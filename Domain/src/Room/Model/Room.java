package Room.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="Room")
public class Room {
    @Id
    private UUID RoomId;
    private UUID idBuilding;
    private String Description;
    private String Map;

    public UUID getRoomId() {
        return RoomId;
    }

    public void setRoomId(UUID roomId) {
        RoomId = roomId;
    }

    public UUID getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(UUID isBuilding) {
        this.idBuilding = isBuilding;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMap() {
        return Map;
    }

    public void setMap(String map) {
        Map = map;
    }
}
