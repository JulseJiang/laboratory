package cn.edu.nsu.lib.controllers.common;

import cn.edu.nsu.lib.bean.AjaxBean;
import cn.edu.nsu.lib.config.Constants;
import cn.edu.nsu.lib.controllers.BaseController;
import cn.edu.nsu.lib.enums.Result;
import cn.edu.nsu.lib.services.common.ILoginService;
import cn.edu.nsu.lib.services.common.ModifyPasswdService;
import cn.edu.nsu.lib.utils.RequestUtil;
import cn.edu.nsu.lib.utils.V;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author ChenGang
 * @Title: ModifyPasswdController
 * @Package cn.edu.nsu.lib.dao.common
 * @Description:修改密码
 * @date 2017/9/29 0029 上午 8:53
 **/
@Controller

public class ModifyPasswdController extends BaseController{
    @Autowired
    HttpServletRequest request;
    @Autowired
    ModifyPasswdService modifyPasswdService;
    @Autowired
    ILoginService loginService;
    //进入修改密码页面
    @RequestMapping(value="/modifypasswd", method= RequestMethod.GET)
    public String  modifypasswd()
    {
        return "/modifypasswd";
    }
    //更新密码功能
    @RequestMapping(value="/uodatePasswd", method= RequestMethod.POST)
    @ResponseBody
    public AjaxBean updatePasswd( String OriginalPassword, String password1, String password2,String code) throws Exception {
        //验证是否为空
        if ( V.isEmpty(OriginalPassword) || V.isEmpty(password1)||V.isEmpty(password2)) {
            return new AjaxBean(Result.PARAM_NOT_EMPTY);
        }
        //验证密码是否相同
        if(!password1.equals(password2))
        {
            return new AjaxBean(Result.FILE_TYPE_NOT_SUIT);
        }
        String sCode = (String) request.getSession().getAttribute(Constants.KEY_SESSION_CODE);
        if (sCode == null) {//验证码过期
            return new AjaxBean(Result.CODE_NOT_EXISTS);
        }
        if (!sCode.equals(code)) {//验证码不正确
            return new AjaxBean(Result.CODE_NOT_CORRECT);
        }
       //获取登陆信息
        Map<String, Object> loginMap = RequestUtil.getLogin(request);
        String userName=(String) loginMap.get(Constants.KEY_MAP_USERNAME);
        //验证密码
        Map<String, Object> map = loginService.checkAccount(userName,OriginalPassword);
        if (map != null) {
            //更新密码
            if(modifyPasswdService.updatePasswd(userName,"password1")!=null)
            {
               return  new AjaxBean(Result.SUCCESS);
            }
            //更新失败
            return new AjaxBean(Result.EXCEPTION) ;
        } else {

            //原密码错误
            return new AjaxBean(Result.FAIL);
        }
    }
}
