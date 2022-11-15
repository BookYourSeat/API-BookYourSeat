package bookyourseat.api.Controller;

import Company.Model.Company;
import Company.Service.ICompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Company")
public class CompanyController {
    private ICompanyService companyService;

    public CompanyController(ICompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping("/GetById")
    public Company GetUser(UUID Id) {
        Company newCompany = new Company();
        return newCompany;
    }

    @GetMapping("/GetAll")
    public List<Company> GetAll() {
        ArrayList companies = new ArrayList<Company>();
        return companies;
    }

    @PostMapping("/Post")
    public boolean Post(Company company) {
        return true;
    }

    @PutMapping("/Put")
    public boolean Put(Company company) {
        return true;
    }

    @DeleteMapping("/Delete")
    public boolean Delete(UUID id) {
        return true;
    }
}
