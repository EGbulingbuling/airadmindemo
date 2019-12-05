package cn.eg.airadmindemo.service.impl;

import cn.eg.airadmindemo.mapper.TicketInfoMapper;
import cn.eg.airadmindemo.mapper.UmUserMapper;
import cn.eg.airadmindemo.pojo.TicketInfo;
import cn.eg.airadmindemo.pojo.UmUser;
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
    @Resource
    private UmUserMapper umUserMapper;

    @Override
    public List<TicketInfo> showTicketInfo() {
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        UmUser user =umUserMapper.selByUser(username);
        List<TicketInfo> ticketInfos=ticketInfoMapper.selTicInf(user.getUserId());
        return ticketInfos;
    }
}
