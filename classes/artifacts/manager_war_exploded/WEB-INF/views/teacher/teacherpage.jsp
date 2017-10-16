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
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle" ><span class="lab-on">云计算</span><strong class="caret"></strong></a>
					<ul class="dropdown-menu" id="lab-list">

					</ul>
				</li>
			</ul>
				<%--表格标题--%>
			<div class="page-header">
				<h1 >
					<span class="lab-on">实验室</span> <small>学生信息列表</small>
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
            dataType:"json",
            success:function (result) {
                console.log("result.data.labEntityList.length=" +
                    result.data.labEntityList.length);
                console.log("result.data.studentEntityList=" +
                    result.data.studentEntityList);
                var lablist =  result.data.labEntityList;
                //遍历实验室信息并且显示名称列表
                for(var i = 0 ; i < lablist.length;i++){
                    console.log("实验室："+lablist[i].name);
                    if (i==0){
                        $('.lab-on').text(lablist[i].name);
                        continue;
                    }
                    $('#lab-list').append("<li>" +
                        " <a href='#'>"+lablist[i].name+"</a>" +
                        "</li>");
				}
				//遍历第一个实验室所拥有的学生信息填充表格
                var stulist =  result.data.studentEntityList;
                for(var i = 0 ; i < result.data.studentEntityList.length;i++){
                    console.log("当前实验室包含的学生："+stulist[i].name);
                    $('tbody').append("<tr>" +
                         "<td>" +
                        stulist[i].id+
                        "</td>" +
                         "<td><a href=''>" +
                        stulist.name +
                        "</a></td>" +
                         "<td>" +
                        stulist.grade +
                        "</td>" +
                         "<td>" +
                        stulist.major+
                        "</td>" +
                         "<td>" +
                        stulist.tel +
                        "</td>" +
                         "<td><input type='radio' name='setting\' ></td>" +
                        "</tr>");
                }

            },
            error:function (result) {
                console.log("请求失败");
            }
        })


    });


</script>
</body>
</html>