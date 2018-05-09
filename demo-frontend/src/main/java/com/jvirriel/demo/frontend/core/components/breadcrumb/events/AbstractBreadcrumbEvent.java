package com.jvirriel.demo.frontend.core.components.breadcrumb.events;

import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbAction;

/**
 * AbstractBreadcrumbEvent:
 * Evento base para la generacion de eventos del breadcrumb.
 */
public abstract class AbstractBreadcrumbEvent {
    protected BreadcrumbAction action;

    public AbstractBreadcrumbEvent(BreadcrumbAction action) {
        this.action = action;
    }

    public BreadcrumbAction getAction() {
        return action;
    }

    public void setAction(BreadcrumbAction action) {
        this.action = action;
    }
}
