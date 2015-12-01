<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", request.getContextPath());
%>
<!doctype html>
<html>
<head>
<script type="text/javascript">if (location.href.indexOf("random") == -1) {location.href = location.href+"?random="+Math.random();}</script>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT"><META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<title>选择</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script type="text/javascript" src="${stc }js/yellow.js"></script>
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
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$("#tips_1").show(function(){
				$("#tips_1").click(function(){
					setTimeout(function(){
						startTest();
					},500);
					$("#play").show();
					$("#tips_1").hide();
				});
			});
		}, 10000);
	});
</script>
</head>
<body style=" background:#000 url(${stc}images/b100.png) no-repeat center top; " oncontextmenu="return false" ondragstart="return false">
	<div class="fullscreen" id="swf1">
		<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
			<param name="movie" value="${stc }swf/zyclq.swf">
			<param name="quality" value="high">
			<param name="wmode" value="opaque">
			<param name="swfversion" value="7.0.70.0">
			<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
			<param name="expressinstall"
				value="${stc }Scripts/expressInstall.swf">
			<param name="SCALE" value="exactfit">
			<param name="BGCOLOR" value="#000000">
			<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
			<!--[if !IE]>-->
			<object data="${stc }swf/zyclq.swf" type="application/x-shockwave-flash" width="1000" height="750" align="absmiddle" id="FlashID2">
				<!--<![endif]-->
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<param name="expressinstall"
					value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 浏览器将以下替代内容显示给使用 Flash Player 6.0 和更低版本的用户。 -->
				<div>
					<h4>此页面上的内容需要较新版本的 Adobe Flash Player。</h4>
					<p>
						<a href="http://www.adobe.com/go/getflashplayer"><img
							src="${stc }images/get_flash_player.gif"
							alt="获取 Adobe Flash Player" width="112" height="33" />
						</a>
					</p>
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
	<div class="tips" id="tips_1">
		<div class="bd" style="cursor: pointer;">点击鼠标，开始测试！</div>
	</div>
	<div class="tips" id="tips_2" style="z-index:998;">
		<div class="bd" style="cursor: pointer;z-index:999;">本测试结束，点击退出！</div>
	</div>

	<!--play start-->
	<div id="play" onmousedown="mousedown(event)">
		<div class="spanl">
			<em class="nor" id="s1"></em> <em class="nor" id="s2"></em> <em
				class="nor" id="s3"></em> <em class="nor" id="s4"></em>
		</div>
		<div class="spanr">
			<em class="nor nor-right" id="s5"></em> <em class="nor nor-right"
				id="s6"></em> <em class="nor nor-right" id="s7"></em> <em
				class="nor nor-right" id="s8"></em>
		</div>
	</div>
	<!--play end-->
<script type="text/javascript">
(function($){
	$.getUrlParam = function(name)
	{
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r!=null) return unescape(r[2]); return null;
	};
})(jQuery);
</script>
<script>
	var showLeft = "nor";
	var showRight = "nor nor-right";
	var sleep = 1000;
	
	//问题
	var questions = new Array(
		5,  3,  5,  4,  4,  2,  8,  5,  1,  8,  2,  1
	);
	if($.getUrlParam('m') == "t") {
		questions = new Array(
		5,  3,  5,  4,  4,  2,  8,  5,  1,  8,  2,  1
	);
	}
	//问题对应显示时间3是1.5秒，1是1秒，2是2秒
	var showtime = new Array(
		2,  2,  2,  1,  3,  3,  3,  2,  3,  1,  3,  2
	);
	//回答左为1，回答右为8
	var answers = new Array();
	
	var aquestionend = false;
	var process = false;
	var mousedown = function(e){
		//$("#show > tr > td").html("");
		if (isend) return ;
		if (!aquestionend || process) {
			/*
			$(".errorbox .txt").html("回答错误");
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
		var answer;
		if (btnNum==2){
			answer = 8;
	  	}else if(btnNum==0 || btnNum==1){
			answer = 1;
	  	}
		answers[answers.length] = answer;
		var q = questions[curr-1];
		var iszq = false;
		if ((q <= 4 && answer == 1) || (q >= 5 && answer == 8)) {
			iszq = true;
		}
		var zq = q <=4 ? "左" : "右";
		var anstext = answer<=4?"左":"右";
		var isText = null;
		var student_choice = 0;
		if (iszq) {
			isText = "正确";
			student_choice = 1;
		} else {
			/*
			$(".errorbox .txt").html("回答错误");
			$(".errorbox").show(function(){
				$(".errorbox button").click(function(){
					$(".errorbox").hide();
				});
			});*/
			alert("回答错误");
			isText = "错误";
		}
		
		$(".nor").each(function(index, element) {
	        $(this).attr("class","");
	    });
		aquestionend = true;
		showAQuestion();	//下一个数字
	};
	var show = function(num) {
		if (num < 1 || num > 8) {
			alert("数字"+num+"不在1~8范围内");
			return ;
		}
		$("#show > tr > td").html("");
		
		if (num <= 4) {
			$("#s"+num).attr("class",showLeft);
		} else {
			$("#s"+num).attr("class",showRight);
		}
	}
	var timestart; 
	var curr = 0;
	var isend =true;
	var showAQuestion = function() {
		aquestionend = true;
		process = true;
		if (curr < questions.length) {
			var q = questions[curr];		
			setTimeout(function(){
				show(q);
				process = false;
				timestart = getNs();
			}, sleep);
			curr ++;
		} else {
			alert("测试完毕");
			$("#tips_2").show(function(){
				$("#tips_2").click(function(){
					location.href="${path }/user/mokuai";
				});
			});
			isend = true;
		}
	}
	var timer = function(fn,sleepcount) {
		if (sleepcount <= 0) {
			fn();
		} else {
			setTimeout(function(){
				sleepcount = sleepcount -1;
				timer(fn,sleepcount);
			}, 1000);
		}
	}
	var startTest = function () {
		isend = false;
		timer(function(){
			showAQuestion();
		}, 3);
	}
	var getNs = function () {
		if(window.external.getNanoTime != undefined){
			return window.external.getNanoTime;
		}else{
			return (new Date()).valueOf();
		}
	}
	
	var formatTime = function (formatValue){
		formatValue = formatValue+"";
		var lastText = formatValue.substring(formatValue.length - 3,formatValue.length);
		var startText = formatValue.substring(0,formatValue.length - 3);
		var theValue = startText+"&nbsp;"+lastText;
		return theValue;
	}
	
	var mousedown_ = function (e) {
		var e = e || arguments.callee.caller.arguments[0];
		if(e == "undefined"){
			e = new Object;
		}
		var btnNum = e.button;
		return btnNum;
	}
	
	$(function(){
		$(".nor").each(function(index, element) {
	        $(this).attr("class","");
	    });
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
