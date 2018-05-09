package com.jvirriel.demo.frontend.components.custom.criteriabuilder;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.v7.data.util.ContainerHierarchicalWrapper;

import java.util.Collection;
import java.util.ResourceBundle;

public class CriteriaBuilderWindow extends Window {
    protected CriteriaBuilder criteriaBuilder;
    protected Button applyButton;
    protected Button cancelButton;
    private CriteriaBuilderWindowListener applyEvent;
    private CriteriaBuilderWindowListener cancelEvent;
    private AbstractLayout layout;

    public CriteriaBuilderWindow(Collection<CriteriaField> criteriaFields) {
        this(criteriaFields, null);
    }

    public CriteriaBuilderWindow(Collection<CriteriaField> criteriaFields, ContainerHierarchicalWrapper itemContainerWrapper) {
        this.layout = new VerticalLayout();
        this.criteriaBuilder = new CriteriaBuilder(criteriaFields, itemContainerWrapper);
        ResourceBundle bundle = this.criteriaBuilder.getBundle();
        this.applyButton = new Button(bundle.getString("apply"));
        this.applyButton.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        this.applyButton.setIcon(FontAwesome.FILTER);
        this.applyButton.setCaption("Aplicar");
        this.criteriaBuilder.getButtonLayout().addComponent(this.applyButton);
        this.applyButton.addClickListener((ClickListener) event -> {
            if(CriteriaBuilderWindow.this.criteriaBuilder.validate()) {
                if(CriteriaBuilderWindow.this.applyEvent != null) {
                    CriteriaBuilderWindow.this.applyEvent.execute();
                }

                CriteriaBuilderWindow.this.close();
            }
        });
        this.cancelButton = new Button(bundle.getString("cancel"));
        this.cancelButton.setCaption("Cancelar");
        this.cancelButton.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        this.cancelButton.setIcon(FontAwesome.REMOVE);
        this.criteriaBuilder.getButtonLayout().addComponent(this.cancelButton);
        this.cancelButton.addClickListener((ClickListener) event -> {
            if(CriteriaBuilderWindow.this.cancelEvent != null) {
                CriteriaBuilderWindow.this.cancelEvent.execute();
            }

            CriteriaBuilderWindow.this.close();
        });
        this.layout.addComponent(this.criteriaBuilder);
        this.setContent(this.layout);
        this.center();
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return this.criteriaBuilder;
    }

    public Button getApplyButton() {
        return this.applyButton;
    }

    public Button getCancelButton() {
        return this.cancelButton;
    }

    public CriteriaBuilderWindowListener getApplyEvent() {
        return this.applyEvent;
    }

    public void setApplyEvent(CriteriaBuilderWindowListener applyEvent) {
        this.applyEvent = applyEvent;
    }

    public CriteriaBuilderWindowListener getCancelEvent() {
        return this.cancelEvent;
    }

    public void setCancelEvent(CriteriaBuilderWindowListener cancelEvent) {
        this.cancelEvent = cancelEvent;
    }
}