package com.jvirriel.demo.frontend.components.core;

import org.vaadin.hene.popupbutton.PopupButton;

import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;

/**
 * Clase <i>Builder</i> para crear un componente add-on de Vaadin del tipo PopupButton.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/directory#!addon/popupbutton">documentación de referencia</a> en la página
 * del directorios de add-on´s de Vaadin.
 * <p>
 */
public class PopupButtonBuilder {

    private final PopupButton popupButton;

    private PopupButtonBuilder(final PopupButton popupButton) {
        this.popupButton = popupButton;
    }

    public PopupButton get() {
        return popupButton;
    }

    public static PopupButtonBuilder popupButton() {
        return new PopupButtonBuilder(new PopupButton(""));
    }

    public static PopupButtonBuilder popupButton(final String caption) {
        return new PopupButtonBuilder(new PopupButton(caption));
    }

    public PopupButtonBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            popupButton.addStyleName(styleName);
        }
        return this;
    }

    public PopupButtonBuilder setCaption(final String caption) {
        popupButton.setCaption(caption);
        return this;
    }

    /**
     * If true, clicking on outside the popup closes it. Note that
     * this doesn't affect clicking on the button itself.
     * <p>
     * Default is true.
     *
     * @param closePopupOnOutsideClick set if pop up will be closed by clicking outside
     * @return current Builder object
     */
    public PopupButtonBuilder setClosePopupOnOutsideClick(final boolean closePopupOnOutsideClick) {
        popupButton.setClosePopupOnOutsideClick(closePopupOnOutsideClick);
        return this;
    }

    public PopupButtonBuilder setContent(final Component content) {
        popupButton.setContent(content);
        return this;
    }

    /**
     * Sets opening direction for the popup. At the moment only support values are
     * {@link Alignment#BOTTOM_LEFT}, {@link Alignment#BOTTOM_CENTER} and
     * {@link Alignment#BOTTOM_RIGHT}.
     * <p>
     * Default is {@link Alignment#BOTTOM_RIGHT}.
     */
    public PopupButtonBuilder setDirection(final Alignment direction) {
        popupButton.setDirection(direction);
        return this;
    }

    public PopupButtonBuilder setEnabled(final boolean enabled) {
        popupButton.setEnabled(enabled);
        return this;
    }

    public PopupButtonBuilder setHeight(final String height) {
        popupButton.setHeight(height);
        return this;
    }

    public PopupButtonBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        popupButton.setHeight(height, unit);
        return this;
    }

    public PopupButtonBuilder setIcon(final Resource icon) {
        popupButton.setIcon(icon);
        return this;
    }

    public PopupButtonBuilder setPopupVisible(final boolean visible) {
        popupButton.setPopupVisible(visible);
        return this;
    }

    public PopupButtonBuilder setPrimaryStyleName(final String primaryStyleName) {
        popupButton.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public PopupButtonBuilder setResponsive(final boolean responsive) {
        popupButton.setResponsive(responsive);
        return this;
    }

    public PopupButtonBuilder setSizeFull() {
        popupButton.setSizeFull();
        return this;
    }

    public PopupButtonBuilder setStyleName(final String styleName) {
        popupButton.setStyleName(styleName);
        return this;
    }

    public PopupButtonBuilder setStyleName(final String styleName, final boolean add) {
        popupButton.setStyleName(styleName, add);
        return this;
    }

    public PopupButtonBuilder setVisible(final boolean visible) {
        popupButton.setVisible(visible);
        return this;
    }

    public PopupButtonBuilder setWidth(final String width) {
        popupButton.setWidth(width);
        return this;
    }

    public PopupButtonBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        popupButton.setWidth(width, unit);
        return this;
    }
}