package com.jvirriel.demo.frontend.components.custom.fieldadder;

import java.util.*;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

public class EmailFieldAdder extends AbstractFieldAdder {

    @Override
    Component createMinusFieldContent() {
        return ComponentFactory.textField().get();
    }

    @Override
    public List<List<String>> getValues() {
        List<List<String>> formValues = new ArrayList<>();
        Iterator<Component> fieldsIterator = fieldsLayout.iterator();
        MinusField currentForm;
        TextField formField;

        while (fieldsIterator.hasNext()) {
            currentForm = (MinusField) fieldsIterator.next();
            formField = (TextField) currentForm.getFields();

            List<String> fieldValue = new ArrayList<>();
            fieldValue.add(0, formField.getValue());
            formValues.add(fieldValue);
        }

        return formValues;
    }

    @Override
    public void setValues(List<List<String>> values) {
        MinusField lastFormAdded;
        TextField lastFormAddedField;
        int index = 0;

        fieldsLayout.removeAllComponents();
        for (List<String> value : values) {
            duplicateField();

            // En duplicateField se agrega un nuevo formulario al FieldAdder, por lo tanto
            // hay que obtener dicho nuevo formulario para asignarle su nuevo valor.
            lastFormAdded = (MinusField) fieldsLayout.getComponent(index);
            lastFormAddedField = (TextField) lastFormAdded.getFields();
            lastFormAddedField.setValue(value.get(0));

            index++;
        }
    }
}
