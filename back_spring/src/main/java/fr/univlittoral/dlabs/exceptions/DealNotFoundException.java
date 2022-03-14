package fr.univlittoral.dlabs.exceptions;

public class DealNotFoundException extends RuntimeException {

    public DealNotFoundException(Integer id) {
        super("Could not find deal with id=" + id);
    }
}