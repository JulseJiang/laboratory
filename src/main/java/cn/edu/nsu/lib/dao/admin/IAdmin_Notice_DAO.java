package cn.edu.nsu.lib.dao.admin;

import cn.edu.nsu.lib.bean.admin.db.db_Notice;
import cn.edu.nsu.lib.bean.admin.db.db_Student;
import cn.edu.nsu.lib.bean.admin.db.db_Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by 王振科 on 2017/9/26.
 */
@Repository
public interface IAdmin_Notice_DAO {

    @Select("select * from notice where lab_id = #{lab_id}")
    public List<db_Notice> getnotice_byid(@Param("lab_id")int lab_id);

    @Select("select * from student where id = #{id}")
    public db_Student getstu_byid(@Param("id")BigInteger id);

    @Select("select * from teacher where id = #{id}")
    public db_Teacher getteacher_byid(@Param("id")BigInteger id);

    @Delete("delete from notice where id = #{id} and lab_id = #{lab_id}")
    public int deletenotice_byid(@Param("id") int id, @Param("lab_id")int lab_id);
}
