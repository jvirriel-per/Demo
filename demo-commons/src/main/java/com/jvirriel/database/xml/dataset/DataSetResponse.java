package com.jvirriel.database.xml.dataset;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jvirriel.database.xml.catalogue.Attribute;
import com.jvirriel.database.xml.catalogue.ColumnMetaData;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.*;

@XmlRootElement(name = DATA_SET_RESPONSE)
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(propOrder = {CODE, FORMAT, HTTP_STATUS, META_DATA, PARAMETERS, VARIABLES, RESULT})
public class DataSetResponse {
    @XmlAttribute(name = CODE)
    private String code;

    @XmlAttribute(name = FORMAT)
    private String format;

    @XmlElement(name = HTTP_STATUS)
    private String httpStatus;

    @XmlElement(name = RESULT)
    private String result;

    @XmlElementWrapper(name = META_DATA)
    @XmlElement(name = COLUMN)
    private List<ColumnMetaData> metaData;

    @XmlElementWrapper(name = PARAMETERS)
    @XmlElement(name = PARAMETER)
    private List<DataSetParameter> parameters;

    @XmlElementWrapper(name = VARIABLES)
    @XmlElement(name = VARIABLE)
    private List<Attribute> variables;

    public DataSetResponse() {
        this.metaData = new ArrayList<>();
        this.parameters = new ArrayList<>();
        this.variables = new ArrayList<>();
    }

    public DataSetResponse(String code, String format, String httpStatus, String result, List<ColumnMetaData>
            metaData, List<DataSetParameter> parameters, List<Attribute> variables) {
        this.code = code;
        this.format = format;
        this.httpStatus = httpStatus;
        this.result = result;
        this.metaData = metaData;
        this.parameters = parameters;
        this.variables = variables;
    }

    public DataSetResponse(DataSetResponse dataSetResponse) {
        this.code = dataSetResponse.code;
        this.format = dataSetResponse.format;
        this.httpStatus = dataSetResponse.httpStatus;
        this.result = dataSetResponse.result;
        this.metaData = dataSetResponse.metaData;
        this.parameters = dataSetResponse.parameters;
        this.variables = dataSetResponse.variables;
    }

    public static List<Map<String, String>> fromJson(String json) {
        Type type = new TypeToken<List<Map<String, String>>>() {

        }.getType();

        return new GsonBuilder()
                .serializeNulls()
                .create()
                .fromJson(json, type);
    }

    public static String toJson(List<Map<String, String>> rows) {
        return new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create()
                .toJson(rows);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataSetResponse withCode(String code) {
        this.code = code;

        return this;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public DataSetResponse withFormat(String format) {
        this.format = format;

        return this;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpStatusValue() {
        return Integer.valueOf(this.httpStatus);
    }

    public void setHttpStatusValue(int value) {
        this.httpStatus = Integer.toString(value);
    }

    public DataSetResponse withHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;

        return this;
    }

    public DataSetResponse withHttpStatusValue(int value) {
        this.httpStatus = Integer.toString(value);

        return this;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataSetResponse withResult(String result) {
        this.result = result;

        return this;
    }

    public List<ColumnMetaData> getMetaData() {
        return metaData;
    }

    public void setMetaData(List<ColumnMetaData> metaData) {
        this.metaData = metaData;
    }

    public DataSetResponse withColumn(ColumnMetaData column) {
        this.metaData.add(column);

        return this;
    }

    public DataSetResponse withMetaData(List<ColumnMetaData> metaData) {
        this.metaData = metaData;

        return this;
    }

    public List<DataSetParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<DataSetParameter> parameters) {
        this.parameters = parameters;
    }

    public DataSetResponse withParameter(DataSetParameter parameter) {
        this.parameters.add(parameter);

        return this;
    }

    public DataSetResponse withParameters(List<DataSetParameter> parameters) {
        this.parameters = parameters;

        return this;
    }

    public List<Attribute> getVariables() {
        return variables;
    }

    public void setVariables(List<Attribute> variables) {
        this.variables = variables;
    }

    public DataSetResponse withVariable(Attribute variable) {
        this.variables.add(variable);

        return this;
    }

    public DataSetResponse withVariables(List<Attribute> variables) {
        this.variables = variables;

        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
