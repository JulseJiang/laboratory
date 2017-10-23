//package cn.edu.nsu.lib.controllers.admin;
//
///**
// * Created by 王振科 on 2017/9/26.
// */
//
//import cn.edu.nsu.lib.bean.AjaxBean;
//import cn.edu.nsu.lib.bean.admin.Prize;
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
// * 该类实现显示实验室获奖信息
// * 1.显示成员获奖信息
// * 2.如果审核情况为false，需要管理员审核
// * 3.如果审核情况为true，审核情况显示已通过
// * 4.审核通过的可以删除，通过该奖项的id
// */
//@Controller
//@RequestMapping("/PrizeAdministrator")
//public class Administrator_Prize_Controller {
//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private Admin_Manager service;
//    @Autowired
//    private HttpSession session;
//
//    @RequestMapping("/toprize")
//    public  String toprize() throws Exception {
//        /**
//            toprize() 这个方法的描述
//         * @ClassName: toprize
//         * @Description: 跳转到奖项信息页面
//         * @Author:  王振科
//         * @Date: 10:17
//         * @URL:/PrizeAdministrator/toprize
//         * @param
//         */
//        //获得实验室id
////        int Lab_id = (int) session.getAttribute("Lab_id");
//        //通过实验室id获得获奖人的名单
//        ArrayList<Prize> prizes = service.getAdmini_prize_service().toprize(123);
//        for (Prize prize :
//                prizes) {
//            System.out.println();
//            System.out.println("奖项名字："+prize.getName());
//            System.out.println("奖项id："+prize.getId());
//            System.out.println("获奖人id："+prize.getOwner());
//            System.out.println("获奖人名字："+prize.getOwner_name());
//        }
//        request.setAttribute("prizes",prizes);
//        return "/administrator/toprize";
//    }
//
//    @RequestMapping("/Passcheck")
//    public AjaxBean Passcheck(int prize_id) throws Exception {
//        /**
//            Passcheck() 这个方法的描述
//         * @ClassName: Passcheck
//         * @Description: 通过id把审核情况设置为true
//         * @Author:  王振科
//         * @Date: 11:21
//         * @URL:
//         * @param prize_id
//         */
//        int Lab_id = (int) session.getAttribute("Lab_id");
//        boolean is_checked = true;
//        //通过奖项id和实验室id 进行修改通过操作
//        Result status = service.getAdmini_prize_service().
//                Passcheck_Service(prize_id,Lab_id,is_checked);
//        if(status == Result.FAIL) {
//            return new AjaxBean(Result.FAIL);
//        }else {
//            return new AjaxBean(Result.SUCCESS);
//        }
//    }
//
//    @RequestMapping("/Nopass")
//    public AjaxBean Nopass(int prize_id) throws Exception {
//        /**
//            Nopass() 这个方法的描述
//         * @ClassName: Nopass
//         * @Description: 通过id直接删除这条获奖信息
//         * @Author:  王振科
//         * @Date: 11:21
//         * @URL:
//         * @param prize_id
//         */
//        int Lab_id = (int) session.getAttribute("Lab_id");
//        /********************************删除***************************************************
//         */
//        boolean is_checked = false;
//        //通过奖项id和实验室id 进行修改通过操作
//        Result status = service.getAdmini_prize_service()
//                .Nopass_Service(prize_id,Lab_id,is_checked);
//        if(status == Result.FAIL) {
//            return new AjaxBean(Result.FAIL);
//        }else {
//            return new AjaxBean(Result.SUCCESS);
//        }
//    }
//
//
//    @RequestMapping("/Deletewinner")
//    public AjaxBean Deletewinner(int prize_id) throws Exception {
//        /**
//            Deletewinner() 这个方法的描述
//         * @ClassName: Deletewinner
//         * @Description: 通过id直接删除这条获奖信息
//         * @Author:  王振科
//         * @Date: 11:21
//         * @URL:
//         * @param prize_id
//         */
//        int Lab_id = (int) session.getAttribute("Lab_id");
//        /********************************删除***************************************************
//         */
//        Result status = service.getAdmini_prize_service()
//                .Deletewinner_Service(prize_id,Lab_id);
//        if(status == Result.FAIL) {
//            return new AjaxBean(Result.FAIL);
//        }else {
//            return new AjaxBean(Result.SUCCESS);
//        }
//    }
//}
