package cn.edu.nsu.lib.controllers.teacher;

import cn.edu.nsu.lib.bean.AjaxBean;
import cn.edu.nsu.lib.bean.teacher.LabEntity;
import cn.edu.nsu.lib.bean.teacher.NoticeEntity;
import cn.edu.nsu.lib.bean.teacher.StudentEntity;
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
import java.util.List;

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

    private List<LabEntity> mLabEntityList;

    /**
     *  当前教师id
     */
    private String mT_id = "16310121007";;
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
        //登陆之后才有
//        String t_id = (String)seesion.getAttribute(Constants.KEY_MAP_USERNAME);
        log.info("该教师id为："+mT_id);
        //获得实验室详细信息实体类列表
        mLabEntityList = service.getTeacherService().findLabList(mT_id);
        log.info("labEntityList.size:"+mLabEntityList.size());
        if (mLabEntityList!=null&mLabEntityList.size()>0){
            //将实验室集合发送到页面
            request.setAttribute("lab",mLabEntityList.get(0));
            request.setAttribute("labEntityList",mLabEntityList);//返回实验室集合
            //获取第一个实验室对应的学生信息作为默认显示的信息
            List<StudentEntity> studentEntityList = service.getTeacherService().findStuList(mLabEntityList.get(0).getId());
            //获取该实验室的通知列表
            List<NoticeEntity> noticeEntityList = service.getTeacherService().findNoticeList(mLabEntityList.get(0).getId(),mT_id);
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(studentEntityList);
            request.setAttribute("stuList",studentEntityList);
            request.setAttribute("noticeEntityList",noticeEntityList);
//            request.setAttribute("stuList",json);
//            request.setAttribute("stuList","我是后台传来的消息");
//            log.info("json内容 "+json);
            //获取第一个实验室对应的管理员
            StudentEntity stu_admin = service.getTeacherService().findStuInfo(mLabEntityList.get(0).getLab_admin());
            request.setAttribute("stu_admin",stu_admin);
            log.info("学生列表studentEntityList=  "+studentEntityList.size());
        }
        log.info("进入mianPage，返回教师端页面时附带的信息");
        return "/teacher/teacherpage";
    }

    /**
     * 处理前端发送的ajax请求
     * @return 包含学生信息列表，实验室名称列表，实验室信息列表，通知列表
     * @throws Exception
     */
    @RequestMapping(value = "/init")
    @ResponseBody
    public AjaxBean getlab(String data)throws Exception{
        log.info("data:"+data);
        AjaxBean ajax=null;
            if (mLabEntityList!=null&mLabEntityList.size()>0){
                if("labs".equals(data)){
                    ajax = new AjaxBean(Result.SUCCESS);
                    ajax.put("labEntityList",mLabEntityList);
                }
                else{//提交的是实验室的序号
                    int i = Integer.parseInt(data);
                    String lab_id = mLabEntityList.get(i).getId();
                    if (lab_id!=null){
                        List<StudentEntity> studentEntityList = service.getTeacherService().findStuList(lab_id);
                        //获取该实验室对应的管理员
                        StudentEntity stu_admin = service.getTeacherService().findStuInfo(mLabEntityList.get(i).getLab_admin());
                        //获取该实验室的通知列表
                        List<NoticeEntity> noticeEntityList = service.getTeacherService().findNoticeList(lab_id,mT_id);

                        ajax = new AjaxBean(Result.SUCCESS);
                        //发送学生信息列表
                        ajax.put("stuEntityList",studentEntityList);
                        //发送实验室名称
                        ajax.put("lab_name",mLabEntityList.get(i).getName());
                        //发送实验室管理员id和名称
                        ajax.put("stu_admin_id",stu_admin.getId());
                        //发送通知列表
                        ajax.put("noticeEntityList",noticeEntityList);
                        //发送实验室详细信息
//                        ajax.put("lab_info",lab_info);
                    }

                }
            }else
            {
                ajax = new AjaxBean(Result.LAB_NOT_FOUND);
            }
            log.info("返回实验室名称列表");
        return ajax;
    }

    /**
     * 处理ajax通知请求
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/notice")
    @ResponseBody
    public AjaxBean getNotice(String data)throws Exception{
        log.info("data:"+data);
        AjaxBean ajax=null;
        if (mLabEntityList!=null&mLabEntityList.size()>0){
            //提交的是实验室的序号
                int i = Integer.parseInt(data);
                String lab_id = mLabEntityList.get(i).getId();
                if (lab_id!=null){
                    //获取该实验室的通知列表
                    List<NoticeEntity> noticeEntityList = service.getTeacherService().findNoticeList(lab_id,mT_id);
                    ajax = new AjaxBean(Result.SUCCESS);
                    //发送通知列表
                    ajax.put("noticeEntityList",noticeEntityList);
                }
        }else
        {
            ajax = new AjaxBean(Result.NOTICE_NOT_FOUND);
        }
        log.info("返回实验室名称列表");
        return ajax;
    }

    @RequestMapping(value = "/stu_info",method = RequestMethod.GET)
    public String getStuInfo(String stu_order){
        log.info("学生序号是："+stu_order);
        return  "teacher/stuInfo";
    }
}
