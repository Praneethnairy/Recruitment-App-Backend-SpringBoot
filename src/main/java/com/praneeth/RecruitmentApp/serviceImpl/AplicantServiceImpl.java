package com.praneeth.RecruitmentApp.serviceImpl;

import com.praneeth.RecruitmentApp.DBUtil.DBUtil;
import com.praneeth.RecruitmentApp.model.Applicant;
import com.praneeth.RecruitmentApp.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AplicantServiceImpl implements ApplicantService {

    Connection connection;
    public AplicantServiceImpl() throws SQLException {
        connection = DBUtil.getConnection();
    }
    @Override
    public boolean setApplicant(String name,String email,String password,String contact){
        try
        {
            PreparedStatement stmt = connection.prepareStatement("insert into applicant(uname,uemail,upassword,ucontact) values(?,?,?,?);");
            stmt.setString(1,name);
            stmt.setString(2,email);
            stmt.setString(3,password);
            stmt.setString(4,contact);
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
//            e.printStackTrace();
            return false;
        }
    }

    public int getApplicantId(String uemail,String uname){
        try{
            PreparedStatement stmt = connection.prepareStatement("select uid from applicant where uname = ? and uemail = ?");
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
