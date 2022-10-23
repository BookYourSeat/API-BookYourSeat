package bookyourseat.api.Controller;

import Seat.Service.ISeatService;

public class SeatController {
    private ISeatService seatService;

    public SeatController(ISeatService seatService){
        this.seatService = seatService;
    }
}
