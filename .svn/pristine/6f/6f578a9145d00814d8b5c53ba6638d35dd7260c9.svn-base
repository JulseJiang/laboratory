package cn.edu.nsu.lib.controllers;

import cn.edu.nsu.lib.enums.Result;
import cn.edu.nsu.lib.handlers.MessageException;
import cn.edu.nsu.lib.handlers.PropertiesPlaceholder;
import cn.edu.nsu.lib.utils.RequestUtil;
import cn.edu.nsu.lib.utils.V;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 墨盒
 * @version 1.0
 * @Date 2017/8/15
 * @Time 21:08
 * @Descorption
 */
public class BaseController {
    protected Log log = LogFactory.getLog(getClass());

    protected Map<String, Object> getLogin(HttpServletRequest request) {
        return RequestUtil.getLogin(request);
    }

    @Autowired
    protected PropertiesPlaceholder placeholder;

    /**
     * 检测表单
     *
     * @param value 表单
     * @return 如果不通过返回false
     */
    protected void checkForm(Object value) throws Exception {
        V.checkForm(value);
//        } catch (Exception e) {
//            e.printStackTrace();
//            message = e.getMessage();
//            return false;
//        }
//        return true;
    }

    /**
     * 检测文件大小
     *
     * @param multipartFile 文件
     * @param size          最大大小
     * @throws MessageException
     */
    protected void checkFileSize(MultipartFile multipartFile, long size) throws MessageException {
        if (multipartFile.getSize() > size || multipartFile.getSize() <= 0) {
            throw new MessageException(Result.FILE_SIZE_NOT_SUIT);
        }
    }

//    protected void checkFileType(MultipartFile multipartFile,)

}
