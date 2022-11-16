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
                user.setId(UUID.fromString(set.getString("Id")));
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
    
        String query = "SELECT * FROM [User] WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                User user = new User();
                user.setId(UUID.fromString(set.getString("Id")));
                user.setFirstName(set.getString("FirstName"));
                user.setLastName(set.getString("LastName"));
                user.setEmail(set.getString("Email"));
                user.setPassword(set.getString("Password"));
                return user;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get user");
        }
        return new User();
    }

    public Boolean Post(User user) throws SQLException {
        Connection connection = connector.getConnection();

        String query = "Insert into [User] ([Id],[FirstName],[LastName],[Email],[Password]) VALUES (NEWID(), ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            throw new SQLException("Unable to create user");
        }
        return true;
    }

    public Boolean Put(UUID id, User user) throws SQLException {
        Connection connection = connector.getConnection();

        String query = "Update [User] SET [FirstName] = ?,[LastName] = ?,[Email] = ?,[Password] = ? where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to update user");
        }
        return true;
    }

    public Boolean Delete(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Delete from [User] where [Id] = '" + id.toString() + "'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to delete user");
        }
        return true;
    }
}
