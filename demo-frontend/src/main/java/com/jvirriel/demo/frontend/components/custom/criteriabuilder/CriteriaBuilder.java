package com.jvirriel.demo.frontend.components.custom.criteriabuilder;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.Property.ValueChangeListener;
import com.vaadin.v7.data.util.BeanItemContainer;
import com.vaadin.v7.data.util.ContainerHierarchicalWrapper;
import com.vaadin.v7.ui.CheckBox;
import com.vaadin.v7.ui.ComboBox;
import com.vaadin.v7.ui.*;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.TextField;
import com.vaadin.v7.ui.VerticalLayout;

import java.util.*;

public class CriteriaBuilder extends Panel {
    protected TreeTable tree;
    protected Button addButton;
    protected Button addGroupButton;
    protected Button delButton;
    protected AbstractOrderedLayout mainLayout;
    protected AbstractOrderedLayout buttonLayout;
    protected Collection<CriteriaField> criteriaFields;
    protected CriteriaConditionContainer conditionContainer;
    protected ContainerHierarchicalWrapper itemContainerWrapper;
    protected CriteriaItemFactory defaultCriteriaItemFactory;
    private CriteriaItemFactory criteriaItemFactory;
    public Map<Object, ComboBox> elementConditionFields;
    public Map<Object, ComboBox> fieldFields;
    public Map<Object, TextField> valueConditionFields;

    public CriteriaBuilder(Collection<CriteriaField> criteriaFields) {
        this(criteriaFields, null);
    }

    public CriteriaBuilder(Collection<CriteriaField> criteriaFields, ContainerHierarchicalWrapper existingItemContainerWrapper) {
        this.elementConditionFields = new HashMap();
        this.fieldFields = new HashMap();
        this.valueConditionFields = new HashMap();
        this.criteriaFields = criteriaFields;
        this.mainLayout = new VerticalLayout();
        this.buttonLayout = new HorizontalLayout();
        this.conditionContainer = new CriteriaConditionContainer();
        ResourceBundle bundle = this.getBundle();
        this.defaultCriteriaItemFactory = new DefaultCriteriaItemFactory();

        this.addButton = new Button(bundle.getString("addItem"));
        this.addButton.setCaption("Item");
        this.addButton.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        this.addButton.setIcon(FontAwesome.PLUS_CIRCLE);
        this.addButton.addClickListener((ClickListener) event -> CriteriaBuilder.this.addItem(false));

        this.addGroupButton = new Button(bundle.getString("addGroup"));
        this.addGroupButton.setIcon(FontAwesome.PLUS_CIRCLE);
        this.addGroupButton.setCaption("Grupo");
        this.addGroupButton.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        this.addGroupButton.addClickListener((ClickListener) event -> CriteriaBuilder.this.addItem(true));

        this.delButton = new Button(bundle.getString("delete"));
        this.delButton.setCaption("Eliminar");
        this.delButton.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        this.delButton.setIcon(FontAwesome.TRASH);
        this.delButton.addClickListener((ClickListener) event -> CriteriaBuilder.this.delItem());

        this.tree = new TreeTable();
        this.tree.setStyleName(ValoTheme.TREETABLE_COMPACT);

        if (existingItemContainerWrapper == null) {
            this.itemContainerWrapper = new ContainerHierarchicalWrapper(new BeanItemContainer(CriteriaItem.class));
            this.addRootElement();
        } else {
            this.itemContainerWrapper = existingItemContainerWrapper;
            this.updateParentsInWrapper();
        }

        this.tree.setContainerDataSource(this.itemContainerWrapper);
        this.initUiTree();
        this.updateChildrenAllowed();
        this.expandAllTree();
        this.tree.setSizeFull();
        this.tree.setSelectable(true);
        this.tree.setTableFieldFactory(new CriteriaTableFieldFactory());
        this.tree.setImmediate(true);
        this.tree.setBuffered(false);
        this.tree.setEditable(true);
        this.buttonLayout.addComponent(this.addButton);
        this.buttonLayout.addComponent(this.addGroupButton);
        this.buttonLayout.addComponent(this.delButton);
        this.mainLayout.setSizeFull();
        this.mainLayout.addComponent(this.buttonLayout);
        this.mainLayout.addComponent(this.tree);
//        this.mainLayout.setExpandRatio(this.tree, 1.0F);
        this.setContent(this.mainLayout);
    }

    protected ComboBox createAndOrComboBox() {
        ComboBox comboBox = new ComboBox();
        comboBox.addItem("AND");
        comboBox.addItem("OR");
        comboBox.setRequired(true);
        comboBox.setValue("AND");
        return comboBox;
    }

