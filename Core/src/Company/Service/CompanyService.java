package Company.Service;

import Company.Model.Company;
import Company.Repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class CompanyService implements ICompanyService{

    @Autowired
    private ICompanyRepository companyRepository;

    public Company GetById(UUID id) {
        return null;
    }

    public List<Company> GetAll() {
        return null;
    }

    public boolean Post(Company company) {
        return false;
    }

    public boolean Put(Company company) {
        return false;
    }

    public boolean Delete(UUID id) {
        return false;
    }
}
