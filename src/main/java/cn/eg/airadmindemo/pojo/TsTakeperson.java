package cn.eg.airadmindemo.pojo;

import java.io.Serializable;

public class TsTakeperson implements Serializable {
    private int takepersonId;
    private String name;
    private String idNumber;
    private String phone;

    public int getTakepersonId() {
        return takepersonId;
    }

    public void setTakepersonId(int takepersonId) {
        this.takepersonId = takepersonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
