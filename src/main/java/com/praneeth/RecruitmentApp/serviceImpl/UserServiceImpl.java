package com.praneeth.RecruitmentApp.serviceImpl;

import com.praneeth.RecruitmentApp.DBUtil.DBUtil;
import com.praneeth.RecruitmentApp.model.ProfileDetails;
import com.praneeth.RecruitmentApp.model.User;
import com.praneeth.RecruitmentApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    static List<User> loginUser = new ArrayList<>();
    Connection connection;
    public UserServiceImpl() throws SQLException {
        connection = DBUtil.getConnection();
    }
    @Override
    public boolean setUser(int type, String name,String email,String password){
        try
        {
            PreparedStatement getStmt = connection.prepareStatement("select count(*) as cnt from user where uemail = ?");
            getStmt.setString(1,email);
            ResultSet rs = getStmt.executeQuery();
            int i = 0;
            while(rs.next()){
                i = rs.getInt(1);
            }
            if(i == 0){
                PreparedStatement stmt = connection.prepareStatement("insert into user(utype,uname,uemail,upassword) values(?,?,?,?);");
                stmt.setInt(1,type);
                stmt.setString(2,name);
                stmt.setString(3,email);
                stmt.setString(4,password);
                stmt.executeUpdate();
                return true;
            }


        }catch (SQLException e){
//            e.printStackTrace();
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    @Override
    public List<User> checkUser(String email,String password){
        List<User> loginUser = new ArrayList<>();
        try {
//            System.out.println(email);
            PreparedStatement stmt = connection.prepareStatement("select * from user where uemail=? and upassword=?");
            stmt.setString(1,email);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setUid(rs.getInt(1));
                u.setUtype(rs.getInt(2));
                u.setUname(rs.getString(3));
                u.setUemail(rs.getString(4));
                u.setUpassword(rs.getString(5));
                loginUser.add(u);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return loginUser;
    }

    public ProfileDetails fetchProfileDetails(String email, String name,int type){
        ProfileDetails p=  new ProfileDetails();
        try{
            if(type == 1){
                PreparedStatement stmt = connection.prepareStatement("select uid,uname,uemail,uabout from applicant where uname=? and uemail=?;");
                stmt.setString(1,name);
                stmt.setString(2,email);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    p.setUid(rs.getInt(1));
                    p.setUname(rs.getString(2));
                    p.setUemail(rs.getString(3));
                    p.setuAbout(rs.getString(4));
                }
                PreparedStatement skillStmt = connection.prepareStatement("with skillMap(uid,skillName) as (select a.uid,s.skillName from applicant_skill as a join skill as s on a.sid = s.sid) select sm.skillName from skillMap as sm join applicant as ap on sm.uid=ap.uid where ap.uid=?;");
                skillStmt.setInt(1,p.getUid());
                ResultSet skillResult = skillStmt.executeQuery();
                List<String> skills = new ArrayList<>();
                while(skillResult.next()){
                    skills.add(skillResult.getString(1));
                }
                p.setUskills(skills);
            }
            else{
                // TODO : Write code for Recruiter profile
                PreparedStatement stmt1 = connection.prepareStatement("select uid,uname,uemail,uabout,ucompany from recruiter where uname=? and uemail=?;");
                stmt1.setString(1,name);
                stmt1.setString(2,email);
                ResultSet rs = stmt1.executeQuery();
                while(rs.next()){
                    p.setUid(rs.getInt(1));
                    p.setUname(rs.getString(2));
                    p.setUemail(rs.getString(3));
                    p.setuAbout(rs.getString(4));
                    p.setUcompany(rs.getString(5));
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }
    public ProfileDetails updateAbout(String email,String name,int utype,String uabout){
        ProfileDetails p = new ProfileDetails();
        try{
            if(utype == 1){
                PreparedStatement stmt = connection.prepareStatement("update applicant set uabout=? where uname=? and uemail=?;");
                stmt.setString(1,uabout);
                stmt.setString(2,name);
                stmt.setString(3,email);
                stmt.executeUpdate();
                PreparedStatement stmt1 = connection.prepareStatement("select uid,uname,uemail,uabout from applicant where uname=? and uemail=?;");
                stmt1.setString(1,name);
                stmt1.setString(2,email);
                ResultSet rs = stmt1.executeQuery();
                while(rs.next()){
                    p.setUid(rs.getInt(1));
                    p.setUname(rs.getString(2));
                    p.setUemail(rs.getString(3));
                    p.setuAbout(rs.getString(4));
                }
                PreparedStatement skillStmt = connection.prepareStatement("with skillMap(uid,skillName) as (select a.uid,s.skillName from applicant_skill as a join skill as s on a.sid = s.sid) select sm.skillName from skillMap as sm join applicant as ap on sm.uid=ap.uid where ap.uid=?;");
                skillStmt.setInt(1,p.getUid());
                ResultSet skillResult = skillStmt.executeQuery();
                List<String> skills = new ArrayList<>();
                while(skillResult.next()){
                    skills.add(skillResult.getString(1));
                }
                p.setUskills(skills);
            }
            else{
                PreparedStatement stmt = connection.prepareStatement("update recruiter set uabout=? where uname=? and uemail=?;");
                stmt.setString(1,uabout);
                stmt.setString(2,name);
                stmt.setString(3,email);
                stmt.executeUpdate();
                PreparedStatement stmt1 = connection.prepareStatement("select uid,uname,uemail,uabout,ucompany from recruiter where uname=? and uemail=?;");
                stmt1.setString(1,name);
                stmt1.setString(2,email);
                ResultSet rs = stmt1.executeQuery();
                while(rs.next()){
                    p.setUid(rs.getInt(1));
                    p.setUname(rs.getString(2));
                    p.setUemail(rs.getString(3));
                    p.setuAbout(rs.getString(4));
                    p.setUcompany(rs.getString(5));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }
}
