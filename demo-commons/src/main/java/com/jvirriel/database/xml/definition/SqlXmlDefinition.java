package com.jvirriel.database.xml.definition;

import com.jvirriel.database.xml.catalogue.Parameter;
import com.jvirriel.database.xml.dataset.DataSetParameter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.*;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlRootElement(name = SQL_DEFINITION)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {MODE, SQL_CODE, PARAMETERS})
public class SqlXmlDefinition {
    @XmlAttribute(name = MODE)
    private String mode;

    @XmlElement(name = SQL)
    private String sqlCode;

    @XmlElementWrapper(name = PARAMETERS)
    @XmlElement(name = PARAMETER)
    private List<DataSetParameter> parameters;

    public SqlXmlDefinition() {
        this.parameters = new ArrayList<>();
    }

    public SqlXmlDefinition(String mode, String sqlCode, List<DataSetParameter> parameters) {
        this.mode = mode;
        this.sqlCode = sqlCode;
        this.parameters = parameters;
    }

    public SqlXmlDefinition(SqlXmlDefinition sqlXmlDefinition) {
        this.mode = sqlXmlDefinition.mode;
        this.sqlCode = sqlXmlDefinition.sqlCode;
        this.parameters = sqlXmlDefinition.parameters;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public SqlXmlDefinition withMode(String mode) {
        this.mode = mode;

        return this;
    }

    public String getSqlCode() {
        return sqlCode;
    }

    public void setSqlCode(String sqlCode) {
        this.sqlCode = sqlCode;
    }

    public SqlXmlDefinition withSqlCode(String sqlCode) {
        this.sqlCode = sqlCode;

        return this;
    }

    public List<DataSetParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<DataSetParameter> parameters) {
        this.parameters = parameters;
    }

    public String getParameterType(String name) {
        Parameter result = getParameterByName(name);

        return nonNull(result) ? result.getType() : "";
    }

    private Parameter getParameterByName(String name) {
        Predicate<Parameter> predicate = elem -> elem.getName().equals(name);

        return this.parameters
                .stream()
                .anyMatch(predicate) ?
                this.parameters
                        .stream()
                        .filter(predicate)
                        .collect(toList())
                        .get(0) : null;
    }

    public String getParameterValue(String name) {
        Parameter result = getParameterByName(name);

        return nonNull(result) ? result.getValue() : "";
    }

    public SqlXmlDefinition withParameter(DataSetParameter parameter) {
        this.parameters.add(parameter);

        return this;
    }

    public SqlXmlDefinition withParameters(List<DataSetParameter> paramters) {
        this.parameters = paramters;

        return this;
    }

    public Boolean isAnyParameterEmpty() {
        return this.parameters
                .stream()
                .anyMatch(
                        elem -> StringUtils.isEmpty(elem.getMode())
                                || StringUtils.isEmpty(elem.getName())
                                || StringUtils.isEmpty(elem.getType())
                                || StringUtils.isEmpty(elem.getValue())
                );
    }

    public Boolean isModeEmpty() {
        return StringUtils.isEmpty(this.mode);
    }

    public Boolean isSqlCodeEmpty() {
        return StringUtils.isEmpty(this.sqlCode);
    }

    public Boolean isParametersEmpty() {
        return this.isParametersNull() || this.parameters.isEmpty();
    }

    public Boolean isParametersNull() {
        return Objects.isNull(this.parameters);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
