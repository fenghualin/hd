<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>

<!Doctype html>
<html>
  <head>
    
    <title>My JSP 'migong.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT"><META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.shenti{
font-size: 0;}
.shenti,.shenti.li{
padding:0;margin:0;}
.shenti li{
position: relative;
list-style: none;
}
.shenti li.head{
width:3px;
height:3px;
background-color: red;
overflow: hidden;}
.shenti li.body{
width:3px;
height:3px;
background-color: red;
overflow: hidden;}

</style>
  </head>
  
  <body onkeydown="moveShenti(event)" oncontextmenu='return false' ondragstart='return false'>
    	<div style="margin: 50px;padding: 0;width: 476px;height: 476;position: relative;">
    	<img alt="走迷宫" src="${stc }images/snake/1a.jpg" width="476" height="476" style="top:0;left:0;position: absolute;z-index: 1">
    	<ul class="shenti" style="width:476px;height:476px;position: absolute;left: 0;top:0px;z-index: 2">
    		<li class="head" style="position: absolute;left: 238px;top: 238px;"></li>
    		
    	</ul>
    	</div>
    	<div>介绍:</div>
	<input type="button" onclick="buttonClick(this, 3)" value="开始测试"/>    	
<!-- 自行修改_↓↓↓↓↓↓↓↓↓↓ -->
<script type="text/javascript">
//开始默认是向下移动的
var speed = 50;		//速度(延迟)毫秒
var sspeed = 1.8;	//斜着移动的速度是直着移动的速度倍数
var bodyLength = 30;	//身体长度
//提示
function gameSihutong(gameSihutongNum) {
	alert("进入"+gameSihutongNum+"死胡同");
}
function gamePengbi(left, top, ax, ay, bx, by) {
	//console.log("碰壁了：x=" + left+",y="+top+",墙壁区域：ax="+ax+",ay="+ay+",bx="+bx+",by="+by);
	alert("碰壁了");
}
function gameEnd() {
	
	alert("恭喜你已经通关");
}
function buttonClick(thiss, time) {
	if (time <= 0) {
		start();
		thiss.value = "测试进行中。。。";
	} else {
		thiss.value = "("+time+")秒后开始";
		setTimeout(function(){
			buttonClick(thiss,time-1);
		}, 1000);
	}
	
}
function gameStart() {
	//alert("游戏开始");
}
</script>  	
<!-- 自行修改_↑↑↑↑↑↑↑↑↑↑↑ -->



<!-- 不用修改_↓↓↓↓↓↓↓↓↓↓↓ -->    	
<script type="text/javascript" src="${stc }js/jquery1.42.min.js"></script>    	
<script type="text/javascript">
var moveThread;
var moveAbled = true;
var gameIsEnd = false;

function moveProcess(keyCode) {
	//console.log(event.keyCode);
	//38=上，39=右，40=下，37=左
	var pos = $(".shenti>.head").position();
	//pos.left,pos.top
	var top = pos.top;
	var left = pos.left;	switch (keyCode) {
	case 37:
		left --;
		break;
	case 38:
		top --;
		break;
	case 39:
		left ++;
		break;
	case 40: 
		top ++;
		break;
		//3839=上右,3837=上左,4039=下右,4037=下左		
	case 3839:
		top --;
		left ++;
		break;
	case 3837:
		top --;
		left --;
		break;
	case 4039:
		left ++;
		top ++;
		break;
	case 4037:
		left --;
		top ++;
		break;
	default:
		//console.log("不处理的keyCode: " + keyCode);
		return false;
	}
	if ( preMoveShenti(left+1, top+1, keyCode) ) {
		$(".shenti>.head").css("left", left);
		$(".shenti>.head").css("top", top);
		return true;
	} else {
		return false;
	}
}
function moveProcessTool(event) {
	if (moveProcess(event)) {
		moveThread = setTimeout(function(){
			//移动前的位置
			var pos = $(".shenti>.head").position();
			var top = pos.top;
			var left = pos.left;
			moveProcessTool(event);
			moveHeadListener(event, left, top);
		}, event < 100 ? speed : speed*sspeed);
	} else {
		moveAbled = false;
	}
}


