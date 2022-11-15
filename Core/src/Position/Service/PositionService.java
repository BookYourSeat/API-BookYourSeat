package Position.Service;

import Position.Model.Position;
import Position.Repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class PositionService implements IPositionService{

    @Autowired
    private IPositionRepository positionRepository;

    public Position GetById(UUID id) {
        return null;
    }

    public List<Position> GetAll() {
        return null;
    }

    public boolean Post(Position position) {
        return false;
    }

    public boolean Put(Position position) {
        return false;
    }

    public boolean Delete(UUID id) {
        return false;
    }
}
