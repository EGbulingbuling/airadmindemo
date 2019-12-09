package cn.eg.airadmindemo.service.impl;

import cn.eg.airadmindemo.mapper.UmUserMapper;
import cn.eg.airadmindemo.pojo.UmUser;
import cn.eg.airadmindemo.util.CacheUtil;
import cn.eg.airadmindemo.service.UmUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UmUserServiceImpl implements UmUserService {
    @Resource
    private UmUserMapper umUserMapper;
    @Autowired
    private CacheUtil cacheUtil;

    @Override
    public UmUser findUserByUserName(String username) {
        UmUser user= cacheUtil.getUser(username);
        if (user!=null){
            return user;
        }
        user=umUserMapper.selByUser(username);
        cacheUtil.addUser(username,user);
        return user;
    }

    @Override
    public boolean editPassword(String oldPwd,String newPwd) {
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        UmUser user= cacheUtil.getUser(username);
        if (user==null){
            user=umUserMapper.selByUser(username);
            cacheUtil.addUser(username,user);
        }
        SimpleHash oldSh = new SimpleHash("MD5", oldPwd, user.getSalt(),3);
        if (user.getPassword().equals(oldSh.toHex())) {
            String salt= UUID.randomUUID().toString();
            SimpleHash newSh=new SimpleHash("md5",newPwd,salt,3);
            int row = umUserMapper.editPassword(user.getUserName(),newSh.toHex(),salt);
            user.setPassword(newSh.toHex());
            user.setSalt(salt);
            cacheUtil.addUser(username,user);
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
