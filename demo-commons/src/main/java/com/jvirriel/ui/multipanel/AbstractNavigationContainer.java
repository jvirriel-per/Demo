package com.jvirriel.ui.multipanel;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;

/**
 * Container que representa el contentArea del multipanel.
 */
public class AbstractNavigationContainer extends CssLayout {
    private CssLayout contentArea;
    private CssLayout menuArea;

    public AbstractNavigationContainer() {
        super.addStyleName("row-flex");

        buildContentArea();
    }

    private void buildContentArea() {
        menuArea = new CssLayout();
        menuArea.setPrimaryStyleName("valo-menu");

        contentArea = new CssLayout();

        this.addComponents(menuArea, contentArea);
    }

    protected void addMenu(Component menu) {
        menu.addStyleName("valo-menu-part");
        menuArea.addComponent(menu);
    }

    protected ComponentContainer getContentArea() {
        return contentArea;
    }

    public void toggleMenu() {
        menuArea.setVisible(!menuArea.isVisible());
        if (menuArea.getStyleName().contains("valo-menu-visible"))
            menuArea.removeStyleName("valo-menu-visible");
        else
            menuArea.addStyleName("valo-menu-visible");
    }

}