package Building.Service;

import Building.Model.Building;
import Building.Repositoy.IBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class BuildingService implements IBuildingService{

    @Autowired
    private IBuildingRepository buildingRepository;

    public Building GetById(UUID id) {
        return null;
    }

    public List<Building> GetAll() {
        return null;
    }

    public boolean Post(Building building) {
        return false;
    }

    public boolean Put(Building building) {
        return false;
    }

    public boolean Delete(UUID id) {
        return false;
    }
}
