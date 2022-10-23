package bookyourseat.api.Controller;

import Book.Service.IBookService;

public class BookController {
    private IBookService bookService;

    public BookController(IBookService bookService){
        this.bookService = bookService;
    }
}
