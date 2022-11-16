package com.bookyourseat.api.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyourseat.api.Core.Seat.Model.Seat;
import com.bookyourseat.api.Core.Seat.Service.SeatService;

@RestController
@RequestMapping("Seat")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<Seat> Get() {
        return seatService.GetAll();
    }

    @GetMapping("{id}")
    public Seat GetById(@PathVariable UUID id) {
        return seatService.GetById(id);
    }

    @PostMapping
    public Boolean Post(@RequestBody Seat newSeat){
        return seatService.Post(newSeat);
    }

    @PutMapping("{id}")
    public Boolean Put(@PathVariable UUID id, @RequestBody Seat user){
        return seatService.Put(id, user);
    }

    @DeleteMapping("{id}")
    public Boolean Delete(@PathVariable UUID id){
        return seatService.Delete(id);
    }
}