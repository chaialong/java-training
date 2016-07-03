<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan</title>
</head>
<body>
<table border="1">
<c:forEach items="${loanList}" var="loan">
<tr>
	<td>${loan.id}</td>
	<td>${loan.bankName }</td>
</tr>
</c:forEach>
</table>
<a href="listLoan.do?page=${param.page+1}">next</a>
<a href="listLoan.do?page=${param.page-1}">previous</a>
</body>
</html>