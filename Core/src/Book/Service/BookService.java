package Book.Service;

import Book.Model.Book;
import Book.Repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class BookService implements IBookService{

    @Autowired
    private IBookRepository bookRepository;

    public Book GetById(UUID id) {
        return null;
    }

    public List<Book> GetAll() {
        return null;
    }

    public boolean Post(Book book) {
        return false;
    }

    public boolean Put(Book book) {
        return false;
    }

    public boolean Delete(UUID id) {
        return false;
    }
}
