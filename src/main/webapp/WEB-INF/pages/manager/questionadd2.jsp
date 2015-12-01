<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	$("#questioninverted").change(function(){
		var v = $(this).val();
		if(v == "true"){
			$("#pointA2").val("1");
			$("#pointB2").val("2");
			$("#pointC2").val("3");
			$("#pointD2").val("4");
			$("#pointE2").val("5");
		}
		else if(v == "false"){
			$("#pointA2").val("5");
			$("#pointB2").val("4");
			$("#pointC2").val("3");
			$("#pointD2").val("2");
			$("#pointE2").val("1");
		}
		else{
			$("#pointA2").val("");
			$("#pointB2").val("");
			$("#pointC2").val("");
			$("#pointD2").val("");
			$("#pointE2").val("");
		}
	});
	$("#updatedaan").click(function(){
		$("input").removeAttr("disabled");
	});
</script>
<div style="margin:20px 0 0 15px;">
		<c:if test="${!empty qkinds}">
			<p style="float:left;">问题类型：</p>
			<select id="questionkinds2" style="float:left;" disabled="disabled">
				<c:if test="${qkinds == 1}">
					<option value="rjjwnl2">人际交往能力B</option>
				</c:if>
				<c:if test="${qkinds == 2}">
					<option value="zyxxnl">职业心向能力</option>
				</c:if>
				<c:if test="${qkinds == 3}">
					<option value="rgjc1">人格检测1</option>
				</c:if>
				<c:if test="${qkinds == 4}">
					<option value="rgjc2">人格检测2</option>
				</c:if>
			</select>
		</c:if>
		<c:if test="${empty qkinds}">
			<p style="float:left;">请选择问题类型：</p>
			<select id="questionkinds2" style="float:left;">
				<option value="rjjwnl2">人际交往能力B</option>
				<option value="zyxxnl">职业心向能力</option>
				<option value="rgjc1">人格检测1</option>
				<option value="rgjc2">人格检测2</option>
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
	<textarea style="width:400px;height:80px;margin-top:10px;" disabled="disabled" id="questionleirong2">${qcontext}</textarea>
</c:if>
<c:if test="${empty qcontext}">
	<p>请输入问题要求：</p>
	<textarea style="width:400px;height:80px;margin-top:10px;"  id="questionleirong2"></textarea>
</c:if>
</div>
<div style="margin:15px 0 0 15px;">
	<c:if test="${!empty qkinds}">
		<p style="float:left;">答案是否倒序：</p>
		<select id="questioninverted" style="float:left;" disabled="disabled">
			<c:if test="${qkinds == '1'}">
				<option value="true">否</option>
			</c:if>
			<c:if test="${qkinds == '0'}">
				<option value="false">是</option>
			</c:if>
		</select>
	</c:if>
	<c:if test="${empty qkinds}">
		<p style="float:left;">答案是否倒序：</p>
		<select id="questioninverted" style="float:left;">
			<option value="no">请选择答案是否倒序</option>
			<option value="true">否</option>
			<option value="false">是</option>
		</select>
	</c:if>
</div>
<div style="clear:both;"></div>
<div style="margin:15px 0 0 15px;">
	<c:if test="${!empty answerA}">
		<div style="margin-top:10px;">答案A：<input type="text" id="answerA2" disabled="disabled" value="${answerA}" />　　分数：<input type="text" id="pointA2" value="${pointA}" disabled="disabled" /></div>
		<div style="margin-top:10px;">答案B：<input type="text" id="answerB2" disabled="disabled" value="${answerB}" />　　分数：<input type="text" id="pointB2" value="${pointB}" disabled="disabled" /></div>
		<div style="margin-top:10px;">答案C：<input type="text" id="answerC2" disabled="disabled" value="${answerC}" />　　分数：<input type="text" id="pointC2" value="${pointC}" disabled="disabled" /></div>
		<div style="margin-top:10px;">答案D：<input type="text" id="answerD2" disabled="disabled" value="${answerD}" />　　分数：<input type="text" id="pointD2" value="${pointD}" disabled="disabled" /></div>
		<div style="margin-top:10px;">答案E：<input type="text" id="answerE2" disabled="disabled" value="${answerE}" />　　分数：<input type="text" id="pointE2" value="${pointE}" disabled="disabled" /></div>
	</c:if>	
	<c:if test="${empty answerA}">
		<div style="margin-top:10px;">答案A：<input type="text" id="answerA2" disabled="disabled" value="不符合" />　　分数：<input type="text" id="pointA2"/></div>
		<div style="margin-top:10px;">答案B：<input type="text" id="answerB2" disabled="disabled" value="比较不符合" />　　分数：<input type="text" id="pointB2"/></div>
		<div style="margin-top:10px;">答案C：<input type="text" id="answerC2" disabled="disabled" value="一般" />　　分数：<input type="text" id="pointC2"/></div>
		<div style="margin-top:10px;">答案D：<input type="text" id="answerD2" disabled="disabled" value="比较符合" />　　分数：<input type="text" id="pointD2"/></div>
		<div style="margin-top:10px;">答案E：<input type="text" id="answerE2" disabled="disabled" value="符合" />　　分数：<input type="text" id="pointE2"/></div>
		<input type="button" value="修改答案" id="updatedaan" style="margin-top:15px;" />
	</c:if>
</div>
