package cn.eg.airadmindemo.mapper;

public interface TsTicketTakepersonMapper {
    int insTicTak(int ticketId, int takepersonId);

    int delTicTak(int ticketId);
}
