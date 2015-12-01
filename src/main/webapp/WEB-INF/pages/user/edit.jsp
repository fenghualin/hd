<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!Doctype html>
<html>
  <head>
    
    <title>My JSP 'edit.jsp' starting page</title>
    
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
  	<form:form action="" method="post" commandName="user">
	<div style="width:600px;margin: 100px auto;">
		<table border="0">
			<tr><td>编号：</td><td><form:input path="id"/></td></tr>
			<tr><td>姓名：</td><td><form:input path="name"/></td></tr>
			<tr><td>用户名：</td><td><form:input path="username"/></td></tr>
			<tr><td>测试时间：</td><td><form:input path="createTime"/></td></tr>
			<tr><td>性别：</td><td>
				<form:radiobutton path="xingbie" value="男" label="男"/>
				<form:radiobutton path="xingbie" value="女" label="女"/>
			</td></tr>
			<tr><td>年龄：</td><td><form:input path="nianling" /></td></tr>
			<tr><td>民族：</td><td>
				<jsp:include page="/WEB-INF/pages/public/minzuList.jsp" />
				<form:select path="minzu">
					<form:options items="${minzuList  }"/>
				</form:select>
			</td></tr>
			<tr><td>学历：</td><td>
				<form:select path="xueli">
					<form:option value="小学"/>
					<form:option value="初中"/>
					<form:option value="高中"/>
					<form:option value="大专"/>
					<form:option value="本科"/>
					<form:option value="硕士"/>
					<form:option value="博士"/>
				</form:select>
			</td></tr>
			<tr><td>年级：</td><td><form:input path="nianji"/></td></tr>
			<tr><td>班级：</td><td><form:input path="banji"/></td></tr>
			<tr><td>学生类型：</td><td>
				<form:select path="xueshengleixing">
					<form:option value="理科生" />
					<form:option value="文科生" />
					<form:option value="体育生" />
					<form:option value="艺术生" />
					<form:option value="未定向" />
				</form:select>
			</td></tr>
			<tr><td>原学习类型：</td><td>
				<form:select path="yuanxuexileixing">
					<form:option value="理科生" />
					<form:option value="文科生" />
					<form:option value="体育生" />
					<form:option value="艺术生" />
				</form:select>
			</td></tr>
			<tr><td>身份证：</td><td><form:input path="shenfenzheng"/></td></tr>
			<tr><td>父亲姓名：</td><td><form:input path="fuqinxingming"/></td></tr>
			<tr><td>母亲姓名：</td><td><form:input path="muqinxingming"/></td></tr>
			<tr><td>父亲年龄：</td><td><form:input path="fuqinnianling"/></td></tr>
			<tr><td>母亲年龄：</td><td><form:input path="muqinnianling"/></td></tr>
			<tr><td>单位：</td><td><form:input path="danwei"/></td></tr>
			<tr><td>固定电话：</td><td><form:input path="gudingdianhua"/></td></tr>
			<tr><td>移动电话：</td><td><form:input path="yidongdianhua"/></td></tr>
			<tr><td>邮箱：</td><td><form:input path="email"/></td></tr>
			<tr><td>地址：</td><td><form:input path="dizhi"/></td></tr>
			<tr><td>视力：</td><td><form:input path="shili"/></td></tr>
			<tr><td>听力：</td><td>
				<form:radiobutton path="tingli" value="正常" label="正常"/>
				<form:radiobutton path="tingli" value="弱" label="弱"/>
			</td></tr>
			<tr><td>色觉：</td><td>
				<form:radiobutton path="sejue" value="正常" label="正常"/>
				<form:radiobutton path="sejue" value="色弱" label="色弱"/>
				<form:radiobutton path="sejue" value="色盲" label="色盲"/>
			</td></tr>
			<tfoot>
			<tr><td></td><td><input type="submit" value="保存"/></td></tr>
			</tfoot>
		</table>
	</div>
	</form:form>
  </body>
</html>
