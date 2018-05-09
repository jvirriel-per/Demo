package com.jvirriel.demo.frontend.components.custom.verticaltabsheet;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Resource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Componente TabSheet Vertical.
 */
public class VerticalTabSheet extends VerticalLayout implements View {
    public static final String COMPONENTS = "components";

    private HorizontalSplitPanel hsplit;
    private VerticalLayout menu;
    private Class clazz;
    private String stringClassName;
    private Resource icon;
    private Panel sideMenu;
    private String nameActive;
    private Class classActive;
    private Resource iconActive;
    private Panel contentArea;
    private Button buttonActive = null;

    class ButtonListener implements Button.ClickListener {

        private Class clazz;
        private String caption;
        private Resource icon;

        ButtonListener(Class menuClass, String caption, Resource icon) {
            this.clazz = menuClass;
            this.caption = caption;
            this.icon = icon;
        }

        @Override
        public void buttonClick(Button.ClickEvent clickEvent) {
            Panel content = (Panel) hsplit.getSecondComponent();

            try {
                if (buttonActive == null) {
                    buttonActive = clickEvent.getButton();

                    content.setContent((Component) this.clazz.newInstance());
                    nameActive = this.caption;
                    classActive = this.clazz;
                    iconActive = this.icon;
                } else {
                    if (buttonActive != clickEvent.getButton()) {
                        buttonActive.setStyleName(ValoTheme.BUTTON_QUIET);
                        buttonActive = clickEvent.getButton();

                        content.setContent((Component) this.clazz.newInstance());
                        nameActive = this.caption;
                        classActive = this.clazz;
                        iconActive = this.icon;
                    }
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public VerticalTabSheet() {
        setView();
        createMenu();
        createContentArea();
    }

    private void setView() {

        hsplit = ComponentFactory.horizontalSplitPanel()
                .setHeight(100, Unit.PERCENTAGE)
                .setWidth(100, Unit.PERCENTAGE)
                .setLocked(true)
                .setSplitPosition(75, Unit.PERCENTAGE, true)
                .get();

        super.addComponents(hsplit);
    }

    private void createMenu() {
        menu = ComponentFactory.verticalLayout()
                .get();

        addComponent(clazz, stringClassName, icon);

        sideMenu = ComponentFactory.panel()
                .setHeight("400px")
                .addStyleName(ValoTheme.PANEL_BORDERLESS)
                .get();

        sideMenu.setContent(menu);

        hsplit.setFirstComponent(sideMenu);
    }

    public void addComponent(Class clazz, String stringClassName, Resource icon) {
        menu.addComponents(createMenuItem(clazz, stringClassName, icon, false));
    }

    private Button createMenuItem(final Class clazz, final String caption, final Resource faIcon,
                                  boolean isActive) {
        if (isActive) {
            buttonActive = ComponentFactory.button(caption)
                    .addClickListener(new ButtonListener(clazz, caption, faIcon))
                    .setIcon(faIcon, "")
                    .get();
            return buttonActive;
        } else {
            return ComponentFactory.button(caption)
                    .setStyleName(ValoTheme.BUTTON_QUIET)
                    .addClickListener(new ButtonListener(clazz, caption, faIcon))
                    .setIcon(faIcon, "")
                    .get();
        }

    }

    private void createContentArea() {
        Panel contentArea = ComponentFactory.panel()
                .addStyleName(ValoTheme.PANEL_BORDERLESS)
                .setWidth((float) 140, Unit.PERCENTAGE)
                .setHeight(600, Unit.PIXELS)
                .get();

        hsplit.setSecondComponent(contentArea);
    }

    public void setContentArea(Panel contentArea) {
        this.contentArea = contentArea;
        hsplit.setSecondComponent(contentArea);
    }

    public VerticalLayout getMenu() {
        return menu;
    }

    public void setMenu(VerticalLayout newMenu) {
        menu = newMenu;
        this.sideMenu.setContent(menu);
        hsplit.setFirstComponent(this.sideMenu);
    }

    public void removeMenu() {
        menu.removeAllComponents();
    }

    public String getNameActive() {
        return nameActive;
    }

    public void setNameActive(String nameActive) {
        this.nameActive = nameActive;
    }

    public Class getClassActive() {
        return classActive;
    }

    public void setClassActive(Class classActive) {
        this.classActive = classActive;
    }

    public Resource getIconActive() {
        return iconActive;
    }

    public void setIconActive(Resource iconActive) {
        this.iconActive = iconActive;
    }

    public Panel getContentArea() {
        return contentArea;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}