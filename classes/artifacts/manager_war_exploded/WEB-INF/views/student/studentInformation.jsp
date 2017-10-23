<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title> - 基础表格</title>
		<meta name="keywords" content="">
		<meta name="description" content="">

		<link rel="shortcut icon" href="favicon.ico">
		
		<link href="${base_path}/resources/common/boostrap/css/font-awesome.css?v=4.4.0" rel="stylesheet">
		<link href="${base_path}/resources/css/teacher/iCheck/custom.css" rel="stylesheet">
		<link href="${base_path}/resources/common/nav_css/animate.css" rel="stylesheet">
		<link href="${base_path}/resources/common/nav_css/style.css?v=4.1.0" rel="stylesheet">
		<link href="${base_path}/resources/common/boostrap/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
		
		<script src="${base_path}/resources/common/jquery/jquery.min.js"></script>
		

	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInRight">



            <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>学生信息完善</h5>
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
                    	
                    	
                    	<table class="table table-bordered">
								<thead>
									<tr>
										<th>姓名</th>
										<th>性别</th>
										<th>学号</th>
										<th>身份证号</th>
										<th>电话</th>
										<th>系部</th>
										<th>专业班级</th>
										<th>辅导员</th>
									</tr>
								</thead>
								<tbody>
									<tr>

										<td>张三</td>
										<td>男</td>
										<td>15310320333</td>
										<td>411122199712240000</td>
										<td>17761280000</td>
										<td>计科系</td>
										<td>软件工程3班</td>
										<td>王文渊</td>
									</tr>
								</tbody>
							</table>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>高中毕业学校</th>
										<th>所在地区</th>
										<th>所属实验室</th>
										<th>加入实验室时间</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>成都市都江堰市青城山镇七一青城山学校</td>
										<td>成都市都江堰市青城山镇七一青城山学校</td>
										<td>云计算实验室</td>
										<td>2015.9.9</td>
									</tr>
								</tbody>
							</table>

							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="text-align: center;" colspan=7>每期总成绩</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td width="5%"></td>
										<td>大一上</td>
										<td>大一下</td>
										<td>大二上</td>
										<td>大二下</td>
										<td>大三上</td>
										<td>大三下</td>
									</tr>

									<tr>
										<td>高数</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
									</tr>
									<tr>
										<td>英语</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
									</tr>
									<tr>
										<td>c语言</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
									</tr>
								</tbody>
							</table>

							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="text-align: center;" colspan=8>获奖信息</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td width="4%">编号</td>
										<td>奖项名称</td>
										<td>奖项级别</td>
										<td>奖项等级</td>
										<td>获奖类型</td>
										<td>获奖官网</td>
										<td>获奖时间</td>
										<td>审核结果</td>
									</tr>
									<tr>
										<td width="2%">1</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
									</tr>
									<tr>
										<td>2</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
										<td>100</td>
									</tr>
								</tbody>
							</table>
                    	
                        
                    </div>
                </div>
            </div>
            </div>
        </div>


				<!-- 全局js -->
				<script src="${base_path}/resources/common/jquery.min.js"></script>
				<script src="${base_path}/resources/common/boostrap/js/bootstrap.min.js?v=3.3.6"></script>

				<%--<!-- Peity -->--%>
				<%--<script src="${base_path}/resources/common/plugins/peity/jquery.peity.min.js"></script>--%>

				<!-- 自定义js -->
				<%--<script src="${base_path}/resources/common/js/content.js?v=1.0.0"></script>--%>

				<!-- iCheck -->
				<script src="${base_path}/resources/js/teacher/icheck.min.js"></script>

				<!-- Peity -->
				<%--<script src="${base_path}/resources/common/js/demo/peity-demo.js"></script>--%>



				<script>
					$(document).ready(function() {
						$('.i-checks').iCheck({
							checkboxClass: 'icheckbox_square-green',
							radioClass: 'iradio_square-green',
						});
					});
				</script>

	</body>

</html>