package com.jvirriel.demo.frontend.core.components.breadcrumb.events;

import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbException;
import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbItem;

import static com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbAction.REPLACE_LAST;

/**
 * BreadcrumbEventReplaceLast:
 */
public class BreadcrumbEventReplaceLast extends AbstractBreadcrumbEvent {
    protected BreadcrumbItem item;

    public BreadcrumbEventReplaceLast(BreadcrumbItem item) {
        super(REPLACE_LAST);

        if (item == null)
            throw new BreadcrumbException("No item is defined");

        this.item = item;
    }

    public BreadcrumbItem getItem() {
        return item;
    }

    public BreadcrumbEventReplaceLast setItem(BreadcrumbItem item) {
        this.item = item;
        return this;
    }
}
