package Position.Service;

import Position.Model.Position;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface IPositionService {
    public Position GetById(UUID id);
    public List<Position> GetAll();
    public boolean Post(Position position);
    public boolean Put(Position position);
    public boolean Delete(UUID id);
}
