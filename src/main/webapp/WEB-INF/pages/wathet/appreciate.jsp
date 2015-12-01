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
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
    <title>音乐鉴赏</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background: url(${stc }images/mbg-x.jpg) repeat-x center center #ededed ;}
.tips{}
.tips .bd{ color:#000;}
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.audiobox{text-align:center; display:none; width:100%; height:100%;}
.audiobox .bd{ position:absolute; height:auto; left:0%; top:50%; width:100%; text-align:center;font-size:24px;}
.audiobox .imgbox{position:absolute; top:50%; width:100%; margin-top:-40px; font-size:0; display:none;}
.audiobox .imgbox a{ display:inline-block; width:12%;}
.audiobox .imgbox a img{}
.audioqus{ position:absolute; width:100%; height:100%; display:none;font-size:18px;}
.audioqus .bd{position:absolute; left:50%; top:50%;}
.audioqus .title{ margin-bottom:30px;}
.audioqus .list{ line-height:1.6;}
.audioqus .list ul{}
.audioqus .list ul li{}
.audioqus .list ul li a{ color:#000; text-decoration:none;}
.audioqus .list input{ display:none;}
.audioqus .list label{ cursor:pointer;}
.bd ul li a{
	text-decoration: none;color:rgb(190, 186, 186);
}
.bd ul li a:hover{
	text-decoration: none;color:rgb(190, 186, 186);
}
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
var mtime=[57,51,56,73,59,64,61,67];
var mdaan=["3,2,1,4","4,2,0,2","2,1,3,1","5,2,2,0","4,1,3,2","0,2,4,3","1,2,0,4","4,2,2,1"];
var musicurl="${stc }audio/YYJS/";
var mnum=0;
var isclick=false;
var isclickt=false;
var time=0;
var isreturn=false;
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
	if(mnum>7){
		jinduok=1;
	}
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					$(".audiobox").show();
					$(".tips").hide();
					$(".clickbofang").hide();
					isclick=true;
					play_clicks();
				});
			});
		}, 9900);
		
		$("body").mousedown(function(e){
			$(".sds").text(mnum);
			if(jinduok==1){
				if(isreturn==false){
					$(".bd"+mnum).hide();
					$(".clickbofang").hide();
	    			$(".clickreturn").show();
	    			isreturn=true;
				}
				else{
					setpanduantimus("2","heise","<%=path%>/user/mokuai?load=yes");
				}
				return false;
			}
			 if(e.which == 3){
			 	if(isclickt==true){
			 		$(".clickbofang").hide();
			 		isclickt=false;
			 		isclick=true;
					play_clicks();
			 	}
	         }
			 if(e.which == 1){
			 	if(isclickt==true){
			 		$(".clickbofang").hide();
			 		isclickt=false;
			 		isclick=true;
					play_clicks();
			 	}
	         }
		});
		$(".bd a").click(function(){
			var isck = $(this).attr("isclick");
			if(isck == "ok"){
				var student_choice = $(this).attr("value");
				var student_score = mdaan[mnum-1].split(",");
				if(student_choice == "1"){
					student_score=student_score[0];
				}
				else if(student_choice == "2"){
					student_score=student_score[1];
				}
				else if(student_choice == "3"){
					student_score=student_score[2];
				}
				else if(student_choice == "4"){
					student_score=student_score[3];
				}
				$(".bd"+mnum).hide();
				$(".clickbofang").show();
				question_no=mnum;
				var reaction_time=getNs()-time;
// 				alert("question_no:"+question_no+"  student_score:"+student_score+"  student_choice:"+student_choice+"  reaction_time:"+reaction_time);
				$.post("<%=path%>/whatet/musicappreciate/musicAppreciatesave",{"question_no":question_no,"student_score":student_score,"student_choice":student_choice,"reaction_time":reaction_time});
				isclickt=true;
				if(mnum>7){
					jinduok=1;
				}
			}
 	});
});
function play_clicks(){
	if(isclick==true){
		var bdclass=mnum+1;
	    $(".bd"+bdclass).show();
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
	    	 $(".bd"+bdclass+" a").css("color","#000").attr("isclick","ok");
	    	 time=getNs();
	    },mtime[mnum]*1000+2000);
	    isclick=false;
	    mnum=parseInt(mnum)+1;
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
	<div class="bd clickreturn" style="display: none;">
		本测试结束,点击鼠标返回！
	</div>
	<div id="music4"></div>
	<bgsound id="music" src='' volume='0' loop='1'/>
