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

import com.bookyourseat.api.Core.Position.Model.Position;
import com.bookyourseat.api.Core.Seat.DTO.SeatDTO;
import com.bookyourseat.api.Core.Seat.Model.Seat;
import com.bookyourseat.api.Core.Seat.Service.SeatService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("WithPosition/{seatId}/{positionId}")
    public SeatDTO GetByIdWithPosition(@PathVariable UUID seatId) {
        return seatService.GetByIdWithPosition(seatId);
    }

    @GetMapping("WithPositionAndType/{seatId}")
    public SeatDTO GetByIdWithPositionAndType(@PathVariable UUID seatId) {
        return seatService.GetByIdWithPositionAndType(seatId);
    }

    @PostMapping
    public Seat Post(@RequestBody Seat newSeat){
        return seatService.Post(newSeat);
    }

    @PostMapping("WithPosition")
    public SeatDTO PostWithPosition(@RequestBody Seat newSeat, @RequestBody Position position){
        return seatService.PostWithPosition(newSeat, position);
    }

    @PutMapping("{id}")
    public Seat Put(@PathVariable UUID id, @RequestBody Seat user){
        return seatService.Put(id, user);
    }

    @DeleteMapping("{id}")
    public Seat Delete(@PathVariable UUID id){
        return seatService.Delete(id);
    }
}
