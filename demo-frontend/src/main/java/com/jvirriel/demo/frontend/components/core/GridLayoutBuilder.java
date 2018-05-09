package com.jvirriel.demo.frontend.components.core;


import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/GridLayout.html">GridLayout</a>
 */
public final class GridLayoutBuilder {

    /**
     * delegate
     */
    private final GridLayout gridLayout;

    /**
     * Hide constructor, use static factory methods.
     */
    private GridLayoutBuilder(final GridLayout gridLayout) {
        this.gridLayout = gridLayout;
    }

    /**
     * @return the created instance
     */
    public final GridLayout get() {
        return gridLayout;
    }

    public static GridLayoutBuilder gridLayout() {
        return new GridLayoutBuilder(new GridLayout());
    }

    public static GridLayoutBuilder gridLayout(final int columns, final int rows) {
        return new GridLayoutBuilder(new GridLayout(columns, rows));
    }

    public static GridLayoutBuilder gridLayout(final int columns, final int rows, final Component... components) {
        return new GridLayoutBuilder(new GridLayout(columns, rows, components));
    }

    public GridLayoutBuilder addComponent(final Component... components) {
        for (final Component component : components) {
            gridLayout.addComponent(component);
        }
        return this;
    }

    public GridLayoutBuilder addComponent(final Component component, final int column,final int row) {
        gridLayout.addComponent(component, column, row);
        return this;
    }

    public GridLayoutBuilder addComponent(Component component, int column1, int row1, int column2, int row2) {
        gridLayout.addComponent(component, column1, row1, column2, row2);
        return this;
    }

    public GridLayoutBuilder addComponents(final Component[]... componentss) {
        for (final Component[] components : componentss) {
            gridLayout.addComponents(components);
        }
        return this;
    }

    public GridLayoutBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            gridLayout.addAttachListener(attachListener);
        }
        return this;
    }

    public GridLayoutBuilder addComponentAttachListener(final com.vaadin.ui.HasComponents.ComponentAttachListener... componentAttachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentAttachListener componentAttachListener : componentAttachListeners) {
            gridLayout.addComponentAttachListener(componentAttachListener);
        }
        return this;
    }

    public GridLayoutBuilder addComponentDetachListener(final com.vaadin.ui.HasComponents.ComponentDetachListener... componentDetachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentDetachListener componentDetachListener : componentDetachListeners) {
            gridLayout.addComponentDetachListener(componentDetachListener);
        }
        return this;
    }

    public GridLayoutBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            gridLayout.addDetachListener(detachListener);
        }
        return this;
    }

    public GridLayoutBuilder addLayoutClickListener(final com.vaadin.event.LayoutEvents.LayoutClickListener... layoutClickListeners) {
        for (final com.vaadin.event.LayoutEvents.LayoutClickListener layoutClickListener : layoutClickListeners) {
            gridLayout.addLayoutClickListener(layoutClickListener);
        }
        return this;
    }

    public GridLayoutBuilder addListener(final Component.Listener... listeners) {
        for (final Component.Listener listener : listeners) {
            gridLayout.addListener(listener);
        }
        return this;
    }

    public GridLayoutBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            gridLayout.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public GridLayoutBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            gridLayout.addStyleName(styleName);
        }
        return this;
    }

    public GridLayoutBuilder setCaption(final String caption) {
        gridLayout.setCaption(caption);
        return this;
    }

    public GridLayoutBuilder setColumns(final int columns) {
        gridLayout.setColumns(columns);
        return this;
    }

    public GridLayoutBuilder setComponentError(final ErrorMessage componentError) {
        gridLayout.setComponentError(componentError);
        return this;
    }

    public GridLayoutBuilder setCursorX(final int cursorX) {
        gridLayout.setCursorX(cursorX);
        return this;
    }

    public GridLayoutBuilder setCursorY(final int cursorY) {
        gridLayout.setCursorY(cursorY);
        return this;
    }

    public GridLayoutBuilder setData(final Object data) {
        gridLayout.setData(data);
        return this;
    }

    public GridLayoutBuilder setDescription(final String description) {
        gridLayout.setDescription(description);
        return this;
    }

    public GridLayoutBuilder setEnabled(final boolean enabled) {
        gridLayout.setEnabled(enabled);
        return this;
    }

    public GridLayoutBuilder setErrorHandler(final ErrorHandler errorHandler) {
        gridLayout.setErrorHandler(errorHandler);
        return this;
    }

    public GridLayoutBuilder setHeight(final String height) {
        gridLayout.setHeight(height);
        return this;
    }

    public GridLayoutBuilder setIcon(final Resource icon) {
        gridLayout.setIcon(icon);
        return this;
    }

    public GridLayoutBuilder setLocale(final Locale locale) {
        gridLayout.setLocale(locale);
        return this;
    }

    public GridLayoutBuilder setMargin(final boolean margin) {
        gridLayout.setMargin(margin);
        return this;
    }

    public GridLayoutBuilder setMargin(final MarginInfo margin) {
        gridLayout.setMargin(margin);
        return this;
    }

    public GridLayoutBuilder setPrimaryStyleName(final String primaryStyleName) {
        gridLayout.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public GridLayoutBuilder setRows(final int rows) {
        gridLayout.setRows(rows);
        return this;
    }

    public GridLayoutBuilder setSizeFull() {
        gridLayout.setSizeFull();
        return this;
    }

    public GridLayoutBuilder setSizeUndefined() {
        gridLayout.setSizeUndefined();
        return this;
    }

    public GridLayoutBuilder setSpacing(final boolean spacing) {
        gridLayout.setSpacing(spacing);
        return this;
    }

    public GridLayoutBuilder setStyleName(final String styleName) {
        gridLayout.setStyleName(styleName);
        return this;
    }

    public GridLayoutBuilder setVisible(final boolean visible) {
        gridLayout.setVisible(visible);
        return this;
    }

    public GridLayoutBuilder setWidth(final String width) {
        gridLayout.setWidth(width);
        return this;
    }
}