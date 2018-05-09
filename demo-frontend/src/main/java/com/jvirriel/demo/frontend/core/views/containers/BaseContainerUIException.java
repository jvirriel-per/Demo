package com.jvirriel.demo.frontend.core.views.containers;

/**
 * BaseContainerUIException:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public class BaseContainerUIException extends RuntimeException {
    public BaseContainerUIException() {
    }

    public BaseContainerUIException(String message) {
        super(message);
    }

    public BaseContainerUIException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseContainerUIException(Throwable cause) {
        super(cause);
    }

    public BaseContainerUIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
