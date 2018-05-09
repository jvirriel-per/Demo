package com.jvirriel.demo.frontend.components.core;


import com.vaadin.event.FieldEvents;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/Button.html">Button</a>

 */
public final class ButtonBuilder {

    /**
     * delegate
     */
    private final Button button;

    /**
     * Hide constructor, use static factory methods.
     */
    private ButtonBuilder(final Button button) {
        this.button = button;
    }

    /**
     * @return the created instance
     */
    public final Button get() {
        return button;
    }

    /**
     * Construye el button sin nada.
     *
     * @return button sin caption o icono
     */
    public static ButtonBuilder button() {
        return new ButtonBuilder(new Button());
    }

    public static ButtonBuilder button(final Resource icon) {
        return new ButtonBuilder(new Button(icon));
    }

    public static ButtonBuilder button(final String caption) {
        return new ButtonBuilder(new Button(caption));
    }

    public static ButtonBuilder button(final String caption, final Resource icon) {
        return new ButtonBuilder(new Button(caption, icon));
    }

    public static ButtonBuilder button(String caption, Button.ClickListener listener) {
        return new ButtonBuilder(new Button(caption, listener));
    }

    public ButtonBuilder addClickListener(final Button.ClickListener listener) {
        button.addClickListener(listener);
        return this;
    }

    public ButtonBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            button.addAttachListener(attachListener);
        }
        return this;
    }

    public ButtonBuilder addBlurListener(final FieldEvents.BlurListener listener) {
        button.addBlurListener(listener);
        return this;
    }

    public ButtonBuilder addFocusListener(final FieldEvents.FocusListener listener) {
        button.addFocusListener(listener);
        return this;
    }

    public ButtonBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            button.addStyleName(styleName);
        }
        return this;
    }

    public ButtonBuilder setTabIndex(final int tabIndex) {
        button.setTabIndex(tabIndex);
        return this;
    }

    public ButtonBuilder setWidth(final String width) {
        button.setWidth(width);
        return this;
    }

    public ButtonBuilder setHeight(final String height) {
        button.setHeight(height);
        return this;
    }

    public ButtonBuilder setEnabled(final boolean enabled) {
        button.setEnabled(enabled);
        return this;
    }

    public ButtonBuilder setPrimaryStyleName(final String primaryStyleName) {
        button.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public ButtonBuilder setIcon(final Resource icon, final String iconAltText) {
        button.setIcon(icon, iconAltText);
        return this;
    }

    public ButtonBuilder setVisible(final boolean visible) {
        button.setVisible(visible);
        return this;
    }

    public ButtonBuilder setSizeUndefined() {
        button.setSizeUndefined();
        return this;
    }

    public ButtonBuilder setStyleName(final String styleName) {
        button.setStyleName(styleName);
        return this;
    }

    public ButtonBuilder setClickShortcut(final int keyCode, final int... modifiers) {
        button.setClickShortcut(keyCode, modifiers);
        return this;
    }

    public ButtonBuilder setDisableOnClick(boolean disableOnClick) {
        button.setDisableOnClick(disableOnClick);
        return this;
    }

    public ButtonBuilder setWidthInSizeUnit(final float width, Sizeable.Unit unit) {
        button.setWidth(width, unit);
        return this;
    }

    public ButtonBuilder setCaptionAsHtml(final boolean captionAsHtml) {
        button.setCaptionAsHtml(captionAsHtml);
        return this;
    }

    public ButtonBuilder setResponsive(final boolean reponsive) {
        button.setResponsive(reponsive);
        return this;
    }

}