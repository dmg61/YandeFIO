package ru.test.api.exceptions;

/**
 * Created by tikhonin on 10.02.2016.
 */
public class ExternalSystemArgumentException extends Exception {
    private static final long serialVersionUID = 8455411551970694307L;

    public ExternalSystemArgumentException(String message) {
        super(message);
    }
    public ExternalSystemArgumentException(Throwable cause) {
        super(cause);
    }

    public ExternalSystemArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
