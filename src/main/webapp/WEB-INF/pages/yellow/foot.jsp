<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div style="display:none;">
<c:forEach begin="1" end="6" var="count">
<img src="${stc }images/gntl/F${count}.jpg" />
</c:forEach>
<c:forEach begin="1" end="11" var="count">
<img src="${stc }images/ljtl/${count}.jpg" />
</c:forEach>
</div>