package com.jvirriel.demo.frontend.components.core;

import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo TabSheet.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/TabSheet.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public class TabSheetBuilder {

    private final TabSheet tabSheet;

    private TabSheetBuilder(final TabSheet tabSheet) {
        this.tabSheet = tabSheet;
    }

    public TabSheet get() {
        return tabSheet;
    }

    public static TabSheetBuilder tabSheet() {
        return new TabSheetBuilder(new TabSheet());
    }

    public static TabSheetBuilder tabSheet(Component... components) {
        return new TabSheetBuilder(new TabSheet(components));
    }

    public TabSheetBuilder addComponents(Component... components) {
        tabSheet.addComponents(components);
        return this;
    }

    public TabSheetBuilder addFocusListener(com.vaadin.event.FieldEvents.FocusListener listener) {
        tabSheet.addFocusListener(listener);
        return this;
    }

    public TabSheetBuilder addSelectedTabChangeListener(TabSheet.SelectedTabChangeListener listener) {
        tabSheet.addSelectedTabChangeListener(listener);
        return this;
    }

    public TabSheetBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            tabSheet.addStyleName(styleName);
        }
        return this;
    }

    public TabSheetBuilder addTab(Component c) {
        tabSheet.addTab(c);
        return this;
    }

    public TabSheetBuilder addTab(Component c, int position) {
        tabSheet.addTab(c, position);
        return this;
    }

    public TabSheetBuilder addTab(Component c, String caption) {
        tabSheet.addTab(c, caption);
        return this;
    }

    public TabSheetBuilder addTab(Component c, String caption, Resource icon) {
        tabSheet.addTab(c, caption);
        return this;
    }

    public TabSheetBuilder addTab(Component c, String caption, Resource icon, int position) {
        tabSheet.addTab(c, caption, icon, position);
        return this;
    }

    public TabSheetBuilder setCaption(final String caption) {
        tabSheet.setCaption(caption);
        return this;
    }

    public TabSheetBuilder setCloseHandler(TabSheet.CloseHandler handler) {
        tabSheet.setCloseHandler(handler);
        return this;
    }

    public TabSheetBuilder setEnabled(final boolean enabled) {
        tabSheet.setEnabled(enabled);
        return this;
    }

    public TabSheetBuilder setHeight(final String height) {
        tabSheet.setHeight(height);
        return this;
    }

    public TabSheetBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        tabSheet.setHeight(height, unit);
        return this;
    }

    public TabSheetBuilder setPrimaryStyleName(final String primaryStyleName) {
        tabSheet.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public TabSheetBuilder setResponsive(final boolean responsive) {
        tabSheet.setResponsive(responsive);
        return this;
    }

    public TabSheetBuilder setSelectedTab(int position) {
        tabSheet.setSelectedTab(position);
        return this;
    }

    public TabSheetBuilder setSelectedTab(TabSheet.Tab tab) {
        tabSheet.setSelectedTab(tab);
        return this;
    }

    public TabSheetBuilder setSizeFull() {
        tabSheet.setSizeFull();
        return this;
    }

    public TabSheetBuilder setStyleName(final String styleName) {
        tabSheet.setStyleName(styleName);
        return this;
    }

    public TabSheetBuilder setStyleName(final String styleName, final boolean add) {
        tabSheet.setStyleName(styleName, add);
        return this;
    }

    public TabSheetBuilder setTabCaptionsAsHtml(boolean tabCaptionsAsHtml) {
        tabSheet.setTabCaptionsAsHtml(tabCaptionsAsHtml);
        return this;
    }

    public TabSheetBuilder setTabsVisible(boolean tabsVisible) {
        tabSheet.setTabsVisible(tabsVisible);
        return this;
    }

    public TabSheetBuilder setVisible(final boolean visible) {
        tabSheet.setVisible(visible);
        return this;
    }

    public TabSheetBuilder setWidth(final String width) {
        tabSheet.setWidth(width);
        return this;
    }

    public TabSheetBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        tabSheet.setWidth(width, unit);
        return this;
    }
}