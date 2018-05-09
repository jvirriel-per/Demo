package com.jvirriel.database.xml.dataset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dataSetConfig")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class DataSetConfig {
    @XmlElement(name = "subscriberKey")
    private String subscriberKey;

    @XmlElement(name = "appKey")
    private String appKey;

    @XmlElement(name = "dataToken")
    private String dataToken;

    @XmlElement(name = "format")
    private String format;

    @XmlElement(name = "mode")
    private String mode;

    @XmlElement(name = "endPoint")
    private String endPoint;

    public String getSubscriberKey() {
        return subscriberKey;
    }

    public void setSubscriberKey(String subscriberKey) {
        this.subscriberKey = subscriberKey;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getDataToken() {
        return dataToken;
    }

    public void setDataToken(String dataToken) {
        this.dataToken = dataToken;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
