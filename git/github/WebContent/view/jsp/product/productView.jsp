<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../config/config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/css/product/product.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="productView" class="disNone">
		<form name="productViewForm" method="post" action="product.do?action=productUpdate">
			<table class="bbsListType">
				<colgroup>
					<col width="35%" />
					<col width="65%" />
				</colgroup>
				<tr>
					<th>제품명</th>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<th>회사명</th>
					<td><input type="text" name="company" id="company" /><br></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price" id="price" /></td>
				</tr>
			</table>
			<input type="hidden" name="articleId" id="articleId" />
		</form> 
	</div>
</body>
<script src="view/js/product/product.js"></script>
</html>