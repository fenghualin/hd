<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<title>人格投射2</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/rgts2/rgcs2.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.imgbox{ position:absolute; width:610px; height:400px; left:50%; top:50%; margin-left:-305px; margin-top:-208px; display:none; font-size:20px;}
.imgbox .bd{ position:absolute; top:0%; width:100%; height:100%;text-align:center;left:0px;}
.imgbox .title{font-size:14px; position:absolute; z-index:10; width:100%; bottom:110px; line-height:1.6}
.imgbox .dati{font-size:14px; position:absolute; z-index:10; width:100%; bottom:80px; line-height:1.6}
.imgbox .img{ text-align:center; position:absolute; width:100%; z-index:5;}
.imgbox .img img{ height:330px; }
.datibox{width:800px;background-color: #fff;z-index: 99;bottom: 0px;margin:auto;text-align: center;display: none;position: absolute;}
.dati input{margin-left:20px;}
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
var istrue=false;
var b="";
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
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").mousedown(function(){
					$(".imgbox").show();
					$(".tips").hide();
					setTimeout(function(){
						$(".imgbox").hide();
						var content = $("#textval").val();
						$.post("<%=path%>/rgtst/rgtstsave",{"content":content});
						questionend("2","heise","<%=path%>/user/mokuai");
					},360000);
					istrue=true;
				});
			});
		}, 8200);
		$("#but_dati").mousedown(function(e){
			var height=$(document).height()-e.pageY-20;
			var margin_left=($(document).width()-800)/2;
			$(".datibox").css({"height":height,"left":margin_left});
			$(".datibox").show();
		});
		$("#textval").focus(function(){
			if($(this).attr("data-sta")==0){
				$(this).val("");
			}
			else{
				return ;
			}
		});
		$("#textval").change(function(){
			$(this).attr("data-sta",1);
		});
		$("#but_tijiao").click(function(){
			var content = $("#textval").val();
			var re = window.confirm("确认提交！");
			if(re){
				$.post("<%=path%>/rgtst/rgtstsave",{"content":content});
				setpanduantimus("2","heise","<%=path%>/user/mokuai");
			}
		});
// 		$("body").mousedown(function(e){
// 			if(istrue == true){
// 				var re = window.confirm("确认提交！");
// 				if(re){
// 					setpanduantimus("2","heise","<%=path%>/user/mokuai");
// 				}
// 			}
// 		});
	});
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/rgts1.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/rgts2.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
	<div class="bd">
		<div class="time">本小题没有时间限制</div>
		<div class="img" style="left:0;"><img src="${stc }images/rgts2/g.jpg"></div>
		<div class="title" style="left:0;">从这个图片中你能立刻联想到什么？<br>请点击答题按钮，将答题填写在文本框内</div>
		<div class="dati" style="left:0;">
			<input type="button" id="but_dati" value="答题" />
			<input type="button" id="but_tijiao" value="提交" />
		</div>
	</div>
</div>
<div class="datibox" id="datibox" style="">
	<textarea id="textval" data-sta="0" style="width: 100%;height:300px;">把你联想的写在这里。。。</textarea>
</div>
<!--end-->
</body>
</html>
