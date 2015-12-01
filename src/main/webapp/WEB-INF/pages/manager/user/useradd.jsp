<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
.user_add{
margin:20px 0 0 15px;
}
.user_add table{
	width:750px;
}
.user_add table tr{
	line-height: 30px;
}
.user_add table tr td{
	text-align: left;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	var u_username=$("#u_username").val();
	$('#u_email').validatebox({
	    required: true,    
	    validType: 'email'
	});
	$('#u_name').validatebox({
	    required: true,
	});
	$('#u_username').validatebox({
	    required: true,
	    validType: 'username',
	});
	$('#u_password').validatebox({
	    required: true,
	    minLength:6,
		maxLength:16
	});
	$('#u_yidongdianhua').validatebox({
		required: true,
		validType:'kx_mobilePhone'
	});
	$('#u_username').focusout(function(){
		var username=$(this).val();
		$.post("<%=path%>/user/checkusername",{"username":username},function(data){
			if(data=="no"){
				$('#u_username').val(u_username);
				alert("授权码已经存在，请重新输入");
			}
			else{
				
			}
		});
	});
});
</script>
<div class="user_add" style="">
<c:if test="${!empty user}">
<c:if test="${type == 'update' }">
<table>
		<tr><td>姓　　名：</td><td><input type="text" id="u_name" value="${user.name }" /></td><td>授 权 码：</td><td><input type="text" value="${user.username }" id="u_username" /></td><td>密　　码：</td><td><input type="text" id="u_password" value="${user.password }" /></td></tr>
		<tr><td>性　　别：</td><td><c:if test="${user.xingbie == '男' }"><input type="radio" name="u_xingbie" value="男" checked="checked" />男<input value="女" type="radio" name="u_xingbie"  />女</c:if><c:if test="${user.xingbie == '女' }"><input type="radio" name="u_xingbie" value="男"/>男<input value="女"  checked="checked"  type="radio" name="u_xingbie" />女</c:if></td><td>年　　龄：</td><td><input type="text" id="u_nianling" value="${user.nianling }" /></td><td>民　　族：</td><td><input type="text" id="u_minzu" value="${user.minzu }" /></td></tr>
		<tr><td>学　　历：</td><td><input type="text" id="u_xueli" value="${user.xueli }" /></td><td>班　　级：</td><td><input type="text" id="u_banji" value="${user.banji }" /></td><td>年　　级：</td><td><input type="text" id="u_nianji" value="${user.nianji }" /></td></tr>
		<tr><td>学生类型：</td><td><input type="text" id="u_xueshengleixing" value="${user.xueshengleixing}" /></td><td>原学生类型：</td><td><input type="text" id="u_yuanxuexileixing" value="${user.yuanxuelileixing }" /></td><td>身 份 证：</td><td><input type="text" id="u_shenfenzheng" value="${user.shenfenzheng }" /></td></tr>
		<tr><td>父亲姓名：</td><td><input type="text" id="u_fuqinxingming" value="${user.fuqinxingming }" /></td><td>母亲姓名：</td><td><input type="text" id="u_muqinxingming" value="${user.muqinxingming}" /></td><td>父亲年龄：</td><td><input type="text" id="u_fuqinnianling" value="${user.fuqinnianling }" /></td></tr>
		<tr><td>母亲年龄：</td><td><input type="text" id="u_muqinnianling" value="${user.muqinnianling }" /></td><td>单　　位：</td><td><input type="text" id="u_danwei" value="${user.danwei }" /></td><td>固定电话：</td><td><input type="text" id="u_gudingdianhua" value="${user.gudingdianhua }" /></td></tr>
		<tr><td>移动电话：</td><td><input type="text" id="u_yidongdianhua" value="${user.yidongdianhua }" /></td><td>邮　　箱：</td><td><input type="text" id="u_email" value="${user.email }" /></td><td>地　　址：</td><td><input type="text" id="u_dizhi" value="${user.dizhi }" /></td></tr>
		<tr><td>听　　力：</td><td><input type="text" id="u_tingli" value="${user.tingli }" /></td><td>视　　力：</td><td><input type="text" id="u_shili" value="${user.shili }" /></td><td>色　　觉：</td><td><input type="text" id="u_sejue" value="${user.sejue }" /></td></tr>
		<tr><td>余　　额：</td><td><input type="text" id="u_money" value="${user.money }" /></td>
			<td>选择机构：</td>
			<td>
				<select id="u_jigou">
					<c:if test="${user.jigou == 0}">
						<option value="0" selected="selected">选择机构</option>
					</c:if>
					<c:forEach items="${jigoulist}" var="jigoulist">
						<c:if test="${jigoulist.id == user.jigou}">
							<option value="${jigoulist.id}" selected="selected">${jigoulist.name }</option>
						</c:if>
						<c:if test="${jigoulist.id != user.jigou}">
							<option value="${jigoulist.id}">${jigoulist.name }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td>选择权限：</td>
			<td>
				<select id="u_group">
					<c:if test="${empty usergroup.id}">
						<option value="0" selected="selected">选择权限</option>
					</c:if>
					<c:if test="${!empty usergroup.id}">
						<option value="0">选择权限</option>
					</c:if>
					<c:forEach items="${grouplist}" var="grouplist">
							<c:if test="${grouplist.id==usergroup.groupId }">
								<option value="${grouplist.id}" selected="selected">${grouplist.name }</option>
							</c:if>
							<c:if test="${grouplist.id!=usergroup.groupId }">
								<option value="${grouplist.id}">${grouplist.name }</option>
							</c:if>
					</c:forEach>
				</select>
			</td><td></td></tr>
			<tr><td>做题进度：</td><td><input type="text" id="u_zuotijindu" value="${user.zuotijindu }" /></td><td>是否完成：</td><td colspan="3"><input type="text" id="u_iswancheng" value="${user.iswancheng }" />(1:完成 0：未完成)</td></tr>
	</table>
	<input type="hidden" id="u_id" value="${user.id}" />
