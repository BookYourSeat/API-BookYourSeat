package com.bookyourseat.api.Core.SeatType.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.SeatType.Model.SeatType;
import com.bookyourseat.api.Core.SeatType.Repository.SeatTypeRepository;

@Component
public class SeatTypeService {
    @Autowired
    private SeatTypeRepository seatTypeRepository;

    public List<SeatType> GetAll() {
        try {
            return seatTypeRepository.GetAll();
        }
        catch(SQLException e) {
            return new ArrayList<SeatType>();
        }
    }

    public SeatType GetById(UUID id) {
        try {
            return seatTypeRepository.GetById(id);
        }
        catch(SQLException e) {
            return new SeatType();
        }
    }

    public SeatType Post(SeatType seatType) {
        try {
            if(!ValidateSeatTypeInfo(seatType))
                return new SeatType();
            return seatTypeRepository.Post(seatType);
        }
        catch(SQLException e) {
            return new SeatType();
        }
    }

    public SeatType Put(UUID id, SeatType seatType) {
        try {
            if(!ValidateSeatTypeInfo(seatType))
                return new SeatType();
            if(!ValidateSeatTypeExists(id))
                return new SeatType();
            return seatTypeRepository.Put(id, seatType);
        }
        catch(SQLException e) {
            return new SeatType();
        }
    }

    public SeatType Delete(UUID id) {
        try {
            if(!ValidateSeatTypeExists(id))
                return new SeatType();
            return seatTypeRepository.Delete(id);
        }
        catch(SQLException e) {
            return new SeatType();
        }
    }

    private Boolean ValidateSeatTypeInfo(SeatType seatType){
        if(seatType.getDescription().isBlank())
            return false;
        return true;
    }

    private Boolean ValidateSeatTypeExists(UUID id){
        try{
            SeatType seatType = seatTypeRepository.GetById(id);
            if(seatType.toString().isBlank())
                return false;
            return true;
        }
        catch(SQLException e) {
            return false;
        }      
    }
    
}
