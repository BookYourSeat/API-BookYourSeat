package com.bookyourseat.api.Core.Book.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Book.Model.Book;
import com.bookyourseat.api.Core.Connector.Connector;

@Component
public class BookRepository {
    @Autowired
    private Connector connector;
    
    public List<Book> GetAll() throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Book]";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet set = preparedStatement.executeQuery();
            List<Book> books = new ArrayList<Book>();
            while (set.next()) {
                Book book = new Book();
                book.setId(UUID.fromString(set.getString("Id")));
                book.setIdSeat(UUID.fromString(set.getString("IdSeat")));
                book.setIdUser(UUID.fromString(set.getString("IdUser")));
                book.setBookedAt(Date.valueOf(set.getString("BookedAt")));
                book.setBookedUntil(Date.valueOf(set.getString("BookedUntil")));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new SQLException("Unable to get books");
        }
    }

    public Book GetById(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Book] WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                Book book = new Book();
                book.setId(UUID.fromString(set.getString("Id")));
                book.setIdSeat(UUID.fromString(set.getString("IdSeat")));
                book.setIdUser(UUID.fromString(set.getString("IdUser")));
                book.setBookedAt(Date.valueOf(set.getString("BookedAt")));
                book.setBookedUntil(Date.valueOf(set.getString("BookedUntil")));
                return book;
            }
        } catch (SQLException e) {
            throw new SQLException("Unable to get book");
        }
        return new Book();
    }

    public List<Book> GetBySeatAndDate(UUID seatId, Date date) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "SELECT * FROM [Book] where [IdSeat] = ? and [BookedAt] > ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, seatId.toString());
            preparedStatement.setString(2, date.toString());
            ResultSet set = preparedStatement.executeQuery();
            List<Book> books = new ArrayList<Book>();
            while (set.next()) {
                Book book = new Book();
                book.setId(UUID.fromString(set.getString("Id")));
                book.setIdSeat(UUID.fromString(set.getString("IdSeat")));
                book.setIdUser(UUID.fromString(set.getString("IdUser")));
                book.setBookedAt(Date.valueOf(set.getString("BookedAt")));
                book.setBookedUntil(Date.valueOf(set.getString("BookedUntil")));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new SQLException("Unable to get books");
        }
    }

    public Book Post(Book book) throws SQLException {
        Connection connection = connector.getConnection();
        UUID newId = UUID.randomUUID();
        String query = "Insert into [Book] ([Id],[IdSeat],[IdUser],[BookedAt],[BookedUntil]) values (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newId.toString());
            preparedStatement.setString(2, book.getIdSeat().toString());
            preparedStatement.setString(3, book.getIdUser().toString());
            preparedStatement.setString(4, book.getBookedAt().toString());
            preparedStatement.setString(5, book.getBookedUntil().toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to create book");
        }
        book.setId(newId);
        return book;
    }

    public Book Put(UUID id, Book book) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Update [Book] SET [IdSeat] = ?, [IdUser] = ?, [BookedAt] = ?, [BookedUntil] = ? where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, book.getIdSeat().toString());
            preparedStatement.setString(2, book.getIdUser().toString());
            preparedStatement.setString(3, book.getBookedAt().toString());
            preparedStatement.setString(4, book.getBookedUntil().toString());
            preparedStatement.setString(5, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to update book");
        }
        book.setId(id);
        return book;
    }

    public Book Delete(UUID id) throws SQLException {
        Connection connection = connector.getConnection();
    
        String query = "Delete from [Book] where [Id] = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();            
        } catch (SQLException e) {
            throw new SQLException("Unable to delete book");
        }
        Book book = new Book();
        book.setId(id);
        return book;
    }
}
