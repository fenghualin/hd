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
<title>概念推理练习</title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/gntl/zzgl.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.imgbox{ position:absolute; left:50%; top:50%; width:910px; height:566px; margin-left:-455px; margin-top:-267px; display:none;font-size:14px;}
.imgbox .bd{ position:relative; height:100%;}
.imgbox .bd .img{ position:absolute; z-index:5; text-align:center; width:100%; height:100%;}
.imgbox .bd .img img{ width:800px; height:566px;}
.imgbox .bd .selectbox{ position:absolute; z-index:10;width:800px; height:142px; bottom:102px; left:55px;text-align:center;}
.imgbox .bd .selectbox .f{ display:block; width:138px; height:138px; border-width:2px; border-style:solid; border-color:transparent; background:none; position:absolute;}
.imgbox .bd .selectbox .fred{ border-color:#f00;}
.f1{ left:22px;}
.f2{ left:177px;}
.f3{ left:328px;}
.f4{ left:483px;}
.f5{ left:635px;}
.imgbox .bd .btns{position:absolute; z-index:10; right:10px; bottom:10px;}
.imgbox .bd .btns .btn-ok{ width:80px; height:25px;}
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
var imgname=["flx.jpg"];
var number=0;
var jindu=0;
var choice="";
var time=0;
var imgurl="${stc }images/gntl/";
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					$(".imgbox").show();
					$(".tips").hide();
					imgqiehuan();
				});
			});
		}, 8200);
		$(".selectbox a").click(function(){
			var is_click = $(this).attr("is_click");
			if(is_click == "0"){
				if(number>=2){
					return false;
				}
				else{
					$(this).addClass("fred").attr("is_click","1");
					number=number+1;
				}
			}
			else{
				$(this).removeClass("fred").attr("is_click","0");
				number=number-1;
			}
			if(number>=2){
				$("#ques_submit").removeAttr("disabled");
			}
			else{
				$("#ques_submit").attr("disabled","disabled");
			}
		});
		
		$("#ques_submit").click(function(){
			$(".selectbox a").each(function(i,o){
				var isclick = $(o).attr("is_click");
				if(isclick=="1"){
					choice=choice+$(o).attr("lang")+",";
				}
			});
			imgqiehuan();
		});
	});
	
	function imgqiehuan(){
		choice="";
		$(".selectbox a").removeClass("fred").attr("is_click","0");
		number=0;
		if(jindu>0){
			questionend("lx","heise","<%=path%>/user/mokuai");
		}
		else{
			$(".img img").attr("src",imgurl+"flx.jpg");
		}
		jindu=jindu+1;
	}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/gntl.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/gntl.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
	<div class="time">本小题没有时间限制</div>
	<div class="bd">
		<div class="btns"><button class="btn-ok" type="button" id="ques_submit" disabled="disabled">确定</button></div>
		<div class="selectbox">
			<a class="f f1" href="javascript:" lang="0" is_click="0" ><img src="${stc }images/blank.gif" width="138" height="138" /></a>
			<a class="f f2" href="javascript:" lang="1" is_click="0"><img src="${stc }images/blank.gif"  width="138" height="138"/></a>
			<a class="f f3" href="javascript:" lang="2" is_click="0"><img src="${stc }images/blank.gif"  width="138" height="138"/></a>
			<a class="f f4" href="javascript:" lang="3" is_click="0"><img src="${stc }images/blank.gif"  width="138" height="138"/></a>
			<a class="f f5" href="javascript:" lang="4" is_click="0"><img src="${stc }images/blank.gif"  width="138" height="138"/></a>
		</div>
		<div class="img"><img src=""></div>
	</div>
</div>
<!--end-->
</body>
</html>
