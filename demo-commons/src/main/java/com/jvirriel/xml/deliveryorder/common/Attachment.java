package com.jvirriel.xml.deliveryorder.common;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderAttachmentConstants.*;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * Pojo para Attachment
 */
@XmlRootElement(name = ATTACHMENT)
@XmlAccessorType(value = FIELD)
public class Attachment {

    @XmlElementWrapper(name = FILES)
    @XmlElement(name = FILE)
    private List<File> files = new ArrayList<>();

    public Attachment() {
    }

    public Attachment(Attachment attachment) {
        files = new ArrayList<>();
        attachment.files.forEach(file -> files.add(new File(file)));
    }

    public Attachment(List<File> files) {
        this.files = files;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}