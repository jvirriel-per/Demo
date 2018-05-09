package com.jvirriel.demo.frontend.core.components.breadcrumb.events;

import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbAction;
import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbException;
import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbItem;

/**
 * BreadcrumbEventAdd:
 * Evento para notificar la adicion de un nuevo item al breadcrumb.
 */
public class BreadcrumbEventAdd extends AbstractBreadcrumbEvent {
    protected BreadcrumbItem item;

    public BreadcrumbEventAdd(BreadcrumbItem item) {
        super(BreadcrumbAction.ADD_ITEM);

        if (item == null)
            throw new BreadcrumbException("No item is defined");

        this.item = item;
    }

    public BreadcrumbEventAdd(Object items) {
        super(BreadcrumbAction.ADD_ITEM);

        if (items == null)
            throw new BreadcrumbException("No item is defined");

        item.setJson((String) items);
    }


    public BreadcrumbItem getItem() {
        return item;
    }

    public BreadcrumbEventAdd setItem(BreadcrumbItem item) {
        this.item = item;
        return this;
    }

}
