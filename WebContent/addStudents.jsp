<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Students</title>
<link type="text/css" rel="stylesheet" href="css/style-whole.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
	<div id="wrapper">
		<header>Xpanxion University</header>
	</div>
	<div id="container">
		<h3>Add Student</h3>
		<form action="StudentControllerServlet" method="get">
			<input type="hidden" name="command" value="ADD" />
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><input type="text" name="firstName" />
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><input type="text" name="lastName" />
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><input type="text" name="email" />
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