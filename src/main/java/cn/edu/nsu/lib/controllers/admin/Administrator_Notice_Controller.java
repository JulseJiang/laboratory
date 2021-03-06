//package cn.edu.nsu.lib.controllers.admin;
//
///**
// * Created by 王振科 on 2017/9/26.
// */
//
//import cn.edu.nsu.lib.bean.AjaxBean;
//import cn.edu.nsu.lib.bean.admin.Notice;
//import cn.edu.nsu.lib.enums.Result;
//import cn.edu.nsu.lib.services.admin.impl.Admin_Manager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//
///**
// * 该类实现显示实验室公告的信息
// * 1.显示公告信息
// * 2.跳转到添加公告页面
// * 3.下载公告
// * 4.根据公告id删除某条公告
// */
//@Controller
//@RequestMapping("/NoticeAdministrator")
//public class Administrator_Notice_Controller {
//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private Admin_Manager service;
//    @Autowired
//    private HttpSession session;
//
//    @RequestMapping("/toNotice")
//    public String toNotice() throws Exception {
//        /**
//            toNotice() 这个方法的描述
//         * @ClassName: toNotice
//         * @Description:
//         * @Author:  王振科
//         * @Date: 11:21
//         * @URL:
//         * @param
//         */
//        int Labid = (int) session.getAttribute("Labid");
//        //通过实验室id获得公告
//        ArrayList<Notice> notices = service.getAdmini_notice_service()
//                .toNotice_Service(Labid);
//        request.setAttribute("notices",notices);
//        //公告的key是notices
//        return "/administrator/toNotice";
//    }
//
//    @RequestMapping("/Deletenotice")
//    public AjaxBean Deletenotice(int Notice_id) throws Exception {
//        /**
//            Deletenotice() 这个方法的描述
//         * @ClassName: Deletenotice
//         * @Description: 通过公告id，删除公告
//         * @Author:  王振科
//         * @Date: 11:21
//         * @URL:
//         * @param id
//         */
//        int Lab_id = (int) session.getAttribute("Lab_id");
//        Result status = service.getAdmini_notice_service()
//                .Deletenotice_Service(Notice_id,Lab_id);
//        if(status == Result.FAIL) {
//            return new AjaxBean(Result.FAIL);
//        }else {
//            return new AjaxBean(Result.SUCCESS);
//        }
//    }
//
//    @RequestMapping("/toUploadnotice")
//    public String toUploadnotice(){
//        /**
//            toUploadnotice() 这个方法的描述
//         * @ClassName: Uploadnotice
//         * @Description: 跳转到上传公告页面
//         * @Author:  王振科
//         * @Date: 11:21
//         * @URL:
//         * @param
//         */
//        return "/administrator/toUploadnotice";
//    }
//}
