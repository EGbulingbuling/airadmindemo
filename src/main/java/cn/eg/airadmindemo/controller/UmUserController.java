package cn.eg.airadmindemo.controller;

import cn.eg.airadmindemo.pojo.UmUser;
import cn.eg.airadmindemo.service.impl.UmUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UmUserController {
    @Autowired
    private UmUserServiceImpl userService;

    @RequestMapping("/editPassword")
    @ResponseBody
    public String editPassword(String oldPwd, String newPwd){
        boolean isEdit=userService.editPassword(oldPwd,newPwd);
        if (isEdit){
            return "1";
        }else {
            return "0";
        }
    }
}
