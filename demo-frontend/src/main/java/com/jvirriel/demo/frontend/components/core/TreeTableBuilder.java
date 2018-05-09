package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.Validator;
import com.vaadin.v7.data.util.converter.Converter;
import com.vaadin.v7.event.ItemClickEvent;
import com.vaadin.v7.ui.AbstractSelect;
import com.vaadin.v7.ui.TableFieldFactory;
import com.vaadin.v7.ui.TreeTable;

import java.util.Collection;
import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo TreeTable.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/7.6.8/com/vaadin/ui/TreeTable.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public final class TreeTableBuilder {
    /**
     * delegate
     */
    private final TreeTable treeTable;

    /**
     * Hide constructor, use static factory methods.
     */
    private TreeTableBuilder(final TreeTable treeTable) {
        this.treeTable = treeTable;
    }

    /**
     * @return the created instance
     */
    public final TreeTable get() {
        return treeTable;
    }

    /**
     * Empty treeTable.
     *
     * @return
     */
    public static TreeTableBuilder treeTable() {
        return new TreeTableBuilder(new TreeTable());
    }

    /**
     * TreeTable with a default containers and caption.
     *
     * @param caption
     * @return
     */
    public static TreeTableBuilder treeTable(final String caption) {
        return new TreeTableBuilder(new TreeTable(caption));
    }

    public static TreeTableBuilder treeTable(final String caption, Container dataSource) {
        return new TreeTableBuilder(new TreeTable(caption, dataSource));
    }

    public TreeTableBuilder addActionHandler(final com.vaadin.event.Action.Handler... actionHandlers) {
        for (final com.vaadin.event.Action.Handler actionHandler : actionHandlers) {
            treeTable.addActionHandler(actionHandler);
        }
        return this;
    }

    public TreeTableBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            treeTable.addAttachListener(attachListener);
        }
        return this;
    }

    public TreeTableBuilder addContainerProperty(Object propertyId,
                                                 Class<?> type,
                                                 Object defaultValue) {
        treeTable.addContainerProperty(propertyId, type, defaultValue);
        return this;
    }

    public TreeTableBuilder addColumnReorderListener(final TreeTable.ColumnReorderListener... columnReorderListeners) {
        for (final TreeTable.ColumnReorderListener columnReorderListener : columnReorderListeners) {
            treeTable.addColumnReorderListener(columnReorderListener);
        }
        return this;
    }

    public TreeTableBuilder addColumnResizeListener(final TreeTable.ColumnResizeListener... columnResizeListeners) {
        for (final TreeTable.ColumnResizeListener columnResizeListener : columnResizeListeners) {
            treeTable.addColumnResizeListener(columnResizeListener);
        }
        return this;
    }

    public TreeTableBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            treeTable.addDetachListener(detachListener);
        }
        return this;
    }

    public TreeTableBuilder addFooterClickListener(final TreeTable.FooterClickListener... footerClickListeners) {
        for (final TreeTable.FooterClickListener footerClickListener : footerClickListeners) {
            treeTable.addFooterClickListener(footerClickListener);
        }
        return this;
    }

    public TreeTableBuilder addHeaderClickListener(final TreeTable.HeaderClickListener... headerClickListeners) {
        for (final TreeTable.HeaderClickListener headerClickListener : headerClickListeners) {
            treeTable.addHeaderClickListener(headerClickListener);
        }
        return this;
    }

    public TreeTableBuilder addItemClickListener(final ItemClickEvent.ItemClickListener... itemClickListeners) {
        for (final ItemClickEvent.ItemClickListener itemClickListener : itemClickListeners) {
            treeTable.addItemClickListener(itemClickListener);
        }
        return this;
    }

    public TreeTableBuilder addItemSetChangeListener(final Container.ItemSetChangeListener... itemSetChangeListeners) {
        for (final Container.ItemSetChangeListener itemSetChangeListener : itemSetChangeListeners) {
            treeTable.addItemSetChangeListener(itemSetChangeListener);
        }
        return this;
    }

    public TreeTableBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            treeTable.addListener(listener);
        }
        return this;
    }

    public TreeTableBuilder addPropertySetChangeListener(
            final Container.PropertySetChangeListener... propertySetChangeListeners) {
        for (final Container.PropertySetChangeListener propertySetChangeListener : propertySetChangeListeners) {
            treeTable.addPropertySetChangeListener(propertySetChangeListener);
        }
        return this;
    }

    public TreeTableBuilder addReadOnlyStatusChangeListener(
            final Property.ReadOnlyStatusChangeListener... readOnlyStatusChangeListeners) {
        for (final Property.ReadOnlyStatusChangeListener readOnlyStatusChangeListener : readOnlyStatusChangeListeners) {
            treeTable.addReadOnlyStatusChangeListener(readOnlyStatusChangeListener);
        }
        return this;
    }

    public TreeTableBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            treeTable.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public TreeTableBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            treeTable.addStyleName(styleName);
        }
        return this;
    }

    public TreeTableBuilder addValidator(final Validator... validators) {
        for (final Validator validator : validators) {
            treeTable.addValidator(validator);
        }
        return this;
    }

    public TreeTableBuilder addValueChangeListener(
            final Property.ValueChangeListener... valueChangeListeners) {
        for (final Property.ValueChangeListener valueChangeListener : valueChangeListeners) {
            treeTable.addValueChangeListener(valueChangeListener);
        }
        return this;
    }

    /**
     * Colapsa todas las ramas del árbol.
     */
    public TreeTableBuilder collapseAll() {
        for (Object item : treeTable.getContainerDataSource().getItemIds().toArray())
            treeTable.setCollapsed(item, true);

        return this;
    }

    public TreeTableBuilder columnHeaderMode(final TreeTable.ColumnHeaderMode columnHeaderMode) {
        treeTable.setColumnHeaderMode(columnHeaderMode);
        return this;
    }

    public TreeTableBuilder columnHeaders(final String[] columnHeaders) {
        treeTable.setColumnHeaders(columnHeaders);
        return this;
    }

    public TreeTableBuilder currentPageFirstItemIndex(final int currentPageFirstItemIndex) {
        treeTable.setCurrentPageFirstItemIndex(currentPageFirstItemIndex);
        return this;
    }

    /**
     * Expande todas las ramas del árbol.
     */
    public TreeTableBuilder expandAll() {
        for (Object item : treeTable.getContainerDataSource().getItemIds().toArray())
            treeTable.setCollapsed(item, false);
        return this;
    }

    public TreeTableBuilder itemIconPropertyId(final Object itemIconPropertyId) {
        treeTable.setItemIconPropertyId(itemIconPropertyId);
        return this;
    }

    public TreeTableBuilder setBuffered(final boolean buffered) {
        treeTable.setBuffered(buffered);
        return this;
    }

    public TreeTableBuilder setCacheRate(final double cacheRate) {
        treeTable.setCacheRate(cacheRate);
        return this;
    }

    public TreeTableBuilder setCaption(final String caption) {
        treeTable.setCaption(caption);
        return this;
    }

    public TreeTableBuilder setCellStyleGenerator(final TreeTable.CellStyleGenerator cellStyleGenerator) {
        treeTable.setCellStyleGenerator(cellStyleGenerator);
        return this;
    }

    public TreeTableBuilder setColumnAlignments(final TreeTable.Align[] columnAlignments) {
        treeTable.setColumnAlignments(columnAlignments);
        return this;
    }

    public TreeTableBuilder setColumnCollapsingAllowed() {
        treeTable.setColumnCollapsingAllowed(true);
        return this;
    }

    public TreeTableBuilder setColumnCollapsingNotAllowed() {
        treeTable.setColumnCollapsingAllowed(false);
        return this;
    }

    public TreeTableBuilder setColumnIcons(final Resource[] columnIcons) {
        treeTable.setColumnIcons(columnIcons);
        return this;
    }

    public TreeTableBuilder setColumnReorderingAllowed(final boolean reorderingAllowed) {
        treeTable.setColumnReorderingAllowed(reorderingAllowed);
        return this;
    }

    public TreeTableBuilder setComponentError(final ErrorMessage componentError) {
        treeTable.setComponentError(componentError);
        return this;
    }

    public TreeTableBuilder setContainerDataSource(final Container containerDataSource) {
        treeTable.setContainerDataSource(containerDataSource);
        return this;
    }

    public TreeTableBuilder setContainerDataSource(final Container containerDataSource, Collection<?> visibleIds) {
        treeTable.setContainerDataSource(containerDataSource, visibleIds);
        return this;
    }

    public TreeTableBuilder setConversionError(final String conversionError) {
        treeTable.setConversionError(conversionError);
        return this;
    }

    public TreeTableBuilder setConvertedValue(final Object convertedValue) {
        treeTable.setConvertedValue(convertedValue);
        return this;
    }

    public TreeTableBuilder setConverter(final Converter<Object, ?> converter) {
        treeTable.setConverter(converter);
        return this;
    }

    public TreeTableBuilder setCurrentPageFirstItemId(final Object currentPageFirstItemId) {
        treeTable.setCurrentPageFirstItemId(currentPageFirstItemId);
        return this;
    }

    public TreeTableBuilder setData(final Object data) {
        treeTable.setData(data);
        return this;
    }

    public TreeTableBuilder setDescription(final String description) {
        treeTable.setDescription(description);
        return this;
    }

    public TreeTableBuilder setDragMode(final TreeTable.TableDragMode dragMode) {
        treeTable.setDragMode(dragMode);
        return this;
    }

    public TreeTableBuilder setDropHandler(final DropHandler dropHandler) {
        treeTable.setDropHandler(dropHandler);
        return this;
    }

    public TreeTableBuilder setEditable(final boolean editable) {
        treeTable.setEditable(editable);
        return this;
    }

    public TreeTableBuilder setEnabled(final boolean enabled) {
        treeTable.setEnabled(enabled);
        return this;
    }

    public TreeTableBuilder setEnabledSorting(final boolean enabledSorting) {
        treeTable.setSortEnabled(enabledSorting);
        return this;
    }

    public TreeTableBuilder setErrorHandler(final ErrorHandler errorHandler) {
        treeTable.setErrorHandler(errorHandler);
        return this;
    }

    public TreeTableBuilder setFooterVisible(final boolean visible) {
        treeTable.setFooterVisible(true);
        return this;
    }

    public TreeTableBuilder setHeight(final String height) {
        treeTable.setHeight(height);
        return this;
    }

    public TreeTableBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        treeTable.setHeight(height, unit);
        return this;
    }

    public TreeTableBuilder setIcon(final Resource icon) {
        treeTable.setIcon(icon);
        return this;
    }

    public TreeTableBuilder setImmediate(final boolean immediate) {
        treeTable.setImmediate(immediate);
        return this;
    }

    public TreeTableBuilder setInvalidAllowed(final boolean invalidAllowed) {
        treeTable.setInvalidAllowed(invalidAllowed);
        return this;
    }

    public TreeTableBuilder setInvalidCommited(final boolean invalidCommited) {
        treeTable.setInvalidCommitted(invalidCommited);
        return this;
    }

    public TreeTableBuilder setItemCaptionMode(final AbstractSelect.ItemCaptionMode itemCaptionMode) {
        treeTable.setItemCaptionMode(itemCaptionMode);
        return this;
    }

    public TreeTableBuilder setItemCaptionPropertyId(final Object itemCaptionPropertyId) {
        treeTable.setItemCaptionPropertyId(itemCaptionPropertyId);
        return this;
    }

    public TreeTableBuilder setItemDescriptionGenerator(
            final AbstractSelect.ItemDescriptionGenerator itemDescriptionGenerator) {
        treeTable.setItemDescriptionGenerator(itemDescriptionGenerator);
        return this;
    }

    public TreeTableBuilder setLocale(final Locale locale) {
        treeTable.setLocale(locale);
        return this;
    }

    public TreeTableBuilder setMultiSelect(final boolean multiSelect) {
        treeTable.setMultiSelect(multiSelect);
        return this;
    }

    public TreeTableBuilder setMultiSelectMode(final MultiSelectMode multiSelectMode) {
        treeTable.setMultiSelectMode(multiSelectMode);
        return this;
    }

    public TreeTableBuilder setNewItemHandler(final AbstractSelect.NewItemHandler newItemHandler) {
        treeTable.setNewItemHandler(newItemHandler);
        return this;
    }

    public TreeTableBuilder setNewItemsAllowed(final boolean newItemsAllowed) {
        treeTable.setNewItemsAllowed(newItemsAllowed);
        return this;
    }

    public TreeTableBuilder setNullSelectionAllowed(final boolean nullSelectionAllowed) {
        treeTable.setNullSelectionAllowed(nullSelectionAllowed);
        return this;
    }

    public TreeTableBuilder setNullSelectionItemId(final Object nullSelectionItemId) {
        treeTable.setNullSelectionItemId(nullSelectionItemId);
        return this;
    }

    public TreeTableBuilder setPageLength(final int pageLength) {
        treeTable.setPageLength(pageLength);
        return this;
    }

    public TreeTableBuilder setPrimaryStyleName(final String primaryStyleName) {
        treeTable.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public TreeTableBuilder setReadOnly(final boolean readOnly) {
        treeTable.setReadOnly(readOnly);
        return this;
    }

    public TreeTableBuilder setRequired(final boolean required) {
        treeTable.setRequired(required);
        return this;
    }

    public TreeTableBuilder setRequiredError(final String requiredError) {
        treeTable.setRequiredError(requiredError);
        treeTable.setRequired(requiredError != null);
        return this;
    }

    public TreeTableBuilder setResponsive(final boolean responsive) {
        treeTable.setResponsive(responsive);
        return this;
    }

    public TreeTableBuilder setRowGenerator(final TreeTable.RowGenerator rowGenerator) {
        treeTable.setRowGenerator(rowGenerator);
        return this;
    }

    public TreeTableBuilder setRowHeaderMode(final TreeTable.RowHeaderMode rowHeaderMode) {
        treeTable.setRowHeaderMode(rowHeaderMode);
        return this;
    }

    public TreeTableBuilder setSelectable(final boolean selectable) {
        treeTable.setSelectable(selectable);
        return this;
    }

    public TreeTableBuilder setSizeFull() {
        treeTable.setSizeFull();
        return this;
    }

    public TreeTableBuilder setSortAscending(final boolean sortAscending) {
        treeTable.setSortAscending(sortAscending);
        return this;
    }

    public TreeTableBuilder setSortContainerPropertyId(final Object sortContainerPropertyId) {
        treeTable.setSortContainerPropertyId(sortContainerPropertyId);
        return this;
    }

    public TreeTableBuilder setStyleName(final String styleName) {
        treeTable.setStyleName(styleName);
        return this;
    }

    public TreeTableBuilder setStyleName(final String styleName, final boolean add) {
        treeTable.setStyleName(styleName, add);
        return this;
    }

    public TreeTableBuilder setTabIndex(final int tabIndex) {
        treeTable.setTabIndex(tabIndex);
        return this;
    }

    public TreeTableBuilder setTreeTableFieldFactory(final TableFieldFactory treeTableFieldFactory) {
        treeTable.setTableFieldFactory(treeTableFieldFactory);
        return this;
    }

    public TreeTableBuilder setValidationVisible(final boolean validationVisible) {
        treeTable.setValidationVisible(validationVisible);
        return this;
    }

    public TreeTableBuilder setValue(final Object value) {
        treeTable.setValue(value);
        return this;
    }

    public TreeTableBuilder setVisible(final boolean visible) {
        treeTable.setVisible(visible);
        return this;
    }

    public TreeTableBuilder setVisibleColumns(final Object[] visibleColumns) {
        treeTable.setVisibleColumns(visibleColumns);
        return this;
    }

    public TreeTableBuilder setWidth(final String width) {
        treeTable.setWidth(width);
        return this;
    }

    public TreeTableBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        treeTable.setWidth(width, unit);
        return this;
    }
}