<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject List</title>
</head>
<body>
<a href="LogOut">Logout</a>
&nbsp;&nbsp;
<a href="mainmenu.jsp">Back To Home</a>
<h2>Subject List</h2>
<br>
				<table border="1">

					<tr>
                        <th>Subject ID</th>
						<th>Name</th>
						<th>Shortcut</th>
						
					</tr>

					<c:forEach var="tempSubject" items="${SUBJECTS_LIST }">
						<tr>
                            <td>${tempSubject.id}</td>
							<td>${tempSubject.name}</td>
							<td>${tempSubject.shortcut}</td>
							</tr>
					</c:forEach>

				</table>
</body>
</html>