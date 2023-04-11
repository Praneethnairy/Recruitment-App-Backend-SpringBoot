package com.praneeth.RecruitmentApp.serviceImpl;

import com.praneeth.RecruitmentApp.DBUtil.DBUtil;
import com.praneeth.RecruitmentApp.model.JobPost;
import com.praneeth.RecruitmentApp.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostServiceImpl implements JobPostService {


    Connection connection;
    public JobPostServiceImpl() throws SQLException{
        connection = DBUtil.getConnection();
    }


    public List<JobPost> fetchAllJobPosts(){
        List<JobPost> jp = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement("select j.id,j.job_role,r.ucompany,j.upload_date,r.uname,j.abstract,j.job_req,j.total_applicant,j.location from jobpost as j join recruiter as r on r.uid=j.posted_by;");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                JobPost p = new JobPost();
                p.setId(rs.getInt(1));
                p.setJob_role(rs.getString(2));
                p.setCompany(rs.getString(3));
                p.setUpload_date(rs.getDate(4));
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
}
