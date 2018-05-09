package com.jvirriel.demo.frontend.components.custom.tagsfield;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


abstract class AbstractTagsField extends CustomComponent implements TagsField {

    protected Dialog formDialog;

    protected class Dialog {
        private Window modal;

        private VerticalLayout mainLayout;

        private HorizontalLayout contentLayout;

        private HorizontalLayout buttonLayout;

        private Button acceptButton;

        private Component dialogContent;

        Dialog(final String caption) {
            // Layout for the dialog body (icon & message)
            contentLayout = ComponentFactory
                    .horizontalLayout()
                    .setMargin(false)
                    .setSpacing(false)
                    .get();


            // Buttons of the footer
            acceptButton = ComponentFactory
                    .button("Aceptar")
                    .get();

            Button cancelButton = ComponentFactory
                    .button("Cancelar")
                    .addClickListener(clickEvent -> modal.close())
                    .get();

            // Layout ofr the buttons
            buttonLayout = ComponentFactory
                    .horizontalLayout()
                    .setMargin(true)
                    .setSpacing(true)
                    .addComponent(acceptButton, cancelButton)
                    .get();

            // Create the top-level layout of the window
            mainLayout = ComponentFactory
                    .verticalLayout()
                    .setMargin(new MarginInfo(false, false, false, false))
                    .setSpacing(true)
                    .addComponents(contentLayout, buttonLayout)
                    .get();

            mainLayout.setExpandRatio(contentLayout, 1.0f);
            mainLayout.setComponentAlignment(buttonLayout, Alignment.BOTTOM_RIGHT);
            mainLayout.setWidth(8, Unit.INCH);
            mainLayout.setHeight(6,Unit.INCH);

            modal = ComponentFactory.modalWindow(caption)
                    .center()
                    .setResizable(false)
                    .setDraggable(false)
                    .get();

            modal.setContent(mainLayout);

        }

        public Window getWindow() {
            return modal;
        }

        public void setAcceptListener(Button.ClickListener listener) {
            acceptButton.addClickListener(listener);
        }

        public Component getDialogContent() {
            return this.dialogContent;
        }

        public void setDialogContent(Component content) {
            if (this.dialogContent != null) {
                contentLayout.removeComponent(this.dialogContent);
            }

            this.dialogContent = content;

            if (content != null) {
                content.setSizeFull();
                contentLayout.setHeight(2,Unit.INCH);
                contentLayout.addComponent(content, contentLayout.getComponentCount());
                contentLayout.setExpandRatio(content, 1.0f);
                contentLayout.setComponentAlignment(content, Alignment.MIDDLE_CENTER);

            }
        }
    }

    protected HorizontalLayout componentLayout;

    protected Panel tagsContainer;

    protected CssLayout tagsContainerLayout;

    protected Button tagAdder;

    AbstractTagsField(final String caption) {
        formDialog = new Dialog(caption);

        tagsContainerLayout = ComponentFactory
                .cssLayout()
                .setWidth(100, Unit.PERCENTAGE)
                .get();

        tagsContainer = ComponentFactory
                .panel()
                .setContent(tagsContainerLayout)
                .setStyleName(ValoTheme.PANEL_BORDERLESS)
                .get();
        tagsContainer.setSizeUndefined();

        tagAdder = ComponentFactory
                .button(VaadinIcons.ELLIPSIS_H)
                .setSizeUndefined()
                .addClickListener(clickEvent -> {
                    updateModalDialog();
                    UI.getCurrent().addWindow(formDialog.getWindow());
                })
                .get();

        componentLayout = ComponentFactory
                .horizontalLayout()
                .addComponent(tagsContainer, tagAdder)
                .setSpacing(true)
                .setMargin(new MarginInfo(false, false, false, false))
                .setSizeUndefined()
                .get();

        setSizeUndefined();

        setCompositionRoot(componentLayout);
    }

    @Override
    public void addTag(Tag tag) {
        tagsContainerLayout.addComponent(tag);
    }

    @Override
    public void removeTag(Tag tag) {
        tagsContainerLayout.removeComponent(tag);
    }

    @Override
    public void setTags(List<Tag> tags) {
        tagsContainerLayout.removeAllComponents();

        for (Tag item : tags) {
            tagsContainerLayout.addComponent(item);
        }
    }

    @Override
    public List<Tag> getTags() {
        List<Tag> tags = new ArrayList<>();
        Iterator<Component> tagsIterator = tagsContainerLayout.iterator();

        while (tagsIterator.hasNext()) {
            tags.add((Tag) tagsIterator.next());
        }

        return tags;
    }

    abstract void updateModalDialog();
}
