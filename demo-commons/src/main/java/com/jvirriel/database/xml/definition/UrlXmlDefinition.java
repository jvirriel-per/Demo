package com.jvirriel.database.xml.definition;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.*;
import static java.lang.String.format;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@XmlRootElement(name = URL)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {HEADER, HOST, INSTANCE, PORT, DATABASE_NAME})
public class UrlXmlDefinition {
    @XmlElement(name = HEADER)
    private String header;

    @XmlElement(name = HOST)
    private String host;

    @XmlElement(name = INSTANCE)
    private String instance;

    @XmlElement(name = PORT)
    private String port;

    @XmlElement(name = DATABASE_NAME)
    private String databaseName;

    public UrlXmlDefinition() {
    }

    public UrlXmlDefinition(String header, String host, String instance, String port, String databaseName) {
        this.header = header;
        this.host = host;
        this.instance = instance;
        this.port = port;
        this.databaseName = databaseName;
    }

    public UrlXmlDefinition(UrlXmlDefinition urlXmlDefinition) {
        this.header = urlXmlDefinition.header;
        this.host = urlXmlDefinition.host;
        this.instance = urlXmlDefinition.instance;
        this.port = urlXmlDefinition.port;
        this.databaseName = urlXmlDefinition.databaseName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public UrlXmlDefinition withHeader(String header) {
        this.header = header;

        return this;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public UrlXmlDefinition withHost(String host) {
        this.host = host;

        return this;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public UrlXmlDefinition withInstance(String instance) {
        this.instance = instance;

        return this;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public UrlXmlDefinition withPort(String port) {
        this.port = port;

        return this;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public UrlXmlDefinition withDatabaseName(String dataBaseName) {
        this.databaseName = dataBaseName;

        return this;
    }

    public Map<String, String> asMap() {
        Map<String, String> result = new HashMap<>();

        result.put("header", this.header);
        result.put("host", this.host);
        result.put("instance", this.instance);
        result.put("port", this.port);
        result.put("databaseName", this.databaseName);

        return result;
    }

    public String asString() {
        return format("%s//%s%s:%s;databaseName=%s",
                this.header,
                this.host,
                isNotEmpty(this.instance) ? "\\".concat(this.instance) : "",
                this.port,
                this.databaseName);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
