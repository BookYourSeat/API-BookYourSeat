package com.bookyourseat.api.Core.Company.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Building.Model.Building;
import com.bookyourseat.api.Core.Building.Service.BuildingService;
import com.bookyourseat.api.Core.Company.Model.Company;
import com.bookyourseat.api.Core.Company.Repository.CompanyRepository;

@Component
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BuildingService buildingService;
    
    public ResponseEntity<List<Company>> GetAll() {
        try {
            List<Company> companies = companyRepository.GetAll();
            return new ResponseEntity<List<Company>>(companies,HttpStatus.OK);
        }
        catch(SQLException e) {
            return new ResponseEntity<List<Company>>(HttpStatus.BAD_REQUEST);
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

    public ResponseEntity<Company> Delete(UUID id) {
        try {
            if(!ValidateCompanyExists(id))
                return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
            if(!ValidateNoBuildings(id))
                return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
            Company company = companyRepository.Delete(id);
            return new ResponseEntity<Company>(company,HttpStatus.OK);
        }
        catch(SQLException e) {
            return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
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

    private Boolean ValidateNoBuildings(UUID id){
        List<Building> buildings = buildingService.GetByCompanyId(id);
        if(buildings.isEmpty())
            return true;
        return false;
    }
}
