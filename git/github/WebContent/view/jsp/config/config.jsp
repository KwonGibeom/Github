<%@ page isELIgnored="false" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.text.*" %>
<%@ page import="common.*" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/view/js/jquery/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="style/css/common.css">
<%
String url = "http://"+request.getServerName()+":"+request.getServerPort();
%>