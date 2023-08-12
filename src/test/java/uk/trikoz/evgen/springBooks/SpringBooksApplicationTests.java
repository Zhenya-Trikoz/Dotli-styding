package uk.trikoz.evgen.springBooks;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import uk.trikoz.evgen.springBooks.controller.BookController;
import uk.trikoz.evgen.springBooks.model.Book;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringBooksApplicationTests {
    @Autowired
    private BookController bookController;

    @Test
    @Order(1)
    public void createBook() {
        bookController.createBook("Book1", "author1", 2023, "genre1");
    }

    @Test
    @Order(2)
    public void readBooks() {
        List<Book> bookList = (List<Book>) bookController.readBooks();
        System.out.println(bookList.size());
    }

    @Test
    @Order(3)
    public void updateBook() {
        List<Book> bookList = (List<Book>) bookController.readBooks();
        Book book = bookList.get(bookList.size()-1);

        book.setName("Book2");
        book.setAuthor("author2");
        book.setGenre("genre2");
        bookController.updateBook(book.getId(), book.getName(), book.getAuthor(), book.getYear(), book.getGenre());

    }

    @Test
    @Order(4)
    public void findBookId() {
        List<Book> bookList = (List<Book>) bookController.readBooks();
        Book book = bookController.findBookId(bookList.get(bookList.size()-1).getId());

        System.out.println(book);
    }

    @Test
    @Order(5)
    public void deleteBook() {
        List<Book> bookList = (List<Book>) bookController.readBooks();
        bookController.deleteBook(bookList.get(bookList.size()-1).getId());

    }

}
