package com.praneeth.RecruitmentApp.serviceImpl;

import com.praneeth.RecruitmentApp.DBUtil.DBUtil;
import com.praneeth.RecruitmentApp.model.Applicant;
import com.praneeth.RecruitmentApp.model.ProfileDetails;
import com.praneeth.RecruitmentApp.model.SkillUpdateRequest;
import com.praneeth.RecruitmentApp.model.userSkills;
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

    public List<String> fetchAllSkills(){
        List<String> res= new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement("select skillName from skill;");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                res.add(rs.getString(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
//Error
    public ProfileDetails updateApplicantSkill(SkillUpdateRequest us){
        ProfileDetails p = new ProfileDetails();
        for(int i = 0;i<us.skills.size();++i){
            try{
                PreparedStatement stmt = connection.prepareStatement("select sid from skill where skillName=?;");
                stmt.setString(1, us.skills.get(i).label);
                ResultSet rs = stmt.executeQuery();
                int id = -1;
                while(rs.next()){
                    id = rs.getInt(1);
                }
                PreparedStatement stmt1 = connection.prepareStatement("insert into applicant_skill(sid,uid) values (?,?);");
                stmt1.setInt(1,id);
                stmt1.setInt(2,us.uid);
                stmt1.executeUpdate();

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        try{
            PreparedStatement stmt1 = connection.prepareStatement("select uid,uname,uemail,uabout from applicant where uid = ?;");
            stmt1.setInt(1,us.uid);
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
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

}
