<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 412470220@qq.com
  Date: 2019/7/5
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/js/jquery-1.8.3.min.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header" style="height: 70px;">
        <div class="layui-logo" style="width:300px" ><%--<img src="images/link.jpg" style="width: 40px;height: 40px;">--%>
            <span style="font-size:30px; font-weight:bolder;font-family:'幼圆';width: 300px;">在 线 投 票 系 统</span></div>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${user.realName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:void(0)" >基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="logout">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black" style="margin-top: 10px; font-size:18px;">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="javascript:;">投票管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;"  onclick="toShow('/themelist2.jsp')">用户投票</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="toShow" src="/welcome.jsp" style="height:600px;width:100%;border:0;">
        </iframe>

    </div>

    <script>
        function toShow(obj) {
            var src = $("#toShow").attr("src",obj);
        }
        $(function(){
                $("#userlist").bind("click",function(){
                    var src = $("#toShow").attr("src",'userList.jsp');
                })
        })

    </script>
    <div class="layui-footer"style="text-align: center;font-size: 20px;">
        <!-- 底部固定区域 -->
        © bjwlxy.com - 宝鸡文理学院实训
    </div>
</div>
<script src="/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });
</script>
</body>
</html>