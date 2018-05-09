package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/FormLayout.html">FormLayout</a>
 */
public final class FormLayoutBuilder {

    /**
     * delegate
     */
    private final FormLayout formLayout;

    /**
     * Hide constructor, use static factory methods.
     */
    private FormLayoutBuilder(final FormLayout formLayout) {
        this.formLayout = formLayout;
    }

    /**
     * @return
     *         the created instance
     */
    public final FormLayout get() {
        return formLayout;
    }

    public static FormLayoutBuilder formLayout() {
        return new FormLayoutBuilder(new FormLayout());
    }

    public static FormLayoutBuilder formLayout(final Component... components) {
        return new FormLayoutBuilder(new FormLayout(components));
    }

    public FormLayoutBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            formLayout.addAttachListener(attachListener);
        }
        return this;
    }

    public FormLayoutBuilder addComponent(final Component... components) {
        for (final Component component : components) {
            formLayout.addComponent(component);
        }
        return this;
    }

    public FormLayoutBuilder addComponentAsFirst(final Component... componentAsFirsts) {
        for (final Component componentAsFirst : componentAsFirsts) {
            formLayout.addComponentAsFirst(componentAsFirst);
        }
        return this;
    }

    public FormLayoutBuilder addComponentAttachListener(
            final com.vaadin.ui.HasComponents.ComponentAttachListener... componentAttachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentAttachListener componentAttachListener : componentAttachListeners) {
            formLayout.addComponentAttachListener(componentAttachListener);
        }
        return this;
    }

    public FormLayoutBuilder addComponentDetachListener(
            final com.vaadin.ui.HasComponents.ComponentDetachListener... componentDetachListeners) {
        for (final com.vaadin.ui.HasComponents.ComponentDetachListener componentDetachListener : componentDetachListeners) {
            formLayout.addComponentDetachListener(componentDetachListener);
        }
        return this;
    }

    public FormLayoutBuilder addComponents(final Component[]... componentss) {
        for (final Component[] components : componentss) {
            formLayout.addComponents(components);
        }
        return this;
    }

    public FormLayoutBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            formLayout.addDetachListener(detachListener);
        }
        return this;
    }

    public FormLayoutBuilder addLayoutClickListener(final com.vaadin.event.LayoutEvents.LayoutClickListener... layoutClickListeners) {
        for (final com.vaadin.event.LayoutEvents.LayoutClickListener layoutClickListener : layoutClickListeners) {
            formLayout.addLayoutClickListener(layoutClickListener);
        }
        return this;
    }

    public FormLayoutBuilder addListener(final Component.Listener... listeners) {
        for (final Component.Listener listener : listeners) {
            formLayout.addListener(listener);
        }
        return this;
    }

    public FormLayoutBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            formLayout.addShortcutListener(shortcutListener);
        }
        return this;
    }

    public FormLayoutBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            formLayout.addStyleName(styleName);
        }
        return this;
    }

    public FormLayoutBuilder removeStyleName(final String styleName) {
        formLayout.removeStyleName(styleName);
        return this;
    }

    public FormLayoutBuilder setCaption(final String caption) {
        formLayout.setCaption(caption);
        return this;
    }

    public FormLayoutBuilder setComponentError(final ErrorMessage componentError) {
        formLayout.setComponentError(componentError);
        return this;
    }

    public FormLayoutBuilder setData(final Object data) {
        formLayout.setData(data);
        return this;
    }

    public FormLayoutBuilder setDescription(final String description) {
        formLayout.setDescription(description);
        return this;
    }

    public FormLayoutBuilder setEnabled(final boolean enabled) {
        formLayout.setEnabled(enabled);
        return this;
    }

    public FormLayoutBuilder setErrorHandler(final ErrorHandler errorHandler) {
        formLayout.setErrorHandler(errorHandler);
        return this;
    }

    public FormLayoutBuilder setHeight(final String height) {
        formLayout.setHeight(height);
        return this;
    }

    public FormLayoutBuilder setIcon(final Resource icon) {
        formLayout.setIcon(icon);
        return this;
    }

    public FormLayoutBuilder setLocale(final Locale locale) {
        formLayout.setLocale(locale);
        return this;
    }

    public FormLayoutBuilder setMargin(final boolean margin) {
        formLayout.setMargin(margin);
        return this;
    }

    public FormLayoutBuilder setMargin(final MarginInfo margin) {
        formLayout.setMargin(margin);
        return this;
    }

    public FormLayoutBuilder setPrimaryStyleName(final String primaryStyleName) {
        formLayout.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public FormLayoutBuilder setSizeFull(){
        formLayout.setSizeFull();
        return this;
    }

    public FormLayoutBuilder setSizeUndefined(){
        formLayout.setSizeUndefined();
        return this;
    }

    public FormLayoutBuilder setSpacing(final boolean spacing) {
        formLayout.setSpacing(spacing);
        return this;
    }

    public FormLayoutBuilder setStyleName(final String styleName) {
        formLayout.setStyleName(styleName);
        return this;
    }

    public FormLayoutBuilder setStyleName(final String styleName, final Boolean value) {
        formLayout.setStyleName(styleName, value);
        return this;
    }

    public FormLayoutBuilder setVisible(final boolean visible) {
        formLayout.setVisible(visible);
        return this;
    }

    public FormLayoutBuilder setWidth(final String width) {
        formLayout.setWidth(width);
        return this;
    }

}