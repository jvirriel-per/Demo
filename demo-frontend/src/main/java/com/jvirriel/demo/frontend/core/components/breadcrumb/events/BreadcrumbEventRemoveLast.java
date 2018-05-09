package com.jvirriel.demo.frontend.core.components.breadcrumb.events;


import static com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbAction.REMOVE_LAST;

/**
 * BreadcrumbEventReplaceLast:
 */
public class BreadcrumbEventRemoveLast extends AbstractBreadcrumbEvent {
    public BreadcrumbEventRemoveLast() {
        super(REMOVE_LAST);
    }
}
