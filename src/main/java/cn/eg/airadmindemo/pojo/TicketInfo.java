package cn.eg.airadmindemo.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.sql.Timestamp;

public class TicketInfo implements Serializable {
    private int ticketId;
    private String flightNo;
    private String start;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp startTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp endTime;
    private String end;
    private float price;
    private String name;
    private String phone;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
