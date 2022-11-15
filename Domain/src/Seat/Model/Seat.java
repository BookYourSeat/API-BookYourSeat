package Seat.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="Seat")
public class Seat {
    @Id
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
