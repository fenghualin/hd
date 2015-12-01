<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div style="display:none;">
<c:forEach begin="1" end="18" var="count">
<img src="${stc }images/scdb/${count}.jpg" />
</c:forEach>
<img src="${stc }images/ms/1.jpg"/>
<c:forEach begin="1" end="6" var="count">
<img src="${stc }images/kjbl/${count}.jpg" />
</c:forEach>
<img src="${stc }images/blank.gif"/>
</div>