package com.luv2code.servletDemo.mvctwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

	  public static List<Student> getStudents(){
		  //create empty list
		  List<Student> students = new ArrayList<Student>();
		 
		  //add sample data
		  students.add(new Student("Aditya", "Kadam", "AAK@gmail.com"));
		  students.add(new Student("Apurva", "Kadam", "ApuK@gmail.com"));
		  students.add(new Student("Aniruddha", "Kadam", "Ani@gmail.com"));
		  //return the list
		  return students;
	  }
	
}
