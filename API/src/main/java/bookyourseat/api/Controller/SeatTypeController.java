package bookyourseat.api.Controller;

import SeatType.Service.ISeatTypeService;

public class SeatTypeController {
    private ISeatTypeService seatTypeService;

    public SeatTypeController(ISeatTypeService seatTypeService){
        this.seatTypeService = seatTypeService;
    }
}
