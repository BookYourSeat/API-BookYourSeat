package Book.Service;

import Book.Model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface IBookService {
    public Book GetById(UUID id);
    public List<Book> GetAll();
    public boolean Post(Book book);
    public boolean Put(Book book);
    public boolean Delete(UUID id);
}
