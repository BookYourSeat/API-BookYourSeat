package bookyourseat.api.Controller;

import Position.Service.IPositionService;

public class PositionController {
    private IPositionService positionService;

    public PositionController(IPositionService positionService){
        this.positionService = positionService;
    }
}
