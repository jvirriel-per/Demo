package com.jvirriel.demo.frontend.components.custom.fieldadder;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneFieldAdder extends AbstractFieldAdder {

    @Override
    Component createMinusFieldContent() {
        TextField textField = ComponentFactory.textField().get();

        List<String> typePhone = new ArrayList<>();
        typePhone.add(new String("Móvil"));
        typePhone.add(new String("Local"));

        ComboBox comboBox = ComponentFactory.comboBox()
                .setItems(typePhone)
                .get();

        HorizontalLayout horizontalLayout = ComponentFactory.horizontalLayout()
                .setSpacing(true)
                .addComponents(textField, comboBox)
                .get();
        return horizontalLayout;
    }

    @Override
    public List<List<String>> getValues() {
        List<List<String>> formValues = new ArrayList<>();
        Iterator<Component> fieldsIterator = fieldsLayout.iterator();
        MinusField currentForm;
        HorizontalLayout formField;

        while (fieldsIterator.hasNext()) {
            currentForm = (MinusField) fieldsIterator.next();
            formField = (HorizontalLayout) currentForm.getFields();

            List<String> fieldValue = new ArrayList<>();
            TextField textField = (TextField) formField.getComponent(0);
            ComboBox comboBox = (ComboBox) formField.getComponent(1);
            fieldValue.add(textField.getValue());
            fieldValue.add(String.valueOf(comboBox.getValue()));
            formValues.add(fieldValue);
        }

        return formValues;
    }

    @Override
    public void setValues(List<List<String>> values) {

    }
}
