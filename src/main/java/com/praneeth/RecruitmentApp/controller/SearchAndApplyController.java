package com.praneeth.RecruitmentApp.controller;

import com.praneeth.RecruitmentApp.model.JobPost;
import com.praneeth.RecruitmentApp.service.ApplicantService;
import com.praneeth.RecruitmentApp.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchAndApplyController {

    @Qualifier("AplService")
    @Autowired
    private ApplicantService aplservice;

    @Qualifier("JobPostService")
    @Autowired
    private JobPostService jpservice;

    @GetMapping("/searchResults")
    public List<JobPost> jobPost(){
        return this.jpservice.fetchAllJobPosts();
    }

    @PostMapping("/applyJob")
    public boolean applyForJob(@RequestBody MyBuilder.ApplyJob aj){
         return this.aplservice.applyJob(aj.pid,aj.uid);
    }

    @PostMapping("/checkApplied")
    public boolean checkApplied(@RequestBody MyBuilder.ApplyJob aj){
        return this.aplservice.checkAppliedJob(aj.pid,aj.uid);
    }
}
