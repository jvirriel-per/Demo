package com.jvirriel.xml.deliveryorder.common;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderAttachmentConstants.FILE;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * Pojo para File
 */
@XmlRootElement(name = FILE)
@XmlAccessorType(value = FIELD)
public class File {

    @XmlValue
    private String path;

    public File() {
    }

    public File(File file) {
        this.path = file.path;
    }

    public File(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}