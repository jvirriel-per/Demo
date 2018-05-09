package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.MenuBar;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo MenuBar.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/MenuBar.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public class MenuBarBuilder {
    /**
     * delegate
     */
    private final MenuBar menuBar;

    /**
     * Hide constructor, use static factory methods.
     */
    private MenuBarBuilder(final MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    /**
     * @return the created instance
     */
    public final MenuBar get() {
        return menuBar;
    }

    /**
     * Empty menuBar.
     *
     * @return menuBar.
     */
    public static MenuBarBuilder menuBar() {
        return new MenuBarBuilder(new MenuBar());
    }

    public MenuBarBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            menuBar.addListener(listener);
        }
        return this;
    }

    public MenuBarBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            menuBar.addAttachListener(attachListener);
        }
        return this;
    }

    public MenuBarBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            menuBar.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public MenuBarBuilder setStyleName(final String styleName) {
        menuBar.setStyleName(styleName);
        return this;
    }

    public MenuBarBuilder setStyleName(final String styleName, final boolean add) {
        menuBar.setStyleName(styleName, add);
        return this;
    }

    public MenuBarBuilder addItem(final String caption, final MenuBar.Command command) {
        menuBar.addItem(caption, command);
        return this;
    }

    public MenuBarBuilder addItem(final String caption, final Resource icon, final MenuBar.Command command) {
        menuBar.addItem(caption, icon, command);
        return this;
    }

    public MenuBarBuilder addItemBefore(final String caption, final Resource icon, final MenuBar.Command command,
                                        final MenuBar.MenuItem itemToAddBefore) {
        menuBar.addItemBefore(caption, icon, command, itemToAddBefore);
        return this;
    }

    public MenuBarBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            menuBar.addStyleName(styleName);
        }
        return this;
    }

    public MenuBarBuilder setCaption(final String caption) {
        menuBar.setCaption(caption);
        return this;
    }

    public MenuBarBuilder setCaptionAsHtml(final Boolean captionAsHtml) {
        menuBar.setCaptionAsHtml(captionAsHtml);
        return this;
    }

    public MenuBarBuilder setData(final Object data) {
        menuBar.setData(data);
        return this;
    }

    public MenuBarBuilder setHeight(final String height) {
        menuBar.setHeight(height);
        return this;
    }

    public MenuBarBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        menuBar.setHeight(height, unit);
        return this;
    }

    public MenuBarBuilder setIcon(final Resource icon) {
        menuBar.setIcon(icon);
        return this;
    }

    public MenuBarBuilder setPrimaryStyleName(final String primaryStyleName) {
        menuBar.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public MenuBarBuilder removeItem(final MenuBar.MenuItem item) {
        menuBar.removeItem(item);
        return this;
    }

    public MenuBarBuilder removeStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            menuBar.removeStyleName(styleName);
        }
        return this;
    }

    public MenuBarBuilder setAutoOpen(final boolean autoOpenTopLevelMenu) {
        menuBar.setAutoOpen(autoOpenTopLevelMenu);
        return this;
    }

    public MenuBarBuilder setHtmlContentAllowed(final boolean htmlContentAllowed) {
        menuBar.setHtmlContentAllowed(htmlContentAllowed);
        return this;
    }

    public MenuBarBuilder setMoreMenuItem(final MenuBar.MenuItem item) {
        menuBar.setMoreMenuItem(item);
        return this;
    }

    public MenuBarBuilder setTabIndex(final int tabIndex) {
        menuBar.setTabIndex(tabIndex);
        return this;
    }

    public MenuBarBuilder setVisible(final boolean visible) {
        menuBar.setVisible(visible);
        return this;
    }
}