package uk.trikoz.evgen.springBooks.repository;

import org.springframework.stereotype.Repository;
import uk.trikoz.evgen.springBooks.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class provides database access methods for managing books.
 */
@Repository
public class BookRepository implements BookRepositoryInterface {
    /*
     * The 'url' variable stores the database address.
     */
    public static String url = "jdbc:mysql://localhost:3306/book";
    public static String username = "root";
    public static String password = "password";

    /**
     * Constructor for creating a database connection.
     */
    public BookRepository() {
        Connection connection = getConnection();
    }

    /**
     * Get a database connection.
     *
     * @return The database connection.
     */
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Retrieve a collection of all books from the database.
     *
     * @return A collection of books.
     */
    @Override
    public Collection<Book> readBooks() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLBook.readBook)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getInt("year"),
                        resultSet.getString("genre"));
                bookList.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(bookList);

    }

    /**
     * Create a new book in the database.
     *
     * @param book The book to be created.
     */
    @Override
    public void createBook(Book book) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLBook.createBook)) {

            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setString(4, book.getGenre());

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update an existing book's information in the database.
     *
     * @param book The book with updated information.
     */
    @Override
    public void updateBook(Book book) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLBook.updateBook)) {

            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setString(4, book.getGenre());
            statement.setInt(5, book.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a book from the database by its id.
     *
     * @param id The id of the book to be deleted.
     */
    @Override
    public void deleteBook(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLBook.deleteBook)) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find a book in the database by its id.
     *
     * @param id The id of the book to be found.
     * @return The book found by id, or null if not found.
     */
    @Override
    public Book findBookId(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLBook.findBookId)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getInt("year"),
                        resultSet.getString("genre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

