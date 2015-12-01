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
<title>音的记忆</title>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background: url(${stc }images/mbg-x.jpg) repeat-x center center #ededed ;}
.tips{}
.tips .bd{ color:#000;}
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.audiobox{text-align:center; display:none; width:100%; height:100%;}
.audiobox .bd{ position:absolute; height:auto; left:0%; top:50%; width:100%; text-align:center;font-size:24px;}
.audiobox .imgbox{position:absolute; top:50%; width:100%; margin-top:-40px; font-size:0; left:0;}
.audiobox .imgbox a{ display:inline-block; width:12%;}
.audiobox .imgbox a img{}
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
var music=["1.MP3","2.MP3","3.MP3","4.MP3","5.MP3","6.MP3","7.MP3","8.MP3"];
var mtime=[1,1,1,1,1,1,1,1];
var mdaan=[4,1,7,3,6,0,5,2];
var musicurl="${stc }audio/ydjy/";
var mnum=0;
var isclick=false;
var isclickt=false;
var isclicky=false;
var isreturn=false;
var time=0;
var jinduok=0;
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
			mnum = data[0].xiaotijd;
		},
		error: function() {
			
		}
	});
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					$(".audiobox").show();
					$(".tips").hide();
				});
			});
		}, 9900);
		
		$(".tips").click(function(){
			$(".clickbofang").hide();
			isclick=true;
			play_clicks();
		});
		$(".imgbox img").click(function(){
			var student_choice = parseInt($(this).attr("lang"));
			var question_no=mnum;
			var question_right = mdaan[mnum-1];
			var student_score=0;
			var reaction_time = getNs()-time;
			if((student_choice-1) == question_right){
				student_score=1;
			}
			$.post("<%=path%>/whatet/musiccemory/musicCemorySave",{"question_no":question_no,"question_right":question_right,"student_score":student_score,"student_choice":student_choice,"reaction_time":reaction_time},function(data){
				if(mnum>7){
					jinduok=1;
					$(".imgbox").hide();
	    			$(".clickreturn").show();
	    		}
	    		else{
	    			$(".imgbox").hide();
					$(".clickbofang").show();
					isclicky=true;
	    		}
				
			});
		});
		$("body").mousedown(function(e){
			if(jinduok==1){
				if(isreturn==false){
					$(".imgbox").hide();
	    			$(".clickreturn").show();
	    			isreturn=true;
				}
				else{
					setpanduantimus("2","heise","<%=path%>/user/mokuai");
				}
				return false;
			}
			 if(e.which == 3){
			 	if(isclickt == true){
					$(".clickbfend").hide();
					play_click();
					isclickt=false;
			 	}
			 	else if(isclicky == true){
			 		$(".clickbofang").hide();
			 		isclick=true;
			 		isclicky=false;
					play_clicks();
			 	}
	         }
			 if(e.which == 1){
			 	if(isclickt == true){
					$(".clickbfend").hide();
					play_click();
					isclickt=false;
			 	}
			 	else if(isclicky == true){
			 		$(".clickbofang").hide();
			 		isclick=true;
			 		isclicky=false;
					play_clicks();
			 	}
	         }
		});
	});
function play_click(){
	if(isclickt==true){
// 		var musicid = document.getElementById('music');
// 	    musicid.src=musicurl+music[mnum];
	    var murl='<embed src="${stc }audioplay.swf?file='+musicurl+music[mnum]+'&auto=yes&sendstop=yes&repeat=1&buttondir=${stc }audioplay&bgcolor=0xffffff&mode=playpause" quality="high" width="1" height="1" align="" type="application/x-shockwave-flash" />';
    	$("#music4").html(murl);
	    setTimeout(function(){
	    	$(".imgbox").show();
	    	time=getNs();
	    },1100);
	    mnum=mnum+1;
	}
}
function play_clicks(){
	if(isclick==true){
// 	    var userAgent = navigator.userAgent.toLowerCase();
// 		var browserId = userAgent.match(/(firefox|chrome|safari|opera|msie)/)[1];
// 		var browserVersion = (userAgent.match(new RegExp('.+(?:version)[\/: ]([\\d.]+)')) || userAgent.match(new RegExp('(?:'+browserId+')[\/: ]([\\d.]+)')) || [0,'0'])[1];
		var murl='<embed src="${stc }audioplay.swf?file='+musicurl+'pl.MP3&auto=yes&sendstop=yes&repeat=1&buttondir=${stc }audioplay&bgcolor=0xffffff&mode=playpause" quality="high" width="1" height="1" align="" type="application/x-shockwave-flash" />';
    	$("#music4").html(murl);
// 		if(browserId=="chrome"){
// 			var musicid = document.getElementById('music2');
// 	    	musicid.src=musicurl+"pl.wav";
// 		}
// 		else if(browserId=="msie"){
// 			var musicid = document.getElementById('music');
// 	    	musicid.src=musicurl+"pl.wav";
// 		}
	    setTimeout(function(){
	    	$(".clickbfend").show();
	    	isclickt=true;
	    },6000);
	    isclick=false;
	}
}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false' >
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/ydxx.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/ydxx.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
<div class="audiobox">
	<div class="bd clickbofang">
		 点击鼠标，开始播放本次录音
	</div>
	<div class="bd clickbfend" style="display: none;">
		 点击鼠标，开始播放选择音
	</div>
	<div class="bd clickreturn" style="display: none;">
		本测试结束,点击鼠标返回！
	</div>
<!-- 	<bgsound id="music" src='' volume='0' loop='1'/> -->
	<div id="music4"></div>
<audio id="music2" src="" autoplay="autoplay"></audio>
	<div class="imgbox" style="display: none;">
		<a href="#"><img src="${stc }audio/ydjy/cc1.bmp" lang="1"></a>
		<a href="#"><img src="${stc }audio/ydjy/cc2.bmp" lang="2"></a>
		<a href="#"><img src="${stc }audio/ydjy/cc3.bmp" lang="3"></a>
		<a href="#"><img src="${stc }audio/ydjy/cc4.bmp" lang="4"></a>
		<a href="#"><img src="${stc }audio/ydjy/cc5.bmp" lang="5"></a>
		<a href="#"><img src="${stc }audio/ydjy/cc6.bmp" lang="6"></a>
		<a href="#"><img src="${stc }audio/ydjy/cc7.bmp" lang="7"></a>
		<a href="#"><img src="${stc }audio/ydjy/cc8.bmp" lang="8"></a>
	</div>
</div>
<!--end-->
</body>
</html>
