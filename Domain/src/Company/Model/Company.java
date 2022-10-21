package Company.Model;

import java.util.UUID;

public class Company {

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
