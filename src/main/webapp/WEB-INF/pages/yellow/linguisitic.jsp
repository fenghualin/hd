<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    
  <title>语言能力测试</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/sxnl1.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000; font-size:20px;}
.comtip{ font-size:12px; color:#000; position:absolute; left:0; top:0; font-family:"宋体";}
.qusbox{ text-align:center; color:#222; font-size:16px; font-weight:400; font-family:"黑体"; width:510px; height:400px; position:absolute; left:50%; top:50%; margin-left:-255px; margin-top:-186px; display:none;}
.qusbox .bd{ position:relative; margin:0 auto; text-align:left; padding:40px 30px 0 30px; line-height:2;}
.qus{}
.qus ul{}
.qus ul li{color:#222; }
.qus a{ color:#222; text-decoration:none;}
.qus a:hover{ color:#f00;}
a{text-decoration: none;color:#000;}
.qus ul .disabled{
	color:gray!important;
}
</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js"></script>
<!--屏幕居中-->
<script>
	$(function(){
			var scheight = $(".fullscreen").height();
			$(".fullscreen").css("margin-top",-(scheight/2));
		});
</script>
<!--屏幕居中 end-->
<!--提示信息居中-->
<script>
	$(function(){
			var tipheight = $(".tips .bd").height();
			$(".tips .bd").css("margin-top",-(tipheight/2)) ;
		});
</script>
<!--提示信息居中 end-->

<script type="text/javascript">
var time;
var preTime=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					$(".qusbox").show();
					$(".tips").hide();
					ajaxquestion();
				});
			});
		}, 7500);
		$(".option_score1").click(function(){
			var option_score = $(this).attr("option_score");
			var question_no = $(this).attr("question_no");
			var time2= getNs();
			var reaction_time = time2-time;
			var test_no = parseInt($("#datatimu").attr("pagestart"))-1;
			time=time2;
			$.post("<%=path%>/yellow/testResult/Questiondatas",{"option_score":option_score,"question_no":question_no,"student_choice":"A","reaction_time":reaction_time,"test_no":test_no});
		});
		$.ajax({
			type: "POST",
			url: "/user/getXiaotijd",
			data: {},
			dataType: "json",
			success: function(data){
				if (!data[0]) {
					return ;
				}
				$("#datatimu").attr("pagestart", data[0].xiaotijd);
			},
			error: function() {
				
			}
		});
	});
	
function daansubmit(student_choice,option_score){
		if(preTime){
			return ;
		}
		var question_no = $(".txt").attr("question_no");
		var time2= getNs();
		var reaction_time = time2-time;
		var test_no = parseInt($("#datatimu").attr("pagestart"))-1;
		time=time2;
		$.post("<%=path%>/yellow/testResult/linguisiticSave",{"option_score":option_score,"question_no":question_no,"student_choice":student_choice,"reaction_time":reaction_time,"test_no":test_no,"kinds":2});
		ajaxquestion();
}
var sendajaxquestionning = false;
function ajaxquestion(){
	$(".txt").html("");
	$(".qus ul").html("");
	var pagestart = parseInt($("#datatimu").attr("pagestart"))+1;
	var pagesize = $("#datatimu").attr("pagesize");
	if(pagestart == parseInt($(".txt").attr("datacountnumber"))+1){
		questionend("2","hiese","<%=path%>/user/mokuai");
		$(".qusbox").hide();
		return ;
	}
	if (!sendajaxquestionning) {
		sendajaxquestionning = true;
		sendAjaxQuestion(pagestart, pagesize);
	}
	
}
function sendAjaxQuestion(pagestart, pagesize) {
	$.ajax({
		type: "POST",
		url: "/yellow/testResult/Questiondatas",
		data: {pagestart: pagestart, pagesize: pagesize},
		dataType: "json",
		success: function(data){
			if (pagestart == 1) {
				$(".txt").html("词语测试<br/>请在四个选项中选择一个最合适替换句子中<span style='color: red;'>红色字体</span>的词语。<br/><br/>" + data[0].question_text);
			} else if (pagestart == 2) {
				$(".txt").html("请在四个选项中选出最合适的一个词语填入句子。<br/><br/>" + data[0].question_text);
			} else {
				$(".txt").html(data[0].question_text);
			}
			
			
			$(".txt").attr("question_no",data[0].question_no);
			$(".txt").attr("datacountnumber",data[0].datacountnumber);
				for(var i =1 ;i<data.length;i++){
					$(".qus ul").append("<li><a href='javascript:daansubmit(\""+data[i].option_s+"\",\""+data[i].option_score+"\");'  class='disabled option_score"+i+"'>"+data[i].option_s+"　"+data[i].option_text+"</a></li>");
				}
				$("#datatimu").attr("pagestart",pagestart);
				preTime = true;
				setTimeout(function(){
				preTime = false;
				$(".qus ul a").removeClass("disabled");
			}, 2000);
			time=getNs();
			sendajaxquestionning = false;
		},
		error: function() {
			if (confirm("网络异常！获取下一题目失败，点击确定重试，取消重新答题")) {
				sendAjaxQuestion(pagestart, pagesize);
			} else {
				location.reload();
			}
		}
	});
}
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1" >
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/sxcy.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }sScripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/sxcy.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
	<div class="bd click_start">点击鼠标，开始测试</div>
</div>
<div class="qusbox">
	<div class="comtip">本小题没有时间限制</div>
	<div class="bd">
		 <div class="txt"><!-- 词语测试<br>
		 请在四个选项中选择一个最合适替换句子中<em style="color:red">红色字体</em>的词语。<br><br>
		 朱家角景区 的核心是“放生桥”，始建于明朝隆庆五年。<br>
取名“放生桥”，大概就是<em  style="color:red">警示</em>世人多积德吧。  --></div>	
		<div class="qus">
			 <ul>
			 	<!-- <li><a href="#">A 暗示</a></li>
				<li><a href="#">B 警告</a></li>
				<li><a href="#">C 告诫</a></li>
				<li><a href="#">D 劝慰</a></li> -->
			 </ul>
		</div>	
		<div style="display: none;" id="datatimu" pagestart="0" pagesize="1"></div>
	</div>
</div>

</body>
</html>
