<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class List</title>
</head>

<body>
<a href="LogOut">Logout</a>
&nbsp;&nbsp;
<a href="mainmenu.jsp">Back To Home</a>

<h2>Class List</h2>
<table border="1">

					<tr>
                        <th>Class ID
						<th>Section</th>
						<th>Subject</th>
						<th>Teacher</th>
						<th>Time</th>
						<th>List of Students</th>
					</tr>

					<c:forEach var="tempClass" items="${CLASSES_LIST }">
						<tr>

							<c:url var="tempLink" value="/ST_LIST">
							
								<c:param name="id" value="${tempClass.id }" />
								<c:param name="section" value="${tempClass.section}"/>
								<c:param name="subject" value="${tempCLass.subject}"/>
							</c:url>
                            <td>${tempClass.id}</td>
							<td>${tempClass.section}</td>
							<td>${tempClass.subject}</td>
							<td>${tempClass.teacher}</td>
							<td>${tempClass.time}</td>
							<td><a href="${tempLink}">List</a></td>
 						</tr>


					</c:forEach>

				</table>
</body>
</html>