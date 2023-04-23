package com.praneeth.RecruitmentApp.serviceImpl;

import com.praneeth.RecruitmentApp.DBUtil.DBUtil;
import com.praneeth.RecruitmentApp.model.ApplicationPath;
import com.praneeth.RecruitmentApp.model.JobPost;
import com.praneeth.RecruitmentApp.model.SpecificPost;
import com.praneeth.RecruitmentApp.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Qualifier("JobPostService")
public class JobPostServiceImpl implements JobPostService {


    Connection connection;
    public JobPostServiceImpl() throws SQLException{
        connection = DBUtil.getConnection();
    }


    public List<JobPost> fetchAllJobPosts(){
        List<JobPost> jp = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement("select j.id,j.job_role,r.ucompany,j.upload_date,r.uname,j.anAbstract,j.job_req,j.total_applicant,j.location from jobpost as j join recruiter as r on r.uid=j.posted_by;");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                JobPost p = new JobPost();
                p.setId(rs.getInt(1));
                p.setJob_role(rs.getString(2));
                p.setCompany(rs.getString(3));
                p.setUpload_date(rs.getString(4));
                p.setUname(rs.getString(5));
                p.setAbstract(rs.getString(6));
                p.setJob_req(rs.getString(7));
                p.setTotal_applicant(rs.getInt(8));
                p.setLocation(rs.getString(9));

                jp.add(p);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return jp;
    }

    public List<JobPost> fetchAllJobPostsWithUid(int uid){
        List<JobPost> jp = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement("select j.id,j.job_role,r.ucompany,j.upload_date,r.uname,j.anAbstract,j.job_req,j.total_applicant,j.location from jobpost as j join recruiter as r on r.uid=j.posted_by where j.posted_by = ?;");
            stmt.setInt(1,uid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                JobPost p = new JobPost();
                p.setId(rs.getInt(1));
                p.setJob_role(rs.getString(2));
                p.setCompany(rs.getString(3));
                p.setUpload_date(rs.getString(4));
                p.setUname(rs.getString(5));
                p.setAbstract(rs.getString(6));
                p.setJob_req(rs.getString(7));
                p.setTotal_applicant(rs.getInt(8));
                p.setLocation(rs.getString(9));

                jp.add(p);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return jp;
    }

    public SpecificPost fetchPostByPid(int pid){
        SpecificPost sp = new SpecificPost();
        try{
            PreparedStatement stmt = connection.prepareStatement("select j.id,j.job_role,r.ucompany,j.upload_date,r.uname,j.anAbstract,j.job_req,j.total_applicant,j.location from jobpost as j join recruiter as r on r.uid=j.posted_by where j.id = ?;");
            stmt.setInt(1,pid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                sp.setId(rs.getInt(1));
                sp.setJob_role(rs.getString(2));
                sp.setCompany(rs.getString(3));
                sp.setUpload_date(rs.getString(4));
                sp.setUname(rs.getString(5));
                sp.setAbstract(rs.getString(6));
                sp.setJob_req(rs.getString(7));
                sp.setTotal_applicant(rs.getInt(8));
                sp.setLocation(rs.getString(9));

            }
            List<ApplicationPath> ap = new ArrayList<>();
            PreparedStatement stmt1 = connection.prepareStatement("with temp(id,pid,resume,uid,status,uname) as (select a.id,a.pid,a.resume,a.uid,a.status,u.uname from submittedResume as a join applicant as u on a.uid=u.uid) select s.id,s.pid,u.path,s.uid,s.status,s.uname from temp as s join userresume as u on s.resume=u.id where s.pid = ?;");
            stmt1.setInt(1,pid);
            ResultSet rs1 = stmt1.executeQuery();
            while(rs1.next()){
                ApplicationPath temp = new ApplicationPath();
                temp.id = rs1.getInt(1);
                temp.pid = rs1.getInt(2);
                temp.path = rs1.getString(3);
                temp.uid = rs1.getInt(4);
                temp.status = rs1.getInt(5);
                temp.uname = rs1.getString(6);
                ap.add(temp);
            }
            sp.applications = ap;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sp;
    }

    public boolean deletePostById(int pid){
        try{
            PreparedStatement del1 = connection.prepareStatement("delete from submittedResume where pid = ?;");
            del1.setInt(1,pid);
            del1.executeUpdate();

            PreparedStatement del2 = connection.prepareStatement("delete from jobpost where id = ?;");
            del2.setInt(1,pid);
            del2.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean selectOrReject(int id, int status){
        try {
            PreparedStatement stmt = connection.prepareStatement("update submittedResume set status = ? where id = ?;");
            stmt.setInt(1,status);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean uploadJobPost(String job_role, String upload_date, int uid, String absrct, String job_req, String loc){
        try{
            PreparedStatement stmt = connection.prepareStatement("insert into jobpost(job_role,upload_date,posted_by,anAbstract,job_req,location) values(?,?,?,?,?,?);");
            stmt.setString(1,job_role);
            stmt.setString(2, upload_date);
            stmt.setInt(3,uid);
            stmt.setString(4,absrct);
            stmt.setString(5,job_req);
            stmt.setString(6,loc);
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
