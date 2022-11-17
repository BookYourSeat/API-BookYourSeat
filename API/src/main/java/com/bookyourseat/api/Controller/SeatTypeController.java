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

import com.bookyourseat.api.Core.SeatType.Model.SeatType;
import com.bookyourseat.api.Core.SeatType.Service.SeatTypeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("SeatType")
public class SeatTypeController {
    @Autowired
    private SeatTypeService seatTypeService;

    @GetMapping
    public List<SeatType> Get() {
        return seatTypeService.GetAll();
    }

    @GetMapping("{id}")
    public SeatType GetById(@PathVariable UUID id) {
        return seatTypeService.GetById(id);
    }

    @PostMapping
    public SeatType Post(@RequestBody SeatType newSeatType){
        return seatTypeService.Post(newSeatType);
    }

    @PutMapping("{id}")
    public SeatType Put(@PathVariable UUID id, @RequestBody SeatType seatType){
        return seatTypeService.Put(id, seatType);
    }

    @DeleteMapping("{id}")
    public SeatType Delete(@PathVariable UUID id){
        return seatTypeService.Delete(id);
    }
    
}
