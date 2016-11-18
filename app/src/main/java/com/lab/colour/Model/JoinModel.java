package com.lab.colour.Model;

import java.util.Date;

/**
 * Created by SeoHyeonBae on 2016-11-18.
 */

//회원가입 모델
public class JoinModel {

    private String id;
    private String pw;
    private String sex;
    private Date birthday;
    private String residentRagion;
    private String preferRagion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getResidentRagion() {
        return residentRagion;
    }

    public void setResidentRagion(String residentRagion) {
        this.residentRagion = residentRagion;
    }

    public String getPreferRagion() {
        return preferRagion;
    }

    public void setPreferRagion(String preferRagion) {
        this.preferRagion = preferRagion;
    }
}
