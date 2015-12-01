<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>启动and登录</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js"></script>
<script type="text/javascript">
$(function(){
		setTimeout(function(){
		$(".boxflash").hide("fast");
		$(".login").show("fast");
		}, 8500);
		$(".btn-enter").click(function(){
			var username = $("#username").val();
			var password = $("#password").val();
			$.post("<%=path%>/user/userlogin",{"username":username,"password":password},function(data){
				if(data=="ok"){
					window.location.href="<%=path%>/system/allselect";
				}
				else if(data=="iswancheng"){
					alert("该帐号已经测试完成！");
				}
				else{
					alert("授权码或密码错误！");
				}
			});
		});
		$("body").keydown(function(e){
			if(e.keyCode==13){
				$(".btn-enter").click();
			}
		});
	});
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="boxflash">
	<object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="800" height="600">
		<param name="movie" value="${stc }swf/start.swf">
		<param name="quality" value="high">
		<param name="wmode" value="opaque">
		<param name="swfversion" value="7.0.70.0">
		<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
		<param name="expressinstall" value="Scripts/expressInstall.swf">
		<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
		<!--[if !IE]>-->
		<object type="application/x-shockwave-flash" data="${stc }swf/start.swf" width="800" height="600" id="FlashID2" >
				<!--<![endif]-->
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
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
<div class="login">
		<div class="bd">
			<div class="mb12"><input class="input" name="username" id="username" type="text" /></div>
			<div><input class="input" type="password" name="password" id="password" /></div>
		</div>
		<a href="javascript:" class="btn-enter" >ENTER</a>
	</div>
<script type="text/javascript">

</script>
</body>
</html>
