package com.jvirriel.database.xml.catalogue;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.ATTRIBUTE;
import static com.jvirriel.database.xml.constant.XmlTagNameConstants.NAME;
import static com.jvirriel.database.xml.constant.XmlTagNameConstants.VALUE;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlRootElement(name = ATTRIBUTE)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {NAME, VALUE})
public class Attribute {
    @XmlAttribute(name = NAME)
    private String name;

    @XmlAttribute(name = VALUE)
    private String value;

    public Attribute() {

    }

    public Attribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Attribute(Attribute attribute) {
        this.name = attribute.name;
        this.value = attribute.value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attribute withName(String name) {
        this.name = name;

        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Attribute withValue(String value) {
        this.value = value;

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

            return result;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return null;
        }
    }
}
