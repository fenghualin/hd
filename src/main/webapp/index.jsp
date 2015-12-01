<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% request.setAttribute("path", request.getContextPath()); %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>启动and登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=9;IE=8;IE=7;" />
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<link rel="icon" href="${stc }favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${stc }favicon.ico" type="image/x-icon" />
<script type="text/javascript" src="${stc }js/yellow.js"></script>
<script type="text/javascript">
$(function(){
		setTimeout(function(){
		$(".boxflash").hide("fast");
		$(".login").show("fast");
		}, 8500);
	});
</script>
<script type="text/javascript">
$(function(){
	setTimeout(function(){
		$(".boxflash").hide("fast");
		$(".login").show("fast");
		$(document).keydown(function(event) {
			var ev = document.all ? window.event : event;  
			if (ev.keyCode == 13) {
				$(".btn-enter").click();
			}
		});
	}, 8500);
	$(".btn-enter").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		if (!checkNull($("#username"), "请输入授权码") || !checkNull($("#password"), "请输入密码")) {
			return false;
		}
		$("#echo").html("正在验证授权码和密码中...");
		var user = {
			username:username,
			password:password
		}
		$.post("${path}/user/userlogin",user,function(data){
			$("#echo").html("");
			if (data == "nouser") {
				alert("授权码不存在，请重新输入");
				$("#username").focus();
			} else if (data == "nopassword") {
				alert("授权密码有误，请重新输入");
				$("#password").focus();
			} 
// 			else if (data == "online") {
// 				alert("当前授权账号正在使用中，请更换授权账号");
// 				$("#username").focus();
// 			}
			else if(data=="iswancheng"){
					alert("该帐号已经测试完成！");
			} else if(data=="ok"){
					window.location.href="${path}/login/copyright";
			}
		});
		});
});
function checkNull($this, msg) {
	if (!$this.val()) {
		alert(msg);
		$this.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body oncontextmenu="return false" ondragstart="return false">
<div class="boxflash">
	<object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="800" height="600">
		<param name="movie" value="${stc }swf/start.swf">
		<param name="quality" value="high">
		<param name="wmode" value="opaque">
		<param name="swfversion" value="7.0.70.0">
		<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
		<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
		<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
		<!--[if !IE]>-->
		<object id="FlashID2" type="application/x-shockwave-flash" data="${stc }swf/start.swf" width="800" height="600" >
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
			<div><span id="echo" style="font-size:12px;"></span></div>
		</div>
		<button class="btn-enter" >ENTER</button>
	</div>
<%--<link rel="stylesheet" type="text/css" href="http://mp.weixinim.com/stc/plugin/dialog/dialog.css" media="all" />--%>
<%--<script type="text/javascript" src="http://mp.weixinim.com/stc/plugin/dialog/dialog_min.js"></script>	--%>
<div class="footer">
	<div class="bd">
		<a href="http://www.huanduguihua.com/default/htmlDocument/category12304/index.html" target="_blank">关于我们</a>&nbsp;|&nbsp;联系方式：邮件咨询：huandu@huanduguihua.com 地址：北京市海淀区学院南路12号京师科技大厦A座611室</a>
	</div>
</div>
<style>
	 
	.footer{ text-align:center;font-size:12px; color:#999; position:absolute; bottom:0; left:0; height:30px; width:100%; line-height:30px; }
	.footer a{ font-size:12px; color:#999; text-decoration:none;}
</style> 
</body>
</html>
