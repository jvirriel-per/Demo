package com.jvirriel.demo.frontend.components.core;

import com.vaadin.data.ValueProvider;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Grid;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/Grid.html">Grid</a>
*/
public class GridBuilder {
    /**
     * delegate
     */
    private final Grid grid;

    /**
     * Hide constructor, use static factory methods.
     */
    private GridBuilder(final Grid grid) {
        this.grid = grid;
    }

    /**
     * @return the created instance
     */
    public final Grid get() {
        return grid;
    }

    public static GridBuilder grid() {
        return new GridBuilder(new Grid());
    }

    /**
     * Table with caption.
     *
     * @param caption
     * @return
     */
    public static GridBuilder grid(final String caption) {
        return new GridBuilder(new Grid(caption));
    }

    public static GridBuilder grid(final String caption, Collection<?> items) {
        return new GridBuilder(new Grid(caption, items));
    }

    public GridBuilder addColumn(String propertyName){
        grid.addColumn(propertyName);
        return this;
    }

    public <T,V> GridBuilder addColumn(ValueProvider<T,V> valueProvider){
        grid.addColumn(valueProvider);
        return this;
    }

    public   GridBuilder setCaption(final String caption) {
        grid.setCaption(caption);
        return this;
    }

    public GridBuilder setHeight(final String height) {
        grid.setHeight(height);
        return this;
    }

    public GridBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        grid.setHeight(height, unit);
        return this;
    }

    public GridBuilder setItems(List<?> items) {
        grid.setItems(items);
        return this;
    }

    public GridBuilder setItems(Stream<?> items) {
        grid.setItems(items);
        return this;
    }

    public GridBuilder setIcon(final Resource icon) {
        grid.setIcon(icon);
        return this;
    }

    public GridBuilder setDescription(final String description) {
        grid.setDescription(description);
        return this;
    }

    public GridBuilder setEnabled(final boolean enabled) {
        grid.setEnabled(enabled);
        return this;
    }

    public GridBuilder setPrimaryStyleName(final String primaryStyleName) {
        grid.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public GridBuilder setResponsive(final boolean responsive) {
        grid.setResponsive(responsive);
        return this;
    }

    public GridBuilder setSizeFull() {
        grid.setSizeFull();
        return this;
    }

    public GridBuilder setStyleName(final String styleName) {
        grid.setStyleName(styleName);
        return this;
    }

    public GridBuilder setStyleName(final String styleName, final boolean add) {
        grid.setStyleName(styleName, add);
        return this;
    }

    public GridBuilder setVisible(final boolean visible) {
        grid.setVisible(visible);
        return this;
    }

    public GridBuilder setWidth(final String width) {
        grid.setWidth(width);
        return this;
    }

    public GridBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        grid.setWidth(width, unit);
        return this;
    }
}