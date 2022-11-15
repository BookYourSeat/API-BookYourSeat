package bookyourseat.api.Controller;

import Book.Model.Book;
import Book.Service.IBookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Book")
public class BookController {
    private IBookService bookService;

    public BookController(IBookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/GetById")
    public Book GetUser(UUID Id) {
        Book newBook = new Book();
        return newBook;
    }

    @GetMapping("/GetAll")
    public List<Book> GetAll() {
        ArrayList books = new ArrayList<Book>();
        return books;
    }

    @PostMapping("/Post")
    public boolean Post(Book book) {
        return true;
    }

    @PutMapping("/Put")
    public boolean Put(Book book) {
        return true;
    }

    @DeleteMapping("/Delete")
    public boolean Delete(UUID id) {
        return true;
    }
}
