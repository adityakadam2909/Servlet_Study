<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.luv2code.web.jdbc.*"%>
<html>
<head>
<title>Student Tracker App</title>
</head>
<link type="text/css" rel="stylesheet" href="css/style-whole.css">


<body>

	<div id="wrapper">
		<header>Xpanxion University</header>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value="Add Student"
				onclick="window.location.href='addStudents.jsp'; return false;" />
			<table border="2">

				<tr>
					<c:url var="templink_sort_firstName"
						value="StudentControllerServlet">
						<c:param name="command" value="SORTBYFIRSTNAME" />
					</c:url>
										<c:url var="templink_sort_lastName"
						value="StudentControllerServlet">
						<c:param name="command" value="SORTBYLASTNAME" />
					</c:url>
										<c:url var="templink_sort_email"
						value="StudentControllerServlet">
						<c:param name="command" value="SORTBYEMAIL" />
					</c:url>
					<th><a href="${templink_sort_firstName}" var="" />First Name</th>
					<th><a href="${templink_sort_lastName}" var="" />Last Name</th>
					<th><a href="${templink_sort_email}" var="" />Email</th>				
					<th colspan="3">Action</th>
				</tr>
				<c:forEach var="tempStudents" items="${student_list}">
					<c:url var="templink_update" value="StudentControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${tempStudents.id}" />
					</c:url>
					<c:url var="templink_delete" value="StudentControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${tempStudents.id}" />
					</c:url>
					<c:url var="templink_downloadFile" value="StudentControllerServlet">
						<c:param name="command" value="DOWNLOAD" />
						<c:param name="studentId" value="${tempStudents.id}" />
					</c:url>
					<tr>
						<td>${tempStudents.firstName}</td>
						<td>${tempStudents.lastName}</td>
						<td>${tempStudents.email}</td>
						<td><a href="${templink_update}" var="" />UPDATE</td>
						<td><a href="${templink_delete}" var="" />DELETE</td>
						<td><a href="${templink_downloadFile}" var="" />DOWNLOAD FILE</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>