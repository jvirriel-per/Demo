package com.jvirriel.demo.frontend.components.custom.multiphonecombobox;

import com.vaadin.data.HasValue;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Boolean.FALSE;

public class MultiPhoneComboBox<M, L1, L2, L3> extends VerticalLayout {

    private VerticalLayout componentContainer;
    private VerticalLayout container;

    private TextField numberPhone;
    private Button removeButton;

    private ComboBox<M> comboBoxCountry;
    private ComboBox<L1> comboBoxType;
    private ComboBox<L2> comboBoxCodeArea;

    private List<Component> componentsList;

    private List<M> listCountry;
    private List<L1> listType;
    private List<L2> listCodeAreaMobile;
    private List<L2> listCodeAreaLocal;

    public MultiPhoneComboBox() {
        super();
        this.componentsList = new ArrayList<>();

        this.comboBoxCountry = new ComboBox<>();
        this.comboBoxCountry.setEmptySelectionAllowed(FALSE);

        this.comboBoxType = new ComboBox<>();
        this.comboBoxType.setEmptySelectionAllowed(FALSE);

        this.comboBoxCodeArea = new ComboBox<>();
        this.comboBoxCodeArea.setEmptySelectionAllowed(FALSE);

        this.numberPhone = new TextField();

        this.listCountry = new ArrayList<>();
        this.listType = new ArrayList<>();
        this.listCodeAreaMobile = new ArrayList<>();
        this.listCodeAreaLocal = new ArrayList<>();

        removeButton = new Button(VaadinIcons.MINUS);

        container = new VerticalLayout();
        container.setMargin(false);

        Button addButton = new Button(VaadinIcons.PLUS);
        addButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        addButton.addClickListener(event -> addNewRowToContainer());

        HorizontalLayout addButtonLayout = new HorizontalLayout();
        addButtonLayout.setMargin(false);
        addButtonLayout.addComponents(addButton);

        super.addComponents(addButtonLayout);
    }

    private void addNewRowToContainer() {
        CssLayout cssLayout = new CssLayout();

        removeButton = new Button(VaadinIcons.MINUS);

        /*ESTUDIAR CAMBIO*/

        ComboBox<L1> comboBox1 = new ComboBox<>();
        comboBox1.setItems(listType);
        comboBox1.setSelectedItem((L1) "Tipo");

        ComboBox<M> comboBox2 = new ComboBox<>();
        comboBox2.setItems(listCountry);
        comboBox2.setSelectedItem((M) "Venezuela");

        ComboBox<L2> comboBox3 = new ComboBox<>();
        comboBox3.setItems(listCodeAreaMobile);

        TextField textField = new TextField();

        comboBox1.addValueChangeListener(event -> {
            comboBox3.setItems(new ArrayList<>());
            if (comboBox2.getSelectedItem().get() == "Venezuela") {
                if (event.getValue() == "Móvil") {
                    comboBox3.setItems(listCodeAreaMobile);
                } else if (event.getValue() == "Local") {
                    comboBox3.setItems(listCodeAreaLocal);
                }
            }
        });
        cssLayout.addComponents(comboBox1, removeButton);
        cssLayout.addComponents(comboBox2, removeButton);
        cssLayout.addComponents(comboBox3, removeButton);
        cssLayout.addComponents(textField, removeButton);

        componentContainer.addComponents(cssLayout);

        removeButton.addClickListener(this::removeEvent);
    }

    private void removeEvent(Button.ClickEvent event) {
        for (Object aComponentContainer : componentContainer) {
            CssLayout c;
            c = (CssLayout) aComponentContainer;
            for (Object c2 : c) {
                if (c2 == event.getComponent()) {
                    componentContainer.removeComponent(c);
                }
            }
        }
    }

    public void addComponentsToRow() {
        componentContainer = new VerticalLayout();
        componentContainer.setMargin(false);

        CssLayout cssLayout = new CssLayout();

        comboBoxType.setItems(listType);
        comboBoxType.setSelectedItem((L1) "Tipo");

        comboBoxCountry.setItems(listCountry);
        comboBoxCountry.setSelectedItem((M) "Venezuela");

        comboBoxCodeArea.setItems(listCodeAreaMobile);

        this.setComboBoxTypeValueChangeListener(event -> {

            this.getComboBoxCodeArea().setSelectedItem((L2) "");
            this.getComboBoxCodeArea().setItems(new ArrayList<>());
            numberPhone.setValue("");

            if (this.getComboBoxCountry().getSelectedItem().get() == "Venezuela") {
                if (event.getValue() == "Móvil") {
                    this.setListCodeAreaMobile(listCodeAreaMobile);
                    this.getComboBoxCodeArea().setItems(listCodeAreaMobile);
                } else if (event.getValue() == "Local") {
                    this.setListCodeAreaLocal(listCodeAreaLocal);
                    this.getComboBoxCodeArea().setItems(listCodeAreaLocal);
                }
            }
        });

        List<Component> components = new ArrayList<>();
        components.add(comboBoxType);
        components.add(comboBoxCountry);
        components.add(comboBoxCodeArea);
        components.add(numberPhone);

        componentsList = components;

        for (Component component : components) {
            cssLayout.addComponents(component, removeButton);
        }

        componentContainer.addComponent(cssLayout);
        container.addComponent(componentContainer);

        super.addComponent(container);
    }

    public ComboBox<M> getComboBoxCountry() {
        return comboBoxCountry;
    }

    public ComboBox<L2> getComboBoxCodeArea() {
        return comboBoxCodeArea;
    }

    public void setComboBoxTypeValueChangeListener(HasValue.ValueChangeListener<L1> listener) {
        this.comboBoxType.addValueChangeListener(listener);
    }

    public void setListCodeAreaMobile(List<L2> listCodeAreaMobile) {
        this.listCodeAreaMobile = listCodeAreaMobile;
    }

    public void setListCodeAreaLocal(List<L2> listCodeAreaLocal) {
        this.listCodeAreaLocal = listCodeAreaLocal;
    }

    public List<List<String>> getValues() {
        List<String> valueList = new ArrayList<>();
        List<List<String>> listFinal = new ArrayList<>();

        Iterator iterate;
        iterate = container.iterator();

        while (iterate.hasNext()) {
            VerticalLayout v = (VerticalLayout) iterate.next();
            Iterator iterator = v.iterator();
            while (iterator.hasNext()) {
                CssLayout c = (CssLayout) iterator.next();
                Iterator iterator2 = c.iterator();
                while (iterator2.hasNext()) {
                    Component c2 = (Component) iterator2.next();
                    if (c2 instanceof ComboBox) {
                        valueList.add(((ComboBox) c2).getValue().toString());
                    }
                    if (c2 instanceof TextField) {
                        valueList.add(((TextField) c2).getValue());
                    }
                }

                listFinal.add(valueList);
                valueList = new ArrayList<>();
            }

        }

        return listFinal;
    }

    public ComboBox<L1> getComboBoxType() {
        return comboBoxType;
    }

    public TextField getNumberPhone() {
        return numberPhone;
    }

    public void setComboBoxCountryValueChangeListener(HasValue.ValueChangeListener<M> listener) {
        this.comboBoxCountry.addValueChangeListener(listener);
    }

    public void setComboBoxCodeAreaValueChangeListener(HasValue.ValueChangeListener<L2> listener) {
        this.comboBoxCodeArea.addValueChangeListener(listener);
    }

    public void setListType(List<L1> listType) {
        this.listType = listType;
    }

    public void setListCountry(List<M> listCountry) {
        this.listCountry = listCountry;
    }

}
