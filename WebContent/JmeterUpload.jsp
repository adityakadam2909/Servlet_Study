<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jmeter Result</title>
<link type="text/css" rel="stylesheet" href="css/style-whole.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
	<div id="wrapper"></div>
	<div id="container">
		<h2>Upload Jmeter Raw File</h2>
		<form enctype="multipart/form-data" action="JtlControllerServlet"
			method="post">
			<input type="hidden" name="command_1" value="Test" id="command_1" />
			<table>
				<tbody>
					<tr>
						<td><label>CSV File</label></td>
						<td><input type="file" name="csv_result" size="50" />
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" />
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>