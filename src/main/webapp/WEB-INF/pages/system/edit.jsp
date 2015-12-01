<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="p" uri="http://permissiontag"  %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/pages/header.jsp" />
</head>
<body oncontextmenu='return false' ondragstart='return false'>


<div class="contBox">
	<div class="contBox-fluid">
		<div class="box">
			<div class="boxHd"> <a class="btn btn-large btn-info btn-back f_R" href="Javascript:window.history.go(-1)"><i class="icon-chevron-left"></i> 返回</a><em class="tit">编辑用户权限</em> </div>
			<div class="boxBd">
				<form:form action="" method="POST" class="form-horizontal form-validate" commandName="user" target="_self">
					<div class="control-group">
						<label for="plc_name" class="control-label">用户名称：</label>
						<div class="controls">
							<input type="text" name="plc_name" id="plc_name" class="input-medium valid" value="${user.name }" readonly="readonly">
							<span class="maroon">*</span> <span for="plc_name" class="help-block error valid" style=""></span></div>
					</div>
	
					 
					<div class="control-group">
						<label for="wechat_id" class="control-label">登陆账号：</label>
						<div class="controls">
							<input type="text" name="wechat_id" id="wechat_id" class="input-medium valid" value="${user.username }" readonly="readonly">
							<span class="maroon">*</span> <span for="wechat_id" class="help-block error valid" style=""></span></div>
					</div>
					 
					<div class="control-group">
						<label for="email" class="control-label">邮箱：</label>
						<div class="controls">
							<input type="text" name="email" value="" id="email" class="input-medium" readonly="readonly">
						</div>
					</div>
					<div class="control-group">
						<label for="funs" class="control-label">到期时间：</label>
						<div class="controls">
							<input type="text" name="expireTime" id="funs" class="input-medium date"
							value='<fmt:formatDate value="${user.expireTime }" pattern='yyyy-MM-dd HH:mm:ss'/>'
							/>
						</div>
					</div>
					<c:forEach items="${allPermissions }" var="p">
					<div class="control-group">
						<label for="type" class="control-label">${p.name }：</label>
						<div class="controls">
						 	<div class="switch" data-on="success" data-off="warning" class="">
								<input type="checkbox" value="${p.id }" class="permissionCheckBox"/>
								
							</div>
						</div>
						<p:p f="${p.flag }" ps="${userPermissions }"><span class="check" style="display: none;">1</span></p:p>
					</div>
					</c:forEach>
					<div class="control-group">
						<label for="type" class="control-label">&nbsp;</label>
						<div class="controls">
						<button type="submit" class="btn btn-primary">保存</button>
						<a class="btn btn-default" href="Javascript:window.history.go(-1)">取消</a>
						</div>
					</div>
					<form:hidden path="id"/>
				</form:form>
				 
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/pages/footer.jsp" />
<script type="text/javascript">
$(function(){
	var userid = "${user.id}";
	var change = 0;
	$("input[class='permissionCheckBox']").each(function(){
		if($(this).closest(".control-group").children(".check").html() == 1) {
			$(this).click();
		}
	});
	$(".permissionCheckBox").change(function(){
		var clazz = $(this).parent("div").attr("class");
		change++;
		var pid = $(this).val();
		if (clazz == "switch-off" || clazz == "switch-off switch-animate" || clazz == "switch-animate switch-off") {
			$.get("${path}/user/removePermission?uid="+userid+"&pid="+pid, function(msg){
			});
		} else {
			$.get("${path}/user/addPermission?uid="+userid+"&pid="+pid, function(msg){
			});
		}
	});
});
</script>
</body>
</html>
