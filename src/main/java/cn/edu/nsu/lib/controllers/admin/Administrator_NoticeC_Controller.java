//package cn.edu.nsu.lib.controllers.admin;
//
///**
// * Created by 王振科 on 2017/9/26.
// */
//
//import cn.edu.nsu.lib.bean.AjaxBean;
//import cn.edu.nsu.lib.bean.admin.form.Notice_form;
//import cn.edu.nsu.lib.enums.Result;
//import cn.edu.nsu.lib.services.admin.impl.Admin_Manager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
///**
// * 该类实现添加公告
// * 1.点击添加，可以添加上传的 标题，内容，文件（文件名字，文件路径）
// */
//@Controller
//@RequestMapping("/NoticeCLabmanAdministrator")
//public class Administrator_NoticeC_Controller extends  BaseController{
//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private Admin_Manager service;
//    @Autowired
//    private HttpSession session;
//
//    @RequestMapping("/Uploadnoticems")
//    public AjaxBean Uploadnoticems(Notice_form notice_form){
//        /**
//            Uploadnoticems() 这个方法的描述
//         * @ClassName: Uploadnoticems
//         * @Description: 确认上传公告信息
//         * @Author:  王振科
//         * @Date: 11:21
//         * @URL:
//         * @param notice_form
//         */
//        /********************************添加***************************************************
//         */
//        int Lab_id = (int) session.getAttribute("Lab_id");
//         Result status = service.getAdmini_noticeC_service().
//                Uploadnoticems_Service(notice_form,Lab_id);
//
//        return null;
//    }
//}
