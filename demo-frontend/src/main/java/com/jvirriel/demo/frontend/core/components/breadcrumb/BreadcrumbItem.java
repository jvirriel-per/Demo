package com.jvirriel.demo.frontend.core.components.breadcrumb;


public class BreadcrumbItem {
    private String label;
    private String action;
    private String json;

    private int pos;

    public BreadcrumbItem(String label) {
        this.label = label;
    }

    public BreadcrumbItem(String label, String action) {
        this(label);
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public BreadcrumbItem setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getAction() {
        return action;
    }

    public BreadcrumbItem setAction(String action) {
        this.action = action;
        return this;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getJson() {
        return json;
    }

    public BreadcrumbItem setJson(String json) {
        this.json = json;
        return this;
    }
}
