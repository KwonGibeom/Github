<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../config/config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	$(document).ready(function(){
		var ddNum = "."+$(".ddNum").val();
		$(ddNum).show();
	});
	
</script>
</head>
<body>
<input type="hidden" class="ddNum" value="${ddNum }"/>
	<div class="head">
		<table>
			<tr>
				<td>OuterLeft</td>
			</tr>
		</table>
		<dl>
			<dt><a class="menu1" href="users.do?action=hello">menu1</a></dt>
			<dd class="dd1">menu1-1</dd>
			<dd class="dd1">menu1-2</dd>
			<dd class="dd1">menu1-3</dd>
			<dd class="dd1">menu1-4</dd>
		</dl>
		<dl>
			<dt><a class="menu2" href="users.do?action=usersList">menu2</a></dt>
			<dd class="dd2">menu2-1</dd>
			<dd class="dd2">menu2-2</dd>
			<dd class="dd2">menu2-3</dd>
			<dd class="dd2">menu2-4</dd>
		</dl>
		<dl>
			<dt><a class="menu3" href="product.do?action=productList">menu3</a></dt>
			<dd class="dd3">menu3-1</dd>
			<dd class="dd3">menu3-2</dd>
			<dd class="dd3">menu3-3</dd>
			<dd class="dd3">menu3-4</dd>
		</dl>
		<dl>
			<dt><a class="menu4" href="custom.do?action=customList">menu4</a></dt>
			<dd class="dd4">menu4-1</dd>
			<dd class="dd4">menu4-2</dd>
			<dd class="dd4">menu4-3</dd>
			<dd class="dd4">menu4-4</dd>
		</dl>
		<!-- <table>
			<tr>
				<td><a href="users.do?action=hello">menu1</a></td>
			</tr>
			<tr>
				<td><a href="users.do?action=usersList">menu2</a></td>
			</tr>
			<tr>
				<td><a href="product.do?action=productList">menu3</a></td>
			</tr>
			<tr>
				<td><a href="custom.do?action=customList">menu4</a></td>
			</tr>
			<tr>
				<td><a href="users.do?action=hello5">menu5</a></td>
			</tr>
		</table> -->
	</div>
</body>
</html>