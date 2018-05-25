package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
public class JtlDbUtil {
	private OracleDataSource ods;
//	private static final int BUFFER_SIZE = 4096;
	
	public JtlDbUtil(OracleDataSource odsrc) {
		
		ods = odsrc;
	}
	public void uploadJtlFile(JtlData theJtlData, Connection jtlConn) throws SQLException{
		System.out.println("Development is in progress !!!");
	//	Connection jtlConn = null;
		PreparedStatement jtlStmt = null;
		
		try{
	    
/*		    ods.setDriverType("thin");
		    ods.setServerName("localhost");
		    ods.setPortNumber(1531);
		    ods.setDatabaseName("xe"); // sid
		    ods.setUser("adikad");
		    ods.setPassword("pwd123");


		  //   jtlConn = ods.getConnection();
		    */
		    
			String sql = "INSERT INTO jtl_data"+
					"(`timeStamp`,"+
							"`elapsed`,"+
							"`label`,"+
							"`responseCode`,"+
							"`responseMessage`,"+
							"`threadName`,"+
							"`dataType`,"+
							"`success`,"+
							"`failureMessage`,"+
							"`bytes`,"+
							"`sentBytes`,"+
							"`grpThreads`,"+
							"`allThreads`,"+
							"`latency`,"+
							"`idleTime`,"+
							"`connect_time`)"+
							"VALUES"+
							"(?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?,"+
							"?)";
			 sql = "insert INTO JTL_DATA (TIMESTAMP, elapsed,label, responsecode, responseMessage,threadName,dataType,success,failureMessage,bytes,sentBytes,grpThreads,allThreads,latency,idleTime,connect_time)"
					+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			jtlStmt = jtlConn.prepareStatement(sql);
		jtlStmt.setLong(1, theJtlData.getTimeStamp());
		System.out.println("TIMESTAMP : " + theJtlData.getTimeStamp());
		jtlStmt.setInt(2, theJtlData.getElapsed());
		jtlStmt.setString(3, theJtlData.getLabel());
		jtlStmt.setString(4, theJtlData.getResponseCode());
		jtlStmt.setString(5, theJtlData.getResponseMessage());
		jtlStmt.setString(6, theJtlData.getThreadName());
		jtlStmt.setString(7, theJtlData.getDataType());
		jtlStmt.setString(8, theJtlData.getSuccess());
		jtlStmt.setString(9, theJtlData.getFailureMessage());
		jtlStmt.setInt(10, theJtlData.getBytes());
		jtlStmt.setInt(11, theJtlData.getSentBytes());
		jtlStmt.setInt(12, theJtlData.getGrpThreads());
		jtlStmt.setInt(13, theJtlData.getAllThreads());
		jtlStmt.setInt(14, theJtlData.getLatency());
		jtlStmt.setInt(15, theJtlData.getIdleTime());
		jtlStmt.setInt(16, theJtlData.getConnect());
		jtlStmt.execute();
		}
		finally{
//			close(jtlConn,jtlStmt,null);
		}
	}
	
	private void close(Connection jtlConn, Statement jtlStmt, ResultSet jtlRs) {

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
