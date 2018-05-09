package com.jvirriel.demo.frontend.components.core;

import com.vaadin.data.HasValue;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.TextField;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo Textfield.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/TextField.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public final class TextFieldBuilder {
    /**
     * delegate
     */
    private final TextField textField;
    /**
     * Hide constructor, use static factory methods.
     */
    private TextFieldBuilder(final TextField textField) {
        this.textField = textField;
    }
    /**
     * @return
     *         the created instance
     */
    public final TextField get() {
        return textField;
    }

    public static TextFieldBuilder textField() {
        return new TextFieldBuilder(new TextField());
    }

    public static TextFieldBuilder textField(final String caption) {
        return new TextFieldBuilder(new TextField(caption));
    }

    public static TextFieldBuilder textField(final HasValue.ValueChangeListener<String> valueChangeListener) {
        return new TextFieldBuilder(new TextField(valueChangeListener));
    }

    public static TextFieldBuilder textField(final String caption, HasValue.ValueChangeListener<String>
            valueChangeListener) {
        return new TextFieldBuilder(new TextField(caption, valueChangeListener));
    }

    public static TextFieldBuilder textField(final String caption, final String value) {
        return new TextFieldBuilder(new TextField(caption, value));
    }

    public static TextFieldBuilder textField(final String caption, final String value,
                                             HasValue.ValueChangeListener<String> valueChangeListener) {
        return new TextFieldBuilder(new TextField(caption, valueChangeListener));
    }

    public TextFieldBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            textField.addAttachListener(attachListener);
        }
        return this;
    }

    public TextFieldBuilder addBlurListener(final com.vaadin.event.FieldEvents.BlurListener... blurListeners) {
        for (final com.vaadin.event.FieldEvents.BlurListener blurListener : blurListeners) {
            textField.addBlurListener(blurListener);
        }
        return this;
    }

    public TextFieldBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            textField.addDetachListener(detachListener);
        }
        return this;
    }

    public TextFieldBuilder addFocusListener(final com.vaadin.event.FieldEvents.FocusListener... focusListeners) {
        for (final com.vaadin.event.FieldEvents.FocusListener focusListener : focusListeners) {
            textField.addFocusListener(focusListener);
        }
        return this;
    }

    public TextFieldBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            textField.addListener(listener);
        }
        return this;
    }

    public TextFieldBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            textField.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public TextFieldBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            textField.addStyleName(styleName);
        }
        return this;
    }

    public TextFieldBuilder setCaption(final String caption) {
        textField.setCaption(caption);
        return this;
    }

    public TextFieldBuilder setComponentError(final ErrorMessage componentError) {
        textField.setComponentError(componentError);
        return this;
    }

    public TextFieldBuilder setCursorPosition(final int cursorPosition) {
        textField.setCursorPosition(cursorPosition);
        return this;
    }

    public TextFieldBuilder setData(final Object data) {
        textField.setData(data);
        return this;
    }

    public TextFieldBuilder setDescription(final String description) {
        textField.setDescription(description);
        return this;
    }

    public TextFieldBuilder setEnabled(final boolean enabled) {
        textField.setEnabled(enabled);
        return this;
    }

    public TextFieldBuilder setErrorHandler(final ErrorHandler errorHandler) {
        textField.setErrorHandler(errorHandler);
        return this;
    }

    public TextFieldBuilder setHeight(final String height) {
        textField.setHeight(height);
        return this;
    }

    public TextFieldBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        textField.setHeight(height, unit);
        return this;
    }

    public TextFieldBuilder setIcon(final Resource icon) {
        textField.setIcon(icon);
        return this;
    }

    public TextFieldBuilder setPlaceholder(final String placeholder) {
        textField.setPlaceholder(placeholder);
        return this;
    }

    public TextFieldBuilder setLocale(final Locale locale) {
        textField.setLocale(locale);
        return this;
    }

    public TextFieldBuilder setMaxLength(final int maxLength) {
        textField.setMaxLength(maxLength);
        return this;
    }

    public TextFieldBuilder setPrimaryStyleName(final String primaryStyleName) {
        textField.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public TextFieldBuilder setReadOnly(final boolean readOnly) {
        textField.setReadOnly(readOnly);
        return this;
    }

    public TextFieldBuilder setStyleName(final String styleName) {
        textField.setStyleName(styleName);
        return this;
    }

    public TextFieldBuilder setStyleName(final String styleName, final boolean add) {
        textField.setStyleName(styleName, add);
        return this;
    }

    public TextFieldBuilder setTabIndex(final int tabIndex) {
        textField.setTabIndex(tabIndex);
        return this;
    }

    public TextFieldBuilder setValue(final String value) {
        textField.setValue(value);
        return this;
    }

    public TextFieldBuilder setVisible(final boolean visible) {
        textField.setVisible(visible);
        return this;
    }

    public TextFieldBuilder setWidth(final String width) {
        textField.setWidth(width);
        return this;
    }

    public TextFieldBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        textField.setWidth(width, unit);
        return this;
    }
}