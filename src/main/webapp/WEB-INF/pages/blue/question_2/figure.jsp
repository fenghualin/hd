<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% request.setAttribute("path", request.getContextPath()); 
	String basePath = "${stc }";
%>
<% request.setAttribute("basePath", basePath); %>
<!doctype html>
<html>
<head>
<script type="text/javascript">if (location.href.indexOf("random") == -1) {location.href = location.href+"?random="+Math.random();}</script>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT"><META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<title>图形匹配</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ }
.Showimg{ text-align:center; width:100%;height:100%; position:absolute; left:0; top:50%; margin-top:-75px; display:none;}
.Showimg img{ vertical-align:middle;}
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
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tip_start").show(function(){
				$(".tip_start").click(function(){
					$(".Showimg").show();
					$(".tip_start").hide();
					
				});
			});
		}, 10000);
	});
</script>
</head>
<body  oncontextmenu='return false' ondragstart='return false' >
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/zyclq.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/zyclq.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
<div class="tips tip_start">
	<div class="bd">点击鼠标，开始测试！</div>
</div>
<div class="tips tip_end">
	<div class="bd">测试结束，点击退出！</div>
</div>
<div class=""></div>
<div class="Showimg" onmousedown="mousedown(event);">
	<img id="" src="${stc }images/txpp/10.jpg">
	<img id="" src="${stc }images/txpp/11.jpg">
</div>
<script>
	var type_array = new Array(
		2,4,4,2,1,4,2,2,1,2,1,3,3,1,3,3,4,3,1,4,3,2,2,3,4,1,1,2,2,3,1,4,3,1,1,3,2,2,1,4,3,4,4,3,4,4,2,1
	);
	
	var delay_array = new Array(
		2,1,2,1,2,3,1,1,1,3,3,2,3,1,1,1,1,2,1,3,3,2,3,2,2,3,2,2,2,3,1,3,3,2,3,1,3,3,3,2,1,1,1,2,3,2,2,2
	);
	
	var question_array = new Array(
		34,58,74,90,55,70,34,12,11,56,55,17,35,99,39,19,38,79,33,50,15,78,12,37,36,99,77,56,12,57,77,52,13,11,11,13,90,34,33,54,79,76,14,15,32,98,78,33
	);
	//3|4,5|8,74,9|0,5|5,7|0,3|4,1|2,1|1,5|6,5|5,1|7,3|5,9|9,3|9,1|9,3|8,7|9,3|3,5|0,1|5,7|8,1|2,3|7,3|6,9|9,7|7,5|6,1|2,5|7,7|7,5|2,1|3,1|1,1|1,1|3,9|0,3|4,3|3,5|4,7|9,7|6,1|4,1|5,3|2,9|8,7|8,3|3
	
	var answer_array = new Array(
		1,0,0,1,1,0,1,1,1,1,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1,0,0,0,0,0,0,0,1,1
	);
	
	var answers = new Array();
	
	var imgPath = "${stc }images/txpp/";
	var curr_index = 0;
	var sleep = 1000;
	var timestart;
	var aquestionend = false;
	var process = false;
	var iswancheng=false;
	var answer;
	
	var show = function(curr_question){
		var question_now = new Array();
		question_now = curr_question.toString().split("");
		
		for(var i = 0;i < question_now.length;i++){
			$(".Showimg").find("img").each(function(index,ement){
				if(i == index){
					$(this).attr("src",imgPath+question_now[i]+".jpg");
				}
			});
		}
		$(".Showimg img").show();
	};
	$.ajax({
		type: "POST",
		url: "/user/getXiaotijd",
		data: {},
		dataType: "json",
		success: function(data){
			if (!data[0]) {
				return ;
			}
			curr_index = data[0].xiaotijd;
		},
		error: function() {
			
		}
	});
	var showAQuestion = function() {
		aquestionend = true;
		process = true;
		if (curr_index < question_array.length) {
			var q = question_array[curr_index];		
			setTimeout(function(){
				show(q);
				process = false;
				timestart = getNs();
			}, sleep);
			curr_index ++;
		} else {
			//alert("测试完毕");
			$.post("${path}/user/savejindu",{"vals":"2"},function(data){});	
			$(".Showimg").hide();
			$(".tip_end").show(function(){
				$(".tip_end").click(function(){
					if(iswancheng==false){
						//$.post("${path}/user/savejindu",{"vals":"2"},function(data){
								location.href="${path }/user/mokuai";
						//	});		
						iswancheng=true;
					}
				});
			});
			isend = true;
		}
	};
	
	var timer = function(fn,sleepcount) {
		if (sleepcount <= 0) {
			fn();
		} else {
			setTimeout(function(){
				sleepcount = sleepcount -1;
				timer(fn,sleepcount);
			}, 1000);
		}
	};
	
	var startTest = function () {
		isend = false;
		timer(function(){
			showAQuestion();
		}, 3);
	};
	
	var formatTime = function (formatValue){
		formatValue = formatValue+"";
		var lastText = formatValue.substring(formatValue.length - 3,formatValue.length);
		var startText = formatValue.substring(0,formatValue.length - 3);
		var theValue = startText+"&nbsp;"+lastText;
		return theValue;
	};
	
	var mousedown = function (e){
		if (isend) return ;
		$(".Showimg img").hide();
		if (!aquestionend || process) {
			/*$(".errorbox .txt").html("回答错误");
			$(".errorbox").show(function(){
				$(".errorbox button").click(function(){
					$(".errorbox").hide();
				});
			});*/
			alert("请不要抢答");
			return ;
		}
		process = true;
		aquestionend = false;
		var timeend = getNs();
		var timeuse = timeend - timestart;
		var btnNum = mousedown_(e);
		if (btnNum==2){
			answer = 1;
	  	}
		else if(btnNum==0 || btnNum==1){
			answer = 0;
	  	}
		answers[answers.length] = answer;
		var q = answer_array[curr_index-1];
		var iszq = false;
		if (q == answer) {
			iszq = true;
		}
		var student_choice = 0;
		if (iszq) {
			student_choice = 1;
		} else {
			/*$(".errorbox .txt").html("回答错误");
			$(".errorbox").show(function(){
				$(".errorbox button").click(function(){
					$(".errorbox").hide();
				});
			});*/
			alert("回答错误");
		}
		
		var data = {};
		data["testNo"] = 0;
		data["userId"] = 0;
		data["questionNo"] = curr_index;
		data["reactionTime"] = timeuse;
		data["reactionChoice"] = student_choice;
		data["delay"] = delay_array[curr_index-1];
		data["isTrue"] = iszq;
		data["position"] = question_array[curr_index-1];
		
		$.post("${path}/blue/question_2/ajaxSave",data);
		
		aquestionend = true;
		showAQuestion();	//下一个数字
	};
	
	var getNs = function () {
		if(window.external.getNanoTime != undefined){
			return window.external.getNanoTime;
		}else{
			return (new Date()).valueOf()*1000*1000;
		}
	};
	
	var mousedown_ = function (e) {
		var e = e || arguments.callee.caller.arguments[0];
		if(e == "undefined"){
			e = new Object;
		}
		var btnNum = e.button;
		return btnNum;
	};
	
	$(function(){
		startTest();
		mousedown_(null);
		setTimeout(function(){
			$("#loading").hide();
		}, 3000);
	});
</script>
<div class="errorbox" style="display: none;">
	<div class="bd">
		<div class="txt"></div>
		<div class="btns"><button type="button">Enter</button></div>
	</div>
	<div class="mask"></div>
</div>
</body>
</html>
