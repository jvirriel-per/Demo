package com.jvirriel.demo.frontend.components.custom.fieldadder;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdressFieldAdder extends AbstractFieldAdder {
    @Override
    Component createMinusFieldContent() {
        TextArea textArea = ComponentFactory.textArea()
                .setCaption("Dirección Completa")
                .get();
        List<String> list = new ArrayList<>();
        list.add("Opción 1");
        list.add("Opción 2");
        list.add("Opción 3");

        ComboBox<String> comboBox = ComponentFactory.comboBox("Provincia")
                .setItems(list)
                .get();
        ComboBox<String> comboBox1 = ComponentFactory.comboBox("Cantón")
                .setItems(list)
                .get();
        ComboBox<String> comboBox2 = ComponentFactory.comboBox("Distrito")
                .setItems(list)
                .get();


        VerticalLayout verticalLayout = ComponentFactory.verticalLayout()
                .addComponents(textArea,comboBox,comboBox1,comboBox2)
                .get();

        return verticalLayout;
    }

    @Override
    public List<List<String>> getValues() {
        List<List<String>> formValues = new ArrayList<>();
        Iterator<Component> fieldsIterator = fieldsLayout.iterator();
        MinusField currentForm;
        VerticalLayout formField;

        while (fieldsIterator.hasNext()) {
            currentForm = (MinusField) fieldsIterator.next();
            formField = (VerticalLayout) currentForm.getFields();

            List<String> fieldValue = new ArrayList<>();
            TextArea textArea = (TextArea) formField.getComponent(0);
            ComboBox comboBox = (ComboBox) formField.getComponent(1);
            ComboBox comboBox1 = (ComboBox) formField.getComponent(2);
            ComboBox comboBox2 = (ComboBox) formField.getComponent(3);
            fieldValue.add(textArea.getValue());
            fieldValue.add(String.valueOf(comboBox.getValue()));
            fieldValue.add(String.valueOf(comboBox1.getValue()));
            fieldValue.add(String.valueOf(comboBox2.getValue()));
            formValues.add(fieldValue);
        }

        return formValues;
    }

    @Override
    public void setValues(List<List<String>> values) {

    }
}
