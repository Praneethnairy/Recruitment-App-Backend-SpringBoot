package com.praneeth.RecruitmentApp.model;

public class Applicant extends User{


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

    public String getUcontact() {
        return ucontact;
    }

    public void setUcontact(String ucontact) {
        this.ucontact = ucontact;
    }


}
