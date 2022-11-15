package SeatType.Service;

import SeatType.Model.SeatType;
import SeatType.Repository.ISeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class SeatTypeService implements ISeatTypeService{

    @Autowired
    private ISeatTypeRepository seatTypeRepository;

    public SeatType GetById(UUID id){

        return null;
    }
    public List<SeatType> GetAll(){
        return null;
    }
    public boolean Post(SeatType seatType){
        return false;
    }
    public boolean Put(SeatType seatType){
        return false;
    }
    public boolean Delete(UUID id){
        return false;
    }
}
