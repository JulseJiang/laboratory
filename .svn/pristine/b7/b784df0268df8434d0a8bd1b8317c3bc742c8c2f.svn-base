package cn.edu.nsu.lib.services.admin.impl;

import cn.edu.nsu.lib.bean.admin.db.db_Notice;
import cn.edu.nsu.lib.bean.admin.form.HandleForm.HandleNotice;
import cn.edu.nsu.lib.bean.admin.form.Notice_form;
import cn.edu.nsu.lib.dao.admin.IAdmin_NoticeC_DAO;
import cn.edu.nsu.lib.enums.Result;
import cn.edu.nsu.lib.services.admin.IAdmin_NoticeC_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 王振科 on 2017/9/26.
 */
@Service
public class Admin_NoticeC_Service implements IAdmin_NoticeC_Service {
    @Autowired
    private IAdmin_NoticeC_DAO noticeC_dao;

    @Override
    public Result Uploadnoticems_Service(Notice_form notice_form, int lab_id) throws Exception {
        //Notice封装好的处理类(会把form表单的数据处理后传进notic实体类)，
        // 构造方法依次传入Notice表单和Notice的实体类
        HandleNotice handleNotice = new HandleNotice(notice_form);
        db_Notice notice = handleNotice.getdb_Notice();
        int count = noticeC_dao.addnotice_bybean(notice);
        if(count == 1){
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }
}
