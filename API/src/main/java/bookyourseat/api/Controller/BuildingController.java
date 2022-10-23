package bookyourseat.api.Controller;

import Building.Service.IBuildingService;

public class BuildingController {
    private IBuildingService buildingService;

    public BuildingController(IBuildingService buildingService){
        this.buildingService = buildingService;
    }
}
