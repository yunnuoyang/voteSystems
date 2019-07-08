<%--
  Created by IntelliJ IDEA.
  User: shenying
  Date: 2019/7/8
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>在线投票系统</title>
    <style type="text/css">

        a:visited{color: #f89406;}
        a:hover{color:pink;}
        a:active{color:#ccc;}
        a{text-decoration: none}
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login/css/style.css" type="text/css" />

</head>

<body>
<div id="container">

    <!--
    服务器跳转时，路径相对的是服务器WebContent
    浏览器请求跳转时， 路径相对的当前的jsp

     在JSP  凡是有  action  src  href 都要去写绝对路径  加上工程名称的路径
    -->
    <form action="${pageContext.request.contextPath }/user/login" method="post">
        <div class="login">在线投票系统
            <span style="color:red">${err }</span>
            <a href="/register.jsp">注册</a>

        </div>
        <div class="username-text">用户名:</div>
        <div class="password-text">密码:</div>
        <div class="username-field">
            <input type="text" name="loginName" value="" />
        </div>
        <div class="password-field">
            <input type="password" name="password" value="" />
        </div>
        <input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住我</label>


        <div class="forgot-usr-pwd"></div>
        <input type="submit" value="GO" />
    </form>
</div>

</body>
</html>
