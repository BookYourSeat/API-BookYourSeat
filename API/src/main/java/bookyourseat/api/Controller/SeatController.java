package bookyourseat.api.Controller;

import Seat.Model.Seat;
import Seat.Service.ISeatService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Seat")
public class SeatController {
    private ISeatService seatService;

    public SeatController(ISeatService seatService){
        this.seatService = seatService;
    }

    @GetMapping("/GetById")
    public Seat GetUser(UUID Id) {
        Seat newSeat = new Seat();
        return newSeat;
    }

    @GetMapping("/GetAll")
    public List<Seat> GetAll() {
        ArrayList seats = new ArrayList<Seat>();
        return seats;
    }

    @PostMapping("/Post")
    public boolean Post(Seat seat) {
        return true;
    }

    @PutMapping("/Put")
    public boolean Put(Seat seat) {
        return true;
    }

    @DeleteMapping("/Delete")
    public boolean Delete(UUID id) {
        return true;
    }
}
