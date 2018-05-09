package com.jvirriel.xml.deliveryorder.common;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderXmlConstants.BODY;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderXmlConstants.MESSAGE;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderXmlConstants.SUBJECT;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * Pojo para Message
 */
@Component
@XmlRootElement(name = MESSAGE)
@XmlAccessorType(value = FIELD)
public class Message {
    @XmlElement(name = SUBJECT)
    private String subject;

    @XmlElement(name = BODY)
    private MessageBody body;

    public Message() {
    }

    public Message(Message message) {
        this.subject = message.subject;
        this.body = new MessageBody(message.body);
    }

    public Message(String subject, MessageBody body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MessageBody getBody() {
        return body;
    }

    public void setBody(MessageBody body) {
        this.body = body;
    }
}