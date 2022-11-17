package com.bookyourseat.api.Core.Book.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.Book.Model.Book;
import com.bookyourseat.api.Core.Book.Repository.BookRepository;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> GetAll() {
        try {
            return bookRepository.GetAll();
        }
        catch(SQLException e) {
            return new ArrayList<Book>();
        }
    }

    public Book GetById(UUID id) {
        try {
            return bookRepository.GetById(id);
        }
        catch(SQLException e) {
            return new Book();
        }
    }

    public List<Book> GetBySeatAndDate(UUID seatId, Date date) {
        try {
            return bookRepository.GetBySeatAndDate(seatId, date);
        }
        catch(SQLException e) {
            return new ArrayList<Book>();
        }
    }

    public Book Post(Book book) {
        try {
            if(!ValidateBookInfo(book))
                return new Book();
            return bookRepository.Post(book);
        }
        catch(SQLException e) {
            return new Book();
        }
    }

    public Book Put(UUID id, Book book) {
        try {
            if(!ValidateBookInfo(book))
                return new Book();
            if(!ValidateBookExists(id))
                return new Book();
            return bookRepository.Put(id, book);
        }
        catch(SQLException e) {
            return new Book();
        }
    }

    public Book Delete(UUID id) {
        try {
            if(!ValidateBookExists(id))
                return new Book();
            return bookRepository.Delete(id);
        }
        catch(SQLException e) {
            return new Book();
        }
    }

    private Boolean ValidateBookInfo(Book book){
        if(book.getIdSeat().toString().isBlank())
            return false;
        if(book.getIdUser().toString().isBlank())
            return false;
        if(book.getBookedAt().toString().isBlank())
            return false;
        if(book.getBookedUntil().toString().isBlank())
            return false;
        return true;
    }

    private Boolean ValidateBookExists(UUID id){
        try{
            Book book = bookRepository.GetById(id);
            if(book.toString().isBlank())
                return false;
            return true;
        }
        catch(SQLException e) {
            return false;
        }      
    }
}
