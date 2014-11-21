<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../config/config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/css/custom/custom.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/css/common.css">
</head>
<body>
	<div class="innerList">
		<table class="bbsListType">
			<colgroup>
				<col width="15%" />
				<col width="25%" />
				<col width="25%" />
				<col width="15%" />
				<col width="20%" />
			</colgroup>
		
			<tr>
				<th>No.</th>
				<th>사업자번호</th>
				<th>회사명</th>
				<th>대표자</th>
				<th>등록일자</th>				
			</tr>
			<c:choose>
				<c:when test="${!empty requestScope.customList }">
					<c:set var="localCount" value="${top }"/>
					<c:forEach items="${requestScope.customList }" var="list">
						<tr class="listover" onclick="customView(${list.custNo})">
							<td>
								${localCount }
								<c:set var="localCount" value="${localCount-1 }"/>
							</td>
							<td>${list.custNum }</td>
							<td>${list.custName }</td>
							<td>${list.ownerName }</td>
							<td>${list.addDate }</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
	</div>
</body>
</html>