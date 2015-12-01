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
<title>人格投射1</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/rgts1/rgcs2.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.imgbox{ position:absolute; width:610px; height:400px; left:50%; top:50%; margin-left:-305px; margin-top:-208px; display:none; font-size:20px;}
.imgbox .bd{ position:absolute; top:0%; width:100%; height:100%;text-align:center;}
.imgbox .title{font-size:16px; position:absolute; z-index:10; width:100%; bottom:50px; left:0;}
.imgbox .img{ text-align:center; position:absolute; width:100%; z-index:5; left:0;}
.imgbox .img img{ height:330px; }
</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }js/yellow.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
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
var imgurl = "${stc }images/rgts1/";
var question1=["他/她是一个镇定的人？","他/她是一个热情的人？","他/她是一个有支配欲的人？","他/她是一个谨慎的人？","他/她是一个爱幻想的人？","他/她是一个能和大家打成一片的人？","他/她是一个特立独行的人？","他/她是一个直爽的人？","他/她是一个讲究条理的人？","他/她是一个信任他人的人？ ","别人在算计我 ","走自己的路让别人说去吧","在行动之前要仔细权衡利弊 ","不能把怒气撒到不相关的人身上 ","直接批评他，他会不会记恨我 ","想到什么就做什么，何必给自己限定在框框内 ","真想找个时间自己一个人安静地呆着","把事情安排给别人来做更好 ","自己难以达到的梦想中的生活","面前的熟人要躲着他走"];
var question2=["深奥的哲学问题","当前的社会热点","国家的经济状况","探讨某项研究","探讨世界的未来","家庭问题 ","自己成长的经历"];
var question3=["c.jpg","a.jpg"];
var num=0;
var num1=0;
var time=0;
var isreturn=false;
var isclick=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					$(".imgbox").show();
					$(".tips").hide();
					isclick=true;
					questionchange(0);
					time=getNs();
				});
			});
		}, 8200);
		$("body").mousedown(function(e){
			if(isclick == true){
				if(e.which == 3){
			 	questionchange(1);
			 }
			 else if(e.which == 1){
			 	questionchange(0);
			 }
			}
			else{
				return false;
			}
		});
	});
	function questionchange(clickkey){
		var question_no=num+num1;;
		var student_choice=clickkey;
		var reaction_time=getNs()-time;
		if(num < question1.length){
			$("#imgurls").attr("src",imgurl+question3[0]);
			$("#question_title").text(question1[num]);
			if(num>0){
				$.post("<%=path%>/gray/personality/personalitysave",{"question_no":question_no,"student_choice":student_choice,"reaction_time":reaction_time,"imglength":"1"});
			}
			num = num + 1;
		}
		else{
			if(num1 >= question2.length){
				if(isreturn==false){
					questionend("2","heise","user/mokuai");
					$(".imgbox").hide();
					isreturn=true;
				}
					
				else{
					setpanduantimus("2","heise","<%=path%>/user/mokuai");
					$(".imgbox").hide();
				}
			}
			else{
				$("#imgurls").attr("src",imgurl+question3[1]);
				$("#question_title").text(question2[num1]);
			}
			if(num>0){
				$.post("<%=path%>/gray/personality/personalitysave",{"question_no":question_no,"student_choice":student_choice,"reaction_time":reaction_time,"imglength":"2"});
			}
			num1=num1+1;
		}
		time=getNs();
	}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false' >
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
		<div class="img"><img src="" id="imgurls"></div>
		<div class="title" id="question_title"></div>
	</div>
</div>
<jsp:include page="foot.jsp"/>
<!--end-->
</body>
</html>
