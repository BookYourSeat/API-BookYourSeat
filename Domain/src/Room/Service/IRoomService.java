package Room.Service;

import Room.Model.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface IRoomService {
    public Room GetById(UUID id);
    public List<Room> GetAll();
    public boolean Post(Room room);
    public boolean Put(Room room);
    public boolean Delete(UUID id);
}
