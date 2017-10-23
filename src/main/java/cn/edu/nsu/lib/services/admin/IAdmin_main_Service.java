package cn.edu.nsu.lib.services.admin;

import cn.edu.nsu.lib.bean.admin.Student_check;

import java.util.ArrayList;

/**
 * Created by 王振科 on 2017/9/26.
 */
public interface IAdmin_main_Service {
    /**
     * 通过时间获取到所有学生考勤
     * @param datestring
     * @param lab_id
     * @return
     */
    public ArrayList<Student_check> mainpage_Service(String datestring, int lab_id) throws Exception;

}
