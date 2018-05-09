package com.jvirriel.demo.frontend.components.custom.criteriabuilder;


import com.vaadin.v7.ui.Table;

import java.util.Collection;

public class CriteriaField {
    private String name;
    private String displayName;
    private ClassField classField;

    public CriteriaField(String name, String displayName, ClassField classField) {
        this.name = name;
        this.displayName = displayName;
        this.classField = classField;
    }

    public CriteriaField(String name, String displayName) {
        this(name, displayName, ClassField.STRING);
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ClassField getClassField() {
        return this.classField;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassField(ClassField classField) {
        this.classField = classField;
    }

    public String toString() {
        return this.displayName;
    }

    public static void getCriteriaField(Table table, Collection<CriteriaField> fields) {
        Object[] var5;
        int var4 = (var5 = table.getVisibleColumns()).length;

        for (int var3 = 0; var3 < var4; ++var3) {
            Object col = var5[var3];
            fields.add(new CriteriaField(col.toString(), table.getColumnHeader(col)));
        }

    }

    public static enum ClassField {
        INTEGER,
        FLOAT,
        DATE,
        STRING;

        private ClassField() {
        }
    }
}
