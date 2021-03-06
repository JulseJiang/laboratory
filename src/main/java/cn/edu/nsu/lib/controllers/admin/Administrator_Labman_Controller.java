//package cn.edu.nsu.lib.controllers.admin;
//
///**
// * Created by 王振科 on 2017/9/26.
// */
//
//import cn.edu.nsu.lib.bean.AjaxBean;
//import cn.edu.nsu.lib.bean.admin.db.db_Student;
//import cn.edu.nsu.lib.enums.Result;
//import cn.edu.nsu.lib.services.admin.impl.Admin_Manager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.math.BigInteger;
//import java.util.ArrayList;
//
///**
// * 该类实现管理员查看 实验室成员和指导老师 信息表页面
// * 1.查看学生的所有信息，指导老师的信息
// * 2.跳转到添加实验室成员页面
// * 3.跳转到修改实验室成员页面
// * 4.根据id删除该实验室成员
// */
//@Controller
//@RequestMapping("/LabmanAdministrator")
//public class Administrator_Labman_Controller {
//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private Admin_Manager service;
//    @Autowired
//    private HttpSession session;
//
//    @RequestMapping("/toLabmaninfo")
//    public String toLabmaninfo() throws Exception {
//        /**
//            toLabmaninfo() 这个方法的描述
//         * @ClassName: toLabmaninfo
//         * @Description: 跳转到成员信息页面，显示信息
//         * @Author:  王振科
//         * @Date: 11:19
//         * @URL:"/LabmanAdministrator/toLabmaninfo"
//         * @param
//         */
//        //获得实验室的id
////        int Lab_id = (int) session.getAttribute("Lab_id");
//        ArrayList<db_Student> students = service.getAdmini_labman_service().toLabmaninfo_Service(123);
//        request.setAttribute("students",students);
//        for (db_Student student:
//                students) {
//            System.out.println();
//            System.out.println("toLabmaninfo");
//            System.out.println("id:"+student.getId());
//            System.out.println("Name:"+student.getName());
//            System.out.println("Date:"+student.getInstructor());
//            System.out.println("Register:"+student.getLab_id());
//        }
//        //学生key是students
//        return "/administrator/toLabmaninfo";
//    }
//
//    @RequestMapping("/deleteLabman")
//    public AjaxBean deleteLabman(BigInteger student_id) throws Exception {
//        /**
//            deleteLabman() 这个方法的描述
//         * @ClassName: deleteLabman
//         * @Description: 根据id，删除该成员
//         * @Author:  王振科
//         * @Date: 11:20
//         * @URL:
//         * @param student_id
//         */
////        请求中获得学生id并转成int类型
////        int id = (int) request.getAttribute("student_id");
////        int Labid = (int) session.getAttribute("Labid");
//        //根据学号和实验室id删除该学生，返回枚举类型判断是否成功
//        Result status = service.getAdmini_labman_service()
//                .deleteLabman_Service(new BigInteger("153104"));
//        if(status == Result.FAIL) {
//            return new AjaxBean(Result.FAIL);
//        }else {
//            return new AjaxBean(Result.SUCCESS);
//        }
//    }
//
//    @RequestMapping("/tochangeLabman")
//    public String tochangeLabman(BigInteger student_id) throws Exception {
//        /**
//            tochangeLabman() 这个方法的描述
//         * @ClassName: tochangeLabman
//         * @Description: 跳转到更改成员信息页面
//         * @Author:  王振科
//         * @Date: 11:20
//         * @URL:/LabmanAdministrator/tochangeLabman
//         * @param id
//         */
////        int student_id = (int) request.getAttribute("student_id");
//        //根据id返回该学生对象
////        int Labid = (int) session.getAttribute("Labid");
//        db_Student student = service.getAdmini_labman_service()
//                .tochangeLabman_Service(new BigInteger("153103"),123);
//        request.setAttribute("student",student);
//        return "/administrator/tochangeLabman";
//    }
//
//    @RequestMapping("/toaddLabman")
//    public String toaddLabman() {
//        /**
//            toaddLabman() 这个方法的描述
//         * @ClassName: toaddLabman
//         * @Description: 跳转到添加成员信息页面
//         * @Author:  王振科
//         * @Date: 11:20
//         * @URL:
//         * @param
//         */
//        return  "/administrator/toaddLabman";
//    }
//}
