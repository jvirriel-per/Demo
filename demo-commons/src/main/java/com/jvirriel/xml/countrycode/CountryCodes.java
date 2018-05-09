package com.jvirriel.xml.countrycode;

import com.jvirriel.xmlengine.XmlEngine;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.jvirriel.ui.constants.GeneralConstants.VERSION;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@XmlRootElement(name = "countryCodes")
@XmlAccessorType(value = FIELD)
public class CountryCodes {

    @XmlAttribute(name = VERSION)
    private String version;

    @XmlElement(name = "countryCode")
    private String countryCode;

    @XmlElement(name = "acronym")
    private String acronym;

    public CountryCodes() {

    }

    public CountryCodes(CountryCodes countryCodes) {
        this.version = countryCodes.version;
        this.countryCode = countryCodes.countryCode;
        this.acronym = countryCodes.acronym;
    }

    public CountryCodes(String version, String countryCode, String acronym) {
        this.version = version;
        this.countryCode = countryCode;
        this.acronym = acronym;
    }

    public static CountryCodes fromXML(String xml) {
        CountryCodes result = null;

        if(isNotEmpty(xml) && isNotBlank(xml)) {
            result = XmlEngine.<CountryCodes>convertXmlToObject(xml, CountryCodes.class);
        }

        return result;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}