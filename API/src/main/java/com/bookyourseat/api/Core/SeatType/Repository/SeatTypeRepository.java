package com.bookyourseat.api.Core.SeatType.Repository;

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
import com.bookyourseat.api.Core.SeatType.Model.SeatType;

@Component
public class SeatTypeRepository {
    @Autowired
    private Connector connector;
    
    public List<SeatType> GetAll() throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [SeatType]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet set = preparedStatement.executeQuery();
            List<SeatType> seatTypes = new ArrayList<SeatType>();
            while (set.next()) {
                SeatType seatType = new SeatType();
                seatType.setId(UUID.fromString(set.getString("Id")));
                seatType.setDescription(set.getString("Description"));
                seatTypes.add(seatType);
            }
            return seatTypes;
        } catch (SQLException e) {
            throw new SQLException("Unable to get seatTypes");
        }
    }

    public SeatType GetById(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [SeatType] WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                SeatType seatType = new SeatType();
                seatType.setId(UUID.fromString(set.getString("Id")));
                seatType.setDescription(set.getString("Description"));
                return seatType;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get seatType");
        }
        return new SeatType();
    }

    public Boolean Post(SeatType seatType) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Insert into [SeatType] ([Id],[Description]) values (NEWID(), ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, seatType.getDescription());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to create seatType");
        }
        return true;
    }

    public Boolean Put(UUID id, SeatType seatType) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Update [SeatType] SET [Description] = ? where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, seatType.getDescription());
            preparedStatement.setString(2, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to update seatType");
        }
        return true;
    }

    public Boolean Delete(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Delete from [SeatType] where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to delete seatType");
        }
        return true;
    }
}
