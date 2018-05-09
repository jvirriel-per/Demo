package com.jvirriel.demo.frontend.components.core;

import com.vaadin.data.HasValue;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.TextArea;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo TextArea.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/TextArea.html">documentación de referencia</a> en la página
 * de Vaadin.
 * <p>
 */
public final class TextAreaBuilder {

    /**
     * delegate
     */
    private final TextArea textArea;

    /**
     * Hide constructor, use static factory methods.
     */
    private TextAreaBuilder(final TextArea textArea) {
        this.textArea = textArea;
    }

    /**
     * @return the created instance
     */
    public final TextArea get() {
        return textArea;
    }

    public static TextAreaBuilder textArea(final String caption) {
        return new TextAreaBuilder(new TextArea(caption));
    }

    public static TextAreaBuilder textArea() {
        return new TextAreaBuilder(new TextArea());
    }

    public static TextAreaBuilder textArea(final HasValue.ValueChangeListener<String> valueChangeListener) {
        return new TextAreaBuilder(new TextArea(valueChangeListener));
    }

    public static TextAreaBuilder textArea(final String caption, final HasValue.ValueChangeListener<String>
            valueChangeListener) {
        return new TextAreaBuilder(new TextArea(caption, valueChangeListener));
    }

    public static TextAreaBuilder textArea(final String caption, final String value) {
        return new TextAreaBuilder(new TextArea(caption, value));
    }

    public static TextAreaBuilder textArea(final String caption, final String value, final
    HasValue.ValueChangeListener<String> valueChangeListener) {
        return new TextAreaBuilder(new TextArea(caption, value, valueChangeListener));
    }

    public TextAreaBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            textArea.addAttachListener(attachListener);
        }
        return this;
    }

    public TextAreaBuilder addBlurListener(final com.vaadin.event.FieldEvents.BlurListener... blurListeners) {
        for (final com.vaadin.event.FieldEvents.BlurListener blurListener : blurListeners) {
            textArea.addBlurListener(blurListener);
        }
        return this;
    }

    public TextAreaBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            textArea.addDetachListener(detachListener);
        }
        return this;
    }

    public TextAreaBuilder addFocusListener(final com.vaadin.event.FieldEvents.FocusListener... focusListeners) {
        for (final com.vaadin.event.FieldEvents.FocusListener focusListener : focusListeners) {
            textArea.addFocusListener(focusListener);
        }
        return this;
    }

    public TextAreaBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            textArea.addListener(listener);
        }
        return this;
    }

    public TextAreaBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            textArea.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public TextAreaBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            textArea.addStyleName(styleName);
        }
        return this;
    }

    public TextAreaBuilder setCaption(final String caption) {
        textArea.setCaption(caption);
        return this;
    }

    public TextAreaBuilder setComponentError(final ErrorMessage componentError) {
        textArea.setComponentError(componentError);
        return this;
    }

    public TextAreaBuilder setCursorPosition(final int cursorPosition) {
        textArea.setCursorPosition(cursorPosition);
        return this;
    }

    public TextAreaBuilder setData(final Object data) {
        textArea.setData(data);
        return this;
    }

    public TextAreaBuilder setDescription(final String description) {
        textArea.setDescription(description);
        return this;
    }

    public TextAreaBuilder setEnabled(final boolean enabled) {
        textArea.setEnabled(enabled);
        return this;
    }

    public TextAreaBuilder setErrorHandler(final ErrorHandler errorHandler) {
        textArea.setErrorHandler(errorHandler);
        return this;
    }

    public TextAreaBuilder setHeight(final String height) {
        textArea.setHeight(height);
        return this;
    }

    public TextAreaBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        textArea.setHeight(height, unit);
        return this;
    }

    public TextAreaBuilder setIcon(final Resource icon) {
        textArea.setIcon(icon);
        return this;
    }

    public TextAreaBuilder setLocale(final Locale locale) {
        textArea.setLocale(locale);
        return this;
    }

    public TextAreaBuilder setMaxLength(final int maxLength) {
        textArea.setMaxLength(maxLength);
        return this;
    }

    public TextAreaBuilder setPrimaryStyleName(final String primaryStyleName) {
        textArea.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public TextAreaBuilder setReadOnly(final boolean readOnly) {
        textArea.setReadOnly(readOnly);
        return this;
    }

    public TextAreaBuilder setRows(final int rows) {
        textArea.setRows(rows);
        return this;
    }

    public TextAreaBuilder setStyleName(final String styleName) {
        textArea.setStyleName(styleName);
        return this;
    }

    public TextAreaBuilder setStyleName(final String styleName, final boolean add) {
        textArea.setStyleName(styleName, add);
        return this;
    }

    public TextAreaBuilder setTabIndex(final int tabIndex) {
        textArea.setTabIndex(tabIndex);
        return this;
    }

    public TextAreaBuilder setValue(final String value) {
        textArea.setValue(value);
        return this;
    }

    public TextAreaBuilder setVisible(final boolean visible) {
        textArea.setVisible(visible);
        return this;
    }

    public TextAreaBuilder setWidth(final String width) {
        textArea.setWidth(width);
        return this;
    }

    public TextAreaBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        textArea.setWidth(width, unit);
        return this;
    }

}