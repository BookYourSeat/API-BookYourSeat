package com.bookyourseat.api.Core.Company.Model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {
    private UUID Id;
    private String Description;

    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
