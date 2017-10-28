<%@ page import="java.util.List" %>
<%@ page import="cn.edu.nsu.lib.bean.teacher.StudentEntity" %>
<%@ page import="org.apache.commons.logging.Log" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ page import="com.mysql.cj.xdevapi.JsonArray" %>
<%@ page import="com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor" %>
<%@ page import="cn.edu.nsu.lib.bean.teacher.LabEntity" %>
<%@ page import="cn.edu.nsu.lib.bean.teacher.NoticeEntity" %>
<%@ page import="cn.edu.nsu.lib.bean.admin.Notice" %>
<%@ page import="cn.edu.nsu.lib.bean.teacher.TeacherEntity" %>
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
					 <a  href="#Page_stu" data-toggle="tab">首页</a>
				</li>
				<li>
					 <a  href="#Page_notice" data-toggle="tab">公告</a>
				</li>
				<li>
					 <a  href="#Page_LabInfo" data-toggle="tab">信息</a>
				</li>
				<%--实验室切换信息--%>
				<li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle" ><span class="lab-on" data-labId="0">${lab.name}</span><strong class="caret"></strong></a>
					<ul class="dropdown-menu" id="lab-list">
                        <%
                            List<LabEntity> labEntityList = (List<LabEntity>) request.getAttribute("labEntityList");
                            for (int i = 1; i < labEntityList.size(); i++) {
                                request.setAttribute("lab_name",labEntityList.get(i).getName());
                                request.setAttribute("lab_order",i);
                        %>
                        <li > <a href="javascript:void(0);" onclick="lab_changed(${lab_order})">${lab_name}</a></li>
                        <%
                            }
                        %>
					</ul>
				</li>
			</ul>
            <%--三个选项卡div--%>
			<div class="tab-content">
                <div class="tab-pane fade in active" id="Page_stu">
                        <%--表格标题--%>
                        <div class="page-header">
                            <h1 >
                                <span class="lab-on">${lab.name}</span>
                                <small>学生信息列表（管理员：
                                    <a  href="/Teacher/stu_info?stu_info=${stu_admin.id}" target="_blank"  id="stu_admin">${stu_admin.name}</a>
                                    ）</small>
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
                                <th title="月签到次数">
                                    签到/次
                                </th>
                                <th>
                                    备注
                                </th>
                            </tr>
                            </thead>
                            <%--学生信息列表--%>
                            <tbody id = "stu_body">
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
//                                    request.setAttribute("order",i);
                            %>
                            <tr>
                                <td>${stu.id}</td>
                                <td><a href="/Teacher/stu_info?stu_id=${stu.id}" target="_blank">${stu.name}</a></td>
                                <%--<td><a href="javascript:void(0);" onclick="stu_info(i)"  title='i'>${stu.name}</a></td>--%>
                                <td>${stu.grade}</td>
                                <td>${stu.major}</td>
                                <td>${stu.tel}</td>
                                <td>${stu.frequency}</td>
                                <td><input type="radio" name="setting" ></td>
                            </tr>
                            <%}%>
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
                <div class="tab-pane fade " id="Page_notice">
                        <%--表格标题 公告通知--%>
                        <div class="page-header">
                            <h1 >
                                <span class="lab-on">${lab.name}</span> <small>通知列表</small>
                            </h1>
                        </div>
                            <%--通知列表--%>
                        <div id="notice-body">
                            <%
                                List<NoticeEntity> noticeEntityList = (List<NoticeEntity>) request.getAttribute("noticeEntityList");
                                if(noticeEntityList!=null){
                                    for (int i = 0; i < noticeEntityList.size(); i++) {
                                        NoticeEntity notice = noticeEntityList.get(i);
                                        request.setAttribute("notice",notice);
                            %>
                                <div class="panel panel-warning">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">
                                            <span class="notice_title">${notice.title}</span>
                                            <span class="pull-right">${notice.publisher} ${notice.time} ||<a href="${notice.file_path}" title="${notice.file_name}"> 附件 </a></span>
                                        </h3>
                                    </div>
                                    <div class="panel-body">
                                        ${notice.content}
                                    </div>
                                </div>
                            <%
                                    }
                                }
                            %>
                         </div>

                </div>
                <div class="tab-pane fade" id="Page_LabInfo">
                    <%--实验室详细信息页面--%>

                    <h1 class="text-center"><span class="lab-on">${lab.name}</span><small class="frequency" title="实验室成员共计${lab.stu_num}人">本月人均考勤<span id="lab_fre">${lab.avg_fre}</span>次</small></h1>
                        <blockquote>
                            <p>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="lab_des">${lab.describe}</span>
                            </p> <small>地址：<cite id=""lab_adddress>${lab.address}</cite></small>
                        </blockquote>
                        <h1><small>教师团队</small></h1>
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th>
                                    教师
                                </th>
                                <th>
                                    姓名
                                </th>
                                <th>
                                    性别
                                </th>
                                <th>
                                    电话
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                List<TeacherEntity> teacherList = (List<TeacherEntity>)request.getAttribute("teacherEntitieList");
                                for (int i = 0;i<teacherList.size();i++){
                                    TeacherEntity teacher = teacherList.get(i);
                                    request.setAttribute("teacher",teacher);
                                    request.setAttribute("order",i);
                            %>
                            <tr >
                                <td>${teacher.id}</td>
                                <td>${teacher.name}</td>
                                <td>${teacher.gender}</td>
                                <td>${teacher.tel}</td>
                            </tr>
                           <%}%>
                            </tbody>
                        </table>
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
        var lablist={};//记录实验室信息列表
