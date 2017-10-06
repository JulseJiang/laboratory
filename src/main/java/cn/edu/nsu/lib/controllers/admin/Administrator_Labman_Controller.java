package cn.edu.nsu.lib.controllers.admin;

/**
 * Created by 王振科 on 2017/9/26.
 */

import cn.edu.nsu.lib.bean.AjaxBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 该类实现管理员查看 实验室成员和指导老师 信息表页面
 * 1.查看学生的所有信息，指导老师的信息
 * 2.跳转到添加实验室成员页面
 * 3.跳转到修改实验室成员页面
 * 4.根据id删除该实验室成员
 */
@Controller
@RequestMapping("/LabmanAdministrator")
public class Administrator_Labman_Controller {

    @RequestMapping("/toLabmaninfo")
    public String toLabmaninfo(){
        /**
            toLabmaninfo() 这个方法的描述
         * @ClassName: toLabmaninfo
         * @Description: 跳转到成员信息页面，显示信息
         * @Author:  王振科
         * @Date: 11:19
         * @URL:
         * @param
         */
        return null;
    }

    @RequestMapping("/deleteLabman")
    public AjaxBean deleteLabman(int id){
        /**
            deleteLabman() 这个方法的描述
         * @ClassName: deleteLabman
         * @Description: 根据id，删除该成员
         * @Author:  王振科
         * @Date: 11:20
         * @URL:
         * @param id
         */
        return null;
    }

    @RequestMapping("/tochangeLabman")
    public String tochangeLabman(int id){
        /**
            tochangeLabman() 这个方法的描述
         * @ClassName: tochangeLabman
         * @Description: 跳转到更改成员信息页面
         * @Author:  王振科
         * @Date: 11:20
         * @URL:
         * @param id
         */
        return null;
    }

    @RequestMapping("/toaddLabman")
    public String toaddLabman() {
        /**
            toaddLabman() 这个方法的描述
         * @ClassName: toaddLabman
         * @Description: 跳转到添加成员信息页面
         * @Author:  王振科
         * @Date: 11:20
         * @URL:
         * @param
         */
        return  null;
    }
}
