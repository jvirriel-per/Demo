package com.jvirriel.demo.frontend.core.components.breadcrumb.events;

import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbAction;
import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbException;
import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbItem;

import java.util.List;

/**
 * BreadcrumbEventUpdatedItemList:
 * Evento para notificar la actualización de la lista de items.
 */
public class BreadcrumbEventUpdatedItemsList extends AbstractBreadcrumbEvent {
    protected List<BreadcrumbItem> itemList;

    public BreadcrumbEventUpdatedItemsList(List<BreadcrumbItem> itemList) {
        super(BreadcrumbAction.UPDATE);

        if (itemList == null)
            throw new BreadcrumbException("No itemList is defined");

        this.itemList = itemList;
    }

    public List<BreadcrumbItem> getItemList() {
        return itemList;
    }

    public BreadcrumbEventUpdatedItemsList setItemList(List<BreadcrumbItem> itemList) {
        this.itemList = itemList;
        return this;
    }

}
