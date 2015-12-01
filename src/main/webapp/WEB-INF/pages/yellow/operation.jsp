<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!Doctype html>
<html>
  <head>
   <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<script type="text/javascript">if (location.href.indexOf("random") == -1) {location.href = location.href+"?random="+Math.random();}</script>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT"><META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
    <title>数学运算</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/bk.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000; font-size:20px;}
.comparing{ text-align:center; font-size:20px; width:100%; position:absolute; left:0; top:50%; display:none;}
.comparing .bd{ width:310px; position:relative; margin:0 auto;}
.comparing input{ width:80px; height:24px; border:1px solid #696969;}
a{text-decoration: none;color:#000;}
.but_c{width:80px;margin-top:10px;}
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
var shijian=false;
var shijian13=false;
var isreturn=false;
var istijiao=0;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					if(isend==false){
						if(isreturn==false){
						$(".comparing").show();
						$(".tips").hide();
						var str2=$(".bd em").attr("val_dir");
					  	if(str2 == 0){
					  		shijian=false;
					  		setTimeout("qiehuan();",2000);
					  		$(".bd em").attr("val_dir","1");
					  	}
					  	else{
					  		qiehuan();
					  	}
						shijian=true;
					}
					}
					else{
					return false;
					}
				});
			});
		}, 7500);
		$("body").mousedown(function(e){
			if(isend==false){
				var ev = document.all ? window.event : e;
				if(e.which == 3){
					if($(".bd em").html()=="" || $(".bd em").html() == null){
				  	return false;
				  }
				  else{
				  	qiehuan();
				  }
				  $(".val_daan").focus();
			 	}
			 	else if(e.which == 1){
			 		if($(".bd em").html()=="" || $(".bd em").html() == null){
					  	return false;
					  }
					  else{
					  	qiehuan();
					  }
					  $(".val_daan").focus();
				 }
				else{
					return false;
				}
			} else {
				setpanduantimus(2,"","<%=path%>/user/mokuai");
			}
		});
		$(document).keydown(function(event) {
			var ev = document.all ? window.event : event;  
			if (ev.keyCode == 13) {
				if (isend) return;
				var str1=$("#data_vals").attr("lang");
				var str2=$(".bd em").attr("lang");
				var number=$("#data_vals").attr("numbers");
				if(timu1[number].length == str2){
		  				shijian13=true;
		  		}
		  		if(timu2[number].length == str2){
		  				shijian13=true;
		  		}
		  		if(timu3[number].length == str2){
		  				shijian13=true;
		  		}
				if(shijian13==true){
					if(str1 == "0"){
						if(timu1[number].length == str2){
							nexttimu();
					  		shijian13=false;
						}
					}
					else if(str1 == 1){
						if(timu2[number].length == str2){
							nexttimu();
					  		shijian13=false;
						}
					}
					else if(str1 == 2){
						if(timu3[number].length == str2){
							nexttimu();
					  		shijian13=false;
						}
					}
				}
			} 
		}); 
	});
