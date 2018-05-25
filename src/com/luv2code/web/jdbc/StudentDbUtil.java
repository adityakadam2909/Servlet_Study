package com.luv2code.web.jdbc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement.ParseInfo;

public class StudentDbUtil {
	private DataSource dataSource;
	private static final int BUFFER_SIZE = 4096;

	public StudentDbUtil(DataSource thedataSource) {

		dataSource = thedataSource;
	}

	public List<Student> getStudents(int theSortOrder)throws SQLException{
		List<Student> students = new ArrayList();
		Connection myConn = null,myConn2 = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String sql=null;
		int sort=theSortOrder;
		try{
			// get a connection
			//			myConn = dataSource.getConnection();

			// create sql statement

			switch (sort) {
			case 1:
				myConn = dataSource.getConnection();
				sql ="";
				sql = "select * from student order by id";				
				myStmt = myConn.prepareStatement(sql);
				System.out.println("sort=1 :this method is called !");
				break;
			case 2:
				myConn = dataSource.getConnection();
				sql="";
				sql = "select * from student order by first_name";
				myStmt = myConn.prepareStatement(sql);
				System.out.println("sort=2 :this method is called !");
				break;
			case 3:
				myConn = dataSource.getConnection();
				sql="";
				sql = "select * from student order by last_name";
				myStmt = myConn.prepareStatement(sql);
				System.out.println("sort=3 :this method is called !");
				break;
			case 4:
				myConn = dataSource.getConnection();
				sql="";
				sql = "select * from student order by email";
				myStmt = myConn.prepareStatement(sql);
				System.out.println("sort=4 :this method is called !");
				break;
			default:
				myConn = dataSource.getConnection();
				sql ="";
				sql = "select * from student order by id";				
				myStmt = myConn.prepareStatement(sql);
				System.out.println("sort=1 :this method is called !");

				break;
			}
			// execute query
			myRs =	myStmt.executeQuery();

			// process result
			while(myRs.next()){
				//retreive result set
				// add it to the list of students
				int id = myRs.getInt("id");
				System.out.println("id= "+id);
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				Student tempStudent = new Student(id, firstName, lastName, email);

				students.add(tempStudent);
			}

			return students;
		}
		finally{
			// close JDBC object
			close(myConn, myStmt, myRs);

		}



	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try{
			if(myRs!=null){
				myRs.close();
			}
			if(myStmt!=null){
				myStmt.close();
			}
			if(myConn!=null){
				myConn.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @param theStudent
	 * @throws SQLException
	 */
	public void addStudent(Student theStudent) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try{
			//db connn
			myConn = dataSource.getConnection();

			// create sql statememt
			String sql = "insert into student " 
					+"(first_name, last_name, email,time_stamp)" 
					+"values(?,?,?,now())";
			//map connection to statement obj 
			myStmt = myConn.prepareStatement(sql);
			// set param values to the statement
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());			
			// execute the query
			myStmt.execute();
		}finally{
			// close JDBC object
			close(myConn, myStmt, null);

		}


	}

	public Student getStudents(String theStudentId) throws Exception {
		Student thestudent = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		try{
			//			convert student id to int
			studentId = Integer.parseInt(theStudentId);
			//			get connection to database
			myConn = dataSource.getConnection();
			//			create sql statement
			String sql = "select * from student where id = ? order by id";

			//			create prepared statement
			myStmt = myConn.prepareStatement(sql);

			//			set param
			myStmt.setInt(1, studentId);
			//			execute the statement
			myRs = myStmt.executeQuery();
			//			retreive data from db
			if (myRs.next()){
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				thestudent = new Student(studentId, firstName, lastName, email);				  
			}
		}finally{
			//close connection
			close(myConn, myStmt, myRs);
		}
		return thestudent;
	}

	public void updateStudent(Student theStudent) throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;

		try{
			myConn = dataSource.getConnection();

			String sql = "update student set first_name=?,last_name=?, email=?, photo=?, time_stamp=now() where id=?";//

			myStmt = myConn.prepareStatement(sql);


			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());

			if (theStudent.getInputStream() != null) {
				// fetches input stream of the upload file for the blob column
				myStmt.setBinaryStream(4, theStudent.getInputStream());
			}
			else{
				myStmt.setNull(4, java.sql.Types.BLOB);
			}
			myStmt.setInt(5, theStudent.getId());
			myStmt.executeUpdate();

		}finally{
			close(myConn, myStmt, myRs);
		}


	}

	public void deleteStudent(Student theStudent) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;

		try{
			myConn = dataSource.getConnection();

			String sql = "delete from student where id=?";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, theStudent.getId());

			myStmt.execute();

		}finally{
			close(myConn, myStmt, myRs);
		}

	}

	public void downloadFileStudent(Student theStudent) throws SQLException, IOException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;

		try{
			myConn = dataSource.getConnection();

			String sql = "select photo from student where id=?";

			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, theStudent.getId());	

			myRs = myStmt.executeQuery();

			if (myRs.next()){
				Blob blob = myRs.getBlob("photo");
				InputStream inputStream = blob.getBinaryStream();
				OutputStream outStream = new FileOutputStream("D://Dump//photo//Save.jpg");
				int byteRead = -1;
				byte[] buffer = new byte[BUFFER_SIZE];
				while((byteRead = inputStream.read(buffer))!= -1){
					outStream.write(buffer, 0, byteRead);					
				}
				inputStream.close();
				outStream.close();
				System.out.println("File saved !!!");

			}

		}finally{
			close(myConn, myStmt, myRs);
		}


	}





}


