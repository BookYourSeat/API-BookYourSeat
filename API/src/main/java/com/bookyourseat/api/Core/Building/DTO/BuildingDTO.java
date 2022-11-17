package com.bookyourseat.api.Core.Building.DTO;

import java.util.UUID;

import com.bookyourseat.api.Core.Building.Model.Building;
import com.bookyourseat.api.Core.Company.Model.Company;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingDTO {
    private UUID Id;
    private UUID IdCompany;
    private String Description;

    private String CompanyDescription;

    public BuildingDTO(){}

    public BuildingDTO(Building building, Company company){
        this.Id = building.getId();
        this.IdCompany = building.getIdCompany();
        this.Description = building.getDescription();
        this.CompanyDescription = company.getDescription();
    }

    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @JsonProperty("IdCompany")
    public UUID getIdCompany() {
        return IdCompany;
    }

    public void setIdCompany(UUID idCompany) {
        IdCompany = idCompany;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @JsonProperty("CompanyDescription")
    public String getCompanyDescription() {
        return CompanyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        CompanyDescription = companyDescription;
    }
}
