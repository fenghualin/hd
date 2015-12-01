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
    <title>色彩对比</title>
    <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/scdb/msnl3.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.imgshows{ width:562px; height:562px; position:absolute; left:50%; top:50%; margin-left:-281px; margin-top:-268px; display:none; background-color:#f0f0f0;}
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.imgshows .bd{ position:absolute; z-index:5; text-align:center;left:0%; top:0%;  width:100%; height:100;}
.imgshows .bd img{  width:562px;height:562px;}
.imgshows .bd .title{ color:#fff; font-size:26px; margin-bottom:20px;}
.imgshows .btns{ position:absolute; bottom:12px; left:0; width:100%; z-index:10; text-align:center;}
.imgshows .btns button{ width:40px; height:40px; background-color:#f5961e; outline:none; border:1px solid #fd8909; font-size:20px; color:#fff;margin:0 10px;}
.imgshows .btns button:active{ background-color:#fd8909;}
 
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
			$(".tips .bd").css("margin-top",-(tipheight/2)) ;
		});
</script>

<script type="text/javascript">
var imgurl="${stc }images/scdb/";
var isclick=false;
var questionimg=["1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","10.jpg","11.jpg","12.jpg","13.jpg","14.jpg","15.jpg","16.jpg","17.jpg","18.jpg"];
var questionanswer=[2,1,1,2,1,1,1,2,2,2,2,1,1,2,2,1,2,1];
var time=0;
var jindu=0;
var isend=false;
$(function(){
	$.ajax({
		type: "POST",
		url: "/user/getXiaotijd",
		data: {},
		dataType: "json",
		success: function(data){
			if (!data[0]) {
				return ;
			}
			$("#imgid").attr("lang", data[0].xiaotijd);
		},
		error: function() {
			
		}
	});
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					if(isend){
						return ;
					}
					$(".imgshows").show();
					$(".tips").hide();
					imgqiehuan();
					isend=true;
				});
			});
		}, 7600);
		$("body").mousedown(function(e){
				$("#imgid").hide();
				var lang = parseInt($("#imgid").attr("lang"));
				if(jindu>18){
						setpanduantimus("2","heise","<%=path%>/user/mokuai?load=yes");
						return false;
					}
				if(e.which == 3){
					if(isclick == true){
				  		datasubmit("1");
				  	}
			 	}
				 else if(e.which == 1){
				  	if(isclick == true){
				  		datasubmit("0");
				  	}
				 }
				else{
					return false;
				}
		});
	});
function imgqiehuan(){
	var lang = parseInt($("#imgid").attr("lang"));
	if(lang>17){
		$("#imgid").attr({"lang":lang+1}).removeAttr("src");
		questionend("2","heise","<%=path%>/user/mokuai?load=yes");
		jindu=19;
	}
	else{
		$("#imgid").attr({"src":imgurl+questionimg[lang]+"?20141011150301","lang":lang+1});
		setTimeout(function(){
			$("#imgid").show();
		}, 300);
	}
	time=getNs();
	isclick=true;
}
function datasubmit(mouseclick){
	var lang = parseInt($("#imgid").attr("lang"))-1;
	var reaction_time=getNs()-time;
	var question_no = $("#imgid").attr("lang");
	var student_choice = mouseclick;
	var question_answer=0;
	if(mouseclick=="1" && questionanswer[lang]==2){
		question_answer = 1;
	}
	else if(mouseclick=="0" && questionanswer[lang]==1){
		question_answer = 1;
	}
	else{
		question_answer=0;
	}
	if(lang<18){
		$.post("<%=path%>/orange/colorContrast/colorContrastsave",{"student_choice":student_choice,"reaction_time":reaction_time,"question_answer":question_answer,"question_no":question_no});
	}
	imgqiehuan();
}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false' >
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/scdb.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/scdb.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
	<div class="time">本小题没有时间限制</div>
	<div class="bd">
		 <img src="" id="imgid" lang="0">
	</div>
	 
</div>
<!--end-->
</body>
</html>

