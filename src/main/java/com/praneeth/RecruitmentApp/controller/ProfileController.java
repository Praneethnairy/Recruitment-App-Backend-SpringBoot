package com.praneeth.RecruitmentApp.controller;

import com.praneeth.RecruitmentApp.model.ProfileDetails;
import com.praneeth.RecruitmentApp.model.SkillUpdateRequest;
import com.praneeth.RecruitmentApp.model.User;
import com.praneeth.RecruitmentApp.service.ApplicantService;
import com.praneeth.RecruitmentApp.service.JobPostService;
import com.praneeth.RecruitmentApp.service.RecruiterService;
import com.praneeth.RecruitmentApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/profile")
public class ProfileController {

    @Qualifier("AplService")
    @Autowired
    private ApplicantService aplservice;

    @Qualifier("UsrService")
    @Autowired
    private UserService usrservice;

    @Qualifier("RecrtService")
    @Autowired
    private RecruiterService rcrtservice;


    @PostMapping("/getProfileData")
    public ProfileDetails user_profile(@RequestBody User u){
        return this.usrservice.fetchProfileDetails(u.getUemail(),u.getUname(),u.getUtype());
    }

    @PostMapping("/updateUserAbout")
    public ProfileDetails user_about_update(@RequestBody MyBuilder.UpdateProfile up){
        return this.usrservice.updateAbout(up.uemail,up.uname,up.utype,up.uabout);
    }

    @GetMapping("/fetchAllSkills")
    public List<String> fetchSkills(){
        return this.aplservice.fetchAllSkills();
    }

    @PostMapping("/updateSkill")
    public ProfileDetails user_skill_update(@RequestBody SkillUpdateRequest us){
        return this.aplservice.updateApplicantSkill(us);
    }

    @PostMapping("/resumePath")
    public boolean update_resume_path(@RequestBody MyBuilder.ResumeAddStruct ras){
        this.aplservice.updateResumePath(ras.uid, ras.path);
        return true;
    }
}
