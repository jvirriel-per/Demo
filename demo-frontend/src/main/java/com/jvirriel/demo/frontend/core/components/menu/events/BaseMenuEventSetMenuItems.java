package com.jvirriel.demo.frontend.core.components.menu.events;

import com.pt.base.core.components.menu.BaseMenuItem;

import java.util.List;

/**
 * BaseMenuEventSetMenuItems:
 * <p>
 * Creado por bpena el 28/04/2017.
 */
public class BaseMenuEventSetMenuItems {
    List<BaseMenuItem> itemList;

    public BaseMenuEventSetMenuItems(List<BaseMenuItem> itemList) {
        this.itemList = itemList;
    }

    public List<BaseMenuItem> getItemList() {
        return itemList;
    }

    public BaseMenuEventSetMenuItems setItemList(List<BaseMenuItem> itemList) {
        this.itemList = itemList;
        return this;
    }
}
