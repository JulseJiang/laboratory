package cn.edu.nsu.lib.services.admin;

/**
 * Created by 王振科 on 2017/9/26.
 */
public interface IAdministrator_Prize_Service {
    /**
     * 判断 通过获奖审核是否成功
     * @param notice_id
     * @return
     */
    public int Passcheck_Service(int notice_id);

    /**
     * 判断 不通过获奖审核是否成功
     * @param notice_id
     * @return
     */
    public int Nopass_Service (int notice_id);

    /**
     * 判断 删除获奖信息是否成功
     * @param notice_id
     * @return
     */
    public int Deletewinner_Service (int notice_id);
}
