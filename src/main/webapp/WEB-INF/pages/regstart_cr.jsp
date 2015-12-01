<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% request.setAttribute("path", request.getContextPath()); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<title>注册</title>
<link rel="stylesheet" type="text/css" href="${stc }css/common.css">
<link rel="stylesheet" type="text/css" href="${stc }css/css.css">

<link rel="stylesheet" type="text/css" href="${stc }js/easyui/jquery-easyui-1.3.2/demo/demo.css"/>
<link rel="stylesheet" type="text/css" href="${stc }js/easyui/jquery-easyui-1.3.2/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${stc }js/easyui/jquery-easyui-1.3.2/themes/default/easyui.css" id="easyuiCss"/>
<script type="text/javascript" src="${stc }js/easyui/jquery-easyui-1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="${stc }js/easyui/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${stc }js/easyui/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>
<script src="${stc }Scripts/swfobject_modified.js" type="text/javascript"></script>
<script src="${stc }js/yellow.js"></script>
<script>
	$(function(){
			var scheight = $(".fullscreen").height();
			$(".fullscreen").css("margin-top",-(scheight/2));
		});
</script>
<script type="text/javascript">
$(function(){
		setTimeout(function(){
			$("#swf1").hide();
			$("#swf2").show("fast",function(){
				setTimeout(function(){
					$("#openreg").show();
						}, 3333);
					}
			);
		}, 10000);
		
		//打开表单
		$("#openreg").click(function(){
				$("#regform").show("fast");
			});
// 	$('#create_time').datebox({
// 		required:true ,
// 	    onSelect: function(date){
// 	        alert(date.getFullYear()+":"+(date.getMonth()+1)+":"+date.getDate());
// 	    }
// 	});
// 	$("#create_time").val("");
	$('#create_time').datetimebox({    
    required: true,    
    showSeconds: true   
    });
});  
</script>
<style type="text/css">
#echo{
z-index: 8;
color: #F00;
border: 1px solid #F90;
background-color: #FFF;
font-size: 12px;
padding: 0 5px;
font-weight: bold;
}
</style>
</head>
<body oncontextmenu='return false' ondragstart='return false'>
<div class="fullscreen" id="swf1">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750" id="FlashID">
				<param name="movie" value="${stc }swf/copyright.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<param name="SCALE" value="exactfit">
				<param name="BGCOLOR" value="#000000">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object data="${stc }swf/copyright.swf" type="application/x-shockwave-flash" width="1000" height="750" id="FlashID2" align="absmiddle">
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

<div class="fullscreen" id="swf2" style="display:none;">
		<a id="openreg"  href="#">打开表单</a>
		<form:form action="${path }/user/userdatasave" method="post" commandName="user" id="registerForm">
		<form:hidden path="id"/>
		<div id="regform" class="regform">
			<div class="bd">
					<div class="rows rows1 clearfix">
						<div class="ibox clearfix">
							<label><span>Name</span><b>(姓名)</b></label>
<!-- 							<input class="w55" name="name" type="text"/> -->
							<form:input path="name" cssClass="w55"/>
						</div>
						<div class="ibox clearfix">
							<label><span>Age</span><b>(年龄)</b></label>
