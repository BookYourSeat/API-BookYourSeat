package com.bookyourseat.api.Core.Seat.Model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seat {
    private UUID Id;
    private UUID IdType;
    private UUID IdRoom;
    private UUID IdPosition;
    
    @JsonProperty("Id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @JsonProperty("IdType")
    public UUID getIdType() {
        return IdType;
    }

    public void setIdType(UUID idType) {
        IdType = idType;
    }

    @JsonProperty("IdRoom")
    public UUID getIdRoom() {
        return IdRoom;
    }

    public void setIdRoom(UUID idRoom) {
        IdRoom = idRoom;
    }

    @JsonProperty("IdPosition")
    public UUID getIdPosition() {
        return IdPosition;
    }

    public void setIdPosition(UUID idPosition) {
        IdPosition = idPosition;
    }
}
