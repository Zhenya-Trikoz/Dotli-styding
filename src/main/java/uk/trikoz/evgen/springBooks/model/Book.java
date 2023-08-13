package uk.trikoz.evgen.springBooks.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * The Book class, which represents the essence of the book
 */
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private int year;
    private String genre;

    /**
     * Constructs a `Book` object with specified attributes.
     *
     * @param id     The ID of the book assigned by the database.
     * @param name   The name of the book.
     * @param author The author of the book.
     * @param year   The year of publication of the book.
     * @param genre  The genre of the book.
     */
    public Book(int id, String name, String author, int year, String genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    /**
     * Constructs a `Book` object with specified attributes.
     *
     * @param name   The name of the book.
     * @param author The author of the book.
     * @param year   The year of publication of the book.
     * @param genre  The genre of the book.
     */
    public Book(String name, String author, int year, String genre) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, year, genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }


}
