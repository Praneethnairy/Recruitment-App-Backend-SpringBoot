package com.praneeth.RecruitmentApp.controller;

import com.praneeth.RecruitmentApp.model.JobPost;

import java.util.List;
//Builder class for temporary classes
public class MyBuilder {
    static class SignInReq{
        public String email;
        public String password;

        public SignInReq() {
            super();
        }

        public SignInReq(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }

    static class UpdateProfile{
        public int utype;
        public String uname;
        public String uemail;
        public String uabout;
        public List<String> uskills;

        public UpdateProfile() {
            super();
        }

        public UpdateProfile(int utype, String uname, String uemail, String uabout, List<String> uskills) {
            this.utype = utype;
            this.uname = uname;
            this.uemail = uemail;
            this.uabout = uabout;
            this.uskills = uskills;
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

        public String getUabout() {
            return uabout;
        }

        public void setUabout(String uabout) {
            this.uabout = uabout;
        }

        public List<String> getUskills() {
            return uskills;
        }

        public void setUskills(List<String> uskills) {
            this.uskills = uskills;
        }
    }

    static class ResumeAddStruct{
        public int uid;
        public String path;
    }

    static class ApplyJob{
        public int pid;
        public int uid;
    }

    static class UserId{
        public int uid;
    }


    static class jobPostHandler{
        public String job_role;
        public int posted_by;
        public String upload_date;
        public String anAbstract;
        public String job_req;
        public String location;
    }
}
