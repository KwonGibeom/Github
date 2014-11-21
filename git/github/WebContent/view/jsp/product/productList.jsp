<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../config/config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/css/product/product.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/css/common.css">
</head>
<body>
	<div class="innerList">
		<table class="bbsListType sortable">
			<colgroup>
				<col width="15%" />
				<col width="25%" />
				<col width="25%" />
				<col width="35%" />
			</colgroup>
			<thead>
			<tr>
				<th class="sorting">No.</th>
				<th class="sorting">제품명</th>
				<th class="sorting">회사</th>
				<th class="sorting">가격</th>				
			</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${!empty requestScope.productList }">
					<c:set var="localCount" value="${top }"/>
					<c:forEach items="${requestScope.productList }" var="list">
						<tr class="listover" onclick="productView(${list.id})">
							<td>
								${localCount }
								<c:set var="localCount" value="${localCount-1 }"/>
							</td>
							<td>${list.name }</td>
							<td>${list.company }</td>
							<td>${list.price }</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>