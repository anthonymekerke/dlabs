package fr.univlittoral.dlabs.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer id) {
        super("Could not find user with id=" + id);
    }
}