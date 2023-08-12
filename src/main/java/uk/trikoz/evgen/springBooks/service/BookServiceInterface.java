package uk.trikoz.evgen.springBooks.service;

import uk.trikoz.evgen.springBooks.model.Book;

import java.util.Collection;

/**
 * The `BookServiceInterface` interface defines methods for managing book-related operations.
 */
public interface BookServiceInterface {

    /**
     * Retrieves the count of registered books.
     *
     * @return The count of registered books.
     */
    int getCountBook();

    /**
     * Retrieves a collection of all books stored in the database.
     *
     * @return A collection of all books.
     */
    Collection<Book> readBooks();

    /**
     * Creates a new book in the database.
     *
     * @param book The book to be created.
     */
    void createBook(Book book);

    /**
     * Updates an existing book in the database.
     *
     * @param book The updated book information.
     */
    void updateBook(Book book);

    /**
     * Deletes a book from the database based on its ID.
     *
     * @param id The ID of the book to be deleted.
     */
    void deleteBook(int id);

    /**
     * Finds a book in the database based on its ID.
     *
     * @param id The ID of the book to be found.
     * @return The found book, or null if not found.
     */
    Book findBookId(int id);
}
