package cn.edu.nsu.lib.controllers.student;

import cn.edu.nsu.lib.bean.student.StuNoticeBean;
import cn.edu.nsu.lib.controllers.BaseController;
import cn.edu.nsu.lib.handlers.Anyone;
import cn.edu.nsu.lib.services.student.StuNoticeService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
/*
*@auther ChenGang
*@说明：跳转到文档页面
**/
@Controller
@RequestMapping("/Stu")
public class StuDownFileController extends BaseController implements Anyone{
  @Autowired
private StuNoticeService stuNoticeService;
    @RequestMapping("/StuFileList")
    public ModelAndView StuFileList()
    {
        ModelAndView modelAndView=new ModelAndView();
        try {
            List<StuNoticeBean> stuNoticelist = stuNoticeService.findNoticeList();
            modelAndView.addObject("stuFileList", stuNoticelist);
            modelAndView.setViewName("/Stu/Stulist");
        }catch (Exception e)
        {
            e.printStackTrace();
            modelAndView.setViewName("/Stu/Stulist");
        }
        return modelAndView;
    }
    /*
    *@auther ChenGang
    *@说明：实现下载功能
    **/

        public ResponseEntity<byte[]> download(HttpServletRequest request,
                @RequestParam("filename") String filename,
                Model model)throws Exception {
            //下载文件路径
            String path = "????";
            File file = new File(path + File.separator + filename);
            HttpHeaders headers = new HttpHeaders();
            //下载显示的文件名，解决中文名称乱码问题
            String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
            //通知浏览器以attachment（下载方式）打开图片
            headers.setContentDispositionFormData("attachment", downloadFielName);
            //application/octet-stream ： 二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.CREATED);
        }


}