</c:if>
<c:if test="${type == 'look' }">
<table>
		<tr><td>姓　　名：</td><td><input type="text" id="u_name" value="${user.name }" disabled="disabled" /></td><td>授 权 码：</td><td><input type="text" value="${user.username }" id="u_username" disabled="disabled" /></td><td>密　　码：</td><td><input type="text" id="u_password" value="${user.password }" disabled="disabled" /></td></tr>
		<tr><td>性　　别：</td><td><c:if test="${user.xingbie == '男' }"><input type="radio" name="u_xingbie" value="男" checked="checked" disabled="disabled" />男<input value="女" type="radio" name="u_xingbie"  disabled="disabled" />女</c:if><c:if test="${user.xingbie == '女' }"><input type="radio" name="u_xingbie" value="男" disabled="disabled"/>男<input value="女"  checked="checked"  type="radio" name="u_xingbie" disabled="disabled" />女</c:if></td><td>年　　龄：</td><td><input type="text" id="u_nianling" value="${user.nianling }" disabled="disabled" /></td><td>民　　族：</td><td><input type="text" id="u_minzu" value="${user.minzu }" disabled="disabled" /></td></tr>
		<tr><td>学　　历：</td><td><input type="text" id="u_xueli" value="${user.xueli }" disabled="disabled" /></td><td>班　　级：</td><td><input type="text" id="u_banji" value="${user.banji }" disabled="disabled" /></td><td>年　　级：</td><td><input type="text" id="u_nianji" value="${user.nianji }" disabled="disabled" /></td></tr>
		<tr><td>学生类型：</td><td><input type="text" id="u_xueshengleixing" value="${user.xueshengleixing}" disabled="disabled" /></td><td>原学生类型：</td><td><input type="text" id="u_yuanxuexileixing" value="${user.yuanxuelileixing }" disabled="disabled" /></td><td>身 份 证：</td><td><input type="text" id="u_shenfenzheng" value="${user.shenfenzheng }" disabled="disabled" /></td></tr>
		<tr><td>父亲姓名：</td><td><input type="text" id="u_fuqinxingming" value="${user.fuqinxingming }" disabled="disabled" /></td><td>母亲姓名：</td><td><input type="text" id="u_muqinxingming" value="${user.muqinxingming}" disabled="disabled" /></td><td>父亲年龄：</td><td><input type="text" id="u_fuqinnianling" value="${user.fuqinnianling }" disabled="disabled" /></td></tr>
		<tr><td>母亲年龄：</td><td><input type="text" id="u_muqinnianling" value="${user.muqinnianling }" disabled="disabled" /></td><td>单　　位：</td><td><input type="text" id="u_danwei" value="${user.danwei }" disabled="disabled" /></td><td>固定电话：</td><td><input type="text" id="u_gudingdianhua" value="${user.gudingdianhua }" disabled="disabled" /></td></tr>
		<tr><td>移动电话：</td><td><input type="text" id="u_yidongdianhua" value="${user.yidongdianhua }" disabled="disabled" /></td><td>邮　　箱：</td><td><input type="text" id="u_email" value="${user.email }" disabled="disabled" /></td><td>地　　址：</td><td><input type="text" id="u_dizhi" value="${user.dizhi }" disabled="disabled" /></td></tr>
		<tr><td>听　　力：</td><td><input type="text" id="u_tingli" value="${user.tingli }" disabled="disabled" /></td><td>视　　力：</td><td><input type="text" id="u_shili" value="${user.shili }" disabled="disabled" /></td><td>色　　觉：</td><td><input type="text" id="u_sejue" value="${user.sejue }" disabled="disabled" /></td></tr>
		<tr><td>余　　额：</td><td><input type="text" id="u_money" disabled="disabled" value="${user.money }" /></td>
		<td>选择机构：</td>
		<td>
				<select id="u_jigou" disabled="disabled">
					<c:if test="${user.jigou == 0}">
						<option value="0" selected="selected">选择机构</option>
					</c:if>
					<c:forEach items="${jigoulist}" var="jigoulist">
						<c:if test="${jigoulist.id == user.jigou}">
							<option value="${jigoulist.id}" selected="selected">${jigoulist.name }</option>
						</c:if>
						<c:if test="${jigoulist.id != user.jigou}">
							<option value="${jigoulist.id}">${jigoulist.name }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		<td>选择权限：</td>
			<td>
				<select id="u_group" disabled="disabled">
					<c:if test="${empty usergroup.id}">
						<option value="0" selected="selected">选择权限</option>
					</c:if>
					<c:if test="${!empty usergroup.id}">
						<option value="0">选择权限</option>
					</c:if>
					<c:forEach items="${grouplist}" var="grouplist">
							<c:if test="${grouplist.id==usergroup.groupId }">
								<option value="${grouplist.id}" selected="selected">${grouplist.name }</option>
							</c:if>
							<c:if test="${grouplist.id!=usergroup.groupId }">
								<option value="${grouplist.id}">${grouplist.name }</option>
							</c:if>
					</c:forEach>
				</select>
			</td><td></td></tr>
	</table>
