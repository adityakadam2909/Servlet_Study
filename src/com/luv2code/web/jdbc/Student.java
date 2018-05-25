package com.luv2code.web.jdbc;

import java.io.InputStream;

public class Student {
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
@Override
public String toString() {
	return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
}
public void setEmail(String email) {
	this.email = email;
}
public Student(String firstName, String lastName, String email) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
}
public Student(int id, String firstName, String lastName, String email) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
}
private String firstName;
public Student(int id, String firstName, String lastName, String email, InputStream inputStream) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.inputStream = inputStream;
}
private String lastName;
public InputStream getInputStream() {
	return inputStream;
}
public void setInputStream(InputStream inputStream) {
	this.inputStream = inputStream;
}
private String email;
private InputStream inputStream;
}
