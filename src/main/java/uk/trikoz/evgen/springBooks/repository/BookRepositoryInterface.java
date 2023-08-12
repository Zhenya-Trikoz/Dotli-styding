package uk.trikoz.evgen.springBooks.repository;

import uk.trikoz.evgen.springBooks.model.Book;

import java.sql.Connection;
import java.util.Collection;

/**
 * The `BookRepositoryInterface` interface provides methods for interacting with a book repository.
 */
public interface BookRepositoryInterface {

    /**
     * Establishes a database connection.
     *
     * @return A database connection.
     */
    Connection getConnection();

    /**
     * Retrieves a collection of all books from the repository.
     *
     * @return A collection of books.
     */
    default Collection<Book> readBooks() {
        return null;
    }

    /**
     * Creates a new book in the repository.
     *
     * @param book The book to be created.
     */
    void createBook(Book book);

    /**
     * Updates an existing book in the repository.
     *
     * @param book The updated book.
     */
    void updateBook(Book book);

    /**
     * Deletes a book from the repository based on its ID.
     *
     * @param id The ID of the book to be deleted.
     */
    void deleteBook(int id);

    /**
     * Finds a book in the repository based on its ID.
     *
     * @param id The ID of the book to find.
     * @return The found book, or null if not found.
     */
    Book findBookId(int id);
}

