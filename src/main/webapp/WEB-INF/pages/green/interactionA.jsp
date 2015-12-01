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
    
    <title>人际交往能力A</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/rj1/bk.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.qusshows{ width:910px; height:280px; font-size:14px; position:absolute;text-align:center; left:50%; top:50%; margin-left:-455px; margin-top:-120px; background-color:#f0f0f0; display:none;}
.qusshows .bd{ padding:50px 90px 0 90px; line-height:1.6; text-align:left;color:#181818;}
.qusshows .title{ margin-bottom:40px;}
.qusshows .quslist{}
.qusshows .quslist li{ font-size:14px;}
.qusshows .quslist li a{color:#181818; text-decoration:none; font-size:14px;}
.qusshows .quslist li a:hover{ color:#F00;}
.quslist ul .disabled{
	color:gray!important;
}
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
var time;
var preTime=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					$(".qusshows").show();
					$(".tips").hide();
					ajaxquestion();
				});
			});
		}, 8300);
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
		var question_no = $(".title").attr("question_no");
		var time2= getNs();
		var reaction_time = time2-time;
		var test_no = parseInt($("#datatimu").attr("pagestart"));
		time=time2;
		$.post("<%=path%>/green/TnteractionA/linguisiticSave",{"option_score":option_score,"question_no":question_no,"student_choice":student_choice,"reaction_time":reaction_time,"test_no":test_no,"kinds":4});
		ajaxquestion();
}
var sendajaxquestionning = false;
function ajaxquestion(){
	$(function(){
		$(".title").html("");
		$(".quslist ul").html("");
		var pagestart = parseInt($("#datatimu").attr("pagestart"))+1;
		var pagesize = $("#datatimu").attr("pagesize");
		if(pagestart == parseInt($(".title").attr("datacountnumber"))+1){
			questionend("2","heise","<%=path%>/user/mokuai");
			return ;
		}
		if (!sendajaxquestionning) {
			sendajaxquestionning = true;
			sendAjaxQuestion(pagestart, pagesize);
		}
		
	});
}

function sendAjaxQuestion(pagestart, pagesize) {
	$.ajax({
		type: "POST",
		url: "/green/TnteractionA/Questiondatas",
		data: {pagestart: pagestart, pagesize: pagesize},
		dataType: "json",
		success: function(data){
			$(".title").html(data[0].question_text);
			$(".title").attr("question_no",data[0].question_no);
			$(".title").attr("datacountnumber",data[0].datacountnumber);
				for(var i =1 ;i<data.length;i++){
					$(".quslist ul").append("<li><a href='javascript:daansubmit(\""+data[i].option_s+"\",\""+data[i].option_score+"\");' class='disabled option_score"+i+"'>"+data[i].option_s+"　"+data[i].option_text+"</a></li>");
				}
				$("#datatimu").attr("pagestart",pagestart);
				preTime = true;
				setTimeout(function(){
				preTime = false;
				$(".quslist ul a").removeClass("disabled");
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
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/rj1.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/rj1.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
<div class="qusshows">
	 <div class="bd" style="padding: 30px 90px 0 90px;">
	 		<div class="title" style="margin-bottom: 30px;"></div>
			<div class="quslist">
				<ul>
					<!-- <li><a href="#">A) 跟他聊一会儿，但心里觉得不痛快，也许过一阵子会好的。</a></li>
					<li><a href="#">B) 很讨厌这种当人一面背人一面的人，不想再理他了。</a></li>
					<li><a href="#">C) 仔细想想其实他也是针对事情，不是针对我，还是可以原谅的。</a></li>
					<li><a href="#">D) 觉得对这种人要以其人之道还治其人之身。</a></li> -->
				</ul>
			</div>
			<div style="display: none;" id="datatimu" pagestart="0" pagesize="1"></div>
	 </div> 
</div>
<!--end-->
</body>
</html>
