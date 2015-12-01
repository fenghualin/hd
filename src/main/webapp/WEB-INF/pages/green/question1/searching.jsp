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
<meta content="IE=edge" http-equiv="X-UA-Compatible">    
<title>目标搜索</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/zrrz/mbss.jpg) no-repeat center center;}
.tips{}
button{cursor: pointer}
.tips .bd{ color:#000;}
.imgshows{ width:828px; height:555px; position:absolute; left:50%; top:50%; margin-left:-414px; margin-top:-257px; display:none;}
.imgs{ height:100%; position:relative;}
.time{position:absolute; font-size:12px;top:-20px; padding:0px 0 0 5px;}
.imgshows .btns{ position:absolute; bottom:22px; left:166px; font-size:0; }
.imgshows .btns button{ width:44px; height:44px;margin-right:20px; background-color:#00c500; text-align:center; border:1px solid #09b20d; font-size:24px; color:#fff; font-weight:bold;}
.imgshows .btns button:active{ background-color:#09b20d;}
#img1{ background:url(${stc }images/zrrz/1.jpg) no-repeat;}
#img2{background:url(${stc }images/zrrz/2.jpg) no-repeat;}
#img3{background:url(${stc }images/zrrz/3.jpg) no-repeat;}
#img4{background:url(${stc }images/zrrz/4.jpg) no-repeat;}
a{text-decoration: none;color:#000;}
</style>
<script src="${stc }js/jquery.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js" type="text/javascript"></script>
<script>
	$(function(){
			var scheight = $(".fullscreen").height();
			$(".fullscreen").css("margin-top",-(scheight/2))
		})
</script>
<script>
	$(function(){
			var tipheight = $(".tips .bd").height();
			$(".tips .bd").css("margin-top",-(tipheight/2)) 
		})
</script>
<script type="text/javascript">
var time;
var timu=1;
var cleartime;
var isend=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					if(isend){
						return ;
					}
					$(".imgshows").show();
					$(".tips").hide();
					time = getNs();
					cleartime = setInterval("dstime()",1000);
					isend=true;
				});
			});
		}, 8300);
		$("#img1 button").click(function(){
			$("#img2").show();
			$("#img1").hide();
		});
		$("#img2 button").click(function(){
			$("#img3").show();
			$("#img2").hide();
			var img2butval = $(this).val();
		});
		$("#img3 button").click(function(){
			$("#img4").show();
			$("#img3").hide();
			var img3butval = parseInt($(this).val());
			var reaction_time = getNs()-time;
			var student_score;
			var student_choice;
			if(img3butval <= 6){
				student_score=img3butval;
				student_choice=img3butval;
			}
			else{
				student_choice=img3butval;
				student_score = 6-(img3butval-6);
			}
			$.post("<%=path%>/green/testsearch/saveTestSearch",{"reaction_time":reaction_time,"student_score":student_score,"student_choice":student_choice,"question_no":"1"});
			time=getNs();
			timu=2;
			$("#sytime").text(90);
		});
		$("#img4 button").click(function(){
			questionend("2","heise","<%=path%>/user/mokuai");
			$("#img4").css("background","none");
			var img4butval = parseInt($(this).val());
			var reaction_time = getNs()-time;
			var student_score;
			var student_choice;
			if(img4butval <= 9){
				student_score=img4butval;
				student_choice=img4butval;
			}
			else{
				student_choice=img4butval;
				student_score = 9-(img4butval-9);
			}
			$.post("<%=path%>/green/testsearch/saveTestSearch",{"reaction_time":reaction_time,"student_score":student_score,"student_choice":student_choice,"question_no":"2"});
		});
	});
	function dstime(){
		var sytime = parseInt($("#sytime").text());
		if(sytime == 0){
			var reaction_time = getNs()-time;
			var img4butval = 0 ;
			var student_score=0;
			var student_choice=0;
			if(timu==1){
				$("#img4").show();
				$("#img3").hide();
				$.post("<%=path%>/green/testsearch/saveTestSearch",{"reaction_time":reaction_time,"student_score":student_score,"student_choice":student_choice,"question_no":"1"});
				timu=2;
				time=getNs();
				$("#sytime").text("90");
			}
			else if(timu==2){
				$("#img4").css("background","none");
				questionend("2","heise","<%=path%>/user/mokuai");
				$.post("<%=path%>/green/testsearch/saveTestSearch",{"reaction_time":reaction_time,"student_score":student_score,"student_choice":student_choice,"question_no":"2"});
				$("#sytime").text("-1");
				timu=3;
				clearInterval(cleartime);
			}
			return false;
		}
		$("#sytime").text(sytime-1);
}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/mbss.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/mbss.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
						<!--<![endif]-->
						<param name="quality" value="high">
						<param name="wmode" value="opaque">
						<param name="swfversion" value="7.0.70.0">
						<param name="expressinstall" value="Scripts/expressInstall.swf">
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
	<div class="time">本小题剩余时间：<span id="sytime">90</span></div>
	<div class="imgs" id="img1" style="display:none;">
		<div class="btns">
			<button type="button" value="4">4</button>
			<button type="button" value="6">6</button>
			<button type="button" value="5">5</button>
			<button type="button" value="8">8</button>
		</div>
	</div>
	<div class="imgs" id="img2" style="display:none;">
		<div class="btns">
			<button type="button" value="10">10</button>
			<button type="button" value="6">6</button>
			<button type="button" value="7">7</button>
			<button type="button" value="9">9</button>
		</div>
	</div>
	<div class="imgs" id="img3" >
		<div class="btns">
			<button type="button" value="11">11</button>
			<button type="button" value="3">3</button>
			<button type="button" value="4">4</button>
			<button type="button" value="6">6</button>
			<button type="button" value="9">9</button>
			<button type="button" value="8">8</button>
			<button type="button" value="5">5</button>
			<button type="button" value="2">2</button>
			<button type="button" value="7">7</button>
			<button type="button" value="10">10</button>
		</div>
	</div>
	<div class="imgs" id="img4"  style="display:none;">
		<div class="btns">
			<button type="button" value="11">11</button>
			<button type="button" value="3">3</button>
			<button type="button" value="8">8</button>
			<button type="button" value="6">6</button>
			<button type="button" value="9">9</button>
			<button type="button" value="7">7</button>
			<button type="button" value="5">5</button>
			<button type="button" value="2">2</button>
			<button type="button" value="4">4</button>
			<button type="button" value="10">10</button>
		</div>
	</div>	
</div>
<!--end-->
</body>
</html>

