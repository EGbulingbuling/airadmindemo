package cn.eg.airadmindemo.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class TsFlight implements Serializable {
    private int ticketId;
    private String flightNo;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp startTime;
    private String start;
    private String end;
    private float price;
    private int peoNum;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp endTime;
    private float discount;
    private String startCity;
    private String endCity;
    private String aircraftType;
    private String airCompany;

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

    @Override
    public String toString() {
        return "TsFlight{" +
                "ticketId=" + ticketId +
                ", flightNo='" + flightNo + '\'' +
                ", startTime=" + startTime +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", price=" + price +
                ", peoNum=" + peoNum +
                ", endTime=" + endTime +
                ", discount=" + discount +
                ", startCity='" + startCity + '\'' +
                ", endCity='" + endCity + '\'' +
                ", aircraftType='" + aircraftType + '\'' +
                ", airCompany='" + airCompany + '\'' +
                '}';
    }

    public String getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(String airCompany) {
        this.airCompany = airCompany;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

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

    public int getPeoNum() {
        return peoNum;
    }

    public void setPeoNum(int peoNum) {
        this.peoNum = peoNum;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
