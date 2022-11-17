package com.bookyourseat.api.Core.Seat.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Position.Model.Position;
import com.bookyourseat.api.Core.Position.Service.PositionService;
import com.bookyourseat.api.Core.Seat.DTO.SeatDTO;
import com.bookyourseat.api.Core.Seat.Model.Seat;
import com.bookyourseat.api.Core.Seat.Repository.SeatRepository;
import com.bookyourseat.api.Core.SeatType.Model.SeatType;
import com.bookyourseat.api.Core.SeatType.Service.SeatTypeService;


@Component
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private PositionService positionService;
    @Autowired
    private SeatTypeService seatTypeService;

    public List<Seat> GetAll() {
        try {
            return seatRepository.GetAll();
        }
        catch(SQLException e) {
            return new ArrayList<Seat>();
        }
    }

    public Seat GetById(UUID id) {
        try {
            return seatRepository.GetById(id);
        }
        catch(SQLException e) {
            return new Seat();
        }
    }

    public SeatDTO GetByIdWithPosition(UUID seatId) {
        Seat seat = GetById(seatId);
        Position position = positionService.GetById(seat.getIdPosition());
        return new SeatDTO(seat, position);
    }
    
    public SeatDTO GetByIdWithPositionAndType(UUID seatId) {
        Seat seat = GetById(seatId);
        Position position = positionService.GetById(seat.getIdPosition());
        SeatType seatType = seatTypeService.GetById(seat.getIdType());
        return new SeatDTO(seat, position, seatType);
    }

    public Seat Post(Seat seat) {
        try {
            if(!ValidateSeatInfo(seat))
                return new Seat();
            return seatRepository.Post(seat);
        }
        catch(SQLException e) {
            return new Seat();
        }
    }

    public SeatDTO PostWithPosition(Seat seat, Position position) {
        try {
            Position positionValidator = positionService.Post(position);
            if(positionValidator.toString().isBlank())
                return new SeatDTO();
            seat.setIdPosition(positionValidator.getId());
            if(!ValidateSeatInfo(seat))
                return new SeatDTO();
            seatRepository.Post(seat);
            return new SeatDTO(seat, position);
        }
        catch(SQLException e) {
            return new SeatDTO();
        }
    }

    public Seat Put(UUID id, Seat seat) {
        try {
            if(!ValidateSeatInfo(seat))
                return new Seat();
            if(!ValidateSeatExists(id))
                return new Seat();
            return seatRepository.Put(id, seat);
        }
        catch(SQLException e) {
            return new Seat();
        }
    }

    public Seat Delete(UUID id) {
        try {
            if(!ValidateSeatExists(id))
                return new Seat();
            return seatRepository.Delete(id);
        }
        catch(SQLException e) {
            return new Seat();
        }
    }

    private Boolean ValidateSeatInfo(Seat seat){
        if(seat.getIdPosition().toString().isBlank())
            return false;
        if(seat.getIdRoom().toString().isBlank())
            return false;
        if(seat.getIdType().toString().isBlank())
            return false;
        return true;
    }

    private Boolean ValidateSeatExists(UUID id){
        try{
            Seat seat = seatRepository.GetById(id);
            if(seat.toString().isBlank())
                return false;
            return true;
        }
        catch(SQLException e) {
            return false;
        }      
    }
}
