package com.praneeth.RecruitmentApp.model;

import java.util.List;

public class ProfileDetails {
    private int uid;
    private String uname;
    private String uemail;
    private String uAbout;
    private List<String> uskills;
    private String ucompany;

    public ProfileDetails() {
        super();
    }

    public ProfileDetails(int uid, String uname, String uemail, String uAbout, List<String> uskills, String ucompany) {
        this.uid = uid;
        this.uname = uname;
        this.uemail = uemail;
        this.uAbout = uAbout;
        this.uskills = uskills;
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

    public String getuAbout() {
        return uAbout;
    }

    public void setuAbout(String uAbout) {
        this.uAbout = uAbout;
    }

    public List<String> getUskills() {
        return uskills;
    }

    public void setUskills(List<String> uskills) {
        this.uskills = uskills;
    }

    public String getUcompany() {
        return ucompany;
    }

    public void setUcompany(String ucompany) {
        this.ucompany = ucompany;
    }
}
