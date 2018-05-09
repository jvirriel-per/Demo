package com.jvirriel.demo.backend.configuration.audit;

import java.util.Date;

public class Document {
    protected Date creationDate;
    protected Date updatedDate;
    protected String user;
    protected String status;
    protected String inputData;
    protected String outputData;
    protected String errorData;
    protected String appCode;
    protected String group;
    protected String subGroup;
    protected String type;

    /**
     * Constructor no parametrizado
     */
    public Document() {
        getLocalDateTime();
    }

    /**
     * Constructor parametrizado
     * @param user nombre de usuario ejecutor
     * @param status estatus de la solicitud, exitoso o fallido
     * @param inputData data de solicitud
     * @param outputData data de respuesta
     * @param errorData data de error
     * @param appCode codigo de aplicacion
     * @param group grupo al que pertenece
     * @param subGroup subgrupo al que pertenece
     * @param type tipo de solicitud, Ejemplo: guardar, editar, buscar...
     */
    public Document(String user, String status, String inputData, String outputData, String errorData, String appCode,
                    String group, String subGroup, String type) {
        this.user = user;
        this.status = status;
        this.inputData = inputData;
        this.outputData = outputData;
        this.errorData = errorData;
        this.appCode = appCode;
        this.group = group;
        this.subGroup = subGroup;
        this.type = type;

        getLocalDateTime();
    }

    public Document(Document document) {
        this.user = document.user;
        this.status = document.status;
        this.inputData = document.inputData;
        this.outputData = document.outputData;
        this.errorData = document.errorData;
        this.appCode = document.appCode;
        this.group = document.group;
        this.subGroup = document.subGroup;
        this.type = document.type;
        this.creationDate = document.creationDate;
        this.updatedDate = document.updatedDate;
    }

    public void updateDate() {
        this.updatedDate = new Date();
    }

    public String getErrorData() {
        return errorData;
    }

    public void setErrorData(String errorData) {
        this.errorData = errorData;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String getOutputData() {
        return outputData;
    }

    public void setOutputData(String outputData) {
        this.outputData = outputData;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private void getLocalDateTime() {
        this.creationDate = new Date();
        this.updatedDate = this.creationDate;
    }
}
