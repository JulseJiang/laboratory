package cn.edu.nsu.lib.services.admin;

import cn.edu.nsu.lib.bean.admin.form.Student_form;

/**
 * Created by 王振科 on 2017/9/26.
 */
public interface IAdministrator_LabmanC_Service {

    /**
     * 判断表单添加是否成功
     * @param student_form
     * @return
     */
    public int checkadd_Service(Student_form student_form);

    /**
     * 判断表单修改是否成功
     * @param student_form
     * @return
     */
    public int checkalter_Service(Student_form student_form);

}
