package com.jvirriel.database.xml.dataset;

import com.jvirriel.database.xml.catalogue.Parameter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.CLASS;
import static com.jvirriel.database.xml.constant.XmlTagNameConstants.DATA_SET_PARAMETER;
import static com.jvirriel.database.xml.constant.XmlTagNameConstants.MODE;

@XmlRootElement(name = DATA_SET_PARAMETER)
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(propOrder = {MODE})
public class DataSetParameter extends Parameter {
    @XmlAttribute(name = MODE)
    private String mode;

    public DataSetParameter() {
    }

    public DataSetParameter(String name, String type, String mode, String value) {
        super(name, type, value);

        this.mode = mode;
    }

    public DataSetParameter(DataSetParameter dataSetParameter) {
        super.name = dataSetParameter.name;
        super.type = dataSetParameter.type;
        this.mode = dataSetParameter.mode;
        super.value = dataSetParameter.value;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public DataSetParameter withMode(String mode) {
        this.mode = mode;

        return this;
    }

    @Override
    public DataSetParameter withName(String name) {
        this.name = name;

        return this;
    }

    @Override
    public DataSetParameter withType(String type) {
        this.type = type;

        return this;
    }

    @Override
    public DataSetParameter withValue(String value) {
        this.value = value;

        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
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
