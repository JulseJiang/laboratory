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
					 <a href="#Page_stu" data-toggle="tab">首页</a>
				</li>
				<li>
					 <a href="#Page_notice" data-toggle="tab">公告</a>
				</li>
				<li>
					 <a href="#Page_LabInfo" data-toggle="tab">信息</a>
				</li>
				<%--实验室切换信息--%>
				<li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle" ><span class="lab-on" title="0">${lab.name}</span><strong class="caret"></strong></a>
					<ul class="dropdown-menu" id="lab-list">
                        <li><a class="lab_change" >开心斗地主</a> </li>
					</ul>
				</li>
			</ul>
				<div class="tab-content">
                    <div class="tab-pane fade" id="Page_stu">
                        <%--表格标题--%>
                        <div class="page-header">
                            <h1 >
                                <span class="lab-on">${lab.name}</span> <small>学生信息列表（管理员：<a id="stu_admin">${stu_admin.name}</a>）</small>
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
                    <div class="tab-pane fade" id="Page_notice">
                        我是通知页面
                    </div>
                    <div class="tab-pane fade" id="Page_LabInfo">
                        我是实验室详细信息页面
                    </div>
                </div>
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
        var lablist={};//记录实验室名称列表
        $('.lab-on').click(function (){
            console.log("您点击了lab-on");
            if(!isInit){
                isInit = true;//实验室名称列表只需要请求一次
                labs();
            }else{
                refrechli();//刷新菜单列表
            };

//            refreshStu(1);
        });
    });
    //初次点击列表或切换实验室的时候，展示该教师管理的实验室名称列表
    //向后台发出请求，初始化lablist
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
               refrechli();
            },
            error:function (result) {
                console.log("get_labs请求失败");
            }
        })
    }
//    当实验室切换时，实验室菜单，人员列表和标题都要改变
function  refreshStu(lab_order) {
    $.ajax({
        data:{
            data:lab_order
        },
        type:'post',
        url:'init',
        dataType:"json",
        success:function (result) {
            console.log("result.data.studentEntityList=" +
                result.data.stuEntityList);
            //遍历该实验室所拥有的学生信息填充表格
            var stulist =  result.data.stuEntityList;
            $('tbody').empty();//清空表格
            for(var i = 0 ; i < stulist.length;i++){
                console.log("当前实验室包含的学生："+stulist[i].name);
                if(stulist[i].id==result.data.stu_admin_id){

                }
                $('tbody').append("<tr>" +
                    "<td>" +
                    stulist[i].id+
                    "</td>" +
                    "<td><a class='stuinfo'>" +
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
            $('.lab-on').text(lablist[lab_order].name);//修改下拉菜单的默认显示
            $('.lab-on').first().attr({'title':lab_order});
            $('#stu_admin').text(result.data.stu_admin_name);
            $('#stu_admin').attr({'title':result.data.stu_admin_id});
            console.log(" $('#stu_admin'):"+ $('#stu_admin').text());
            console.log('显示菜单的title：'+$('.lab-on').first().attr('title'));
            console.log("lab_order:"+lab_order);
            labs();//刷新下拉菜单列表
        },
        error:function (result) {
            console.log("请求失败");
        }
    })
}
//返回html标签字符串
function editli(i,lab_name) {
    var str = "<li >" +
    " <a href=\"javascript:void(0);\" onclick=\"refreshStu(" +
        i +
        ")\"  title='" +
    i +
    "'>"+lablist[i].name+"</a>" +
    "</li>";
    console.log("str : "+str);
    return str;
}
//刷新下拉菜单列表
function refrechli(){
    $('#lab-list').empty();//清空列表
    //遍历实验室信息并且显示名称列表
    for(var i = 0 ; i < lablist.length;i++){
        console.log("实验室："+lablist[i].name);
//                    在页面中显示当前实验室信息
        console.log("$('.lab-on').attr('title'):"+$('.lab-on').attr('title'));
//                    var title=$('.lab-on').attr('title');
        if (i==$('.lab-on').attr('title')){
            console.log("标注显示的实验室："+lablist[i].name);
//                        $('.lab-on').text(lablist[i].name);
            continue;
        }
        $('#lab-list').append(editli(i,lablist[i].name));

    }
}
</script>
</body>
</html>