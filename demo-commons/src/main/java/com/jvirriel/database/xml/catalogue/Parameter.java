package com.jvirriel.database.xml.catalogue;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.*;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderXmlConstants.TYPE;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlRootElement(name = PARAMETER)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {NAME, TYPE, VALUE})
public class Parameter {
    @XmlAttribute(name = NAME)
    protected String name;

    @XmlAttribute(name = TYPE)
    protected String type;

    @XmlValue
    protected String value;

    public Parameter() {

    }

    public Parameter(String name, String type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Parameter(Parameter parameter) {
        this.name = parameter.name;
        this.type = parameter.type;
        this.value = parameter.value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parameter withName(String name) {
        this.name = name;

        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Parameter withType(String type) {
        this.type = type;

        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Parameter withValue(String value) {
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

            result.remove(CLASS);

            return result;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return null;
        }
    }
}