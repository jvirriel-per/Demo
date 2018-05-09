package com.jvirriel.demo.frontend.components.core;


import com.vaadin.event.FieldEvents;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo Accordion.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/Accordion.html">documentación de referencia</a> en la página
 * de Vaadin.

 */

public class AccordionBuilder {

    private final Accordion accordion;

    private AccordionBuilder(final Accordion accordion) {
        this.accordion = accordion;
    }

    public Accordion get() {
        return accordion;
    }

    public static AccordionBuilder accordion() {
        return new AccordionBuilder(new Accordion());
    }

    public static AccordionBuilder accordion(Component... components) {
        return new AccordionBuilder(new Accordion(components));
    }

    public AccordionBuilder addBlurListener(FieldEvents.BlurListener listener) {
        accordion.addBlurListener(listener);
        return this;
    }

    public AccordionBuilder addComponents(Component... components) {
        accordion.addComponents(components);
        return this;
    }

    public AccordionBuilder addFocusListener(FieldEvents.FocusListener listener) {
        accordion.addFocusListener(listener);
        return this;
    }

    public AccordionBuilder addSelectedTabChangeListener(TabSheet.SelectedTabChangeListener listener) {
        accordion.addSelectedTabChangeListener(listener);
        return this;
    }

    public AccordionBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            accordion.addStyleName(styleName);
        }
        return this;
    }

    public AccordionBuilder addTab(Component c) {
        accordion.addTab(c);
        return this;
    }

    public AccordionBuilder addTab(Component c, int position) {
        accordion.addTab(c, position);
        return this;
    }

    public AccordionBuilder addTab(Component c, String caption) {
        accordion.addTab(c, caption);
        return this;
    }

    public AccordionBuilder addTab(Component c, String caption, Resource icon) {
        accordion.addTab(c, caption);
        return this;
    }

    public AccordionBuilder addTab(Component c, String caption, Resource icon, int position) {
        accordion.addTab(c, caption, icon, position);
        return this;
    }

    public AccordionBuilder setCaption(final String caption) {
        accordion.setCaption(caption);
        return this;
    }

    public AccordionBuilder setCloseHandler(TabSheet.CloseHandler handler) {
        accordion.setCloseHandler(handler);
        return this;
    }

    public AccordionBuilder setEnabled(final boolean enabled) {
        accordion.setEnabled(enabled);
        return this;
    }

    public AccordionBuilder setHeight(final String height) {
        accordion.setHeight(height);
        return this;
    }

    public AccordionBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        accordion.setHeight(height, unit);
        return this;
    }


    public AccordionBuilder setPrimaryStyleName(final String primaryStyleName) {
        accordion.setPrimaryStyleName(primaryStyleName);
        return this;
    }


    public AccordionBuilder setResponsive(final boolean responsive) {
        accordion.setResponsive(responsive);
        return this;
    }

    public AccordionBuilder setSelectedTab(int position) {
        accordion.setSelectedTab(position);
        return this;
    }

    public AccordionBuilder setSelectedTab(TabSheet.Tab tab) {
        accordion.setSelectedTab(tab);
        return this;
    }

    public AccordionBuilder setSizeFull() {
        accordion.setSizeFull();
        return this;
    }

    public AccordionBuilder setStyleName(final String styleName) {
        accordion.setStyleName(styleName);
        return this;
    }

    public AccordionBuilder setStyleName(final String styleName, final boolean add) {
        accordion.setStyleName(styleName, add);
        return this;
    }

    public AccordionBuilder setTabCaptionsAsHtml(boolean tabCaptionsAsHtml) {
        accordion.setTabCaptionsAsHtml(tabCaptionsAsHtml);
        return this;
    }

    public AccordionBuilder setTabsVisible(boolean tabsVisible) {
        accordion.setTabsVisible(tabsVisible);
        return this;
    }

    public AccordionBuilder setVisible(final boolean visible) {
        accordion.setVisible(visible);
        return this;
    }

    public AccordionBuilder setWidth(final String width) {
        accordion.setWidth(width);
        return this;
    }

    public AccordionBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        accordion.setWidth(width, unit);
        return this;
    }

}