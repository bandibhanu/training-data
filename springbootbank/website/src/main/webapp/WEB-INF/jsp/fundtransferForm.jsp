<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<form action="fundtransferpage">
Enter Sender Account Number: <input name="sendersaccountNumber"/><br/><br/>
Enter receiver Account Number: <input name="receiversaccountNumber"/><br/><br/>
enter Amount:<input name="amount"/><br/><br/>
<input type="submit" value="submit" name="submit">
</form>
</body>
</html>