package ru.test.api.exceptions;

/**
 * Created by tikhonin on 15.02.2016.
 */
public class ExternalSystemCryptoException extends Exception {
    private static final long serialVersionUID = -2053774630127980461L;

    public ExternalSystemCryptoException(String message) {
        super(message);
    }
    public ExternalSystemCryptoException(Throwable cause) {
        super(cause);
    }

    public ExternalSystemCryptoException(String message, Throwable cause) {
        super(message, cause);
    }

}