</script>
<script type="text/javascript">
	var timu1=[["A＝4","B＝17－5","C＝A×4","D＝B÷6","E＝A＋5","则E答案是<input type='text' style='width:70px;' onkeyup='yzdaan(this)' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"],["A＝8","B＝16÷4","C＝A＋5","D＝B×3","E＝A－4","则E答案是<input type='text' style='width:70px;' onkeyup='yzdaan(this)' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"],["A＝6","B＝16÷4","C＝A＋5","D＝B×3","E＝A×2","则E答案是<input type='text' onkeyup='yzdaan(this)' style='width:70px;' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"],["A＝15","B＝4＋9","C＝A－2","D＝B＋3","E＝A÷5","则E答案是<input type='text' style='width:70px;' onkeyup='yzdaan(this)' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"]];
	var timu2=[["A＝9","B＝4＋3","C＝B×2","D＝A÷3","E＝8－4","F＝B＋5","则F答案是<input type='text' onkeyup='yzdaan(this)' style='width:70px;' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"],["A＝7","B＝2×6","C＝B＋4","D＝A－2","E＝6＋3","F＝B÷4","则F答案是<input type='text' style='width:70px;' onkeyup='yzdaan(this)' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"],["A＝5","B＝9－3","C＝B÷2","D＝A×3","E＝14÷7","F＝B×2","则F答案是<input type='text' style='width:70px;' onkeyup='yzdaan(this)' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"],["A＝8","B＝18÷2","C＝B－4","D＝A＋5","E＝3×4","F＝B－6","则F答案是<input type='text' style='width:70px;' onkeyup='yzdaan(this)' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"]];
	var timu3=[["A＝6","B＝A×2","C＝B＋5","D＝A÷2","E＝C－4","F＝B÷2","G＝C＋3","则G答案是<input type='text' onkeyup='yzdaan(this)' style='width:70px;' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"],["A＝8","B＝A＋6","C＝B÷2","D＝A－2","E＝C×2","F＝B－7","G＝C－4","则G答案是<input type='text' style='width:70px;' onkeyup='yzdaan(this)' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"],["A＝9","B＝A－4","C＝B×3","D＝C＋6","E＝A÷3","F＝B＋3","G＝C÷5","则G答案是<input type='text' style='width:70px;' onkeyup='yzdaan(this)' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"],["A＝8","B＝A÷2","C＝B－2","D＝B×3","E＝A＋5","F＝B＋9","G＝C×7","则G答案是<input type='text' style='width:70px;' onkeyup='yzdaan(this)' class='val_daan' /><br/><input type='button' onclick='nexttimu()' value='确定' class='but_c' />"]];
	var daan1=[["9","4","12","3"],["12","3","12","3"],["18","2","14","17"]];
	var click1=0;
	var nmiao1;
	var num=1;
	var isend=false;
	/**切换下一步**/
	function qiehuan(){
	var nmiao3;
		if(click1==1){
			var nmiao2=getNs();
			nmiao3=nmiao2-nmiao1;
			nmiao1=getNs();
		}
		else{
			nmiao1=getNs();
			click1=1;
		}
		var str1=$("#data_vals").attr("lang");
		var str2=$(".bd em").attr("lang");
		var number=$("#data_vals").attr("numbers");
	  	if(str1 == 0){
		  	if(number == "" || number == null){
		  		number = Math.round(Math.random()*(timu1.length-1));
		  	}
		  	if(timu1[number].length == str2){
		  		shijian13=true;
		  		return;
		  	}
		  	else{
		  		$(".bd em").html(timu1[number][str2]).attr("lang",parseInt(str2)+1);
		  	}
		  	$("#data_vals").attr("numbers",number);
		  	$(".val_daan").focus();
	  	}
	  	else if(str1==1){
		  	if(number == "" || number == null){
		  		number = Math.round(Math.random()*(timu1.length-1));
		  	}
		  	if(timu2[number].length == str2){
		  		shijian13=true;
		  		return;
		  	}
		  	else{
		  		$(".bd em").html(timu2[number][str2]).attr("lang",parseInt(str2)+1);
		  	}
		  	$("#data_vals").attr("numbers",number);
		  	$(".val_daan").focus();
	  	}
	  	else if(str1==2){
		  	if(number == "" || number == null){
		  		number = Math.round(Math.random()*(timu3.length-1));
		  	}
		  	if(timu3[number].length == str2){
		  		shijian13=true;
		  		return;
		  	}
		  	$(".bd em").html(timu3[number][str2]);
		  	$(".bd em").attr("lang",parseInt(str2)+1);
		  	$("#data_vals").attr("numbers",number);
		  	$(".val_daan").focus();
	  	}
	  	if(nmiao1 == "" || nmiao1==null || nmiao1==undefined){
	  		return;
	  	}
	  	if(istijiao==0){
	  		$(".bd em").attr("lang",0);
	  		istijiao=1;
	  	}
	  	else{
	  		if (!number) number = 1;
	  		if (!str2) str2 = 0;
	  		if (!str1) str1 = 0;
	  		var compare = {"test_no":parseInt(str1)+1,"question_no":parseInt(str2)+1,"correct_answer":daan1[str1][number],"reaction_time":nmiao3,"step":parseInt(str1)+1};
			$.post("<%=path%>/yellow/mathoperation/operationSubmit",compare);
	  	}
		shijian=true;
	}
	/**切换下一题，提交答案**/
	function nexttimu(){
		var str1=$("#data_vals").attr("lang");
		var val_daan = $.trim($(".val_daan").val());
		var str2=$(".bd em").attr("lang");
		var number=$("#data_vals").attr("numbers");
		var is_true=0;
		if(click1==1){
			var nmiao2=getNs();
			nmiao3=nmiao2-nmiao1;
			nmiao1=getNs();
		}
		else{
			nmiao1=getNs();
			click1=1;
		}
		if(val_daan == "" || val_daan == null){
			alert("请填写答案！");
			return ;
		}
		else if(val_daan == daan1[str1][number]){
			is_true = 1;
		}
		else {
			is_true = 0;
		}
		var compare = {"test_no":parseInt(str1)+1,"question_no":parseInt(str2)+1,"correct_answer":daan1[str1][number],"reaction_time":nmiao3,"is_true":is_true,"student_answer":val_daan,"step":parseInt(str1)+1};
		$.post("<%=path%>/yellow/mathoperation/operationSubmit",compare); 
		num=num+1;
// 		alert("str1: " + str1+", == 2? " + (str1==2));
	  	if(str1 == 0){
		  	if(timu1[number].length == str2){
		  		str1=parseInt(str1)+1;
		  		str2=0;
		  		number = Math.round(Math.random()*(timu2.length-1));
		  		$(".bd").attr("lang",str1).attr("vals",str1);
		  		$(".bd em").html(timu2[number][str2]).attr("lang",str2);
		  		$(".bd em").attr("val_dir","0");
				click1=0;
		  	}
		  	$("#data_vals").attr("numbers",number);
	  	}
	  	else if(str1==1){
		  	if(timu2[number].length == str2){
		  		str1=parseInt(str1)+1;
		  		str2=0;
		  		number = Math.round(Math.random()*(timu3.length-1));
		  		$("#data_vals").attr("lang",str1).attr("vals",str1);
		  		$(".bd em").html(timu3[number][str2]);
		  		$(".bd em").attr("lang",str2);
		  		$(".bd em").attr("val_dir","0");
		  		click1=0;
		  	}
		  	$("#data_vals").attr("numbers",number);
	  	}
	  	else if(str1==2){
		  	if(timu3[number].length == str2){
		  		$(".comparing").hide();
		  		$(".comparing").html("");
				$(".tips").show();
// 				alert("wtf");
// 				alert("答完题了？");
// 				console.log("wtfff");
				isend=true;
				questionend("2","hiese","<%=path%>/user/mokuai");
// 				$(".tips").click(function(){
// 					alert("click????");
// 				});
				
		  	}
		  	$(".bd em").html(timu3[number][str2]);
		  	$(".bd em").attr("lang",str2);
		  	$("#data_vals").attr("numbers",number);
	  	}
	  	nmiao1=getNs();
			click1=1;
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
	}
    

</script>
</head>
<body oncontextmenu='return false' ondragstart='return false' >
<div class="fullscreen" id="swf1" style="margin-top: -393px!important;">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<br><param name="movie" value="${stc }swf/sxcy.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
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
	<div class="bd" >按任意键或点击鼠标，开始测试</div>
</div>
<div class="comparing" >
	<div class="bd" id="data_vals" lang="0">
		<em lang="0" val_dir="0"></em>
	</div>
</div>
</body>
</html>