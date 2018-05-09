package com.jvirriel.ui.audithistorypanel;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Panel para mostrar información asociada a los campos de auditoría.
 */
public class AuditHistoryPanel extends CssLayout {
    private Panel panelInformation;
    private Label title;

    private Label userCreation;
    private Label userCreationTitle;
    private Label dateCreation;
    private Label userUpdate;
    private Label dateUpdate;

    public AuditHistoryPanel() {
        super.setSizeFull();

        buildTitle();
        buildContent();
    }

    /**
     * Construye el titulo del componente
     */
    private void buildTitle() {
        title = new Label("Historial");
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_BOLD);

        super.addComponent(title);
    }

    /**
     * Construye y organiza el contenido del panel.
     */
    private void buildContent() {
        panelInformation = new Panel();

        VerticalLayout rootContainerContent = new VerticalLayout();
        rootContainerContent.setMargin(false);
        rootContainerContent.setSpacing(false);
        rootContainerContent.addComponent(new Label());

        userCreationTitle = new Label("Usuario de creación: ");
        userCreation = new Label();

        HorizontalLayout userCreationHorizontal = new HorizontalLayout();
        userCreationHorizontal.setMargin(new MarginInfo(false, true, false, false));
        userCreationHorizontal.addComponents(userCreationTitle,userCreation);

        Label dateCreationTitle = new Label("Fecha de creación: ");
        dateCreation = new Label();

        HorizontalLayout dateCreationHorizontal = new HorizontalLayout();
        dateCreationHorizontal.setMargin(new MarginInfo(false, true, false, false));
        dateCreationHorizontal.addComponents(dateCreationTitle, dateCreation);

        Label userUpdateTitle = new Label("Usuario de actualización: ");
        userUpdate = new Label();

        HorizontalLayout userUpdateHorizontal = new HorizontalLayout();
        userUpdateHorizontal.setMargin(new MarginInfo(false, true, false, false));
        userUpdateHorizontal.addComponents(userUpdateTitle, userUpdate);

        Label dateUpdateTitle = new Label("Fecha de actualización: ");
        dateUpdate = new Label();

        HorizontalLayout dateUpdateHorizontal = new HorizontalLayout();
        dateUpdateHorizontal.setMargin(new MarginInfo(false, true, false, false));
        dateUpdateHorizontal.addComponents(dateUpdateTitle, dateUpdate);

        HorizontalLayout firstRowLayout = new HorizontalLayout();
        firstRowLayout.setMargin(new MarginInfo(true, false, false, false));
        firstRowLayout.addComponents(userCreationHorizontal, dateCreationHorizontal);

        HorizontalLayout secondRowLayout = new HorizontalLayout();
        secondRowLayout.setMargin(new MarginInfo(true, false, false, false));
        secondRowLayout.addComponents(userUpdateHorizontal, dateUpdateHorizontal);

        rootContainerContent.addComponents(firstRowLayout,secondRowLayout);

        panelInformation.setContent(rootContainerContent);

        super.addComponent(panelInformation);
    }

    /**
     * Asocia un caption al userCreation
     *
     * @param value, valor a mostrar
     */
    public void setUserCreationValue(String value) {
        this.userCreation.setCaption(value);
    }

    /**
     * Asocia un caption al dateCreation
     *
     * @param value, valor a mostrar
     */
    public void setDateCreationValue(String value) {
        this.dateCreation.setCaption(value);
    }

    /**
     * Asocia un caption al userUpdate
     *
     * @param value, valor a mostrar
     */
    public void setUserUpdateValue(String value) {
        this.userUpdate.setCaption(value);
    }

    /**
     * Asocia un caption al dateUpdate
     *
     * @param value, valor a mostrar
     */
    public void setDateUpdateValue(String value) {
        this.dateUpdate.setCaption(value);
    }

}