package cn.edu.nsu.lib.services.admin;

import cn.edu.nsu.lib.bean.admin.Student;

import java.util.ArrayList;

/**
 * Created by 王振科 on 2017/9/26.
 */
public interface IAdministrator_Labman_Service {

    /**
     * 判断通过id删除成员是否成功
     * @param student_id
     * @return
     */
    public int deleteLabman_Service(int student_id);

    /**
     * 通过成员id返回成员对象
     * @return
     */
    public Student tochangeLabman_Service(int student_id);

    /**
     * 通过session里的实验室id，返回该实验室成员对象
     * @param Lab_id
     * @return
     */
    public ArrayList<Student> toLabmaninfo_Service(int Lab_id);




}
