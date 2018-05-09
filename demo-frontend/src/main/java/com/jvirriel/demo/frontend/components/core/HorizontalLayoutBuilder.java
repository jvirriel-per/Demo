package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/HorizontalLayout.html">HorizontalLayout</a>
 */
public final class HorizontalLayoutBuilder {

    /**
     * delegate
     */
    private final HorizontalLayout horizontalLayout;

    /**
     * Hide constructor, use static factory methods.
     */
    private HorizontalLayoutBuilder(final HorizontalLayout horizontalLayout) {
        this.horizontalLayout = horizontalLayout;
    }

    /**
     * @return the created instance
     */
    public final HorizontalLayout get() {
        return horizontalLayout;
    }

    public static HorizontalLayoutBuilder horizontalLayout() {
        return new HorizontalLayoutBuilder(new HorizontalLayout());
    }

    public static HorizontalLayoutBuilder horizontalLayout(final Component... components) {
        return new HorizontalLayoutBuilder(new HorizontalLayout(components));
    }

    public HorizontalLayoutBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            horizontalLayout.addAttachListener(attachListener);
        }
        return this;
    }

    public HorizontalLayoutBuilder addComponent(final Component... components) {
        for (final Component component : components) {
            horizontalLayout.addComponent(component);
        }
        return this;
    }

    public HorizontalLayoutBuilder addComponentAsFirst(final Component... componentAsFirsts) {
        for (final Component componentAsFirst : componentAsFirsts) {
            horizontalLayout.addComponentAsFirst(componentAsFirst);
        }
        return this;
    }

    public HorizontalLayoutBuilder addComponentAttachListener(final com.vaadin.ui.HasComponents.ComponentAttachListener... componentAttachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentAttachListener componentAttachListener : componentAttachListeners) {
            horizontalLayout.addComponentAttachListener(componentAttachListener);
        }
        return this;
    }

    public HorizontalLayoutBuilder addComponentDetachListener(final com.vaadin.ui.HasComponents.ComponentDetachListener... componentDetachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentDetachListener componentDetachListener : componentDetachListeners) {
            horizontalLayout.addComponentDetachListener(componentDetachListener);
        }
        return this;
    }

    public HorizontalLayoutBuilder addComponents(final Component... components) {
        for (final Component component : components) {
            horizontalLayout.addComponents(component);
        }
        return this;
    }

    public HorizontalLayoutBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            horizontalLayout.addDetachListener(detachListener);
        }
        return this;
    }

    public HorizontalLayoutBuilder addLayoutClickListener(final com.vaadin.event.LayoutEvents.LayoutClickListener... layoutClickListeners) {
        for (final com.vaadin.event.LayoutEvents.LayoutClickListener layoutClickListener : layoutClickListeners) {
            horizontalLayout.addLayoutClickListener(layoutClickListener);
        }
        return this;
    }

    public HorizontalLayoutBuilder addListener(final Component.Listener... listeners) {
        for (final Component.Listener listener : listeners) {
            horizontalLayout.addListener(listener);
        }
        return this;
    }

    public HorizontalLayoutBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            horizontalLayout.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public HorizontalLayoutBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            horizontalLayout.addStyleName(styleName);
        }
        return this;
    }

    public HorizontalLayoutBuilder setCaption(final String caption) {
        horizontalLayout.setCaption(caption);
        return this;
    }

    public HorizontalLayoutBuilder setComponentError(final ErrorMessage componentError) {
        horizontalLayout.setComponentError(componentError);
        return this;
    }

    public HorizontalLayoutBuilder setData(final Object data) {
        horizontalLayout.setData(data);
        return this;
    }

    public HorizontalLayoutBuilder setDescription(final String description) {
        horizontalLayout.setDescription(description);
        return this;
    }

    public HorizontalLayoutBuilder setEnabled(final boolean enabled) {
        horizontalLayout.setEnabled(enabled);
        return this;
    }

    public HorizontalLayoutBuilder setErrorHandler(final ErrorHandler errorHandler) {
        horizontalLayout.setErrorHandler(errorHandler);
        return this;
    }

    public HorizontalLayoutBuilder setHeight(final String height) {
        horizontalLayout.setHeight(height);
        return this;
    }

    public HorizontalLayoutBuilder setIcon(final Resource icon) {
        horizontalLayout.setIcon(icon);
        return this;
    }

    public HorizontalLayoutBuilder setLocale(final Locale locale) {
        horizontalLayout.setLocale(locale);
        return this;
    }

    public HorizontalLayoutBuilder setMargin(final boolean margin) {
        horizontalLayout.setMargin(margin);
        return this;
    }

    public HorizontalLayoutBuilder setMargin(final MarginInfo margin) {
        horizontalLayout.setMargin(margin);
        return this;
    }

    public HorizontalLayoutBuilder setPrimaryStyleName(final String primaryStyleName) {
        horizontalLayout.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public HorizontalLayoutBuilder setSizeFull() {
        horizontalLayout.setSizeFull();
        return this;
    }

    public HorizontalLayoutBuilder setSizeUndefined() {
        horizontalLayout.setSizeUndefined();
        return this;
    }

    public HorizontalLayoutBuilder setSpacing(final boolean spacing) {
        horizontalLayout.setSpacing(spacing);
        return this;
    }

    public HorizontalLayoutBuilder setStyleName(final String styleName) {
        horizontalLayout.setStyleName(styleName);
        return this;
    }

    public HorizontalLayoutBuilder setVisible(final boolean visible) {
        horizontalLayout.setVisible(visible);
        return this;
    }

    public HorizontalLayoutBuilder setWidth(final String width) {
        horizontalLayout.setWidth(width);
        return this;
    }

    public HorizontalLayoutBuilder setWidth(final float width, final Sizeable.Unit unit) {
        horizontalLayout.setWidth(width, unit);
        return this;
    }
}