package ru.test.api.exceptions;

/**
 * Created by tikhonin on 07.04.2016.
 */
public class AxiCreditIOException extends Exception {
    private static final long serialVersionUID = -7478000568874252859L;

    public AxiCreditIOException(String message) {
        super(message);
    }
    public AxiCreditIOException(Throwable cause) {
        super(cause);
    }

    public AxiCreditIOException(String message, Throwable cause) {
        super(message, cause);
    }

}
