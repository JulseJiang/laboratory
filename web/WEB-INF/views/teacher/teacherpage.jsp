<%@ page import="java.util.List" %>
<%@ page import="cn.edu.nsu.lib.bean.teacher.StudentEntity" %>
<%@ page import="org.apache.commons.logging.Log" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ page import="com.mysql.cj.xdevapi.JsonArray" %>
<%@ page import="com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor" %>
<%@ page import="cn.edu.nsu.lib.bean.teacher.LabEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
	<style>
		html{
			margin: 10px;
		}
	</style>
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
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle" ><span class="lab-on" title="${lab.id}">${lab.name}</span><strong class="caret"></strong></a>
					<ul class="dropdown-menu" id="lab-list">
                        <li><a href="">开心斗地主</a> </li>
					</ul>
				</li>
			</ul>
				<%--表格标题--%>
			<div class="page-header">
				<h1 >
					<span class="lab-on">${lab.name}</span> <small>学生信息列表</small>
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
				<%
//                    String stuList = (String) request.getAttribute("stuList");
                    List<StudentEntity> stuList = (List<StudentEntity>)request.getAttribute("stuList");
                    System.out.println("request.getAttribute(\"stuList\")"+(request.getAttribute("stuList")==null));
                    System.out.println("stuList是否为空"+(stuList.size()));
//                    System.out.println("stuList是否为空"+(stuList.length()));
//                    List<StudentEntity> stulist = (List<StudentEntity>)request.getAttribute("jsonStuList");
//					System.out.println("stulist是否为空"+(stulist==null));
					for (int i = 0;i<stuList.size();i++){
						StudentEntity stu = stuList.get(i);
						request.setAttribute("stu",stu);
					%>
				<tr>
					<td>${stu.id}</td>
					<td><a href="">${stu.name}</a></td>
					<td>${stu.grade}</td>
					<td>${stu.major}</td>
					<td>${stu.tel}</td>
					<td><input type="radio" name="setting" ></td>
				</tr>
				<%}%>
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
    //页面加载就绪时
    $(document).ready(function(){
        var isInit = false;//标注是否是第一次加载
        var lablist={};
        $('.lab-on').click(function (){
            console.log("您点击了lab-on");
            if(!isInit){
                isInit = true;//实验室名称列表只需要请求一次
                labs();
            };

            labchanged(1);
        });
    });
    //初次点击列表或切换实验室的时候，展示该教师管理的实验室名称列表
    function labs(){
        $.ajax({
            data:{
                data:'labs'
            },
            type:'post',
            url:'init',
            dataType:'json',
            success:function(result){
                console.log("get_labs请求成功");
               lablist =  result.data.labEntityList;
                //遍历实验室信息并且显示名称列表
                for(var i = 0 ; i < lablist.length;i++){
                    console.log("实验室："+lablist[i].name);
//                    在页面中显示当前实验室信息
                    console.log("title:"+$('.lab-on').attr('title'));
                    console.log("$('.lab-on').text():"+$('.lab-on').text());
//                    var title=$('.lab-on').attr('title');
                    if (lablist[i].id==$('.lab-on').attr('title')){
                        console.log("标注显示的实验室");
//                        $('.lab-on').text(lablist[i].name);
                        continue;
                    }
                    $('#lab-list').append("<li>" +
                        " <a href='#' title='" +
                        i +
                        "''>"+lablist[i].name+"</a>" +
                        "</li>");
//                    $('#lab-list').append("<li title='" +
//						lablist[i].id +
//						"'>" +
//                        " <a href='#'>"+lablist[i].name+"</a>" +
//                        "</li>");
                }
            },
            error:function (result) {
                console.log("get_labs请求失败");
            }
        })
    }
//    当实验室切换时，实验室菜单，人员列表和标题都要改变
function  labchanged(i) {
    $.ajax({
        data:{
            data:i,
        },
        type:'post',
        url:'init',
        dataType:"json",
        success:function (result) {
            console.log("result.data.studentEntityList=" +
                result.data.stuEntityList);
            //遍历该实验室所拥有的学生信息填充表格
            var stulist =  result.data.stuEntityList;
            for(var i = 0 ; i < stulist.length;i++){
                console.log("当前实验室包含的学生："+stulist[i].name);
                $('tbody').append("<tr>" +
                    "<td>" +
                    stulist[i].id+
                    "</td>" +
                    "<td><a href=''>" +
                    stulist[i].name +
                    "</a></td>" +
                    "<td>" +
                    stulist[i].grade +
                    "</td>" +
                    "<td>" +
                    stulist[i].major+
                    "</td>" +
                    "<td>" +
                    stulist[i].tel +
                    "</td>" +
                    "<td><input type='radio' name='setting' ></td>" +
                    "</tr>");
            }
            $('.lab-on').text(lablist[i].name);
        },
        error:function (result) {
            console.log("请求失败");
        }
    })
}

</script>
</body>
</html>