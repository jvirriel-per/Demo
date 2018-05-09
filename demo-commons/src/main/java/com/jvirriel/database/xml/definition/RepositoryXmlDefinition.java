package com.jvirriel.database.xml.definition;

import com.jvirriel.database.xml.catalogue.Attribute;
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

@XmlRootElement(name = REPOSITORY_DEFINITION)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {URL, CONNECTION})
public class RepositoryXmlDefinition {
    @XmlElement(name = URL)
    private UrlXmlDefinition url;

    @XmlElementWrapper(name = CONNECTION)
    @XmlElement(name = ATTRIBUTE)
    private List<Attribute> connection;

    public RepositoryXmlDefinition() {
        this.url = new UrlXmlDefinition();
        this.connection = new ArrayList<>();
    }

    public RepositoryXmlDefinition(UrlXmlDefinition url, List<Attribute> connection) {
        this.url = url;
        this.connection = connection;
    }

    public RepositoryXmlDefinition(RepositoryXmlDefinition repositoryXmlDefinition) {
        this.url = repositoryXmlDefinition.url;
        this.connection = repositoryXmlDefinition.connection;
    }

    public UrlXmlDefinition getUrl() {
        return url;
    }

    public void setUrl(UrlXmlDefinition url) {
        this.url = url;
    }

    public RepositoryXmlDefinition withUrl(UrlXmlDefinition url) {
        this.url = url;

        return this;
    }

    public List<Attribute> getConnection() {
        return connection;
    }

    public void setConnection(List<Attribute> connection) {
        this.connection = connection;
    }

    public RepositoryXmlDefinition withConnection(List<Attribute> connection) {
        this.connection = connection;

        return this;
    }

    public RepositoryXmlDefinition withConnectionAttribute(Attribute attribute) {
        this.connection.add(attribute);

        return this;
    }

    public Map<String, String> getConnectionAsMap() {
        Map<String, String> result = new HashMap<>();

        for (Attribute attribute : connection) {
            result.put(attribute.getName(), attribute.getValue());
        }

        return result;
    }

    public String getConnectionAttribute(String name) {
        Predicate<Attribute> predicate = elem -> elem.getName().equals(name);

        return this.connection
                .stream()
                .anyMatch(predicate) ?
                this.connection
                        .stream()
                        .filter(predicate)
                        .collect(toList())
                        .get(0)
                        .getValue() : "";

    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
