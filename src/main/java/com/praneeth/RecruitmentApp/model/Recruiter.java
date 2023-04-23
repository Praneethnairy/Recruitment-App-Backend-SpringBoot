package com.praneeth.RecruitmentApp.model;

public class Recruiter extends User{
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
