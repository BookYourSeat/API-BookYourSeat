package Room.Service;

import Room.Model.Room;
import Room.Repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class RoomService implements IRoomService {

    @Autowired
    private IRoomRepository roomRepository;

    public Room GetById(UUID id) {
        return null;
    }

    public List<Room> GetAll() {
        return null;
    }

    public boolean Post(Room room) {
        return false;
    }

    public boolean Put(Room room) {
        return false;
    }

    public boolean Delete(UUID id) {
        return false;
    }
}