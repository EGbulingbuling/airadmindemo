package cn.eg.airadmindemo.service.impl;

import cn.eg.airadmindemo.mapper.TicketInfoMapper;
import cn.eg.airadmindemo.mapper.UmUserMapper;
import cn.eg.airadmindemo.pojo.TicketInfo;
import cn.eg.airadmindemo.util.CacheUtil;
import cn.eg.airadmindemo.service.TsShowMyTicketService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TsShowMyTicketServiceImpl implements TsShowMyTicketService {
    @Autowired
    private TicketInfoMapper ticketInfoMapper;
    @Autowired
    private CacheUtil cacheUtil;

    @Override
    public List<TicketInfo> showTicketInfo() {
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        List<TicketInfo> ticketInfos=cacheUtil.getTicketInfo(username);
        if (ticketInfos!=null){
            return ticketInfos;
        }
        ticketInfos=ticketInfoMapper.selTicInf(username);
        cacheUtil.addTicketInfo(username,ticketInfos);
        return ticketInfos;
    }
}