<!-- 							<input type="text" name="nianling" class="w44" /> -->
							<form:input path="nianling" cssClass="w44"/>
						</div> 
						<div class="ibox clearfix">
							<label><span>Nation</span><b>(民族)</b></label>
						<form:select path="minzu" cssClass="w70">
							<jsp:include page="/WEB-INF/pages/public/minzuList.jsp" />
							<c:forEach var="minzu"  items="${minzuList  }">
								<form:option value="${minzu }" />
							</c:forEach>
						</form:select>
						</div>
						<div class="ibox clearfix">
							<label><span>Nationality</span><b>(国籍)</b></label>
							<form:select path="guoji" cssClass="w130">
								<form:option value="中国"/>
								<form:option value="其它" />
							</form:select>
						</div> 
					</div>
					<div class="rows rows2 clearfix">
						<div class="ibox clearfix">
							<label><span>Sex</span><b>(性别)</b></label>
							<form:select path="xingbie" cssClass="w44">
								<form:option value="男"/>
								<form:option value="女"/>
							</form:select>
						</div>
						<div class="ibox clearfix">
							<label><span>Vision</span><b>(视力)</b></label>
							<form:select path="shili" cssClass="w44">
								<form:option value="正常"/>
								<form:option value="色弱"/>
								<form:option value="色盲"/>
							</form:select>
						</div> 
						<div class="ibox clearfix">
							<label><span>Blood-group</span><b>(血型)</b></label>
							<form:select path="xiexing" cssClass="w55">
								<form:option value="A"/>
								<form:option value="B"/>
								<form:option value="AB"/>
								<form:option value="O"/>
							</form:select>
						</div>
						<div class="ibox clearfix">
							<label><span>Date</span><b>(测试日期)</b>
								<form:input cssClass="w130" id="create_time" path="createTime"/>
							</label>
							
						</div> 
					</div>
					 
					<div class="rows rows3 clearfix">
						<div class="ibox clearfix">
							<label><span>Current Position</span><b>(单位)</b></label>
							 <form:input cssClass="w290" path="school"/>
						</div>
						<div class="ibox clearfix">
							<label><span>Student Type</span><b>(学习类型)</b></label>
							<form:select cssClass="w100" path="xueshengleixing">
								<form:option value="文科"/>
								<form:option value="理科"/>
								<form:option value="艺术生"/>
								<form:option value="体育生"/>
								<form:option value="未定向"/>
							</form:select>
						</div>
					</div>
					<div class="clearfix" style="padding:0 30px; border:1px solid #009;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<div class="clearfix" style="margin-bottom:16px; padding-top:20px">
										<div class="ibox clearfix">
										<label style="width:97px;"><span>Duty</span><b>(职务)</b></label>
										 <form:input cssClass="w130" path="nianji"/>
										</div>
									</div>
									<div class="clearfix" style="margin-bottom:16px;">
										<div class="ibox clearfix">
										<label style="width:100px;"><span>Education</span><b>(学历)</b></label>
										 <form:input cssClass="w130" path="banji"/>
										</div>
									</div>
									<div class="clearfix" style="margin-bottom:16px;">
										<div class="ibox clearfix">
										<label style="width:97px;"><span>Ability</span><b>(特长)</b></label>
										 <form:input cssClass="w130" path="techang"/>
										</div>
									</div>
									<div class="clearfix" style="padding-bottom:20px;">
										<div class="ibox clearfix">
										<label style="width:97px;"><span>Id card</span><b>(身份证号)</b></label>
										 <form:input cssClass="w130" path="shenfenzheng"/>
										</div>
									</div>
								</td>
								<td align="left" style="border-left:1px solid #009; padding-left:20px;">
									<div class="clearfix" style="margin-bottom:16px;">
										<div class="ibox clearfix">
										<label style="width:130px;"><span>Parents age</span><b>(双亲年龄)</b></label>
										<label style="border-left:1px solid #000; margin-left:5px; padding-left:5px;"><strong>F</strong></label>
										<form:input cssClass="w80" path="fuqinnianling" />
										<label style="border-left:1px solid #000; margin-left:5px;padding-left:5px;"><strong>M</strong></label>
										<form:input cssClass="w80" path="muqinnianling" />
										</div>
									</div>
									<div class="clearfix" style="margin-bottom:16px;">
										<div class="ibox clearfix">
										<label style="width:130px;"><span>Antecedents</span><b>(文化程度)</b></label>
										<label style="border-left:1px solid #000; margin-left:5px; padding-left:5px;"><strong>F</strong></label>
										<form:select cssClass="w80" path="fuqinwenhuachengdu">
											<form:option value="小学"/>
											<form:option value="初中"/>
											<form:option value="高中"/>
											<form:option value="大专"/>
											<form:option value="本科"/>
											<form:option value="硕士"/>
											<form:option value="博士"/>
										</form:select>
										<label style="border-left:1px solid #000; margin-left:5px;padding-left:5px;"><strong>M</strong></label>
										<form:select cssClass="w80" path="muqinwenhuachengdu">
											<form:option value="小学"/>
											<form:option value="初中"/>
											<form:option value="高中"/>
											<form:option value="大专"/>
											<form:option value="本科"/>
											<form:option value="硕士"/>
											<form:option value="博士"/>
										</form:select>
										</div>
									</div>
									<div class="clearfix" style="margin-bottom:16px;">
										<div class="ibox clearfix">
										<label style="width:130px;"><span>Work</span><b>(双亲职业)</b></label>
										<label style="border-left:1px solid #000; margin-left:5px; padding-left:5px;"><strong>F</strong></label>
										<form:input cssClass="w80" path="fuqinzhiye" />
										<label style="border-left:1px solid #000; margin-left:5px;padding-left:5px;"><strong>M</strong></label>
										<form:input cssClass="w80" path="muqinzhiye" />
										</div>
									</div>
									<div class="clearfix">
										<div class="ibox clearfix">
										<label style="width:130px;"><span>Income</span><b>(双亲收入)</b></label>
										<label style="border-left:1px solid #000; margin-left:5px; padding-left:5px;"><strong>F</strong></label>
										<form:select cssClass="w80" path="fuqinshouru">
											<form:option value="0-2000"/>
											<form:option value="2000-5000"/>
											<form:option value="5000-10000"/>
											<form:option value="10000-20000"/>
											<form:option value="20000以上"/>
										</form:select>
										<label style="border-left:1px solid #000; margin-left:5px;padding-left:5px;"><strong>M</strong></label>
										<form:select cssClass="w80" path="muqinshouru">
											<form:option value="0-2000"/>
											<form:option value="2000-5000"/>
											<form:option value="5000-10000"/>
											<form:option value="10000-20000"/>
											<form:option value="20000以上"/>
										</form:select>
										</div>
									</div>
								</td>
							</tr>
						</table>
						 
					</div>
					<div class="rows rows5 clearfix">
						<div class="ibox clearfix">
							<label><span>Telephone</span><b>(联系电话)</b></label>
							<form:input cssClass="w180" path="yidongdianhua"/>
						</div>
						<div class="ibox clearfix">
							<label><span>E-mail</span><b>(邮箱)</b></label>
							<form:input cssClass="w180" path="email" />
						</div>
					</div>
					<div class="rows rows6 clearfix">
						<div class="ibox clearfix">
							<label><span>Home</span><b>(家庭住址)</b></label>
							<form:input class="w300" path="dizhi"/>
						</div>
						<span id="echo">小提示：请认真填写资料</span>
						<button type="submit" class="btn-enter" id="submitbtn" style="display: ;"></button>
