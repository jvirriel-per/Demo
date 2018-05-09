package com.jvirriel.demo.frontend.components.core;

import com.vaadin.data.HasValue;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;

import java.time.LocalDate;
import java.util.Locale;

/**
 *  Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/DateField.html">DateField</a>
 *
 * Clase núcleo para el DateFieldBuilder nativo y todas sus propiedades.

 */
public class DateFieldBuilder {
    /**
     * delegate
     */
    private final com.vaadin.ui.DateField dateField;

    /**
     * Hide constructor, use static factory methods.
     */
    private DateFieldBuilder(final com.vaadin.ui.DateField dateField) {
        this.dateField = dateField;
    }

    /**
     * @return the created instance
     */
    public final com.vaadin.ui.DateField get() {
        return dateField;
    }

    public static DateFieldBuilder dateField() {
        return new DateFieldBuilder(new com.vaadin.ui.DateField());
    }

    public static DateFieldBuilder dateField(final HasValue.ValueChangeListener<LocalDate> valueChangeListener) {
        return new DateFieldBuilder(new com.vaadin.ui.DateField(valueChangeListener));
    }

    public static DateFieldBuilder dateField(final String caption) {
        return new DateFieldBuilder(new com.vaadin.ui.DateField(caption));
    }

    public static DateFieldBuilder dateField(final String caption, final HasValue.ValueChangeListener<LocalDate>
            valueChangeListener) {
        return new DateFieldBuilder(new com.vaadin.ui.DateField(caption, valueChangeListener));
    }

    public static DateFieldBuilder dateField(final String caption, final LocalDate value) {
        return new DateFieldBuilder(new com.vaadin.ui.DateField(caption, value));
    }

    public static DateFieldBuilder dateField(String caption, LocalDate value,
                                             HasValue.ValueChangeListener<LocalDate> valueChangeListener) {
        return new DateFieldBuilder(new com.vaadin.ui.DateField(caption, value, valueChangeListener));
    }

    public DateFieldBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            dateField.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public DateFieldBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            dateField.addListener(listener);
        }
        return this;
    }

    public DateFieldBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            dateField.addAttachListener(attachListener);
        }
        return this;
    }

    public DateFieldBuilder addFocusListener(final com.vaadin.event.FieldEvents.FocusListener... focusListeners) {
        for (final com.vaadin.event.FieldEvents.FocusListener focusListener : focusListeners) {
            dateField.addFocusListener(focusListener);
        }
        return this;
    }

    public DateFieldBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            dateField.addStyleName(styleName);
        }
        return this;
    }

    public DateFieldBuilder addBlurListener(final com.vaadin.event.FieldEvents.BlurListener... blurListeners) {
        for (final com.vaadin.event.FieldEvents.BlurListener blurListener : blurListeners) {
            dateField.addBlurListener(blurListener);
        }
        return this;
    }

    public DateFieldBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            dateField.addDetachListener(detachListener);
        }
        return this;
    }

    public DateFieldBuilder setWidth(final String width) {
        dateField.setWidth(width);
        return this;
    }

    public DateFieldBuilder setHeight(final String height) {
        dateField.setHeight(height);
        return this;
    }

    public DateFieldBuilder setEnabled(final boolean enabled) {
        dateField.setEnabled(enabled);
        return this;
    }

    public DateFieldBuilder setTabIndex(final int tabIndex) {
        dateField.setTabIndex(tabIndex);
        return this;
    }

    public DateFieldBuilder setLocale(final Locale locale) {
        dateField.setLocale(locale);
        return this;
    }

    public DateFieldBuilder setErrorHandler(final ErrorHandler errorHandler) {
        dateField.setErrorHandler(errorHandler);
        return this;
    }

    public DateFieldBuilder setData(final Object data) {
        dateField.setData(data);
        return this;
    }

    public DateFieldBuilder setComponentError(final ErrorMessage componentError) {
        dateField.setComponentError(componentError);
        return this;
    }

    public DateFieldBuilder setValue(final LocalDate value) {
        dateField.setValue(value);
        return this;
    }

    public DateFieldBuilder setPrimaryStyleName(final String primaryStyleName) {
        dateField.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public DateFieldBuilder setIcon(final Resource icon) {
        dateField.setIcon(icon);
        return this;
    }

    public DateFieldBuilder setShowISOWeekNumbers(final boolean ISOWeekNumbers) {
        dateField.setShowISOWeekNumbers(ISOWeekNumbers);
        return this;
    }

    public DateFieldBuilder setDescription(final String description) {
        dateField.setDescription(description);
        return this;
    }

    public DateFieldBuilder setReadOnly(final boolean readOnly) {
        dateField.setReadOnly(readOnly);
        return this;
    }

    public DateFieldBuilder setVisible(final boolean visible) {
        dateField.setVisible(visible);
        return this;
    }

    public DateFieldBuilder setCaption(final String caption) {
        dateField.setCaption(caption);
        return this;
    }

    public DateFieldBuilder caption(final String caption) {
        dateField.setCaption(caption);
        return this;
    }

    public DateFieldBuilder setStyleName(final String styleName) {
        dateField.setStyleName(styleName);
        return this;
    }

    public DateFieldBuilder setDateFormat(final String dateFormat) {
        dateField.setDateFormat(dateFormat);
        return this;
    }

    public DateFieldBuilder setLenient(final Boolean lenient) {
        dateField.setLenient(lenient);
        return this;
    }

    public DateFieldBuilder setDateOutOfRangeMessage(final String dateOutOfRangeMessage) {
        dateField.setDateOutOfRangeMessage(dateOutOfRangeMessage);
        return this;
    }

    public DateFieldBuilder setParseErrorMessage(final String parseErrorMessage) {
        dateField.setParseErrorMessage(parseErrorMessage);
        return this;
    }

    public DateFieldBuilder setResponsive(final boolean responsive) {
        dateField.setResponsive(responsive);
        return this;
    }

    public DateFieldBuilder setLenient(final boolean lenient) {
        dateField.setLenient(lenient);
        return this;
    }

    public DateFieldBuilder setRangeStart(final LocalDate rangeStart) {
        dateField.setRangeStart(rangeStart);
        return this;
    }

    public DateFieldBuilder setRangeEnd(final LocalDate rangeEnd) {
        dateField.setRangeEnd(rangeEnd);
        return this;
    }

    public DateFieldBuilder setResolution(final com.vaadin.shared.ui.datefield.DateResolution resolution) {
        dateField.setResolution(resolution);
        return this;
    }

}