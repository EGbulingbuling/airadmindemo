package cn.eg.airadmindemo.pojo;

import java.io.Serializable;
import java.sql.Date;

public class UmUser implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private String salt;
    private String phone;
    private String sex;
    private String nickname;
    private String address;
    private Date birth;
    private String email;

    public UmUser() {
    }

    public UmUser(int userId, String userName, String password, String salt, String phone, String sex, String nickname, String address, Date birth, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.sex = sex;
        this.nickname = nickname;
        this.address = address;
        this.birth = birth;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
