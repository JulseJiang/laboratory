package cn.edu.nsu.lib.services.teacher.impl;

import cn.edu.nsu.lib.bean.teacher.LabEntity;
import cn.edu.nsu.lib.bean.teacher.StudentEntity;
import cn.edu.nsu.lib.dao.teacher.impl.TeacherDaoImpl;
import cn.edu.nsu.lib.services.teacher.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    /**
     * class_name: ITeacherService
     * describe: 教师端Service接口
     * creat_user: 蒋玖宏 julse@qq.com
     * creat_date: 2017/9/28
     * creat_time: 20:46
     *
     * @param t_id
     */
    @Autowired
    private TeacherDaoImpl teacherDao;
    /**
     * method_name: getStuList
     * param: [t_id]
     * describe: 通过教师的id号获取学生列表(该教师管理的所有实验室的学生信息)
     * creat_user:  julse@qq.com
     * creat_date: 2017/9/28
     **/
    @Override
    public ArrayList<StudentEntity> getStuList(String t_id) {


        /**
         * 先通过教师id找到教师管理的实验室
         */
//        List<Map<String,LabEntity>> listMap = teacherDao.findLabList(t_id);
        /**
         * 通过实验室id找到学生列表
         */
        return null;
    }

    /**
     * 通过教师id找到教师管理的实验室信息列表
     *
     * @param t_id 教师id
     * @return
     */
    @Override
    public List<LabEntity> findLabList(String t_id)throws Exception{
        List<String> list = teacherDao.findLab(t_id);
        if (list==null){
            return null;
        }
        List<LabEntity> labEntityList = new ArrayList<>();
        for (String i : list){
            labEntityList.add(teacherDao.findLabInfo(i));
        }
        return labEntityList;
    }

    /**
     * 通过实验室id号查询实验室的学生信息列表
     * @param lab_id 实验室id
     * @return
     * @throws Exception
     */
    @Override
    public List<StudentEntity> findStuList(String lab_id) throws Exception {
        teacherDao.findStuList(lab_id);
        return null;
    }
}