    protected ComboBox createConditionComboBox() {
        ComboBox comboBox = new ComboBox();
        comboBox.addItem("Greater then");
        comboBox.addItem("Less then");
        comboBox.addItem("Equal");
        return comboBox;
    }

    protected ComboBox createCriteriaFieldComboBox() {
        ComboBox comboBox = new ComboBox();
        comboBox.addItems(this.criteriaFields);
        return comboBox;
    }

    public Collection<CriteriaField> getCriteriaFields() {
        return this.criteriaFields;
    }

    public void setCriteriaFields(Collection<CriteriaField> criteriaFields) {
        this.criteriaFields = criteriaFields;
    }

    private void addRootElement() {
        CriteriaItem root = new CriteriaItem(null, false, this.conditionContainer.getGroupCondition("and"));
        this.itemContainerWrapper.addItem(root);
        this.itemContainerWrapper.setChildrenAllowed(root, false);
    }

    private void addItem(boolean flGroup) {
        CriteriaItem selectedItem = (CriteriaItem) this.tree.getValue();
        if (selectedItem == null) {
            selectedItem = this.getRootItem();
        }

        if (!selectedItem.isFlagGroup()) {
            selectedItem = selectedItem.getParent();
        }

        CriteriaItemFactory curCriteriaItemFactory;
        if (this.criteriaItemFactory == null) {
            curCriteriaItemFactory = this.defaultCriteriaItemFactory;
        } else {
            curCriteriaItemFactory = this.criteriaItemFactory;
        }

        CriteriaItem item;
        if (flGroup) {
            item = curCriteriaItemFactory.makeGroup(selectedItem, false, this.conditionContainer.getGroupCondition("and"));
        } else {
            item = curCriteriaItemFactory.makeItem(selectedItem, null, false, this.conditionContainer.getElementCondition("equal"), "", true);
        }

        this.itemContainerWrapper.setChildrenAllowed(selectedItem, true);
        this.itemContainerWrapper.addItem(item);
        this.itemContainerWrapper.setParent(item, selectedItem);
        this.itemContainerWrapper.setChildrenAllowed(item, false);
        this.tree.setCollapsed(selectedItem, true);
        this.tree.setCollapsed(selectedItem, false);
    }

    private void delItem() {
        CriteriaItem selectedItem = (CriteriaItem) this.tree.getValue();
        if (selectedItem != null) {
            if (selectedItem != this.getRootItem() && !this.itemContainerWrapper.hasChildren(selectedItem)) {
                this.itemContainerWrapper.removeItem(selectedItem);
            }
        }
    }

    public ContainerHierarchicalWrapper getItemContainerWrapper() {
        return this.itemContainerWrapper;
    }

    public CriteriaItem getRootItem() {
        Collection collectionRoots = this.itemContainerWrapper.rootItemIds();
        if (collectionRoots.size() == 0) {
            this.addRootElement();
            collectionRoots = this.itemContainerWrapper.rootItemIds();
        }

        return (CriteriaItem) collectionRoots.iterator().next();
    }

    protected ResourceBundle getBundle() {
        return this.conditionContainer.getBundle();
    }

    public boolean validate() {
        Iterator var2 = this.itemContainerWrapper.getItemIds().iterator();

        while (var2.hasNext()) {
            CriteriaItem item = (CriteriaItem) var2.next();
            int valid = item.validate();
            if (valid != 0) {
                this.tree.select(item);
                switch (valid) {
                    case -6:
                        this.elementConditionFields.get(item).focus();
                        Notification.show(this.getBundle().getString("invalidElementCondition"));
                        break;
                    case -5:
                    case -4:
                        this.valueConditionFields.get(item).focus();
                        Notification.show(this.getBundle().getString("invalidValue"));
                    case -3:
                    default:
                        break;
                    case -2:
                        this.elementConditionFields.get(item).focus();
                        Notification.show(this.getBundle().getString("naElementCondition"));
                        break;
                    case -1:
                        this.fieldFields.get(item).focus();
                        Notification.show(this.getBundle().getString("naField"));
                }

                return false;
            }
        }

        return true;
    }

    public CriteriaItemFactory getCriteriaItemFactory() {
        return this.criteriaItemFactory;
    }

    public void setCriteriaItemFactory(CriteriaItemFactory criteriaItemFactory) {
        this.criteriaItemFactory = criteriaItemFactory;
    }

    public AbstractOrderedLayout getButtonLayout() {
        return this.buttonLayout;
    }

