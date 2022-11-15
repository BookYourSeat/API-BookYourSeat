package Seat.Service;

import Seat.Model.Seat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ISeatService {
    public Seat GetById(UUID id);
    public List<Seat> GetAll();
    public boolean Post(Seat seat);
    public boolean Put(Seat seat);
    public boolean Delete(UUID id);
}
