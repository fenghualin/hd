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
    <title>时间音程</title>
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
var music=["0.1-0.2.MP3","0.1-0.15.MP3","0.2-0.4.MP3","0.3-0.45.MP3","0.5-0.2.MP3","0.55-0.3.MP3"];
var mtime=[2,2,3,3,3,3];
var mdaan=[1,1,1,1,0,0];
var musicurl="${stc }audio/yc/";
var mnum=0;
var isclick=false;
var isclickt=false;
var isclicky=false;
var time=0;
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
			play_click();
		});
		$("body").mousedown(function(e){
			 if(e.which == 3){
			 	if(isclickt == true){
					datasub(1);
					if(mnum>5){
						setpanduantimus("2","heise","<%=path%>/user/mokuai");
						return false;
					}
					$(".clickbofang").show();
					$(".clickbfend").hide();
					isclick=true;
					isclickt=false;
					isclicky=true;
			 	}
			 	else if(isclicky == true){
			 		$(".clickbofang").hide();
					play_click();
			 	}
	         }
			 if(e.which == 1){
			 	if(isclickt == true){
					datasub(0);
					if(mnum>music.length){
						setpanduantimus("2","heise","<%=path%>/user/mokuai");
						return false;
					}
					$(".clickbofang").show();
					$(".clickbfend").hide();
					isclick=true;
					isclickt=false;
					isclicky=true;
			 	}
			 	else if(isclicky == true){
			 		$(".clickbofang").hide();
					play_click();
			 	}
	         }
		});
	});
function play_click(){
	if(isclick==true){
// 		var userAgent = navigator.userAgent.toLowerCase();
// 		var browserId = userAgent.match(/(firefox|chrome|safari|opera|msie)/)[1];
// 		var browserVersion = (userAgent.match(new RegExp('.+(?:version)[\/: ]([\\d.]+)')) || userAgent.match(new RegExp('(?:'+browserId+')[\/: ]([\\d.]+)')) || [0,'0'])[1];
// 		if(browserId=="chrome"){
// 			var musicid = document.getElementById('music2');
// 	    	musicid.src=musicurl+music[mnum];
// 		}
// 		else if(browserId=="msie"){
// 			var musicid = document.getElementById('music');
// 	    	musicid.src=musicurl+music[mnum];
// 		}
		var murl='<embed src="${stc }audioplay.swf?file='+musicurl+music[mnum]+'&auto=yes&sendstop=yes&repeat=1&buttondir=${stc }audioplay&bgcolor=0xffffff&mode=playpause" quality="high" width="1" height="1" align="" type="application/x-shockwave-flash" />';
    	$("#music4").html(murl);
	    setTimeout(function(){
	    	if(mnum > music.length){
	    		$(".clickreturn").show();
	    	}
	    	else{
	    		$(".clickbfend").show();
	    	}
	    	isclickt=true;
	    	time=getNs();
	    },mtime[mnum]*1000+2200);
	    mnum=mnum+1;
	    isclick=false;
	}
}
function datasub(clickkey){
	var question_no=mnum;
	var question_right = mdaan[mnum-1];
	var student_score=0;
	var student_choice = clickkey;
	var reaction_time = getNs()-time;
	if(clickkey == question_right){
		student_score=1;
	}
	$.post("<%=path%>/whatet/musiclength/musicLengthsave",{"question_no":question_no,"question_right":question_right,"student_score":student_score,"student_choice":student_choice,"reaction_time":reaction_time});
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
		播放结束，请选择
	</div>
	<div class="bd clickreturn" style="display: none;">
		本测试结束,点击鼠标返回！
	</div>
	<div id="music4"></div>
<!-- 	<bgsound id="music" src='' volume='0' loop='1'/> -->
<!-- <audio id="music2" src="" autoplay="autoplay"></audio> -->
</div>
<!--end-->
</body>
</html>
