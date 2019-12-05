package cn.eg.airadmindemo.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.sql.Timestamp;

public class TsTicket implements Serializable {
    private int ticketId;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
