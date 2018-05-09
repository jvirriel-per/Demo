package com.jvirriel.demo.frontend.components.custom.criteriabuilder;

import java.text.SimpleDateFormat;

public class CriteriaItem {
    static final int VALID_RECORD = 0;
    static final int ERR_NA_FIELD = -1;
    static final int ERR_NA_ELEMENT_CONDITION = -2;
    static final int ERR_NA_GROUP_CONDITION = -3;
    static final int ERR_NA_VALUE = -4;
    static final int ERR_INVALID_VALUE = -5;
    static final int ERR_INVALID_ELEMENT_CONDITION = -6;
    private CriteriaItem parent;
    private boolean flagGroup;
    private CriteriaField field;
    private boolean flagNot;
    private CriteriaCondition elementCondition;
    private CriteriaCondition groupCondition;
    private String value;
    private boolean ignoreCase;

    public CriteriaItem(CriteriaItem parent, CriteriaField field, boolean flagNot, CriteriaCondition elementCondition, String value, boolean ignoreCase) {
        this.parent = parent;
        this.field = field;
        this.flagNot = flagNot;
        this.elementCondition = elementCondition;
        this.value = value;
        this.flagGroup = false;
        this.ignoreCase = ignoreCase;
    }

    public CriteriaItem(CriteriaItem parent, boolean flagNot, CriteriaCondition groupCondition) {
        this.parent = parent;
        this.flagNot = flagNot;
        this.groupCondition = groupCondition;
        this.flagGroup = true;
    }

    public CriteriaItem() {
    }

    public CriteriaItem getParent() {
        return this.parent;
    }

    public void setParent(CriteriaItem parent) {
        this.parent = parent;
    }

    public boolean isFlagGroup() {
        return this.flagGroup;
    }

    public void setFlagGroup(boolean flagGroup) {
        this.flagGroup = flagGroup;
    }

    public CriteriaField getField() {
        return this.field;
    }

    public void setField(CriteriaField field) {
        this.field = field;
    }

    public boolean isFlagNot() {
        return this.flagNot;
    }

    public void setFlagNot(boolean flagNot) {
        this.flagNot = flagNot;
    }

    public CriteriaCondition getElementCondition() {
        return this.elementCondition;
    }

    public void setElementCondition(CriteriaCondition elementCondition) {
        this.elementCondition = elementCondition;
    }

    public CriteriaCondition getGroupCondition() {
        return this.groupCondition;
    }

    public void setGroupCondition(CriteriaCondition groupCondition) {
        this.groupCondition = groupCondition;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isIgnoreCase() {
        return this.ignoreCase;
    }

    public void setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public int validate() {
        if (this.flagGroup) {
            if (this.groupCondition == null) {
                return -3;
            }
        } else {
            if (this.field == null) {
                return -1;
            }

            if (this.elementCondition == null) {
                return -2;
            }

            String elementConditionName = this.elementCondition.getName();
            if (elementConditionName.equals("isNull")) {
                return 0;
            }

            if (this.value == null) {
                return -4;
            }

            CriteriaField.ClassField classField = this.field.getClassField();
            if (classField != CriteriaField.ClassField.STRING && (elementConditionName.equals("startingWith") || elementConditionName.equals("containing") || elementConditionName.equals("like"))) {
                return -6;
            }

            try {
                switch (classField) {
                    case INTEGER:
                        Integer.parseInt(value);
                        break;
                    case FLOAT:
                        Float.parseFloat(value);
                        break;
                    case DATE:
                        SimpleDateFormat.getDateInstance().parse(value);
                        break;
                    default:
                        break;
                }
            } catch (Exception var4) {
                return -5;
            }
        }

        return 0;
    }
}
