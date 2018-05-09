package com.jvirriel.demo.frontend.components.core;

import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.CssLayout;

/**
 *  Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/CssLayout.html">Vaadin CssLayout</a>

 */
public class CssLayoutBuilder {

    private final CssLayout cssLayout;

    /**
     * Hide constructor, use static factory methods.
     */
    private CssLayoutBuilder(final CssLayout cssLayout) {
        this.cssLayout = cssLayout;
    }

    /**
     * Creates a Vaadin CssLayout object.
     *
     * @return the created instance
     */
    public final CssLayout get() {
        return cssLayout;
    }

    /**
     * Generates an empty CssLayout.
     *
     * @return the current Builder object.
     */
    public static CssLayoutBuilder cssLayout() {
        return new CssLayoutBuilder(new CssLayout());
    }

    /**
     * Constructs a CssLayout with the given samples in the given order.
     *
     * @param children  the samples to be added to the containers
     * @return the current Builder object.
     */
    public static CssLayoutBuilder cssLayout(com.vaadin.ui.Component... children) {
        return new CssLayoutBuilder(new CssLayout(children));
    }

    /**
     * (non-Javadoc)
     *
     * @param attachListeners
     * @return the current Builder object
     */
    public CssLayoutBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            cssLayout.addAttachListener(attachListener);
        }
        return this;
    }

    /**
     * Adds the samples in the given order to this Product containers.
     *
     * @param components    the samples to add.
     * @return the current Builder object.
     */
    public CssLayoutBuilder addComponents(com.vaadin.ui.Component... components) {
        cssLayout.addComponents(components);
        return this;
    }

    /**
     * Add a click listener to the layout. The listener is called whenever the user clicks inside
     * the layout. An event is also triggered when the click targets a Product inside a nested
     * layout or Panel, provided the targeted Product does not prevent the click event from
     * propagating. A caption is not considered part of a Product.
     *
     * @param listener  the listener to be added
     * @return the current Builder object.
     */
    public CssLayoutBuilder addLayoutClickListener(com.vaadin.event.LayoutEvents.LayoutClickListener listener) {
        cssLayout.addLayoutClickListener(listener);
        return this;
    }

    /**
     * Adds one or more style names to this Product. Multiple styles can be specified as a
     * space-separated list of style names. The style name will be rendered as a HTML class name,
     * which can be used in a CSS definition. More infot at <a href="https://vaadin.com/api/7.7.6/com/vaadin/ui/AbstractComponent.html#addStyleName-java.lang.String-">doc.<a/>
     *
     * @param styleNames    the new style to be added to the Product.
     * @return the current Builder object.
     */
    public CssLayoutBuilder addStyles(final String... styleNames) {
        for (final String styleName : styleNames) {
            cssLayout.addStyleName(styleName);
        }
        return this;
    }

    /**
     * Adds one or more style names to this Product. Multiple styles can be specified as
     * a space-separated list of style names. The style name will be rendered as a HTML
     * class name, which can be used in a CSS definition.
     * @param style - the new style to be added to the Product
     * @return
     */
    public CssLayoutBuilder addStyleName(String style) {
        cssLayout.addStyleName(style);
        return this;
    }

    /**
     * Sets the Product's caption String. Caption is the visible name of the Product.
     * @param caption - the new caption String for the Product.
     * @return
     */
    public CssLayoutBuilder setCaption(String caption) {
        cssLayout.setCaption(caption);
        return this;
    }

    /**
     * Sets the data object, that can be used for any application specific data. The Product
     * does not use or modify this data.
     *
     * @param data  the Application specific data
     * @return the current Builder object.
     */
    public CssLayoutBuilder setData(final Object data) {
        cssLayout.setData(data);
        return this;
    }

    /**
     * (non-Javadoc)
     *
     * @return the current Builder object.
     */
    public CssLayoutBuilder setEnabled(final boolean enabled) {
        cssLayout.setEnabled(enabled);
        return this;
    }

    /**
     * Sets the height of the object. Negative number implies unspecified size
     * (terminal is free to set the size).
     *
     * @param height    the height of the obejct.
     * @return the current Builder object.
     */
    public CssLayoutBuilder setHeight(final String height) {
        cssLayout.setHeight(height);
        return this;
    }

    public CssLayoutBuilder setHeight(final float height, final Sizeable.Unit unit) {
        cssLayout.setHeight(height, unit);
        return this;
    }

    public CssLayoutBuilder setIcon(Resource icon){
        cssLayout.setIcon(icon);
        return this;
    }

    public CssLayoutBuilder setPrimaryStyle(final String primaryStyle) {
        cssLayout.setPrimaryStyleName(primaryStyle);
        return this;
    }

    /**
     * (non-Javadoc)
     *
     * @return the current Builder object.
     */
    public CssLayoutBuilder setResponsive(final boolean responsive) {
        cssLayout.setResponsive(responsive);
        return this;
    }

    public CssLayoutBuilder setSizeFull() {
        cssLayout.setSizeFull();
        return this;
    }

    public CssLayoutBuilder setStyleName(final String styleName) {
        cssLayout.setStyleName(styleName);
        return this;
    }

    public CssLayoutBuilder setStyleName(final String styleName, final boolean add) {
        cssLayout.setStyleName(styleName, add);
        return this;
    }

    /**
     * Sets the Product to be visible in the user interface.
     *
     * @return the current Builder object.
     */
    public CssLayoutBuilder setVisible(final boolean visible) {
        cssLayout.setVisible(visible);
        return this;
    }

    /**
     * Sets the width of the object. Negative number implies unspecified size (terminal is free to set the size).
     *
     * @param width     the width of the object
     * @return the current Builder object.
     */
    public CssLayoutBuilder setWidth(final String width) {
        cssLayout.setWidth(width);
        return this;
    }

    public CssLayoutBuilder setWidth(final float width, final Sizeable.Unit unit) {
        cssLayout.setWidth(width, unit);
        return this;
    }
}