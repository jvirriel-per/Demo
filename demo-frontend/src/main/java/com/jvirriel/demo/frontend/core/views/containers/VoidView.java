package com.jvirriel.demo.frontend.core.views.containers;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;

/**
 * VoidView: Vista vacia, se utilizara para que el navigator la use como vista predeterminada,
 * en caso de no tener una vista principal.
 * Creado por bpena el 27/04/2017.
 */
public class VoidView extends VerticalLayout implements View {
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
