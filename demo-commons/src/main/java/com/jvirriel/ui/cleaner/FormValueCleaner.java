package com.jvirriel.ui.cleaner;

import com.vaadin.data.HasValue;

public class FormValueCleaner {
    public static void clean(HasValue ... values) {
        for (HasValue value :
                values) {
            value.clear();
        }
    }
}
