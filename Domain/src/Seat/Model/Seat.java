package Seat.Model;

import java.util.UUID;

public class Seat {
    private UUID SeatId;
    private UUID IdType;
    private UUID IdRoom;
    private UUID IdPosition;

    public UUID getSeatId() {
        return SeatId;
    }

    public void setSeatId(UUID seatId) {
        SeatId = seatId;
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
