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
    <meta content="IE=edge" http-equiv="X-UA-Compatible"/>
    
    <title>表象能力</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:#000}
.tips{}
.tips .bd{ }
.imgshows{ width:100%; height:100%; position:absolute; left:0%; top:0%; display:none; }
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.imgshows .bd{ position:absolute; z-index:5; text-align:center; width:100%; height:200px; left:0; top:50%; margin-top:-100px;}
.imgshows .bd img{ width:200px; height:200px;}
a{text-decoration: none;color:#000;}
</style>
<script src="${stc }js/jquery1.42.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js"></script>
<script>
	$(function(){
			var scheight = $(".fullscreen").height();
			$(".fullscreen").css("margin-top",-(scheight/2));
		})
</script>
<script>
	$(function(){
			var tipheight = $(".tips .bd").height();
			$(".tips .bd").css("margin-top",-(tipheight/2));
		});
</script>

<script type="text/javascript">
var istrue=false;
var time="";
var isend=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
					$(".tips").click(function(){
						if(isend==false){
						isend=true;
						$(".imgshows").show();
						$(".tips").hide();
						var jindu = parseInt($("#jindu").text())+1;
						var bj_attr = $(".qiehuan"+jindu).attr("bj_attr");
						var bj_attrs = "";
						if(bj_attr!="" && bj_attr!=null){
							bj_attrs = bj_attr.split(",");
						}
						var yanshi = parseInt(bj_attrs[1])*1000;
						setTimeout(qiehuan,yanshi);
					}
				});
			});
		}, 9000);
		$("body").mousedown(function(e){
				if(e.which == 3){
					if(istrue == true){
				  		qiehuandy("1");
					}
			 	}
				 else if(e.which == 1){
				 	if(istrue == true){
				  		qiehuandy("0");
					}
			 	}
			else{
				return false;
			}
		});
	});
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false' >
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/bxnl.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/bxnl.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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

var jind=0;
var jindu=1;
$.ajax({
	type: "POST",
	url: "/user/getXiaotijd",
	data: {},
	dataType: "json",
	success: function(data){
		if (!data[0]) {
			return ;
		}
		jind = data[0].xiaotijd;
		jindu = jind+1;
	},
	error: function() {
		
	}
});
var qiehuan = function(){
		
		jind=jind+1;
		var jindu2 = jind-1;
		$(".qiehuan"+jind).show();
		$(".qiehuan"+jindu2).hide();
		
		if(time != ""){
			aa = true;
			time = getNs();
			if(jindu>36){
				if($(".tips").css("display") == "block"){
					setpanduantimu("2","heise","<%=path%>/user/mokuai");
				}
	// 			$(".tips .bd").html("<a href='javascript:' onclick='setpanduantimu(this.lang)' lang='3'>题目做完毕了，点击鼠标返回</a>");
				questionend("2","baise","<%=path%>/user/mokuai");
				$(".imgshows").hide();
				$(".tips").show();
				return false;
			}
			
		}
		else{
			time = getNs();
		}
		istrue=true;
};
var aa=true;
function qiehuandy(clickkey){
	if(jindu>36){
		return ;
	}
	
	if(aa == true){
		jindu ++;
		aa = false;
		var bj_attr = $(".qiehuan"+(jindu-1)).attr("bj_attr");
		var bj_attrs = "";
		if(bj_attr){
			bj_attrs = bj_attr.split(",");
		}
		var jindu2 =jind-1;
		var bj_attr = $(".qiehuan"+(jindu-1)).hide();
		var yanshi = parseInt(bj_attrs[1]);
		var reaction_time=0;
		if(yanshi == 1)
			yanshi = 1*1000;
		else if(yanshi == 3)
			yanshi = 1.5*1000;
		else 
			yanshi = 2*1000;
		reaction_time = getNs()-time;
		var question_no=jind;
		$.post("<%=path%>/red/testAppearance/testAppearancesave",{"question_no":question_no,"reaction_time":reaction_time,"clickkey":clickkey,"delay":yanshi,"type":bj_attrs[2],"structure":bj_attrs[0],"angle":bj_attrs[3],"classification":bj_attrs[4]});		
		if(parseInt(bj_attrs[2]) == 1){
				if(clickkey==0){
					alert("回答错误！");
				}
			}
		else if(parseInt(bj_attrs[2]) == 2 || parseInt(bj_attrs[2]) == 3){
			if(clickkey == 1){
				alert("回答错误！");
			}
		}
		bj_attr = $(".qiehuan"+jindu).attr("bj_attr");
		if(bj_attr){
			bj_attrs = bj_attr.split(",");
		}
		yanshi = parseInt(bj_attrs[1]);
		if(yanshi == 1)
			yanshi = 1*1000;
		else if(yanshi == 3)
			yanshi = 1.5*1000;
		else 
			yanshi = 2*1000;
		setTimeout("qiehuan("+clickkey+")",yanshi);
	}
	else{
		alert("不要抢答！");
	}
}
	
    
</script>
</div>
<div class="tips">
	<div class="bd">点击鼠标，开始测试！</div>
