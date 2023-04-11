package com.praneeth.RecruitmentApp.serviceImpl;


import com.praneeth.RecruitmentApp.DBUtil.DBUtil;
import com.praneeth.RecruitmentApp.service.RecruiterService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class RecruiterServiceImpl implements RecruiterService {
    Connection connection;

    public RecruiterServiceImpl() throws SQLException {
        connection = DBUtil.getConnection();
    }

    @Override
    public boolean setRecruiter(String name,String email,String password,String contact,String company){
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into recruiter(uname,uemail,upassword,ucontact,ucompany) values(?,?,?,?,?);");
            stmt.setString(1,name);
            stmt.setString(2,email);
            stmt.setString(3,password);
            stmt.setString(4,contact);
            stmt.setString(5,company);

            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
//            e.printStackTrace();
            return false;
        }
//        return false;


    }
    public int getRecruiterId(String uemail,String uname){
        try{
            PreparedStatement stmt = connection.prepareStatement("select uid from recruiter where uname = ? and uemail = ?");
            stmt.setString(1,uname);
            stmt.setString(2,uemail);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return -1;
    }
}
