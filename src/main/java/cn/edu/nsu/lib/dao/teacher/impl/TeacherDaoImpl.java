package cn.edu.nsu.lib.dao.teacher.impl;

import cn.edu.nsu.lib.dao.BaseDao;
import cn.edu.nsu.lib.dao.teacher.ITeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TeacherDaoImpl extends BaseDao implements ITeacherDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 通过教师id找到实验室id列表
     * @param t_id 教师id
     * @return 实验室id
     */
    @Override
    public List<Map<String, Object>> findLab(String t_id) throws Exception{

        /**
         * creat_user: 蒋玖宏 julse@qq.com
         * creat_date: 2017/9/28
         **/
        String sql = getSql("SELECT * FROM RELATIONSHIP WHERE TEACHER_ID = '?'",new String[]{t_id});
        log.info(sql);
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 通过实验室id号查找实验室的详细信息
     * @param lab_id
     * @return
     */
    public List<Map<String, Object>> findLabInfo(String lab_id){
        /**
        * creat_user: 蒋玖宏 julse@qq.com creat_date: 2017/9/29
        **/
        String sql = "SELECT * FROM LAB WHERE ID = " +
                lab_id;
        log.info(sql);
        return jdbcTemplate.queryForList(sql);
    }
    /**
     * 通过实验室id找到学生列表
     *
     * @param lab_id
     */
    @Override
    public List<Map<String, Object>> findStuList(String lab_id){
        String sql = "SELECT \n" +
                "S.ID,\n" +
                "S.NAME,\n" +
                "S.GENDER,\n" +
                "S.GRADE," +
                "S.TIME,\n" +
                "S.TEL,\n" +
                "S.INSTRUCTOR,\n" +
                "M.NAME MAJORNAME\n" +
                "FROM STUDENT S,\n" +
                "MAJOR M \n" +
                "WHERE S.MAJ_ID=M.ID \n" +
                "AND S.LAB_ID = " +lab_id;
        log.info(sql);
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 根据专业编号查找专业
     * @param major_id
     * @return
     */
    @Override
    public List<Map<String, Object>> findMajor(String major_id){
        String sql = "SELECT NAME FROM MAJOR WHERE ID = " +
                major_id;
        log.info(sql);
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 查找实验室管理员：理论上只能有一个管理员，但是由于数据库的表结构，一个实验室的管理员可能在测试数据中有多个
     * @return
     */
    @Override
    public List<Map<String, Object>> findLabAdmin(String lab_id) {
        String sql = "SELECT S.ID FROM STUDENT S JOIN ACCOUNT A ON  S.ID=A.ID AND IDENTITY = 1 AND LAB_ID = " +
                lab_id;
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> findStuInfo(String stu_id) {
        String sql = "SELECT \n" +
                "S.ID ,\n" +
                "S.NAME ,\n" +
                "S.GENDER ,\n" +
                "S.GRADE,\n" +
                "S.TIME,\n" +
                "S.TEL,\n" +
                "S.INSTRUCTOR,\n" +
                "M.NAME MAJORNAME\n" +
                "FROM STUDENT S,\n" +
                "MAJOR M \n" +
                "WHERE S.MAJ_ID=M.ID \n" +
                "AND S.ID = " +
                stu_id;
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 通过实验室id查找实验室通知列表
     * @param lab_id
     * @return
     */
    @Override
    public List<Map<String, Object>> findNoticeList(String lab_id, String teacher_id) throws Exception{
//        String sql = "SELECT * FROM NOTICE WHERE LAB_ID =" +
//                lab_id;
        String sql =getSql( "SELECT \n" +
                "TEACHER.ID,NAME,\n" +
                "TIME,TITLE,CONTENT,FILE_NAME,FILE_PATH\n" +
                "FROM TEACHER,NOTICE WHERE LAB_ID = ? \n" +
                "AND TEACHER.ID = '?'",new String[]{lab_id,teacher_id});
        log.info("实验室通知查找："+sql);
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 根据学生学号查询学生的月考勤次数
     * @param s_id
     * @return
     * @throws Exception
     */
    @Override
    public List<Map<String, Object>> count_fre(String s_id) throws Exception {
        String sql = getSql("select count(*) frequency from signed where stu_id=? and register = 1\n" +
                "and DATE_FORMAT( date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' );",new String[]{s_id});
        log.info("查询学生月考勤次数："+sql);
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 查询该实验室学生人数
     * @param lab_id
     * @return
     */
    @Override
    public List<Map<String, Object>> findStuNum(String lab_id) {
        String sql = "SELECT COUNT(*) STU_NUM FROM STUDENT WHERE LAB_ID = "+lab_id;
        log.info("该实验室人数："+sql);
        return jdbcTemplate.queryForList(sql);
    }
    /**
     * 某实验室考勤总次数
     * @param lab_id
     * @return
     */
    @Override
    public List<Map<String, Object>> count_fre_total(String lab_id) throws Exception{
        String sql = getSql("SELECT COUNT(*) TOTAL FROM SIGNED WHERE LAB_ID=? AND REGISTER = 1\n" +
                "AND DATE_FORMAT( DATE, '%Y%M' ) = DATE_FORMAT( CURDATE( ) , '%Y%M' )",new String[]{lab_id});
        log.info("查询实验室月考勤总次数:"+sql);
        return jdbcTemplate.queryForList(sql);
    }
}
