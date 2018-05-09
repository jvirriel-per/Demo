package com.jvirriel.demo.frontend.core.components.breadcrumb.events;

import static com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbAction.GO_BACK;

/**
 * BreadcrumbEventReplaceLast:
 */
public class BreadcrumbEventGoBack extends AbstractBreadcrumbEvent {
    public BreadcrumbEventGoBack() {
        super(GO_BACK);
    }
}
