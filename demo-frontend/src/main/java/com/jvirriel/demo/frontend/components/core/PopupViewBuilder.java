package com.jvirriel.demo.frontend.components.core;

import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.PopupView;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo PopupView.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/PopupView.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public class PopupViewBuilder {

    private final PopupView popupView;

    private PopupViewBuilder(final PopupView $attribute) {
        this.popupView = $attribute;
    }

    public PopupView get() {
        return popupView;
    }

    public static PopupViewBuilder popupView(PopupView.Content content) {
        return new PopupViewBuilder(new PopupView(content));
    }

    public static PopupViewBuilder popupView(String small, Component large) {
        return new PopupViewBuilder(new PopupView(small, large));
    }

    public PopupViewBuilder addPopupVisibilityListener(PopupView.PopupVisibilityListener listener) {
        popupView.addPopupVisibilityListener(listener);
        return this;
    }

    public PopupViewBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            popupView.addStyleName(styleName);
        }
        return this;
    }

    public PopupViewBuilder beforeClientResponse(final boolean initial) {
        popupView.beforeClientResponse(initial);
        return this;
    }

    public PopupViewBuilder setCaption(final String caption) {
        popupView.setCaption(caption);
        return this;
    }

    public PopupViewBuilder setEnabled(final boolean enabled) {
        popupView.setEnabled(enabled);
        return this;
    }

    public PopupViewBuilder setHeight(final String height) {
        popupView.setHeight(height);
        return this;
    }

    public PopupViewBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        popupView.setHeight(height, unit);
        return this;
    }

    public PopupViewBuilder setHideOnMouseOut(final boolean hideOnMouseOut) {
        popupView.setHideOnMouseOut(hideOnMouseOut);
        return this;
    }

    public PopupViewBuilder setIcon(final Resource icon) {
        popupView.setIcon(icon);
        return this;
    }

    public PopupViewBuilder setPopupVisible(final boolean visible) {
        popupView.setPopupVisible(visible);
        return this;
    }

    public PopupViewBuilder setPrimaryStyleName(final String primaryStyleName) {
        popupView.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public PopupViewBuilder setResponsive(final boolean responsive) {
        popupView.setResponsive(responsive);
        return this;
    }

    public PopupViewBuilder setSizeFull() {
        popupView.setSizeFull();
        return this;
    }

    public PopupViewBuilder setStyleName(final String styleName) {
        popupView.setStyleName(styleName);
        return this;
    }

    public PopupViewBuilder setStyleName(final String styleName, final boolean add) {
        popupView.setStyleName(styleName, add);
        return this;
    }

    public PopupViewBuilder setVisible(final boolean visible) {
        popupView.setVisible(visible);
        return this;
    }

    public PopupViewBuilder setWidth(final String width) {
        popupView.setWidth(width);
        return this;
    }

    public PopupViewBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        popupView.setWidth(width, unit);
        return this;
    }
}
