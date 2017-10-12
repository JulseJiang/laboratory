<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>教师端首页</title>
    <link rel="stylesheet" href="${path}/resources/css/bootstrap.min.css" />
     <script type="application/javascript" src="${path}/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/resources/common/layer/2.4/layer.js"></script>
    <script type="application/javascript" src="${path}/resources/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${path}/resources/js/jquery.js"></script>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column">
			<%--顶部导航信息--%>
			<ul class="nav nav-tabs">
				<li class="active">
					 <a href="#">首页</a>
				</li>
				<li>
					 <a href="#">公告</a>
				</li>
				<li>
					 <a href="#">信息</a>
				</li>
				<%--实验室切换信息--%>
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">云计算<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 <a href="#">信息安全</a>
						</li>
						<li>
							 <a href="#">物联网</a>
						</li>
						<li>
							 <a href="#">动漫</a>
						</li>
						<li class="divider">
						</li>
						<li>
							 <a href="#">全部</a>
						</li>
					</ul>
				</li>
			</ul>
				<%--表格标题--%>
			<div class="page-header">
				<h1>
					云计算实验室 <small>学生信息列表</small>
				</h1>
			</div>
				<%--学生信息列表--%>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>
							学号
						</th>
						<th>
							姓名
						</th>
						<th>
							年级
						</th>
						<th>
							专业
						</th>
                        <th>
                            电话
                        </th>
                        <th>
                            备注
                        </th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>15310320108</td>
						<td><a href="">张三</a></td>
						<td>15级</td>
						<td>软件工程</td>
						<td>15312654825</td>
						<td><input type="radio" name="setting" ></td>
					</tr>
					<tr class="success">
						<td>15310320108</td>
						<td><a href="">张三</a></td>
						<td>15级</td>
						<td>软件工程</td>
						<td>15312654825</td>
						<td><input type="radio" name="setting" ></td>
					</tr>
					<tr class="error">
						<td>15310320108</td>
						<td><a href="">张三</a></td>
						<td>15级</td>
						<td>软件工程</td>
						<td>15312654825</td>
						<td><input type="radio" name="setting" ></td>
					</tr>
					<tr class="warning">
						<td>15310320108</td>
						<td><a href="">张三</a></td>
						<td>15级</td>
						<td>软件工程</td>
						<td>15312654825</td>
						<td><input type="radio" name="setting" ></td>
					</tr>
					<tr class="info">
						<td>15310320108</td>
						<td><a href="">张三</a></td>
						<td>15级</td>
						<td>软件工程</td>
						<td>15312654825</td>
						<td><input type="radio" name="setting" ></td>
					</tr>
				</tbody>
			</table>
				<%--表格页面切换按钮--%>
			<ul class="pagination " >
				<li>
					 <a href="#">Prev</a>
				</li>
				<li>
					 <a href="#">1</a>
				</li>
				<li>
					 <a href="#">2</a>
				</li>
				<li>
					 <a href="#">3</a>
				</li>
				<li>
					 <a href="#">4</a>
				</li>
				<li>
					 <a href="#">5</a>
				</li>
				<li>
					 <a href="#">Next</a>
				</li>
			</ul>
		</div>
		<div class="col-md-2 column">
		</div>
	</div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript">
    $(document).ready(function(){
        $.ajax({
            data:'success',
            type:'post',
            url:'init',
            success:function (result) {
                result.dataType='json';
                console.log("result.data.lab_name" +
                    result.data.lab_name);

            }

        })


    });

</script>
</body>
</html>