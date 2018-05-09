package com.jvirriel.demo.frontend.components.custom.componentaddress;

import com.jvirriel.demo.frontend.components.custom.multilevelcombobox.MultiLevelComboBox;
import com.vaadin.ui.*;

public class ComponentAddress extends VerticalLayout {
    private CssLayout componentContainer;
    private Panel panelContent;
    private Button buttonModal;
    private CssLayout components;
    private GridLayout gridLayoutModal;
    private MenuBar gridMenuBar;
    private TextArea address;
    private TextArea textAreaPrincipal;
    private MultiLevelComboBox multiLevelComboBox;

    public ComponentAddress(Component component) {
        super.setMargin(false);

        componentContainer = new CssLayout();
        componentContainer.setSizeFull();

        textAreaPrincipal = new TextArea();
        textAreaPrincipal.setWidth("350px");

        componentContainer.addComponent(textAreaPrincipal);
        components = new CssLayout();

        panelContent = new Panel();
        panelContent.setWidth("350px");
        panelContent.setContent(componentContainer);

        buttonModal = new Button("...");
        buttonModal.addClickListener(event -> {
            buildModal(component);
        });

        multiLevelComboBox = (MultiLevelComboBox) component;

        components.setSizeFull();
        components.addComponents(panelContent, buttonModal);
        super.addComponent(components);
    }

    public void buildModal(Component component) {
        Window modal = new Window("Dirección");
        modal.setModal(true);
        modal.setWidth("50%");
        modal.setHeight("400px");
        modal.setResizable(false);

        Panel containerModal = new Panel();
        containerModal.setWidth("100%");

        address = new TextArea("Dirección");
        address.setValue(textAreaPrincipal.getValue());
        address.setWidth("100%");

        gridLayoutModal = new GridLayout(4, 4);
        gridLayoutModal.setSpacing(true);
        gridLayoutModal.setMargin(true);
        gridLayoutModal.setSizeFull();

        gridMenuBar = new MenuBar();
        gridMenuBar.addItem("Guardar", x -> saveItem(modal));
        gridMenuBar.addItem("Cancelar", x -> {
            modal.close();
        });

        gridLayoutModal.addComponent(address, 0, 0, 3, 0);
        gridLayoutModal.addComponent(component, 0, 1, 3, 1);
        gridLayoutModal.addComponent(gridMenuBar, 3, 3);
        gridLayoutModal.setComponentAlignment(gridMenuBar, Alignment.TOP_RIGHT);

        containerModal.setContent(gridLayoutModal);
        modal.setContent(containerModal);

        UI.getCurrent().addWindow(modal);
    }

    private void saveItem(Window modal) {
        String addressTxt = address.getValue() + ", " + multiLevelComboBox.getMainComboBox().getSelectedItem().get();
        textAreaPrincipal.setValue(addressTxt);

        modal.close();
    }

    public void setAddressCaption(String caption) {
        address.setCaption(caption);
    }
}
