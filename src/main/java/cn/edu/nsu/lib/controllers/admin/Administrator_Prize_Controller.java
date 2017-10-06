package cn.edu.nsu.lib.controllers.admin;

/**
 * Created by 王振科 on 2017/9/26.
 */

import cn.edu.nsu.lib.bean.AjaxBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 该类实现显示实验室获奖信息
 * 1.显示成员获奖信息
 * 2.如果审核情况为false，需要管理员审核
 * 3.如果审核情况为true，审核情况显示已通过
 * 4.审核通过的可以删除，通过该奖项的id
 */
@Controller
@RequestMapping("/PrizeAdministrator")
public class Administrator_Prize_Controller {

    @RequestMapping("/Passcheck")
    public AjaxBean Passcheck(int prize_id){
        /**
            Passcheck() 这个方法的描述
         * @ClassName: Passcheck
         * @Description: 通过id把审核情况设置为true
         * @Author:  王振科
         * @Date: 11:21
         * @URL:
         * @param prize_id
         */
        return null;
    }

    @RequestMapping("/Nopass")
    public AjaxBean Nopass(int prize_id){
        /**
            Nopass() 这个方法的描述
         * @ClassName: Nopass
         * @Description: 通过id直接删除这条获奖信息
         * @Author:  王振科
         * @Date: 11:21
         * @URL:
         * @param prize_id
         */
        return null;
    }


    @RequestMapping("/Deletewinner")
    public AjaxBean Deletewinner(int prize_id){
        /**
            Deletewinner() 这个方法的描述
         * @ClassName: Deletewinner
         * @Description: 通过id直接删除这条获奖信息
         * @Author:  王振科
         * @Date: 11:21
         * @URL:
         * @param prize_id
         */
        return null;
    }
}
