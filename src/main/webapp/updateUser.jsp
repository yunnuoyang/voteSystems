<%@ page import="com.vote.pojo.User" %>
<%@ page import="com.vote.service.UserService" %>
<%@ page import="com.vote.service.Impl.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019/7/8
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户界面</title>
    <link rel="stylesheet" href="/layui/css/layui.css" type="text/css" media="all">
    <script src="/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script>
    $(function(){
        //Demo
        layui.use('form', function(){
            var form = layui.form;
            $=layui.jquery;
            form.render();
            //自定义验证规则
            form.verify({
                //value 表单的值
                loginName: function(value){
                    if(value==""){
                        return '登录名不能为空';
                    }
                },
                realName: function(value){
                    if(value==""){
                        return '真实姓名不能为空';
                    }
                },
                counties:function (value) {
                    if(value==""){
                        return '县区不能为空';
                    }
                }
                ,password: [
                    /^[\S]{6,12}$/
                    ,'密码必须6到12位，且不能出现空格'
                ]
            });

            //监听提交
            form.on('submit(go)', function(data){
                //弹出层  最终的提交信息  当前容器的全部表单字段，名值对形式：{name: value}
                // layer.msg(JSON.stringify(data.field));
                $.ajax({
                    url:"/user/updateUser",
                    type:"post",
                    data:data.field,
                    dataType:"text",
                    success:function(res) {
                        if (res == "success") {
                          layer.alert("修改成功！");
                         window.location.href="/welcome.jsp";
                        } else {
                            layer.alert("修改失败！");
                            // 提示框
                            layer.open({

                                confirmTrans: function(){
                                    //配置一个透明的询问框
                                    layer.msg('用户信息修改失败，请重新修改！', {
                                        time: 2000, //2s后自动关闭
                                        btn: ['好的', '返回']
                                    });
                                }

                            })
                            /*返回界面*/
                           window.location.href = "/updateUser.jsp";
                        }
                    }
                })
                form.render();
            });

        });


    })

</script>
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:60px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>
<fieldset class="layui-elem-field layui-field-title"  style="text-align: center;">
    <legend><h2>修改用户</h2></legend>
</fieldset>
<form class="layui-form" action="#" method="post">

    <input type="hidden" id="id" name="id" value="${user.id}">
    <input type="hidden" name="sex" value="${user.sex}">
    <div class="layui-form-item" style="margin-bottom: 30px">
        <label class="layui-form-label"  style="font-size: 20px;">登录名:</label>
        <div class="layui-input-block" >
            <input type="text" name="loginName" lay-verify="loginName" autocomplete="off" value="${user.loginName}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-bottom: 30px">
        <label class="layui-form-label"  style="font-size: 20px;">姓名:</label>
        <div class="layui-input-block">
            <input type="text" name="realName" lay-verify="realName" autocomplete="off" value="${user.realName}" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="margin-bottom: 30px">
        <label class="layui-form-label" style="font-size: 20px;">密码:</label>
        <div class="layui-input-block">
            <input type="password" name="password" lay-verify="password" value="${user.password}" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="margin-bottom: 30px">
        <label class="layui-form-label" style="font-size: 20px;">地址：</label>
        <div class="layui-input-inline">
            <select name="province"  id="province">
                <option value="">请选择省</option>
                <option value="陕西省" selected="">陕西省</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="city" id="city">
                <option value="">请选择城市</option>
                <option value="西安市" selected="">西安市</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="counties" id="counties">
                <option value="">请选择县/区</option>
                <option value="碑林区" selected="">碑林区</option>
                <option value="雁塔区">雁塔区</option>
                <option value="莲湖区">莲湖区</option>
                <option value="新城区">新城区</option>
                <option value="高新区">高新区</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <!--lay-filter 事件过滤器-->
            <button class="layui-btn" lay-submit lay-filter="go" id="updateUser">修改</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

</body>
</html>
