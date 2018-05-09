package com.jvirriel.demo.frontend.components.core;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.*;
import com.vaadin.ui.CheckBoxGroup;

import java.util.Collection;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo CheckBoxGroup.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/CheckBoxGroup.html">documentación de referencia</a> en la página
 * de Vaadin.

 */
public final class CheckBoxGroupBuilder {

    /**
     * delegate
     */
    private final CheckBoxGroup checkBoxGroup;

    /**
     * Hide constructor, use static factory methods.
     */
    private CheckBoxGroupBuilder(final CheckBoxGroup checkBoxGroup) {
        this.checkBoxGroup = checkBoxGroup;
    }

    /**
     * @return
     *         the created instance
     */
    public final CheckBoxGroup get() {
        return checkBoxGroup;
    }

    public static CheckBoxGroupBuilder checkBoxGroup() {
        return new CheckBoxGroupBuilder(new CheckBoxGroup());
    }

    public static CheckBoxGroupBuilder checkBoxGroup(final String caption) {
        return new CheckBoxGroupBuilder(new CheckBoxGroup(caption));
    }

    public static CheckBoxGroupBuilder checkBoxGroup(final String caption, final Collection<?> collection) {
        return new CheckBoxGroupBuilder(new CheckBoxGroup(caption, collection));
    }

    public static CheckBoxGroupBuilder checkBoxGroup(final String caption, final DataProvider<?,?> dataProvider) {
        return new CheckBoxGroupBuilder(new CheckBoxGroup(caption, dataProvider));
    }

    public CheckBoxGroupBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            checkBoxGroup.addListener(listener);
        }
        return this;
    }

    public CheckBoxGroupBuilder addAttachListener(
            final ClientConnector.AttachListener... attachListeners) {
        for (final ClientConnector.AttachListener attachListener : attachListeners) {
            checkBoxGroup.addAttachListener(attachListener);
        }
        return this;
    }

    public CheckBoxGroupBuilder addBlurListener(final com.vaadin.event.FieldEvents.BlurListener... blurListeners) {
        for (final com.vaadin.event.FieldEvents.BlurListener blurListener : blurListeners) {
            checkBoxGroup.addBlurListener(blurListener);
        }
        return this;
    }

    public CheckBoxGroupBuilder addDetachListener(
            final ClientConnector.DetachListener... detachListeners) {
        for (final ClientConnector.DetachListener detachListener : detachListeners) {
            checkBoxGroup.addDetachListener(detachListener);
        }
        return this;
    }

    public CheckBoxGroupBuilder addFocusListener(final com.vaadin.event.FieldEvents.FocusListener... focusListeners) {
        for (final com.vaadin.event.FieldEvents.FocusListener focusListener : focusListeners) {
            checkBoxGroup.addFocusListener(focusListener);
        }
        return this;
    }

    public CheckBoxGroupBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            checkBoxGroup.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public CheckBoxGroupBuilder setWidth(final String width) {
        checkBoxGroup.setWidth(width);
        return this;
    }

    public CheckBoxGroupBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        checkBoxGroup.setWidth(width, unit);
        return this;
    }

    public CheckBoxGroupBuilder setEnable(final boolean enable) {
        checkBoxGroup.setEnabled(enable);
        return this;
    }

    public CheckBoxGroupBuilder setLocale(final Locale locale) {
        checkBoxGroup.setLocale(locale);
        return this;
    }

    public CheckBoxGroupBuilder setTabIndex(final int tabIndex) {
        checkBoxGroup.setTabIndex(tabIndex);
        return this;
    }

    public CheckBoxGroupBuilder setData(final Object data) {
        checkBoxGroup.setData(data);
        return this;
    }

    public CheckBoxGroupBuilder setHeight(final String height) {
        checkBoxGroup.setHeight(height);
        return this;
    }

    public CheckBoxGroupBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        checkBoxGroup.setHeight(height, unit);
        return this;
    }

    public CheckBoxGroupBuilder setVisible(final boolean visible) {
        checkBoxGroup.setVisible(visible);
        return this;
    }

    public CheckBoxGroupBuilder setStyleName(final String styleName) {
        checkBoxGroup.setStyleName(styleName);
        return this;
    }

    public CheckBoxGroupBuilder setStyleName(final String styleName, final boolean add) {
        checkBoxGroup.setStyleName(styleName, add);
        return this;
    }

    public CheckBoxGroupBuilder setErrorHandler(final ErrorHandler errorHandler) {
        checkBoxGroup.setErrorHandler(errorHandler);
        return this;
    }

    public CheckBoxGroupBuilder setComponentError(final ErrorMessage componentError) {
        checkBoxGroup.setComponentError(componentError);
        return this;
    }

    public CheckBoxGroupBuilder setPrimaryStyleName(final String primaryStyleName) {
        checkBoxGroup.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public CheckBoxGroupBuilder setIcon(final Resource icon) {
        checkBoxGroup.setIcon(icon);
        return this;
    }

    public CheckBoxGroupBuilder setHtmlContentAllowed(final boolean htmlContentAllowed) {
        checkBoxGroup.setHtmlContentAllowed(htmlContentAllowed);
        return this;
    }


    public CheckBoxGroupBuilder setDescription(final String description) {
        checkBoxGroup.setDescription(description);
        return this;
    }

    public CheckBoxGroupBuilder setReadOnly(final boolean readOnly) {
        checkBoxGroup.setReadOnly(readOnly);
        return this;
    }

    public CheckBoxGroupBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            checkBoxGroup.addStyleName(styleName);
        }
        return this;
    }

    public CheckBoxGroupBuilder setValue(final Set value) {
        checkBoxGroup.setValue(value);
        return this;
    }

    public CheckBoxGroupBuilder setCaption(final String caption) {
        checkBoxGroup.setCaption(caption);
        return this;
    }

    public CheckBoxGroupBuilder setItems(String... s){
        checkBoxGroup.setItems(s);
        return this;
    }

    public CheckBoxGroupBuilder setItems(Collection collection){
        checkBoxGroup.setItems(collection);
        return this;
    }

    public CheckBoxGroupBuilder setItems(Stream stream){
        checkBoxGroup.setItems(stream);
        return this;
    }

    public CheckBoxGroupBuilder setItemEnabledProvider(SerializablePredicate itemEnabledProvider){
        checkBoxGroup.setItemEnabledProvider(itemEnabledProvider);
        return this;
    }


}
