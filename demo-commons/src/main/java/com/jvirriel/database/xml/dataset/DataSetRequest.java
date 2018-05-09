package com.jvirriel.database.xml.dataset;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@XmlRootElement(name = DATA_SET_REQUEST)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {CODE, FORMAT, PARAMETERS})
public class DataSetRequest {
    @XmlAttribute(name = CODE)
    String code;

    @XmlAttribute(name = FORMAT)
    String format;

    @XmlElementWrapper(name = PARAMETERS)
    @XmlElement(name = PARAMETER)
    List<DataSetParameter> parameters;

    public DataSetRequest() {
        this.parameters = new ArrayList<>();
    }

    public DataSetRequest(String code, String format, List<DataSetParameter> parameters) {
        this.code = code;
        this.format = format;
        this.parameters = parameters;
    }

    public DataSetRequest(DataSetRequest dataSetRequest) {
        this.code = dataSetRequest.code;
        this.format = dataSetRequest.format;
        this.parameters = dataSetRequest.parameters;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataSetRequest withCode(String code) {
        this.code = code;

        return this;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public DataSetRequest withFormat(String format) {
        this.format = format;

        return this;
    }

    public DataSetParameter getParameter(String name) {
        return getParameterByName(name);
    }

    public List<DataSetParameter> getParameters() {
        return parameters;
    }

    public String getParameterType(String name) {
        DataSetParameter result = getParameterByName(name);

        return nonNull(result) ? result.getType() : "";
    }

    public String getParameterValue(String name) {
        DataSetParameter result = getParameterByName(name);

        return nonNull(result) ? result.getValue() : "";
    }

    public void setParameters(List<DataSetParameter> parameters) {
        this.parameters = parameters;
    }

    public DataSetRequest withParameter(DataSetParameter parameter) {
        this.parameters.add(parameter);

        return this;
    }

    public DataSetRequest withParameters(List<DataSetParameter> parameters) {
        this.parameters = parameters;

        return this;
    }

    public Boolean isAnyParameterTypeEmpty() {
        return this.parameters
                .stream()
                .anyMatch(elem -> isEmpty(elem.getType()));
    }

    public Boolean isAnyParameterValueEmpty() {
        return this.parameters
                .stream()
                .anyMatch(elem -> isEmpty(elem.getValue()));
    }

    public Boolean isCodeEmpty() {
        return StringUtils.isEmpty(this.code);
    }

    public Boolean isFormatEmpty() {
        return StringUtils.isEmpty(this.format);
    }

    public Boolean isParamtersEmtpy() {
        return this.isParametersNull() || this.parameters.isEmpty();
    }

    public Boolean isParametersNull() {
        return isNull(this.parameters);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private DataSetParameter getParameterByName(String name) {
        Predicate<DataSetParameter> predicate = elem -> elem.getName().equals(name);

        return this.parameters
                .stream()
                .anyMatch(predicate) ?
                this.parameters
                        .stream()
                        .filter(predicate)
                        .collect(toList())
                        .get(0) : null;
    }
}
