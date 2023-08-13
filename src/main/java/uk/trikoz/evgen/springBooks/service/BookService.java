package uk.trikoz.evgen.springBooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.trikoz.evgen.springBooks.exception.BookException;
import uk.trikoz.evgen.springBooks.model.Book;
import uk.trikoz.evgen.springBooks.repository.BookRepository;

import java.util.Collection;

/**
 * This class provides the business logic for managing books.
 */
@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Get the count of registered books.
     *
     * @return The count of books.
     */
    @Override
    public int getCountBook() {
        return bookRepository.readBooks().size();
    }

    /**
     * Get all books that are in the database.
     *
     * @return Collection of books.
     */
    @Override
    public Collection<Book> readBooks() {
        return bookRepository.readBooks();
    }

    /**
     * Create a new book if it doesn't already exist in the database.
     *
     * @param book The book to be created.
     * @throws BookException If the book is already registered or if input data is invalid.
     */
    @Override

    public void createBook(Book book) throws BookException {
        if (bookRepository.readBooks().contains(book)) {
            throw new BookException(
                    String.format("Book %s is already registered", book));
        } else {
            if (!book.getName().isEmpty() &&
                    !book.getAuthor().isEmpty() &&
                    !book.getGenre().isEmpty()) {
                bookRepository.createBook(book);
            } else {
                throw new BookException("Invalid input data");
            }
        }
    }


    /**
     * Update an existing book's information by id.
     *
     * @param book The book with updated information.
     * @throws BookException If the book is already registered or if input data is invalid.
     */
    @Override
    public void updateBook(Book book) throws BookException {
        if (bookRepository.readBooks().contains(book)) {
            throw new BookException(
                    String.format("Book %s is already registered", book));
        } else {
            if (!book.getName().isEmpty() &&
                    !book.getAuthor().isEmpty() &&
                    !book.getGenre().isEmpty()) {
                bookRepository.updateBook(book);
            } else {
                throw new BookException("Invalid input data");
            }
        }
    }

    /**
     * Delete a book from the database by its id.
     *
     * @param id The id of the book to be deleted.
     */
    @Override
    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    /**
     * Get a book by its id from the database.
     *
     * @param id The id of the book to be found.
     * @return The book found by id, or throw BookException if not found.
     */
    @Override
    public Book findBookId(int id) {
        Book book = bookRepository.findBookId(id);

        if (book == null) {
            throw new BookException(
                    String.format("Book with id: %s not found", id));
        } else {
            return book;
        }
    }
}
