package com.praneeth.RecruitmentApp.service;

import com.praneeth.RecruitmentApp.model.Applicant;
import com.praneeth.RecruitmentApp.model.ProfileDetails;
import com.praneeth.RecruitmentApp.model.SkillUpdateRequest;
import org.springframework.stereotype.Repository;
import com.praneeth.RecruitmentApp.model.userSkills;
import java.util.List;

@Repository
public interface ApplicantService {
//    public List<Applicant> getApplicantData();
    public boolean setApplicant(String name,String email,String password,String contact);
    public int getApplicantId(String uemail,String uname);

    public List<String> fetchAllSkills();

    public ProfileDetails updateApplicantSkill(SkillUpdateRequest us);
}
