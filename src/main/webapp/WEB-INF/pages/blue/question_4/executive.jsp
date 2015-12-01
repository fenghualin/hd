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
<title>选择</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background-color:#000;}
.ShowNum{ width:100%; text-align:center; position:absolute; le:0; top:50%; font-size:30px; color:#fff; display:none;}
.inputNum{ border:2px solid #fff; background-color:transparent; width:476px; height:37px; color:#fff; font-size:30px; text-align:center; font-family:"宋体"; font-weight:normal;}
#inputplay{ display:none; width:100%; height:100%; overflow:hidden;}
.inputBox{ position:absolute; top:50%; left:0; margin-top:-20px; width:100%; text-align:center;}
.nubPlus{position:absolute; bottom:20px; left:50%; margin-left:-98px; width:196px;}
.nubPlus ul{ }
.nubPlus ul li{ display:block; float:left; width:60px; padding:2px;}
.nubPlus .nb{ font-family:"黑体"; display:block; background-color:#f0f0f0; border:none; cursor:pointer; -webkit-border-radius:3px;-ms-border-radius:3px;-o-border-radius:3px;border-radius:3px;color:#000; width:100%; height:42px; font-size:24px; text-align:center; }
.nubPlus .nb:active{background-color:#fff; }
.nubPlus .tb{ color:rgba(255,255,255,1); font-family:"黑体"}
.nubPlus .del{ background-color:rgb(249,155,14); text-shadow:1px 1px 0 rgba(0,0,0,0.15);}
.nubPlus .ok{ background-color:rgb(26,182,228); text-shadow:1px 1px 0 rgba(0,0,0,0.15);}
.nubPlus .ok:active{ background-color:rgba(26,182,228,0.9); }
.nubPlus .del:active{ background-color:rgba(249,155,14,0.9);}

</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js"></script>
<!--[if lt IE 8 ]>
<script src="${stc }js/json2.js"></script>
<![endif]-->
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
		$(".tip_start").show(function(){
				$(".tip_start").click(function(){
					$(".ShowNum").show(function(){
						startTest();
							setTimeout(function(){
								$(".ShowNum").hide();
								$("#inputplay").show();
								},2000);
						});
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
<div class="ShowNum">
</div>
<!--play start-->
<div id="inputplay">
		<div class="inputBox">
			<input class="inputNum" type="text" id="answer" onkeyup="yzdaan(this)" onchange="yzdaan(this)" autocomplete="off" data-click="0"/>
		</div>
		<div class="nubPlus">
			<ul>
				<li>
					<input class="nb num_btn" type="button" value="1"/>
				</li>
				<li>
					<input class="nb num_btn" type="button" value="2"/>
				</li>
				<li>
					<input class="nb num_btn" type="button" value="3"/>
				</li>
				<li>
					<input class="nb num_btn" type="button" value="4"/>
				</li>
				<li>
					<input class="nb num_btn" type="button" value="5"/>
				</li>
				<li>
					<input class="nb num_btn" type="button" value="6"/>
				</li>
				<li>
					<input class="nb num_btn" type="button" value="7"/>
				</li>
				<li>
					<input class="nb num_btn" type="button" value="8"/>
				</li>
				<li>
					<input class="nb num_btn" type="button" value="9"/>
				</li>
				<li>
					<input class="nb tb del del_btn" type="button" value="退格"/>
				</li>
				<li>
					<input class="nb num_btn" type="button" value="0"/>
				</li>
				<li>
					 <input class="nb tb ok" type="button" onclick="submitAnswer();" value="确定"/>
				</li>
			</ul>		
		</div>
	</div>
<!--play end-->
<script type="text/javascript">
		//设置开始

		//开始数字的位数
		var start = 3;
		//当前做到第几题了
		var curr_question = 0;
		//连续错误次数
		var error_number = 0;
		//数字显示的时间(毫秒)，showtime毫秒后自动隐藏
		var showtime = 1300;
		//准备时间(秒)，下一个数字出现的准备时间
		var precount = 1;
		//数字出现时间
		var numShowTime;
		//按钮点击时间
		var clickTime;
		//答题时间
		var answerTime;
		//总答题时间
		var allTime;
		//设置结束
		var question_number = 1;
		var error_question = 0;
		var iswancheng = false;
		if (start < 1) {
			alert("start不能小于1");
		}

		//开始数1000
		var num_s = Math.pow(10, start - 1);

		//结束数8999
		var num_c = 9 * Math.pow(10, start - 1) - 1;
		window.test = {
			s : num_s,
			c : num_c,
			count : start,
			questions : new Array(),
			answers : new Array(),
			answerTime : new Array()
		};

		var count = start;
		//显示一个数字
		function show() {
			var generated;
			if (error_number < 3) {
				generated = parseInt(Math.random() * window.test.c
						+ window.test.s);
				if (question_number == 1) {
					window.test.c *= 10;
					window.test.c += 9;
					window.test.s *= 10;
				}
			} else {
				//开始数
				window.test.s = num_s;
				//结束数
				window.test.c = num_c;
				return null;
			}
			if(question_number <= 3){
				question_number += 1;
			}else{
				count++;
				question_number = 1;
			}
			curr_question++;
			//console.log(generated);
			return generated;
		}
		String.prototype.reverseString = function() {
			var str = "";
			for ( var j = this.length; j >= 1; j--) {
				str += this.substring(j - 1, j);
			}
			return str;
		};
		var testaaa = true;
		function showQuestion() {
			var generated = show();
			//console.log(generated);
			if (generated == null) {
				var data = {};
				for ( var i = 0; i < window.test.questions.length; i++) {
					var q = (window.test.questions[i]) + "";
					var a = (window.test.answers[i]) + "";
					var aTime = window.test.answerTime[i];
					data[i] = {};
					data[i]["question"] = ((q+"").reverseString())+"";
					data[i]["answer"] = a;
					data[i]["question_no"] = (i + 1);
					data[i]["reaction_time"] = aTime;
					data[i]["range"] = (2.0 + (curr_question - 3.0) / 3.0);
					data[i]["accuracy"] = (1.0 - error_question / curr_question);
					data[i]["testNo"] = 0;
					data[i]["userId"] = 0;
					data[i]["reaction_choice"] = 0;
				}
				//console.log(data);
				var returnData = JSON.stringify(data);
				var url = "${path}/blue/question_4/ajaxSave";
				$.ajaxSetup({   
		            async : false  
		        });
				$.post(url, {
					data : returnData
				}, function() {

				});
				$.ajaxSetup({   
		            async : true  
		        });
				$("#inputplay").hide();
				$.post("${path}/user/savejindu",{"vals":"2"},function(data){
					//location.href="${path }/user/mokuai";
				});
				$(".tip_end").show(function(){
					$(".tip_end").click(function(){
						if(iswancheng==false){
							//$.post("${path}/user/savejindu",{"vals":"2"},function(data){
								location.href="${path }/user/mokuai";
							//});
							iswancheng=true;
						}
					});
				});
			} else {
				timer(function() {
					$(".ShowNum").show();
					numShowTime = getNs();//答案显示时间
					//console.log(generated);
					$(".ShowNum").html(generated);
					putQuestion(generated);
					setTimeout(function() {
						$(".ShowNum").hide();
						$("#inputplay").show();
						$(".inputNum").focus();
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
		function startTest() {
			showQuestion();
		};
		function submitAnswer() {
			var answer = $("#answer").val();
			if (!answer) {
				alert("请输入答案");
				$("#answer").focus();
				return false;
			}
			clickTime = getNs();//用户点击时间
			answerTime = clickTime - numShowTime; //答题时间
			putAnswerTime(answerTime);
			putAnswer(answer);
			var curr_question = window.test.questions[window.test.questions.length - 1];
			curr_question = ((curr_question+"").reverseString())+"";
			//计算连续错误次数
			if (answer == curr_question) {
				error_number = 0;
				//console.log("回答正确");
			} else {
				error_number += 1;
				error_question += 1;
				//console.log("回答错误");
			}
			$(".inputNum").val("");
			$("#inputplay").hide();
			setTimeout(function() {
				showQuestion();
			}, 1000);
			$(".inputNum").focus();
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
		$(function() {
			$(".inputNum").blur(function(){
				setTimeout(function(){
					$(this).focus();
				}, 100);
			});
			$(".num_btn").each(
				function(index, element) {
					$(this).mouseup(
						function() {
// 							if($(".inputNum").attr("data-click")==0){
// 								return ;
// 							}
							$(".inputNum").val(
								$(".inputNum").val() + ""
									+ $(this).val());
							$(".inputNum").focus();
					});
				});
			$(".del_btn").click(
					function() {
						$(".inputNum").val(
								$(".inputNum").val().substr(0,
										$(".inputNum").val().length - 1));
					});
			$("body").keydown(function(e){
				if(e.keyCode == 13) {
					submitAnswer();
				}
				$("#answer").focus();
			});		
					
		});
		function getNs() {
			if (window.external.getNanoTime != undefined) {
				return window.external.getNanoTime;
			} else {
				return (new Date()).valueOf()*1000*1000;
			}
		}
		function yzdaan(obj){
		var vv = $(obj).val();
		var req = /\d/g;
		var v=vv.match(req);
		if(v != "" && v != null){
			$(obj).val(v.join(""));
		}
		else{
			$(obj).val("");
		}
		$(obj).focus();
	}
	
	</script>
</body>
</html>
