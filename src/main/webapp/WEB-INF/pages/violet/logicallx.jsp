<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<script type="text/javascript">if (location.href.indexOf("random") == -1) {location.href = location.href+"?random="+Math.random();}</script>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT"><META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<meta charset="utf-8">
<title>逻辑推理练习</title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/ljtl/zzgl.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.time{ font-size:12px;position:absolute; left:30px; top:10px; z-index:10;}
.imgbox{ position:absolute; left:50%; top:50%; width:940px; height:600px; margin-left:-470px; margin-top:-294px; display:none;font-size:14px;}
.imgbox .bd{ position:relative; height:100%;}
.imgbox .bd .img{ position:absolute; z-index:5; text-align:center; width:100%; height:100%;}
.imgbox .bd .img img{ width:800px; height:600px;}
.imgbox .bd .selectbox{ position:absolute; z-index:10;width:100%; height:164px; bottom:54px; left:0;text-align:center; font-size:0;}
.imgbox .bd .selectbox .f{ display:inline-block; width:93px; height:75px; background:none; margin:0 6px;}
.imgbox .bd .selectbox .f:active{ border-color:#f00;}

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
var imgname=["6.jpg"];
var q_answer=[5];
var jindu=0;
var time=0;
var imgurl="${stc }images/ljtl/";
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					$(".imgbox").show();
					$(".tips").hide();
					imgqiehuan();
					setInterval("dstime()",1000);
				});
			});
		}, 8200);
		$(".selectbox a").click(function(){
			var student_choice = parseInt($(this).attr("lang"));
			var student_score=0;
			var question_no = jindu;
// 			alert(question_no);
			var reaction_time=getNs()-time;
			var right_anser=q_answer[jindu-1];
			var isright=0;
			if(right_anser == student_choice){
				student_score=student_score+1;
				isright=1;
			}
 		//$.post("<%=path%>/violet/logical/logicalsave",{"student_choice":student_choice,"student_score":student_score,"question_no":question_no,"reaction_time":reaction_time,"right_anser":right_anser,"isright":isright});
			imgqiehuan();
		});
	});
	
	function imgqiehuan(){
		if(jindu>(imgname.length-1)){
			questionend("lx","heise","<%=path%>/user/mokuai");
			$(".imgbox").hide();
				$("#sytime").text(-1);
		}
		else{
			$(".img img").attr("src",imgurl+imgname[jindu]);
			$("#sytime").text(180);
			jindu = jindu+1;
		}
		time=getNs();
	}
	function dstime(){
		var sytime = parseInt($("#sytime").text());
		if(sytime <= 1){
			var student_choice = 0;
			var student_score=0;
			var question_no = jindu;
			var reaction_time=getNs()-time;
			var right_anser=q_answer[jindu-1];
			var isright=0;
			if(right_anser == student_choice){
				student_score=student_score+1;
				isright=1;
			}
			imgqiehuan();
			return false;
		}
		$("#sytime").text(sytime-1);
	}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/ljtl.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/ljtl.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
<div class="imgbox">
	<div class="time">本小题剩余时间：<span id="sytime">180</span></div>
	<div class="bd">
		<div class="selectbox">
			<div>
				<a class="f f1" href="#" lang="0"><img src="${stc }images/blank.gif" width="93" height="75" /></a>
				<a class="f f2" href="#" lang="1"><img src="${stc }images/blank.gif" width="93" height="75" /></a>
				<a class="f f3" href="#" lang="2"><img src="${stc }images/blank.gif" width="93" height="75" /></a>
			</div>
			<div style="margin-top:12px;">
				<a class="f f4" href="#" lang="3"><img src="${stc }images/blank.gif" width="93" height="75" /></a>
				<a class="f f5" href="#" lang="4"><img src="${stc }images/blank.gif" width="93" height="75" /></a>
				<a class="f f6" href="#" lang="5"><img src="${stc }images/blank.gif" width="93" height="75" /></a>
			</div>
		</div>
		<div class="img"><img src=""></div>
	</div>
</div>
<!--end-->
</body>
</html>

