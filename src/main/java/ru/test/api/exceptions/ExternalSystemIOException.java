package ru.test.api.exceptions;

/**
 * Created by tikhonin on 29.01.2016.
 */
public class ExternalSystemIOException extends Exception {
    private static final long serialVersionUID = -401069888830088872L;

    public ExternalSystemIOException(String message) {
        super(message);
    }
    public ExternalSystemIOException(Throwable cause) {
        super(cause);
    }

    public ExternalSystemIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
