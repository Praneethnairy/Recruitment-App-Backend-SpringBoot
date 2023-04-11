package com.praneeth.RecruitmentApp.model;

public class Recruiter {
    private int uid;
    private String uname;
    private String uemail;

    private String upassword;
    private String ucontact;
    private String ucompany;

    public Recruiter() {
        super();
    }

    public Recruiter( String uname, String uemail, String upassword, String ucontact, String ucompany) {
        this.uname = uname;
        this.uemail = uemail;
        this.upassword = upassword;
        this.ucontact = ucontact;
        this.ucompany = ucompany;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUcontact() {
        return ucontact;
    }

    public void setUcontact(String ucontact) {
        this.ucontact = ucontact;
    }

    public String getUcompany() {
        return ucompany;
    }

    public void setUcompany(String ucompany) {
        this.ucompany = ucompany;
    }
}
