package cn.edu.nsu.lib.dao.admin;

import cn.edu.nsu.lib.bean.admin.db.db_Prize;
import cn.edu.nsu.lib.bean.admin.db.db_Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by 王振科 on 2017/9/26.
 */
@Repository
public interface IAdmin_Prize_DAO {
    @Select("select * from prize where lab_id = #{lab_id}")
    public List<db_Prize> getstuprize_byid(@Param("lab_id") int lab_id);

    @Select("select * from prize where id = #{id}")
    public db_Student getownname_byid(@Param("id") BigInteger id);

    @Update("update prize set " +
            "is_checked =  #{is_checked} " +
            "where id = #{id} and lab_id = #{lab_id}")
    public int updateprize_byid(@Param("id") int id, @Param("lab_id")int lab_id , @Param("is_checked")boolean is_checked);

    @Delete("delete from prize where id = #{id} and lab_id = #{lab_id}")
    public int deletedateprize_byid(int id, int lab_id);
}
