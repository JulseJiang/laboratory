package cn.edu.nsu.lib.dao.student;

import cn.edu.nsu.lib.bean.student.StuNoticeBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StuNoticeDao{
    @Select("select * from notice")
    List<StuNoticeBean> findNoticeList();
}
