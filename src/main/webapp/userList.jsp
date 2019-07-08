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
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="layui/layui.js" charset="utf-8"></script>
    <script src="js/jquery-1.8.3.min.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
</head>
<body>
<table class="layui-hide" id="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
 <script type="text/html" id="status">
                  {{#  if(d.status === 1){ }}

                     <span class="layui-badge layui-bg-green" style="font-size: 18px">管理员</span>
                  {{#  } else { }}
                   <span class="layui-badge">用户</span>
                  {{#  } }}
            </script>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
   $(function(){
       layui.use('table', function(){
           var table = layui.table;
           table.render({
               elem: '#test'
               ,url:'user/userList'
               ,dataType:"json"
               ,cols: [[
                   {field:'id', width:190, title: 'ID', sort: true,}
                   ,{field:'loginName', width:190, title: '登录名', style:'background-color: #009688; color: #fff;'}
                   ,{field:'realName', width:190, title: '姓名'}
                   ,{field:'password', width:190, title: '密码',style:'background-color: #009688; color: #fff;'}
                   ,{field:'address', width:190, title: '地址'}
                   ,{field:'sex', width:190, title: '性别', sort: true}
                   ,{field:'status', width:190, title: '用户类型',templet: '#status'}
                   ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
               ]]
               , page: true
               ,done:function(res){
                    console.log(res);
               }
           });
       });


   })

</script>


</body>
</html>