package com.bookyourseat.api.Core.Position.Model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Position {
    private UUID Id;
    private Float TopLongitude;
    private Float TopLatitude;
    private Float BottomLongitude;
    private Float BottomLatitude;

    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @JsonProperty("TopLongitude")
    public Float getTopLongitude() {
        return TopLongitude;
    }

    public void setTopLongitude(Float topLongitude) {
        TopLongitude = topLongitude;
    }

    @JsonProperty("TopLatitude")
    public Float getTopLatitude() {
        return TopLatitude;
    }

    public void setTopLatitude(Float topLatitude) {
        TopLatitude = topLatitude;
    }

    @JsonProperty("BottomLongitude")
    public Float getBottomLongitude() {
        return BottomLongitude;
    }

    public void setBottomLongitude(Float bottomLongitude) {
        BottomLongitude = bottomLongitude;
    }

    @JsonProperty("BottomLatitude")
    public Float getBottomLatitude() {
        return BottomLatitude;
    }

    public void setBottomLatitude(Float bottomLatitude) {
        BottomLatitude = bottomLatitude;
    }
}
