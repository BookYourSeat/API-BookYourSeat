package bookyourseat.api.Controller;

import Company.Service.ICompanyService;

public class CompanyController {
    private ICompanyService companyService;

    public CompanyController(ICompanyService companyService){
        this.companyService = companyService;
    }
}
