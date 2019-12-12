package cn.eg.airadmindemo.aop;

import cn.eg.airadmindemo.util.CacheUtil;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class UpdateTicketAcpect {//aop无法触发
    @Autowired(required = false)
    private CacheUtil cacheUtil;

    @Pointcut("execution(* cn.eg.airadmindemo.service.impl.TsBuyTicketServiceImpl.buyTicket(..))")
    public void buyTicket(){}

    @Pointcut("execution(* cn.eg.airadmindemo.service.impl.TsUndoTicketServiceImpl.undoTicket(..))")
    public void undoTicket(){}

    @AfterReturning("buyTicket()")
    public void doAfterBuyTicket(){
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        cacheUtil.deleteTicketInfo(username);
    }

    @AfterReturning("undoTicket()")
    public void doAfterUndoTicket(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        cacheUtil.deleteTicketInfo(username);
    }
}
