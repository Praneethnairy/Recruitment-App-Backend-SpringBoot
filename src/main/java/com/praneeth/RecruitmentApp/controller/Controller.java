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
//import com.praneeth.RecruitmentApp.model.userSkills;

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

class UpdateProfile{
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

    @PostMapping("/updateUserAbout")
    public ProfileDetails user_about_update(@RequestBody UpdateProfile up){
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
}
