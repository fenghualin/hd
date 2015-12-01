<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>未找到您要访问的页面</title>
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
		
		<script >
			function jump(){
				window.parent.location="login";	
			}
		</script>
        <style type="text/css">  
            .align-center{  
                margin:0 auto;      /* 居中 这个是必须的，，其它的属性非必须 */
                margin-top:200px;  
                width:600px;        /* 给个宽度 顶到浏览器的两边就看不出居中效果了 */   
                text-align:center;  /* 文字等内容居中 */
                font-size:22px; 
                font-weight:bold; 
            }  
         </style>
	</head>
	<body id="errorbody">
		<div class="align-center">抱歉，未找到您要访问的页面，请与系统管理员联系。</div> 
	</body>
</html>