package com.jvirriel.database.xml.dataset;

import com.jvirriel.database.xml.catalogue.Attribute;
import com.jvirriel.database.xml.definition.SqlXmlDefinition;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.*;
import static java.util.stream.Collectors.toList;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlRootElement(name = DATA_SET_DEFINITION)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {CODE, NAME, ATTRIBUTES, SQL_DEFINITION, REPOSITORY_CODE})
public class
DataSetXmlDefinition {
    @XmlAttribute(name = CODE)
    private String code;

    @XmlAttribute(name = NAME)
    private String name;

    @XmlAttribute(name = FORMAT)
    private String format;

    @XmlElementWrapper(name = ATTRIBUTES)
    @XmlElement(name = ATTRIBUTE)
    private List<Attribute> attributes;

    @XmlElement(name = SQL_DEFINITION)
    private SqlXmlDefinition sqlXmlDefinition;

    @XmlElement(name = REPOSITORY_CODE)
    private String repositoryCode;

    public DataSetXmlDefinition() {
        this.attributes = new ArrayList<>();
    }

    public DataSetXmlDefinition(String code, String name, List<Attribute> attributes, SqlXmlDefinition sqlXmlDefinition,
                                String repositoryCode) {
        this.code = code;
        this.name = name;
        this.attributes = attributes;
        this.sqlXmlDefinition = sqlXmlDefinition;
        this.repositoryCode = repositoryCode;
    }
    
    public DataSetXmlDefinition(DataSetXmlDefinition dataSetXmlDefinition) {
        this.code = dataSetXmlDefinition. code;
        this.name = dataSetXmlDefinition. name;
        this.attributes = dataSetXmlDefinition. attributes;
        this.sqlXmlDefinition = dataSetXmlDefinition.sqlXmlDefinition;
        this.repositoryCode = dataSetXmlDefinition.repositoryCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataSetXmlDefinition withCode(String code) {
        this.code = code;

        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataSetXmlDefinition withName(String name) {
        this.name = name;

        return this;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public DataSetXmlDefinition withFormat(String format) {
        this.format = format;

        return this;
    }

    public String getAttribute(String name) {
        Predicate<Attribute> predicate = elem -> elem.getName().equals(name);

        return this.attributes
                .stream()
                .anyMatch(predicate) ?
                this.attributes
                        .stream()
                        .filter(predicate)
                        .collect(toList())
                        .get(0)
                        .getValue() : "";
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Map<String, String> getAttributesAsMap() {
        Map<String, String> result = new HashMap<>();

        for(Attribute attribute:this.attributes) {
            result.put(attribute.getName(), attribute.getValue());
        }

        return result;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public DataSetXmlDefinition withAttribute(Attribute attribute) {
        this.attributes.add(attribute);

        return this;
    }

    public DataSetXmlDefinition withAttributes(List<Attribute> attributes) {
        this.attributes = attributes;

        return this;
    }

    public SqlXmlDefinition getSqlXmlDefinition() {
        return sqlXmlDefinition;
    }

    public void setSqlXmlDefinition(SqlXmlDefinition sqlXmlDefinition) {
        this.sqlXmlDefinition = sqlXmlDefinition;
    }

    public DataSetXmlDefinition witSqlDefinition(SqlXmlDefinition sqlXmlDefinition) {
        this.sqlXmlDefinition = sqlXmlDefinition;

        return this;
    }

    public String getRepositoryCode() {
        return repositoryCode;
    }

    public void setRepositoryCode(String repositoryCode) {
        this.repositoryCode = repositoryCode;
    }

    public DataSetXmlDefinition withRepositoryCode(String repositoryCode) {
        this.repositoryCode = repositoryCode;

        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
