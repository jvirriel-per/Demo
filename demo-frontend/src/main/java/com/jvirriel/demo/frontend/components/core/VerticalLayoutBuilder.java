package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo VerticalLayout.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/VerticalLayout.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public final class VerticalLayoutBuilder {

    /**
     * delegate
     */
    private final VerticalLayout verticalLayout;

    /**
     * Hide constructor, use static factory methods.
     */
    private VerticalLayoutBuilder(final VerticalLayout verticalLayout) {
        this.verticalLayout = verticalLayout;
    }

    /**
     * @return
     *         the created instance
     */
    public final VerticalLayout get() {
        return verticalLayout;
    }

    public static VerticalLayoutBuilder verticalLayout() {
        return new VerticalLayoutBuilder(new VerticalLayout());
    }

    public static VerticalLayoutBuilder verticalLayout(final Component... components) {
        return new VerticalLayoutBuilder(new VerticalLayout(components));
    }

    public VerticalLayoutBuilder addComponentAsFirst(final Component... componentAsFirsts) {
        for (final Component componentAsFirst : componentAsFirsts) {
            verticalLayout.addComponentAsFirst(componentAsFirst);
        }
        return this;
    }

    public VerticalLayoutBuilder addComponents(final Component... components) {
        verticalLayout.addComponents(components);
        return this;
    }

    public VerticalLayoutBuilder addComponentsAndExpand(Component... components) {
        verticalLayout.addComponentsAndExpand(components);
        return this;
    }

    public VerticalLayoutBuilder addAttachListener(
            final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            verticalLayout.addAttachListener(attachListener);
        }
        return this;
    }

    public VerticalLayoutBuilder addComponentAttachListener(
            final com.vaadin.ui.HasComponents.ComponentAttachListener... componentAttachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentAttachListener componentAttachListener : componentAttachListeners) {
            verticalLayout.addComponentAttachListener(componentAttachListener);
        }
        return this;
    }

    public VerticalLayoutBuilder addComponentDetachListener(
            final com.vaadin.ui.HasComponents.ComponentDetachListener... componentDetachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentDetachListener componentDetachListener : componentDetachListeners) {
            verticalLayout.addComponentDetachListener(componentDetachListener);
        }
        return this;
    }

    public VerticalLayoutBuilder addDetachListener(
            final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            verticalLayout.addDetachListener(detachListener);
        }
        return this;
    }

    public VerticalLayoutBuilder addLayoutClickListener(
            final com.vaadin.event.LayoutEvents.LayoutClickListener... layoutClickListeners) {
        for (final com.vaadin.event.LayoutEvents.LayoutClickListener layoutClickListener : layoutClickListeners) {
            verticalLayout.addLayoutClickListener(layoutClickListener);
        }
        return this;
    }

    public VerticalLayoutBuilder addListener(final Component.Listener... listeners) {
        for (final Component.Listener listener : listeners) {
            verticalLayout.addListener(listener);
        }
        return this;
    }

    public VerticalLayoutBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            verticalLayout.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public VerticalLayoutBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            verticalLayout.addStyleName(styleName);
        }
        return this;
    }

    public VerticalLayoutBuilder setCaption(final String caption) {
        verticalLayout.setCaption(caption);
        return this;
    }

    public VerticalLayoutBuilder setComponentAlignment(Component childComponent, Alignment alignment) {
        verticalLayout.setComponentAlignment(childComponent, alignment);
        return this;
    }

    public VerticalLayoutBuilder setComponentError(final ErrorMessage componentError) {
        verticalLayout.setComponentError(componentError);
        return this;
    }

    public VerticalLayoutBuilder setData(final Object data) {
        verticalLayout.setData(data);
        return this;
    }

    public VerticalLayoutBuilder setDescription(final String description) {
        verticalLayout.setDescription(description);
        return this;
    }

    public VerticalLayoutBuilder setEnabled(final boolean enabled) {
        verticalLayout.setEnabled(enabled);
        return this;
    }

    public VerticalLayoutBuilder setSizeUndefined() {
        verticalLayout.setSizeUndefined();
        return this;
    }

    public VerticalLayoutBuilder setErrorHandler(final ErrorHandler errorHandler) {
        verticalLayout.setErrorHandler(errorHandler);
        return this;
    }

    public VerticalLayoutBuilder setHeight(final String height) {
        verticalLayout.setHeight(height);
        return this;
    }

    public VerticalLayoutBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        verticalLayout.setHeight(height, unit);
        return this;
    }

    public VerticalLayoutBuilder setIcon(final Resource icon) {
        verticalLayout.setIcon(icon);
        return this;
    }

    public VerticalLayoutBuilder setLocale(final Locale locale) {
        verticalLayout.setLocale(locale);
        return this;
    }

    public VerticalLayoutBuilder setMargin(final boolean margin) {
        verticalLayout.setMargin(margin);
        return this;
    }

    public VerticalLayoutBuilder setMargin(final MarginInfo margin) {
        verticalLayout.setMargin(margin);
        return this;
    }

    public VerticalLayoutBuilder setPrimaryStyleName(final String primaryStyleName) {
        verticalLayout.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public VerticalLayoutBuilder setSizeFull() {
        verticalLayout.setSizeFull();
        return this;
    }

    public VerticalLayoutBuilder setSpacing(final boolean spacing) {
        verticalLayout.setSpacing(spacing);
        return this;
    }

    public VerticalLayoutBuilder setStyleName(final String styleName) {
        verticalLayout.setStyleName(styleName);
        return this;
    }

    public VerticalLayoutBuilder setStyleName(final String styleName, final boolean add) {
        verticalLayout.setStyleName(styleName, add);
        return this;
    }

    public VerticalLayoutBuilder setVisible(final boolean visible) {
        verticalLayout.setVisible(visible);
        return this;
    }

    public VerticalLayoutBuilder setWidth(final String width) {
        verticalLayout.setWidth(width);
        return this;
    }

    public VerticalLayoutBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        verticalLayout.setWidth(width, unit);
        return this;
    }
}
