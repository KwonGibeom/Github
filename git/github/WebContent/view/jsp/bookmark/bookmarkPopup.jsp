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
<form id="bookmark" method="post" action="bookmark.do?action=bookmarkUpdate" >
등록할 url: <input type="text" name="url" id="url" value="${requestScope.url }" style="width: 250px" />
<br><br>
등록할 menu: <select name="menu" id="menu">
	<c:forEach begin="1" end="10" varStatus="op">
		<option value="${op.count }">menu${op.count }</option>
	</c:forEach>
	
</select>
</form>
<br><br><br>
<input type="button" value="등록" name="submit" onclick="submit()" />
<input type="button" value="취소" name="cancel" onclick="cancel()" />
<%-- <c:choose>
	<c:when test="${!empty requestScope.list }">
		<c:forEach var="list" items="${requestScope.list }">
			북마크1: ${list.bookmark1 }<br>
			북마크2: ${list.bookmark2 }<br>
			<input type="text" id="menuurl" />
		</c:forEach>
	</c:when>
</c:choose> --%>

</body>
<script type="text/javascript">

function submit(){
	$("#bookmark").submit();
	window.close();
	opener.location.reload();
}

function cancel(){
	window.close();
}

</script>
</html>