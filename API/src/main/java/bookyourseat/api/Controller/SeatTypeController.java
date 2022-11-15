package bookyourseat.api.Controller;

import SeatType.Model.SeatType;
import SeatType.Service.ISeatTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/SeatType")
public class SeatTypeController {
    private ISeatTypeService seatTypeService;

    public SeatTypeController(ISeatTypeService seatTypeService){
        this.seatTypeService = seatTypeService;
    }

    @GetMapping("/GetById")
    public SeatType GetUser(UUID Id) {
        SeatType newSeatType = new SeatType();
        return newSeatType;
    }

    @GetMapping("/GetAll")
    public List<SeatType> GetAll() {
        ArrayList seatTypes = new ArrayList<SeatType>();
        return seatTypes;
    }

    @PostMapping("/Post")
    public boolean Post(SeatType seatType) {
        return true;
    }

    @PutMapping("/Put")
    public boolean Put(SeatType seatType) {
        return true;
    }

    @DeleteMapping("/Delete")
    public boolean Delete(UUID id) {
        return true;
    }
}
