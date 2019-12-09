package cn.eg.airadmindemo.pojo;

import java.io.Serializable;

public class TsTicketUser implements Serializable {
    private int ticketUserId;
    private int ticketId;
    private int userId;

    public TsTicketUser() {
    }

    public TsTicketUser(int ticketUserId, int ticketId, int userId) {
        this.ticketUserId = ticketUserId;
        this.ticketId = ticketId;
        this.userId = userId;
    }

    public int getTicketUserId() {
        return ticketUserId;
    }

    public void setTicketUserId(int ticketUserId) {
        this.ticketUserId = ticketUserId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
