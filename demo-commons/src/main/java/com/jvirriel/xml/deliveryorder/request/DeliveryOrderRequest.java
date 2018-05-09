package com.jvirriel.xml.deliveryorder.request;


import com.jvirriel.database.xml.catalogue.Parameter;
import com.jvirriel.xml.deliveryorder.common.Message;
import com.jvirriel.xml.deliveryorder.common.Receiver;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.jvirriel.database.xml.constant.XmlTagNameConstants.PARAMETER;
import static com.jvirriel.database.xml.constant.XmlTagNameConstants.PARAMETERS;
import static com.jvirriel.xml.deliveryorder.constants.DeliveryOrderXmlConstants.*;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * Pojo para DeliveryOrderRequest
 */
@Component
@XmlRootElement(name = DELIVERY_ORDER_REQUEST)
@XmlAccessorType(value = FIELD)
@XmlType(propOrder = {PARAMETERS, SENDER, RECEIVERS, MESSAGE})
public class DeliveryOrderRequest {

    @XmlAttribute(name = USER_ID)
    private Long userId;

    @XmlAttribute(name = REQUEST_TYPE)
    private String requestType;

    @XmlAttribute(name = DELIVERY_TYPE)
    private String deliveryType;

    @XmlAttribute(name = DELIVERY_PRIORITY)
    private String deliveryPriority;

    @XmlAttribute(name = VERSION)
    private String version;

    @XmlElementWrapper(name = PARAMETERS)
    @XmlElement(name = PARAMETER)
    private List<Parameter> parameters;

    @XmlElement(name = SENDER)
    private String sender;

    @XmlElementWrapper(name = RECEIVERS)
    @XmlElement(name = RECEIVER)
    private List<Receiver> receivers;

    @XmlElement(name = MESSAGE)
    private Message message;

    public DeliveryOrderRequest() {
        this.parameters = new ArrayList<>();
        this.receivers = new ArrayList<>();
    }

    public DeliveryOrderRequest(Long userId, String requestType, String deliveryType, String deliveryPriority, String version,
                                List<Parameter> parameters, String sender, List<Receiver> receivers, Message message) {
        this.userId = userId;
        this.requestType = requestType;
        this.deliveryType = deliveryType;
        this.deliveryPriority = deliveryPriority;
        this.version = version;
        this.parameters = parameters;
        this.sender = sender;
        this.receivers = receivers;
        this.message = message;
    }

    public DeliveryOrderRequest(DeliveryOrderRequest deliveryOrderRequest) {
        this.userId = deliveryOrderRequest.userId;
        this.requestType = deliveryOrderRequest.requestType;
        this.deliveryType = deliveryOrderRequest.deliveryType;
        this.deliveryPriority = deliveryOrderRequest.deliveryPriority;
        this.version = deliveryOrderRequest.version;
        this.parameters = deliveryOrderRequest.parameters;
        this.sender = deliveryOrderRequest.sender;
        this.receivers = deliveryOrderRequest.receivers;
        this.message = deliveryOrderRequest.message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryPriority() {
        return deliveryPriority;
    }

    public void setDeliveryPriority(String deliveryPriority) {
        this.deliveryPriority = deliveryPriority;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public String getParameterType(String name) {
        Parameter result = getParameterByName(name);

        return nonNull(result) ? result.getType() : "";
    }

    public String getParameterValue(String name) {
        Parameter result = getParameterByName(name);

        return nonNull(result) ? result.getValue() : "";
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public DeliveryOrderRequest withParameter(Parameter parameter) {
        this.parameters.add(parameter);

        return this;
    }

    public DeliveryOrderRequest withParameters(List<Parameter> parameters) {
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Receiver> receivers) {
        this.receivers = receivers;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}