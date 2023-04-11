package com.praneeth.RecruitmentApp.service;

import com.praneeth.RecruitmentApp.model.Applicant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantService {
//    public List<Applicant> getApplicantData();
    public boolean setApplicant(String name,String email,String password,String contact);
    public int getApplicantId(String uemail,String uname);
}
