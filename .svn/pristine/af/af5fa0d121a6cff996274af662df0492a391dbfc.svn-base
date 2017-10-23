package cn.edu.nsu.lib.services.admin.impl;

import cn.edu.nsu.lib.bean.admin.db.db_Student;
import cn.edu.nsu.lib.dao.admin.IAdmin_Labman_DAO;
import cn.edu.nsu.lib.enums.Result;
import cn.edu.nsu.lib.services.admin.IAdmin_Labman_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by 王振科 on 2017/9/26.
 */
@Service
public class Admin_Labman_Service implements IAdmin_Labman_Service {
    @Autowired
    private IAdmin_Labman_DAO labman_dao;

    @Override
    public Result deleteLabman_Service(BigInteger id)throws Exception {
        //通过学生id直接删除account表中的数据，级联删除了student表的数据
        int count = labman_dao.deleteman_byid(id);
        //如果影响行数为0就返回fail
        if(count == 0){
            return Result.FAIL;
        }
        return Result.SUCCESS;
    }

    @Override
    public db_Student tochangeLabman_Service(BigInteger id, int lab_id)throws Exception {
        db_Student student = labman_dao.getstu_byid(id,lab_id);
        return student;
    }

    @Override
    public ArrayList<db_Student> toLabmaninfo_Service(int Lab_id)throws Exception {
        ArrayList<db_Student> list=labman_dao.getstus_byid(Lab_id);
        return list;
    }
}
