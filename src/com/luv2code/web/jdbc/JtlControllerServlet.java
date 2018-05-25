package com.luv2code.web.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;;

/**
 * Servlet implementation class JtlControllerServlet
 */
@WebServlet("/JtlControllerServlet")
@MultipartConfig(maxFileSize=16*1024*1024)// upload size defined
public class JtlControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private JtlDbUtil jtlDbUtil;
//	@Resource(name="jdbc/web_student_tracker") //schema name
//	@Resource(name="jdbc/adikad.JTL_DATA")
//	private DataSource jtlDataSource;
	private OracleDataSource ods;

	@Override
	public void init() throws ServletException {
		// 
		super.init();

		// create student db util  and passs it to connection pool / dataSource
		try{
//			jtlDbUtil = new JtlDbUtil(jtlDataSource);
			ods = new OracleDataSource();
			jtlDbUtil = new JtlDbUtil(ods);
		}catch(Exception e){
			throw new ServletException("waat lag gayi mamu !!!");
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();


		try {
			String theCommand_1 = request.getParameter("command_1");
			System.out.println(theCommand_1);
			if(theCommand_1 == null){
				theCommand_1 = "Test1";
			}
			switch (theCommand_1){

			case "Test":
				uploadJtlData(request,response);
				break;
			default:

				defaultPage(request,response);
				break;
			}

		}catch(Exception e){
			throw new ServletException(e);
		}

	}

	private void defaultPage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Development is in Progress !!!");

	}

	private void uploadJtlData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		long timeStamp;
		int elapsed;
		String responseCode;
		String responseMessage;
		String threadName;
		String dataType;
		String success;
		String failureMessage;
		int bytes;
		int sentBytes;
		int grpThreads;
		int allThreads;
		int latency;
		int idleTime;
		int connect_time;
		String label;
		InputStream file =null;
		Part filePart = request.getPart("csv_result");
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());

			// obtains input stream of the upload file
			file = filePart.getInputStream();
		}else {
			System.out.println("File not loaded !");
		}
		BufferedReader buffer = new BufferedReader(new InputStreamReader(file));
		String line=null;
		String[] lineData=null;

		System.out.println("Uploaded data is :");
		//		while((line=buffer.readLine()) != null){



		/*JtlData(int timeStamp, int elapsed, String label, int responseCode, String responseMessage, String threadName, String dataType,
			String success, String failureMessage, int bytes, int sentBytes, int grpThreads, int allThreads, int latency,
			int idleTime, int connect)*/



		//		System.out.println("Line length : "+ lineData.length);
		//		System.out.println();
		line=buffer.readLine();
		line=buffer.readLine();
		String temp; 
		 ods.setDriverType("thin");
		    ods.setServerName("localhost");
		    ods.setPortNumber(1531);
		    ods.setDatabaseName("xe"); // sid
		    ods.setUser("adikad");
		    ods.setPassword("pwd123");
		    Connection jtlConn = ods.getConnection();
		while (line!=null) {

			lineData = line.split(",");

			for (int i = 0; i < 1; i++) {
				//			
				if((temp=lineData[i])!=""){
					timeStamp = Long.parseLong(temp);
					System.out.println(timeStamp);}
				else{
					timeStamp = 0;
				}
				System.out.println("timestamp = "+timeStamp);
				temp = null;
				if((temp=lineData[i+1])!="")
				{elapsed = Integer.parseInt(temp);}
				else{
					elapsed = 0;
				}
				if((temp=lineData[i+2])!="")
				{
					label = temp;}
				else{
					label ="";
				}
				if((temp=lineData[i+3])!="")
				{
					responseCode = temp;}
				else{
					responseCode = "0";
				}
				if(lineData.length>16){
					if((temp=lineData[i+4]+lineData[i+5])!=""){
						responseMessage = temp;
						i=1;}
					else
					{
						responseMessage = "";
					}}
				else{
					if((temp=lineData[i+4])!=""){

						responseMessage = temp;
					}
					else
					{
						responseMessage = "";
					}}

				if((temp=lineData[i+5])!=""){
					threadName = temp;
				}else{
					threadName = "";
				}
				if((temp=lineData[i+6])!=""){
					dataType = temp;}
				else{
					dataType = "";
				}
				if((temp=lineData[i+7])!=""){
					success = temp;}
				else{
					success = "";
				}
				if((temp=lineData[i+8])!=""){
					failureMessage = temp;
				}else
				{failureMessage = "";}
				if((temp=lineData[i+9])!=""){
					bytes = Integer.parseInt(temp); }
				else{
					bytes = 0;
				}
				if((temp=lineData[i+10])!=""){
					sentBytes = Integer.parseInt(temp);
				}else{
					sentBytes = 0;
				}
				if((temp=lineData[i+11])!=""){
					grpThreads = Integer.parseInt(temp); }
				else{
					grpThreads = 0;
				}
				if((temp=lineData[i+12])!=""){
					allThreads = Integer.parseInt(temp); }
				else{
					allThreads = 0;
				}
				if((temp=lineData[i+13])!=""){
					latency = Integer.parseInt(temp);}
				else{
					latency = 0;
				}
				if((temp=lineData[i+14])!=""){
					idleTime = Integer.parseInt(temp); }
				else{
					idleTime = 0;
				}
				if((temp=lineData[i+15])!=""){
					connect_time = Integer.parseInt(lineData[i+15]);}
				else{
					connect_time = 0;
				}
				JtlData theJtlData = new JtlData(timeStamp, elapsed, label, responseCode, responseMessage, threadName, dataType, success, failureMessage, bytes, sentBytes, grpThreads, allThreads, latency, idleTime, connect_time);
				jtlDbUtil.uploadJtlFile(theJtlData, jtlConn);
			}
			lineData=null;
			line=buffer.readLine();
		}
	}

}
