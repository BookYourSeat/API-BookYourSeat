package SeatType.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="SeatType")
public class SeatType {
    @Id
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
