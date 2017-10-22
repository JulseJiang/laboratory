package cn.edu.nsu.lib.services.teacher.impl;

import cn.edu.nsu.lib.bean.teacher.LabEntity;
import cn.edu.nsu.lib.bean.teacher.StudentEntity;
import cn.edu.nsu.lib.dao.teacher.impl.TeacherDaoImpl;
import cn.edu.nsu.lib.services.teacher.ITeacherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
//    private TeacherDaoManager dao;
    private TeacherDaoImpl teacherDao;
    protected Log log = LogFactory.getLog(getClass());
    /**
     * method_name: getStuList
     * param: [t_id]
     * describe: 通过教师的id号获取学生列表(该教师管理的所有实验室的学生信息)
     * creat_user:  julse@qq.com
     * creat_date: 2017/9/28
     **/
    @Override
    public ArrayList<StudentEntity> findStuListAll(String t_id) {


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
        List<String> idlist = new ArrayList<>();
        List<Map<String,Object>> idlistMap=teacherDao.findLab(t_id);
        if (idlistMap==null){
            log.info("该教师没有管理实验室");
            return null;
        }
        for (Map<String,Object> map :idlistMap) {
            //获取实验室的id存入list中
            idlist.add(map.get("lab_id").toString());
        }
        log.info("该教师管理的实验室个数为："+idlist.size());
        List<LabEntity> labEntityList = new ArrayList<>();
        for (String i : idlist){
            LabEntity lab = new LabEntity();
            List<Map<String,Object>> listMap = teacherDao.findLabInfo(i);
            for (Map<String,Object> map :listMap) {
                //获取实验室的详细信息存在lab中
                lab.setId(i);
                lab.setName(map.get("name").toString());
//                lab.setDescrib(map.get("lab_describe").toString());
//                lab.setAddress(map.get("address").toString());
//                lab.setQq(map.get("qq_group").toString());
                labEntityList.add(lab);
            }
        }
        return labEntityList;
    }

    @Override
    public LabEntity findLabEntity(String lab_id) throws Exception {
        LabEntity lab = new LabEntity();
        List<Map<String,Object>> listMap = teacherDao.findLabInfo(lab_id);
        for (Map<String,Object> map :listMap) {
            //获取实验室的详细信息存在lab中
            lab.setId(lab_id);
            lab.setName(map.get("name").toString());
            lab.setDescrib(map.get("lab_describe").toString());
            lab.setAddress(map.get("address").toString());
            lab.setQq(map.get("qq_group").toString());
        }
        return lab;
    }

    /**
     * 通过实验室id号查询实验室的学生信息列表
     * @param lab_id 实验室id
     * @return
     * @throws Exception
     */
    @Override
    public List<StudentEntity> findStuList(String lab_id) throws Exception {
        List<StudentEntity> studentEntityList = new ArrayList<>();
        List<Map<String,Object>> listMap=teacherDao.findStuList(lab_id);
        if (listMap==null){
            log.info("没有查到该实验室的学生信息");
            return null;
        }
        for (Map<String,Object> map :listMap) {
            StudentEntity stu = new StudentEntity();
            //获取实验室的详细信息存在stu中
            stu.setId(map.get("id").toString());//学号
            stu.setName(map.get("name").toString());//姓名
            stu.setGender(map.get("gender").toString());//性别
            stu.setGrade(map.get("grade").toString());//年级
            stu.setTime(map.get("time").toString());//加入实验室时间
            stu.setMajor(map.get("majorname").toString());//专业
            stu.setInstuctor(map.get("instructor").toString());//辅导员
            stu.setTel(map.get("tel").toString());//联系电话

//            teacherDao.findMajor(map.get("maj_id").toString());

            studentEntityList.add(stu);
        }
        log.info("从"+lab_id+"号实验室查到"+studentEntityList.size()+"条学生信息");

        return studentEntityList;
    }
}
