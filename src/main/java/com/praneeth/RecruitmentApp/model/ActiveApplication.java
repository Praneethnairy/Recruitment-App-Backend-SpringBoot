package com.praneeth.RecruitmentApp.model;

public class ActiveApplication {
    private int pid;
    private String jobTitle;
    private String company;
    private String status;

    public ActiveApplication() {
        super();
    }

    public ActiveApplication(int pid, String jobTitle, String company, String status) {
        this.pid = pid;
        this.jobTitle = jobTitle;
        this.company = company;
        this.status = status;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
