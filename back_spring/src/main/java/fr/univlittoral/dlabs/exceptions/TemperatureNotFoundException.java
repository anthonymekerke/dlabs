package fr.univlittoral.dlabs.exceptions;

public class TemperatureNotFoundException extends RuntimeException {

    public TemperatureNotFoundException(Integer id) {
        super("Could not find temperature with id=" + id);
    }
}