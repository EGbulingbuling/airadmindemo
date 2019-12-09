package cn.eg.airadmindemo.mapper;

import cn.eg.airadmindemo.pojo.TicketInfo;

import java.util.List;

public interface TicketInfoMapper {
    List<TicketInfo> selTicInf(String username);
}
