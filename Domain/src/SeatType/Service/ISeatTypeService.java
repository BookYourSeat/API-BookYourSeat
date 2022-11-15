package SeatType.Service;

import SeatType.Model.SeatType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ISeatTypeService {
    public SeatType GetById(UUID id);
    public List<SeatType> GetAll();
    public boolean Post(SeatType seatType);
    public boolean Put(SeatType seatType);
    public boolean Delete(UUID id);
}
