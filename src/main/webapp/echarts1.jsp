<%--
  Created by IntelliJ IDEA.
  User: 412470220@qq.com
  Date: 2019/7/8
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/echarts.common.min.js"></script>
</head>
<body>
    <div id="main" style="width: 600px;height:400px; position: absolute;left: 30px;top: 100px"></div>
    <div id="main2" style="width: 600px;height:400px; position: absolute;left: 600px;top: 100px"></div>

    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"/echarts/getBarData",
                type:"get",
                dataType:"JSON",
                success:function(data){
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('main'));

                    // 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: '投票发布统计'
                        },
                        tooltip: {},
                        legend: {
                            data:['数量']
                        },
                        xAxis: {
                            data: data.date
                        },
                        yAxis: {},
                        series: [{
                            name: '该月新增主题',
                            type: 'line',
                            itemStyle : {
                                normal : {
                                    lineStyle:{
                                        color:'#87ceeb'  //线的颜色
                                    }
                                }
                            },
                            data: data.count
                        }]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                }
            });
        })
    </script>

    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"/echarts/getBarData2",
                type:"get",
                dataType:"JSON",
                success:function(data){
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('main2'));

                    // 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: '投票人数统计'
                        },
                        tooltip: {},
                        legend: {
                            data:['数量']
                        },
                        xAxis: {
                            data: data.date
                        },
                        yAxis: {},
                        series: [{
                            name: '该月投票人数',
                            type: 'bar',
                            itemStyle : {
                                normal : {
                                    lineStyle:{
                                        color:'#87ceeb'  //线的颜色
                                    }
                                }
                            },
                            data: data.count
                        }]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                }
            });
        })
    </script>

</body>
</html>
