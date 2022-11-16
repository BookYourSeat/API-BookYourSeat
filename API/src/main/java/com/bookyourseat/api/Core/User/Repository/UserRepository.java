package com.bookyourseat.api.Core.User.Repository;

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
import com.bookyourseat.api.Core.User.Model.User;

@Component
public class UserRepository {
    @Autowired
    private Connector connector;

    public List<User> GetAll() throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [User]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet set = preparedStatement.executeQuery();
            List<User> users = new ArrayList<User>();
            while (set.next()) {
                User user = new User();
                user.setUserId(UUID.fromString(set.getString("Id")));
                user.setFirstName(set.getString("FirstName"));
                user.setLastName(set.getString("LastName"));
                user.setEmail(set.getString("Email"));
                user.setPassword(set.getString("Password"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new SQLException("Unable to get users");
        }
    }

    public User GetById(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [User] WHERE Id = '" + id.toString() + "'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                User user = new User();
                user.setUserId(UUID.fromString(set.getString("Id")));
                user.setFirstName(set.getString("FirstName"));
                user.setLastName(set.getString("LastName"));
                user.setEmail(set.getString("Email"));
                user.setPassword(set.getString("Password"));
                return user;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get users");
        }
        return new User();
    }
}
