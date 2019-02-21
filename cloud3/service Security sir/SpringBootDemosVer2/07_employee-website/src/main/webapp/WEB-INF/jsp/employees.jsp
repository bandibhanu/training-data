<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<jstl:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.id }</td>
				<td>${employee.firstName }</td>
				<td>${employee.lastName }</td>
			</tr>
		</jstl:forEach>
	</table>
	<div>
		<a href="${previous}">Previous</a>
		<a href="${next}">Next</a>		
	</div>
	
</body>
</html>