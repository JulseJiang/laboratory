package cn.edu.nsu.lib.dao.teacher.impl;

import cn.edu.nsu.lib.bean.teacher.LabEntity;
import cn.edu.nsu.lib.bean.teacher.StudentEntity;
import cn.edu.nsu.lib.dao.BaseDao;
import cn.edu.nsu.lib.dao.teacher.ITeacherDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherDaoImpl extends BaseDao implements ITeacherDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 通过教师id找到实验室id
     * @param t_id 教师id
     * @return 实验室id
     */
    @Override
    public List<String> findLab(String t_id) throws Exception{

        /**
         * creat_user: 蒋玖宏 julse@qq.com
         * creat_date: 2017/9/28
         **/
        //sql语句只需要一个参数时使用
   /*     String sql = "SELECT * FROM RELATIONSHIP WHERE TEACHER_ID = " +
                t_id;*/
   //sql语句中需要多个参数时使用
        String sql = getSql("SELECT * FROM RELATIONSHIP WHERE TEACHER_ID = '?'",new String[]{t_id});
        List<String> list = new ArrayList<>();
        List<Map<String,Object>> listMap = jdbcTemplate.queryForList(sql);
        if (listMap==null){
            return null;
        }
        for (Map<String,Object> map :listMap) {
            //获取实验室的id存入list中
            list.add(map.get("lab_id").toString());
        }
        return list;
    }

    /**
     * 通过实验室id号查找实验室的详细信息
     * @param lab_id
     * @return
     */
    public LabEntity findLabInfo(String lab_id){
        /**
        * creat_user: 蒋玖宏 julse@qq.com creat_date: 2017/9/29
        **/
        String sql = "SELECT * FROM LAB WHERE ID = " +
                lab_id;
        LabEntity lab = new LabEntity();
        List<Map<String,Object>> listMap = jdbcTemplate.queryForList(sql);
        if (listMap==null){
            return null;
        }
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
     * 通过实验室id找到学生列表
     *
     * @param lab_id
     */
    @Override
    public List<StudentEntity> findStuList(String lab_id){
        List<StudentEntity> studentEntityList = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT WHERE LAB_ID = " +
                lab_id;
        StudentEntity stu = new StudentEntity();
        List<Map<String,Object>> listMap = jdbcTemplate.queryForList(sql);
        if (listMap==null){
            return null;
        }
        for (Map<String,Object> map :listMap) {
            //获取实验室的详细信息存在stu中
            stu.setId(map.get("id").toString());//学号
            stu.setName(map.get("name").toString());//姓名
            stu.setGender(map.get("gender").toString());//性别
            stu.setGrade(map.get("grade").toString());//年级
            stu.setTime(map.get("time").toString());//加入实验室时间
            stu.setMajor(map.get("major").toString());//专业
            stu.setInstuctor(map.get("instructor").toString());//辅导员
            stu.setTel(map.get("tel").toString());//联系电话
            studentEntityList.add(stu);
        }
        return studentEntityList;
    }

    /**
     * 通过学生id找到学生信息
     *
     * @param s_id
     * @return
     * @throws Exception
     */
    @Override
    public StudentEntity findStu(String s_id) {
        return null;
    }
}
