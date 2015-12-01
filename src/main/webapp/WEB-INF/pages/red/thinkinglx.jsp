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
   <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
    
   <title>思维转换能力</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:#000}
.tips{}
.tips .bd{ }
.imgshows{ width:100%; height:100%; position:absolute; left:0%; top:0%; display:none; }
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.imgshows .bd{ position:absolute; z-index:5; text-align:center; width:100%;  left:0; top:50%; margin-top:-100px;}
.imgshows .bd img{ width:150px; height:150px;}
.imgshows .bd .title{ color:#fff; font-size:26px; margin-bottom:20px;}
a{text-decoration: none;color:#000;}
</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js"></script>
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
var isreturn=false;
var isend=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					if (isend) return ;
					isend = true;
					$(".imgshows").show();
					$(".tips").hide();
					istrue=true;
					var yanshitime = yanshi[timujindu-1];
					if(yanshitime == 1)
						yanshitime = 1*1000;
					else if(yanshitime == 3)
						yanshitime = 1.5*1000;
					else 
						yanshitime = 2*1000;
					setTimeout("timuqiehuan('1')",yanshitime);
							});
						});
		}, 9000);
		
		$("body").mousedown(function(e){
			if(isreturn==true){
				setpanduantimus("lx","baise","<%=path%>/red/mainselect");
				return false;
			}
				if(e.which == 3){
					if(istrue == true){
				  		qiehuandy("1");
					}
			 	}
				 else if(e.which == 1){
				 	if(istrue == true){
				  		qiehuandy("0");
					}
			 	}
			else{
				return false;
			}
		});
	});



function timuqiehuan(clickkey){
// 	alert(timujindu);
	if(timujindu<6){
	var ti=parseInt(testtimu[timujindu])-1;
	var ashuzi = parseInt(a[ti])-1;
	var yaoqiu = Math.round(ti/2);
	if(yaoqiu==6)
		yaoqiu=5;
	var imgurl = c[ashuzi];
	aa = true;
	var question_no = timujindu;
	$(".tiyaoqiu").text(b[yaoqiu]);
	$(".titupian").html("<img src='"+$("#imgurl").text()+imgurl+"' />");
	timujindu = timujindu + 1;
	var yanshitime=yanshi[timujindu-1];
	if(time != ""){
			if(timujindu == 1){
				reaction_time = getNs()-time;
			}
			else {
				reaction_time = getNs() - time - yanshitime*1000;
			}
			time = getNs();
// 	$.post("<%=path%>/red/testThinking/testThinkingsave",{"question_no":question_no,"reaction_time":reaction_time,"reaction_chioce":clickkey,"delay":yanshitime,"is_true":daan[timujindu-2],"type":ti});
	}
	else {
		time = getNs();
	}
	}
}
function qiehuandy(clickkey){
	if(aa == true){
		aa = false;
		$(".tiyaoqiu").text("");
		$(".titupian").html("");
		var yanshitime = yanshi[timujindu-1];
		if(yanshitime == 1)
			yanshitime = 1*1000;
		else if(yanshitime == 3)
			yanshitime = 1.5*1000;
		else 
			yanshitime = 2*1000;
		if(clickkey!=daan[timujindu-1]){
			alert("回答错误！");
		}
		setTimeout("timuqiehuan("+clickkey+")",yanshitime);
	}
	else{
		alert("不要抢答！");
	}
	if(timujindu > 5 ){
// 		if($(".tips").css("display") == "block"){
// 			setpanduantimu("2");
// 		}
		//$(".tips .bd").html("<a href='javascript:' onclick='setpanduantimu(this.lang)' lang='3'>题目做完毕了,点击鼠标返回</a>");
		questionend("lx","baise","<%=path%>/user/mokuai");
		$(".imgshows").hide();
		$(".tips").show();
		isreturn=true;
		return false;
	}
}
	var istrue=false;
	var time="";
	var timujindu = 0;
	var testtimu=[6,5,3,8,4,9];
	var a=[1, 2, 2, 1, 2, 1, 1, 2, 3, 4, 5, 6];
	var b=["正方形在圆形之上","正方形在圆形之下","正方形不在圆形之上","正方形不在圆形之下","正方形","圆形"];
	var c=["11.bmp","22.bmp","33.bmp","44.bmp","55.bmp","66.bmp"];
	var yanshi=[2,1,2,1,3,1,3,2,2,3,1,3,1,3,1,3,1,1,2,2,3,3,1,1,2,1,2,2,3,1,3,2,3,2,3,2];
	var daan = [1,1,1,0,0,1,0,0,1,0,0,1,1,0,1,1,0,0,0,1,1,0,1,1,0,0,1,1,0,0,1,1,0,0,0,1];
	
	var aa=true;
	
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false' >
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/swzh.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示,请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/swzh.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
	<div class="bd">点击鼠标,开始测试！</div>
</div>

<!--start-->
<div class="imgshows">
	<div class="bd">
		<div class="title tiyaoqiu"></div>
		<div class="titupian"></div>
	</div>
</div>
<div id="imgurl" style="display:none;">${stc }images/swzh/</div>
<!--end-->
</body>
</html>
