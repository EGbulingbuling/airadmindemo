package cn.eg.airadmindemo.mapper;

import cn.eg.airadmindemo.pojo.UmUser;

public interface UmUserMapper {
    UmUser selByUser(String username);

    int editPassword(String username,String password,String salt);
}
