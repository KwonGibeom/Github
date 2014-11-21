<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="head">
		<table>
			<tr>
				<td>head</td>
			</tr>
		</table>
		<table>
			<tr>
				<td><a class="menu1" href="users.do?action=hello">menu1</a></td>
				<td><a class="menu2" href="users.do?action=usersList">menu2</a></td>
				<td><a class="menu3" href="product.do?action=productList">menu3</a></td>
				<td><a class="menu4" href="custom.do?action=customList">menu4</a></td>
				<td><a class="menu5" href="users.do?action=hello5">menu5</a></td>
				
				<td>
					<input type="button" name="retrieve" value="조회" onclick="retrieve1()" />
					<input type="button" name="insert" value="등록" onclick="insert1()" />
					<input type="button" name="delete" value="삭제" onclick="del1()" />
					<input type="button" name="save" value="저장" onclick="save1()" />
					<input type="button" name="print" value="출력" onclick="print1()" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>