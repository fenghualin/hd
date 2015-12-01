<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery validation plug-in - main demo</title>

<script src="${stc }js/jquery.min.js"></script>
<script src="${stc }js/jquery.validate.min.js"></script>

<script>
$(function(){
	$("#commentForm").validate({
		rules:{
			name:"required",
			email:{
				required:true,
				email:true
		     }
		},
		messages:{
		     name:"Name不能为空",
		     email:{
				required:"E-mail不能为空",
		       	email:"E-mail地址不正确"
		     }
		},
		submitHandler: function(form) { 
			alert("submit?");
			form.submit();
		},
		invalidHandler: function(event, validator) {
		    // 'this' refers to the form
		    var errors = validator.numberOfInvalids();
		    if (errors) {
		      var message = errors == 1
		        ? 'You missed 1 field. It has been highlighted'
		        : 'You missed ' + errors + ' fields. They have been highlighted';
		      $("div.error span").html(message);
		      $("div.error").show();
		    } else {
		      $("div.error").hide();
		    }
		  }
	});
	// propose username by combining first- and lastname
	$("#username").focus(function() {
		var firstname = $("#firstname").val();
		var lastname = $("#lastname").val();
		if(firstname && lastname && !this.value) {
			this.value = firstname + "." + lastname;
		}
	});

	//code to hide topic selection, disable for demo
	var newsletter = $("#newsletter");
	// newsletter topics are optional, hide at first
	var inital = newsletter.is(":checked");
	var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
	var topicInputs = topics.find("input").attr("disabled", !inital);
	// show when newsletter is checked
	newsletter.click(function() {
		topics[this.checked ? "removeClass" : "addClass"]("gray");
		topicInputs.attr("disabled", !this.checked);
	});
})
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
</script>

<style type="text/css">
body{
font-size:12px;}
</style>

</head>
<body oncontextmenu='return false' ondragstart='return false'>

<h1 id="banner">
<a href="http://bassistance.de/jquery-plugins/jquery-plugin-validation/">jQuery Validation Plugin</a> Demo</h1>
<div id="main">

<p>Default submitHandler is set to display an alert into of submitting the form</p>

<form class="cmxform" id="commentForm" method="get" action="">
	<fieldset>
		<legend>请填写以下表单</legend>
		<p>
			<label for="cname">姓名 (至少2个字符)</label>
			<input name="name" type="text"/>
		<p>
			<label for="cemail">邮箱 (必填)</label>
			<input type="input" name="email"/>
		</p>
		<p>
			<label for="curl">URL (可选)</label>
			<input type="input" name="url" />
		</p>
		<p>
			<label for="ccomment">评论 (必填)</label>
			<textarea name="comment"></textarea>
		</p>
		<p>
			<input class="submit" type="submit" value="Submit"/>
		</p>
	</fieldset>
</form>
</div>


</body>
</html>
