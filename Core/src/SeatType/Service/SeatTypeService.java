package SeatType.Service;

public class SeatTypeService {
    private ISeatTypeService seatTypeService;

    public SeatTypeService(ISeatTypeService seatTypeService){
        this.seatTypeService = seatTypeService;
    }
}
