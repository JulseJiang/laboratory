//package cn.edu.nsu.lib.controllers.common;
//
//import cn.edu.nsu.lib.bean.AjaxBean;
//import cn.edu.nsu.lib.config.Constants;
//import cn.edu.nsu.lib.controllers.BaseController;
//import cn.edu.nsu.lib.enums.Result;
//import cn.edu.nsu.lib.services.common.ILoginService;
//import cn.edu.nsu.lib.utils.RequestUtil;
//import cn.edu.nsu.lib.utils.V;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author 墨盒
// * @version 1.0
// * @Date 2017/9/26
// * @Time 16:42
// * @Descorption
// */
//@Controller
//public class LoginController extends BaseController {
//    @Autowired
//    private HttpServletRequest request;
//
//
//    @Autowired
//    private ILoginService loginService;
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String toLogin() throws Exception {
//        return "login";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//
//    public @ResponseBody AjaxBean login(String username, String password, String role, String code) throws Exception {
//        if (V.isEmpty(username) || V.isEmpty(password) || V.isEmpty(role) || V.isEmpty(code)) {
//            return new AjaxBean(Result.PARAM_NOT_EMPTY);
//        }
//        String sCode = (String) request.getSession().getAttribute(Constants.KEY_SESSION_CODE);
//        if (sCode == null) {//验证码过期
//            return new AjaxBean(Result.CODE_NOT_EXISTS);
//        }
//        //将验证码转换为大写
//        code=code.toUpperCase();
//        if (!sCode.equals(code)) {//验证码不正确
//            return new AjaxBean(Result.CODE_NOT_CORRECT);
//        }
//        //验证账号密码
//        Map<String, Object> map = loginService.checkAccount(username, password);
//        if (map != null) {//登陆成功
//            Map<String, Object> user = loginService.getUser(username, Integer.parseInt(map.get(Constants.KEY_MAP_AUTHORITY).toString()));
//            /**
//            *@auther ChenGang
//            *@说明：修复第一次登录找不到user的问题
//            **/
//            if(user!=null)
//            {
//                RequestUtil.login(request, user);
//            }else
//            {   user=new HashMap<String,Object>();
//                user.put("id",Long.parseLong(username));
//                RequestUtil.login(request, user);
//            }
//            //属性为0会jackson会自动忽略前台拿不到数据
//            AjaxBean ajax = new AjaxBean(Result.LOGIN_SUCCESS);
//            ajax.put(Constants.KEY_JSON_SESSION_ID, request.getSession().getId());
//            return ajax;
//        } else {
//            //登陆失效或者未登录
//            return new AjaxBean(Result.FAIL);
//        }
//    }
//}
//
