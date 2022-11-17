package com.bookyourseat.api.Core.Company.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Company.Model.Company;
import com.bookyourseat.api.Core.Connector.Connector;

@Component
public class CompanyRepository {
    @Autowired
    private Connector connector;
    
    public List<Company> GetAll() throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Company]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet set = preparedStatement.executeQuery();
            List<Company> companies = new ArrayList<Company>();
            while (set.next()) {
                Company company = new Company();
                company.setId(UUID.fromString(set.getString("Id")));
                company.setDescription(set.getString("Description"));
                companies.add(company);
            }
            return companies;
        } catch (SQLException e) {
            throw new SQLException("Unable to get companies");
        }
    }

    public Company GetById(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Company] WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                Company company = new Company();
                company.setId(UUID.fromString(set.getString("Id")));
                company.setDescription(set.getString("Description"));
                return company;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get company");
        }
        return new Company();
    }

    public Company Post(Company company) throws SQLException {
        Connection connection = connector.getConnection();
        UUID newId = UUID.randomUUID();
        String query = "Insert into [Company] ([Id],[Description]) values (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newId.toString());
            preparedStatement.setString(2, company.getDescription());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to create company");
        }
        company.setId(newId);
        return company;
    }

    public Company Put(UUID id, Company company) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Update [Company] SET [Description] = ? where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, company.getDescription());
            preparedStatement.setString(2, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to update company");
        }
        company.setId(id);
        return company;
    }

    public Company Delete(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Delete from [Company] where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e);
            throw new SQLException("Unable to delete company");
        }
        Company company = new Company();
        company.setId(id);
        return company;
    }
}