var currDirectIndex = 4;
var direct = [
              38,3839,39,4039,40,4037,37,3837
];
function start() {
	moveShenti(null, true);
}
function moveShenti(event, forceStart) {
	gameStart();
	if (forceStart) {
		clearTimeout(moveThread);
		moveProcessTool(direct[currDirectIndex]);
		return true;
	}
	moveAbled = true;
	//console.log(event.keyCode);
	//38=上，39=右，40=下，37=左
	//3839=上右,3837=上左,4039=下右,4037=下左
	if (event.keyCode == 68) {
		//左边移动index减
		if (currDirectIndex == 0) {
			currDirectIndex = 7;
		} else {
			currDirectIndex --;
		}
	} else if (event.keyCode == 75) {
		//右边移动index加
		if (currDirectIndex == 7) {
			currDirectIndex = 0;
		} else {
			currDirectIndex ++;
		}
	} else {
		//未知
	}
	
	//console.log("移动方向："+direct[currDirectIndex]);
	if (!gameIsEnd && (event.keyCode == 68 || event.keyCode == 75) ) {
		clearTimeout(moveThread);
		moveProcessTool(direct[currDirectIndex]);
	}
	
}
var headSize = 3;
//墙壁区域
var qiangbiArray = [
[1,1,476,9],
[468,10,476,217],
[468,268,476,476],
[1,468,467,476],
[1,10,9,467],
[73,72,467,80],
[400,81,408,407],
[73,399,399,407],
[73,393,81,398],
[73,81,81,342],
[138,137,215,145],
[266,137,343,145],
[335,146,343,342],
[82,334,334,342],
[138,146,146,333],
[198,198,275,205],
[276,146,283,283],
[265,276,275,283],
[198,276,215,283],
[198,206,205,275]
];
//死胡同区域,0,1=1号死胡同，2,3=2号死胡同，4=3号死胡同，5,6=4号死胡同
var sihutongNum;
var sihutongArray = [
[10,10,467,71],
[10,72,72,342],
[82,81,215,136],
[82,137,137,332],
[409,81,467,217],
[265,284,283,333],
[284,146,334,333]
];
//38=上，39=右，40=下，37=左
function preMoveShenti(left, top, type) {
	//console.log(left+","+top);
	//越界检查
	if (left < 1 || left > 476 || top < 1 || top > 476) {
		//console.log("越界异常：x="+left+",y="+top);
		return false;
	}
	//通关检查
	if (left >= 468 && top >= 218 && left <= 476 && top <= 267) {
		gameIsEnd = true;
		gameEnd();
		return false;
	}
	//碰壁
	for (var i=0; i<qiangbiArray.length; i++) {
		//遍历墙壁的块
		var ax = qiangbiArray[i][0];
		var ay = qiangbiArray[i][1];
		var bx = qiangbiArray[i][2];
		var by = qiangbiArray[i][3];
		if (type == 39) {
			
			ax = ax - 2;
		} else if (type == 40) {
			ay = ay - 2;
		}
		//碰壁检查
		if ((left >= ax && top >= ay) && ((left) <= bx && (top) <= by)) {
			gamePengbi(left, top, ax, ay, bx, by);
			return false;
		}
	}
	//死胡同区域,0,1=1号死胡同，2,3=2号死胡同，4=3号死胡同，5,6=4号死胡同,sihutongNum=死胡同号码
	var isJoinSihutong = false;
	for (var i=0; i<sihutongArray.length; i++) {
		if (isJoinSihutong) break;
		//遍历墙壁的块
		var ax = sihutongArray[i][0];
		var ay = sihutongArray[i][1];
		var bx = sihutongArray[i][2];
		var by = sihutongArray[i][3];
		if (type == 39) {
			
			ax = ax - 2;
		} else if (type == 40) {
			ay = ay - 2;
		}
		//碰壁检查
		if ((left >= ax && top >= ay) && ((left) <= bx && (top) <= by)) {
			//gamePengbi(left, top, ax, ay, bx, by);
			//进入死胡同区域
			//console.log("进入死胡同");
			isJoinSihutong = true;
			var num = null;
			if (i == 0 || i == 1) {
				num = 1;
			} else if (i == 2 || i == 3) {
				num = 2;
			} else if (i == 4) {
				num = 3;
			} else if (i == 5 || i == 6) {
				num = 4;
			} else {
				alert("未知的死胡同");
			}
			//console.log("死胡同编号：" + num+"，上一次进入死胡同的编号：" + sihutongNum + "他们相等吗？" + (num == sihutongNum));
			if (num!=null && !(num == sihutongNum)) {
				sihutongNum = num;
				gameSihutong(sihutongNum);
				//console.log("进入死胡同");
			}
			return true;
		}
	}
	sihutongNum = null;
	return true;

	return true;
}

//头部移动的时候，后面的跟着移动
var bodyArray;
$(function(){
	//left: 238;top: 238
	bodyArray = new Array(10);
	bodyArray[0] = {
		left: 238,
		top: 238,
		direct: 40
	}
	for (var i=1; i<bodyLength; i++) {
		var body = {
				left: 238,
				top: (238-i),
				direct: 40,
				parent: bodyArray[i-1],
				id: "body"+(i+1)
		}
		bodyArray[i] = body;
		$(".shenti>.head").after('<li class="body" id="'+body.id+'" style="position: absolute;left: '+body.left+'px;top: '+body.top+'px;"></li>')
	};
});
function moveHeadListener(direct, left, top) {
	//console.log("头部移动监听：" + direct+",bodyArray: " + bodyArray);
	
	moveBodyTo($("#body1"), left, top);
	bodyArray[0] = {
			left: left,
			top: top
	};
	//console.log("1号身体移动到：" + bodyArray[0].left+","+bodyArray[0].top);
	
	for (var i=1; i<bodyLength; i++) {
		//console.log(bodyArray[i].id);
		var move_left = bodyArray[i-1].left;
		var move_top = bodyArray[i-1].top;
		moveBodyTo($("#"+bodyArray[i].id), move_left, move_top, bodyArray[i]);
		
	}
	for (var i=bodyLength-1; i>0; i--) {
		var move_left = bodyArray[i-1].left;
		var move_top = bodyArray[i-1].top;
		bodyArray[i] = {
				left: move_left,
				top: move_top,
				direct: 40,
				parent: bodyArray[i-1],
				id: "body"+(i+1)
		}
	}
	
}
function moveBodyTo($body, left, top, body) {
	
	$body.css("left", left);
	$body.css("top", top);
}

</script>
<!-- 不用修改_↑↑↑↑↑↑↑↑↑ -->
</body>

</html>
