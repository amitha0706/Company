package com.company.service.impl;

import com.company.model.dto.CompanyDTO;
import com.company.model.entity.CompanyEntity;
import com.company.repository.CompanyRepository;
import com.company.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository cmpRepo;

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<CompanyEntity> companies = cmpRepo.findAll();
        List<CompanyDTO> companyDTOs = new ArrayList<>();

        for(CompanyEntity cmpEntity : companies){
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setId(cmpEntity.getId());
            companyDTO.setName(cmpEntity.getName());
            companyDTO.setBranch(cmpEntity.getBranch());

            companyDTOs.add(companyDTO);
        }
        return companyDTOs;
    }

    @Override
    public CompanyDTO getCompanyById(long cmpId) {
        Optional<CompanyEntity> cmpOpt = cmpRepo.findById(cmpId);
        CompanyEntity entity = cmpOpt.get();

        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(entity.getId());
        companyDTO.setName(entity.getName());
        companyDTO.setBranch(entity.getBranch());

        return companyDTO;
    }
}
