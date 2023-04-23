package com.praneeth.RecruitmentApp.service;

import com.praneeth.RecruitmentApp.controller.MyBuilder;
import com.praneeth.RecruitmentApp.model.JobPost;
import com.praneeth.RecruitmentApp.model.SpecificPost;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JobPostService {
    public List<JobPost> fetchAllJobPosts();
    public List<JobPost> fetchAllJobPostsWithUid(int uid);

    public SpecificPost fetchPostByPid(int pid);

    public boolean deletePostById(int pid);

    public boolean selectOrReject(int id, int status);

    public boolean uploadJobPost(String job_role, String upload_date,int uid,String abs, String job_req,String loc);
}
