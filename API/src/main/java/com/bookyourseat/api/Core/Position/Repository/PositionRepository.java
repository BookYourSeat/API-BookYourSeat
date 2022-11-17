package com.bookyourseat.api.Core.Position.Repository;

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
import com.bookyourseat.api.Core.Position.Model.Position;

@Component
public class PositionRepository {
    @Autowired
    private Connector connector;
    
    public List<Position> GetAll() throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Position]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet set = preparedStatement.executeQuery();
            List<Position> positions = new ArrayList<Position>();
            while (set.next()) {
                Position position = new Position();
                position.setId(UUID.fromString(set.getString("Id")));
                position.setTopLatitude(Float.valueOf(set.getString("TopLatitude")));
                position.setTopLongitude(Float.valueOf(set.getString("TopLongitude")));
                position.setBottomLatitude(Float.valueOf(set.getString("BottomLatitude")));
                position.setBottomLongitude(Float.valueOf(set.getString("BottomLongitude")));
                positions.add(position);
            }
            return positions;
        } catch (SQLException e) {
            throw new SQLException("Unable to get positions");
        }
    }

    public Position GetById(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Position] WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                Position position = new Position();
                position.setId(UUID.fromString(set.getString("Id")));
                position.setTopLatitude(Float.valueOf(set.getString("TopLatitude")));
                position.setTopLongitude(Float.valueOf(set.getString("TopLongitude")));
                position.setBottomLatitude(Float.valueOf(set.getString("BottomLatitude")));
                position.setBottomLongitude(Float.valueOf(set.getString("BottomLongitude")));
                return position;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get position");
        }
        return new Position();
    }

    public Position Post(Position position) throws SQLException {
        Connection connection = connector.getConnection();
        UUID newId = UUID.randomUUID();
    
        String query = "Insert into [Position] ([Id],[TopLatitude],[TopLongitude],[BottomLatitude],[BottomLongitude]) values (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newId.toString());
            preparedStatement.setString(2, String.valueOf(position.getTopLatitude()));
            preparedStatement.setString(3, String.valueOf(position.getTopLongitude()));
            preparedStatement.setString(4, String.valueOf(position.getBottomLatitude()));
            preparedStatement.setString(5, String.valueOf(position.getBottomLongitude()));
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to create position");
        }
        position.setId(newId);
        return position;
    }

    public Position Put(UUID id, Position position) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Update [Position] SET [TopLatitude] = ?, [TopLongitude] = ?, [BottomLatitude] = ?, [BottomLongitude] = ? where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, String.valueOf(position.getTopLatitude()));
            preparedStatement.setString(2, String.valueOf(position.getTopLongitude()));
            preparedStatement.setString(3, String.valueOf(position.getBottomLatitude()));
            preparedStatement.setString(4, String.valueOf(position.getBottomLongitude()));
            preparedStatement.setString(5, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to update position");
        }
        position.setId(id);
        return position;
    }

    public Position Delete(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Delete from [Position] where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to delete position");
        }
        Position position = new Position();
        position.setId(id);
        return position;
    }
}
