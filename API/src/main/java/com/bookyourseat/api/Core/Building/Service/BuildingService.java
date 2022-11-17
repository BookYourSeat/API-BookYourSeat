package com.bookyourseat.api.Core.Building.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Building.DTO.BuildingDTO;
import com.bookyourseat.api.Core.Building.Model.Building;
import com.bookyourseat.api.Core.Building.Repository.BuildingRepository;

@Component
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> GetAll() {
        try {
            return buildingRepository.GetAll();
        }
        catch(SQLException e) {
            return new ArrayList<Building>();
        }
    }

    public Building GetById(UUID id) {
        try {
            return buildingRepository.GetById(id);
        }
        catch(SQLException e) {
            return new Building();
        }
    }

    public BuildingDTO GetBuildingDTO(UUID id) {
        try {
            return buildingRepository.GetBuildingDTO(id);
        }
        catch(SQLException e) {
            return new BuildingDTO();
        }
    }

    public List<Building> GetByCompanyId(UUID id) {
        try {
            return buildingRepository.GetByCompanyId(id);
        }
        catch(SQLException e) {
            return new ArrayList<Building>();
        }
    }

    public Building Post(Building building) {
        try {
            if(!ValidateBuildingInfo(building))
                return new Building();
            return buildingRepository.Post(building);
        }
        catch(SQLException e) {
            return new Building();
        }
    }

    public Building Put(UUID id, Building building) {
        try {
            if(!ValidateBuildingInfo(building))
                return new Building();
            if(!ValidateBuildingExists(id))
                return new Building();
            return buildingRepository.Put(id, building);
        }
        catch(SQLException e) {
            return new Building();
        }
    }

    public Building Delete(UUID id) {
        try {
            if(!ValidateBuildingExists(id))
                return new Building();
            return buildingRepository.Delete(id);
        }
        catch(SQLException e) {
            return new Building();
        }
    }

    private Boolean ValidateBuildingInfo(Building building){
        if(building.getIdCompany().toString().isBlank())
            return false;
        if(building.getDescription().isBlank())
            return false;
        return true;
    }

    private Boolean ValidateBuildingExists(UUID id){
        try{
            Building building = buildingRepository.GetById(id);
            if(building.toString().isBlank())
                return false;
            return true;
        }
        catch(SQLException e) {
            return false;
        }      
    }
}
