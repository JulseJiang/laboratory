package cn.edu.nsu.lib.services.teacher;

import cn.edu.nsu.lib.bean.teacher.LabEntity;
import cn.edu.nsu.lib.bean.teacher.StudentEntity;

import java.util.ArrayList;
import java.util.List;
public interface ITeacherService {
    /**
    * class_name: ITeacherService
    * describe: 教师端Service接口
    * creat_user:  julse@qq.com
    * creat_date: 2017/9/28
    * creat_time: 20:46
    **/

    /**
     * 获取学生列表
     * @param lab_id 实验室id
     * @return
     */
    public ArrayList<StudentEntity> getStuList(String lab_id);
    /**
    * creat_user:  julse@qq.com
    * creat_date: 2017/9/28
    **/

    /**
     * 获取实验室详细信息列表
     * @param t_id 教师id
     * @return
     */
    public List<LabEntity> findLabList(String t_id) throws Exception;

    /**
     * 通过实验室id号查询实验室的学生信息列表
     * @param lab_id 实验室id
     * @return
     * @throws Exception
     */
    public List<StudentEntity> findStuList(String lab_id) throws Exception;
}
