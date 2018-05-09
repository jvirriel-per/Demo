package com.jvirriel.demo.frontend.core.components.breadcrumb;


public class BreadcrumbLobbyItem {
    private String label;
    private String action;
    private int pos;

    public BreadcrumbLobbyItem(String label) {
        this.label = label;
    }

    public BreadcrumbLobbyItem(String label, String action) {
        this(label);
        this.action = action;
    }

    public String getLabel(){
        return label;
    }

    public BreadcrumbLobbyItem setLabel(String label){
        this.label = label;
        return this;
    }

    public String getAction(){
        return  action;
    }

    public BreadcrumbLobbyItem setAction(String action){
        this.action = action;
        return this;
    }

    public int getPos(){return pos;}

    public void setPos(int pos){this.pos = pos;}
}
