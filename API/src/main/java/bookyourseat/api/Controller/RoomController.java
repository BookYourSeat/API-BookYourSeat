package bookyourseat.api.Controller;

import Room.Service.IRoomService;

public class RoomController {
    private IRoomService roomService;

    public RoomController(IRoomService roomService){
        this.roomService = roomService;
    }
}
