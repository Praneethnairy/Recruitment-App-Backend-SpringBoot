package com.praneeth.RecruitmentApp.service;

import com.praneeth.RecruitmentApp.DBUtil.DBUtil;
import com.praneeth.RecruitmentApp.model.ProfileDetails;
import com.praneeth.RecruitmentApp.model.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface UserService {
    public boolean setUser(int utype, String uname,String uemail,String password);
    public List<User> checkUser(String email,String password);

    public ProfileDetails fetchProfileDetails(String email,String name,int utype);

}
