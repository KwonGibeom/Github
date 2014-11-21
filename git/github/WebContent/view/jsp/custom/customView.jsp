<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../config/config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/css/custom/custom.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="customView" class="disNone">
		<form name="customViewForm" method="post" action="custom.do?action=customUpdate">
			<table class="bbsListType">
				<colgroup>
					<col width="35%" />
					<col width="65%" />
				</colgroup>
				<tr>
					<th>사업자번호</th>
					<td><input type="text" name="custNum" id="custNum" /></td>
				</tr>
				<tr>
					<th>회사명</th>
					<td><input type="text" name="custName" id="custName" /><br></td>
				</tr>
				<tr>
					<th>대표자</th>
					<td><input type="text" name="ownerName" id="ownerName" /></td>
				</tr>
				<tr>
					<th>회사대표메일</th>
					<td><input type="text" name="custMail" id="custMail" /></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="custTel" id="custTel" /></td>
				</tr>
				<tr>
					<th>담당자1</th>
					<td><input type="text" name="custEmp1" id="custEmp1" /></td>
				</tr>
				<tr>
					<th>담당자2</th>
					<td><input type="text" name="custEmp2" id="custEmp2" /></td>
				</tr>
				<tr>
					<th>담당자3</th>
					<td><input type="text" name="custEmp3" id="custEmp3" /></td>
				</tr>
				<tr>
					<th>담당전화1</th>
					<td><input type="text" name="empTel1" id="empTel1" /></td>
				</tr>
				<tr>
					<th>담당전화2</th>
					<td><input type="text" name="empTel2" id="empTel2" /></td>
				</tr>
				<tr>
					<th>담당전화3</th>
					<td><input type="text" name="empTel3" id="empTel3" /></td>
				</tr>
				<tr>
					<th>등록일자</th>
					<td><input type="text" name="addDate" id="addDate" /></td>
				</tr>				
			</table>
			<input type="hidden" name="articleId" id="articleId" />
		</form> 
	</div>
</body>
<script src="view/js/custom/custom.js"></script>
</html>