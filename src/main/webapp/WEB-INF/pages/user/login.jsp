<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!Doctype html>
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
   登陆测试：${errorMessage }
   <form:form action="login?ref=${ref }" method="post" commandName="user">
   <c:if test="${empty user.id }">
   		用户名：<form:input path="username" /><br/>
   		密　码：<form:input path="password" /><br/>
   		验证码：<input type="text" name="checkcode" maxlength="4" style="width:80px;"/><img src="${path }/checkcode.jsp" alt="验证码" onclick="this.src=this.src" width="100" height="30"/><br/>
   		<input type="submit" value="登　陆"/>&nbsp;<input type="button" onclick="history.go(-1);" value="返　回"/>&nbsp;
   </c:if>
   <c:if test="${not empty user.id }">
   		你已登陆：${user.username }<br/>
   		<form:hidden path="username" />
   		<form:hidden path="password" />
		<input type="submit" value="进入账号"/>&nbsp;<input type="button" onclick="history.go(-1);" value="返　回"/>&nbsp;
   </c:if>
   		
   </form:form>
  </body>
</html>
