package com.jvirriel.demo.frontend.core.views;

/**
 * ViewMode:
 * <p>
 * Creado por bpena el 25/04/2017.
 */
public enum ViewMode {
    LIST,
    BROWSE,
    DETAIL,
    EDIT;

    public Boolean equals(String viewMode) {
        return this.name().equals(viewMode.toUpperCase());
    }

    public Boolean equals(ViewMode viewMode) {
        return this.name().equals(viewMode.name());
    }
}
