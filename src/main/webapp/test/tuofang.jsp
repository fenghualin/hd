<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>

<!Doctype html>
<html>
  <head>
    
    <title>My JSP 'tuofang.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<META HTTP-EQUIV="Expires" CONTENT="Mon, 04 Dec 1999 21:29:02 GMT"><META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#moveable td{
border:1px solid red;
width:92px;
height:92px;

}
#moveable td div{
background-image: url(${stc }images/Puzzle2/1_1.jpg);width:92px;height:92px;
cursor: move;
}
</style>
  </head>
  <body oncontextmenu='return false' ondragstart='return false'>
  
    	<div id="moveable">
    	<table style="float:left;">
    		<tbody>
    			<tr>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data1" style="background-position: 0 0;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data3" style="background-position: 92 0;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data2" style="background-position: 184 0;"></div></td>
    			</tr>
    			<tr>
    				<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data7" style="background-position: 0 92;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data4" style="background-position: 0 184;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data5" style="background-position: 184 184;"></div></td>
					
    			</tr>
    			<tr>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data6" style="background-position: 92 184;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data8" style="background-position: 184 92;"></div></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"><div id="data9" style="background-position: 92 92;"></div></td>
    			</tr>
    		</tbody>
    	</table>
    	<table style="float:left;" id="movescore">
    		<tbody>
    			<tr>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td>
    			</tr>
    			<tr>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td>
    			</tr>
    			<tr>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td>
					<td onmousedown="imageDown(this)" onmouseup="imageUp(this)"></td>
    			</tr>
    		</tbody>
    	</table>
    	</div>
<script type="text/javascript">
var currHtml;
var before;
var step=0;
var score = 0;
var time=0;
function imageDown(thiss) {
	currHtml = thiss.innerHTML;
	before = thiss;
}
function imageUp(thiss) {
	if (thiss.innerHTML) {
		return false;
	}
	before.innerHTML = "";
	thiss.innerHTML = currHtml;
	checkComplete();
	step=step+1;
	if(step==1){
		time=getNs();
	}
}
function checkComplete() {
	var divs = document.getElementById("movescore").getElementsByTagName("div");
	if (divs.length < 9) {
			return false;
	}
	score = 0;

	for (var i=0; i<divs.length; i++) {
		if (divs[i].getAttribute("id") != "data"+(i+1)) {
			return false;
		} else {
			score ++;
		}
	}
	alert("完成");
}
</script>
</body>
</html>
