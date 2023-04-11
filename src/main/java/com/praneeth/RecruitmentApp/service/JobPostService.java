package com.praneeth.RecruitmentApp.service;

import com.praneeth.RecruitmentApp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostService {
    public List<JobPost> fetchAllJobPosts();
}
