package com.praneeth.RecruitmentApp.controller;

import com.praneeth.RecruitmentApp.model.Applicant;
import com.praneeth.RecruitmentApp.model.Recruiter;
import com.praneeth.RecruitmentApp.service.ApplicantService;
import com.praneeth.RecruitmentApp.service.JobPostService;
import com.praneeth.RecruitmentApp.service.RecruiterService;
import com.praneeth.RecruitmentApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

//Follows Single Responsibility Principle - Only does SignUp for users
@RestController
@CrossOrigin
@RequestMapping("/signUp")
public class SignUpController {
    @Qualifier("AplService")
    @Autowired
    private ApplicantService aplservice;

    @Qualifier("UsrService")
    @Autowired
    private UserService usrservice;

    @Qualifier("RecrtService")
    @Autowired
    private RecruiterService rcrtservice;


    @PostMapping("/applicant")
    public boolean signUpApl(@RequestBody Applicant a){
//        System.out.println(a.getUname());

        boolean res1 = this.usrservice.setUser(1,a.getUname(),a.getUemail(),a.getUpassword());

        boolean res2 = this.aplservice.setApplicant(a.getUname(),a.getUemail(),a.getUpassword(),a.getUcontact());


        return res1 & res2;
    }

    @PostMapping("/recruiter")
    public boolean signUpRec(@RequestBody Recruiter r){
//        System.out.println(r.getUname());
        boolean res1 = this.usrservice.setUser(0,r.getUname(),r.getUemail(),r.getUpassword());
        boolean res2 = this.rcrtservice.setRecruiter(r.getUname(),r.getUemail(),r.getUpassword(),r.getUcontact(),r.getUcompany());
        return res1 & res2;
    }
}
