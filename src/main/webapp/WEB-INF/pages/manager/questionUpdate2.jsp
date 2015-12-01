<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div style="margin:20px 0 0 15px;">
		<c:if test="${!empty qkinds}">
			<p style="float:left;">问题类型：</p>
			<select id="questionkinds2" style="float:left;" >
				<c:if test="${qkinds == 1}">
					<option value="rjjwnl2" selected="selected">人际交往能力B</option>
					<option value="zyxxnl">职业心向能力</option>
					<option value="rgjc1">人格检测1</option>
					<option value="rgjc2">人格检测2</option>
				</c:if>
				<c:if test="${qkinds == 2}">
					<option value="rjjwnl2">人际交往能力B</option>
					<option value="zyxxnl"  selected="selected">职业心向能力</option>
					<option value="rgjc1">人格检测1</option>
					<option value="rgjc2">人格检测2</option>
				</c:if>
				<c:if test="${qkinds == 3}">
					<option value="rjjwnl2">人际交往能力B</option>
					<option value="zyxxnl" >职业心向能力</option>
					<option value="rgjc1" selected="selected">人格检测1</option>
					<option value="rgjc2">人格检测2</option>
				</c:if>
				<c:if test="${qkinds == 4}">
					<option value="rjjwnl2">人际交往能力B</option>
					<option value="zyxxnl" >职业心向能力</option>
					<option value="rgjc1">人格检测1</option>
					<option value="rgjc2" selected="selected">人格检测2</option>
				</c:if>
			</select>
		</c:if>

</div>
<div style="clear:both;"></div>
<c:if test="${!empty qid}">
<div id="question_id2" style="display:none;">${requestScope.qid}</div>
</c:if>
<div style="margin:15px 0 0 15px;">
<c:if test="${!empty qcontext}">
	<p>问题要求：</p>
	<textarea style="width:400px;height:80px;margin-top:10px;"  id="questionleirong2">${qcontext}</textarea>
</c:if>
</div>
<div style="margin:15px 0 0 15px;">
	<c:if test="${!empty answerA}">
		<div style="margin-top:10px;">答案A：<input type="text" id="answerA2"  value="${answerA}" />　　分数：<input type="text" id="pointA2" value="${pointA}"  /></div>
		<div style="margin-top:10px;">答案B：<input type="text" id="answerB2"  value="${answerB}" />　　分数：<input type="text" id="pointB2" value="${pointB}"  /></div>
		<div style="margin-top:10px;">答案C：<input type="text" id="answerC2"  value="${answerC}" />　　分数：<input type="text" id="pointC2" value="${pointC}"  /></div>
		<div style="margin-top:10px;">答案D：<input type="text" id="answerD2"  value="${answerD}" />　　分数：<input type="text" id="pointD2" value="${pointD}"  /></div>
		<div style="margin-top:10px;">答案E：<input type="text" id="answerE2"  value="${answerE}" />　　分数：<input type="text" id="pointE2" value="${pointE}"  /></div>
	</c:if>	
</div>
<div style="margin:15px 0 0 15px;">
	<c:if test="${!empty inverted}">
		<p style="float:left;">答案是否倒序：</p>
		<select id="questioninverted" style="float:left;" >
			<c:if test="${inverted == '1'}">
				<option value="true" selected="selected">否</option>
				<option value="false">false</option>
			</c:if>
			<c:if test="${inverted == '0'}">
				<option value="false" selected="selected">是</option>
				<option value="true">true</option>
			</c:if>
		</select>
	</c:if>
</div>

