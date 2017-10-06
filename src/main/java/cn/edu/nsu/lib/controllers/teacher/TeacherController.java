package cn.edu.nsu.lib.controllers.teacher;

import cn.edu.nsu.lib.bean.AjaxBean;
import cn.edu.nsu.lib.controllers.BaseController;
import cn.edu.nsu.lib.enums.Result;
import cn.edu.nsu.lib.handlers.Anyone;
import cn.edu.nsu.lib.services.teacher.TeacherServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* class_name: Teacher_Controller
* describe: 教师端控制器 用于实现教师端主页
* creat_user: 蒋玖宏 julse@qq.com
* creat_date: 2017/9/27
* creat_time: 21:40
**/


/**
 * 绕过权限验证，项目完成时删除implement anyone
 */
@Controller
@RequestMapping(value = "/Teacher")

public class TeacherController extends BaseController implements Anyone{
    @Autowired
    private HttpSession seesion;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TeacherServiceManager service;
    /**
     * method_name: mainpage
     * param: []
     * describe: 跳转到教师端主页，显示实验室信息
     * creat_user: 蒋玖宏 julse@qq.com
     * creat_date: 2017/9/27
     **/
    @RequestMapping(value="/mainpage",method = RequestMethod.GET)
    /*@Authority(role = Authority.Role.TEACHER)*/
    public String toMainpage()throws Exception{
        System.out.println("进入toMainpage，返回到教师端主页");
        //登陆之后才有
//        String t_id = (String)seesion.getAttribute(Constants.KEY_MAP_USERNAME);
/*       String t_id = "123";
        //获得实验室详细信息实体类列表
        List<LabEntity> labEntityList = service.getTeacherService().findLabList(t_id);
        //创建json数据存储对应信息
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < labEntityList.size(); i++) {
           LabEntity lab = new LabEntity();

        }*/
        return "/teacher/mainpage";
    }
    @RequestMapping(value = "/mainpage")
    @ResponseBody
    public AjaxBean mianPage()throws Exception{
        AjaxBean bean = new AjaxBean(Result.SUCCESS,"我的实验室");
        bean.put("lab_name","云计算实验室");
        System.out.println("进入mianPage，返回教师端页面时附带的信息");
        return bean;
    }


}
