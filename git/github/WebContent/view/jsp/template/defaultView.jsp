<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="../config/config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge.chrome=1" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style/css/layout-default-latest.css" />
<link type="text/css" rel="stylesheet" href="style/css/layout-defaultView.css" />

<script type="text/javascript" src="${pageContext.request.contextPath }/view/js/jquery/jquery-latest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/view/js/jquery/jquery-ui-latest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/view/js/jquery/jquery.layout-latest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/view/js/browserChk.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/view/js/layout-defaultView.js"></script>
</head>
<body>
	<div class="outer-center">
		<div class="middle-center">
			<div class="inner-center"><%@include file="content.jsp" %></div>
			<div class="inner-west"><%@include file="left.jsp" %></div>
			<div class="ui-layout-north"><%@include file="search.jsp" %></div>
		</div>
	</div>
	<div class="outer-west">
		<%@include file="outerLeft.jsp" %>
		<input type="button" value="toggle" onclick="innerLayout.toggle('north')" />
		<input type="button" value="hide" onclick="innerLayout.hide('north')" />
	</div>
	<div class="outer-east"><%@include file="right.jsp" %></div>
	<div class="ui-layout-north"><%@include file="head.jsp" %></div>
	<div class="ui-layout-south"><%@include file="footer.jsp" %></div>
</body>
</html>