<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title> 学生端首页</title>

    <meta name="keywords" content="">
    <meta name="description" content="">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.jsp" />
    <![endif]-->

    <link rel="stylesheet" href="${base_path}/resources/common/boostrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${base_path}/resources/common/boostrap/css/font-awesome.min.css">
    <link rel="stylesheet" href="${base_path}/resources/common/nav_css/animate.css">
    <link rel="stylesheet" href="${base_path}/resources/common/nav_css/style.css">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:40px;">
                                        <!--<i class="glyphicon glyphicon-check"></i>-->
                                        <strong class="font-bold"></strong>
                                    </span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">实验室管理系统
                    </div>
                </li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                </li>
                <li>
                    <span class="nav-label">&nbsp;</span>
                </li>
                <li>
                    <span class="nav-label">&nbsp;</span>
                </li>
                <li>
                    <span class="nav-label">&nbsp;</span>
                </li>
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">信息</span>
                </li>
                <li>
                    <a href="#"><i class="glyphicon glyphicon-envelope"></i> <span class="nav-label">信息管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="${base_pase}/student/fillInformation.action">完善信息 <span class="fa arrow"></span></a>
                            <a class="J_menuItem" href="${base_pase}/student/stuInformation.action">查看信息 <span class="fa arrow"></span></a>
                            <a class="J_menuItem" href="${base_pase}/student/fillAwardInformation.action">添加获奖信息 <span class="fa arrow"></span></a>
                    </ul>
                </li>

                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">公告</span>
                </li>
                <li>
                    <a class="J_menuItem" href="${base_pase}/student/stuDocument.action"><i class="glyphicon glyphicon-eye-open"></i> <span class="nav-label">查看公告</span><span class="fa arrow"></span></a>

                </li>
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">密码</span>
                </li>

                <li >
                    <a class="J_menuItem"  href="${base_pase}/modifyPasswd/student.action"><i class="fa fa-edit"></i> <span class="nav-label" >修改密码</span><span class="fa arrow"></span></a>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1" style="background-color: #FFFFFF">
        <div class="row border-bottom" >
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header" >
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-info" href="#"><i class="fa fa-bars"></i> </a>     <!--左上方收缩按钮-->
                    <div>&nbsp;</div>
                    <div class="form-group text-right">
                        <span style="font-size: 28px" class="text-center">实验室人员管理系统</span>
                    </div>
                </div>
                <div>&nbsp;</div>
                <ul class="nav navbar-top-links navbar-right" >
                    <li class="dropdown">
                        <a  href="javascript:void(0)" ,class="dropdown-toggle " data-toggle="dropdown" >
                            <i class="glyphicon glyphicon-user"></i>${username}
                        </a>

                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" onclick="exitLogin()">
                            <i class="glyphicon glyphicon-off"></i>退出
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" width="100%" height="100%" src="${base_pase}/student/stuInformation.action" frameborder="0" data-id="index_v1.jsp" seamless></iframe><!--欢迎页放在这里-->
        </div>
    </div>
    <!--右侧部分结束-->
</div>

<!-- 全局js -->

<script src="${base_path}/resources/common/jquery/jquery.min.js"></script>
<script src="${base_path}/resources/common/boostrap/js/bootstrap.min.js"></script>
<script src="${base_path}/resources/common/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${base_path}/resources/common/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${base_path}/resources/common/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->

<script src="${base_path}/resources/common/nav_js/index.js"></script>
<script>
    function exitLogin(){
        $.ajax(
            {
                contentType: "application/x-www-form-urlencoded;charset=utf-8",
                async: false,
                type: 'get',
                url: 'exitLogin',
                success: function () {
                    layer.msg("正在退出。。。。");
                    location.href = '/student/login.action'
                }
            })

    }
</script>

</body>
</html>
