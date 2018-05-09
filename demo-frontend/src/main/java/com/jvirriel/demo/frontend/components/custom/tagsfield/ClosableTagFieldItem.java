package com.jvirriel.demo.frontend.components.custom.tagsfield;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


public class ClosableTagFieldItem extends CustomComponent implements TagsField.Tag {

    private Button closeButton;

    private String tagText;

    ClosableTagFieldItem(final String caption) {
        tagText = caption;

        Label text = ComponentFactory
                .label(caption)
                .addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON)
                .setIcon(VaadinIcons.PHONE)
                .setStyleName(ValoTheme.LABEL_COLORED)
                .setSizeUndefined()
                .get();

        closeButton = ComponentFactory
                .button(FontAwesome.REMOVE)
                .setStyleName(ValoTheme.BUTTON_BORDERLESS)
                .setSizeUndefined()
                .get();

        HorizontalLayout tagLayout = ComponentFactory
                .horizontalLayout()
                .addComponent(text, closeButton)
                .setSpacing(false)
                .setSizeUndefined()
                .get();

        Panel tag = ComponentFactory
                .panel(tagLayout)
                .get();

        tag.setSizeUndefined();

        setSizeUndefined();

        setCompositionRoot(tag);
    }

    @Override
    public String getValue() {
        return tagText;
    }

    public void setRemoveTagListener(Button.ClickListener listener) {
        closeButton.addClickListener(listener);
    }
}
