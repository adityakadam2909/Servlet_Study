package com.luv2code.web.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
@MultipartConfig(maxFileSize=16*1024*1024)// upload size defined
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int sortOrder;
	static int defaultOrder=1;
	private StudentDbUtil studentDbUtil;
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;


	@Override
	public void init() throws ServletException {
		// 
		super.init();

		// create student db util  and passs it to connection pool / dataSource
		try{
			studentDbUtil = new StudentDbUtil(dataSource);
		}catch(Exception e){
			throw new ServletException("waat lag gayi mamu !!!");
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");

			if(theCommand == null){
				theCommand = "LIST";
			}
			switch (theCommand){
			case "LIST":

				listStudents(request,response, defaultOrder);
				break;
			case "SORTBYFIRSTNAME":
				sortOrder = 2;
				listStudents(request,response, sortOrder);
				break;
			case "SORTBYLASTNAME":
				sortOrder = 3;
				listStudents(request,response, sortOrder);
				break;
			case "SORTBYEMAIL":
				sortOrder = 4;
				listStudents(request,response, sortOrder);
				break;
			case "ADD":
				addStudents(request,response);
				break;
			case "UPDATE":
				updateStudents(request,response);
				break;
			case "LOAD":
				loadStudents(request,response);
				break;
			case "DELETE":
				deleteStudents(request,response);
				break;				
			case "DOWNLOAD":
				downloadStudents(request,response);
				break;

			default:

				listStudents(request,response,defaultOrder);
				break;
			}




		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void downloadStudents(HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
		
		int id = Integer.parseInt(request.getParameter("studentId"));

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		InputStream inputStream = null;
		Part filePart;

		Student theStudent = new Student(id, firstName, lastName, email, inputStream);
		studentDbUtil.downloadFileStudent(theStudent);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");

			if(theCommand == null){
				theCommand = "LIST";
			}
			switch (theCommand){

			case "UPDATE":
				updateStudents(request,response);
				break;
			default:

				listStudents(request,response,defaultOrder);
				break;
			}




		} catch (Exception e) {
			throw new ServletException(e);
		}
	}



	private void deleteStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("studentId"));
		Student theStudent = new Student(id, null, null, null);
		studentDbUtil.deleteStudent(theStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/deletePage.jsp");
		dispatcher.forward(request, response);


	}


	private void updateStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("studentId"));

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");

		if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }else {
        	System.out.println("File not loaded !");
        }
		Student theStudent = new Student(id, firstName, lastName, email, inputStream);
		studentDbUtil.updateStudent(theStudent);
		listStudents(request, response,defaultOrder);



	}


	private void loadStudents(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// read student id from jsp

		String theStudentId = request.getParameter("studentId");
		Student theStudent = studentDbUtil.getStudents(theStudentId);
		request.setAttribute("the_student", theStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);

	}

	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		Student theStudent = new Student(firstName, lastName, email);

		studentDbUtil.addStudent(theStudent);

		listStudents(request,response,defaultOrder);
	}


	private void listStudents(HttpServletRequest request, HttpServletResponse response, int thesortOrder) throws Exception {
		//get students  from db util
		List<Student> students = studentDbUtil.getStudents(thesortOrder);
		//add students to the request
		
		request.setAttribute("student_list", students);
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

}
