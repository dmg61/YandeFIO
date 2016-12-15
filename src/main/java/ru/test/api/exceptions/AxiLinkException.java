package ru.test.api.exceptions;

/**
 * Created by tikhonin on 29.01.2016.
 */
public class AxiLinkException extends Exception {
    private static final long serialVersionUID = -1149557526731611980L;

    public AxiLinkException(String message) {
        super(message);
    }
    public AxiLinkException(Throwable cause) {
        super(cause);
    }

    public AxiLinkException(String message, Throwable cause) {
        super(message, cause);
    }
}