package uk.trikoz.evgen.springBooks.repository;

/**
 * The `SQLBook` class provides SQL queries as constants for book-related operations in the database.
 */
public class SQLBook {
    /**
     * SQL query to retrieve all books from the database.
     */
    public static final String readBook = "SELECT * FROM books";

    /**
     * SQL query to insert a new book into the database.
     */
    public static final String createBook = "INSERT INTO `books` (`name`, `author`, `year`, `genre`) VALUES (?, ?, ?, ?)";

    /**
     * SQL query to update an existing book in the database.
     */
    public static final String updateBook = "UPDATE books SET name = ?, author = ?, year = ?, genre = ? WHERE id = ?";

    /**
     * SQL query to delete a book from the database based on its ID.
     */
    public static final String deleteBook = "DELETE FROM books WHERE id = ?";

    /**
     * SQL query to find a book in the database based on its ID.
     */
    public static final String findBookId = "SELECT * FROM books WHERE id = ?";
}
