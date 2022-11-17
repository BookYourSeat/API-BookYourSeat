package com.bookyourseat.api.Core.Building.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingDTO {
    private UUID Id;
    private UUID IdCompany;
    private String Description;

    private String CompanyDescription;

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
