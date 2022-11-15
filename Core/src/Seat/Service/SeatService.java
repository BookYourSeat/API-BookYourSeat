package Seat.Service;

import Seat.Model.Seat;
import Seat.Repository.ISeatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class SeatService implements ISeatService{

    @Autowired
    private ISeatRepository seatRepository;

    public Seat GetById(UUID id){

        return null;
    }
    public List<Seat> GetAll(){
        return null;
    }
    public boolean Post(Seat seat){
        return false;
    }
    public boolean Put(Seat seat){
        return false;
    }
    public boolean Delete(UUID id){
        return false;
    }
}
