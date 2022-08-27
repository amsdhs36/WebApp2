<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Student List</title>
</head>
<body>

<a href="mainmenu.jsp">Back To Home Page</a>
<h3>
Students of ${SUBJECT} section ${SECTION} </h3>
	<table border="1">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>age</th>
					</tr>
					<c:forEach var="tempStudent" items="${STUD_LIST}">
						<tr>
							<td>${tempStudent.fname}</td>
							<td>${tempStudent.lname}</td>
							<td>${tempStudent.age}</td>
						</tr>
					</c:forEach>

				</table>
</body>
</html>