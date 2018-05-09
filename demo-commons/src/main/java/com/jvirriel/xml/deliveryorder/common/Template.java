package com.jvirriel.xml.deliveryorder.common;


import com.jvirriel.database.xml.catalogue.Parameter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.PARAMETER;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderTemplateConstants.CODE;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderTemplateConstants.TEMPLATE;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderTemplateConstants.TEMPLATE_TYPE;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderXmlConstants.VERSION;
import static com.jvirriel.database.xml.constant.XmlTagNameConstants.PARAMETERS;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * Pojo para Template
 */
@XmlRootElement(name = TEMPLATE)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {"templateType", VERSION, "id", PARAMETERS, "code"})
public class Template {

    @XmlAttribute(name = TEMPLATE_TYPE)
    private String templateType;

    @XmlAttribute(name = VERSION)
    private String version;

    @XmlAttribute(name = "id")
    private Long id;

    @XmlElementWrapper(name = PARAMETERS)
    @XmlElement(name = PARAMETER)
    private List<Parameter> parameters;

    @XmlElement(name = CODE)
    private String code;

    public Template() {
        this.parameters = new ArrayList<>();
    }

    public Template(String templateType, String version, List<Parameter> parameters, String code) {
        this.templateType = templateType;
        this.version = version;
        this.parameters = parameters;
        this.code = code;
    }

    public Template(Template template) {
        this.templateType = template.templateType;
        this.version = template.version;
        parameters = new ArrayList<>();
        template.parameters.forEach(parameter -> parameters.add(new Parameter(parameter)));
        this.code = template.code;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParameterType(String name) {
        Parameter result = getParameterByName(name);

        return nonNull(result) ? result.getType() : "";
    }

    public String getParameterValue(String name) {
        Parameter result = getParameterByName(name);

        return nonNull(result) ? result.getValue() : "";
    }

    public Template withParameter(Parameter parameter) {
        this.parameters.add(parameter);

        return this;
    }

    public Template withParameters(List<Parameter> parameters) {
        this.parameters = parameters;

        return this;
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
}