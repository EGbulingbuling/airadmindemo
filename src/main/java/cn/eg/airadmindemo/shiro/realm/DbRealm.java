package cn.eg.airadmindemo.shiro.realm;

import cn.eg.airadmindemo.pojo.UmUser;
import cn.eg.airadmindemo.service.impl.UmUserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DbRealm extends AuthorizingRealm {
    @Autowired
    private UmUserServiceImpl userService;

    @Override
    public String getName() {
        return "DbRealm";
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username= (String) token.getPrincipal();
        UmUser user=this.userService.findUserByUserName(username);
        if (user == null) {
            throw new UnknownAccountException("账号不存在！");
        }
        return new SimpleAuthenticationInfo(
                user.getUserName(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
