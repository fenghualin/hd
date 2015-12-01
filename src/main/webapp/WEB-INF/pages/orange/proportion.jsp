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
    <title>空间比例判断</title>
    <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/kjbl/bk.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.imgshows{ width:946px; height:608px; position:absolute; left:50%; top:50%; margin-left:-473px; margin-top:-295px; display:none; }
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.imgshows .bd{ position:absolute; z-index:5; text-align:center;left:50%; top:50%;  width:800px; height:600px; margin-left:-400px; margin-top:-300px;}
.imgshows .bd img{ height:600px; width:800px;}
.imgshows .bd .title{ color:#fff; font-size:26px; margin-bottom:20px;}
.imgshows .btns{ position:absolute; bottom:45px; left:0; width:100%; z-index:10; text-align:center;}
.imgshows .btns .btn{ width:100px; height:40px; display:inline-block; margin:0 20px;}
a{text-decoration: none;color:#000;}
.a{}
.b{}
.c{}
.d{}
</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js"></script>
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
var time=0;
var url="${stc }images/kjbl/";
var questionimg=["1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg"];
var questanswer=[2,3,2,1,1,2];
var isend=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					if(isend==false){
						$(".imgshows").show();
						$(".tips").hide();
						imgqiehuan();
						isend=true;
					}
				});
			});
		}, 9000);
		$(".btns a").click(function(){
			var student_choice="";
			var vals=$(this).attr("vals");
			if(vals=="A")
				student_choice=0;
			else if(vals=="B")
				student_choice=1;
			else if(vals=="C")
				student_choice=2;
			else if(vals=="D")
				student_choice=3;
				
			var lang = parseInt($("#imgid").attr("lang"))-1;
			var reaction_time=getNs()-time;
			var question_answer=0;
			if(questanswer[lang]==student_choice){
				question_answer=1;
			}
			else{
				question_answer=0;
			}
			var question_no = $("#imgid").attr("lang");
			$.post("<%=path%>/orange/testPainting/testPaintingsave",{"student_choice":student_choice,"reaction_time":reaction_time,"question_answer":question_answer,"question_no":question_no},function(data){
				if(data == "ok"){
					imgqiehuan();
				}
			});
		});
	});
function imgqiehuan(){
	var lang = parseInt($("#imgid").attr("lang"));
	if(lang>5){
		$("#imgid").attr({"lang":lang+1}).removeAttr("src");
		//$(".tips .bd").html("<a href='javascript:' onclick='setpanduantimu(this.lang)' lang='3'>题目做完毕了,点击鼠标返回</a>");
		questionend("2","heise","<%=path%>/user/mokuai");
		isend=true;
		$(".imgshows").hide();
		$(".tips").show();
	}
	else{
		$("#imgid").attr({"src":url+questionimg[lang],"lang":lang+1});
	}
	time=getNs();
}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/kjbl.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/kjbl.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
		 <img src="" lang="0" id="imgid">
	</div>
	<div class="btns">
		<a class="btn a" vals="A" href="#"><img src="${stc }images/blank.gif" width="100" height="40"/></a>
		<a class="btn b" vals="B" href="#"><img src="${stc }images/blank.gif" width="100" height="40"/></a>
		<a class="btn c" vals="C" href="#"><img src="${stc }images/blank.gif" width="100" height="40"/></a>
		<a class="btn d" vals="D" href="#"><img src="${stc }images/blank.gif" width="100" height="40"/></a>
	</div>
</div>
<!--end-->
</body>
</html>
