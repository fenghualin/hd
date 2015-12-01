<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
#autoadduser select{
	width:150px;
}
</style>
<div id="autoadduser">
	<table>
		<tr>
			<td>用户个数：</td><td><input type="text" id="u_usernumber" /></td>
		</tr>
		<tr>
			<td>初始金额：</td><td><input type="text" id="u_money" /></td>
		</tr>
		<tr>
			<td>题目版本:</td>
			<td>
				<select id="u_banben">
					<option value="0">青少年版</option>
					<option value="1">成人版</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>隶属机构:</td>
			<td>
				<select id="u_jigou">
				<c:forEach items="${listjigou}" var="listjigou">
					<option value="${listjigou.id }">${listjigou.name}</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr><td>选择用户权限：</td><td>
			<select id="userquanxian">
				<c:forEach items="${listgroup}" var="listgroup">
					<option value="${listgroup.id }">${listgroup.name}</option>
				</c:forEach>
			</select>
		</td></tr>
	</table>
</div>