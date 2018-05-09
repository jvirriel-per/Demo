package com.jvirriel.demo.frontend.components.custom.verticaltabsheet;

import com.vaadin.server.Resource;

/**
 * Bean para manejar las opciones del menú lateral que contedrá el MultiPanel.
 */
public class Option {

    private Class clazz;
    private String className;
    private Resource icon;

    public Option() {
    }

    public Option(Class clazz, String stringClassName, Resource icon) {
        this.clazz = clazz;
        this.className = stringClassName;
        this.icon = icon;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Resource getIcon() {
        return icon;
    }

    public void setIcon(Resource icon) {
        this.icon = icon;
    }
}