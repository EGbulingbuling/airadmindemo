package cn.eg.airadmindemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PassportController {

    @RequestMapping("/login")
    public String showLogin(){
        return "/login.html";
    }

    @RequestMapping("/toLogin")
    public String toLogin(String username, String password,String remember, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        if (remember!=null&&"1".equals(remember)){
            token.setRememberMe(true);
        }
        try {
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到xxRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
        } catch (Exception e) {
            token.clear();
            return "redirect:/login";
        }
        session.setAttribute("username",username);

        return "redirect:/index.html";
    }

    /**
     * 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        // 此处有坑： 退出登录，其实不用实现任何东西，只需要保留这个接口即可，也不可能通过下方的代码进行退出
        // SecurityUtils.getSubject().logout();
        // 因为退出操作是由Shiro控制的
        return "/login";
    }
}
