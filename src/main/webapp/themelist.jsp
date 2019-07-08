<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/8
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<table class="layui-hide" id="test"></table>


<script src="layui/layui.js" charset="utf-8"></script>

<script src="js/jquery-1.8.3.min.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            id:'id'
            ,elem: '#test'
            ,url:'theme/list'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', width:180, title: 'id', sort: true}
                ,{field:'themeName', width:180, title: '主题名称'}
                ,{field:'themeDate', width:180, title: '发布日期', sort: true}
                ,{field:'endDate', width:180, title: '截止日期'}
                ,{field:'endDate', width:180, title: '操作',template:""}
            ]]
            ,done: function () {
                $("[data-field='id']").css('display','none');
            }
        });
    });
</script>

</body>
</html>