package com.praneeth.RecruitmentApp.service;

import com.praneeth.RecruitmentApp.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantService {
//    public List<Applicant> getApplicantData();
    public boolean setApplicant(String name,String email,String password,String contact);
    public int getApplicantId(String uemail,String uname);

    public List<String> fetchAllSkills();

    public ProfileDetails updateApplicantSkill(SkillUpdateRequest us);

    public void updateResumePath(int uid,String path);

    public boolean applyJob(int pid,int uid);

    public boolean checkAppliedJob(int pid,int uid);

    public List<ActiveApplication> getAllApplied(int uid);

    public boolean withdraw(int pid);
}
