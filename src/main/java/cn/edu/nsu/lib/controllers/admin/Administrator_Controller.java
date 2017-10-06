package cn.edu.nsu.lib.controllers.admin;

import cn.edu.nsu.lib.bean.AjaxBean;
import cn.edu.nsu.lib.bean.admin.form.Notice_form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 王振科 on 2017/9/24.
 */


/**
 * 该类实现管理员主页
 * 1.显示学生（姓名，学号，考勤）等信息显示的功能
 * 2.根据前端传的日期查询当天的考勤信息
 */
@Controller
@RequestMapping("/Administrator")
public class Administrator_Controller {
    //    我把管理员视图藏在该路径下了  /administrator/
    @Autowired
    private HttpServletRequest request;


    @RequestMapping("/mainpage")
    public String mainpage(){
        /**
            mainpage() 这个方法的描述
         * @ClassName: mainpage
         * @Description: 跳转到管理员主页面，显示考勤信息
         * @Author:  王振科
         * @Date: 21:10
         * @URL:localhost/Administrator/mainpage
         * @param
         */
        return "/administrator/mainpage";
    }


    @RequestMapping("/timechangedata")
    public AjaxBean timechangedata(String time){
    /**
        timechangedata() 这个方法的描述
     * @ClassName: timechangedata
     * @Description: 根据前端传的日期查询刷新当天的考勤信息
     * @Author:  王振科
     * @Date: 20:50
     * @URL:
     * @param time
     */
        return null;
    }



    /*
    测试
     */
    @RequestMapping("/Test")
    public void Test(HttpServletResponse response,
            Notice_form notice_form){
        request.setAttribute("rpublisher",notice_form.getPublisher());
        request.setAttribute("rtime",notice_form.getTime());
        System.out.println("rpublisher属性："+notice_form.getPublisher());
        response.setContentType("utf-8");
        try {
            request.getRequestDispatcher("/Administrator/mainpage").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
