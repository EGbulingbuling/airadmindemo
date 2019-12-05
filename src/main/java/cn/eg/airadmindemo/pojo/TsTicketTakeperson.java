package cn.eg.airadmindemo.pojo;

import java.io.Serializable;

public class TsTicketTakeperson implements Serializable {
    private int ticketTakepersonId;
    private int ticketId;
    private int takepersonId;

    public int getTicketTakepersonId() {
        return ticketTakepersonId;
    }

    public void setTicketTakepersonId(int ticketTakepersonId) {
        this.ticketTakepersonId = ticketTakepersonId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTakepersonId() {
        return takepersonId;
    }

    public void setTakepersonId(int takepersonId) {
        this.takepersonId = takepersonId;
    }
}
