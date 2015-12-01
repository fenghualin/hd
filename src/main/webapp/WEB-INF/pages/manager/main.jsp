<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>环度后台管理</title>
    <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
<!-- 	<link rel="shortcut icon" href="imgs/title.ico" type="images/x-icon"/> -->
	<link rel="stylesheet" type="text/css" href="${stc }js/easyui/jquery-easyui-1.3.2/demo/demo.css"/>
	<link rel="stylesheet" type="text/css" href="${stc }js/easyui/jquery-easyui-1.3.2/themes/icon.css"/>
	<link rel="stylesheet" type="text/css" href="${stc }js/easyui/jquery-easyui-1.3.2/themes/default/easyui.css" id="easyuiCss"/>
	<script type="text/javascript" src="${stc }js/easyui/jquery-easyui-1.3.2/jquery.min.js"></script>
	<script type="text/javascript" src="${stc }js/easyui/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${stc }js/easyui/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${stc }js/easyui/kx.js?201486161536"></script>
	<link rel="icon" href="${stc }favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="${stc }favicon.ico" type="image/x-icon" />
	<style type="text/css">
		.datagrid-header-check input, .datagrid-cell-check input{
			border:none;
		}
	</style>
	<script type="text/javascript" >
		$(document).ready(function() {
			$('#menu').tree({
		data: [{"id":"<%=path%>/jigou/jigouman","text":"机构管理"},{"id":"<%=path%>/user/usermanager","text":"学生管理"},{"id":"<%=path%>/group/quanxianman","text":"用户权限管理"},{"id":"questionmanagerui","text":"问题管理(4项选择)青少年版"},{"id":"<%=path%>/questionmanager/questionmanagerui2","text":"问题管理(5项选择)青少年版"},{"id":"questionmanageruicr","text":"问题管理(4项选择)成人版"},{"id":"<%=path%>/questionmanager/questionmanagerui2cr","text":"问题管理(5项选择)成人版"}],
		animate: true,
		onClick: function(node) {
			var text  = node.text;
			if (!$('#tabs').tabs('exists', text) && node.id != 1) {
				$('#tabs').tabs('add', {
					title: text,
					closable: true,
					href: node.id
				});
			} else {
				$('#tabs').tabs('select', text);
			}
		}
	});

		});
		
	</script>
  </head>
   <body class="easyui-layout" id="bobyLayout">
	<div data-options="region:'north',border:false" style="height:67px;padding-right: 0px;overflow: hidden;">
		<div id="top_tit_" style="float:left;">
			<a href="javascript:"><img src="${stc }images/logoico.png" width="55" style="border:none"/></a><span>环度后台管理</span>
		</div>
		<div id="top_tit_bot" style="margin-right:50px;margin-top:15px;">
			<ul id="main_top_ul">
				<li>欢迎您：管理员</li>
			</ul>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'导航菜单'" style="width:240px;">
		<ul id="menu" class="easyui-tree">
		</ul>
	</div>
	<div data-options="region:'center'" id="gettab">
		<div id="tabs" class="easyui-tabs" data-options="fit:true,border:false">
			<div title="欢迎您" style="padding:20px;font-size: 20px;font-weight: bold;">
			  	<div id='kx-dialog'></div>
			  	<div id='kx-dialogtwo'></div>
			  	<div id="kx-window"></div>
			  	<div id='QQwindow'>
			  		<ul id="staffTree"></ul>
			  	</div>
	          	<div>环度后台管理</div>
      		</div>
		</div>
	</div>
  </body>
</html>
