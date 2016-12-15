package ru.test.api.exceptions;

/**
 * Created by tikhonin on 04.04.2016.
 */
public class AxiCreditException extends Exception {
    private static final long serialVersionUID = -3795047940484838869L;

    public AxiCreditException(String message) {
        super(message);
    }
    public AxiCreditException(Throwable cause) {
        super(cause);
    }

    public AxiCreditException(String message, Throwable cause) {
        super(message, cause);
    }

}
