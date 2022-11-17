package com.bookyourseat.api.Core.Company.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Company.Model.Company;
import com.bookyourseat.api.Core.Company.Repository.CompanyRepository;

@Component
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    
    public List<Company> GetAll() {
        try {
            return companyRepository.GetAll();
        }
        catch(SQLException e) {
            return new ArrayList<Company>();
        }
    }

    public Company GetById(UUID id) {
        try {
            return companyRepository.GetById(id);
        }
        catch(SQLException e) {
            return new Company();
        }
    }

    public Company Post(Company company) {
        try {
            if(!ValidateCompanyInfo(company))
                return new Company();
            return companyRepository.Post(company);
        }
        catch(SQLException e) {
            return new Company();
        }
    }

    public Company Put(UUID id, Company company) {
        try {
            if(!ValidateCompanyInfo(company))
                return new Company();
            if(!ValidateCompanyExists(id))
                return new Company();
            return companyRepository.Put(id, company);
        }
        catch(SQLException e) {
            return new Company();
        }
    }

    public Company Delete(UUID id) {
        try {
            if(!ValidateCompanyExists(id))
                return new Company();
            return companyRepository.Delete(id);
        }
        catch(SQLException e) {
            return new Company();
        }
    }

    private Boolean ValidateCompanyInfo(Company company){
        if(company.getDescription().isBlank())
            return false;
        return true;
    }

    private Boolean ValidateCompanyExists(UUID id){
        try{
            Company company = companyRepository.GetById(id);
            if(company.toString().isBlank())
                return false;
            return true;
        }
        catch(SQLException e) {
            return false;
        }      
    }
}
