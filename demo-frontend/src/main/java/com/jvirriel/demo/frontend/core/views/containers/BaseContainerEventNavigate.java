package com.jvirriel.demo.frontend.core.views.containers;

/**
 * BaseContainerEventNavigate:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public class BaseContainerEventNavigate {
    private String uriApp;

    public BaseContainerEventNavigate(String uriApp) {
        if (uriApp == null || uriApp.isEmpty())
            throw new BaseContainerUIException("ViewName must be defined on BaseContainerEventNavigate");
        this.uriApp = uriApp;
    }

    public String getUriApp() {
        return uriApp;
    }

    public BaseContainerEventNavigate setUriApp(String uriApp) {
        this.uriApp = uriApp;
        return this;
    }
}
