package com.jvirriel.demo.frontend.core.views.main;

import com.pt.base.core.annotations.FunctionalityMode;

/**
 * ViewEvent:
 * <p>
 * Creado por bpena el 12/05/2017.
 */
public class ViewEvent {
    private FunctionalityMode mode;

    public ViewEvent(FunctionalityMode mode) {
        this.mode = mode;
    }

    public FunctionalityMode getMode() {
        return mode;
    }

    public ViewEvent setMode(FunctionalityMode mode) {
        this.mode = mode;
        return this;
    }
}
