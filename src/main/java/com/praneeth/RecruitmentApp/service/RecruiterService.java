package com.praneeth.RecruitmentApp.service;

import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterService {
    public boolean setRecruiter(String name,String email,String password,String contact,String company);
    public int getRecruiterId(String uemail,String uname);
}
