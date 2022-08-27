<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher List</title>
</head>
<body>

<a href="LogOut">Logout</a>
&nbsp;&nbsp;
<a href="mainmenu.jsp">Back To Home</a>
<h2>Teacher List</h2>
<table border="1">

					<tr>
                        <th>Teacher ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>			

					</tr>

					<c:forEach var="tempTeacher" items="${TEACHERS_LIST }">
						<tr>
                            <td>${tempTeacher.id}</td>
							<td>${tempTeacher.fname}</td>
							<td>${tempTeacher.lname}</td>
							<td>${tempTeacher.age}</td>
							

						</tr>


					</c:forEach>

				</table>
</body>
</html>