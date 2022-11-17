package com.bookyourseat.api.Core.Room.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Room.DTO.RoomDTO;
import com.bookyourseat.api.Core.Room.Model.Room;
import com.bookyourseat.api.Core.Room.Repository.RoomRepository;

@Component
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    
    public List<Room> GetAll() {
        try {
            return roomRepository.GetAll();
        }
        catch(SQLException e) {
            return new ArrayList<Room>();
        }
    }

    public Room GetById(UUID id) {
        try {
            return roomRepository.GetById(id);
        }
        catch(SQLException e) {
            return new Room();
        }
    }

    public RoomDTO GetRoomDTO(UUID id) {
        /*
        try {
            return roomRepository.GetRoomDTO(id);
        }
        catch(SQLException e) {
            return new RoomDTO();
        }
        */
        return new RoomDTO();
    }

    public Room Post(Room room) {
        try {
            if(!ValidateRoomInfo(room))
                return new Room();
            return roomRepository.Post(room);
        }
        catch(SQLException e) {
            return new Room();
        }
    }

    public Room Put(UUID id, Room room) {
        try {
            if(!ValidateRoomInfo(room))
                return new Room();
            if(!ValidateRoomExists(id))
                return new Room();
            return roomRepository.Put(id, room);
        }
        catch(SQLException e) {
            return new Room();
        }
    }

    public Room Delete(UUID id) {
        try {
            if(!ValidateRoomExists(id))
                return new Room();
            return roomRepository.Delete(id);
        }
        catch(SQLException e) {
            return new Room();
        }
    }

    private Boolean ValidateRoomInfo(Room room){
        if(room.getIdBuilding().toString().isBlank())
            return false;
        if(room.getDescription().isBlank())
            return false;
        if(room.getMap().isBlank())
            return false;    
        return true;
    }

    private Boolean ValidateRoomExists(UUID id){
        try{
            Room room = roomRepository.GetById(id);
            if(room.toString().isBlank())
                return false;
            return true;
        }
        catch(SQLException e) {
            return false;
        }      
    }
}
