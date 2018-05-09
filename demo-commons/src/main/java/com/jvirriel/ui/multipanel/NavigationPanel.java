package com.jvirriel.ui.multipanel;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Base para construir un container de tipo multipanel.
 */
public class NavigationPanel extends CssLayout {

    protected Navigator navigator;
    protected LinkedHashMap<String, String> menuItems;
    protected VaadinIcons[] menuItemIcons;
    private AbstractNavigationContainer root;
    private CssLayout menu;
    private CssLayout menuItemsLayout;

    protected NavigationPanel() {
        this.setHeight("100%");

        this.menu = new CssLayout();
        this.menuItems = new LinkedHashMap<>();
        this.menuItemsLayout = new CssLayout();

        this.root = new AbstractNavigationContainer();
        this.root.addMenu(buildMenu());

        buildNavigator();

        this.addComponent(root);
    }

    private CssLayout buildMenu() {
        setMenuItems();

        menuItemsLayout.setPrimaryStyleName("valo-menuitems");
        menu.addComponent(menuItemsLayout);

        int count = 0;
        setMenuItemIcons();

        for (final Map.Entry<String, String> item : menuItems.entrySet()) {
            final Button b = new Button(item.getValue(), (Button.ClickListener) event -> navigator.navigateTo(item.getKey()));
            b.setPrimaryStyleName("valo-menu-item");
            b.setIcon(menuItemIcons[count]);
            menuItemsLayout.addComponent(b);
            count++;
        }

        return menu;
    }

    private void buildNavigator() {
        navigator = new Navigator(UI.getCurrent(), root.getContentArea());

        setViews();

        navigator.addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(final ViewChangeEvent event) {
                return true;
            }

            @Override
            public void afterViewChange(final ViewChangeEvent event) {
                for (Component aMenuItemsLayout1 : menuItemsLayout) {
                    aMenuItemsLayout1.removeStyleName("selected");
                }
                for (final Map.Entry<String, String> item : menuItems.entrySet()) {
                    if (event.getViewName().equals(item.getKey())) {
                        for (Component aMenuItemsLayout : menuItemsLayout) {
                            final Component c;
                            c = aMenuItemsLayout;
                            if (c.getCaption() != null && c.getCaption().startsWith(item.getValue())) {
                                c.addStyleName("selected");
                                break;
                            }
                        }
                        break;
                    }
                }
                menu.removeStyleName("valo-menu-visible");
            }
        });
    }

    protected void hideMenu() {
        root.setVisible(false);
    }

    protected void removeNavigation() {
        removeComponent(root);
    }

    protected void setViews() {
    }

    protected void setMenuItemIcons() {
    }

    protected void setMenuItems() {
    }
}