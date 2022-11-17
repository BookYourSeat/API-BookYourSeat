package com.bookyourseat.api.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyourseat.api.Core.Company.Model.Company;
import com.bookyourseat.api.Core.Company.Service.CompanyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> Get() {
        return companyService.GetAll();
    }

    @GetMapping("{id}")
    public Company GetById(@PathVariable UUID id) {
        return companyService.GetById(id);
    }

    @PostMapping
    public Company Post(@RequestBody Company newCompany){
        return companyService.Post(newCompany);
    }

    @PutMapping("{id}")
    public Company Put(@PathVariable UUID id, @RequestBody Company company){
        return companyService.Put(id, company);
    }

    @DeleteMapping("{id}")
    public Company Delete(@PathVariable UUID id){
        return companyService.Delete(id);
    }
}
