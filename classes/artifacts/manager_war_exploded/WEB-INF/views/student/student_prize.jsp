<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 基本表单</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    
    <link href="${base_path}/resources/common/boostrap/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${base_path}/resources/css/teacher/iCheck/custom.css" rel="stylesheet">
    <link href="${base_path}/resources/common/nav_css/animate.css" rel="stylesheet">
    <link href="${base_path}/resources/common/nav_css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${base_path}/resources/common/boostrap/css/bootstrap.min.css">

    

    <script src="${base_path}/resources/common/jquery/jquery.min.js"></script>  
    <script src="${base_path}/resources/common/boostrap/js/bootstrap.min.js"></script>  
    

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">

        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>添加获奖信息</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="form_basic.html#">选项1</a>
                                </li>
                                <li><a href="form_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                    	
                        <form method="get" class="form-horizontal">

                            <div class="form-group">
                                <label class="col-sm-2 control-label">奖项名称</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control">
                                </div>        
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">奖项级别</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control">
                                </div>        
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">奖项等级</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control">
                                </div>        
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">获奖类型</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control">
                                </div>        
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">获奖官网</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control">
                                </div>        
                            </div>
                            
                            <div class="form-group">
                                        <label class="col-sm-2 control-label">获奖时间</label>
                                        <div class="col-sm-10">
                                            <input class="form-control layer-date" placeholder="YYYYMMDD" onclick="laydate({istime: true, format: 'YYYYMMDD'})">
                                            <label class="laydate-icon"></label>
                                        </div>
                            </div>
                            
                          
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                    <button class="btn btn-white" type="submit">取消</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    

    <div id="modal-form" class="modal fade" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-6 b-r">
                            <h3 class="m-t-none m-b">登录</h3>
                            <form role="form">
                                <div class="form-group">
                                    <label>用户名：</label>
                                    <input type="email" placeholder="请输入用户名" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>密码：</label>
                                    <input type="password" placeholder="请输入密码" class="form-control">
                                </div>
                                <div>
                                    <button class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit"><strong>登录</strong>
                                    </button>
                                    <label>
                                        <input type="checkbox" class="i-checks">自动登录</label>
                                </div>
                            </form>
                        </div>
                        <div class="col-sm-6">
                            <h4>还不是会员？</h4>
                            <p>您可以注册一个账户</p>
                            <p class="text-center">
                                <a href="form_basic.html"><i class="fa fa-sign-in big-icon"></i></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${base_path}/resources/common/jquery/jquery.min.js"></script>
    <script src="${base_path}/resources/common/boostrap/js/bootstrap.min.js"></script>

    <!-- 自定义js -->
    <script src="${base_path}/resources/js/teacher/content.js"></script>
    
        <!-- 日期选择器layerDate plugin javascript -->
    <script src="${base_path}/resources/js/student/laydate/laydate.js"></script>
    
    <!-- 获奖信息文本框增删 -->
    <script src="${base_path}/resources/js/student/inputGroup.js"></script>  
    <script>  
        $(function() {  
            $('.input-group-add').initInputGroup({  
                'widget' : 'textarea', //输入框组中间的空间类型  
                /*'add' : '添加',  
                'del' : '删除'*/  
            });  
        });  
    </script>  



    <!--主页图标 iCheck -->
    <script src="${base_path}/resources/js/teacher/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

    <script>
        //外部js调用
        laydate({
            elem: '#hello', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });

        //日期范围限制
        var start = {
            elem: '#start',
            format: 'YYYY/MM/DD hh:mm:ss',
            min: laydate.now(), //设定最小日期为当前日期
            max: '2099-06-16 23:59:59', //最大日期
            istime: true,
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };
        var end = {
            elem: '#end',
            format: 'YYYY/MM/DD hh:mm:ss',
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istime: true,
            istoday: false,
            choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);
    </script>
    

</body>

</html>
