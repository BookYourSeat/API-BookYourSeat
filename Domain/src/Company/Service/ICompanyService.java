package Company.Service;

import Company.Model.Company;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ICompanyService {
    public Company GetById(UUID id);
    public List<Company> GetAll();
    public boolean Post(Company company);
    public boolean Put(Company company);
    public boolean Delete(UUID id);
}
