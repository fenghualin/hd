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
    	<div style="margin: 50px;padding: 0;width: 530px;height: 491;position: relative;">
    	<img alt="走迷宫" src="${stc }images/snake/2a.jpg" width="530" height="491" style="top:0;left:0;position: absolute;z-index: 1">
    	<ul class="shenti" style="width:530px;height:491px;position: absolute;left: 0;top:0px;z-index: 2">
    		<li class="head" style="position: absolute;left: 265px;top: 260px;"></li>
    		
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
	//alert("碰壁了");
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
	time = getNs();
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
[1,1,530,6],
[526,7,530,491],
[39,488,525,491],
[1,7,6,491],
[40,40,250,44],
[246,7,250,39],
[284,40,492,44],
[488,45,492,277],
[488,304,492,487],
[192,450,454,454],
[40,450,158,454],
[82,455,86,486],
[40,312,44,449],
[7,223,44,227],
[40,228,44,275],
[40,45,44,186],
[81,81,454,85],
[450,86,454,454],
[455,246,487,250],
[373,412,449,416],
[229,412,339,416],
[300,417,304,449],
[81,412,196,416],
[192,417,196,449],
[81,249,85,411],
[45,271,80,275],
[81,86,85,213],
[119,119,415,123],
[412,124,415,216],
[412,281,416,378],
[160,374,411,378],
[119,336,123,378],
[119,124,123,304],
[86,300,118,304],
[124,158,378,162],
[300,163,304,192],
[374,163,378,197],
[374,223,378,250],
[379,246,449,250],
[374,272,378,335],
[336,336,411,340],
[124,336,304,340],
[223,341,227,374],
[157,163,161,305],
[192,193,227,197],
[336,193,340,304],
[341,193,373,197],
[341,272,373,276],
[162,300,304,305],
[192,198,196,299],
[223,223,304,227],
[262,193,265,222],
[300,228,304,299],
[279,272,299,276],
[223,272,245,276],
[197,247,227,251],
[223,252,227,271]
];
//死胡同区域,0,1=1号死胡同，2,3=2号死胡同，4=3号死胡同，5,6=4号死胡同
var sihutongNum;
var sihutongArray = [
[7,7,245,39],
[7,40,39,222],
[40,187,44,222],
[493,304,525,487],
[87,455,158,487],
[40,455,81,487],
[7,228,39,275],
[284,45,487,80],
[455,81,487,245],
[455,251,487,277],
[305,417,449,449],
[340,412,372,416],
[197,417,299,449],
[197,412,228,416],
[45,249,80,270],
[86,249,118,299],
[125,124,411,157],
[379,158,411,197],
[379,281,411,335],
[228,341,411,373],
[305,336,335,340],
[124,341,222,373],
[124,374,159,378],
[124,163,156,305],
[305,163,373,192],
[341,277,373,335],
[336,305,340,335],
[162,163,227,192],
[162,193,191,299],
[197,252,222,276],
[197,277,299,299],
[246,272,278,276]
];
var sihutongNumArray = [
[0,1,2],
[3],
[4],
[5],
[6],
[7,8],
[9],
[10,11],
[12,13],
[14],
[15],
[16,17],
[18],
[19,20],
[21,22],
[23],
[24],
[25,26],
[27,28],
[29,30,31]
];
function getsihutongNum(index) {
	for (var i=0; i<sihutongNumArray.length; i++) {
		for (var j=0; j<sihutongNumArray[i].length; j++) {
			if (index == sihutongNumArray[i][j]) {
				return i+1;
			}
		}
	}
}
//38=上，39=右，40=下，37=左
function preMoveShenti(left, top, type) {
	//console.log(left+","+top);
	//越界检查
	if (left < 1 || left > 530 || top < 1 || top > 491) {
		//console.log("越界异常：x="+left+",y="+top);
		return false;
	}
	//通关检查
	if (left >= 7 && top >= 488 && left <= 38 && top <= 491) {
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
			num = getsihutongNum(i);
			
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
		left: 265,
		top: 260,
		direct: 40
	}
	for (var i=1; i<bodyLength; i++) {
		var body = {
				left: 265,
				top: (260-i),
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
