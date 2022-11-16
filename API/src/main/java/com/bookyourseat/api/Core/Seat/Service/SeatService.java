package com.bookyourseat.api.Core.Seat.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Seat.Model.Seat;
import com.bookyourseat.api.Core.Seat.Repository.SeatRepository;


@Component
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    
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

    public Boolean Post(Seat seat) {
        try {
            if(!ValidateSeatInfo(seat))
                return false;
            return seatRepository.Post(seat);
        }
        catch(SQLException e) {
            return false;
        }
    }

    public Boolean Put(UUID id, Seat seat) {
        try {
            if(!ValidateSeatInfo(seat))
                return false;
            if(!ValidateSeatExists(id))
                return false;
            return seatRepository.Put(id, seat);
        }
        catch(SQLException e) {
            return false;
        }
    }

    public Boolean Delete(UUID id) {
        try {
            if(!ValidateSeatExists(id))
                return false;
            return seatRepository.Delete(id);
        }
        catch(SQLException e) {
            return false;
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
