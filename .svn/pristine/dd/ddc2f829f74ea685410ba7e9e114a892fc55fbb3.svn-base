package cn.edu.nsu.lib.services.admin;

import cn.edu.nsu.lib.bean.admin.db.db_Student;
import cn.edu.nsu.lib.enums.Result;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by 王振科 on 2017/9/26.
 */
public interface IAdmin_Labman_Service {

    /**
     * 判断通过id删除成员是否成功
     *
     * @param id
     * @return
     */
    public Result deleteLabman_Service(BigInteger id) throws Exception;

    /**
     * 通过成员id返回成员对象
     * @return
     */
    public db_Student tochangeLabman_Service(BigInteger id, int lab_id) throws Exception;

    /**
     * 通过session里的实验室id，返回该实验室成员对象
     * @param Lab_id
     * @return
     */
    public ArrayList<db_Student> toLabmaninfo_Service(int Lab_id) throws Exception;




}
