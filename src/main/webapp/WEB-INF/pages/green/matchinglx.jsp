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
<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<meta http-equiv="X-UA-Compatible" content="IE=9;IE=8;IE=7;" />
    
    <title>目标拼图练习</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css"/>
<link rel="stylesheet" type="text/css" href="${stc }css/css.css"/>
<script type="text/javascript" src="${stc }js/jquery1.42.min.js"></script>


<script src="${stc }js/yellow.js" type="text/javascript"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<!--
<script src="${stc }js/demo_files/kit.js"></script>
<script src="${stc }js/demo_files/event.js"></script>
<script src="${stc }js/demo_files/dom.js"></script>
<script type="text/javascript" async="" src="${stc }js/demo_files/ga.js"></script>
-->
<link rel="stylesheet" href="${stc }js/demo_files/demo.css"/>
    <style>
body{ background:url(${stc }images/Puzzle2/bk.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.imgshows, .imgshows_ss{ width:830px; height:555px; position:absolute;text-align:center; left:50%; top:50%; margin-left:-415px; margin-top:-257px; background-color:#f0f0f0; display:none;}
.imgshows{}
.imgmain{ height:100%;width:100%; position:relative; text-align:center;}
.imgmain img{ height:400px;width:400px; position:absolute; left:50%; top:50%; margin-left:-200px; margin-top:-200px;}
#img1{ position:absolute; left:10px; top:13px;} 
#img2{ position:absolute; right:10px; top:13px;}
.btn-skip{position:absolute; left:50%; bottom:-30px; width:80px; height:24px; margin-left:-40px;}
a{text-decoration: none;color:#000;}
#moveable{
	width:780px;margin:auto;margin-top:80px;
}
#moveable td{
border:1px solid #999;
width:92px;
height:92px;

}
#moveable td div{
width:92px;height:92px;
cursor: move;
}
</style>
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
var jindu=0;
var currHtml;
var before;
var step=0;
var score = 0;
var time=0;
var time2=0;
var isend=false;
var bodyclick=false;
$(function(){
	setTimeout(function(){
	$("#swf1").hide();
	$(".tips").show(function(){
			$(".tips").click(function(){
				if(isend==false){
					$(".imgshows").show();
					$(".tips").hide();
					setTimeout(function(){
						$(".imgshows_ss").show();
						$(".tips .bd").html("<a href='/user/mokuai' lang='3'>练习完毕，点击返回</a>");
						$(".imgshows").hide();
						daluansunxu();
					},8000);
					isend=true;
				}
			});
		});
	}, 8300);
	$(document).click(function(){
		if(bodyclick){
			bodyclick = false;
			location.href = "/user/mokuai?" + Math.random();
		}
	});
});
</script>
</head>
 <body oncontextmenu="return false" ondragstart="return false">
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/mbpt.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/mbpt.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
	 <div class="imgmain"><img src="${stc }images/Puzzle2/1_lx.jpg"/></div>
</div>
<div class="imgshows_ss" style="display:none;">
    	<div id="moveable">
    	<table style="float:left;" id="movescore">
<!--     		<tbody> -->
<!--     			<tr> -->
<!-- 					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td> -->
<!-- 					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td> -->
<!-- 					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td> -->
<!--     			</tr> -->
<!--     			<tr> -->
<!-- 					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td> -->
<!-- 					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td> -->
<!-- 					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td> -->
<!--     			</tr> -->
<!--     			<tr> -->
<!-- 					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td> -->
<!-- 					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td> -->
<!-- 					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td> -->
<!--     			</tr> -->
<!--     		</tbody> -->
    	</table>
    	<table style="float:left;" id="suijitupian">
    		<!-- <tbody>
    			<tr>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data1" style="background-position: 0 0;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data3" style="background-position: 92 0;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data2" style="background-position: 184 0;"></div></td>
    			</tr>
    			<tr>
    				<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data7" style="background-position: 0 92;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data4" style="background-position: 0 184;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data5" style="background-position: 184 184;"></div></td>
					
    			</tr>
    			<tr>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data6" style="background-position: 92 184;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data8" style="background-position: 184 92;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data9" style="background-position: 92 92;"></div></td>
    			</tr>
    		</tbody> -->
    	</table>
    	</div>
		
		<div style="width:830px;overflow: hidden;margin-top:20px;float:left;"> <input type="button" id="xiayiti" disabled="disabled"  value="完成练习"  /></div>
		<script>
			$("#xiayiti").click(function(){
					$(".imgshows_ss").hide();
					$(".tips").show();
					setTimeout(function(){
						bodyclick=true;
					},500);
			});
var imgarr = [[0,0],[92,0],[184,0],[0,92],[92,92],[184,92],[0,184],[92,184],[184,184]];
function randomsort(a, b) {
    return Math.random()>.5 ? -1 : 1;//用Math.random()函数生成0~1之间的随机数与0.5比较，返回-1或1
}
function daluansunxu(){
	var context="<tbody>";
	var context2="<tbody>";
		imgarr.sort(randomsort);
		var z=0;
		for(var i=0;i<3;i++){
			context=context+"<tr>";
			context2=context2+"<tr>";
			for(var y=0;y<3;y++){
				context=context+"<td onmousedown='imageDown(this)' onmouseup='imageUp(this)'><div id='data"+(z+1)+"' style='background:url(${stc }images/Puzzle2/1_lx.jpg);background-position: "+imgarr[z][0]+"px "+imgarr[z][1]+"px;'></div></td>";
				context2=context2+"<td onmousedown='imageDown(this)' onmouseup='imageUp(this)'></td>";
				z=z+1;
			}
			context=context+"</tr>";
			context2=context2+"</tr>";
		}
		$("#movescore").html(context2);
		$("#suijitupian").css("margin-left","50px");
		$("#moveable").css("width","610px");
		context=context+"</tbody>";
		context2=context2+"</tbody>";
		$("#suijitupian").html(context);
		$("#movescore").html(context2);
	currHtml;
	before;
	step=0;
	score = 0;
	time=getNs();
	time2=0;
}
function imageDown(thiss) {
	currHtml = thiss.innerHTML;
	before = thiss;
}
function imageUp(thiss) {
	if (thiss.innerHTML) {
		return false;
	}
	before.innerHTML = "";
	thiss.innerHTML = currHtml;
	checkComplete();
	step=step+1;
	if(step==1){
		time2=getNs()-time;
	}
	$("#xiayiti").removeAttr("disabled");
}
function checkComplete() {
	var divs = document.getElementById("movescore").getElementsByTagName("div");
	if (divs.length < 9) {
			return false;
	}
	score = 0;
	for (var i=0; i<divs.length; i++) {
		if (divs[i].getAttribute("id") != "data"+(i+1)) {
			return false;
		} else {
			score ++;
		}
	}
}
		</script>
</div>
<!--end-->
</body>
</html>


