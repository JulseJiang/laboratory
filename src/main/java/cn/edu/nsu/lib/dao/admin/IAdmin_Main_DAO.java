package cn.edu.nsu.lib.dao.admin;

import cn.edu.nsu.lib.bean.admin.db.db_Student;
import cn.edu.nsu.lib.bean.admin.db.db_Student_check;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by 王振科 on 2017/9/27.
 */

//@Select("select id as " + Constants.KEY_MAP_USERNAME + ",identity as " + Constants.KEY_MAP_AUTHORITY +
//        ",passwd as " + Constants.KEY_MAP_PASSWORD + ",salt as " + Constants.KEY_MAP_SALT +
//        " from account where id = #{username} limit 1")
//    Map<String, Object> getAccount(@Param("username") String username) throws Exception;
//
//@Select("select * from db_Teacher where id = #{username} limit 1")
//    Map<String, Object> getTeacherUser(@Param("username") String username) throws Exception;
@Repository
public interface IAdmin_Main_DAO {

    @Select("select * from signed where lab_id = #{lab_id} and date = #{date}")
    public List<db_Student_check> getstucheck_bydate(@Param("date")String date, @Param("lab_id")int lab_id);

    @Select("select * from student where id = #{id}")
    public db_Student getstu_byid(@Param("id")BigInteger id);
}
