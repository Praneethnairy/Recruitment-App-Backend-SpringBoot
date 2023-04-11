package com.praneeth.RecruitmentApp.model;

//import java.time.LocalDate;
import javax.naming.Name;
import java.util.Date;

public class JobPost {
    private int id;
    private String job_role;
    private String company;
    private Date upload_date;
    private String uname;
    private String Abstract;
    private String job_req;
    private int total_applicant;
    private String location;

    public JobPost() {
        super();
    }

    public JobPost(String job_role, String company, Date upload_date, String uname, String anAbstract, String job_req, int total_applicant,String location) {
        this.job_role = job_role;
        this.company = company;
        this.upload_date = upload_date;
        this.uname = uname;
        Abstract = anAbstract;
        this.job_req = job_req;
        this.total_applicant = total_applicant;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(Date upload_date) {
        this.upload_date = upload_date;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getJob_req() {
        return job_req;
    }

    public void setJob_req(String job_req) {
        this.job_req = job_req;
    }

    public int getTotal_applicant() {
        return total_applicant;
    }

    public void setTotal_applicant(int total_applicant) {
        this.total_applicant = total_applicant;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
