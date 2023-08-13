package uk.trikoz.evgen.springBooks.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uk.trikoz.evgen.springBooks.model.Book;

import java.util.List;

/**
 * The repository interface for accessing and manipulating Book entities in the database.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Retrieves a list of all books in the database.
     *
     * @return A list of books.
     */
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM books", nativeQuery = true)
    List<Book> readBooks();

    /**
     * Inserts a new book into the database.
     *
     * @param book The book to be inserted.
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `books` (`name`, `author`, `year`, `genre`) VALUES (:#{#book.name}, :#{#book.author}, :#{#book.year}, :#{#book.genre})", nativeQuery = true)
    void createBook(@Param("book") Book book);

    /**
     * Updates an existing book in the database.
     *
     * @param book The updated book information.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE books SET name = :#{#book.name}, author = :#{#book.author}, year = :#{#book.year}, genre = :#{#book.genre} WHERE id = :#{#book.id}", nativeQuery = true)
    void updateBook(@Param("book") Book book);

    /**
     * Deletes a book from the database by its ID.
     *
     * @param id The ID of the book to be deleted.
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM books WHERE id = :id", nativeQuery = true)
    void deleteBook(@Param("id") int id);

    /**
     * Retrieves a book from the database by its ID.
     *
     * @param id The ID of the book to be retrieved.
     * @return The retrieved book, or null if not found.
     */
    @Transactional
    @Query(value = "SELECT * FROM books WHERE id = :id", nativeQuery = true)
    Book findBookId(@Param("id") int id);
}


