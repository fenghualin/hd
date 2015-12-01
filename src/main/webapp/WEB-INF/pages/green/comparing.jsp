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
    
<title>目标比较</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/zc/bg.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.imgshows{ width:898px; height:574px; position:absolute; left:50%; top:50%; margin-left:-449px; margin-top:-279px; display:none; background:url(${stc }images/zc/bk.jpg) no-repeat;}
.imgshows img{ width:410px; height:547px;}
.imgs{ height:547px;width:410px; position:relative;}
.time{ font-size:11px; padding:-1px 0 0 5px;}
#img1{ position:absolute; left:10px; top:13px;} 
#img2{ position:absolute; right:10px; top:13px;}
.btn-skip{position:absolute; left:50%; bottom:-30px; width:80px; height:24px; margin-left:-40px;}
.di{ position:absolute; z-index:20; border-width:2px; border-style:solid; border-color:transparent; border-radius:50%;}
.d1{ width:52px; height:52px;right:0; top:4px; }
.d2{ width:18px; height:18px; right:153px; top:122px;}
.d3{ width:24px; height:24px; left:50px; top:148px;}
.d4{ width:24px; height:24px; left:163px; top:181px;}
.d5{ width:24px; height:24px; right:86px; top:192px;}
.d6{width:52px; height:52px; right:132px; top:197px;}
.d7{width:24px; height:24px; left:50px; top:289px;}
.d8{width:52px; height:52px; right:206px; bottom:75px;}
#img1 .img{ background:url(${stc }images/zc/2.jpg); width:410px; height:547px;}
#img2 .img{ background:url(${stc }images/zc/1.jpg); width:410px; height:547px;}
a{text-decoration: none;color:#000;}
</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js" type="text/javascript"></script>
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
var time=90;
var time2=0;
var dingshidy;
var isend=false;
var clickpd=0;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					if(isend==false){
						$(".imgshows").show();
						$(".tips").hide();
						dingshidy = setInterval("dingshizhixing()",1000);
						time2=getNs();
						isend=true;
					}
				});
			});
		}, 8300);
		
		$(".btn-skip").click(function(){
			questionend("2","heise","<%=path%>/user/mokuai");
			var times=getNs()-time2;
			//alert(click+"--"+right+"--"+times);
			$.post("<%=path%>/green/testTargetcompare/testTargetcomparesave",{"test_no":9,"count_click":click,"success_click":right,"reaction_time":times,"click":"true"});
			clearInterval(dingshidy);
		});
	});
	
function dingshizhixing(){
	if(time == 0){
		questionend("2","heise","<%=path%>/user/mokuai");
		var times=getNs()-time2;
		$.post("<%=path%>/green/testTargetcompare/testTargetcomparesave",{"test_no":9,"count_click":click,"success_click":right,"reaction_time":times,"click":"true"});
		clearInterval(dingshidy);
	}
	else{
		time = time - 1;
		$("#sytime").text(time);
	}
}
function datasubmit(){
	//alert("d");
}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/mbbj.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/mbbj.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
	<div class="bd click_start">点击鼠标，开始测试！</div>
</div>
<!--start-->
<div class="imgshows">
<div class="time">本小题剩余时间：<span id="sytime">90</span></div>
	<button class="btn-skip" type="button">跳过</button>
	<div class="imgs" id="img1">
		 <div class="di d1" lang="1" data-click="0"></div>
		 <div class="di d2" lang="2" data-click="0"></div>
		 <div class="di d3" lang="3" data-click="0"></div>
		 <div class="di d4" lang="4" data-click="0"></div>
		 <div class="di d5" lang="5" data-click="0"></div>
		 <div class="di d6" lang="6" data-click="0"></div>
		 <div class="di d7" lang="7" data-click="0"></div>
		 <div class="di d8" lang="8" data-click="0"></div>
		 <div class="img"></div>
	</div>
	<div class="imgs" id="img2">
		 <div class="di d1" lang="1" data-click="0"></div>
		 <div class="di d2" lang="2" data-click="0"></div>
		 <div class="di d3" lang="3" data-click="0"></div>
		 <div class="di d4" lang="4" data-click="0"></div>
		 <div class="di d5" lang="5" data-click="0"></div>
		 <div class="di d6" lang="6" data-click="0"></div>
		 <div class="di d7" lang="7" data-click="0"></div>
		 <div class="di d8" lang="8" data-click="0"></div>
		 <div class="img"></div>
	</div>  
	
