package com.praneeth.RecruitmentApp.controller;

import com.praneeth.RecruitmentApp.Exceptions.MyExceptionHandlerPrevRoute;
import com.praneeth.RecruitmentApp.model.*;
import com.praneeth.RecruitmentApp.service.ApplicantService;
import com.praneeth.RecruitmentApp.service.JobPostService;
import com.praneeth.RecruitmentApp.service.RecruiterService;
import com.praneeth.RecruitmentApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
class SignInReq{
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

@RestController
@CrossOrigin
public class Controller {


    @Autowired
    private ApplicantService aplservice;
    @Autowired
    private UserService usrservice;

    @Autowired
    private RecruiterService rcrtservice;

    @Autowired
    private JobPostService jpservice;


    @PostMapping(value = "/signIn")
    public List<User> signIn(@RequestBody SignInReq s,Model m){
//        System.out.println(s.email);
        return this.usrservice.checkUser(s.email,s.password);
    }

    @PostMapping("/signUp/applicant")
    public boolean signUpApl(@RequestBody Applicant a){
//        System.out.println(a.getUname());

        boolean res1 = this.usrservice.setUser(1,a.getUname(),a.getUemail(),a.getUpassword());

        boolean res2 = this.aplservice.setApplicant(a.getUname(),a.getUemail(),a.getUpassword(),a.getUcontact());


        return res1 & res2;
    }

    @PostMapping("/signUp/recruiter")
    public boolean signUpRec(@RequestBody Recruiter r){
//        System.out.println(r.getUname());
        boolean res1 = this.usrservice.setUser(0,r.getUname(),r.getUemail(),r.getUpassword());
        boolean res2 = this.rcrtservice.setRecruiter(r.getUname(),r.getUemail(),r.getUpassword(),r.getUcontact(),r.getUcompany());
        return res1 & res2;
    }

    @GetMapping("/searchResults")
    public List<JobPost> jobPost(){
        return this.jpservice.fetchAllJobPosts();
    }

    @PostMapping("/fetchApplicantId")
    public int getApplicantId(@RequestBody User r){
        return this.aplservice.getApplicantId(r.getUemail(),r.getUname());
    }

    @PostMapping("/fetchRecruiterId")
    public int getRecruiterId(@RequestBody User r){
        return this.rcrtservice.getRecruiterId(r.getUemail(),r.getUname());
    }

    @PostMapping("/getProfileData")
    public ProfileDetails user_profile(@RequestBody User u){
        return this.usrservice.fetchProfileDetails(u.getUemail(),u.getUname(),u.getUtype());
    }
}
