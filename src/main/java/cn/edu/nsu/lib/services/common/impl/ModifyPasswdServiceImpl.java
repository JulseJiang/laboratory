package cn.edu.nsu.lib.services.common.impl;

import cn.edu.nsu.lib.dao.common.ModifyPasswdDao;
import cn.edu.nsu.lib.services.common.ModifyPasswdService;
import cn.edu.nsu.lib.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenGang
 * @Title: ModifyPasswdServiceImpl
 * @Package cn.edu.nsu.lib.services.common.impl
 * @Description:
 * @date 2017/9/29 0029 上午 10:52
 **/
@Service
public class ModifyPasswdServiceImpl implements ModifyPasswdService{
    @Autowired
    ModifyPasswdDao modifyPasswdDao;

    @Override
    public String   updatePasswd(String username, String password) throws Exception {
        //将密码加盐
        String[] s=EncryptUtil.parseMd5(password);
        //更新数据库密码和盐
        modifyPasswdDao.updatePasswd(username,s[0],s[1]);

        return "success";
    }
}