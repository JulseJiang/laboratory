package cn.edu.nsu.lib.services.teacher.impl;

import cn.edu.nsu.lib.bean.teacher.*;
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
                lab.setName(map.get("name").toString());//名称
                lab.setDescribe(map.get("lab_describe").toString());//描述
                lab.setAddress(map.get("address").toString());//地址
//                lab.setQq(map.get("qq_group").toString());//QQ群
                lab.setLab_admin(findLabAdmin(i));//实验室管理员id

                for (Map<String,Object> map_num:teacherDao.findStuNum(i)) {
                lab.setStu_num(map_num.get("stu_num").toString());//学生总人数
                }
//                lab.setAvg_fre();//考勤率 List<Map<String,Object>>
                for (Map<String,Object> map_total:teacherDao.count_fre_total(i)) {
                    float total =Integer.parseInt(map_total.get("TOTAL").toString());
                    float n = Integer.parseInt(lab.getStu_num());
                    log.info(i+"号实验室本月人均打卡total/n="+total+"/"+n+"="+(total/n));
                    lab.setAvg_fre((int)Math.ceil(total/n)+"");//实验室本月考勤总次数
                }


                labEntityList.add(lab);
                }
        }
        return labEntityList;
    }

    public String findLabAdmin(String lab_id) throws Exception{
        for (Map<String,Object> map :teacherDao.findLabAdmin(lab_id)) {
            return map.get("id").toString();
        }
        log.info("没有找到该实验室的管理员");
        return null;
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
            studentEntityList.add(stuMapToEntity(map,false));
        }
        log.info("从"+lab_id+"号实验室查到"+studentEntityList.size()+"条学生信息");
        return studentEntityList;
    }

    @Override
    public StudentEntity findStuInfo(String stu_id) throws Exception{
        for (Map<String,Object> map :teacherDao.findStuInfo(stu_id)) {
            log.info("查询学生详细信息");
            return stuMapToEntity(map,true);
        }
        log.info("没有找到" +stu_id+
                "号学生详细信息");
        return null;
    }

    /**
     * 获取实验室通知列表
     * @param lab_id
     * @return
     */
    @Override
    public List<NoticeEntity> findNoticeList(String lab_id,String t_id) throws Exception {
        List<NoticeEntity> noticeEntityList =new ArrayList<>();
        for (Map<String,Object> map :teacherDao.findNoticeList(lab_id,t_id)) {
            NoticeEntity notice = new NoticeEntity();
            notice.setPublisher(map.get("name").toString());
            notice.setTime(map.get("time").toString());
            notice.setTitle(map.get("title").toString());
            notice.setContent(map.get("content").toString());
            notice.setFile_name(map.get("file_name").toString());
            notice.setFile_path(map.get("file_path").toString());
            noticeEntityList.add(notice);
        }
        log.info("noticeEntityList.size():"+noticeEntityList.size());
        return noticeEntityList;
    }

    public StudentEntity stuMapToEntity(Map<String,Object> map,boolean flag) throws Exception {
        StudentEntity stu = new StudentEntity();
        //获取实验室的详细信息存在stu中
        stu.setId(map.get("id").toString());//学号
        stu.setName(map.get("name").toString());//姓名
        stu.setGrade(map.get("grade").toString());//年级
        stu.setMajor(map.get("major_name").toString());//专业
        stu.setTel(map.get("tel").toString());//联系电话
        for (Map<String,Object> map_fre :teacherDao.count_fre(stu.getId())) {
            //获取实验室的id存入list中
            stu.setFrequency(map_fre.get("frequency").toString());//查询月考勤情况
        }

        if(flag){//如果需要查询学生详细信息
//            log.info("实验室id："+map.get("lab_id").toString());
//            for (Map<String,Object> map_lab_name :teacherDao.findlabName(map.get("lab_id").toString())) {
                //获取实验室的id存入list中
//                stu.setLab_name(map_lab_name.get("name").toString());
//            log.info("map.get(\"frequency\").toString():"+map1.get("frequency").toString());
//            }
            if ("true".equals(map.get("gender").toString())){
                stu.setGender("女");//性别false
            }else {
                stu.setGender("男");//性别true
            }
            stu.setTime(map.get("time").toString());//加入实验室时间
            stu.setInstructor(map.get("instructor").toString());//辅导员
            stu.setLab_name(map.get("lab_name").toString());//实验室名称
            stu.setDepartment(map.get("department").toString());//系部
            stu.setStuClass(map.get("stuClass").toString());//班级
            List<Map<String,Object>> listMap = teacherDao.count_prize(stu.getId());
            for (Map<String,Object> map_prize_sum :teacherDao.count_prize(stu.getId())){
                stu.setPrize_sum(map_prize_sum.get("prize_sum").toString());//获奖次数
            }


        }

        return stu;
    }

    /**
     * 通过实验室id号查询该实验室的教师管理团队
     * @param lab_id
     * @return
     */
    @Override
    public List<TeacherEntity> findTeacherList(String lab_id) throws Exception{
        List<TeacherEntity> list = new ArrayList<>();
        for (Map<String,Object> map:teacherDao.findTeacherList(lab_id)) {
            TeacherEntity teacher = new TeacherEntity();
            teacher.setId(map.get("id").toString());
            teacher.setId(map.get("name").toString());
            teacher.setId(map.get("gender").toString());
            teacher.setId(map.get("tel").toString());
            list.add(teacher);
        }
        return list;
    }

    /**
     * 根据学生学号查找学生获奖信息列表
     * @param stu_id
     * @return
     */
    @Override
    public List<PrizeEntity> findPrizeList(String stu_id) throws Exception {
        List<PrizeEntity> list = new ArrayList<>();
        for (Map<String,Object> map:teacherDao.findPrizeList(stu_id)) {
            list.add(prizeMapToEntity(map,false));
        }
        return list;
    }

    /**
     * 解析数据库中的字段，生成奖项实体
     * @param map
     * @param flag
     * @return
     */
    private PrizeEntity prizeMapToEntity(Map<String, Object> map,boolean flag) {
        PrizeEntity prize = new PrizeEntity();
        prize.setPrize_name(map.get("prize_name").toString());
        if (flag){//展示在实验室获奖信息列表时需要显示的字段
            prize.setStu_id(map.get("owner").toString());
            prize.setStu_name(map.get("prize_name").toString());
            prize.setRegion(map.get("region").toString());
        }else{//展示在个人详情页时需要的字段
            prize.setAdviser(map.get("adviser").toString());
            prize.setIs_checked(map.get("is_checked").toString());
            prize.setTime(map.get("time").toString());
            prize.setUrl(map.get("url").toString());
            prize.setCategory(map.get("category").toString());
            prize.setRank(map.get("rank").toString());
            prize.setCommittee(map.get("committee").toString());
        }
        return prize;
    }
}
