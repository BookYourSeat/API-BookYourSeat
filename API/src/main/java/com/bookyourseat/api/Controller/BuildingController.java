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

import com.bookyourseat.api.Core.Building.Model.Building;
import com.bookyourseat.api.Core.Building.Service.BuildingService;

@RestController
@RequestMapping("Building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public List<Building> Get() {
        return buildingService.GetAll();
    }

    @GetMapping("{id}")
    public Building GetById(@PathVariable UUID id) {
        return buildingService.GetById(id);
    }

    @PostMapping
    public Building Post(@RequestBody Building newBuilding){
        return buildingService.Post(newBuilding);
    }

    @PutMapping("{id}")
    public Building Put(@PathVariable UUID id, @RequestBody Building building){
        return buildingService.Put(id, building);
    }

    @DeleteMapping("{id}")
    public Building Delete(@PathVariable UUID id){
        return buildingService.Delete(id);
    }
}
