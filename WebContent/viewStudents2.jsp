<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Student Table demo</h2>

<br>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>

		<c:forEach var="tempStudents" items="${student_list}">
		<tr>
		<td>${tempStudents.firstName}</td>
		<td>${tempStudents.lastName}</td>
		<td>${tempStudents.email}</td>
		</tr>
		</c:forEach>
	</table>
</body>

</html>