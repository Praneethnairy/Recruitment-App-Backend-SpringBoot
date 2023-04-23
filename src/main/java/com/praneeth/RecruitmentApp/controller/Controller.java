package com.praneeth.RecruitmentApp.controller;

import com.praneeth.RecruitmentApp.model.*;
import com.praneeth.RecruitmentApp.service.ApplicantService;
import com.praneeth.RecruitmentApp.service.JobPostService;
import com.praneeth.RecruitmentApp.service.RecruiterService;
import com.praneeth.RecruitmentApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import com.praneeth.RecruitmentApp.model.userSkills;

import java.util.List;





@RestController
@CrossOrigin
public class Controller {

    @Qualifier("AplService")
    @Autowired
    private ApplicantService aplservice;

    @Qualifier("UsrService")
    @Autowired
    private UserService usrservice;

    @Qualifier("RecrtService")
    @Autowired
    private RecruiterService rcrtservice;

    @Qualifier("JobPostService")
    @Autowired
    private JobPostService jpservice;




    @PostMapping(value = "/signIn")
    public List<User> signIn(@RequestBody MyBuilder.SignInReq s,Model m){
//        System.out.println(s.email);
        return this.usrservice.checkUser(s.email,s.password);
    }

    @PostMapping("/fetchApplicantId")
    public int getApplicantId(@RequestBody User r){
        return this.aplservice.getApplicantId(r.getUemail(),r.getUname());
    }

    @PostMapping("/fetchRecruiterId")
    public int getRecruiterId(@RequestBody User r){
        return this.rcrtservice.getRecruiterId(r.getUemail(),r.getUname());
    }


}
