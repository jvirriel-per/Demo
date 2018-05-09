package com.jvirriel.demo.frontend.components.custom.componentphone;

import com.jvirriel.demo.frontend.components.custom.multiphonecombobox.MultiPhoneComboBox;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class ComponentPhone extends VerticalLayout {

    private CssLayout componentContainer;
    private Panel panelContent;
    private Button buttonModal;
    private CssLayout components;
    private GridLayout gridLayoutModal;
    private MenuBar gridMenuBar;
    private CssLayout cssLayoutPhone = new CssLayout();
    private CssLayout cssLayoutPhoneLandLine = new CssLayout();

    public ComponentPhone(Component component) {
        super.setMargin(false);

        componentContainer = new CssLayout();
        componentContainer.setSizeFull();

        componentContainer.addComponents(cssLayoutPhone, cssLayoutPhoneLandLine);
        components = new CssLayout();

        panelContent = new Panel();
        panelContent.setWidth("500px");
        panelContent.setContent(componentContainer);

        buttonModal = new Button("...");
        buttonModal.addClickListener(event -> {
            buildModal(component);
        });

        components.setSizeFull();
        components.addComponents(panelContent, buttonModal);
        super.addComponent(components);

    }

    public void buildModal(Component component) {
        Window modal = new Window("Dirección");
        modal.setModal(true);
        modal.setWidth("60%");
        modal.setHeight("300px");
        modal.setResizable(false);

        Panel containerModal = new Panel();
        containerModal.setWidth("100%");

        gridLayoutModal = new GridLayout(4, 4);
        gridLayoutModal.setSpacing(true);
        gridLayoutModal.setMargin(true);
        gridLayoutModal.setSizeFull();

        gridMenuBar = new MenuBar();
        gridMenuBar.addItem("Guardar", x -> saveItem(component, modal));
        gridMenuBar.addItem("Cancelar", x -> {
            modal.close();
        });
        gridLayoutModal.addComponent(component, 0, 0, 3, 0);
        gridLayoutModal.addComponent(gridMenuBar, 3, 3);
        gridLayoutModal.setComponentAlignment(gridMenuBar, Alignment.TOP_RIGHT);

        containerModal.setContent(gridLayoutModal);
        modal.setContent(containerModal);

        UI.getCurrent().addWindow(modal);
    }

    private void saveItem(Component component, Window modal) {
        MultiPhoneComboBox multiComboBoxPhone = (MultiPhoneComboBox) component;
        List<List<String>> result = multiComboBoxPhone.getValues();

        for (List<String> s : result) {
            String type = s.get(0);
            String country = s.get(1);
            String codeArea = s.get(2);
            String numberPhone = s.get(3);

            Button button = new Button();
            button.setIcon(VaadinIcons.CLOSE);
            button.setStyleName(ValoTheme.BUTTON_BORDERLESS);

            Label label = new Label();
            label.setContentMode(ContentMode.HTML);

            GridLayout gridLayout = new GridLayout(2, 2);
            Panel panel = new Panel();
            panel.setWidth("180px");

            if (Objects.equals(type, "Móvil")) {
                label.setValue(codeArea + numberPhone);
                label.setIcon(VaadinIcons.MOBILE);
                gridLayout.addComponent(label, 0, 0);
                gridLayout.addComponent(button, 1, 0);
                gridLayout.setComponentAlignment(button, Alignment.BOTTOM_CENTER);
                panel.setContent(gridLayout);
                if (!exist(codeArea + numberPhone)) {
                    cssLayoutPhone.addComponent(panel);
                }
            } else {
                label.setValue(codeArea + numberPhone);
                label.setIcon(VaadinIcons.PHONE_LANDLINE);
                gridLayout.addComponent(label, 0, 0);
                gridLayout.addComponent(button, 1, 0);
                gridLayout.setComponentAlignment(button, Alignment.BOTTOM_CENTER);
                panel.setContent(gridLayout);
                if (!exist(codeArea + numberPhone)) {
                    cssLayoutPhoneLandLine.addComponent(panel);
                }
            }
            button.addClickListener(event -> {
                gridLayout.removeComponent(0, 0);
                gridLayout.removeComponent(1, 0);
                super.removeComponent(gridLayout);
                cssLayoutPhone.removeComponent(panel);
                cssLayoutPhoneLandLine.removeComponent(panel);
            });
        }

        modal.close();
    }

    private boolean exist(String number) {
        Iterator iterate = componentContainer.iterator();
        while (iterate.hasNext()) {
            CssLayout c = (CssLayout) iterate.next();
            Iterator iterate2 = c.iterator();
            while (iterate2.hasNext()) {
                Panel panel = (Panel) iterate2.next();
                Iterator iterator3 = panel.iterator();
                while (iterator3.hasNext()) {
                    GridLayout gridLayout = (GridLayout) iterator3.next();
                    Label label = (Label) gridLayout.getComponent(0, 0);
                    if (Objects.equals(label.getValue(), number)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private List<String> getValues() {
        List<String> result = new ArrayList<>();
        Iterator iterate = componentContainer.iterator();
        while (iterate.hasNext()) {
            CssLayout c = (CssLayout) iterate.next();
            Iterator iterate2 = c.iterator();
            while (iterate2.hasNext()) {
                Panel panel = (Panel) iterate2.next();
                Iterator iterator3 = panel.iterator();
                while (iterator3.hasNext()) {
                    GridLayout gridLayout = (GridLayout) iterator3.next();
                    Label label = (Label) gridLayout.getComponent(0, 0);
                    result.add(label.getValue());
                }
            }
        }
        return result;
    }
}
