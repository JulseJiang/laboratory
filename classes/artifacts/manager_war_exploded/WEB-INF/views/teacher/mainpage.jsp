<%@ page import="cn.edu.nsu.lib.bean.AjaxBean" %>
<%@ page import="org.springframework.web.bind.annotation.ResponseBody" %>
<%--
  Created by IntelliJ IDEA.
  User: jules
  Date: 2017/9/27
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息表</title>
    <style >
        div {
            width: 70%;

            margin: auto;
        }
        td{
            text-align: center;
            padding: 8px;
        }
    </style>
</head>
<body>
<p>这里是教师端主页--某某教师：实验室a，实验室b，实验室c</p>
<%--<% List<LabEntity> list =request.getAttribute("LabEntityList");--%>
<%--student_table--%>

<div>
    <table>
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>年级</th>
            <th>专业</th>
            <th>联系电话</th>
            <th>设置为管理员</th>
        </tr>
        </thead>
        <tbody id="tbody-stulist">

        <tr>
            <td>15310320108</td>
            <td><a href="">张三</a></td>
            <td>15级</td>
            <td>软件工程</td>
            <td>15312654825</td>
            <td><input type="radio" prize_name="setting" ></td>
        </tr>
        <tr>
            <td>15310320108</td>
            <td><a href="">张三</a></td>
            <td>15级</td>
            <td>软件工程</td>
            <td>15312654825</td>
            <td><input type="radio" prize_name="setting" ></td>
        </tr>
        <tr>
            <td>15310320108</td>
            <td><a href="">张三</a></td>
            <td>15级</td>
            <td>软件工程</td>
            <td>15312654825</td>
            <td><input type="radio" prize_name="setting" ></td>
        </tr>
        </tbody>

    </table>
</div>
<script type="text/javascript" src="${path}/resources/common/jquery.min.js"></script>
<script type="text/javascript" src="${path}/resources/common/layer/2.4/layer.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $.ajax({
            type:'post',
            url:'init',
            success:function (result) {
                console.log("result.data.lab_name" +
                    result.data.lab_name);

            }
        })


    });
</script>
</body>
</html>
