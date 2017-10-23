//package cn.edu.nsu.lib.services.admin.impl;
//
//import cn.edu.nsu.lib.bean.admin.Notice;
//import cn.edu.nsu.lib.bean.admin.db.db_Notice;
//import cn.edu.nsu.lib.bean.admin.db.db_Student;
//import cn.edu.nsu.lib.bean.admin.db.db_Teacher;
//import cn.edu.nsu.lib.dao.admin.IAdmin_Notice_DAO;
//import cn.edu.nsu.lib.enums.Result;
//import cn.edu.nsu.lib.services.admin.IAdmin_Notice_Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by 王振科 on 2017/9/26.
// */
//@Service
//public class Admin_Notice_Service implements IAdmin_Notice_Service {
//    @Autowired
//    private IAdmin_Notice_DAO notice_dao;
//
//    @Override
//    public ArrayList<Notice> toNotice_Service(int Lab_id)throws Exception {
//        //通过实验室id获得该实验室的公告list
//        List<db_Notice> list = notice_dao.getnotice_byid(Lab_id);
//        //最终返回的数据集合(公告信息)
//        ArrayList<Notice> notices = new ArrayList<>();
//            for (db_Notice db_notice :
//                    list) {
//                Notice notice = new Notice();
//                //1.插入公告信息
//                notice.setId(db_notice.getId());
//                notice.setLab_id(db_notice.getLab_id());
//                notice.setPublisher(db_notice.getPublisher());
//                notice.setTitle(db_notice.getTitle());
//                notice.setContent(db_notice.getContent());
//                notice.setFile_name(db_notice.getFile_name());
//                notice.setFile_path(db_notice.getFile_path());
//                notice.setTime(db_notice.getTime());
//                //2.根据发布者id插入其名字
//                BigInteger Publisher_id = db_notice.getPublisher();
//                db_Student student = notice_dao.getstu_byid(Publisher_id);
//                db_Teacher teacher;
//                if(student == null){
//                    teacher = notice_dao.getteacher_byid(Publisher_id);
//                    //2.1.发布人是老师就设置老师名字
//                    notice.setPublisher_name(teacher.getName());
//                }else {
//                    //2.2.发布人是学生就设置学生名字
//                    notice.setPublisher_name(student.getName());
//                }
//                notices.add(notice);
//            }
//        return notices;
//    }
//
//
//    @Override
//    public Result Deletenotice_Service(int Notice_id,int Lab_id)throws Exception {
//        int count = notice_dao.deletenotice_byid(Notice_id,Lab_id);
//        if(count == 1){
//            return Result.SUCCESS;
//        }
//        return Result.FAIL;
//    }
//
//
//}
