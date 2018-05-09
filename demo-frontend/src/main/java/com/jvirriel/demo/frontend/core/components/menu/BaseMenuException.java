package com.jvirriel.demo.frontend.core.components.menu;

/**
 * BaseMenuException:
 * <p>
 * Creado por bpena el 28/04/2017.
 */
public class BaseMenuException extends RuntimeException {
    public BaseMenuException() {
    }

    public BaseMenuException(String message) {
        super(message);
    }

    public BaseMenuException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseMenuException(Throwable cause) {
        super(cause);
    }

    public BaseMenuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
