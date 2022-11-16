package com.bookyourseat.api.Core.Seat.Repository;

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
import com.bookyourseat.api.Core.Seat.Model.Seat;

@Component
public class SeatRepository {
    @Autowired
    private Connector connector;
    
    public List<Seat> GetAll() throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Seat]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet set = preparedStatement.executeQuery();
            List<Seat> users = new ArrayList<Seat>();
            while (set.next()) {
                Seat seat = new Seat();
                seat.setId(UUID.fromString(set.getString("Id")));
                seat.setIdPosition(UUID.fromString(set.getString("IdPosition")));
                seat.setIdRoom(UUID.fromString(set.getString("IdRoom")));
                seat.setIdType(UUID.fromString(set.getString("IdType")));
                users.add(seat);
            }
            return users;
        } catch (SQLException e) {
            throw new SQLException("Unable to get users");
        }
    }

    public Seat GetById(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Seat] WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                Seat seat = new Seat();
                seat.setId(UUID.fromString(set.getString("Id")));
                seat.setIdPosition(UUID.fromString(set.getString("IdPosition")));
                seat.setIdRoom(UUID.fromString(set.getString("IdRoom")));
                seat.setIdType(UUID.fromString(set.getString("IdType")));
                return seat;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get users");
        }
        return new Seat();
    }

    public Boolean Post(Seat seat) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Insert into [Seat] ([Id],[IdPosition],[IdRoom],[IdType]) values (NEWID(), ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, seat.getIdPosition().toString());
            preparedStatement.setString(2, seat.getIdRoom().toString());
            preparedStatement.setString(3, seat.getIdType().toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to create users");
        }
        return true;
    }

    public Boolean Put(UUID id, Seat seat) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Update [Seat] SET [IdPosition] = ?, [IdRoom] = ?,[IdType] = ? where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, seat.getIdPosition().toString());
            preparedStatement.setString(2, seat.getIdRoom().toString());
            preparedStatement.setString(3, seat.getIdType().toString());
            preparedStatement.setString(4, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to update users");
        }
        return true;
    }

    public Boolean Delete(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Delete from [Seat] where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to delete seat");
        }
        return true;
    }
}
