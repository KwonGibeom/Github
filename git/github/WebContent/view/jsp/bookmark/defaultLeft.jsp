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
	<c:choose>
		<c:when test="${!empty bookmark }">
			<c:choose>
				<c:when test="${!empty bookmark.bookmark1 }">
					<a href="${bookmark.bookmark1 }">menu1</a>
					<br>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!empty bookmark.bookmark2 }">
					<a href="${bookmark.bookmark2 }">menu2</a>
					<br>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!empty bookmark.bookmark3 }">
					<a href="${bookmark.bookmark3 }">menu3</a>
					<br>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!empty bookmark.bookmark4 }">
					<a href="${bookmark.bookmark4 }">menu4</a>
					<br>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!empty bookmark.bookmark5 }">
					<a href="${bookmark.bookmark5 }">menu5</a>
					<br>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!empty bookmark.bookmark6 }">
					<a href="${bookmark.bookmark6 }">menu6</a>
					<br>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!empty bookmark.bookmark7 }">
					<a href="${bookmark.bookmark7 }">menu7</a>
					<br>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!empty bookmark.bookmark8 }">
					<a href="${bookmark.bookmark8 }">menu8</a>
					<br>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!empty bookmark.bookmark9 }">
					<a href="${bookmark.bookmark9 }">menu9</a>
					<br>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!empty bookmark.bookmark10 }">
					<a href="${bookmark.bookmark10 }">menu10</a>
					<br>
				</c:when>
			</c:choose>
		</c:when>
	</c:choose>
	
	<br><br>
			<input type="button" id="insert" value="insert" onclick="insert()" />
			<form name="bookmark" id="bookmark" target="pop" action="bookmark.do?action=bookmark" method="post" ></form>
</body>
<script type="text/javascript">
function insert(){
	
	var f = document.bookmark;

	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "url");

	input.setAttribute("value", window.location.pathname+window.location.search);

	f.appendChild(input); 

	var winopts = "width=500,height=300,toolbar=no,location=no,directories=no, status=yes,menubar=no, status=yes,menubar=no,resizable=yes"; 
    var popWindow = window.open('', 'pop', winopts); 

    f.submit();  
}

</script>
</html>