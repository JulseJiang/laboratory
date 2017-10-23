//package cn.edu.nsu.lib.services.admin.impl;
//
//import cn.edu.nsu.lib.bean.admin.Prize;
//import cn.edu.nsu.lib.bean.admin.db.db_Prize;
//import cn.edu.nsu.lib.bean.admin.db.db_Student;
//import cn.edu.nsu.lib.dao.admin.IAdmin_Prize_DAO;
//import cn.edu.nsu.lib.enums.Result;
//import cn.edu.nsu.lib.services.admin.IAdmin_Prize_Service;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by 王振科 on 2017/10/5.
// */
//@Service
//public class Admin_Prize_Service implements IAdmin_Prize_Service{
//    @Autowired
//    private IAdmin_Prize_DAO prize_dao;
//    private Log log = LogFactory.getLog(Admin_Prize_Service.class);
//
//    @Override
//    public Result Passcheck_Service(int prize_id,int Lab_id,boolean is_checked)throws Exception {
//        int count = prize_dao.updateprize_byid(prize_id,Lab_id,is_checked);
//        if(count == 1){
//            return Result.SUCCESS;
//        }
//        return Result.FAIL;
//    }
//
//    @Override
//    public Result Nopass_Service(int prize_id, int Lab_id,boolean is_checked)throws Exception {
//
//        int count = prize_dao.updateprize_byid(prize_id,Lab_id,is_checked);
//        if(count == 1){
//            return Result.SUCCESS;
//        }
//        return Result.FAIL;
//    }
//
//    @Override
//    public Result Deletewinner_Service(int prize_id, int Lab_id)throws Exception {
//        int count = prize_dao.deletedateprize_byid(prize_id,Lab_id);
//        if(count == 1){
//            return Result.SUCCESS;
//        }
//        return Result.FAIL;
//    }
//
//    @Override
//    public ArrayList<Prize> toprize(int Lab_id)throws Exception {
//        List<db_Prize> list = prize_dao.getstuprize_byid(Lab_id);
//        //最终返回的结果（奖项）
//        ArrayList<Prize> prizes = new ArrayList<>();
//            //遍历插入信息
//            for (db_Prize dbPrize :
//                    list) {
//                Prize prize = new Prize();
//                //插入奖项信息
//                prize.setId(dbPrize.getId());
//                prize.setOwner(dbPrize.getOwner());
//                prize.setName(dbPrize.getPrize_name());
//                log.info("奖项名字"+dbPrize.getPrize_name());
//                prize.setCategory(dbPrize.getCategory());
//                prize.setRank(dbPrize.getRank());
//                prize.setRegion(dbPrize.getRegion());
//                prize.setTime(dbPrize.getTime());
//                prize.setUrl(dbPrize.getUrl());
//                prize.setCheck(dbPrize.isIs_checked());
//
//                //根据id插入获奖人的名字
//                db_Student student = prize_dao.getownname_byid(dbPrize.getOwner());
//                prize.setOwner_name(student.getName());
//                prizes.add(prize);
//            }
//        return prizes;
//    }
//}
