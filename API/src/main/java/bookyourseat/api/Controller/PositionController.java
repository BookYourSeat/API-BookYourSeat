package bookyourseat.api.Controller;

import Position.Model.Position;
import Position.Service.IPositionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Position")
public class PositionController {
    private IPositionService positionService;

    public PositionController(IPositionService positionService){
        this.positionService = positionService;
    }

    @GetMapping("/GetById")
    public Position GetUser(UUID Id) {
        Position newPosition = new Position();
        return newPosition;
    }

    @GetMapping("/GetAll")
    public List<Position> GetAll() {
        ArrayList positions = new ArrayList<Position>();
        return positions;
    }

    @PostMapping("/Post")
    public boolean Post(Position position) {
        return true;
    }

    @PutMapping("/Put")
    public boolean Put(Position position) {
        return true;
    }

    @DeleteMapping("/Delete")
    public boolean Delete(UUID id) {
        return true;
    }
}
