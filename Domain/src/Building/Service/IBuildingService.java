package Building.Service;

import Building.Model.Building;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface IBuildingService {
    public Building GetById(UUID id);
    public List<Building> GetAll();
    public boolean Post(Building building);
    public boolean Put(Building building);
    public boolean Delete(UUID id);
}
