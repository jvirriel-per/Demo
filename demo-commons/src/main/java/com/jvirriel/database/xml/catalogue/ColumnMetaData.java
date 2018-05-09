package com.jvirriel.database.xml.catalogue;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static com.pt.core.database.xml.constant.XmlTagNameConstants.*;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlRootElement(name = META_DATA)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {COLUMN_NAME, COLUMN_TYPE, LENGTH, COLUMN_CLASS, NULLABLE, READ_ONLY, WRITABLE})
public class ColumnMetaData {
    @XmlAttribute(name = NAME)
    private String columnName;

    @XmlAttribute(name = TYPE)
    private String columnType;

    @XmlAttribute(name = CLASS)
    private String columnClass;

    @XmlAttribute(name = IS_NULLABLE)
    private Boolean nullable;

    @XmlAttribute(name = LENGTH)
    private String length;
    
    @XmlAttribute(name = IS_READ_ONLY)
    private Boolean readOnly;

    @XmlAttribute(name = IS_WRITABLE)
    private Boolean writable;

    public ColumnMetaData() {
        this.nullable = Boolean.TRUE;
        this.readOnly = Boolean.FALSE;
        this.writable = Boolean.TRUE;
    }

    public ColumnMetaData(String columnName, String columnType, String columnClass, Boolean nullable, String length, 
                          Boolean readOnly, Boolean writable) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnClass = columnClass;
        this.nullable = nullable;
        this.length = length;
        this.readOnly = readOnly;
        this.writable = writable;
    }

    public ColumnMetaData(ColumnMetaData columnMetaData) {
        this.columnName = columnMetaData.columnName;
        this.columnType = columnMetaData.columnType;
        this.columnClass = columnMetaData.columnClass;
        this.nullable = columnMetaData.nullable;
        this.length = columnMetaData.length;
        this.readOnly = columnMetaData.readOnly;
        this.writable = columnMetaData.writable;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnMetaData withColumnName(String columnName) {
        this.columnName = columnName;

        return this;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public ColumnMetaData withColumnType(String columnType) {
        this.columnType = columnType;

        return this;
    }

    public String getColumnClass() {
        return columnClass;
    }

    public void setColumnClass(String columnClass) {
        this.columnClass = columnClass;
    }

    public ColumnMetaData withColumnClass(String columnClass) {
        this.columnClass = columnClass;

        return this;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public ColumnMetaData withLength(int length) {
        this.length = Integer.toString(length);

        return this;
    }

    public Boolean isNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public ColumnMetaData withNullable(Boolean nullable) {
        this.nullable = nullable;

        return this;
    }

    public Boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public ColumnMetaData withReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;

        return this;
    }

    public Boolean isWritable() {
        return writable;
    }

    public void setWritable(Boolean writable) {
        this.writable = writable;
    }

    public ColumnMetaData withWritable(Boolean writable) {
        this.writable = writable;

        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Map<String, String> asMap() {
        try {
            Map<String, String> result = BeanUtils.describe(this);

            result.remove("class");

            result.put("nullable", this.nullable.toString());
            result.put("readOnly", this.readOnly.toString());
            result.put("writable", this.writable.toString());

            return result;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return null;
        }
    }
}
