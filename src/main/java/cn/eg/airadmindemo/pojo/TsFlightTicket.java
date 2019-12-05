package cn.eg.airadmindemo.pojo;

import java.io.Serializable;

public class TsFlightTicket implements Serializable {
    private int flightTicketId;
    private int ticketId;
    private int flightId;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getFlightTicketId() {
        return flightTicketId;
    }

    public void setFlightTicketId(int flightTicketId) {
        this.flightTicketId = flightTicketId;
    }
}
