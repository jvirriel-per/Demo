package com.jvirriel.xml.deliveryorder.common;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderXmlConstants.RECEIVERS;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * Pojo para Receiver
 */
@XmlRootElement(name = RECEIVERS)
@XmlAccessorType(value = FIELD)
public class Receiver {

    @XmlValue
    private String value;

    public Receiver() {
    }

    public Receiver(String receiver) {
        this.value = receiver;
    }

    public Receiver(Receiver receivers) {
        this.value = receivers.value;
    }

    public String getReceiver() {
        return value;
    }

    public void setReceiver(String receiver) {
        this.value = receiver;
    }
}