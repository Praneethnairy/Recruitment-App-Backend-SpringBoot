package com.praneeth.RecruitmentApp.controller;

import com.praneeth.RecruitmentApp.model.ActiveApplication;
import com.praneeth.RecruitmentApp.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/status")
public class JobStatusController {

    @Qualifier("AplService")
    @Autowired
    private ApplicantService aplservice;

    @PostMapping("/getAllActive")
    public List<ActiveApplication> getAllActive(@RequestBody MyBuilder.UserId ui){
        return this.aplservice.getAllApplied(ui.uid);
    }

    @PostMapping("/withdraw")
    public boolean withdrawApplication(@RequestBody MyBuilder.UserId ui){
        return this.aplservice.withdraw(ui.uid);
    }
}
