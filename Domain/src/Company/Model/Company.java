package Company.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="Company")
public class Company {
    @Id
    private UUID CompanyId;
    private String Description;

    public UUID getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(UUID companyId) {
        CompanyId = companyId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