</div>
<script>
var error=0;var right=0;
var mX=0;var mY=0;
var click=0;
var step=0;
var is_true="out";
function getPoint(obj) { //获取某元素以浏览器左上角为原点的坐标
    var t = obj.offsetTop; //获取该元素对应父容器的上边距
    var l = obj.offsetLeft; //对应父容器的上边距
    //判断是否有父容器，如果存在则累加其边距
    while (obj = obj.offsetParent) {//等效 obj = obj.offsetParent;while (obj != undefined)
        t += obj.offsetTop; //叠加父容器的上边距
        l += obj.offsetLeft; //叠加父容器的左边距
    }
 	return t+","+l;
 }

	$(function(){
		$("#img1 .di").click(function(e){
// 				alert(1);	
				//$(this).css("border-color","#2a8702");
				var l = $(this).attr("lang");
				if($(".d"+l).attr("data-click")=="1"){
				//alert($(this).attr("data-click"));
					return false;
				}
				$(".d"+l).css("border-color","#2a8702").attr("data-click","1");
				right = right + 1;
				is_true="in";
				clickAction(e,"img1");
			});
		$("#img1").click(function(e){
// 			alert("img1.click");

			clickAction(e,"img1");
		});
		$("#img2 .di").click(function(e){
// 				alert(2);	
				//$(this).css("border-color","#2a8702");
				var l = $(this).attr("lang");
				if($(".d"+l).attr("data-click")=="1"){
					return false;
				}
				$(".d"+l).css("border-color","#2a8702").attr("data-click","1");
				right = right + 1;
				is_true="in";
				clickAction(e,"img2");
			});
		$("#img2").click(function(e){
// 			alert("img2.click");	
			clickAction(e,"img2");
		});
	});

var process = false;		
function clickAction(e,imgid) {
	//clearInterval(dingshidy);
	//dingshidy = setInterval("dingshizhixing()",90000);
	if (process) return ;
	process = true;
	var times=getNs()-time2;
	if(is_true=="out"){
		error = error+1;
		if (error >= 50) {
			alert("错误超过50次，测试结束");
			$.post("<%=path%>/green/testTargetcompare/testTargetcomparesave",{"test_no":9,"count_click":click,"success_click":right,"reaction_time":times,"click":"true"});
			questionend("2","heise","<%=path%>/user/mokuai");
		}
		
		process = false;
		return false;
	}
	var b = getPoint(document.getElementById(imgid));
	
	b = b.split(",");
	mX=e.pageX-parseInt(b[1]);
	mY=e.pageY-parseInt(b[0]);
	var zuobiao="x="+mX+" y="+mY;
	step = step+1;
	if(step==9){
		questionend("2","heise","<%=path%>/user/mokuai");
		step=9;
		var times=getNs()-time2;
		$.post("<%=path%>/green/testTargetcompare/testTargetcomparesave",{"test_no":step,"count_click":error,"success_click":right,"reaction_time":times,"click":"true"});
		clearInterval(dingshidy);
		process = false;
		alert("已点击8次，测试结束。");
		return false;
	}
	$.post("<%=path%>/green/testTargetcompare/testTargetcomparesave",{"test_no":step,"zuobiao":zuobiao,"reaction_time":times,"is_true":is_true,"click":"false"}, function(){
		process = false;
		click=click+1;
		is_true="out";
	});
}	  		
</script>
<!--end-->
</body>
</html>
