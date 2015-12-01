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
    
    <title>空间推理</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/kjtl/kjnl.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.imgshows{ width:910px; height:564px; position:absolute; left:50%; top:50%; margin-left:-455px; margin-top:-266px; display:none; }
.imgshows img{}
.imgs{ height:547px;width:410px; position:relative;}
.time{ font-size:12px;position:absolute; left:5px; top:5px; z-index:10;}
.imgshows .bd{ position:absolute; z-index:5; text-align:center; width:100%; height:100%;}
.imgshows .bd img{ height:100%;}
.imgshows .btns{position:absolute; right:10px; bottom:5px; z-index:10;}
.imgshows .btns>span{ display:inline-block;}
label{ font-size:12px; display:block;}
.btn-ok{  width:80px; height:24px;}
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
var jindu=0;
var imgurl="${stc }images/kjtl/";
var daan2=[["1"],["2"],["5","1"],["3","4"],["2","1","3"],["1","3","4"]];
var isend=false;
var student_choicea="0";
			var student_choiceb="0";
			var student_choicec="0";
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					if(isend==false){
						$(".imgshows").show();
						$(".tips").hide();
						isend=true;
					}
				});
			});
		}, 8000);
		var isclick=0;
		var y = 0;
		var time=0;
		$(".btns select").change(function(){
			if(time==0)
				time=getNs();
			$(".btns .choices"+(jindu+1)).each(function(i,o){
					if($(o).val()=="0"){
						isclick=isclick-1;
					}
					else{
						isclick=isclick+1;
					}
				y=y+1;
			});
			if(isclick==y){
				$(".btn-ok").removeAttr("disabled");
			}
			else{
				$(".btn-ok").attr("disabled","disabled");
			}
			y=0;
			isclick=0;
		});
		$(".btn-ok").click(function(){
			if(isclick!=y){
				alert("请选择答案！");
				return false;		
			}
			var daan1=daan2[jindu];
			var daan="";
			var student_score=0;
			$(".btns .choices"+(jindu+1)).each(function(i,o){
				daan=daan+","+$(o).val();
			});
			daan=daan.substring(1).split(",");
			if(daan.length==1){
				student_choicea=daan[0];
				student_choiceb="0";
				student_choicec="0";
			}
			else if(daan.length==2){
				student_choicea=daan[0];
				student_choiceb=daan[1];
				student_choicec="0";
			}
			else if(daan.length==3){
				student_choicea=daan[0];
				student_choiceb=daan[1];
				student_choicec=daan[2];
			}
			var reaction_time=getNs()-time;
			for(var i =0;i<daan.length;i++){
				if(daan[i]==daan1[i]){
					student_score=student_score+1;
				}
			}
			jindu=jindu+1;
			$.post("<%=path%>/red/testReasoning/testReasoningsave",{"student_choicea":student_choicea,"student_choiceb":student_choiceb,"student_choicec":student_choicec,"student_score":student_score,"reaction_time":reaction_time,"question_no":jindu},function(data){
// 				if(data=="ok"){
// 					window.location.href="<%=path%>/red/testReasoning/testReasoningtwo";
// 				}
			});
			if(jindu>5){
					//$(".tips .bd").html("<a href='javascript:' onclick='setpanduantimu(this.lang)' lang='3'>题目做完毕了,点击鼠标返回</a>");
					questionend("2","heise","<%=path%>/user/mokuai");
					$(".imgshows").hide();
					$(".tips").show();
			}
			else{
				$(".btns"+jindu).hide();
				$(".btns"+(jindu+1)).show();
				$(".bd img").attr("src",imgurl+(jindu+1)+".jpg");
			}
			$(".btn-ok").attr("disabled","disabled");
			time=getNs();
		});
	});
</script>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/kjtl.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/kjtl.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
	<div class="bd">点击鼠标，开始测试！</div>
</div>
<!--start-->
<div class="imgshows">
	<div class="time">本小题没有时间限制</div>
	<div class="bd">
		 <img src="${stc }images/kjtl/1.jpg">
	</div>
	<div class="btns btns1">
		<span>
			<label>A图:</label>
			<select class="choices1">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
			</select>
		</span>
		<span>
		<button class="btn-ok" type="button" disabled="disabled">确定</button>
		</span>
	</div> 
	<div class="btns btns2" style="display: none;">
		<span>
			<label>A图:</label>
			<select class="choices2">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
			</select>
		</span>
		<span>
		<button class="btn-ok" type="button" disabled="disabled">确定</button>
		</span>
	</div> 
	<div class="btns btns3" style="display: none;">
		<span>
			<label>A图:</label>
			<select class="choices3">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
			</select>
		</span>
		<span>
			<label>B图:</label>
			<select class="choices3">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
			</select>
		</span>
		<span>
		<button class="btn-ok" type="button" disabled="disabled">确定</button>
		</span>
	</div> 
	<div class="btns btns4"  style="display: none;">
		<span>
			<label>A图:</label>
			<select class="choices4">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
			</select>
		</span>
		<span>
			<label>B图:</label>
			<select class="choices4">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
			</select>
		</span>
		<span>
		<button class="btn-ok" type="button" disabled="disabled">确定</button>
		</span>
	</div> 
	<div class="btns btns5"  style="display: none;">
		<span>
			<label>A图:</label>
			<select class="choices5">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
				<option value="7">7号图</option>
				<option value="8">8号图</option>
				<option value="9">9号图</option>
			</select>
		</span>
		<span>
			<label>B图:</label>
			<select class="choices5">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
				<option value="7">7号图</option>
				<option value="8">8号图</option>
				<option value="9">9号图</option>
			</select>
		</span>
		<span>
			<label>C图:</label>
			<select class="choices5">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
				<option value="7">7号图</option>
				<option value="8">8号图</option>
				<option value="9">9号图</option>
			</select>
		</span>
		<span>
		<button class="btn-ok" type="button" disabled="disabled">确定</button>
		</span>
	</div> 
	<div class="btns btns6"  style="display: none;">
		<span>
			<label>A图:</label>
			<select class="choices6">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
				<option value="7">7号图</option>
				<option value="8">8号图</option>
				<option value="9">9号图</option>
			</select>
		</span>
		<span>
			<label>B图:</label>
			<select class="choices6">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
				<option value="7">7号图</option>
				<option value="8">8号图</option>
				<option value="9">9号图</option>
			</select>
		</span>
		<span>
			<label>C图:</label>
			<select class="choices6">
				<option value="0"> </option>
				<option value="1">1号图</option>
				<option value="2">2号图</option>
				<option value="3">3号图</option>
				<option value="4">4号图</option>
				<option value="5">5号图</option>
				<option value="6">6号图</option>
				<option value="7">7号图</option>
				<option value="8">8号图</option>
				<option value="9">9号图</option>
			</select>
		</span>
		<span>
		<button class="btn-ok" type="button" disabled="disabled">确定</button>
		</span>
	</div> 
</div>
<!--end-->
</body>
</html>
