<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="searchForm" method="get" action="custom.do">
	<input type="hidden" name="action" value="customList" />
	<div id="searchCondition" class="disNone" style="position: relative;">
		<!-- <input type="button" name="retrieve" value="조회" onclick="retrieve1()" />
		<input type="button" name="insert" value="등록" onclick="insert1()" />
		<input type="button" name="delete" value="삭제" onclick="del1()" />
		<input type="button" name="save" value="저장" onclick="save1()" />
		<input type="button" name="print" value="출력" onclick="print1()" /> -->
		<input type="button" name="slide" value="slide" onclick="searchSlide()" />
	</div><br>
	<div id="searchBar" class="disNone">
		<table>
			<tr>
				<td>
					<select name="searchColumn">
						<option value="setCustNum">사업자번호</option>
						<c:choose>
							<c:when test="${searchColumn eq 'setCustName' }" >
								<option value="setCustName" selected="selected">회사명</option>
							</c:when>
							<c:otherwise>
								<option value="setCustName">회사명</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${searchColumn eq 'setOwnerName' }" >
								<option value="setOwnerName" selected="selected">대표자</option>
							</c:when>
							<c:otherwise>
								<option value="setOwnerName">대표자</option>
							</c:otherwise>
						</c:choose>
					</select>
				</td>
				<td><input type="text" name="searchKeyword" value="${searchKeyword }" /></td>
				<td><input type="button" name="searchBtn" value="검색" onclick="getSearch()" /></td>
			</tr>
		</table>
	</div>
</form>
</body>
<script src="view/js/searchCondition/searchCondition.js"></script>
</html>