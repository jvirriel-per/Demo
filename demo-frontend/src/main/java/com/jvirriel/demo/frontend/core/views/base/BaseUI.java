package com.jvirriel.demo.frontend.core.views.base;

import com.jvirriel.demo.frontend.core.annotations.Function;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.VerticalLayout;

import static com.jvirriel.constants.GeneralConstants.ACCEPT_ID;
import static com.jvirriel.constants.GeneralConstants.CANCEL_ID;
import static com.jvirriel.constants.GeneralConstants.DELETE_ID;


public abstract class BaseUI extends CssLayout {
    protected  boolean preNew() {
        return true;
    }

    protected void onNew() {
        if (this.preNew()) {
            this.actionNew();
            this.postNew();
        }

    }

    protected boolean actionNew() {
        return true;
    }

    protected boolean postNew() {
        return true;
    }

    protected boolean preEdit() {
        return true;
    }

    protected void onEdit() {
        if (this.preEdit()) {
            this.actionEdit();
            this.postEdit();
        }
    }

    protected boolean actionEdit() {
        return true;
    }

    protected boolean postEdit() {
        return true;
    }

    protected boolean preDelete() {
        return true;
    }

    @Function(action = DELETE_ID)
    public void onDelete() {
        if (this.preDelete()) {
            this.deleteAction();
            this.postDelete();
        }
    }

    protected boolean deleteAction() {
        return true;
    }

    protected boolean postDelete() {
        return true;
    }

    protected boolean preCancel() {
        return true;
    }

    @Function(action = CANCEL_ID)
    public void onCancel() {
        if (this.preCancel()) {
            this.actionCancel();
            this.postCancel();
        }
    }

    protected boolean actionCancel() {
        return true;
    }

    protected boolean postCancel() {
        return true;
    }

    protected boolean preSave() {
        return true;
    }

    @Function(action = ACCEPT_ID)
    public void onSave() {
        if (this.preSave() && this.validate()) {
            this.actionSave();
            this.postSave();
        }
    }

    protected boolean actionSave() {
        return true;
    }

    protected boolean postSave() {
        return true;
    }

    protected boolean validate() {
        return true;
    }
}