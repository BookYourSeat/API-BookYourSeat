package com.bookyourseat.api.Core.Room.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomBuildingDTO{
    private UUID Id;
    private UUID IdBuilding;
    private String Description;
    private String Map;

    private String BuildingDescription;

    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @JsonProperty("IdBuilding")
    public UUID getIdBuilding() {
        return IdBuilding;
    }

    public void setIdBuilding(UUID idBuilding) {
        IdBuilding = idBuilding;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @JsonProperty("Map")
    public String getMap() {
        return Map;
    }

    public void setMap(String map) {
        Map = map;
    }

    @JsonProperty("BuildingDescription")
    public String getBuildingDescription() {
        return BuildingDescription;
    }

    public void setBuildingDescription(String description) {
        BuildingDescription = description;
    }
}