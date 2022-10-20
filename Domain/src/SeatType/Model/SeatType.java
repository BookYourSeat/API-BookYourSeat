package SeatType.Model;

import java.util.UUID;

public class SeatType {
    private UUID SeatTypeId;
    private String Description;

    public UUID getSeatTypeId() {
        return SeatTypeId;
    }

    public void setSeatTypeId(UUID seatTypeId) {
        SeatTypeId = seatTypeId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
