package ua.ch.trikoz.evgen.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProjectExceptionHandler {

    @ExceptionHandler(ProjectRegistrationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleProjectException() {

    }
}
