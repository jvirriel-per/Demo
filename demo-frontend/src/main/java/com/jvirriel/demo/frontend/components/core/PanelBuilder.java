package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.Action;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo Panel.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/Panel.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public final class PanelBuilder {

    /**
     * delegate
     */
    private final Panel panel;

    /**
     * Hide constructor, use static factory methods.
     */
    private PanelBuilder(final Panel panel) {
        this.panel = panel;
    }

    /**
     * @return the created instance
     */
    public final Panel get() {
        return panel;
    }

    public static PanelBuilder panel() {
        return new PanelBuilder(new Panel());
    }

    public static PanelBuilder panel(final Component component) {
        return new PanelBuilder(new Panel(component));
    }

    public static PanelBuilder panel(final String caption) {
        return new PanelBuilder(new Panel(caption));
    }

    public static PanelBuilder panel(final String caption, final Component component) {
        return new PanelBuilder(new Panel(caption, component));
    }

    public PanelBuilder addActionHandler(final Action.Handler... actionHandlers) {
        for (final Action.Handler actionHandler : actionHandlers) {
            panel.addActionHandler(actionHandler);
        }
        return this;
    }

    public PanelBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            panel.addAttachListener(attachListener);
        }
        return this;
    }

    public PanelBuilder addClickListener(final com.vaadin.event.MouseEvents.ClickListener... clickListeners) {
        for (final com.vaadin.event.MouseEvents.ClickListener clickListener : clickListeners) {
            panel.addClickListener(clickListener);
        }
        return this;
    }

    public PanelBuilder addComponentAttachListener(final com.vaadin.ui.HasComponents.ComponentAttachListener... componentAttachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentAttachListener componentAttachListener : componentAttachListeners) {
            panel.addComponentAttachListener(componentAttachListener);
        }
        return this;
    }

    public PanelBuilder addComponentDetachListener(
            final com.vaadin.ui.HasComponents.ComponentDetachListener... componentDetachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentDetachListener componentDetachListener : componentDetachListeners) {
            panel.addComponentDetachListener(componentDetachListener);
        }
        return this;
    }

    public PanelBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            panel.addDetachListener(detachListener);
        }
        return this;
    }

    public PanelBuilder addListener(final Component.Listener... listeners) {
        for (final Component.Listener listener : listeners) {
            panel.addListener(listener);
        }
        return this;
    }

    public PanelBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            panel.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public PanelBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            panel.addStyleName(styleName);
        }
        return this;
    }

    public PanelBuilder setCaption(final String caption) {
        panel.setCaption(caption);
        return this;
    }

    public PanelBuilder setComponentError(final ErrorMessage componentError) {
        panel.setComponentError(componentError);
        return this;
    }

    public PanelBuilder setContent(final Component content) {
        panel.setContent(content);
        return this;
    }

    public PanelBuilder setData(final Object data) {
        panel.setData(data);
        return this;
    }

    public PanelBuilder setDescription(final String description) {
        panel.setDescription(description);
        return this;
    }

    public PanelBuilder setEnabled(final boolean enabled) {
        panel.setEnabled(enabled);
        return this;
    }

    public PanelBuilder setErrorHandler(final ErrorHandler errorHandler) {
        panel.setErrorHandler(errorHandler);
        return this;
    }

    public PanelBuilder setHeight(final String height) {
        panel.setHeight(height);
        return this;
    }

    public PanelBuilder setHeight(final float height, final Sizeable.Unit unit) {
        panel.setHeight(height, unit);
        return this;
    }

    public PanelBuilder setIcon(final Resource icon) {
        panel.setIcon(icon);
        return this;
    }

    public PanelBuilder setLocale(final Locale locale) {
        panel.setLocale(locale);
        return this;
    }

    public PanelBuilder setPrimaryStyleName(final String primaryStyleName) {
        panel.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public PanelBuilder setScrollLeft(final int scrollLeft) {
        panel.setScrollLeft(scrollLeft);
        return this;
    }

    public PanelBuilder setScrollTop(final int scrollTop) {
        panel.setScrollTop(scrollTop);
        return this;
    }

    public PanelBuilder setSizeFull(){
        panel.setSizeFull();
        return this;
    }

    public PanelBuilder setStyleName(final String styleName) {
        panel.setStyleName(styleName);
        return this;
    }

    public PanelBuilder setStyleName(final String styleName, final boolean add) {
        panel.setStyleName(styleName, add);
        return this;
    }

    public PanelBuilder setTabIndex(final int tabIndex) {
        panel.setTabIndex(tabIndex);
        return this;
    }

    public PanelBuilder setVisible(final boolean visible) {
        panel.setVisible(visible);
        return this;
    }

    public PanelBuilder setWidth(final String width) {
        panel.setWidth(width);
        return this;
    }

    public PanelBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        panel.setWidth(width, unit);
        return this;
    }
}