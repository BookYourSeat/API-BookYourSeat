package com.bookyourseat.api.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyourseat.api.Core.Book.Model.Book;
import com.bookyourseat.api.Core.Book.Service.BookService;

@RestController
@RequestMapping("Book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> Get() {
        return bookService.GetAll();
    }

    @GetMapping("{id}")
    public Book GetById(@PathVariable UUID id) {
        return bookService.GetById(id);
    }

    @PostMapping
    public Book Post(@RequestBody Book newBook){
        return bookService.Post(newBook);
    }

    @PutMapping("{id}")
    public Book Put(@PathVariable UUID id, @RequestBody Book book){
        return bookService.Put(id, book);
    }

    @DeleteMapping("{id}")
    public Book Delete(@PathVariable UUID id){
        return bookService.Delete(id);
    }
}
