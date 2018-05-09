package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import org.vaadin.teemu.switchui.Switch;
/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/CheckBox.html">SwitchButton</a>
 */
public class SwitchButtonBuilder {

    private final Switch sw;

    public SwitchButtonBuilder(Switch sw) {
        this.sw = sw;
    }

    public final Switch get() {
        return sw;
    }

    public static SwitchButtonBuilder switchButton() {
        return new SwitchButtonBuilder(new Switch());
    }

    public static SwitchButtonBuilder switchButton(String caption) {
        return new SwitchButtonBuilder(new Switch(caption));
    }

    public static SwitchButtonBuilder switchButton(final String caption, final boolean initialState) {
        return new SwitchButtonBuilder(new Switch(caption, initialState));
    }

    public SwitchButtonBuilder addBlurListener(final com.vaadin.event.FieldEvents.BlurListener... blurListeners) {
        for (final com.vaadin.event.FieldEvents.BlurListener blurListener : blurListeners) {
            sw.addBlurListener(blurListener);
        }
        return this;
    }

    public SwitchButtonBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            sw.addDetachListener(detachListener);
        }
        return this;
    }

    public SwitchButtonBuilder addFocusListener(final com.vaadin.event.FieldEvents.FocusListener... focusListeners) {
        for (final com.vaadin.event.FieldEvents.FocusListener focusListener : focusListeners) {
            sw.addFocusListener(focusListener);
        }
        return this;
    }

    public SwitchButtonBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            sw.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public SwitchButtonBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            sw.addStyleName(styleName);
        }
        return this;
    }


    public SwitchButtonBuilder setCaption(final String caption) {
        sw.setCaption(caption);
        return this;
    }

    public SwitchButtonBuilder setComponentError(final ErrorMessage componentError) {
        sw.setComponentError(componentError);
        return this;
    }


    public SwitchButtonBuilder setDescription(final String description) {
        sw.setDescription(description);
        return this;
    }

    public SwitchButtonBuilder setEnabled(final boolean enabled) {
        sw.setEnabled(enabled);
        return this;
    }

    public SwitchButtonBuilder setErrorHandler(final ErrorHandler errorHandler) {
        sw.setErrorHandler(errorHandler);
        return this;
    }

    public SwitchButtonBuilder setHeight(final String height) {
        sw.setHeight(height);
        return this;
    }

    public SwitchButtonBuilder setHeight(final float height, Sizeable.Unit unit) {
        sw.setHeight(height, unit);
        return this;
    }

    public SwitchButtonBuilder setIcon(final Resource icon) {
        sw.setIcon(icon);
        return this;
    }


    public SwitchButtonBuilder setPrimaryStyleName(final String primaryStyleName) {
        sw.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public SwitchButtonBuilder setReadOnly(final boolean readOnly) {
        sw.setReadOnly(readOnly);
        return this;
    }


    public SwitchButtonBuilder setResponsive(final boolean responsive) {
        sw.setResponsive(responsive);
        return this;
    }

    public SwitchButtonBuilder setStyleName(final String styleName) {
        sw.setStyleName(styleName);
        return this;
    }

    public SwitchButtonBuilder setStyleName(String style, boolean add) {
        sw.setStyleName(style, add);
        return this;
    }

    public SwitchButtonBuilder setValue(final boolean value) {
        sw.setValue(value);
        return this;
    }

    public SwitchButtonBuilder setVisible(final boolean visible) {
        sw.setVisible(visible);
        return this;
    }

    public SwitchButtonBuilder setWidth(final String width) {
        sw.setWidth(width);
        return this;
    }

    public SwitchButtonBuilder setWidth(final float width, Sizeable.Unit unit) {
        sw.setWidth(width, unit);
        return this;
    }
}