<audio id="music2" src="" autoplay="autoplay"></audio>
	<div class="bd bd1" style="display: none;">
		<div class="title">以下是贝多芬钢琴曲《悲怆》第二乐章中的旋律，你认为乐曲表达了什么样的情绪？</div>
		<div class="list">
			<ul>
				<li><a href="#"  value="1" >A) 疑惑</a></li>
				<li><a href="#"  value="2" >B) 欣喜</a></li>
				<li><a href="#"  value="3" >C) 悲伤</a></li>
				<li><a href="#"  value="4" >D) 祈祷</a></li>
			</ul>
		</div>
	</div>
	<div class="bd bd2" style="display: none;">
		<div class="title">你认为以下旋律描写了什么？</div>
		<div class="list">
			<ul>
				<li><a href="#"  value="1" >A) 皎洁的月色</a></li>
				<li><a href="#"  value="2" >B) 夜色中的海面</a></li>
				<li><a href="#"  value="3" >C) 喧闹的市井</a></li>
				<li><a href="#"  value="4" >D) 幽静的田园</a></li>
			</ul>
		</div>
	</div>
	<div class="bd bd3" style="display: none;">
		<div class="title">以下乐曲你认为展现了什么场面？</div>
		<div class="list">
			<ul>
				<li><a href="#"  value="1" >A) 军队凯旋</a></li>
				<li><a href="#"  value="2" >B) 雷电交加</a></li>
				<li><a href="#"  value="3" >C) 乘风破浪</a></li>
				<li><a href="#"  value="4" >D) 重获自由</a></li>
			</ul>
		</div>
	</div>
	<div class="bd bd4" style="display: none;">
		<div class="title">以下是著名乐曲《梁祝》的选段，你认为这一段因以什么为题？</div>
		<div class="list">
			<ul>
				<li><a href="#"  value="1" >A) 结拜</a></li>
				<li><a href="#"  value="2" >B) 抗婚</a></li>
				<li><a href="#"  value="3" >C) 化蝶</a></li>
				<li><a href="#"  value="4" >D) 哭坟</a></li>
			</ul>
		</div>
	</div>
	<div class="bd bd5" style="display: none;">
		<div class="title">以下是著名的《自新大陆》中的旋律，你认为乐曲描写了什么？</div>
		<div class="list">
			<ul>
				<li><a href="#"  value="1" >A) 作者的乡愁</a></li>
				<li><a href="#"  value="2" >B) 静谧的夏夜</a></li>
				<li><a href="#"  value="3" >C) 甜美的梦境</a></li>
				<li><a href="#"  value="4" >D) 伟大的母爱</a></li>
			</ul>
		</div>
	</div>
	<div class="bd bd6" style="display: none;">
		<div class="title">你认为以下乐曲所描写的主人公是谁？</div>
		<div class="list">
			<ul>
				<li><a href="#"  value="1" >A) 清澈的泉水</a></li>
				<li><a href="#"  value="2" >B) 诙谐的小丑</a></li>
				<li><a href="#"  value="3" >C) 活泼的小狗</a></li>
				<li><a href="#"  value="4" >D) 温婉的姑娘</a></li>
			</ul>
		</div>
	</div>
	<div class="bd bd7" style="display: none;">
		<div class="title">你认为以下乐曲描写什么样的意境？</div>
		<div class="list">
			<ul>
				<li><a href="#"  value="1" >A) 风静沙平，鸿雁飞鸣</a></li>
				<li><a href="#"  value="2" >B) 静寂空山，丝丝鸟语</a></li>
				<li><a href="#"  value="3" >C) 南国风情，雨打芭蕉</a></li>
				<li><a href="#"  value="4" >D) 夕阳映照，万顷碧波</a></li>
			</ul>
		</div>
	</div>
	<div class="bd bd8" style="display: none;">
		<div class="title">以下乐曲你认为作者会题写什么曲名？</div>
		<div class="list">
			<ul>
				<li><a href="#"  value="1" >A) 军队进行曲</a></li>
				<li><a href="#"  value="2" >B) 狂欢节序曲</a></li>
				<li><a href="#"  value="3" >C) 诗人曲舞</a></li>
				<li><a href="#"  value="4" >D) 小步舞曲</a></li>
			</ul>
		</div>
	</div>
</div>
<script>
// 	$(function(){
// 			$(".audiobox").click(function(){
// 					$(this).hide();
// 					$(".audioqus").show(0,function(){
// 							var aw = $(".audioqus .bd").width();
// 							var ah = $(".audioqus .bd").height();
// 							$(".audioqus .bd").css("margin-top",-(ah/2));
// 							$(".audioqus .bd").css("margin-left",-(aw/2));
// 						});
// 				});
// 		});
</script>

<script>
	   
			
	 
</script>
<!--end-->
</body>
</html>