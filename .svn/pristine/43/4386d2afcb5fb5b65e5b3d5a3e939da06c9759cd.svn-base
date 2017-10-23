package cn.edu.nsu.lib.dao.admin;

import cn.edu.nsu.lib.bean.admin.db.db_Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by 王振科 on 2017/9/26.
 */
@Repository
public interface IAdmin_Labman_DAO {

    @Select("select * from student where lab_id = #{lab_id}")
    public ArrayList<db_Student> getstus_byid(@Param("lab_id") int lab_id);

    @Delete("delete from account where id = #{id}")
    public int deleteman_byid(@Param("id") BigInteger id);

    @Select("select * from student where id = #{id} and lab_id = #{lab_id}")
    public db_Student getstu_byid(@Param("id") BigInteger id, @Param("lab_id")int lab_id);
}
