package com.bookyourseat.api.Core.Room.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Connector.Connector;
import com.bookyourseat.api.Core.Room.Model.Room;

@Component
public class RoomRepository {
    @Autowired
    private Connector connector;
    
    public List<Room> GetAll() throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Room]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet set = preparedStatement.executeQuery();
            List<Room> rooms = new ArrayList<Room>();
            while (set.next()) {
                Room room = new Room();
                room.setId(UUID.fromString(set.getString("Id")));
                room.setIdBuilding(UUID.fromString(set.getString("IdBuilding")));
                room.setDescription(set.getString("Description"));
                room.setMap(set.getString("Map"));
                rooms.add(room);
            }
            return rooms;
        } catch (SQLException e) {
            throw new SQLException("Unable to get rooms");
        }
    }

    public Room GetById(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Room] WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                Room room = new Room();
                room.setId(UUID.fromString(set.getString("Id")));
                room.setIdBuilding(UUID.fromString(set.getString("IdBuilding")));
                room.setDescription(set.getString("Description"));
                room.setMap(set.getString("Map"));
                return room;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get room");
        }
        return new Room();
    }

    public Room Post(Room room) throws SQLException {
        Connection connection = connector.getConnection();
        UUID newId = UUID.randomUUID();
    
        String query = "Insert into [Room] ([Id],[IdBuilding],[Description],[Map]) values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newId.toString());
            preparedStatement.setString(2, room.getIdBuilding().toString());
            preparedStatement.setString(3, room.getDescription());
            preparedStatement.setString(4, room.getMap());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to create room");
        }
        room.setId(newId);
        return room;
    }

    public Room Put(UUID id, Room room) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Update [Room] SET [IdBuilding] = ?, [Description] = ?, [Map] = ? where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, room.getIdBuilding().toString());
            preparedStatement.setString(2, room.getDescription());
            preparedStatement.setString(3, room.getMap());
            preparedStatement.setString(4, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to update room");
        }
        room.setId(id);
        return room;
    }

    public Room Delete(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Delete from [Room] where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to delete room");
        }
        Room room = new Room();
        room.setId(id);
        return room;
    }
}
