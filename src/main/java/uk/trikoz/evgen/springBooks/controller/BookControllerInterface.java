package uk.trikoz.evgen.springBooks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import uk.trikoz.evgen.springBooks.model.Book;

import java.util.Collection;

/**
 * This interface defines the methods for managing books through the REST API.
 */
public interface BookControllerInterface {

    /**
     * Get the count of all books.
     *
     * @return The count of books.
     */
    int getCountBook();

    /**
     * Get a collection of all books.
     *
     * @return A collection of books.
     */
    Collection<Book> readBooks();

    /**
     * Create a new book.
     *
     * @param name   The name of the book.
     * @param author The author of the book.
     * @param year   The year of publication.
     * @param genre  The genre of the book.
     */
    void createBook(String name, String author, int year, String genre);

    /**
     * Update information about a book.
     *
     * @param id     The ID of the book to update.
     * @param name   The new name of the book.
     * @param author The new author of the book.
     * @param year   The new year of publication.
     * @param genre  The new genre of the book.
     */
    void updateBook(int id, String name, String author, int year, String genre);

    /**
     * Delete a book by its ID.
     *
     * @param id The ID of the book to delete.
     */
    void deleteBook(int id);

    /**
     * Find a book by its ID.
     *
     * @param id The ID of the book to find.
     * @return The found book, or null if not found.
     */
    Book findBookId(int id);
}
