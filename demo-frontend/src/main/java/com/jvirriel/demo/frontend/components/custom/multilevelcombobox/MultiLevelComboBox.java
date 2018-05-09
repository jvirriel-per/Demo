package com.jvirriel.demo.frontend.components.custom.multilevelcombobox;

import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;

import static java.lang.Boolean.FALSE;

public class MultiLevelComboBox<M, L1, L2, L3> extends GridLayout {
    private final ComboBox<M> mainComboBox;
    private final ComboBox<L1> levelOneComboBox;
    private final ComboBox<L2> levelTwoComboBox;
    private final ComboBox<L3> levelThreeComboBox;

    public MultiLevelComboBox() {
        this(RowMode.ONE_ROW, FALSE, FALSE);
    }

    public MultiLevelComboBox(RowMode rowMode, Boolean margin, Boolean spacing) {
        super();

        this.mainComboBox = new ComboBox<>();
        this.mainComboBox.setEmptySelectionAllowed(FALSE);

        this.levelOneComboBox = new ComboBox<>();
        this.levelOneComboBox.setEmptySelectionAllowed(FALSE);

        this.levelTwoComboBox = new ComboBox<>();
        this.levelTwoComboBox.setEmptySelectionAllowed(FALSE);

        this.levelThreeComboBox = new ComboBox<>();
        this.levelThreeComboBox.setEmptySelectionAllowed(FALSE);

        switch (rowMode) {
            case ONE_ROW:
                super.setColumns(4);
                super.setRows(1);
                this.buildComboBoxesInOneRow(margin, spacing);
                break;
            case TWO_ROWS:
                super.setColumns(2);
                super.setRows(2);
                this.buildComboBoxesInTwoRows(margin, spacing);
                break;
        }
    }

    private void buildComboBoxesInOneRow(Boolean margin, Boolean spacing) {
        super.addComponent(mainComboBox, 0, 0);
        super.addComponent(levelOneComboBox, 1, 0);
        super.addComponent(levelTwoComboBox, 2, 0);
        super.addComponent(levelThreeComboBox, 3, 0);

        super.setMargin(margin);
        super.setSpacing(spacing);
    }

    private void buildComboBoxesInTwoRows(Boolean margin, Boolean spacing) {
        super.addComponent(mainComboBox, 0, 0);
        super.addComponent(levelOneComboBox, 1, 0);
        super.addComponent(levelTwoComboBox, 0, 1);
        super.addComponent(levelThreeComboBox, 1, 1);

        super.setMargin(margin);
        super.setSpacing(spacing);
    }

    public ComboBox<M> getMainComboBox() {
        return mainComboBox;
    }

    public ComboBox<L1> getLevelOneComboBox() {
        return levelOneComboBox;
    }

    public ComboBox<L2> getLevelTwoComboBox() {
        return levelTwoComboBox;
    }

    public ComboBox<L3> getLevelThreeComboBox() {
        return levelThreeComboBox;
    }

    public void setMainComboBoxValueChangeListener(ValueChangeListener<M> listener) {
        this.mainComboBox.addValueChangeListener(listener);
    }

    public void setLevelOneComboBoxValueChangeListener(ValueChangeListener<L1> listener) {
        this.levelOneComboBox.addValueChangeListener(listener);
    }

    public void setLevelTwoComboBoxValueChangeListener(ValueChangeListener<L2> listener) {
        this.levelTwoComboBox.addValueChangeListener(listener);
    }

    public void setLevelThreeComboBoxValueChangeListener(ValueChangeListener<L3> listener) {
        this.levelThreeComboBox.addValueChangeListener(listener);
    }

    public enum RowMode {
        ONE_ROW,
        TWO_ROWS
    }
}
