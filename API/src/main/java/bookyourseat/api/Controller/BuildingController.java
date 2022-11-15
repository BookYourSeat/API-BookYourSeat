package bookyourseat.api.Controller;

import Building.Model.Building;
import Building.Service.IBuildingService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Building")
public class BuildingController {
    private IBuildingService buildingService;

    public BuildingController(IBuildingService buildingService){
        this.buildingService = buildingService;
    }

    @GetMapping("/GetById")
    public Building GetUser(UUID Id) {
        Building newBuilding = new Building();
        return newBuilding;
    }

    @GetMapping("/GetAll")
    public List<Building> GetAll() {
        ArrayList buildings = new ArrayList<Building>();
        return buildings;
    }

    @PostMapping("/Post")
    public boolean Post(Building building) {
        return true;
    }

    @PutMapping("/Put")
    public boolean Put(Building building) {
        return true;
    }

    @DeleteMapping("/Delete")
    public boolean Delete(UUID id) {
        return true;
    }
}
