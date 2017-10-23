package cn.edu.nsu.lib.services.admin;

import cn.edu.nsu.lib.bean.admin.form.Notice_form;
import cn.edu.nsu.lib.enums.Result;

/**
 * Created by 王振科 on 2017/9/26.
 */
public interface IAdmin_NoticeC_Service {
    /**
     * 判断上传表单数据是否成功
     * @param notice_form
     * @return
     */
    public Result Uploadnoticems_Service(Notice_form notice_form, int lab_id) throws Exception;
}
