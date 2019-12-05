package cn.eg.airadmindemo.service.impl;

import cn.eg.airadmindemo.mapper.UmUserMapper;
import cn.eg.airadmindemo.pojo.UmUser;
import cn.eg.airadmindemo.service.UmUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UmUserServiceImpl implements UmUserService {
    @Resource
    private UmUserMapper umUserMapper;

    @Override
    public UmUser findUserByUserName(String usernaem) {
        return umUserMapper.selByUser(usernaem);
    }

    @Override
    public boolean editPassword(String oldPwd,String newPwd) {
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        UmUser user=findUserByUserName(username);
        SimpleHash oldSh = new SimpleHash("MD5", oldPwd, user.getSalt(),3);
        if (user.getPassword().equals(oldSh.toHex())) {
            String salt= UUID.randomUUID().toString();
            SimpleHash newSh=new SimpleHash("md5",newPwd,salt,3);
            int row = umUserMapper.editPassword(user.getUserName(),newSh.toHex(),salt);
            if (row>0){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
