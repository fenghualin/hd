<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>快速测试选择</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<link rel="icon" href="${stc }favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${stc }favicon.ico" type="image/x-icon" />
<style>
.group{ padding:20px 13px; padding-right:0;font-size:12px;}
.group ul{ margin-bottom:20px;}
.group ul li{ margin-right:15px; width:126px; float:left;}
.group ul li dl{}
.group ul li dl dt{ margin-bottom:20px;}
.group ul li dl dt a{display:block; height:30px; line-height:30px;text-align:center; background-color:#f7f7f7; color:#000; text-decoration:none;}
.group ul li dl dd{ margin-bottom:10px;}
.group ul li dl dd a{ display:block; height:25px; line-height:25px; text-align:center; background-color:#e7e7e7; color:#000; text-decoration:none;}
.group ul li dl a:hover{ background-color:#11379f; color:#fff;}
</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }js/jquery.SuperSlide.2.1.1.js"></script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="group">
	 <ul class="clearfix">
	 	<li>
			<dl>
				<dt><a href="javascript:void(0);" target="_self">信息加工&amp;工作记忆</a></dt>
				<dd><a href="<%=path%>/system/select?zuotijindu=1" target="_blank">选择反应</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=2" target="_blank">图形匹配</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=3" target="_blank">语音回路</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=4" target="_blank">中央处理器</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=5" target="_blank">视空板</a></dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt><a href="javascript:void(0);" target="_self">语言&amp;数学</a></dt>
				<dd><a href="<%=path%>/system/select?zuotijindu=6" target="_blank">数学比较</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=7" target="_blank">数学运算</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=8" target="_blank">语言测验</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=9" target="_blank">走迷津</a></dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt><a href="javascript:void(0);" target="_self">自然&amp;人际</a></dt>
				<dd><a href="<%=path%>/system/select?zuotijindu=10" target="_blank">目标搜索</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=11" target="_blank">目标比较</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=12" target="_blank">目标拼图</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=13" target="_blank">人际交往能力A</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=14" target="_blank">人际交往能力B</a></dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt><a href="javascript:void(0);" target="_self">空间&amp;表象&amp;思维</a></dt>
				<dd><a href="<%=path%>/system/select?zuotijindu=15" target="_blank">空间操作</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=16" target="_blank">空间推理</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=17" target="_blank">表象能力</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=18" target="_blank">思维转换</a></dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt><a href="javascript:void(0);" target="_self">美术能力</a></dt>
				<dd><a href="<%=path%>/system/select?zuotijindu=19" target="_blank">空间比例判断</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=20" target="_blank">门萨艺术</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=21" target="_blank">色彩对比</a></dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt><a href="javascript:void(0);" target="_self">音乐能力</a></dt>
				<dd><a href="<%=path%>/system/select?zuotijindu=22" target="_blank">音调形象</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=23" target="_blank">音长</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=24" target="_blank">节奏</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=25" target="_blank">音的记忆</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=26" target="_blank">音乐鉴赏</a></dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt><a href="javascript:void(0);" target="_self">组织管理&amp;逻辑推理</a></dt>
				<dd><a href="<%=path%>/system/select?zuotijindu=27" target="_blank">组织管理能力</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=28" target="_blank">概念推理</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=29" target="_blank">逻辑推理</a></dd>
			</dl>
		</li>
	 </ul>
	 <ul class="clearfix">
	 	<li>
			<dl>
				<dt><a href="javascript:void(0);" target="_self">职业心向测量</a></dt>
				<dd><a href="<%=path%>/system/select?zuotijindu=30" target="_blank">职业心向</a></dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt><a href="javascript:void(0);" target="_self">人格测量</a></dt>
				<dd><a href="<%=path%>/system/select?zuotijindu=31" target="_blank">人格测验1</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=32" target="_blank">人格测验2</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=33" target="_blank">人格投射1</a></dd>
				<dd><a href="<%=path%>/system/select?zuotijindu=34" target="_blank">人格投射2</a></dd>
			</dl>
		</li>
	 </ul>
	 <ul class="clearfix">
	 	<li>
			<dl>
				<dd><a href="javascript:void(0);">启动界面</a></dd>
				<dd><a href="javascript:void(0);">注册</a></dd>
				<dd><a href="javascript:void(0);">结束</a></dd>
				<dd><a href="javascript:void(0);">Error</a></dd>
			</dl>
		</li>
		<li>
			<dl>
				<dd><a href="javascript:void(0);">职业潜能</a></dd>
				<dd><a href="javascript:void(0);">职业心向</a></dd>
				<dd><a href="javascript:void(0);">人格特质</a></dd>
			</dl>
		</li>
	 </ul>
</div>
</body>
</html>
