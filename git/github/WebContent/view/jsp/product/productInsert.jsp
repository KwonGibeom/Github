<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../config/config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="productJoinForm" action="product.do?action=productInsert" method="post" >
	이름 : <input type="text" name="name" id="name" /><br>
	회사명 : <input type="text" name="company" id="company" /><br>
	가격 : <input type="text" name="price" id="price" /><br>
	<br><br>
</form>
</body>
<script src="view/js/product/product.js"></script>
</html>