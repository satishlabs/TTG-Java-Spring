<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	Date :${requestScope.model.now}
	<br /> Book List :
	<br />
	<c:forEach items="${requestScope.model.bookList}" var="book">
		<c:out value="${book}" />
		<br />
	</c:forEach>
</body>
</html>