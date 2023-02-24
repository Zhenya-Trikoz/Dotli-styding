package ua.ch.trikoz.evgen.springboot.exception;


public class ProjectRegistrationException extends RuntimeException {

    public ProjectRegistrationException(String message){
        super(message);
    }
}
