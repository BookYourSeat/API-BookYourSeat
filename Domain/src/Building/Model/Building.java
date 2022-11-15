package Building.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="Building")
public class Building {
    @Id
    private UUID BuildingId;
    private UUID idCompany;
    private String Description;

    public UUID getBuildingId() {
        return BuildingId;
    }

    public void setBuildingId(UUID buildingId) {
        BuildingId = buildingId;
    }

    public UUID getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(UUID idCompany) {
        this.idCompany = idCompany;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
