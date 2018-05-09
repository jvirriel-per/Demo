package com.jvirriel.demo.frontend.components.core;

import com.vaadin.data.HasValue;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.PasswordField;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo Password Field.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/PasswordField.html">documentación de referencia</a> en la página
 * de Vaadin.
 * <p>
 */
public class PasswordFieldBuilder {
    /**
     * delegate
     */
    private final PasswordField passwordField;

    /**
     * Hide constructor, use static factory methods.
     */
    private PasswordFieldBuilder(final PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * @return the created instance
     */
    public final PasswordField get() {
        return passwordField;
    }

    public static PasswordFieldBuilder passwordField() {
        return new PasswordFieldBuilder(new PasswordField());
    }

    public static PasswordFieldBuilder passwordField(final String caption) {
        return new PasswordFieldBuilder(new PasswordField(caption));
    }

    public static PasswordFieldBuilder passwordField(final HasValue.ValueChangeListener<String> valueChangeListener) {
        return new PasswordFieldBuilder(new PasswordField(valueChangeListener));
    }

    public static PasswordFieldBuilder passwordField(final String caption, HasValue.ValueChangeListener<String>
            valueChangeListener) {
        return new PasswordFieldBuilder(new PasswordField(caption, valueChangeListener));
    }

    public static PasswordFieldBuilder passwordField(final String caption, final String value) {
        return new PasswordFieldBuilder(new PasswordField(caption, value));
    }

    public static PasswordFieldBuilder passwordField(final String caption, final String value,
                                                     HasValue.ValueChangeListener<String> valueChangeListener) {
        return new PasswordFieldBuilder(new PasswordField(caption, valueChangeListener));
    }

    public PasswordFieldBuilder addBlurListener(final com.vaadin.event.FieldEvents.BlurListener... blurListeners) {
        for (final com.vaadin.event.FieldEvents.BlurListener blurListener : blurListeners) {
            passwordField.addBlurListener(blurListener);
        }
        return this;
    }

    public PasswordFieldBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            passwordField.addDetachListener(detachListener);
        }
        return this;
    }

    public PasswordFieldBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            passwordField.addListener(listener);
        }
        return this;
    }

    public PasswordFieldBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            passwordField.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public PasswordFieldBuilder addFocusListener(final com.vaadin.event.FieldEvents.FocusListener... focusListeners) {
        for (final com.vaadin.event.FieldEvents.FocusListener focusListener : focusListeners) {
            passwordField.addFocusListener(focusListener);
        }
        return this;
    }

    public PasswordFieldBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            passwordField.addStyleName(styleName);
        }
        return this;
    }

    public PasswordFieldBuilder setCaption(final String caption) {
        passwordField.setCaption(caption);
        return this;
    }

    public PasswordFieldBuilder setDescription(final String description) {
        passwordField.setDescription(description);
        return this;
    }

    public PasswordFieldBuilder setPlaceholder(final String placeholder) {
        passwordField.setPlaceholder(placeholder);
        return this;
    }

    public PasswordFieldBuilder setEnabled(final boolean enabled) {
        passwordField.setEnabled(enabled);
        return this;
    }

    public PasswordFieldBuilder setHeight(final String height) {
        passwordField.setHeight(height);
        return this;
    }

    public PasswordFieldBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        passwordField.setHeight(height, unit);
        return this;
    }

    public PasswordFieldBuilder setIcon(final Resource icon) {
        passwordField.setIcon(icon);
        return this;
    }

    public PasswordFieldBuilder setMaxLength(final int maxLength) {
        passwordField.setMaxLength(maxLength);
        return this;
    }

    public PasswordFieldBuilder setPrimaryStyleName(final String primaryStyleName) {
        passwordField.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public PasswordFieldBuilder setReadOnly(final boolean readOnly) {
        passwordField.setReadOnly(readOnly);
        return this;
    }

    public PasswordFieldBuilder setStyleName(final String styleName) {
        passwordField.setStyleName(styleName);
        return this;
    }

    public PasswordFieldBuilder setStyleName(final String styleName, final boolean add) {
        passwordField.setStyleName(styleName, add);
        return this;
    }

    public PasswordFieldBuilder setValue(final String value) {
        passwordField.setValue(value);
        return this;
    }

    public PasswordFieldBuilder setVisible(final boolean visible) {
        passwordField.setVisible(visible);
        return this;
    }

    public PasswordFieldBuilder setWidth(final String width) {
        passwordField.setWidth(width);
        return this;
    }

    public PasswordFieldBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        passwordField.setWidth(width, unit);
        return this;
    }
}