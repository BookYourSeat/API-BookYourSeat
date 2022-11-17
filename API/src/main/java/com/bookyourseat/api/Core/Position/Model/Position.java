package com.bookyourseat.api.Core.Position.Model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Position {
    private UUID Id;
    private Float Longitude;
    private Float Latitude;
    private Float Radius;

    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @JsonProperty("Longitude")
    public Float getLongitude() {
        return Longitude;
    }

    public void setLongitude(Float longitude) {
        Longitude = longitude;
    }

    @JsonProperty("Latitude")
    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        Latitude = latitude;
    }

    @JsonProperty("Radius")
    public Float getRadius() {
        return Radius;
    }

    public void setRadius(Float radius) {
        Radius = radius;
    }
}
