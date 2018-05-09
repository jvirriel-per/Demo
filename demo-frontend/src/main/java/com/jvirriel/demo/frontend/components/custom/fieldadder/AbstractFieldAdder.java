package com.jvirriel.demo.frontend.components.custom.fieldadder;

import com.pt.components.ComponentFactory;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Iterator;

public abstract class AbstractFieldAdder extends CustomComponent implements CustomFieldAdder {

    protected class MinusField extends HorizontalLayout {
        private Button removeButton;

        private Component fields;

        public MinusField(Component fields) {
            removeButton = ComponentFactory
                    .button(VaadinIcons.MINUS)
                    .setStyleName(ValoTheme.BUTTON_BORDERLESS)
                    .get();

            this.fields = fields;

            super.addComponents(this.fields, removeButton);
            super.setComponentAlignment(this.fields, Alignment.MIDDLE_LEFT);
            super.setComponentAlignment(this.fields, Alignment.MIDDLE_RIGHT);
        }

        public void addClickListener(Button.ClickListener listener) {
            removeButton.addClickListener(listener);
        }

        public Component getFields() {
            return fields;
        }
    }

    protected VerticalLayout componentLayout;

    protected VerticalLayout fieldsLayout;

    public AbstractFieldAdder() {
        fieldsLayout = ComponentFactory
                .verticalLayout()
                .setSpacing(Boolean.TRUE)
                .setSizeUndefined()
                .get();

        Panel panelLayouts = ComponentFactory.panel()
                .setContent(fieldsLayout)
                .setHeight(5, Unit.INCH)
                .setStyleName(ValoTheme.PANEL_BORDERLESS)
                .get();

        Button addingButton = ComponentFactory
                .button(VaadinIcons.PLUS)
                .setStyleName(ValoTheme.BUTTON_BORDERLESS)
                .addClickListener((Button.ClickListener) (clickEvent) -> duplicateField())
                .get();

        HorizontalLayout buttonLayout = ComponentFactory
                .horizontalLayout()
                .addComponent(addingButton)
                .setSizeUndefined()
                .get();
        buttonLayout.setComponentAlignment(addingButton, Alignment.MIDDLE_LEFT);

        componentLayout = ComponentFactory
                .verticalLayout()
                .setSpacing(Boolean.TRUE)
                .addComponents(buttonLayout, panelLayouts)
                .setSizeUndefined()
                .get();

        setCompositionRoot(componentLayout);
    }

    public void duplicateField() {
        MinusField newField = new MinusField(createMinusFieldContent());

        newField.addClickListener(clickListener -> removeField(newField));

        fieldsLayout.addComponent(newField);
        fieldsLayout.setComponentAlignment(newField, Alignment.MIDDLE_LEFT);
    }

    public void removeField(Component field) {
        Iterator<Component> fieldsIterator = fieldsLayout.iterator();

        while (fieldsIterator.hasNext()) {
            if (field.equals(fieldsIterator.next())) {
                fieldsLayout.removeComponent(field);
                break;
            }
        }
    }

    public int getValuesCount() {
        return fieldsLayout.getComponentCount();
    }

    abstract Component createMinusFieldContent();
}