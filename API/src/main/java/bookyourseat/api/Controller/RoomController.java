package bookyourseat.api.Controller;

import Room.Model.Room;
import Room.Service.IRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Room")
public class RoomController {
    private IRoomService roomService;

    public RoomController(IRoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping("/GetById")
    public Room GetUser(UUID Id) {
        Room newRoom = new Room();
        return newRoom;
    }

    @GetMapping("/GetAll")
    public List<Room> GetAll() {
        ArrayList rooms = new ArrayList<Room>();
        return rooms;
    }

    @PostMapping("/Post")
    public boolean Post(Room room) {
        return true;
    }

    @PutMapping("/Put")
    public boolean Put(Room room) {
        return true;
    }

    @DeleteMapping("/Delete")
    public boolean Delete(UUID id) {
        return true;
    }
}
