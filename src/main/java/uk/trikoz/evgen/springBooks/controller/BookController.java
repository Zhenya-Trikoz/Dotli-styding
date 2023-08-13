package uk.trikoz.evgen.springBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uk.trikoz.evgen.springBooks.exception.BookException;
import uk.trikoz.evgen.springBooks.model.Book;
import uk.trikoz.evgen.springBooks.service.BookService;

import java.util.Collection;

/**
 * This class defines the REST API endpoints for managing books.
 */
@RestController
@RequestMapping("/book")
public class BookController implements BookControllerInterface {

    @Autowired
    private BookService bookService;

    /**
     * Get the count of registered books.
     *
     * @return The count of books.
     */

    @GetMapping("/count")
    public int getCountBook() {
        return bookService.getCountBook();
    }

    /**
     * Get all books that are in the database.
     *
     * @return Collection of books.
     */

    @GetMapping("/readBooks")
    public Collection<Book> readBooks() {
        return bookService.readBooks();
    }

    /**
     * Method receives parameters from the request and uses them to create a new book,
     * then sends it to the service layer.
     *
     * @param name   The name of the book.
     * @param author The author of the book.
     * @param year   The publication year of the book.
     * @param genre  The genre of the book.
     */

    @PutMapping("/createBook")
    public void createBook(@RequestParam String name, String author, int year, String genre) {
        Book book = new Book(name, author, year, genre);
        bookService.createBook(book);
    }

    /**
     * Method receives parameters from the request and uses them to create a new book,
     * then sends it to the service layer for updating specific book information by id.
     *
     * @param id     The id of the book to be updated.
     * @param name   The new name of the book.
     * @param author The new author of the book.
     * @param year   The new publication year of the book.
     * @param genre  The new genre of the book.
     */

    @PutMapping("/updateBook")
    public void updateBook(@RequestParam int id, String name, String author, int year, String genre) {
        Book book = new Book(id, name, author, year, genre);
        bookService.updateBook(book);
    }

    /**
     * Method receives the id of the book to be deleted from the database.
     *
     * @param id The id of the book to be deleted.
     */
    @Override
    @DeleteMapping("/deleteBook")
    public void deleteBook(@RequestParam int id) {
        bookService.deleteBook(id);
    }

    /**
     * Get a book by its id from the database.
     *
     * @param id The id of the book to be found.
     * @return The book found by id, or null if not found.
     */
    @Override
    @GetMapping("/findBookId")
    public Book findBookId(@RequestParam int id) {
        return bookService.findBookId(id);
    }

    /**
     * Handle BookException by returning an error message with HTTP status NOT_FOUND.
     *
     * @param e The handled exception.
     * @return The error message.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BookException.class)
    public String handleBookNotFound(BookException e) {
        return e.getMessage();
    }
}
