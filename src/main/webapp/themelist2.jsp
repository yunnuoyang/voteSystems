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
</div>

  <table class="layui-table" lay-data="{width: 1450, height:590, url:'theme/list', page:true, id:'idTest'}" lay-filter="demo">
      <thead>
          <tr>
              <th lay-data="{field:'id', width:200, sort: true, fixed: true}">ID</th>
              <th lay-data="{field:'themeName', width:200}">主题名</th>
              <th lay-data="{field:'endDate', width:200}">截止日期</th>
              <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">操作</th>
          </tr>
      </thead>
  </table>

  <script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">赞成</a>
      <a class="layui-btn layui-btn-xs" lay-event="edit">反对</a>

  </script>


  <script src="layui/layui.js" charset="utf-8"></script>
  <script src="js/jquery-1.8.3.min.js" charset="utf-8"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('table', function(){
        var table = layui.table;
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('请确认是否赞成', function(index){
                    var data=obj.data;
                    $.get("vote/addTicket/"+data.id+"/"+1, function(data){
                        if(data=="alreadyVote"){
                            alert("您已经投过票了")
                        }else if(data=="success"){
                            alert("投票成功")
                        }else if(data=="fail"){
                            alert("投票已截至")
                        }
                        layer.close(index);
                    });
                });
            } else if(obj.event === 'edit'){
                layer.confirm('请确认是否反对', function(index){
                    var data=obj.data;
                    $.get("vote/addTicket/"+data.id+"/"+0, function(data){
                        if(data=="alreadyVote"){
                            alert("您已经投过票了")
                        }else if(data=="success"){
                            alert("投票成功")
                        }else if(data=="fail"){
                            alert("投票已截至")
                        }
                        layer.close(index);
                    });
                });
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