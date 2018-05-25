<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Students</title>
<link type="text/css" rel="stylesheet" href="css/style-whole.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
	<div id="wrapper">
		<header>Xpanxion University</header>
	</div>
	<div id="container">
		<h3>Update Student</h3>
		<form enctype="multipart/form-data" action="StudentControllerServlet" method="post">
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="studentId" value="${the_student.id}" />
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><input type="text" name="firstName" value = "${the_student.firstName}" />
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><input type="text" name="lastName" value = "${the_student.lastName}"/>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><input type="text" name="email" value = "${the_student.email}"/>
					</tr>
					<tr>
						<td><label>Photo</label></td>
						<td><input type="file" name="photo" size ="50"/>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" />
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<p>
		<a href="StudentControllerServlet" />back to list
	</p>
</body>
</html>