package com.jvirriel.demo.frontend.core.views.navigator;

/**
 * NavigationType:
 * <p>
 * Creado por bpena el 27/04/2017.
 */
public class NavigationType {
    public static final String CREATE = "create";
    public static final String EDIT = "edit";
    public static final String DETAIL = "detail";
    public static final String LIST = "list";
    public static final String FILTER = "filter";

    public static String parse(String type) {
        return type.toLowerCase();
    }
}