<%--						<a href="javascript:void(0);" class="btn-enter" onclick="$('#submitbtn').click();"></a>--%>
					</div>  
			</div>
		</div>
		
		</form:form>
		<object id="FlashID21" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="750">
				<param name="movie" value="${stc }swf/reg.swf">
				<param name="quality" value="high">
				<param name="wmode" value="opaque">
				<param name="swfversion" value="7.0.70.0">
				<!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
				<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
				<!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
				<!--[if !IE]>-->
				<object type="application/x-shockwave-flash" data="${stc }swf/reg.swf" width="1000" height="750" id="FlashID22">
						<!--<![endif]-->
						<param name="quality" value="high">
						<param name="wmode" value="opaque">
						<param name="swfversion" value="7.0.70.0">
						<param name="expressinstall" value="${stc }Scripts/expressInstall.swf">
						<!-- 浏览器将以下替代内容显示给使用 Flash Player 6.0 和更低版本的用户。 -->
						<div>
								<h4>此页面上的内容需要较新版本的 Adobe Flash Player。</h4>
								<p><a href="http://www.adobe.com/go/getflashplayer"><img src="${stc }images/get_flash_player.gif" alt="获取 Adobe Flash Player" width="112" height="33" /></a></p>
						</div>
						<!--[if !IE]>-->
				</object>
				<!--<![endif]-->
		</object>
</div>
<script type="text/javascript">
swfobject.registerObject("FlashID21");
swfobject.registerObject("FlashID22");
NoRightClick("FlashID21");
//NoRightClick("FlashID22");
</script>
<!-- 表单验证 -->
<%--<link rel="stylesheet" type="text/css" href="http://mp.weixinim.com/stc/plugin/dialog/dialog.css" media="all" />--%>
<%--<script type="text/javascript" src="http://mp.weixinim.com/stc/plugin/dialog/dialog_min.js"></script>	--%>

