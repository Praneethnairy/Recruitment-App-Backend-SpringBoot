package com.praneeth.RecruitmentApp.model;

public class Applicant {

    private int uid;
    private String uname;
    private String uemail;

    private String upassword;
    private String ucontact;

    public Applicant() {
        super();
    }

    public Applicant( String uname, String uemail, String upassword, String ucontact) {

        this.uname = uname;
        this.uemail = uemail;
        this.upassword = upassword;
        this.ucontact = ucontact;
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


}
