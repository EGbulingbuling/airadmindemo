package cn.eg.airadmindemo.service;

import cn.eg.airadmindemo.pojo.UmUser;

public interface UmUserService {
    UmUser findUserByUserName(String usernaem);

    boolean editPassword(String oldPwd,String newPwd);
}
