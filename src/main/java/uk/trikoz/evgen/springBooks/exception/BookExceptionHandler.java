package uk.trikoz.evgen.springBooks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global exception handler for handling BookException.
 */
@ControllerAdvice
public class BookExceptionHandler {

    /**
     * Handles BookException and returns a HTTP 400 Bad Request status.
     */
    @ExceptionHandler(BookException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBookException() {

    }
}