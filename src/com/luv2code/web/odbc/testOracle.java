package com.luv2code.web.odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class testOracle {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1531:XE";
	private static final String DB_USER = "adikad";
	private static final String DB_PASSWORD = "pwd123";
	
	public static void main(String args[]) throws SQLException{
		System.out.println("Development is in progress !!!");
		Connection jtlConn = null;
		PreparedStatement jtlStmt = null;
		ResultSet jtlRs =null;
//		OracleDataSource ods = null;;
		try{
//			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//	        jtlConn = DriverManager.getConnection((String)session.getValue("connStr"),
//	                                           "scott", "tiger");
//			jtlConn = jtlDataSource.getConnection();
//			jtlConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1531:XE","adikad","pwd123");
			
//		    ods.setUser("adikad");
//		    ods.setPassword("pwd123");		    
//		    ods.setNetworkProtocol("ipc");
////		    ods.setDriverType("oci");
//		    ods.setServerName("localhost");
//		    ods.setNetworkProtocol("tcp");
//		    ods.setDatabaseName("adikad_local");
//		    ods.setPortNumber(1531);


//		     jtlConn = getDBConnection();
		    ///////DataSource use///////////
			OracleDataSource ds = new OracleDataSource();
		    ds.setDriverType("thin");
		    ds.setServerName("localhost");
		    ds.setPortNumber(1531);
		    ds.setDatabaseName("xe"); // sid
		    ds.setUser("adikad");
		    ds.setPassword("pwd123");

			jtlConn = ds.getConnection();
			////////////////////////////
		    
//			String sql = "INSERT INTO jtl_data"+
//					"(`timeStamp`,"+
//							"`elapsed`,"+
//							"`label`,"+
//							"`responseCode`,"+
//							"`responseMessage`,"+
//							"`threadName`,"+
//							"`dataType`,"+
//							"`success`,"+
//							"`failureMessage`,"+
//							"`bytes`,"+
//							"`sentBytes`,"+
//							"`grpThreads`,"+
//							"`allThreads`,"+
//							"`latency`,"+
//							"`idleTime`,"+
//							"`connect_time`)"+
//							"VALUES"+
//							"(?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?,"+
//							"?)";
String sql = "insert INTO JTL_DATA (TIMESTAMP, elapsed,label, responsecode, responseMessage,threadName,dataType,success,failureMessage,bytes,sentBytes,grpThreads,allThreads,latency,idleTime,connect_time)"
+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		+"values (?,2307,'Req_175 /spe/qa11/scripttracker/dealpoint/login.html','200','OK','1 - Power Search 1-1','text','TRUE','no msg',693,355,1,4,2307,0,955)";

		jtlStmt = jtlConn.prepareStatement(sql);
		jtlStmt.setLong(1, 123456);
		System.out.println("TIMESTAMP : " + 12345678912345L);
		jtlStmt.setInt(2, 2307);
		jtlStmt.setString(3, "Req_175 /spe/qa11/scripttracker/dealpoint/login.html");
		jtlStmt.setString(4, "200");
		jtlStmt.setString(5, "OK");
		jtlStmt.setString(6, "1 - Power Search 1-1");
		jtlStmt.setString(7, "text");
		
		jtlStmt.setString(8, "TRUE");
		jtlStmt.setString(9, "no msg");
		jtlStmt.setInt(10, 693);
		jtlStmt.setInt(11, 355);
		jtlStmt.setInt(12, 1);
		jtlStmt.setInt(13, 4);
		jtlStmt.setInt(14, 2307);
		jtlStmt.setInt(15, 0);
		jtlStmt.setInt(16, 955);
		jtlStmt.execute();
		}
		finally{
		
	
		try{
			if(jtlRs!=null){
				jtlRs.close();
			}
			if(jtlStmt!=null){
				jtlStmt.close();
			}
			if(jtlConn!=null){
				jtlConn.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	}
	
	private static long getValueTM(){
		return 12345678912345L;
	}
	
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}
