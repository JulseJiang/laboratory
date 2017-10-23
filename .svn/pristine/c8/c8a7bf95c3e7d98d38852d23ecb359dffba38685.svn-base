package cn.edu.nsu.lib.services.admin.impl;

import cn.edu.nsu.lib.bean.admin.db.db_Major;
import cn.edu.nsu.lib.bean.admin.db.db_Student;
import cn.edu.nsu.lib.bean.admin.form.Student_form;
import cn.edu.nsu.lib.bean.admin.form.Utils.FormUtil;
import cn.edu.nsu.lib.dao.admin.IAdmin_LabmanC_DAO;
import cn.edu.nsu.lib.enums.Result;
import cn.edu.nsu.lib.services.admin.IAdmin_LabmanC_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 王振科 on 2017/9/26.
 */
@Service
public class Admin_LabmanC_Service implements IAdmin_LabmanC_Service {
    @Autowired
    private IAdmin_LabmanC_DAO labmanC_dao;

    @Override
    public Result checkadd_Service(Student_form student_form, int labid)throws Exception {
        db_Student student = new db_Student();
            //给要传入数据库的实体类注入信息
            student.setId(FormUtil.getBI(student_form.getStudent_id()));
            student.setTel(FormUtil.getBI(student_form.getTel()));
            student.setLab_id(labid);
            //通过用户输入的专业名字查到该专业的id
            db_Major major = labmanC_dao.getmajor_byname(student_form.getMajor());
            student.setMaj_id(FormUtil.getInt(major.getName()));
            student.setGender(FormUtil.getInt(student_form.getGender()));
            student.setGrade(FormUtil.getInt(student_form.getGrade()));
            student.setTime(student_form.getTime());
            student.setName(student_form.getName());
            student.setInstructor(student_form.getInstructor());

            //通过传入学生实体类
        int count = labmanC_dao.addstu(student);
        if(count == 1){
            return  Result.SUCCESS;
        }
        return  Result.FAIL;
    }

    @Override
    public Result checkalter_Service(Student_form student_form, int lab_id)throws Exception {
        db_Student student = new db_Student();
        //给要传入数据库的实体类注入信息
        student.setId(FormUtil.getBI(student_form.getStudent_id()));
        student.setTel(FormUtil.getBI(student_form.getTel()));
        //通过Controller层从session中获得的实验室id 传进要添加的student中
        student.setLab_id(lab_id);
        //通过用户输入的专业名字查到该专业的id
        db_Major major = labmanC_dao.getmajor_byname(student_form.getMajor());
        student.setMaj_id(FormUtil.getInt(major.getName()));
        student.setGender(FormUtil.getInt(student_form.getGender()));
        student.setGrade(FormUtil.getInt(student_form.getGrade()));
        student.setTime(student_form.getTime());
        student.setName(student_form.getName());
        student.setInstructor(student_form.getInstructor());

        //通过传入学生实体类进行修改
        int count = labmanC_dao.alterstu(student);
        if(count == 1){
            return  Result.SUCCESS;
        }
        return  Result.FAIL;
    }
}
