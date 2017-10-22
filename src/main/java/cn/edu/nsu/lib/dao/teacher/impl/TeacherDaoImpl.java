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
//        String sql = "SELECT * FROM STUDENT WHERE LAB_ID = " +
//                lab_id;
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
}
