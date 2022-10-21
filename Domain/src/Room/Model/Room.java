package Room.Model;

import java.util.UUID;

public class Room {

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
