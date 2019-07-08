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
        <div style="margin-bottom: 5px;">

            <!-- 示例-970 -->
            <ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>

        </div>

      <!-- <div class="layui-btn-group demoTable" hidden="hidden">
            <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
            <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
            <button class="layui-btn" data-type="isAll">验证是否全选</button>
        </div> --!>

        <table class="layui-table" lay-data="{width: 892, height:330, url:'theme/list', page:true, id:'idTest'}" lay-filter="demo">
            <thead>
                <tr>
                    <th lay-data="{type:'checkbox', fixed: 'left'}" style="display: none;"></th>
                    <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
                    <th lay-data="{field:'themeName', width:180}">主题名</th>
                    <th lay-data="{field:'themeDate', width:180, sort: true}">发布日期</th>
                    <th lay-data="{field:'endDate', width:180}">终止日期</th>
                    <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
                </tr>
            </thead>
        </table>

        <script type="text/html" id="barDemo">
            <!-- <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a> --!>
            <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>


        <script src="layui/layui.js" charset="utf-8"></script>
        <script src="js/jquery-1.8.3.min.js" charset="utf-8"></script>
        <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
        <script>
            layui.use('table', function(){
            var table = layui.table;
            //监听表格复选框选择
            table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
            //监听工具条
            table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                var data=obj.data;
                $.get("theme/del?id="+data.id, function(data){
                    alert("删除成功");
                });
            obj.del();
            layer.close(index);
        });
        } else if(obj.event === 'edit'){
            layer.alert('编辑行：<br>'+ JSON.stringify(data))
                window.location="theme/updateTheme?id="+obj.data.id;
        }
        });

            var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
            var checkStatus = table.checkStatus('idTest')
            ,data = checkStatus.data;
            layer.alert(JSON.stringify(data));
        }
            ,getCheckLength: function(){ //获取选中数目
            var checkStatus = table.checkStatus('idTest')
            ,data = checkStatus.data;
            layer.msg('选中了：'+ data.length + ' 个');
        }
            ,isAll: function(){ //验证是否全选
            var checkStatus = table.checkStatus('idTest');
            layer.msg(checkStatus.isAll ? '全选': '未全选')
        }
        };

            $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        });
        </script>

    </body>
</html>