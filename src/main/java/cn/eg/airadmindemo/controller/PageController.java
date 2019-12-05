package cn.eg.airadmindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 */
@Controller
public class PageController {

    @RequestMapping("/index.html")
    public String showPage(){
        return "/index.html";
    }

    @RequestMapping("html/system/{page}")
    public String showPage1(@PathVariable String page){
        return "html/system/"+page;
    }
    @RequestMapping("html/caiwu/{page}")
    public String showPage2(@PathVariable String page){
        return "html/caiwu/"+page;
    }

    @RequestMapping("html/msg/{page}")
    public String showPage3(@PathVariable String page){
        return "html/msg/"+page;
    }

    @RequestMapping("html/insurance/{page}")
    public String showPage4(@PathVariable String page){
        return "html/insurance/"+page;
    }

    @RequestMapping("html/ticket/{page}")
    public String showPage5(@PathVariable String page){
        return "html/ticket/"+page;
    }

    @RequestMapping("html/user/{page}")
    public String showPage6(@PathVariable String page){
        return "html/user/"+page;
    }

    @RequestMapping("html/xingchengdan/{page}")
    public String showPage7(@PathVariable String page){
        return "html/xingchengdan/"+page;
    }

}
