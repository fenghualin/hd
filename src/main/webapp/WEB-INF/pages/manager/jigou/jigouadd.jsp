<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div style="margin:20px 0 0 15px;">
	<c:if test="${chaozuo=='add'}">
		<table>
			<tr>
				<td>机构名字：</td><td><input type="text" id="jigou_name" /></td>
			</tr>
			<tr>
				<td>机构描述：</td><td><input type="text" id="jigou_describe" /></td>
			</tr>
		</table>
	</c:if>
	<c:if test="${chaozuo=='update'}">
		<table>
			<tr>
				<td>机构名字：</td><td><input type="text" id="jigou_name" value="${jigou.name }" /><input type="hidden" id="jigou_id" value="${jigou.id }" /></td>
			</tr>
			<tr>
				<td>机构描述：</td><td><input type="text" id="jigou_describe" value="${jigou.describe }"  /></td>
			</tr>
		</table>
	</c:if>
	<c:if test="${chaozuo=='look'}">
		<table>
			<tr>
				<td>机构名字：</td><td><input type="text" id="jigou_name" disabled="disabled" value="${jigou.name }" /></td>
			</tr>
			<tr>
				<td>机构描述：</td><td><input type="text" id="jigou_describe" disabled="disabled" value="${jigou.describe }"  /></td>
			</tr>
		</table>
	</c:if>
</div>

