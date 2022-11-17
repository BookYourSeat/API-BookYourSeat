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
            List<Seat> seats = new ArrayList<Seat>();
            while (set.next()) {
                Seat seat = new Seat();
                seat.setId(UUID.fromString(set.getString("Id")));
                seat.setIdPosition(UUID.fromString(set.getString("IdPosition")));
                seat.setIdRoom(UUID.fromString(set.getString("IdRoom")));
                seat.setIdType(UUID.fromString(set.getString("IdType")));
                seats.add(seat);
            }
            return seats;
        } catch (SQLException e) {
            throw new SQLException("Unable to get seats");
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
            throw new SQLException("Unable to get seat");
        }
        return new Seat();
    }

    public Seat Post(Seat seat) throws SQLException {
        Connection connection = connector.getConnection();
        UUID newId = UUID.randomUUID();
    
        String query = "Insert into [Seat] ([Id],[IdPosition],[IdRoom],[IdType]) values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newId.toString());
            preparedStatement.setString(2, seat.getIdPosition().toString());
            preparedStatement.setString(3, seat.getIdRoom().toString());
            preparedStatement.setString(4, seat.getIdType().toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to create seat");
        }
        seat.setId(newId);
        return seat;
    }

    public Seat Put(UUID id, Seat seat) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Update [Seat] SET [IdPosition] = ?, [IdRoom] = ?,[IdType] = ? where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, seat.getIdPosition().toString());
            preparedStatement.setString(2, seat.getIdRoom().toString());
            preparedStatement.setString(3, seat.getIdType().toString());
            preparedStatement.setString(4, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to update seat");
        }
        seat.setId(id);
        return seat;
    }

    public Seat Delete(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Delete from [Seat] where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to delete seat");
        }
        Seat seat = new Seat();
        seat.setId(id);
        return seat;
    }
}
