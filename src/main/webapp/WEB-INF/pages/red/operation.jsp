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
    
    <meta charset="utf-8">
<title>空间操作</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">
<style>
body{ background:url(${stc }images/kjcz/kjnl.jpg) no-repeat center center;}
.tips{}
.tips .bd{ color:#000;}
.imgshows{ width:910px; height:564px; position:absolute; left:50%; top:50%; margin-left:-455px; margin-top:-266px; display:none; }
.imgshows img{}
.imgs{ height:547px;width:410px; position:relative;}
.time{ font-size:12px; padding:5px 0 0 5px;}
.imgshows .bd{ position:absolute; top:50%; left:50%; margin-left:-170px; margin-top:-220px;}
.bkmain{ position:relative; border:1px solid #000; background:#c0c0c0; padding:19px;}
.bkmain ul{ background-color:#fff; overflow:hidden; font-size:0; width:300px; height:300px;}
.bkmain ul li{ width:60px; height:60px; display:inline-block;}
.target{ width:120px; height:120px; position:absolute; left:10px; top:10px;}
.target img{ width:120px; height:120px;}
.bklist{ text-align:center; position:absolute; width:100%; bottom:25px; left:0; font-size:0;}
.bklist em{ width:60px; height:60px; display:inline-block; margin:0 7px; overflow:hidden;}
.pt6{ background:url(${stc }images/kjcz/6.jpg) no-repeat 0 0;position: absolute;left:80px;top:440px;width:100px;height:100px;}
.pt5{background:url(${stc }images/kjcz/5.jpg) no-repeat;position: absolute;left:190px;top:440px;60px;height:100px;width:100px;}
.pt4{background:url(${stc }images/kjcz/4.jpg) no-repeat;position: absolute;left:300px;top:440px;60px;height:100px;width:100px;}
.pt3{background:url(${stc }images/kjcz/3.jpg) no-repeat;position: absolute;left:410px;top:440px;60px;height:100px;width:100px;}
.pt2{background:url(${stc }images/kjcz/2.jpg) no-repeat;position: absolute;left:520px;top:440px;60px;height:100px;width:100px;}
.pt1{background:url(${stc }images/kjcz/1.jpg) no-repeat;position: absolute;left:630px;top:440px;60px;height:100px;width:100px;}
.btn-next{position:absolute; right:10px; bottom:10px; width:80px; height:24px;}
.posi1{background:"";width:100px;height:100px;position: absolute;left:305px;top:82px;}
.posi2{background:"";width:100px;height:100px;position: absolute;left:405px;top:82px;}
.posi3{background:"";width:100px;height:100px;position: absolute;left:505px;top:82px;}
.posi4{background:"";width:100px;height:100px;position: absolute;left:305px;top:182px;}
.posi5{background:"";width:100px;height:100px;position: absolute;left:405px;top:182px;}
.posi6{background:"";width:100px;height:100px;position: absolute;left:505px;top:182px;}
.posi7{background:"";width:100px;height:100px;position: absolute;left:305px;top:282px;}
.posi8{background:"";width:100px;height:100px;position: absolute;left:405px;top:282px;}
.posi9{background:"";width:100px;height:100px;position: absolute;left:505px;top:282px;}
.pt_td{cursor: move;}
</style>
<script src="${stc }js/jquery1.41.min.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js" type="text/javascript"></script>
<script src="${stc }js/jquery.rotate.min.js" type="text/javascript"></script>
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
var times=0;
var times2;
var start_think=0;
var sum_step=0;
var imgurl="${stc }images/kjcz/";
var jindu=0;
var isend=false;
$(function(){
		setTimeout(function(){
		$("#swf1").hide();
		$(".tips").show(function(){
				$(".tips").click(function(){
					if(isend==false){
					$(".imgshows").show();
					$(".tips").hide();
					times=getNs();
					isend=true;
					}
				});
			});
		}, 8000);
		var daan=[[1,1,1,3,3,3,1,1,1],[2,1,1,2,1,1,2,3,1],[3,3,3,4,4,3,3,3,3],[3,3,3,3,4,3,3,3,3]];
		$("#nexttimu").click(function(){
			var jieguo="";
			var right=0;
			var sel="";
			$(".posi").each(function(i,o){
				jieguo=jieguo+","+$(o).attr("moves");
				var sel2=parseInt($(o).attr("data-lan2"))-1;
				sel=sel+","+sel2;
			});
			if(jindu>=3){
// 				$(".tips .bd").html("<a href='javascript:' onclick='setpanduantimu(this.lang)' lang='3'>题目做完毕了，点击鼠标返回</a>");
				questionend("2","heise","<%=path%>/user/mokuai");
				$(".imgshows").hide();
				$(".tips").show();
			}
			else{
				$(".target img").attr("src",imgurl+(jindu+2)+(jindu+2)+".bmp");
				$(".posi").css("background","").html("").attr({"lang":"","moves":""});;
				$("#nexttimu").attr("disabled","disabled");
			}
			var mod=jieguo.substring(1);
			jieguo = jieguo.substring(1).split(",");
			sel = sel.substring(1);
			for(var i = 0 ;i<daan[jindu].length;i++){
				if(daan[jindu][i]==jieguo[i]){
					right=right+1;
				}
			}
			var reaction_time = getNs()-times;
			var student_score = 36-(9-right);
			var question_no = jindu+1;
			$.post("<%=path%>/red/testredoperation/testredoperationsave",{"mod":mod,"sel":sel,"reaction_time":reaction_time,"question_no":question_no,"sum_step":sum_step,"start_think":start_think,"student_score":student_score});
			jindu=jindu+1;
			sum_step=0;
			times=getNs();
		});
});
</script>

</head>
<body oncontextmenu='return false' ondragstart='return false' >
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/kjcz.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/kjcz.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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
window.onselectstart = function() { return false;};
window.oncopy = function() { return false;}; 
</script>
</div>
<div class="tips">
	<div class="bd">点击鼠标，开始测试！</div>
</div>
<!--start-->
<div class="imgshows" id="imgshows">
	<button class="btn-next" type="button" id="nexttimu" disabled="disabled">下一题</button>
	<div class="target"><img src="${stc }images/kjcz/11.bmp"></div>
	<div class="bd">
		<div class="bkmain">
		 <ul>
		 </ul>
	</div>
	</div>
	<div class="posi posi1" dir_s="1" moves="0" data-lan2="1" style=""></div>
	<div class="posi posi2" dir_s="2" moves="0" data-lan2="1" style=""></div>
	<div class="posi posi3" dir_s="3" moves="0" data-lan2="1" style=""></div>
	<div class="posi posi4" dir_s="4" moves="0" data-lan2="1" style=""></div>
	<div class="posi posi5" dir_s="5" moves="0" data-lan2="1" style=""></div>
	<div class="posi posi6" dir_s="6" moves="0" data-lan2="1" style=""></div>
	<div class="posi posi7" dir_s="7" moves="0" data-lan2="1" style=""></div>
	<div class="posi posi8" dir_s="8" moves="0" data-lan2="1" style=""></div>
	<div class="posi posi9" dir_s="9" moves="0" data-lan2="1" style=""></div>
	<div class="bklist">
		
	</div>
	<div class="pt6 pt_td" moves="5" lang="${stc }images/kjcz/6.jpg"></div>
	<div class="pt5 pt_td" moves="4" lang="${stc }images/kjcz/5.jpg"></div>
	<div class="pt4 pt_td" moves="3" lang="${stc }images/kjcz/4.jpg"></div>
	<div class="pt3 pt_td" moves="2" lang="${stc }images/kjcz/3.jpg"></div>
	<div class="pt2 pt_td" moves="1" lang="${stc }images/kjcz/2.jpg"></div>
	<div class="pt1 pt_td" moves="0" lang="${stc }images/kjcz/1.jpg"></div>
</div>
<script type="text/javascript">
function isEmpty(src) {
	return src == "" || src == "http://mp.weixinim.com/stc/0.png";
}
var imgtouming='${stc }images/blank.gif';
function getPoint(obj) { //获取某元素以浏览器左上角为原点的坐标
    var t = obj.offsetTop; //获取该元素对应父容器的上边距
    var l = obj.offsetLeft; //对应父容器的上边距
    //判断是否有父容器，如果存在则累加其边距
    while (obj = obj.offsetParent) {//等效 obj = obj.offsetParent;while (obj != undefined)
        t += obj.offsetTop; //叠加父容器的上边距
        l += obj.offsetLeft; //叠加父容器的左边距
    }
 	return t+","+l;
 }
 	var src="";
	var isSuccess = false;
	var isreturn = false;
	var posiclass="";
	var obj1;
	var clear = true; 
	$(function(){

	$(".pt_td").mousedown(function(e){
		sum_step=sum_step+1;
		if(start_think == 0){
			start_think = getNs()-times;
			times=getNs();
		}
		var left=$(this).css("left");
		var top=$(this).css("top");
		src_1 = this.lang;
		var moves = $(this).attr("moves");
		$("body").append("<div id='mousediv' style='position:absolute; z-index:2;display: none;'></div>");
		$(document.getElementById("mousediv")).append("<p id='mouseimg' moves='"+moves+"' lang='"+src_1+"' style='background:url(" + src_1 + ") no-repeat;width:100px;height:100px;'></p>");
		var eX=e.pageX-50;
		var eY=e.pageY-50;
		$(document.getElementById("mousediv")).css("left",eX+"px");
		$(document.getElementById("mousediv")).css("top",eY+"px");
		$(document.getElementById("mousediv")).show();
		isSuccess = true;
	});
	
	
	$("body").mousemove(function(e){
		var eX=e.pageX-50;
		var eY=e.pageY-50;
		$(document.getElementById("mousediv")).css("left",eX+"px");
		$(document.getElementById("mousediv")).css("top",eY+"px");
	});
	
	$("body").mouseup(function(e){
		var b = getPoint(document.getElementById("imgshows"));
		b = b.split(",");
		var left=e.pageX-parseInt(b[1]);
		var top=e.pageY-parseInt(b[0]);
		var _src = $(document.getElementById("mouseimg")).attr("lang");
		src = !_src ? "http://mp.weixinim.com/stc/0.png" : _src;
		var moves = $(document.getElementById("mouseimg")).attr("moves");
		if(isSuccess){
			var pleft = $(".posi1").css("left");
			var ptop = $(".posi1").css("top");
			pleft = parseInt(pleft.substring(0,pleft.lastIndexOf("p")));
			ptop = parseInt(ptop.substring(0,ptop.lastIndexOf("p")));
			if(left>=pleft && left<pleft+100 && top>=ptop && top<=(ptop+100) && isEmpty($(".posi1").attr("lang"))){
				$(".posi1").css("background","url("+src+")").attr("lang",src).attr("moves",moves);
				$(".posi1").html("<img src='"+src+"' lang='1' />");
				$(".posi1").attr("data-lan2", "1");
				if(posiclass != ""){
					clear=false;
				}
			}
			else if(left>=(pleft+100) && left<(pleft+200) && top>=ptop && top<(ptop+100)  && isEmpty($(".posi2").attr("lang"))){
				$(".posi2").css("background","url("+src+")").attr("lang",src).attr("moves",moves);
				$(".posi2").html("<img src='"+src+"' lang='1' />");
				$(".posi2").attr("data-lan2", "1");
				if(posiclass != ""){
					clear=false;
				}
			}
			else if(left>=pleft+200 && left<pleft+300 && top>=ptop && top<ptop+100  && isEmpty($(".posi3").attr("lang"))){
				$(".posi3").css("background","url("+src+")").attr("lang",src).attr("moves",moves);
				$(".posi3").html("<img src='"+src+"' lang='1' />");
				$(".posi3").attr("data-lan2", "1");
				if(posiclass != ""){
					clear=false;
				}
			}
			else if(left>=pleft && left<pleft+100 && top>=ptop+100 && top<ptop+200  && isEmpty($(".posi4").attr("lang"))){
				$(".posi4").css("background","url("+src+")").attr("lang",src).attr("moves",moves);
				$(".posi4").html("<img src='"+src+"' lang='1' />");
				$(".posi4").attr("data-lan2", "1");
				if(posiclass != ""){
					clear=false;
				}
			}
			else if(left>=pleft+100 && left<pleft+200 && top>=ptop+100 && top<ptop+200  && isEmpty($(".posi5").attr("lang"))){
				$(".posi5").css("background","url("+src+")").attr("lang",src).attr("moves",moves);
				$(".posi5").html("<img src='"+src+"' lang='1' />");
				$(".posi5").attr("data-lan2", "1");
				if(posiclass != ""){
					clear=false;
				}
			}
			else if(left>=pleft+200 && left<pleft+300 && top>=ptop+100 && top<ptop+200  && isEmpty($(".posi6").attr("lang"))){
				$(".posi6").css("background","url("+src+")").attr("lang",src).attr("moves",moves);
				$(".posi6").html("<img src='"+src+"' lang='1' />");
				$(".posi6").attr("data-lan2", "1");
				if(posiclass != ""){
					clear=false;
				}
			}
			else if(left>=pleft && left<pleft+100 && top>=ptop+200 && top<ptop+300  && isEmpty($(".posi7").attr("lang"))){
				$(".posi7").css("background","url("+src+")").attr("lang",src).attr("moves",moves);
				$(".posi7").html("<img src='"+src+"' lang='1' />");
				$(".posi7").attr("data-lan2", "1");
				if(posiclass != ""){
					clear=false;
				}
			}
			else if(left>=pleft+100 && left<pleft+200 && top>=ptop+200 && top<ptop+300  && isEmpty($(".posi8").attr("lang"))){
				$(".posi8").css("background","url("+src+")").attr("lang",src).attr("moves",moves);
				$(".posi8").html("<img src='"+src+"' lang='1' />");
				$(".posi8").attr("data-lan2", "1");
				if(posiclass != ""){
					clear=false;
				}
			}
			else if(left>=pleft+200 && left<pleft+300 && top>=ptop+200 && top<ptop+300  && isEmpty($(".posi9").attr("lang"))){
				$(".posi9").css("background","url("+src+")").attr("lang",src).attr("moves",moves);
				$(".posi9").html("<img src='"+src+"' lang='1' />");
				$(".posi9").attr("data-lan2", "1");
				if(posiclass != ""){
					clear=false;
				}
			}
			else{
// 				$(".posi"+posiclass).css("background","url("+$(".posi"+posiclass).attr("lang")+")");
			}
		}
		if(isreturn == true){
			var pleft = $(".pt6").css("left");
			var ptop = $(".pt6").css("top");
			pleft = parseInt(pleft.substring(0,pleft.lastIndexOf("p")));
			ptop = parseInt(ptop.substring(0,ptop.lastIndexOf("p")));
			var moves = $(".posi"+posiclass).attr("moves");
			if(left>=pleft && left<pleft+74 && top>=ptop && top<=(ptop+60)  && moves=="1"){
				$("div").remove("#mousediv");
			}
// 			else if(left>=pleft+74 && left<pleft+148 && top>=ptop && top<=(ptop+60)  && moves=="2"){
// 				alert(2);
// 				$("div").remove("#mousediv");
// 			}
// 			else if(left>=pleft+148 && left<pleft+222 && top>=ptop && top<=(ptop+60) && moves=="3"){
// 				alert(3);
// 				$("div").remove("#mousediv");
// 			}
// 			else if(left>=pleft+222 && left<pleft+296 && top>=ptop && top<=(ptop+60)  && moves=="4"){
// 				alert(4);
// 				$("div").remove("#mousediv");
// 			}
// 			else if(left>=pleft+296 && left<pleft+370 && top>=ptop && top<=(ptop+60) && moves=="5"){
// 				alert(5);
// 				$("div").remove("#mousediv");
// 			}
// 			else if(left>=pleft+370 && left<pleft+444 && top>=ptop && top<=(ptop+60) && moves=="6"){
// 				alert(6);
// 				$("div").remove("#mousediv");
// 			}
// 			if(clear == true){
// 				$(".posi"+posiclass).css("background","url("+$(".posi"+posiclass).attr("lang")+")");
// 			}
// 			else{
// 				$(".posi"+posiclass).css("background","").attr("lang","");
// 			}
// 			clear=true;
			src_1="";
		}
		$("div").remove("#mousediv");
		var wanbi=0;
		$(".posi").each(function(i,o){
				if($(o).attr("lang")==""){
					wanbi=wanbi-1;
				}
				else{
					wanbi=wanbi+1;
				}
		});
		if(wanbi==9){
			$("#nexttimu").removeAttr("disabled");
		}
		else{
			$("#nexttimu").attr("disabled","disabled");
		}
		isSuccess = false;
		isreturn = false;
		e.returnValue = false;
		return false;
	});
	var src_1="";
	$(".posi").mousedown(function(e){
		sum_step=sum_step+1;
		var _src_1 = $(this).attr("lang");
		src_1 = !_src_1 ? "http://mp.weixinim.com/stc/0.png" : _src_1;
		if(e.which == 3){
			if($(this).html()=="" && $(this).attr("lang") != ""){
				//$(this).html("<img src='"+src+"' lang='1' />");
			}
			
			$(this).html("<img src='"+src_1+"' lang='1' />");
			var _rotate = parseInt($(this).attr("data-lan2"));
			//记录当前旋转方向，如果是4了，则重置为1，否则加1
			var _lng2 = _rotate == 4 ? 1 : _rotate + 1;
			
			//计算角度，如果是4*90度了，则是设置为0度
			_rotate = _rotate == 4 ? 0 : _rotate * 90;
			
			$(this).children("img").rotate(_rotate);
			$(this).attr("data-lan2",_lng2);
			return false;
		}
		posiclass= $(this).attr("dir_s");
		if(src_1 != "" || src_1 != null){
			$(this).html("");
			$("body").append("<div id='mousediv' style='position:absolute; z-index:2;'></div>");
			$(document.getElementById("mousediv")).append("<p id='mouseimg' lang='"+src_1+"' style='background:url(" + src_1 + ") no-repeat;width:100px;height:100px;'></p>");
			$(this).css("background","").attr("lang","");
			isreturn=true;
			isSuccess=true;
		}
		else{
			return false;
		}
	});
	});
</script>
<!--end-->
</body>
</html>