package cn.eg.airadmindemo.config.shiro;

import cn.eg.airadmindemo.shiro.realm.DbRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setUnauthorizedUrl("/refuse");

        Map<String, String> filterChain = new LinkedHashMap<>();
        filterChain.put("/login.html","anon");
        filterChain.put("/login","anon");
        filterChain.put("/toLogin","anon");
        filterChain.put("/logout", "logout");//在这儿配置登出地址，不需要专门去写控制器。
        filterChain.put("/common/**","anon");
        filterChain.put("/frontstatic/**","anon");
        filterChain.put("/**","user");

        shiroFilter.setFilterChainDefinitionMap(filterChain);
        return shiroFilter;
    }

//    @Bean
//    public LogoutFilter logout(){
//        LogoutFilter logoutFilter=new LogoutFilter();
//        logoutFilter.setRedirectUrl("/login.html");
//        return logoutFilter;
//    }

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManage=new DefaultWebSecurityManager();
        securityManage.setRealm(shiroRealm());
//        securityManage.setCacheManager(cacheManager());
        securityManage.setSessionManager(sessionManager());
        securityManage.setRememberMeManager(rememberMeManager());
        return securityManage;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager rememberMeManager=new CookieRememberMeManager();
        rememberMeManager.setCookie(rememberMeCookie());
        return rememberMeManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie(){
        SimpleCookie simpleCookie=new SimpleCookie();
        simpleCookie.setMaxAge(604800);
        simpleCookie.setName("rememberMe");
        return simpleCookie;
    }

    /**
     * 会话管理器
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(600000);
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }

//    /**
////     * 缓存管理器，跟redis有没有关系，可不可以用redis替换
////     */
////    @Bean
////    public EhCacheManager cacheManager(){
////        EhCacheManager cacheManager=new EhCacheManager();
////        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
////        return cacheManager;
////    }

    @Bean
    public DbRealm shiroRealm(){
        DbRealm realm=new DbRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        //没有配置权限缓存,所以关闭授权缓存域
        realm.setAuthorizationCachingEnabled(false);
        return realm;
    }

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
     * HashedCredentialsMatcher说明：
     * 用户传入的token先经过shiroRealm的doGetAuthenticationInfo方法
     * 此时token中的密码为明文。
     * 再经由HashedCredentialsMatcher加密password与查询用户的结果password做对比。
     * new SimpleHash("SHA-256", password, null, 1024).toHex();
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用SHA-256算法;
        hashedCredentialsMatcher.setHashIterations(3);//散列的次数，比如散列两次，相当于 MD5(MD5(""));
        return hashedCredentialsMatcher;
    }
}
