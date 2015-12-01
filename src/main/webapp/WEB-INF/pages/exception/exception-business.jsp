<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>成环度脑AT测试网站消息</title>
    </head>
    <body>
        <% Exception e = (Exception)request.getAttribute("ex"); %>
        <H2>环度脑AT测试网站消息</H2>
        <hr />
        <P> <%= e.getMessage()%></P>
        <%--
        <P>错误信息：</P>
             <% e.printStackTrace(new java.io.PrintWriter(out)); %>
        --%>
    </body>
</html>