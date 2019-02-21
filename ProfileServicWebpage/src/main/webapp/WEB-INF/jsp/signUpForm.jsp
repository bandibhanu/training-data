<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUP</title>
</head>
<body>
	<h1>${message}</h1>
	<h1>enter the choice</h1>
	<form action="signUpMethod">
		Enter Name: <input name="Name" /><br />
		<br /> Enter dateOfBirth:<input name="dateOfBirth" /><br />
		<br /> Enter EmailId:<input name="EmailId" /><br />
		<br /> Enter phoneNumber:<input name="phoneNumber" /><br />
		<br /> Enter gender:<input name="gender" /><br />
		<br /> <input type="submit" name="submit" />
	</form>
</body>
</html>




