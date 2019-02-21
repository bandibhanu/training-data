<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="getStatements">

<table>
		<tr>
			<th>transaction_id </th>
			<th>account_number </th>
			<th>amount </th>
			<th>current_balance </th>
			<th>transaction_date </th>
			<th>transaction_details </th>
			<th>transaction_type</th>
		</tr>
		<tr>
		
		<jstl:forEach var="transactions" items="${currentDataSet.transactions}">
				<tr>
					<td>${transactions.transactionId}</td>
					<td>${transactions.accountNumber}</td>
					<td>${transactions.amount}</td>
					<td>${transactions.transactionType}</td>
					<td>${transactions.currentBalance}</td>
					<td>${transactions.transactionDate}</td>
				</tr>
			</jstl:forEach>
		
		
		
		</tr>
		</table>
		<div>
				<a href="${currentDataSet.previousLink.href}">Previous</a>
		<a href="${currentDataSet.nextLink.href}">Next</a>
		
		</div>
</form>
</body>
</html>