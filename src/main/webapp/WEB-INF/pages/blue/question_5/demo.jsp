<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", request.getContextPath());
	String basePath = "${stc }";
%>
<%
	request.setAttribute("basePath", basePath);
%>
<!doctype html>
<html>
<head>
<script type="text/javascript">if (location.href.indexOf("random") == -1) {location.href = location.href+"?random="+Math.random();}</script>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT"><META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<title>视空板</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background-color:#000;}
.Showimg{ text-align:center; width:100%; position:absolute; left:0; top:50%; margin-top:-75px; display:none;}
.Showimg img{ vertical-align:middle;}
.visualnb{ margin-left:-5px; margin-top:-5px;}
.visualnb button{ background-color:#f0f0f0; border:1px solid #000; border-radius:3px; width:30px; height:30px; margin-top:5px; margin-left:5px;}
.visualnb button.on{ background-color:#819cff;}
.btnok{ margin-top:20px;}
.btnok .btn-ok{ width:75px; height:28px; background-color:#f0f0f0; border:none;}
.btnok .btn-ok:active{ background-color:#fff;}
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
			$(".tips .bd").css("margin-top",-(tipheight/2)); 
		});
</script>
<!--提示信息居中 end-->

<script type="text/javascript">
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tip_start").show(function(){
				$(".tip_start").click(function(){
					startTest();
					$(".Showimg").show();
					$(".tip_start").hide();
				});
			});
			$("body").css("background-color","#120f57");
		}, 10000);
	});
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
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
<div class="tips tip_start">
	<div class="bd">点击鼠标，开始测试！</div>
</div>
<div class="tips tip_end">
	<div class="bd">测试结束，点击返回。</div>
</div>
<div class="Showimg" id="qiehuan">
	 <ul class="visualnb">
	 </ul>
	 <div class="btnok"><button class="btn-ok" onclick="submitQuestion()" disabled="disabled">确定</button></div>
