<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!Doctype html>
<html>
  <head>
    
    <title>My JSP 'testLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT"><META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body oncontextmenu='return false' ondragstart='return false'>
  当前用户：${sessionScope.loginUser }<br />
    测试登陆，<a href="${path }/user/login">点击进行登陆</a><br />
    注销登陆，<a href="${path }/user/logout">点击注销登录</a><br />
   
  </body>
</html>
