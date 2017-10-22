package cn.edu.nsu.lib.dao.teacher;

import java.util.List;
import java.util.Map;

public interface ITeacherDao {
    /**
    * class_name: ITeacherDao
    * describe: 教师端数据库接口
    * creat_user: 蒋玖宏 julse@qq.com
    * creat_date: 2017/9/28
    * creat_time: 21:10
    **/



    /**
     * 通过教师id找到实验室列表
     * @param t_id
     * @return LabEntity实验室实体类
     * @throws Exception
     */
    List<Map<String, Object>> findLab(String t_id) throws Exception;

    /**
     *  通过实验室id找到实验室的详细信息
     * @param lab_id
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> findLabInfo(String lab_id) throws Exception;

    /**
     * 通过实验室id找到学生列表
     */
    List<Map<String, Object>> findStuList(String lab_id) throws Exception;
    /**
     * 通过专业id号查找专业名称
     * @param major_id
     * @return
     */
    List<Map<String, Object>> findMajor(String major_id);
}
