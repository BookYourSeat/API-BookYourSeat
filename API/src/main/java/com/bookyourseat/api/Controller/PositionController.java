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
import com.bookyourseat.api.Core.Position.Service.PositionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<Position> Get() {
        return positionService.GetAll();
    }

    @GetMapping("{id}")
    public Position GetById(@PathVariable UUID id) {
        return positionService.GetById(id);
    }

    @PostMapping
    public Position Post(@RequestBody Position newPosition){
        return positionService.Post(newPosition);
    }

    @PutMapping("{id}")
    public Position Put(@PathVariable UUID id, @RequestBody Position position){
        return positionService.Put(id, position);
    }

    @PutMapping("Multi")
    public List<Position> Put(@RequestBody List<Position> positions){
        return positionService.MultiPut(positions);
    }

    @DeleteMapping("{id}")
    public Position Delete(@PathVariable UUID id){
        return positionService.Delete(id);
    }

}
