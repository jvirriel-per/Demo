package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.v7.shared.ui.combobox.FilteringMode;
import org.vaadin.addons.comboboxmultiselect.ComboBoxMultiselect;

import java.util.Collection;
import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/directory#!addon/comboboxmultiselect-add-on">ComboBoxMultiselect</a>

 */
public class ComboBoxMultiSelectBuilder {
    private final ComboBoxMultiselect comboBoxMultiselect;

    public ComboBoxMultiSelectBuilder(ComboBoxMultiselect comboBoxMultiselect) {
        this.comboBoxMultiselect = comboBoxMultiselect;
    }

    public final ComboBoxMultiselect get() {
        return comboBoxMultiselect;
    }

    public static ComboBoxMultiSelectBuilder comboBoxMultiSelect() {
        return new ComboBoxMultiSelectBuilder(new ComboBoxMultiselect());
    }

    public static ComboBoxMultiSelectBuilder comboBoxMultiSelect(String caption){
        return new ComboBoxMultiSelectBuilder(new ComboBoxMultiselect(caption));
    }

    public static ComboBoxMultiSelectBuilder comboBoxMultiSelect(String caption, Collection<?> options){
        return new ComboBoxMultiSelectBuilder(new ComboBoxMultiselect(caption, options));
    }

    public ComboBoxMultiSelectBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            comboBoxMultiselect.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public ComboBoxMultiSelectBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            comboBoxMultiselect.addAttachListener(attachListener);
        }
        return this;
    }

    /*public ComboBoxMultiSelectBuilder addPropertySetChangeListener(final Container.PropertySetChangeListener... propertySetChangeListeners) {
        for (final Container.PropertySetChangeListener propertySetChangeListener : propertySetChangeListeners) {
            comboBoxMultiselect.addPropertySetChangeListener(propertySetChangeListener);
        }
        return this;
    }*/

    /*public ComboBoxMultiSelectBuilder addValueChangeListener(final com.vaadin.data.Property.ValueChangeListener... valueChangeListeners) {
        for (final com.vaadin.data.Property.ValueChangeListener valueChangeListener : valueChangeListeners) {
            comboBoxMultiselect.addValueChangeListener(valueChangeListener);
        }
        return this;
    }*/

    /*public ComboBoxMultiSelectBuilder addReadOnlyStatusChangeListener(final com.vaadin.data.Property.ReadOnlyStatusChangeListener... readOnlyStatusChangeListeners) {
        for (final com.vaadin.data.Property.ReadOnlyStatusChangeListener readOnlyStatusChangeListener : readOnlyStatusChangeListeners) {
            comboBoxMultiselect.addReadOnlyStatusChangeListener(readOnlyStatusChangeListener);
        }
        return this;
    }*/

    public ComboBoxMultiSelectBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            comboBoxMultiselect.addListener(listener);
        }
        return this;
    }

    /*public ComboBoxMultiSelectBuilder addItemSetChangeListener(final Container.ItemSetChangeListener... itemSetChangeListeners) {
        for (final Container.ItemSetChangeListener itemSetChangeListener : itemSetChangeListeners) {
            comboBoxMultiselect.addItemSetChangeListener(itemSetChangeListener);
        }
        return this;
    }*/

    public ComboBoxMultiSelectBuilder addItemWithCaption(final Object itemId, final String caption) {
        comboBoxMultiselect.addItem(itemId);
        comboBoxMultiselect.setItemCaption(itemId, caption);
        return this;
    }

    /*public ComboBoxMultiSelectBuilder addValidator(final Validator... validators) {
        for (final Validator validator : validators) {
            comboBoxMultiselect.addValidator(validator);
        }
        return this;
    }*/

    /*public ComboBoxMultiSelectBuilder addFocusListener(final FieldEvents.FocusListener... focusListeners) {
        for (final FieldEvents.FocusListener focusListener : focusListeners) {
            comboBoxMultiselect.addFocusListener(focusListener);
        }
        return this;
    }*/

    public ComboBoxMultiSelectBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            comboBoxMultiselect.addStyleName(styleName);
        }
        return this;
    }

    public ComboBoxMultiSelectBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            comboBoxMultiselect.addDetachListener(detachListener);
        }
        return this;
    }

    public ComboBoxMultiSelectBuilder setWidth(final String width) {
        comboBoxMultiselect.setWidth(width);
        return this;
    }

    public ComboBoxMultiSelectBuilder setEnabled(final boolean enabled) {
        comboBoxMultiselect.setEnabled(enabled);
        return this;
    }

    public ComboBoxMultiSelectBuilder setCommitInvalidData(final boolean commitInvalidData) {
        comboBoxMultiselect.setInvalidCommitted(commitInvalidData);
        return this;
    }

    public ComboBoxMultiSelectBuilder setTextInputAllowed(final boolean textInputAllowed) {
        comboBoxMultiselect.setTextInputAllowed(textInputAllowed);
        return this;
    }

    public ComboBoxMultiSelectBuilder setLocale(final Locale locale) {
        comboBoxMultiselect.setLocale(locale);
        return this;
    }

    public ComboBoxMultiSelectBuilder setTabIndex(final int tabIndex) {
        comboBoxMultiselect.setTabIndex(tabIndex);
        return this;
    }

    public ComboBoxMultiSelectBuilder setFilteringMode(final FilteringMode filteringMode) {
        comboBoxMultiselect.setFilteringMode(filteringMode);
        return this;
    }

    public ComboBoxMultiSelectBuilder setData(final Object data) {
        comboBoxMultiselect.setData(data);
        return this;
    }

    public ComboBoxMultiSelectBuilder setNullSelectionItemId(final Object nullSelectionItemId) {
        comboBoxMultiselect.setNullSelectionItemId(nullSelectionItemId);
        return this;
    }

    public ComboBoxMultiSelectBuilder setHeight(final String height) {
        comboBoxMultiselect.setHeight(height);
        return this;
    }

    public ComboBoxMultiSelectBuilder setScrollToSelectedItem(final boolean scrollToSelectedItem) {
        comboBoxMultiselect.setScrollToSelectedItem(scrollToSelectedItem);
        return this;
    }

    public ComboBoxMultiSelectBuilder setInvalidAllowed(final boolean invalidAllowed) {
        comboBoxMultiselect.setInvalidAllowed(invalidAllowed);
        return this;
    }

    public ComboBoxMultiSelectBuilder setVisible(final boolean visible) {
        comboBoxMultiselect.setVisible(visible);
        return this;
    }

    public ComboBoxMultiSelectBuilder setItemIconPropertyId(final Object itemIconPropertyId) {
        comboBoxMultiselect.setItemIconPropertyId(itemIconPropertyId);
        return this;
    }

    public ComboBoxMultiSelectBuilder setPageLength(final int pageLength) {
        comboBoxMultiselect.setPageLength(pageLength);
        return this;
    }

    /*public ComboBoxMultiSelectBuilder setContainerDataSource(final Container containerDataSource) {
        comboBoxMultiselect.setContainerDataSource(containerDataSource);
        return this;
    }*/

    public ComboBoxMultiSelectBuilder setStyleName(final String styleName) {
        comboBoxMultiselect.setStyleName(styleName);
        return this;
    }

    public ComboBoxMultiSelectBuilder setRequired(final boolean required) {
        comboBoxMultiselect.setRequired(true);
        return this;
    }

    public ComboBoxMultiSelectBuilder setErrorHandler(final ErrorHandler errorHandler) {
        comboBoxMultiselect.setErrorHandler(errorHandler);
        return this;
    }

    public ComboBoxMultiSelectBuilder setItemCaptionPropertyId(final Object itemCaptionPropertyId) {
        comboBoxMultiselect.setItemCaptionPropertyId(itemCaptionPropertyId);
        return this;
    }

    public ComboBoxMultiSelectBuilder setComponentError(final ErrorMessage componentError) {
        comboBoxMultiselect.setComponentError(componentError);
        return this;
    }

    /*public ComboBoxMultiSelectBuilder setNullSelectionAllowed(final boolean nullSelectionAllowed) {
        comboBoxMultiselect.setNullSelectionAllowed(nullSelectionAllowed);
        return this;
    }*/

    public ComboBoxMultiSelectBuilder setConvertedValue(final Object convertedValue) {
        comboBoxMultiselect.setConvertedValue(convertedValue);
        return this;
    }

    public ComboBoxMultiSelectBuilder setPrimaryStyleName(final String primaryStyleName) {
        comboBoxMultiselect.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public ComboBoxMultiSelectBuilder setIcon(final Resource icon) {
        comboBoxMultiselect.setIcon(icon);
        return this;
    }

    public ComboBoxMultiSelectBuilder setInputPrompt(final String inputPrompt) {
        comboBoxMultiselect.setInputPrompt(inputPrompt);
        return this;
    }

    public ComboBoxMultiSelectBuilder setDescription(final String description) {
        comboBoxMultiselect.setDescription(description);
        return this;
    }

    public ComboBoxMultiSelectBuilder setConversionError(final String conversionError) {
        comboBoxMultiselect.setConversionError(conversionError);
        return this;
    }

    public ComboBoxMultiSelectBuilder setValidationVisible(final boolean validationVisible) {
        comboBoxMultiselect.setValidationVisible(validationVisible);
        return this;
    }

    public ComboBoxMultiSelectBuilder setReadOnly(final boolean readOnly) {
        comboBoxMultiselect.setReadOnly(readOnly);
        return this;
    }

    /*public ComboBoxMultiSelectBuilder setConverter(final Converter<Object, ?> converter) {
        comboBoxMultiselect.setConverter(converter);
        return this;
    }*/

    /*public ComboBoxMultiSelectBuilder setItemCaptionMode(final AbstractSelect.ItemCaptionMode itemCaptionMode) {
        comboBoxMultiselect.setItemCaptionMode(itemCaptionMode);
        return this;
    }*/

    public ComboBoxMultiSelectBuilder setImmediate(final boolean inmediate) {
        comboBoxMultiselect.setImmediate(inmediate);
        return this;
    }

    /*public ComboBoxMultiSelectBuilder setNewItemHandler(final ComboBox.NewItemHandler newItemHandler) {
        comboBoxMultiselect.setNewItemHandler(newItemHandler);
        return this;
    }*/

    public ComboBoxMultiSelectBuilder setValue(final Object value) {
        comboBoxMultiselect.setValue(value);
        return this;
    }

    public ComboBoxMultiSelectBuilder setRequiredError(final String requiredError) {
        comboBoxMultiselect.setRequiredError(requiredError);
        comboBoxMultiselect.setRequired(requiredError != null);
        return this;
    }

    public ComboBoxMultiSelectBuilder setBuffered(final boolean buffered) {
        comboBoxMultiselect.setBuffered(buffered);
        return this;
    }

    public ComboBoxMultiSelectBuilder setCaption(final String caption) {
        comboBoxMultiselect.setCaption(caption);
        return this;
    }

    public ComboBoxMultiSelectBuilder setNewItemsAllowed(final boolean newItemsAllowed) {
        comboBoxMultiselect.setNewItemsAllowed(newItemsAllowed);
        return this;
    }

    public ComboBoxMultiSelectBuilder setResponsive(final boolean responsive) {
        comboBoxMultiselect.setResponsive(responsive);
        return this;
    }
}
