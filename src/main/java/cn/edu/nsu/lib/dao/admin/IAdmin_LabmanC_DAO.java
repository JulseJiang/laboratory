package cn.edu.nsu.lib.dao.admin;

import cn.edu.nsu.lib.bean.admin.db.db_Major;
import cn.edu.nsu.lib.bean.admin.db.db_Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by 王振科 on 2017/9/26.
 */
@Repository
public interface IAdmin_LabmanC_DAO {

    @Select("select * from major where name = #{name}")
    public db_Major getmajor_byname(@Param("name") String name);

//    insert into student(id,name,gender,grade,maj_id,lab_id,time,instructor,tel)
//        values(153105,'COCO',1,11,1,123,'2017-10-07','王',8749)
    @Insert("insert into student(id,name,gender,grade,maj_id,lab_id,time,instructor,tel) " +
            " values(#{student.id}," +
            "#{student.name}," +
            "#{student.gender}," +
            "#{student.grade}," +
            "#{student.maj_id}," +
            "#{student.lab_id}," +
            "#{student.time}," +
            "#{student.instructor}," +
            "#{student.tel})")
    public int addstu(@Param("student") db_Student student);

    //修改不能改学号，要盖学号要删了再添加
    @Update("update student set " +
            "name = #{student.name}," +
            "gender = #{student.gender}," +
            "grade = #{student.grade}," +
            "maj_id = #{student.maj_id}," +
            "lab_id = #{student.lab_id}," +
            "time = #{student.time}," +
            "instructor = #{student.instructor}," +
            "tel =  #{student.tel} " +
            "where id = #{student.id}")
    public int alterstu(@Param("student")db_Student student);
}
