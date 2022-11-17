package com.bookyourseat.api.Core.Building.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Building.DTO.BuildingDTO;
import com.bookyourseat.api.Core.Building.Model.Building;
import com.bookyourseat.api.Core.Connector.Connector;

@Component
public class BuildingRepository {
    @Autowired
    private Connector connector;
    
    public List<Building> GetAll() throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Building]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet set = preparedStatement.executeQuery();
            List<Building> buildings = new ArrayList<Building>();
            while (set.next()) {
                Building building = new Building();
                building.setId(UUID.fromString(set.getString("Id")));
                building.setIdCompany(UUID.fromString(set.getString("IdCompany")));
                building.setDescription(set.getString("Description"));
                buildings.add(building);
            }
            return buildings;
        } catch (SQLException e) {
            throw new SQLException("Unable to get buildings");
        }
    }

    public Building GetById(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Building] WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                Building building = new Building();
                building.setId(UUID.fromString(set.getString("Id")));
                building.setIdCompany(UUID.fromString(set.getString("IdCompany")));
                building.setDescription(set.getString("Description"));
                return building;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get building");
        }
        return new Building();
    }

    public BuildingDTO GetBuildingDTO(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT b.[Id], b.[Description], b.[IdCompany], c.[Description] as CompanyDescription FROM [BookYourSeat].[dbo].[Building] as b LEFT JOIN Company as c ON c.Id = b.IdCompany WHERE b.[Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                BuildingDTO buildingDTO = new BuildingDTO();
                buildingDTO.setId(UUID.fromString(set.getString("Id")));
                buildingDTO.setIdCompany(UUID.fromString(set.getString("IdCompany")));
                buildingDTO.setDescription(set.getString("Description"));
                buildingDTO.setCompanyDescription(set.getString("CompanyDescription"));
                return buildingDTO;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get building");
        }
        return new BuildingDTO();
    }

    public List<Building> GetByCompanyId(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Building] WHERE [IdCompany] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            List<Building> buildings = new ArrayList<Building>();
            while (set.next()) {
                Building building = new Building();
                building.setId(UUID.fromString(set.getString("Id")));
                building.setIdCompany(UUID.fromString(set.getString("IdCompany")));
                building.setDescription(set.getString("Description"));
                buildings.add(building);
            }
            return buildings;
        } catch (SQLException e) {
            throw new SQLException("Unable to get buildings");
        }
    }

    public Building Post(Building building) throws SQLException {
        Connection connection = connector.getConnection();
        UUID newId = UUID.randomUUID();
        String query = "Insert into [Building] ([Id],[IdCompany],[Description]) values (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newId.toString());
            preparedStatement.setString(2, building.getIdCompany().toString());
            preparedStatement.setString(3, building.getDescription());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to create building");
        }
        building.setId(newId);
        return building;
    }

    public Building Put(UUID id, Building building) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Update [Building] SET [IdCompany] = ?, [Description] = ? where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, building.getIdCompany().toString());
            preparedStatement.setString(2, building.getDescription());
            preparedStatement.setString(3, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to update building");
        }
        building.setId(id);
        return building;
    }

    public Building Delete(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Delete from [Building] where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to delete building");
        }
        Building building = new Building();
        building.setId(id);
        return building;
    }
}