//        mLaborder=0;//记录显示的实验室序号

        //点击当前实验室菜单
        $('.lab-on').click(function (){
            console.log("您点击了lab-on");
            if(!isInit){
                isInit = true;//实验室名称列表只需要请求一次
                labs();//请求实验室名称列表
            }else{
//                refreshli();//刷新菜单列表，当前显示的实验室不同，菜单不同（选择其他菜单项时，再次打开）
            };
        });
    });
//初次点击列表，展示该教师管理的实验室名称列表
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
               refreshli(0);
            },
            error:function (result) {
                console.log("get_labs请求失败");
            }
        })
    }
// 当实验室切换时，实验室菜单，人员列表,公告，实验室详细信息和标题都要改变
function  lab_changed(lab_order) {
    $.ajax({
        data:{
            data:lab_order
        },
        type:'post',
        url:'init',
        dataType:"json",
        success:function (result) {
            refreshli(lab_order);//刷新菜单项列表

//            console.log("result.data.studentEntityList=" +
//                result.data.stuEntityList);
//            mLaborder=lab_order;//请求成功之后将全局变量mLaborder赋值当前展示实验室序号


            //刷新学生信息表格
            var stulist = result.data.stuEntityList;
            var stu_admin_id=result.data.stu_admin_id;
            if(stulist!=null&stu_admin_id!=null){
                //遍历该实验室所拥有的学生信息填充表格
                refreshstu(stulist,stu_admin_id);
            }




            console.log("lab_order:"+lab_order);
            console.log("通知名称："+result.data.noticeEntityList[0].title);
            //刷新公告表
            var noticelist =  result.data.noticeEntityList;//返回公告列表
            if(noticelist!=null){
                console.log("noticelist:"+noticelist);
                refresh_notice(noticelist);
            }else {
                console.log("暂无通知");
            }

            //刷新实验室详细信息


            refresh_labinfo(lab_order);
        },
        error:function (result) {
            console.log("请求失败");
        }
    });
}
//返回html标签字符串-菜单项
function editli(i,lab_name) {
    var str = "<li >" +
    " <a href=\"javascript:void(0);\" onclick=\"lab_changed(" +
        i +
        ")\"  data-labId='" +
    i +
    "'>"+lablist[i].name+"</a>" +
    "</li>";
    console.log("str : "+str);
    return str;
}
//刷新下拉菜单列表
function refreshli(lab_order){
    var mylab_list =$('#lab-list');
    mylab_list.empty();//清空列表
    //遍历实验室信息并且显示名称列表
    for(var i = 0 ; i < lablist.length;i++){
        if (i==lab_order){
            console.log("标注显示的实验室："+lablist[i].name);

            //刷新显示菜单项
            var lab_on = $('.lab-on');
            lab_on.text(lablist[lab_order].name);//修改下拉菜单的默认显示
//            lab_on.first().attr({'title':lab_order});//只给首次出现lab_on的标签加上title
//            console.log('显示菜单的title：'+lab_on.first().attr('title'));

            continue;
        }
        mylab_list.append(editli(i,lablist[i].name));

    }
}
//遍历该实验室所拥有的学生信息填充表格
function refreshstu(stulist,stu_admin_id) {
    var t_body = $('#stu_body');
    t_body.empty();//清空学生信息表格
    for(var i = 0 ; i < stulist.length;i++){
        console.log("当前实验室包含的学生："+stulist[i].name);
        if(stulist[i].id==stu_admin_id){//如果该学生是管理员
            var stu_admin = $('#stu_admin');//获取显示实验室管理员名称的标签
            stu_admin.text(stulist[i].name);
            stu_admin.attr({'data-stuId':i});
            console.log(" $('#stu_admin'):"+stu_admin.text());
        }
        t_body.append(edit_stu_tr(i,stulist));//追加学生信息
    }
}
function refresh_notice(noticelist) {
    var notice_body=$('#notice-body');
    notice_body.empty();
    for(var i =0;i<noticelist.length;i++){
        notice_body.append(edit_pan(noticelist[i]));
    }
}
//刷新实验室详细信息
function refresh_labinfo(lab_order){
//    $('#lab_des').text(lablist.);
    $('#lab_address').text(lablist[lab_order].address);
//    $('#lab_fre').text("1234");
    $('#lab_fre').text(lablist[lab_order].avg_fre);
}
//返回html标签字符串-学生信息列表区域
function edit_stu_tr(i,stulist){
    var str="<tr>" +
    "<td>" +
    stulist[i].id+
    "</td>" +
    "<td><a href='/Teacher/stu_info?stu_id=" +
        stulist[i].id+
        "' target=\"_blank\">" +
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
    "<td>" +
        stulist[i].frequency +
        "</td>"+
    "<td><input type='radio' name='setting' ></td>" +
    "</tr>"
    return str;
}
//初始化通知列表
//function notices(lab_order) {
//    $.ajax({
//        data:{
//            data:lab_order
//        },
//        type:'post',
//        url:'notice',
//        dataType:'json',
//        success:function(result){
//            console.log("get_labs请求成功");
////            var noticelist =  result.data.noticeEntityList;
////            console.log("noticelist:"+noticelist);
////            var notice_body=$('#notice-body');
////            notice_body.empty();
////            for(var i =0;i<noticelist.length;i++){
////                notice_body.append(edit_pan(noticelist[i]));
////            }
//        },
//        error:function (result) {
//            console.log("get_labs请求失败");
//        }
//    })
//}
//返回html标签字符串-公告区域
function edit_pan(notice){
    var str = "<div class=\"panel panel-warning\">\n" +
        "<div class=\"panel-heading\">\n" +
        "<h3 class=\"panel-title\">\n" +
        "<span class=\"notice_title\">" +
        notice.title +//标题
        "</span>\n" +
        "<span class=\"pull-right\">" +
        notice.publisher//发布人
        + notice.time +//发布时间
        "||<a href=\"#" +
        notice.file_path +
        "\" title=\"" +
        notice.file_name +
        "\"> 附件 </a></span>\n" +
        "</h3>\n" +
        "</div>\n" +
        "<div class=\"panel-body\">\n" +
        notice.content +
        "</div>\n" +
        "</div>";
        console.log("pan_str="+str);
        return str;
};
function edit_teacher_tr(teacher){
    var str = "<tr >\n" +
        "<td>" +
        "teacher.id" +
        "</td>\n" +
        "<td>" +
        teacher.name +
        "</td>\n" +
        "<td>" +
        teacher.gender +
        "</td>\n" +
        "<td>" +
        teacher.tel +
        "</td>\n" +
        "</tr>"
    return str;
    }
//初始化实验室信息页面
function lab_info(lab_order){

}
//点击学生信息跳转到学生信息详情页
//function stu_info(stu_order){
//    $.ajax({
//        data:{
//            data:'stu_order'
//        },
//        type:'post',
//        url:'init',
//        dataType:'json',
//        success:function(result){
//            console.log("get_labs请求成功");
//            lablist =  result.data.labEntityList;
//            refreshli();
//        },
//        error:function (result) {
//            console.log("get_labs请求失败");
//        }
//    })
//}

</script>
</body>
</html>