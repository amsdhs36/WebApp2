<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner Academy Portal</title>
</head>
<a href="LogOut">Logout</a> 
<body style="background-color:yellow;">
<h1>Hi <%=session.getAttribute("username")%></h1>
<h1>Welcome to Home Page</h1>


<a href="CLASSES">Class List</a>
<a href="SUBJECTS">Subject List</a>		
<a href="TEACHERS">Teacher List</a>
<a href="STUDENTS">Student List</a>

<hr>
				<table>

					<tr>

						<th>Section</th>
						<th>Subject</th>
						<th>Teacher</th>
						<th>Time</th>
						<th>List of Students</th>

					</tr>
					<c:forEach var="tempClass" items="${CLASSES_LIST }">
						<tr>

							<c:url var="tempLink" value="/">
								<c:param name="action" value="ST_LIST" />
								<c:param name="classId" value="${tempClass.id }" />
								<c:param name="section" value="${tempClass.section }" />
								<c:param name="subject" value="${tempClass.subject }" />
							</c:url>

							<td>${tempClass.section}</td>
							<td>${tempClass.subject}</td>
							<td>${tempClass.teacher}</td>
							<td>${tempClass.time}</td>
							<td><a href="${tempLink }">List</a></td>
 
						</tr>


					</c:forEach>

				</table>

</body>
</html>