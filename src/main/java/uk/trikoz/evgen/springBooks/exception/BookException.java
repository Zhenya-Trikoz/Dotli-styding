package uk.trikoz.evgen.springBooks.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Custom exception class for handling book-related exceptions.
 */
public class BookException extends RuntimeException {

    /**
     * Constructs a new BookException with the specified detail message.
     *
     * @param message The detail message.
     */
    public BookException(String message) {
        super(message);
    }
}
