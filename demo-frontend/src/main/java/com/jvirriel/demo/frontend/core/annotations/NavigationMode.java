package com.jvirriel.demo.frontend.core.annotations;

public enum NavigationMode {
    NEW,
    EDIT,
    DETAIL,
    LIST;

    public Boolean equals(String navMode) {
        return this.name().equals(navMode.toUpperCase());
    }

    public Boolean equals(NavigationMode navMode) {
        return this.name().equals(navMode.name());
    }
}