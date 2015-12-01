<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <meta http-equiv="X-UA-Compatible" content="IE=9;IE=8;IE=7;" />

   <title>数学比较</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/sxnl2.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.comparing{ text-align:center; font-size:24px; width:100%; position:absolute; left:0; top:50%; margin-top:-5px; display:none;}
.comparing .bd{ width:430px; position:relative; margin:0 auto;}
.comtip{ font-size:12px; color:#000; position:absolute; left:0; top:-200px;}
a{text-decoration: none;color:#000;}
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
  var isclick=false;var end=false;
  var time=0;
  var istijiao=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					$(".comparing").show();
					$(".tips").hide();
					var str=$(".bd em").attr("lang");
					  if(str == "0"){
					  		setTimeout("timuqiehuan('c')",2000);
					  }
					  else{
					  		timuqiehuan('c');
					  }
				});
			});
		}, 7500);
		$("body").mousedown(function(e){
			if(isclick == true){
				if(e.which == 3){
					if(end == true){
				  	setpanduantimus("2","yellow","/user/mokuai");
				  	return true;
				}
				var str=$(".bd em").attr("lang");
			 	 if(str == "0"){
			  		if(isclick == true){
				  		setTimeout("timuqiehuan('1')",2000);
				  	}
				  	else{
				  		return false;
				  	}
			 	 }
				  else{
				  		timuqiehuan('1');
				  }
			 	}
			 else if(e.which == 1){
				 if(end == true){
				  	setpanduantimus("2","yellow","/user/mokuai");
				  	return true;
				  }
			 	  var str=$(".bd em").attr("lang");
				  if(str == "0"){
				  	if(isclick == true){
// 				  		console.log("str:"+str);
				  		timuqiehuan('0');
				  	}
				  	else{
				  		return false;
				  	}
				  }
				  else{
				  	if(isclick == true){
				  		timuqiehuan('0');
				  	}
				  	else{
				  		return false;
				  	}
				  }
			 }
			}
			else{
				return false;
			}
		});
	});
	function timuqiehuan(reaction_choice){
	 var strs=["5+7 __ 9+4","27+9 __ 5+32","15+21 __ 19+18","16+8+22 __ 17+26+4","11+24+9 __ 8+23+12","17+5+30 __ 4+28+18","16+9+4+3 __ 2+5+6+18","1+17+7+9 __ 5+6+19+5","3+7+17+8 __ 11+4+12+6"];
	 var daan=["1","1","1","1","0","0","0","1","0"];

			var str=$(".bd em").attr("lang");
// 			console.log("str:"+str);
			var lang=parseInt(str)+1;
			if(lang<strs.length+1){
				var istrue;
				if(reaction_choice == daan[str]){
					istrue = true;
				}
				else istrue = false;
				var reaction_time=getNs()-time;
				if(reaction_choice=="c"){
					reaction_choice="";
				}
				
				if(istijiao==true){
// 					console.log("strs[str]:"+strs[str]+"  daan[str]:"+daan[str]);
					var compare = {"test_no":"1","user_id":"1","question_no":lang,"correct_answer":daan[str],"reaction_time":reaction_time,"is_true":istrue,"student_answer":"1","reaction_choice":reaction_choice};
					$.post("/yellow/comparingSubmit",compare);
				}
				$(".bd em").attr("lang",lang);
// 				console.log("strs[str]:"+strs[str]);
				$(".bd em").html(strs[str]);
			}
			else{
				$(".comparing").hide();
				
				$("body").unbind("mousedown");
				questionend("2","hiese","/user/mokuai");
				end=true;
				
				return ;
			}
	//	});
		time=getNs();
		istijiao=true;
		isclick=true;
}
</script>

</head>
<body oncontextmenu="return false" ondragstart="return false">
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/sxcy.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<param name="allowScriptAccess" value="always" />
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
						<param name="allowScriptAccess" value="always" />
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
<div class="comparing">
	<div class="bd">
	<em lang="0"></em>
	<div class="comtip">本小题没有时间限制</div>
	</div>
</div>
</body>
</html>
