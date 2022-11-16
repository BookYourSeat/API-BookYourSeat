package com.bookyourseat.api.Core.Seat.Model;

import java.util.UUID;

public class Seat {
    private UUID Id;
    private UUID IdType;
    private UUID IdRoom;
    private UUID IdPosition;
    
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public UUID getIdType() {
        return IdType;
    }

    public void setIdType(UUID idType) {
        IdType = idType;
    }

    public UUID getIdRoom() {
        return IdRoom;
    }

    public void setIdRoom(UUID idRoom) {
        IdRoom = idRoom;
    }

    public UUID getIdPosition() {
        return IdPosition;
    }

    public void setIdPosition(UUID idPosition) {
        IdPosition = idPosition;
    }
}
