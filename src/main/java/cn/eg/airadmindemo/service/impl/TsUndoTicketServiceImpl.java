package cn.eg.airadmindemo.service.impl;

import cn.eg.airadmindemo.mapper.*;
import cn.eg.airadmindemo.service.TsUndoTicketService;
import cn.eg.airadmindemo.util.CacheUtil;
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
public class TsUndoTicketServiceImpl implements TsUndoTicketService {
    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Autowired
    private TsTicketMapper tsTicketMapper;
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

    @Override
    @Transactional
    public boolean undoTicket(int ticketId) {
        DefaultTransactionDefinition def=new DefaultTransactionDefinition();
        def.setName("buyTicketTx");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        int row1= 0;
        int row2= 0;
        int row5= 0;
        int row3= 0;
        int row4= 0;
        try {
            //删除机票用户
            row1 = tsTicketUserMapper.delTicUse(ticketId);
            //删除机票乘客
            row2 = tsTicketTakepersonMapper.delTicTak(ticketId);
            //航班表人数+1
            row5 = udpFlightForUndo(ticketId);
            //删除机票航班
            row3 = tsFlightTicketMapper.delFliTic(ticketId);
            //删除机票
            row4 = tsTicketMapper.delTic(ticketId);

            String username= (String) SecurityUtils.getSubject().getPrincipal();
            cacheUtil.deleteTicketInfo(username);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }

        return row1>0&&row2>0&&row3>0&&row4>0&&row5>0;
    }

    private int udpFlightForUndo(int ticketId){
        int flightId=tsFlightTicketMapper.selFliIdForTicId(ticketId);
        return tsFlightMapper.udpFliForUndo(flightId);
    }
}
