package com.praneeth.RecruitmentApp.model;

public class User {
    private int uid;
    private int utype;
    private String uname;
    private String uemail;
    private String upassword;

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public int getUid() {
        return uid;
    }
    public User() {
        super();
    }

    public User(int utype, String uname, String uemail,String upassword) {

        this.utype = utype;
        this.uname = uname;
        this.uemail = uemail;
        this.upassword = upassword;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUtype() {
        return utype;
    }

    public void setUtype(int utype) {
        this.utype = utype;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }


}
