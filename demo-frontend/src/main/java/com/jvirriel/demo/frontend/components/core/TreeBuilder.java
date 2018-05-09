package com.jvirriel.demo.frontend.components.core;

import com.vaadin.server.Sizeable;
import com.vaadin.v7.ui.Tree;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo Tree.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/7.6.8/com/vaadin/ui/Tree.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public final class TreeBuilder {

    private final Tree tree;

    private TreeBuilder(final Tree tree) {
        this.tree = tree;
    }

    public Tree get() {
        return tree;
    }

    public static TreeBuilder tree() {
        return new TreeBuilder(new Tree());
    }

    public static TreeBuilder tree(final String caption) {
        return new TreeBuilder(new Tree(caption));
    }

    public TreeBuilder addCollapseListener(Tree.CollapseListener listener) {
        tree.addCollapseListener(listener);
        return this;
    }

    public TreeBuilder addExpandListener(Tree.ExpandListener listener) {
        tree.addExpandListener(listener);
        return this;
    }

    public TreeBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            tree.addStyleName(styleName);
        }
        return this;
    }

    public TreeBuilder setCaption(final String caption) {
        tree.setCaption(caption);
        return this;
    }

    public TreeBuilder setDragMode(final Tree.TreeDragMode dragMode) {
        tree.setDragMode(dragMode);
        return this;
    }

    public TreeBuilder setHeight(final String height) {
        tree.setHeight(height);
        return this;
    }

    public TreeBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        tree.setHeight(height, unit);
        return this;
    }

    public TreeBuilder setHtmlContentAllowed(final boolean htmlContentAllowed) {
        tree.setHtmlContentAllowed(htmlContentAllowed);
        return this;
    }

    public TreeBuilder setImmediate(final boolean immediate) {
        tree.setImmediate(immediate);
        return this;
    }

    public TreeBuilder setItemCaptionPropertyId(Object propertyId) {
        tree.setItemCaptionPropertyId(propertyId);
        return this;
    }

    public TreeBuilder setItemIconPropertyId(Object propertyId) {
        tree.setItemIconPropertyId(propertyId);
        return this;
    }

    public TreeBuilder setItemStyleGenerator(Tree.ItemStyleGenerator itemStyleGenerator) {
        tree.setItemStyleGenerator(itemStyleGenerator);
        return this;
    }

    public TreeBuilder setMultiselectMode(com.vaadin.shared.ui.MultiSelectMode mode) {
        tree.setMultiselectMode(mode);
        return this;
    }

    public TreeBuilder setNewItemsAllowed(boolean allowNewOptions) {
        tree.setNewItemsAllowed(allowNewOptions);
        return this;
    }

    public TreeBuilder setPrimaryStyleName(final String primaryStyleName) {
        tree.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public TreeBuilder setReadOnly(final boolean readOnly) {
        tree.setReadOnly(readOnly);
        return this;
    }

    public TreeBuilder setResponsive(final boolean responsive) {
        tree.setResponsive(responsive);
        return this;
    }

    public TreeBuilder setSizeFull() {
        tree.setSizeFull();
        return this;
    }

    public TreeBuilder setStyleName(final String styleName) {
        tree.setStyleName(styleName);
        return this;
    }

    public TreeBuilder setStyleName(final String styleName, final boolean add) {
        tree.setStyleName(styleName, add);
        return this;
    }

    public TreeBuilder setVisible(final boolean visible) {
        tree.setVisible(visible);
        return this;
    }

    public TreeBuilder setWidth(final String width) {
        tree.setWidth(width);
        return this;
    }

    public TreeBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        tree.setWidth(width, unit);
        return this;
    }
}