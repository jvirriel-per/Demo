package com.jvirriel.demo.frontend.components.core;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.event.ShortcutListener;

import com.vaadin.server.*;
import com.vaadin.ui.RadioButtonGroup;

import java.util.Collection;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo RadioButtonGroup.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/RadioButtonGroup.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public final class RadioButtonGroupBuilder {

    /**
     * delegate
     */
    private final RadioButtonGroup radioButtonGroup;

    /**
     * Hide constructor, use static factory methods.
     */
    private RadioButtonGroupBuilder(final RadioButtonGroup radioButtonGroup) {
        this.radioButtonGroup = radioButtonGroup;
    }

    /**
     * @return
     *         the created instance
     */
    public final RadioButtonGroup get() {
        return radioButtonGroup;
    }

    public static RadioButtonGroupBuilder radioButtonGroup() {
        return new RadioButtonGroupBuilder(new RadioButtonGroup());
    }

    public static RadioButtonGroupBuilder radioButtonGroup(final String caption) {
        return new RadioButtonGroupBuilder(new RadioButtonGroup(caption));
    }

    public static RadioButtonGroupBuilder radioButtonGroup(final String caption, final Collection<?> collection) {
        return new RadioButtonGroupBuilder(new RadioButtonGroup(caption, collection));
    }

    public static RadioButtonGroupBuilder radioButtonGroup(final String caption, final DataProvider<?,?> dataProvider) {
        return new RadioButtonGroupBuilder(new RadioButtonGroup(caption, dataProvider));
    }

    public RadioButtonGroupBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            radioButtonGroup.addListener(listener);
        }
        return this;
    }

    public RadioButtonGroupBuilder addAttachListener(
            final ClientConnector.AttachListener... attachListeners) {
        for (final ClientConnector.AttachListener attachListener : attachListeners) {
            radioButtonGroup.addAttachListener(attachListener);
        }
        return this;
    }

    public RadioButtonGroupBuilder addBlurListener(final com.vaadin.event.FieldEvents.BlurListener... blurListeners) {
        for (final com.vaadin.event.FieldEvents.BlurListener blurListener : blurListeners) {
            radioButtonGroup.addBlurListener(blurListener);
        }
        return this;
    }

    public RadioButtonGroupBuilder addDetachListener(
            final ClientConnector.DetachListener... detachListeners) {
        for (final ClientConnector.DetachListener detachListener : detachListeners) {
            radioButtonGroup.addDetachListener(detachListener);
        }
        return this;
    }

    public RadioButtonGroupBuilder addFocusListener(final com.vaadin.event.FieldEvents.FocusListener... focusListeners) {
        for (final com.vaadin.event.FieldEvents.FocusListener focusListener : focusListeners) {
            radioButtonGroup.addFocusListener(focusListener);
        }
        return this;
    }

    public RadioButtonGroupBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            radioButtonGroup.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public RadioButtonGroupBuilder setWidth(final String width) {
        radioButtonGroup.setWidth(width);
        return this;
    }

    public RadioButtonGroupBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        radioButtonGroup.setWidth(width, unit);
        return this;
    }

    public RadioButtonGroupBuilder setEnable(final boolean enable) {
        radioButtonGroup.setEnabled(enable);
        return this;
    }

    public RadioButtonGroupBuilder setLocale(final Locale locale) {
        radioButtonGroup.setLocale(locale);
        return this;
    }

    public RadioButtonGroupBuilder setTabIndex(final int tabIndex) {
        radioButtonGroup.setTabIndex(tabIndex);
        return this;
    }

    public RadioButtonGroupBuilder setData(final Object data) {
        radioButtonGroup.setData(data);
        return this;
    }

    public RadioButtonGroupBuilder setHeight(final String height) {
        radioButtonGroup.setHeight(height);
        return this;
    }

    public RadioButtonGroupBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        radioButtonGroup.setHeight(height, unit);
        return this;
    }

    public RadioButtonGroupBuilder setVisible(final boolean visible) {
        radioButtonGroup.setVisible(visible);
        return this;
    }

    public RadioButtonGroupBuilder setStyleName(final String styleName) {
        radioButtonGroup.setStyleName(styleName);
        return this;
    }

    public RadioButtonGroupBuilder setStyleName(final String styleName, final boolean add) {
        radioButtonGroup.setStyleName(styleName, add);
        return this;
    }

    public RadioButtonGroupBuilder setErrorHandler(final ErrorHandler errorHandler) {
        radioButtonGroup.setErrorHandler(errorHandler);
        return this;
    }

    public RadioButtonGroupBuilder setComponentError(final ErrorMessage componentError) {
        radioButtonGroup.setComponentError(componentError);
        return this;
    }

    public RadioButtonGroupBuilder setPrimaryStyleName(final String primaryStyleName) {
        radioButtonGroup.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public RadioButtonGroupBuilder setIcon(final Resource icon) {
        radioButtonGroup.setIcon(icon);
        return this;
    }

    public RadioButtonGroupBuilder setHtmlContentAllowed(final boolean htmlContentAllowed) {
        radioButtonGroup.setHtmlContentAllowed(htmlContentAllowed);
        return this;
    }

    public RadioButtonGroupBuilder setDescription(final String description) {
        radioButtonGroup.setDescription(description);
        return this;
    }

    public RadioButtonGroupBuilder setReadOnly(final boolean readOnly) {
        radioButtonGroup.setReadOnly(readOnly);
        return this;
    }

    public RadioButtonGroupBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            radioButtonGroup.addStyleName(styleName);
        }
        return this;
    }

    public RadioButtonGroupBuilder setValue(final Object value) {
        radioButtonGroup.setValue(value);
        return this;
    }

    public RadioButtonGroupBuilder setCaption(final String caption) {
        radioButtonGroup.setCaption(caption);
        return this;
    }

    public RadioButtonGroupBuilder setItems(String... strings){
        radioButtonGroup.setItems(strings);
        return this;
    }

    public RadioButtonGroupBuilder setItems(Collection collection){
        radioButtonGroup.setItems(collection);
        return this;
    }

    public RadioButtonGroupBuilder setItems(Stream stream){
        radioButtonGroup.setItems(stream);
        return this;
    }

    public RadioButtonGroupBuilder setItemEnabledProvider(SerializablePredicate itemEnabledProvider){
        radioButtonGroup.setItemEnabledProvider(itemEnabledProvider);
        return this;
    }

}
