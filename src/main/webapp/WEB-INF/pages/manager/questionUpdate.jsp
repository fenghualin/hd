<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div style="margin:20px 0 0 15px;">
		<c:if test="${!empty qkinds}">
			<p style="float:left;">问题类型：</p>
			<select id="questionkinds" style="float:left;">
				<c:if test="${qkinds == 1}">
					<option value="zzglnl" selected="selected">组织管理能力</option>
					<option value="yynlcs">言语能力测试</option>
					<option value="lbtl">类比推理</option>
					<option value="rjjwnl">人际交往能力</option>
				</c:if>
				<c:if test="${qkinds == 2}">
					<option value="zzglnl">组织管理能力</option>
					<option value="yynlcs" selected="selected">言语能力测试</option>
					<option value="lbtl">类比推理</option>
					<option value="rjjwnl">人际交往能力</option>
				</c:if>
				<c:if test="${qkinds == 3}">
					<option value="zzglnl">组织管理能力</option>
					<option value="yynlcs">言语能力测试</option>
					<option value="lbtl" selected="selected">类比推理</option>
					<option value="rjjwnl">人际交往能力</option>
				</c:if>
				<c:if test="${qkinds == 4}">
					<option value="zzglnl">组织管理能力</option>
					<option value="yynlcs">言语能力测试</option>
					<option value="lbtl">类比推理</option>
					<option value="rjjwnl" selected="selected">人际交往能力</option>
				</c:if>
			</select>
		</c:if>
</div>
<div style="clear:both;"></div>
<c:if test="${!empty qid}">
<div id="question_id" style="display:none;">${requestScope.qid}</div>
</c:if>
<div style="margin:15px 0 0 15px;">
<c:if test="${!empty qcontext}">
	<p>问题要求：</p>
	<textarea style="width:400px;height:80px;margin-top:10px;"  id="questionleirong">${qcontext}</textarea>
</c:if>
<c:if test="${empty qcontext}">
	<p>请输入问题要求：</p>
	<textarea style="width:400px;height:80px;margin-top:10px;"  id="questionleirong"></textarea>
</c:if>
</div>
<div style="margin:15px 0 0 15px;">
	<c:if test="${!empty answerA}">
		<div style="margin-top:10px;">答案A：<input type="text" id="answerA"  value="${answerA}" />　　分数：<input type="text" id="pointA" value="${pointA}"  /></div>
		<div style="margin-top:10px;">答案B：<input type="text" id="answerB"  value="${answerB}" />　　分数：<input type="text" id="pointB" value="${pointB}"  /></div>
		<div style="margin-top:10px;">答案C：<input type="text" id="answerC"  value="${answerC}" />　　分数：<input type="text" id="pointC" value="${pointC}"  /></div>
		<div style="margin-top:10px;">答案D：<input type="text" id="answerD"  value="${answerD}" />　　分数：<input type="text" id="pointD" value="${pointD}"  /></div>
	</c:if>	
	<c:if test="${empty answerA}">
		<div style="margin-top:10px;">答案A：<input type="text" id="answerA" />　　分数：<input type="text" id="pointA"/></div>
		<div style="margin-top:10px;">答案B：<input type="text" id="answerB" />　　分数：<input type="text" id="pointB"/></div>
		<div style="margin-top:10px;">答案C：<input type="text" id="answerC" />　　分数：<input type="text" id="pointC"/></div>
		<div style="margin-top:10px;">答案D：<input type="text" id="answerD" />　　分数：<input type="text" id="pointD"/></div>
	</c:if>
</div>



