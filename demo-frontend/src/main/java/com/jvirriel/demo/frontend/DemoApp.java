package com.jvirriel.demo.frontend;

import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbItem;
import com.jvirriel.demo.frontend.core.components.breadcrumb.events.BreadcrumbEventAdd;
import com.jvirriel.demo.frontend.core.views.containers.VoidView;
import com.jvirriel.demo.frontend.core.views.main.MainUI;
import com.jvirriel.demo.frontend.core.views.navigator.events.NavigatorEventAdd;
import com.jvirriel.demo.frontend.entitystatus.views.EntityStatusContainerUI;
import com.jvirriel.demo.frontend.entitytype.constants.EntityTypeGeneralConstants;
import com.jvirriel.demo.frontend.entitytype.views.EntityTypeContainerUI;
import com.jvirriel.exception.ViewErrorHandler;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import static com.jvirriel.constants.GeneralConstants.EMPTY_STRING;
import static com.jvirriel.demo.frontend.entitystatus.constants.EntityStatusGeneralConstants.ENTITY_STATUS;
import static com.jvirriel.ui.constants.GeneralConstants.THEME;

@Theme(THEME)
@Title("Demo FE")
public class DemoApp extends MainUI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoApp.class)
    public static class Servlet extends VaadinServlet {
        @Override
        protected void servletInitialized() throws ServletException {
            super.servletInitialized();
        }
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        super.init(vaadinRequest);
        UI.getCurrent().setErrorHandler(new ViewErrorHandler());
    }

    /**
     * Permite agregar los containers (módulos) que tendrá el aplicativo.
     */
    @Override
    protected void setViews() {
        super.setViews();
        bus.post(new NavigatorEventAdd(EMPTY_STRING, VoidView.class));
        bus.post(new NavigatorEventAdd(ENTITY_STATUS, EntityStatusContainerUI.class));
        bus.post(new NavigatorEventAdd(EntityTypeGeneralConstants.ENTITY_TYPE, EntityTypeContainerUI.class));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        super.enter(viewChangeEvent);
        bus.post(new BreadcrumbEventAdd(new BreadcrumbItem(this.appName, EMPTY_STRING)));
    }
}