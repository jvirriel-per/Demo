package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.v7.data.Container;
import com.vaadin.v7.ui.Table;

import java.util.Collection;
import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo Table.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/7.7.6/com/vaadin/ui/Table.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public final class TableBuilder {

    /**
     * delegate
     */
    private final Table table;

    /**
     * Hide constructor, use static factory methods.
     */
    private TableBuilder(final Table table) {
        this.table = table;
    }

    /**
     * @return the created instance
     */
    public final Table get() {
        return table;
    }

    /**
     * Empty table.
     * @return
     */
    public static TableBuilder table() {
        return new TableBuilder(new Table());
    }

    /**
     * Table with caption.
     * @param caption
     * @return
     */
    public static TableBuilder table(final String caption) {
        return new TableBuilder(new Table(caption));
    }

    public TableBuilder addActionHandler(final com.vaadin.event.Action.Handler... actionHandlers) {
        for (final com.vaadin.event.Action.Handler actionHandler : actionHandlers) {
            table.addActionHandler(actionHandler);
        }
        return this;
    }

    public TableBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            table.addAttachListener(attachListener);
        }
        return this;
    }

    public TableBuilder addColumnReorderListener(final Table.ColumnReorderListener... columnReorderListeners) {
        for (final Table.ColumnReorderListener columnReorderListener : columnReorderListeners) {
            table.addColumnReorderListener(columnReorderListener);
        }
        return this;
    }

    public TableBuilder addColumnResizeListener(final Table.ColumnResizeListener... columnResizeListeners) {
        for (final Table.ColumnResizeListener columnResizeListener : columnResizeListeners) {
            table.addColumnResizeListener(columnResizeListener);
        }
        return this;
    }

    public TableBuilder addContainerProperty(Object propertyId,
                                             Class<?> type,
                                             Object defaultValue) {
        table.addContainerProperty(propertyId, type, defaultValue);
        return this;
    }

    public TableBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            table.addDetachListener(detachListener);
        }
        return this;
    }

    public TableBuilder addFooterClickListener(final Table.FooterClickListener... footerClickListeners) {
        for (final Table.FooterClickListener footerClickListener : footerClickListeners) {
            table.addFooterClickListener(footerClickListener);
        }
        return this;
    }

    public TableBuilder addHeaderClickListener(final Table.HeaderClickListener... headerClickListeners) {
        for (final Table.HeaderClickListener headerClickListener : headerClickListeners) {
            table.addHeaderClickListener(headerClickListener);
        }
        return this;
    }

    public TableBuilder addItemSetChangeListener(final Container.ItemSetChangeListener... itemSetChangeListeners) {
        for (final Container.ItemSetChangeListener itemSetChangeListener : itemSetChangeListeners) {
            table.addItemSetChangeListener(itemSetChangeListener);
        }
        return this;
    }

    public TableBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            table.addListener(listener);
        }
        return this;
    }

    public TableBuilder addPropertySetChangeListener(final Container.PropertySetChangeListener... propertySetChangeListeners) {
        for (final Container.PropertySetChangeListener propertySetChangeListener : propertySetChangeListeners) {
            table.addPropertySetChangeListener(propertySetChangeListener);
        }
        return this;
    }

    public TableBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            table.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public TableBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            table.addStyleName(styleName);
        }
        return this;
    }

    public TableBuilder setBuffered(final boolean buffered) {
        table.setBuffered(buffered);
        return this;
    }

    public TableBuilder setCacheRate(final double cacheRate) {
        table.setCacheRate(cacheRate);
        return this;
    }

    public TableBuilder setCaption(final String caption) {
        table.setCaption(caption);
        return this;
    }

    public TableBuilder setCellStyleGenerator(final Table.CellStyleGenerator cellStyleGenerator) {
        table.setCellStyleGenerator(cellStyleGenerator);
        return this;
    }

    public TableBuilder setColumnAlignments(final Table.Align[] columnAlignments) {
        table.setColumnAlignments(columnAlignments);
        return this;
    }

    public TableBuilder setColumnCollapsingAllowed(final boolean collapsingAllowed) {
        table.setColumnCollapsingAllowed(collapsingAllowed);
        return this;
    }

    public TableBuilder setColumnHeaderMode(final Table.ColumnHeaderMode columnHeaderMode) {
        table.setColumnHeaderMode(columnHeaderMode);
        return this;
    }

    public TableBuilder setColumnHeaders(final String[] columnHeaders) {
        table.setColumnHeaders(columnHeaders);
        return this;
    }

    public TableBuilder setColumnIcons(final Resource[] columnIcons) {
        table.setColumnIcons(columnIcons);
        return this;
    }

    public TableBuilder setColumnReorderingAllowed(final boolean reorderingAllowed) {
        table.setColumnReorderingAllowed(reorderingAllowed);
        return this;
    }

    public TableBuilder setInvalidCommit(final boolean invalidCommit) {
        table.setInvalidCommitted(invalidCommit);
        return this;
    }

    public TableBuilder setComponentError(final ErrorMessage componentError) {
        table.setComponentError(componentError);
        return this;
    }

    public TableBuilder setContainerDataSource(final Container containerDataSource) {
        table.setContainerDataSource(containerDataSource);
        return this;
    }

    public TableBuilder setContainerDataSource(final Container containerDataSource, Collection<?> visibleIds) {
        table.setContainerDataSource(containerDataSource, visibleIds);
        return this;
    }

    public TableBuilder setConversionError(final String conversionError) {
        table.setConversionError(conversionError);
        return this;
    }

    public TableBuilder setConvertedValue(final Object convertedValue) {
        table.setConvertedValue(convertedValue);
        return this;
    }

    public TableBuilder setCurrentPageFirstItemId(final Object currentPageFirstItemId) {
        table.setCurrentPageFirstItemId(currentPageFirstItemId);
        return this;
    }

    public TableBuilder setCurrentPageFirstItemIndex(final int currentPageFirstItemIndex) {
        table.setCurrentPageFirstItemIndex(currentPageFirstItemIndex);
        return this;
    }

    public TableBuilder setData(final Object data) {
        table.setData(data);
        return this;
    }

    public TableBuilder setDescription(final String description) {
        table.setDescription(description);
        return this;
    }

    public TableBuilder setMultiSelect(final boolean multiSelect) {
        table.setMultiSelect(multiSelect);
        return this;
    }

    public TableBuilder setSortEnabled(final boolean sortEnabled) {
        table.setSortEnabled(false);
        return this;
    }

    public TableBuilder setDragMode(final Table.TableDragMode dragMode) {
        table.setDragMode(dragMode);
        return this;
    }

    public TableBuilder setDropHandler(final DropHandler dropHandler) {
        table.setDropHandler(dropHandler);
        return this;
    }

    public TableBuilder setEditable(final boolean editable) {
        table.setEditable(editable);
        return this;
    }

    public TableBuilder setEnabled(final boolean enabled) {
        table.setEnabled(enabled);
        return this;
    }

    public TableBuilder setErrorHandler(final ErrorHandler errorHandler) {
        table.setErrorHandler(errorHandler);
        return this;
    }

    public TableBuilder setFooterVisible(final boolean footerVisible) {
        table.setFooterVisible(footerVisible);
        return this;
    }

    public TableBuilder setHeight(final String height) {
        table.setHeight(height);
        return this;
    }

    public TableBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        table.setHeight(height, unit);
        return this;
    }

    public TableBuilder setIcon(final Resource icon) {
        table.setIcon(icon);
        return this;
    }

    public TableBuilder setImmediate(final boolean immediate) {
        table.setImmediate(immediate);
        return this;
    }

    public TableBuilder setInvalidAllowed(final boolean invalidAllowed) {
        table.setInvalidAllowed(invalidAllowed);
        return this;
    }

    public TableBuilder setItemCaptionPropertyId(final Object itemCaptionPropertyId) {
        table.setItemCaptionPropertyId(itemCaptionPropertyId);
        return this;
    }

    public TableBuilder setItemIconPropertyId(final Object itemIconPropertyId) {
        table.setItemIconPropertyId(itemIconPropertyId);
        return this;
    }

    public TableBuilder setLocale(final Locale locale) {
        table.setLocale(locale);
        return this;
    }

    public TableBuilder setMultiSelectMode(final MultiSelectMode multiSelectMode) {
        table.setMultiSelectMode(multiSelectMode);
        return this;
    }

    public TableBuilder setNewItemsAllowed(final boolean newItemsAllowed) {
        table.setNewItemsAllowed(newItemsAllowed);
        return this;
    }

    public TableBuilder setNullSelectionAllowed(final boolean nullSelectionAllowed) {
        table.setNullSelectionAllowed(nullSelectionAllowed);
        return this;
    }

    public TableBuilder setNullSelectionItemId(final Object nullSelectionItemId) {
        table.setNullSelectionItemId(nullSelectionItemId);
        return this;
    }

    public TableBuilder setPageLength(final int pageLength) {
        table.setPageLength(pageLength);
        return this;
    }

    public TableBuilder setPrimaryStyleName(final String primaryStyleName) {
        table.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public TableBuilder setReadOnly(final boolean readOnly) {
        table.setReadOnly(readOnly);
        return this;
    }

    public TableBuilder setRequired(final boolean required) {
        table.setRequired(required);
        return this;
    }

    public TableBuilder setRequiredError(final String requiredError) {
        table.setRequiredError(requiredError);
        table.setRequired(requiredError != null);
        return this;
    }

    public TableBuilder setResponsive(final boolean responsive) {
        table.setResponsive(responsive);
        return this;
    }

    public TableBuilder setRowGenerator(final Table.RowGenerator rowGenerator) {
        table.setRowGenerator(rowGenerator);
        return this;
    }

    public TableBuilder setRowHeaderMode(final Table.RowHeaderMode rowHeaderMode) {
        table.setRowHeaderMode(rowHeaderMode);
        return this;
    }

    public TableBuilder setSelectable(final boolean selectable) {
        table.setSelectable(selectable);
        return this;
    }

    public TableBuilder setSizeFull() {
        table.setSizeFull();
        return this;
    }

    public TableBuilder setSortAscending(final boolean sortAscending) {
        table.setSortAscending(sortAscending);
        return this;
    }

    public TableBuilder setSortContainerPropertyId(final Object sortContainerPropertyId) {
        table.setSortContainerPropertyId(sortContainerPropertyId);
        return this;
    }

    public TableBuilder setStyleName(final String styleName) {
        table.setStyleName(styleName);
        return this;
    }

    public TableBuilder setStyleName(final String styleName, final boolean add) {
        table.setStyleName(styleName, add);
        return this;
    }

    public TableBuilder setTabIndex(final int tabIndex) {
        table.setTabIndex(tabIndex);
        return this;
    }

    public TableBuilder setValidationVisible(final boolean validationVisible) {
        table.setValidationVisible(validationVisible);
        return this;
    }

    public TableBuilder setValue(final Object value) {
        table.setValue(value);
        return this;
    }

    public TableBuilder setVisible(final boolean visible) {
        table.setVisible(visible);
        return this;
    }

    public TableBuilder setVisibleColumns(final Object[] visibleColumns) {
        table.setVisibleColumns(visibleColumns);
        return this;
    }

    public TableBuilder setWidth(final String width) {
        table.setWidth(width);
        return this;
    }

    public TableBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        table.setWidth(width, unit);
        return this;
    }
}