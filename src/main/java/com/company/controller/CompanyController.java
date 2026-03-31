package com.company.controller;

import com.company.model.dto.CompanyDTO;
import com.company.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    public CompanyService cmpService;

    @GetMapping("/getAllCompanies")
    public List<CompanyDTO> getAllCompanies(){
        return cmpService.getAllCompanies();
    }

    @GetMapping("/getCmpById/{cmpId}")
    public CompanyDTO getCompanyById(@PathVariable long cmpId) {
        return cmpService.getCompanyById(cmpId);
    }
}
