package ru.test.api.exceptions;

/**
 * Created by tikhonin on 29.01.2016.
 */
public class ExternalSystemException extends Exception {
    private static final long serialVersionUID = -1284686822871463228L;

    public ExternalSystemException(String message) {
        super(message);
    }
    public ExternalSystemException(Throwable cause) {
        super(cause);
    }

    public ExternalSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
