package com.luv2code.web.jdbc;

public class JtlData {
	private long timeStamp;
private int elapsed;
public JtlData(long timeStamp, int elapsed, String label, String responseCode, String responseMessage, String threadName, String dataType,
		String success, String failureMessage, int bytes, int sentBytes, int grpThreads, int allThreads, int latency,
		int idleTime, int connect_time) {
	super();
	this.timeStamp = timeStamp;
	this.elapsed = elapsed;
	this.label = label;
	this.responseCode = responseCode;
	this.responseMessage = responseMessage;
	this.threadName = threadName;
	this.dataType = dataType;
	this.success = success;
	this.failureMessage = failureMessage;
	this.bytes = bytes;
	this.sentBytes = sentBytes;
	this.grpThreads = grpThreads;
	this.allThreads = allThreads;
	this.latency = latency;
	this.idleTime = idleTime;
	this.connect_time = connect_time;
}
private String label;
public int getElapsed() {
	return elapsed;
}
public void setElapsed(int elapsed) {
	this.elapsed = elapsed;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public String getResponseCode() {
	return responseCode;
}
public void setResponseCode(String responseCode) {
	this.responseCode = responseCode;
}
public String getResponseMessage() {
	return responseMessage;
}
public void setResponseMessage(String responseMessage) {
	this.responseMessage = responseMessage;
}
public String getThreadName() {
	return threadName;
}
public void setThreadName(String threadName) {
	this.threadName = threadName;
}
public String getDataType() {
	return dataType;
}
public void setDataType(String dataType) {
	this.dataType = dataType;
}
public String getSuccess() {
	return success;
}
public void setSuccess(String success) {
	this.success = success;
}
public String getFailureMessage() {
	return failureMessage;
}
public void setFailureMessage(String failureMessage) {
	this.failureMessage = failureMessage;
}
public int getBytes() {
	return bytes;
}
public void setBytes(int bytes) {
	this.bytes = bytes;
}
public int getSentBytes() {
	return sentBytes;
}
public void setSentBytes(int sentBytes) {
	this.sentBytes = sentBytes;
}
public int getGrpThreads() {
	return grpThreads;
}
public void setGrpThreads(int grpThreads) {
	this.grpThreads = grpThreads;
}
public int getAllThreads() {
	return allThreads;
}
public void setAllThreads(int allThreads) {
	this.allThreads = allThreads;
}
public int getLatency() {
	return latency;
}
public void setLatency(int latency) {
	this.latency = latency;
}
public int getIdleTime() {
	return idleTime;
}
public void setIdleTime(int idleTime) {
	this.idleTime = idleTime;
}
public int getConnect() {
	return connect_time;
}
public long getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(long timeStamp) {
	this.timeStamp = timeStamp;
}
public void setConnect(int connect_time) {
	this.connect_time = connect_time;
}
private String responseCode;
private String responseMessage;
private String threadName;
private String dataType;
private String success;
private String failureMessage;
private int bytes;
private int sentBytes;
private int grpThreads;
private int allThreads;
private int latency;
private int idleTime;
private int connect_time;


}
