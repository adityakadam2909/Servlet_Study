<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

<c:forEach var="tempStudents" items="${student_list}">
${tempStudents}<br/>
</c:forEach>

</body>

</html>