</div>
<script type="text/javascript">
Array.prototype.contains = function(obj) { 
  var i = this.length; 
  while (i--) { 
    if (this[i] === obj) { 
      return true; 
    } 
  } 
  return false; 
};
</script>
<script type="text/javascript">
	var start_num = 3;//开始时候一排多少个方块
	var error_number = 0;//当前错误题数
	var curr_question = 1;//当前题目
	var question_num = 0;
	var showtime = 1000;//题目显示时间
	var answerTime;//答题时间
	var error_question = 0;//设置结束
	var count = start_num;
	var precount = 1;//准备时间(秒)，下一个数字出现的准备时间
	var clickTime;//按钮点击时间
	var question_number = 1;
	//开始数1000
	//var num_s = Math.pow(start_num*2, start_num - 1);
	
	window.test = {
		count : start_num,
		questions : new Array(),
		answers : new Array(),
		answerTime : new Array()
	};
	
	function startTest() {
		showQuestion();
	};
	
	function compact(v1,v2){
		if(v1<v2){
			return -1;
		}else if(v1>v2){
			return 1;
		}else{
			return 0;
		}
	}
	
	//显示一个数字
	function show() {
		//var generated = "";
		
		var the_question = new Array();
		if (start_num < 6) {
			for(var i = 1;i<=count;i++){
				var question = parseInt(Math.random()*(count*2) + 1);
				if(the_question.contains(question)){
					i--;
				}else{
					the_question[i-1] = question;
				}
			}
			start_num ++;
		} else {
			return null;
		}
		if(question_number < 3){
			question_number += 1;
		}else{
			count++;
			question_number = 1;
		}
		question_num++;
		//console.log(generated);
		return the_question;
	}
	
	function showQuestion() {
		var generated = show();
		//console.log(generated);
		if (generated == null) {
			//var data = {};
			//for ( var i = 0; i < window.test.questions.length; i++) {
			//	var q = (window.test.questions[i]).join('');
			//	var a = (window.test.answers[i]).join('');
			//	var aTime = window.test.answerTime[i];
				//console.log(error_question +"--"+ question_num);
			///	data[i] = {};
			///	data[i]["question"] = q;
			//	data[i]["answer"] = a;
			//	data[i]["question_no"] = (i + 1);
			//	data[i]["reaction_time"] = aTime;
			//	data[i]["range"] = (2.0 + (question_num - 3.0) / 3.0);
			//	data[i]["accuracy"] = (1.0 - error_question / question_num);
			///	data[i]["testNo"] = 0;
			///	data[i]["userId"] = 0;
			///	data[i]["reaction_choice"] = 0;
			//}/
			//console.log(data);
			//var returnData = JSON.stringify(data);
			//var url = "${path}/blue/question_5/ajaxSave";
			//$.post(url, {data : returnData}, function() {});
			$(".Showimg").hide();
			$(".tip_end").show(function(){
				$(".tip_end").click(function(){
					location.href="${path }/user/mokuai";
				});
			});
		} else {
			timer(function() {
				numShowTime = getNs();//答案显示时间
				var questionHtml = "<li>";
				generated.sort(compact);
				var count_sum = generated.length;
				for(var i = 0;i < count_sum*2;i++){
					var className = "";
					for(var j = 0;j < generated.length;j++){
						if((i+1) == generated[j]){
							className = "on";
						}
					}
					
					if(i == count_sum - 1){
						questionHtml += "<button onmouseup='addClassOn(this)' class='btn "+className+"' id='"+(i+1)+"'></button>";
						questionHtml += "</li>";
					}else if(i == count_sum){
						questionHtml += "<li>";
						questionHtml += "<button onmouseup='addClassOn(this)' class='btn "+className+"' id='"+(i+1)+"'></button>";
					}else{
						questionHtml += "<button onmouseup='addClassOn(this)' class='btn "+className+"' id='"+(i+1)+"'></button>";
					}
				}
				questionHtml += "</li>";
				
				$(".visualnb").html(questionHtml);
				$("#qiehuan").show();
				putQuestion(generated);
				setTimeout(function() {
					$(".visualnb").find("button").each(function(){
						$(this).removeClass("on");
					});
				}, showtime);
			}, precount);
		}
	}
	function timer(fn, sleepcount) {
		if (sleepcount <= 0) {
			$(".ShowImg").hide();
			fn();
		} else {
			$(".ShowImg").show();
			setTimeout(function() {
				sleepcount = sleepcount - 1;
				timer(fn, sleepcount);
			}, 1000);
		}
	}
	function getNs() {
		if (window.external.getNanoTime != undefined) {
			return window.external.getNanoTime;
		} else {
			return (new Date()).valueOf();
		}
	}
	function putQuestion(q) {
		window.test.questions[window.test.questions.length] = q;
	}
	function putAnswer(a) {
		window.test.answers[window.test.answers.length] = a;
	}
	function putAnswerTime(time) {
		window.test.answerTime[window.test.answerTime.length] = time;
	}
	function addClassOn(obj){
		if(($(".visualnb").find("button[class='btn on']").length)==($(".visualnb").find("button").length/2)){
			if($(obj).hasClass("on")){
				$(obj).toggleClass("on");
				$(".btn-ok").attr("disabled","disabled");
			}
			return;
		}
		$(obj).toggleClass("on");
		
		if(($(".visualnb").find("button[class='btn on']").length)==($(".visualnb").find("button").length/2)){
			$(".btn-ok").removeAttr("disabled");
		}
	}
	function submitQuestion(){
		
		var answer = new Array();
		$(".visualnb").find("button[class='btn on']").each(function(index,ement){
			answer[index] = $(this).attr("id");
		});
		clickTime = getNs();//用户点击时间
		answerTime = clickTime - numShowTime; //答题时间
		putAnswerTime(answerTime);
		putAnswer(answer);
		var the_question = window.test.questions[window.test.questions.length - 1];
		curr_question = the_question.join('');
		curr_answer = answer.join('');
		//计算连续错误次数
		if (curr_answer == curr_question) {
			error_number = 0;
			//、console.log("回答正确");
		} else {
			error_number += 1;
			error_question += 1;
			//console.log("回答错误");
		}
		//$(".inputNum").val(null);
		$(".btn-ok").attr("disabled","disabled");
		$("#qiehuan").find("button").removeClass("on");
		setTimeout(function() {
			showQuestion();
		}, 1000);
	}
</script>
</body>
</html>
