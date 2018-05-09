package com.jvirriel.demo.frontend.core.components.subheader;

import com.google.common.eventbus.EventBus;
import com.pt.base.core.components.breadcrumb.events.BreadcrumbEventGoBack;
import com.pt.base.core.components.breadcrumb.events.BreadcrumbEventRemoveLast;
import com.pt.base.core.views.main.MainUIConstants;
import com.pt.components.ComponentFactory;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Clase encargada de construir el botón de regresar en el menu de aplicativos.
 * Created by fsalazar on 07/06/2017.
 */
public class BackButton extends CssLayout {

    private Button buttonBuilder;
    private EventBus bus;


    public BackButton() {

        buildBackButton();
    }

    /**
     * Metodo encargado de la construcción del componente.
     */
    public void buildBackButton() {

        bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);

        buttonBuilder = ComponentFactory.button()
                .setIcon(VaadinIcons.ARROW_LEFT, "")
                .addStyleName(ValoTheme.BUTTON_BORDERLESS)
                .addStyleName("back-button")
                .addClickListener(this::navigateTo)
                .get();
        addComponent(buttonBuilder);
    }

    /**
     * Metodo encargado de la navergación del componente.
     */
    public void navigateTo(Button.ClickEvent event) {
        bus.post(new BreadcrumbEventGoBack());
    }
}
