package com.praneeth.RecruitmentApp.model;

//import java.time.LocalDate;
import javax.naming.Name;
import java.util.Date;

public class JobPost {
    protected int id;
    protected String job_role;
    protected String company;
    protected String upload_date;
    protected String uname;
    protected int posted_by;
    protected String anAbstract;
    protected String job_req;
    protected int total_applicant;
    protected String location;

    public JobPost(String job_role, int posted_by, String upload_date, String anAbstract, String job_req, String location) {
        this.job_role = job_role;
        this.upload_date = upload_date;
        this.posted_by = posted_by;
        this.anAbstract = anAbstract;
        this.job_req = job_req;
        this.location = location;
    }

    public JobPost() {
        super();
    }

    public JobPost(String job_role, String company, String upload_date, String uname, String anAbstract, String job_req, int total_applicant,String location) {
        this.job_role = job_role;
        this.company = company;
        this.upload_date = upload_date;
        this.uname = uname;
        this.anAbstract = anAbstract;
        this.job_req = job_req;
        this.total_applicant = total_applicant;
        this.location = location;
    }

    public int getPosted_by() {
        return posted_by;
    }

    public void setPosted_by(int posted_by) {
        this.posted_by = posted_by;
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

    public String getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(String upload_date) {
        this.upload_date = upload_date;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAbstract() {
        return anAbstract;
    }

    public void setAbstract(String anAbstract) {
        this.anAbstract = anAbstract;
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