</c:if>
</c:if>
<c:if test="${type == 'add' }">
<table>
		<tr><td>姓　　名：</td><td><input type="text" id="u_name" /></td><td>授 权 码：</td><td><input type="text" id="u_username" value="${u_name}" /></td><td>密　　码：</td><td><input type="text" id="u_password" /></td></tr>
		<tr><td>性　　别：</td><td><input type="radio" name="u_xingbie" value="男" checked="checked" />男<input value="女" type="radio" name="u_xingbie" />女</td><td>年　　龄：</td><td><input type="text" id="u_nianling" /></td><td>民　　族：</td><td><input type="text" id="u_minzu" /></td></tr>
		<tr><td>学　　历：</td><td><input type="text" id="u_xueli" /></td><td>班　　级：</td><td><input type="text" id="u_banji" /></td><td>年　　级：</td><td><input type="text" id="u_nianji" /></td></tr>
		<tr><td>学生类型：</td><td><input type="text" id="u_xueshengleixing" /></td><td>原学生类型：</td><td><input type="text" id="u_yuanxuexileixing" /></td><td>身 份 证：</td><td><input type="text" id="u_shenfenzheng" /></td></tr>
		<tr><td>父亲姓名：</td><td><input type="text" id="u_fuqinxingming" /></td><td>母亲姓名：</td><td><input type="text" id="u_muqinxingming" /></td><td>父亲年龄：</td><td><input type="text" id="u_fuqinnianling" /></td></tr>
		<tr><td>母亲年龄：</td><td><input type="text" id="u_muqinnianling" /></td><td>单　　位：</td><td><input type="text" id="u_danwei" /></td><td>固定电话：</td><td><input type="text" id="u_gudingdianhua" /></td></tr>
		<tr><td>移动电话：</td><td><input type="text" id="u_yidongdianhua" /></td><td>邮　　箱：</td><td><input type="text" id="u_email" /></td><td>地　　址：</td><td><input type="text" id="u_dizhi" /></td></tr>
		<tr><td>听　　力：</td><td><input type="text" id="u_tingli" /></td><td>视　　力：</td><td><input type="text" id="u_shili" /></td><td>色　　觉：</td><td><input type="text" id="u_sejue" /></td></tr>
		<tr><td>余　　额：</td><td><input type="text" id="u_money" /></td>
		<td>选择机构：</td>
			<td>
				<select id="u_jigou">
					<option value="0" selected="selected">选择机构</option>
					<c:forEach items="${jigoulist}" var="jigoulist">
							<option value="${jigoulist.id}">${jigoulist.name }</option>
					</c:forEach>
				</select>
			</td>
			<td>选择权限：</td>
			<td>
				<select id="u_group">
					<option value="0" selected="selected">选择权限</option>
					<c:forEach items="${grouplist}" var="grouplist">
							<option value="${grouplist.id}">${grouplist.name }</option>
					</c:forEach>
				</select>
			</td><td></td></tr>
	</table>
</c:if>

</div>

