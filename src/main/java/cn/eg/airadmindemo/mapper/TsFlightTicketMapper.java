package cn.eg.airadmindemo.mapper;

public interface TsFlightTicketMapper {
    int insFliTic(int flightId, int ticketId);

    int delFliTic(int ticketId);

    int selFliIdForTicId(int ticketId);
}
