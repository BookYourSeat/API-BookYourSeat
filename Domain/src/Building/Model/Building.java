package Building.Model;

import java.util.UUID;

public class Building {

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
