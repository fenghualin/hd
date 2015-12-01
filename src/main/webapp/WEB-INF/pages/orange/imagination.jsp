<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!Doctype html>
<html>
  <head>
<script type="text/javascript">if (location.href.indexOf("random") == -1) {location.href = location.href+"?random="+Math.random();}</script>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT"><META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
    <title>艺术想象</title>
    <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/ms/msnl1.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.imgshows{ width:792px; height:418px; position:absolute; left:50%; top:50%; margin-left:-396px; margin-top:-198px; display:none; background-color:#f0f0f0;}
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.imgshows .bd{ position:absolute; z-index:5; text-align:center;left:0%; top:0%;  width:100%; height:100;}
.imgshows .bd img{  width:792px;height:418px;}
.imgshows .bd .title{ color:#fff; font-size:26px; margin-bottom:20px;}
.imgshows .btns{ position:absolute; bottom:12px; left:0; width:100%; z-index:10; text-align:center;}
.imgshows .btns button{ width:40px; height:40px; background-color:#f5961e; outline:none; border:1px solid #fd8909; font-size:20px; color:#fff;margin:0 10px;}
.imgshows .btns button:active{ background-color:#fd8909;}
 .btns button{cursor: pointer;}
</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }js/yellow.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script>
	$(function(){
			var scheight = $(".fullscreen").height();
			$(".fullscreen").css("margin-top",-(scheight/2));
		});
</script>
<script>
	$(function(){
			var tipheight = $(".tips .bd").height();
			$(".tips .bd").css("margin-top",-(tipheight/2));
		});
</script>

<script type="text/javascript">
var dingshidy;
var time=0;
var isend=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					if(isend == false){
						$(".imgshows").show();
						$(".tips").hide();
						dingshidy = setInterval("sytime()",1000);
						time=getNs();
						isend=true;
					}
				});
			});
		}, 7600);
		$(".btns button").click(function(){
			var student_choice = $(this).val();
			var reaction_time = getNs()-time;
			var question_answer = 5;
			var question_no = 1;
			$.post("<%=path%>/orange/imageInation/imageInationsave",{"student_choice":student_choice,"reaction_time":reaction_time,"question_answer":question_answer,"question_no":question_no},function(data){
				if(data == "ok"){
					questionend("2","heise","<%=path%>/user/mokuai");
				}
			});
		});
	});
function sytime(){
	var sytime = parseInt($("#sytime").text());
	if(sytime<=0){
		return false;
	}
	$("#sytime").text(sytime-1);
}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/ysxx.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/ysxx.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
<div class="tips">
	<div class="bd">点击鼠标，开始测试！</div>
</div>
<!--start-->
<div class="imgshows">
	<div class="time">本小题剩余时间：<span id="sytime">120</span></div>
	<div class="bd">
		 <img src="${stc }images/ms/1.jpg">
	</div>
	<div class="btns">
		 <button type="button" value="1">1</button>
		 <button type="button" value="2">2</button>
		 <button type="button" value="5">5</button>
		 <button type="button" value="6">6</button>
		 <button type="button" value="4">4</button>
		 <button type="button" value="3">3</button>
	</div>
</div>
<!--end-->
</body>
</html>
