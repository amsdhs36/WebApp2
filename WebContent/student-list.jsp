<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 
<title>Student List</title>
</head>
<body>

<a href="LogOut">Logout</a>
&nbsp;&nbsp;
<a href="mainmenu.jsp">Back To Home</a>

<h2>Student List</h2>
<table border="1">
					<tr>
					    <th>ID<th>
					    <th>Fist Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Class</th>
					</tr>

					<c:forEach var="tempStudent" items="${STUDENTS_LIST}">
						<tr>
                            <td>${tempStudent.id}</td>
							<td>${tempStudent.fname}</td>
							<td>${tempStudent.lname}</td>
							<td>${tempStudent.age}</td>
							<td>${tempStudent.aclass}</td>

						</tr>


					</c:forEach>

				</table>
				
</body>
</html>