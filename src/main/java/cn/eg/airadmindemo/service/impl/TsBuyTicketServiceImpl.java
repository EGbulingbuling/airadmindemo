package cn.eg.airadmindemo.service.impl;


import cn.eg.airadmindemo.mapper.*;
import cn.eg.airadmindemo.pojo.TsTakeperson;
import cn.eg.airadmindemo.pojo.UmUser;
import cn.eg.airadmindemo.util.CacheUtil;
import cn.eg.airadmindemo.service.TsBuyTicketService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

@Service
public class TsBuyTicketServiceImpl implements TsBuyTicketService {
    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Autowired
    private TsTicketMapper tsTicketMapper;
    @Autowired
    private TsTakepersonMapper tsTakepersonMapper;
    @Autowired
    private TsFlightTicketMapper tsFlightTicketMapper;
    @Autowired
    private TsFlightMapper tsFlightMapper;
    @Autowired
    private TsTicketTakepersonMapper tsTicketTakepersonMapper;
    @Autowired
    private TsTicketUserMapper tsTicketUserMapper;
    @Autowired
    private CacheUtil cacheUtil;
    @Resource
    private UmUserMapper umUserMapper;

    @Override
    @Transactional
    public boolean buyTicket(int flightId, String PersonName, String PersonId, String PersonPhone) {
        DefaultTransactionDefinition def=new DefaultTransactionDefinition();
        def.setName("buyTicketTx");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        int row1= 0;
        int row3= 0;
        int row6= 0;
        int row2= 0;
        int row4= 0;
        int row5= 0;

        try {
            //插入机票
            row1 = addTicket();
            int ticketId=getTicketId();
            //插入机票航班
            row3 = addFlightTicket(flightId,ticketId);
            //航班表人数-1
            row6 = udpFlightForBuy(flightId);
            //插入乘客
            row2 = addTakeperson(PersonName,PersonId,PersonPhone);
            int takepersonId=row2<0?getTakepersonId():row2;
            //插入机票乘客
            row4 = addTicketTakeperson(ticketId,takepersonId);
            //插入机票用户
            row5 = addTicketUser(ticketId);

            String username= (String) SecurityUtils.getSubject().getPrincipal();
            cacheUtil.deleteTicketInfo(username);

        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }

        return row1 > 0 && row2 != 0 && row3 > 0 && row4 > 0 && row5 > 0 && row6 > 0;
    }

    private int addTicketUser(int ticketId) {
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        UmUser user= cacheUtil.getUser(username);
        if (user==null){
            user=umUserMapper.selByUser(username);
            cacheUtil.addUser(username,user);
        }
        return tsTicketUserMapper.insTicUse(ticketId,user.getUserId());
    }

    private int addTicketTakeperson(int ticketId, int takepersonId) {
        return tsTicketTakepersonMapper.insTicTak(ticketId,takepersonId);
    }
    private int udpFlightForBuy(int flightId) {
        return tsFlightMapper.updFliForBuy(flightId);
    }

    private int addFlightTicket(int flightId, int ticketId) {
        return tsFlightTicketMapper.insFliTic(flightId,ticketId);
    }

    /**
     *
     * @param PersonName
     * @param PersonId
     * @param PersonPhone
     * @return 如果存在该身份证号则返回takepersonId
     */
    private int addTakeperson(String PersonName,String PersonId,String PersonPhone) {
        TsTakeperson tsTakeperson=cacheUtil.getTakeperson(PersonId);
        if (tsTakeperson!=null){
            return tsTakeperson.getTakepersonId();
        }
        tsTakeperson =tsTakepersonMapper.selTakById(PersonId);
        if (tsTakeperson!=null){
            cacheUtil.addTakeperson(PersonId,tsTakeperson);
            return tsTakeperson.getTakepersonId();
        }else {
            tsTakepersonMapper.insTak(PersonName,PersonId,PersonPhone);
            return -1;
        }
    }

    private int getTakepersonId() {
        return tsTakepersonMapper.selTakId();
    }

    private int addTicket() {
        return tsTicketMapper.insTic();
    }

    private int getTicketId() {
        return tsTicketMapper.selTicId();
    }
}
