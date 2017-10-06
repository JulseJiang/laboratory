package cn.edu.nsu.lib.dao.teacher;

import cn.edu.nsu.lib.bean.teacher.LabEntity;
import cn.edu.nsu.lib.bean.teacher.StudentEntity;
import cn.edu.nsu.lib.dao.BaseDao;

import java.util.List;

public interface ITeacherDao {
    /**
    * class_name: ITeacherDao
    * describe: 教师端数据库接口
    * creat_user: 蒋玖宏 julse@qq.com
    * creat_date: 2017/9/28
    * creat_time: 21:10
    **/



    /**
     * 通过实验室id找到实验室的详细信息
     * @param t_id
     * @return LabEntity实验室实体类
     * @throws Exception
     */
    List<String> findLab(String t_id) throws Exception;

    /**
     * 通过实验室id找到学生列表
     */
    List<String> findStuList(String lab_id) throws Exception;

    /**
     * 通过学生id找到学生信息
     * @param s_id
     * @return
     * @throws Exception
     */
    StudentEntity findStu(String s_id) throws Exception;

}