<script src="${stc }js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(function(){
$("#testclick").click(function(){
// 		alert("d");
		$.post("${path}/orange/testclick");
	});
	$("#testclick1").click(function(){
// 		alert("timu");
		$.post("${path}/user/savejindu",{"vals":"1"});
	});
	$("#testclick2").click(function(){
// 		alert("mokuai");
		$.post("${path}/user/savejindu",{"vals":"2"});
	});
	$("#registerForm").validate({
		rules:{
			name:"required",
			nianling: {required:true, number: true, range: [0, 120]},
			createTime: {required: true, date: true },
			school: {required: true},
			nianji: {required: true},
			techang: {required: true},
			shenfenzheng: {required: true, rangelength: [15,18]},
			fuqinnianling: {required: true, number: true, range: [0, 120]},
			muqinnianling: {required: true, number: true, range: [0, 120]},
			fuqinzhiye: {required: true},
			muqinzhiye: {required: true},
			yidongdianhua: {required: true},
			email: {required: true},
			dizhi: {required: true}
		},
		messages:{
		     name:"姓名不能为空",
		     nianling: {required:"请输入年龄", number: "请输入正确的年龄", range: "年龄只能0到120岁"},
			 createTime: {required: "请选择时间", date: "请输入正确的时间"},
			 school: {required: "请输入学校名称", minlength: "学校名称不能低于5个字"},
			 nianji: {required: "请输入班级", minlength: "班级名称不能低于3个字"},
			 techang: {required: "请输入特长", minlength: "特长介绍不能低于5个字"},
			 shenfenzheng: {required: "请输入身份证号码", rangelength: "请输入正确的身份证号码"},
			 fuqinnianling: {required: "请输入父亲年龄", number: "请输入正确的年龄", range: "年龄只能0到120岁"},
			 muqinnianling: {required: "请输入母亲年龄", number: "请输入正确的年龄", range: "年龄只能0到120岁"},
			 fuqinzhiye: {required: "请输入父亲职业", minlength: "职业名称不能低于2个字"},
			 muqinzhiye: {required: "请输入母亲职业", minlength: "职业名称不能低于2个字"},
			 yidongdianhua: {required: "请输入联系电话", number: "请输入正确的电话号码", rangelength: "电话号码只能是11位"},
			 email: {required: "请输入邮箱", email: "请输入正确格式的邮箱"},
			 dizhi: {required: "请输入家庭住址", minlength: "请输入更详细的地址（至少10个字）"}
		},
		submitHandler: function(form) {
			//form.validate();
			alert("资料保存成功");
			form.submit();
		},
		showErrors: function(errorMap, errorList) {
		    if (errorList.length > 0) {
		    	//alert(errorList[0].message);
		    	$("#echo").html(errorList[0].message);
		    }
		}
	});
});
/*
jQuery.extend(jQuery.validator.messages, {
	  required: "请输入该值",
	  remote: "请输入正确的值",
	  email: "请输入正确格式的电子邮件",
	  url: "请输入合法的网址",
	  date: "请输入合法的日期",
	  dateISO: "请输入合法的日期 (ISO).",
	  number: "请输入合法的数字",
	  digits: "只能输入整数",
	  creditcard: "请输入合法的信用卡号",
	  equalTo: "请再次输入相同的值",
	  accept: "请输入拥有合法后缀名的字符串",
	  maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
	  minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
	  rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
	  range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
	  max: jQuery.validator.format("请输入一个最大为{0} 的值"),
	  min: jQuery.validator.format("请输入一个最小为{0} 的值")
	});
	*/
</script>
<!-- <input type="button" id="testclick" style="position: absolute;z-index: 100px;" value="test点击"/> -->
<!-- <input type="button" id="testclick1" style="position: absolute;z-index: 100px;margin-top: 30px;" value="test点击timu"/> -->
<!-- <input type="button" id="testclick2" style="position: absolute;z-index: 100px;margin-top: 60px;" value="test点击mokuai"/> -->
</body>
</html>
