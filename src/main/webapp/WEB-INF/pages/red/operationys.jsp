<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!Doctype html>
<html>
  <head>
<script type="text/javascript">if (location.href.indexOf("random") == -1) {location.href = location.href+"?random="+Math.random();}</script>
    <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
    
    <title>空间操作</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
 
</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js"></script>
<script>
	$(function(){
			var scheight = $(".fullscreen").height();
			$(".fullscreen").css("margin-top",-(scheight/2));
			setTimeout(function(){
				location.href="<%=path%>/user/mokuai";
			},21000);
		});
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
		<param name="movie" value="${stc }swf/kjcz_dome2.swf">
		<param name="quality" value="high">
		<param name="wmode" value="opaque">
		<param name="swfversion" value="7.0.70.0">
		<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
		<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
		<param name="SCALE" value="exactfit">
		<param name="BGCOLOR" value="#000000">
		<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 --> 
		<!--[if !IE]>-->
		<object data="${stc }swf/kjcz_dome2.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
			<!--<![endif]-->
			<param name="quality" value="high">
			<param name="wmode" value="opaque">
			<param name="swfversion" value="7.0.70.0">
			<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
			<param name="SCALE" value="exactfit">
			<param name="BGCOLOR" value="#000000">
			<!-- 浏览器将以下替代内容显示给使用 Flash Player 6.0 和更低版本的用户。 -->
			<div>
				<h4>此页面上的内容需要较新版本的 Adobe Flash Player。</h4>
				<p><a href="http://www.adobe.com/go/getflashplayer"><img src="${stc }images/get_flash_player.gif" alt="获取 Adobe Flash Player" width="112" height="33" /></a></p>
			</div>
			<!--[if !IE]>-->
		</object>
		<!--<![endif]-->
	</object>
	<script type="text/javascript">
swfobject.registerObject("FlashID");
NoRightClick("FlashID");
//NoRightClick("FlashID2");
</script> 
</div>
</body>
</html>
