package com.company.service;

import com.company.model.dto.CompanyDTO;

import java.util.List;

public interface ICompanyService {
    public List<CompanyDTO> getAllCompanies();
    public CompanyDTO getCompanyById(long cmpId);
}