    private void initUiTree() {
        ResourceBundle bundle = this.getBundle();
        this.tree.setVisibleColumns(new Object[]{"flagNot", "field", "elementCondition", "value",
                "ignoreCase", "groupCondition"});
/*        this.tree.setColumnHeaders(new String[]{
                bundle.getString("not"),
                bundle.getString("fields"),
                bundle.getString("elementCondition"),
                bundle.getString("value"),
                bundle.getString("ignoreCase"),
                bundle.getString("groupCondition")});*/
        this.tree.setColumnHeaders(new String[]{
                "Negación", "Parámetro", "Operador", "Valor", "Ignorar mayúsculas","Condición lógica"});
        this.tree.setColumnWidth("not", 2);
        this.tree.setColumnWidth("ignoreCase", -1);
        this.tree.setColumnWidth("groupCondition", -15);
        this.tree.setColumnExpandRatio("field", 2);
        this.tree.setColumnExpandRatio("elementCondition", 2);
        this.tree.setColumnExpandRatio("value", 2);
    }

    private void expandAllTree() {
        Iterator var2 = this.tree.getItemIds().iterator();

        while (var2.hasNext()) {
            Object itemId = var2.next();
            this.tree.setCollapsed(itemId, false);
        }

    }

    public CriteriaConditionContainer getConditionContainer() {
        return this.conditionContainer;
    }

    private void updateParentsInWrapper() {
        Collection items = this.itemContainerWrapper.getItemIds();
        Iterator var3 = items.iterator();

        while (var3.hasNext()) {
            CriteriaItem item = (CriteriaItem) var3.next();
            this.itemContainerWrapper.setParent(item, item.getParent());
        }

    }

    private void updateChildrenAllowed() {
        Collection items = this.itemContainerWrapper.getItemIds();
        Iterator var3 = items.iterator();

        while (var3.hasNext()) {
            CriteriaItem item = (CriteriaItem) var3.next();
            this.tree.setChildrenAllowed(item, item.isFlagGroup());
        }

    }

    class CriteriaTableFieldFactory implements TableFieldFactory {
        CriteriaTableFieldFactory() {
        }

        public Field<?> createField(Container container, final Object itemId, Object propertyId, Component uiContext) {
            boolean flGroup = container.getContainerProperty(itemId, "flagGroup").getValue().equals(Boolean.TRUE);
            ComboBox chb2;
            if ("field".equals(propertyId) && !flGroup) {
                chb2 = new ComboBox(null, CriteriaBuilder.this.criteriaFields);
                chb2.setSizeFull();
                chb2.setValidationVisible(true);
                chb2.setImmediate(true);
                chb2.addValueChangeListener((ValueChangeListener) event -> {
                    CriteriaField field = (CriteriaField) event.getProperty().getValue();
                    if (field != null) {
                        ComboBox comp = CriteriaBuilder.this.elementConditionFields.get(itemId);
                        if (comp != null) {
                            Container newContainer;
                            if (field.getClassField() == CriteriaField.ClassField.STRING) {
                                newContainer = CriteriaBuilder.this.conditionContainer.getElementConditionContainer();
                            } else {
                                newContainer = CriteriaBuilder.this.conditionContainer.getElementConditionWoStringContainer();
                            }

                            if (comp.getContainerDataSource() != newContainer) {
                                Object oldValue = comp.getValue();
                                comp.setContainerDataSource(newContainer);
                                if (newContainer.getItem(oldValue) != null) {
                                    comp.setValue(oldValue);
                                }
                            }

                        }
                    }
                });
                CriteriaBuilder.this.fieldFields.put(itemId, chb2);
                return chb2;
            } else if ("elementCondition".equals(propertyId) && !flGroup) {
                chb2 = new ComboBox(null, CriteriaBuilder.this.conditionContainer.getElementConditionContainer());
                chb2.setSizeFull();
                chb2.setValidationVisible(true);
                CriteriaBuilder.this.elementConditionFields.put(itemId, chb2);
                return chb2;
            } else {
                if ("groupCondition".equals(propertyId) && flGroup) {
                    chb2 = new ComboBox(null, CriteriaBuilder.this.conditionContainer.getGroupConditionCollection());
                    chb2.setSizeFull();
                    return chb2;
                } else {
                    CheckBox chb;
                    if ("flagNot".equals(propertyId)) {
                        chb = new CheckBox();
                        return chb;
                    } else if ("value".equals(propertyId) && !flGroup) {
                        TextField chb1 = new TextField();
                        chb1.setSizeFull();
                        CriteriaBuilder.this.valueConditionFields.put(itemId, chb1);
                        return chb1;
                    } else if ("ignoreCase".equals(propertyId)) {
                        chb = new CheckBox();
                        chb.setReadOnly(flGroup);
                        return chb;
                    } else {
                        return null;
                    }
                }
            }
        }
    }
}