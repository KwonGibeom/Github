<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="config/config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${massage }</h2>
	<br/>
		
	<c:forEach items="${requestScope.usersList }" var="list">
		<div>${list.id } &nbsp;&nbsp;&nbsp; ${list.name }</div>
	</c:forEach>
	
</body>
</html>