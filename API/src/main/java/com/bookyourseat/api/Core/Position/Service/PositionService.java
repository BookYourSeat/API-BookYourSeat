package com.bookyourseat.api.Core.Position.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Position.Model.Position;
import com.bookyourseat.api.Core.Position.Repository.PositionRepository;

@Component
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public List<Position> GetAll() {
        try {
            return positionRepository.GetAll();
        }
        catch(SQLException e) {
            return new ArrayList<Position>();
        }
    }

    public Position GetById(UUID id) {
        try {
            return positionRepository.GetById(id);
        }
        catch(SQLException e) {
            return new Position();
        }
    }

    public Boolean Post(Position position) {
        try {
            if(!ValidatePositionInfo(position))
                return false;
            return positionRepository.Post(position);
        }
        catch(SQLException e) {
            return false;
        }
    }

    public Boolean Put(UUID id, Position position) {
        try {
            if(!ValidatePositionInfo(position))
                return false;
            if(!ValidatePositionExists(id))
                return false;
            return positionRepository.Put(id, position);
        }
        catch(SQLException e) {
            return false;
        }
    }

    public Boolean Delete(UUID id) {
        try {
            if(!ValidatePositionExists(id))
                return false;
            return positionRepository.Delete(id);
        }
        catch(SQLException e) {
            return false;
        }
    }

    private Boolean ValidatePositionInfo(Position position){
        if(position.getTopLatitude().isNaN())
            return false;
        if(position.getTopLongitude().isNaN())
            return false;
        if(position.getBottomLatitude().isNaN())
            return false;
        if(position.getBottomLongitude().isNaN())
            return false;
        return true;
    }

    private Boolean ValidatePositionExists(UUID id){
        try{
            Position position = positionRepository.GetById(id);
            if(position.toString().isBlank())
                return false;
            return true;
        }
        catch(SQLException e) {
            return false;
        }      
    }
    
}
