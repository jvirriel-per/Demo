package com.jvirriel.xml.deliveryorder.common;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderAttachmentConstants.ATTACHMENT;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderTemplateConstants.TEMPLATE;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderXmlConstants.BODY;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderXmlConstants.TYPE;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * Pojo para MessageBody
 */
@XmlRootElement(name = BODY)
@XmlAccessorType(value = FIELD)
public class MessageBody {
    @XmlAttribute(name = TYPE)
    private String bodyType;

    @XmlElement(name = TEMPLATE)
    private Template template;

    @XmlElement(name = "content")
    private String content;

    @XmlElement(name = ATTACHMENT)
    private Attachment attachment;

    public MessageBody() {
    }

    public MessageBody(MessageBody messageBody) {
        this.bodyType = messageBody.bodyType;
        this.content = messageBody.content;
        this.template = new Template(messageBody.template);
        this.attachment = new Attachment(messageBody.attachment);
    }

    public MessageBody(String bodyType, String content, Template template, Attachment attachment) {
        this.bodyType = bodyType;
        this.content = content;
        this.template = template;
        this.attachment = attachment;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}