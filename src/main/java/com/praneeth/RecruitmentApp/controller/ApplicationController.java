package com.praneeth.RecruitmentApp.controller;

import com.praneeth.RecruitmentApp.model.JobPost;
import com.praneeth.RecruitmentApp.model.SpecificPost;
import com.praneeth.RecruitmentApp.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/application")
public class ApplicationController {
    @Qualifier("JobPostService")
    @Autowired
    private JobPostService jpservice;

    @PostMapping("/fetchPost")
    public List<JobPost> fetchPost(@RequestBody MyBuilder.UserId ui){
        return this.jpservice.fetchAllJobPostsWithUid(ui.uid);
    }

    @PostMapping("/Post")
    public SpecificPost getPostDetails(@RequestBody MyBuilder.UserId ui){
        return this.jpservice.fetchPostByPid(ui.uid);
    }

    @PostMapping("/delPost")
    public boolean delPost(@RequestBody MyBuilder.UserId ui){
        return this.jpservice.deletePostById(ui.uid);
    }

    @PostMapping("/selectClicked")
    public boolean selectClicked(@RequestBody MyBuilder.UserId ui){
        return this.jpservice.selectOrReject(ui.uid,2);
    }
    @PostMapping("/rejectClicked")
    public boolean rejectClicked(@RequestBody MyBuilder.UserId ui){
        return this.jpservice.selectOrReject(ui.uid,1);
    }

    @PostMapping("/UploadPost")
    public boolean UploadPost(@RequestBody MyBuilder.jobPostHandler jp){
//        System.out.println(jp.getAbstract());
        return this.jpservice.uploadJobPost(jp.job_role,jp.upload_date,jp.posted_by,jp.anAbstract,jp.job_req,jp.location);
    }
}
