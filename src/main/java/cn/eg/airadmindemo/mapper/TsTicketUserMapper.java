package cn.eg.airadmindemo.mapper;

public interface TsTicketUserMapper {
    int insTicUse(int ticketId,int userId);

    int delTicUse(int ticketId);
}