</div>
<!--start-->
<p  id="jindu" style="display:none;" >0</p>
<div class="imgshows">
<!-- <p  id="jindu2" style="color:#fff;">1</p> -->
	<div class="bd qiehuan1" lang="1" bj_attr="41,2,2,3,7" style="display: none">
		<img src="${stc }images/bxnl/41-1.bmp">
		<img src="${stc }images/bxnl/41-2.bmp">
	</div>
	
	<div class="bd qiehuan2" lang="2" style="display: none;" bj_attr="67,2,3,4,12">
		<img src="${stc }images/bxnl/67-1.bmp">
		<img src="${stc }images/bxnl/67-2.bmp">
	</div>
	
	<div class="bd qiehuan3" lang="3" style="display: none;" bj_attr="19,3,1,4,4">
		<img src="${stc }images/bxnl/19-1.bmp">
		<img src="${stc }images/bxnl/19-2.bmp">
	</div>
	
	<div class="bd qiehuan4" style="display: none;" bj_attr="13,1,1,3,3">
		<img src="${stc }images/bxnl/13-1.bmp">
		<img src="${stc }images/bxnl/13-2.bmp">
	</div>
	
	<div class="bd qiehuan5" style="display: none;" bj_attr="25,3,2,1,5">
		<img src="${stc }images/bxnl/25-1.bmp">
		<img src="${stc }images/bxnl/25-2.bmp">
	</div>
	
	<div class="bd qiehuan6" style="display: none;" bj_attr="7,1,1,2,2">
		<img src="${stc }images/bxnl/7-1.bmp">
		<img src="${stc }images/bxnl/7-2.bmp">
	</div>
	
	<div class="bd qiehuan7" style="display: none;" bj_attr="9,3,1,2,2">
		<img src="${stc }images/bxnl/9-1.bmp">
		<img src="${stc }images/bxnl/9-2.bmp">
	</div>
	
	<div class="bd qiehuan8" style="display: none;" bj_attr="27,1,2,1,5">
		<img src="${stc }images/bxnl/27-1.bmp">
		<img src="${stc }images/bxnl/27-2.bmp">
	</div>
	
	<div class="bd qiehuan9" style="display: none;" bj_attr="11,2,1,2,2">
		<img src="${stc }images/bxnl/11-1.bmp">
		<img src="${stc }images/bxnl/11-2.bmp">
	</div>
	
	<div class="bd qiehuan10" style="display: none;" bj_attr="3,2,1,1,1">
		<img src="${stc }images/bxnl/3-1.bmp">
		<img src="${stc }images/bxnl/3-2.bmp">
	</div>
	
	<div class="bd qiehuan11" style="display: none;" bj_attr="31,1,2,2,6">
		<img src="${stc }images/bxnl/31-1.bmp">
		<img src="${stc }images/bxnl/31-2.bmp">
	</div>
	
	<div class="bd qiehuan12" style="display: none;" bj_attr="29,1,2,1,5">
		<img src="${stc }images/bxnl/29-1.bmp">
		<img src="${stc }images/bxnl/29-2.bmp">
	</div>
	
	<div class="bd qiehuan13" style="display: none;" bj_attr="17,1,1,3,3">
		<img src="${stc }images/bxnl/17-1.bmp">
		<img src="${stc }images/bxnl/17-2.bmp">
	</div>
	
	<div class="bd qiehuan14" style="display: none;" bj_attr="21,3,1,4,4">
		<img src="${stc }images/bxnl/21-1.bmp">
		<img src="${stc }images/bxnl/21-2.bmp">
	</div>
	
	<div class="bd qiehuan15" style="display: none;" bj_attr="1,2,1,1,1">
		<img src="${stc }images/bxnl/1-1.bmp">
		<img src="${stc }images/bxnl/1-2.bmp">
	</div>
	
	<div class="bd qiehuan16" style="display: none;" bj_attr="51,2,3,1,9">
		<img src="${stc }images/bxnl/51-1.bmp">
		<img src="${stc }images/bxnl/51-2.bmp">
	</div>
	
	<div class="bd qiehuan17" style="display: none;" bj_attr="5,2,1,1,1">
		<img src="${stc }images/bxnl/5-1.bmp">
		<img src="${stc }images/bxnl/5-2.bmp">
	</div>
	
	<div class="bd qiehuan18" style="display: none;" bj_attr="58,2,3,2,10">
		<img src="${stc }images/bxnl/58-1.bmp">
		<img src="${stc }images/bxnl/58-2.bmp">
	</div>
	
	<div class="bd qiehuan19" style="display: none;" bj_attr="69,3,3,4,12">
		<img src="${stc }images/bxnl/69-1.bmp">
		<img src="${stc }images/bxnl/69-1.bmp">
	</div>
	
	<div class="bd qiehuan20" style="display: none;" bj_attr="70,2,3,4,12">
		<img src="${stc }images/bxnl/70-1.bmp">
		<img src="${stc }images/bxnl/70-2.bmp">
	</div>
	
	<div class="bd qiehuan21" style="display: none;" bj_attr="47,1,2,4,8">
		<img src="${stc }images/bxnl/47-1.bmp">
		<img src="${stc }images/bxnl/47-2.bmp">
	</div>
	
	<div class="bd qiehuan22" style="display: none;" bj_attr="33,1,2,2,6">
		<img src="${stc }images/bxnl/33-1.bmp">
		<img src="${stc }images/bxnl/33-2.bmp">
	</div>
	
	<div class="bd qiehuan23" style="display: none;" bj_attr="15,2,1,3,3">
		<img src="${stc }images/bxnl/15-1.bmp">
		<img src="${stc }images/bxnl/15-2.bmp">
	</div>
	
	<div class="bd qiehuan24" style="display: none;" bj_attr="49,3,3,1,9">
		<img src="${stc }images/bxnl/49-1.bmp">
		<img src="${stc }images/bxnl/49-2.bmp">
	</div>
	
	<div class="bd qiehuan25" style="display: none;" bj_attr="64,1,3,3,11">
		<img src="${stc }images/bxnl/64-1.bmp">
		<img src="${stc }images/bxnl/64-2.bmp">
	</div>
	
	
	<div class="bd qiehuan26" style="display: none;" bj_attr="52,3,3,1,9">
		<img src="${stc }images/bxnl/52-1.bmp">
		<img src="${stc }images/bxnl/52-2.bmp">
	</div>
	
	<div class="bd qiehuan27" style="display: none;" bj_attr="35,3,2,2,6">
		<img src="${stc }images/bxnl/35-1.bmp">
		<img src="${stc }images/bxnl/35-2.bmp">
	</div>
	
	<div class="bd qiehuan28" style="display: none;" bj_attr="45,2,2,4,8">
		<img src="${stc }images/bxnl/45-1.bmp">
		<img src="${stc }images/bxnl/45-2.bmp">
	</div>
	
	<div class="bd qiehuan29" style="display: none;" bj_attr="61,3,3,3,11">
		<img src="${stc }images/bxnl/61-1.bmp">
		<img src="${stc }images/bxnl/61-2.bmp">
	</div>
	
	<div class="bd qiehuan30" style="display: none;" bj_attr="43,3,2,4,8">
		<img src="${stc }images/bxnl/43-1.bmp">
		<img src="${stc }images/bxnl/43-2.bmp">
	</div>
	
	<div class="bd qiehuan31" style="display: none;" bj_attr="63,1,3,3,11">
		<img src="${stc }images/bxnl/63-1.bmp">
		<img src="${stc }images/bxnl/63-2.bmp">
	</div>
	
	<div class="bd qiehuan32" style="display: none;" bj_attr="39,1,2,3,7">
		<img src="${stc }images/bxnl/39-1.bmp">
		<img src="${stc }images/bxnl/39-2.bmp">
	</div>
	
	<div class="bd qiehuan33" style="display: none;" bj_attr="55,3,3,2,10">
		<img src="${stc }images/bxnl/55-1.bmp">
		<img src="${stc }images/bxnl/55-2.bmp">
	</div>
	
	<div class="bd qiehuan34" style="display: none;" bj_attr="37,2,2,3,7">
		<img src="${stc }images/bxnl/37-1.bmp">
		<img src="${stc }images/bxnl/37-2.bmp">
	</div>
	
	<div class="bd qiehuan35" style="display: none;" bj_attr="57,3,3,2,10">
		<img src="${stc }images/bxnl/57-1.bmp">
		<img src="${stc }images/bxnl/57-2.bmp">
	</div>
	
	<div class="bd qiehuan36" style="display: none;" bj_attr="23,1,1,4,4">
		<img src="${stc }images/bxnl/23-1.bmp">
		<img src="${stc }images/bxnl/23-2.bmp">
	</div>
	
</div>
<!--end-->
</body>
</html>
