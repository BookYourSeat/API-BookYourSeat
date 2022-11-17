package com.bookyourseat.api.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyourseat.api.Core.Room.Model.Room;
import com.bookyourseat.api.Core.Room.Service.RoomService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    
    @GetMapping
    public List<Room> Get() {
        return roomService.GetAll();
    }

    @GetMapping("{id}")
    public Room GetById(@PathVariable UUID id) {
        return roomService.GetById(id);
    }

    @PostMapping
    public Boolean Post(@RequestBody Room room){
        return roomService.Post(room);
    }

    @PutMapping("{id}")
    public Boolean Put(@PathVariable UUID id, @RequestBody Room room){
        return roomService.Put(id, room);
    }

    @DeleteMapping("{id}")
    public Boolean Delete(@PathVariable UUID id){
        return roomService.Delete(id);
    }
}
