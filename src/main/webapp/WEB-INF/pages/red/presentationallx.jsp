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
		});
</script>
<script>
	$(function(){
			var tipheight = $(".tips .bd").height();
			$(".tips .bd").css("margin-top",-(tipheight/2)) ;
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
						$(".imgshows").show();
						$(".tips").hide();
						var jindu = parseInt($("#jindu").text());
						var bj_attr = $(".qiehuan"+jindu).attr("bj_attr");
						var bj_attrs = "";
						if(bj_attr!=""){
							bj_attrs = bj_attr.split(",");
						}
						var yanshi = parseInt(bj_attrs[1])*1000;
						istrue=true;
						isend=true;
						setTimeout("qiehuan('0')",yanshi);
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
function qiehuan(clickkey){
		jind=jind+1;
		var jindu2 = jind-1;
		$(".qiehuan"+jind).show();
		$(".qiehuan"+jindu2).hide();
		
		if(time != ""){
			var bj_attr = $(".qiehuan"+jindu).attr("bj_attr");
			var bj_attrs = "";
			if(bj_attr!=""){
				bj_attrs = bj_attr.split(",");
			}
			var yanshi = parseInt(bj_attrs[1]);
			aa = true;
			if(jindu == 1){
				reaction_time = getNs()-time;
			}
			else {
				reaction_time = getNs() - time - yanshi*1000*1000*1000;
			}
			time = getNs();
			var question_no=jind-1;
			jindu=jindu+1;
// 			$.post("<%=path%>/red/testAppearance/testAppearancesave",{"question_no":question_no,"reaction_time":reaction_time,"clickkey":clickkey,"delay":yanshi,"type":bj_attrs[2],"structure":bj_attrs[0],"angle":bj_attrs[3],"classification":bj_attrs[4]});		
			
			if(jindu>5){
				if($(".tips").css("display") == "block"){
					setpanduantimu("lx","heise","<%=path%>/user/mokuai");
				}
	// 			$(".tips .bd").html("<a href='javascript:' onclick='setpanduantimu(this.lang)' lang='3'>题目做完毕了，点击鼠标返回</a>");
				questionend("lx","baise","<%=path%>/user/mokuai");
				$(".imgshows").hide();
				$(".tips").show();
				return false;
			}
			
		}
		else{
			time = getNs();
		}
		istrue=true;
}
function qiehuandy(clickkey){
	if(jindu>5){
		return ;
	}
// 	console.log("2:jindu:"+jindu+"--jind:"+jind);
	if(aa == true){
		aa = false;
		var bj_attr = $(".qiehuan"+jindu).attr("bj_attr");
		var bj_attrs = "";
		if(bj_attr!=""){
			bj_attrs = bj_attr.split(",");
		}
		var jindu2 =jind-1;
		var bj_attr = $(".qiehuan"+jindu).hide();
		var yanshi = parseInt(bj_attrs[1]);
		if(yanshi == 1)
			yanshi = 1*1000;
		else if(yanshi == 3)
			yanshi = 1.5*1000;
		else 
			yanshi = 2*1000;
		
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
		setTimeout("qiehuan("+clickkey+")",yanshi);
	}
	else{
		alert("不要抢答！");
	}
}
var aa=true;
    
</script>
</div>
<div class="tips">
	<div class="bd">点击鼠标，开始测试！</div>
</div>
<!--start-->
<p  id="jindu" style="display:none;" >1</p>
<div class="imgshows">
<!-- <p  id="jindu2" style="color:#fff;">1</p> -->
	
	
	<div class="bd qiehuan1" style="display: none;" bj_attr="25,3,2,1,5">
		<img src="${stc }images/bxnl/25-1.bmp">
		<img src="${stc }images/bxnl/25-2.bmp">
	</div>
	
	
	
	<div class="bd qiehuan2" style="display: none;" bj_attr="31,1,2,2,6">
		<img src="${stc }images/bxnl/31-1.bmp">
		<img src="${stc }images/bxnl/31-2.bmp">
	</div>
	
	<div class="bd qiehuan3" style="display: none;" bj_attr="51,2,3,1,9">
		<img src="${stc }images/bxnl/51-1.bmp">
		<img src="${stc }images/bxnl/51-2.bmp">
	</div>
	
	
	<div class="bd qiehuan4" style="display: none;" bj_attr="47,1,2,4,8">
		<img src="${stc }images/bxnl/47-1.bmp">
		<img src="${stc }images/bxnl/47-2.bmp">
	</div>
	
	
	<div class="bd qiehuan5" style="display: none;" bj_attr="37,2,2,3,7">
		<img src="${stc }images/bxnl/37-1.bmp">
		<img src="${stc }images/bxnl/37-2.bmp">
	</div>
	
	
</div>
<!--end-->
</body>
</html>
