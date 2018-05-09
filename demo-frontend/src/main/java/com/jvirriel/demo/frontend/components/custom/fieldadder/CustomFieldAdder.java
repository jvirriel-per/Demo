package com.jvirriel.demo.frontend.components.custom.fieldadder;

import java.util.List;

import com.vaadin.ui.Component;

public interface CustomFieldAdder extends Component {

    void duplicateField();

    void removeField(Component field);

    List<List<String>> getValues();

    int getValuesCount();

    void setValues(List<List<String>> values);
}
