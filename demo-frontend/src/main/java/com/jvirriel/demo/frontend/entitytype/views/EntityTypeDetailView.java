package com.jvirriel.demo.frontend.entitytype.views;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.jvirriel.demo.frontend.core.views.base.FormViewUI;
import com.jvirriel.demo.frontend.core.views.containers.BaseContainerEventNavigate;
import com.jvirriel.demo.frontend.entitytype.model.EntityTypeModel;
import com.jvirriel.demo.model.entitytype.EntityType;
import com.jvirriel.ui.alertdialog.AlertDialog;
import com.vaadin.data.Binder;
import com.vaadin.data.BinderValidationStatus;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import static com.jvirriel.demo.frontend.constant.GeneralConstants.EMPTY_STRING;
import static com.jvirriel.demo.frontend.constant.GeneralConstants.LIST_ID;
import static com.jvirriel.ui.constants.GeneralConstants.*;
import static com.jvirriel.ui.constants.ValidationConstants.*;

public class EntityTypeDetailView extends FormViewUI<EntityType> {

    private HorizontalLayout firstLayout;
    private TextField name;
    private TextField code;
    private TextField entityTypeOrder;

    private HorizontalLayout secondLayout;
    private TextField defaultValue;
    private TextField entityClass;
    private TextField entitySubClass;

    private EntityTypeModel model;
    private EntityType entity;

    public EntityTypeDetailView() {
    }

    @Override
    protected void setBinder() {
        binder = new Binder<>(EntityType.class);
        model = new EntityTypeModel();
    }

    @Override
    protected boolean preNew() {
        entity = new EntityType();
        entity.setEntitySubClass(EMPTY_STRING);
        entity.setEntityTypeOrder(0);
        entity.setCode(EMPTY_STRING);
        entity.setDefaultValue(EMPTY_STRING);
        entity.setEntityClass(EMPTY_STRING);
        binder.setBean(entity);
        return super.preNew();
    }

    @Override
    protected boolean preEdit() {
        Integer selectedId = this.selectedIds.stream().findFirst().isPresent() ? (Integer)
                this.selectedIds.stream().findFirst().get() : 0;
        if (selectedId == 0) {
            showAlertDialog();
        } else {
            entity = model.findById(selectedId);
            binder.setBean(entity);
        }
        return super.preEdit();
    }

    private void showAlertDialog() {
        AlertDialog.danger(UI.getCurrent(), EMPTY_STRING,
                NO_VALUES_SELECTED, EMPTY_STRING, OK_LABEL, (AlertDialog.Listener) dialog -> {
                }, null);
        bus.post(new BaseContainerEventNavigate(LIST_ID));
    }

    @Override
    protected void fillForm() {
        super.fillForm();

        name = ComponentFactory.textField(NAME_LABEL).get();

        code = ComponentFactory.textField(CODE_LABEL).get();

        entityTypeOrder = ComponentFactory.textField(ORDER_LABEL)
                .get();

        defaultValue = ComponentFactory
                .textField(DEFAULT_VALUE_LABEL)
                .get();

        binder.forField(name)
                .withValidator(name -> isGreaterThan(3).test(name.length()), GREATER_OR_EQUAL_THAN_THREE)
                .asRequired(IS_REQUIRED)
                .bind(EntityType::getName, EntityType::setName);

        binder.forField(code)
                .withValidator(code -> isAlpha().test(code), IS_ALPHA)
                .asRequired(IS_REQUIRED)
                .bind(EntityType::getCode, EntityType::setCode);

        entityClass = ComponentFactory.textField(ENTITY_LABEL).get();

        entitySubClass = ComponentFactory.textField(SUBCLASS_LABEL).get();

        firstLayout = ComponentFactory.horizontalLayout().setMargin(false).addComponents(name, code, entityTypeOrder)
                .get();

        secondLayout = ComponentFactory.horizontalLayout().setMargin(false)
                .addComponents(defaultValue, entityClass, entitySubClass)
                .get();

        addComponents(firstLayout, secondLayout);

        binder.forField(entityTypeOrder)
                .withConverter(new StringToIntegerConverter(ONLY_NUMBERS))
                .bind(EntityType::getEntityTypeOrder, EntityType::setEntityTypeOrder);

        binder.forField(defaultValue)
                .withValidator(value -> isNotEmpty().test(value), IS_REQUIRED)
                .bind(EntityType::getDefaultValue, EntityType::setDefaultValue);

        binder.forField(entityClass)
                .bind(EntityType::getEntityClass, EntityType::setEntityClass);

        binder.forField(entitySubClass)
                .bind(EntityType::getEntitySubClass, EntityType::setEntitySubClass);
    }

    @Override
    protected boolean preSave() {
        return super.preSave();
    }

    @Override
    protected boolean actionSave() {
        model.update(binder.getBean());

        AlertDialog.success(UI.getCurrent(), EMPTY_STRING,
                SAVE_SUCCESSFULLY, EMPTY_STRING, OK_LABEL, (AlertDialog.Listener) dialog -> {
                }, null);

        return super.actionSave();
    }

    @Override
    protected boolean validate() {
        BinderValidationStatus<EntityType> status = binder.validate();

        if (!status.hasErrors()) {
            return true;
        } else {
            AlertDialog.danger(UI.getCurrent(), EMPTY_STRING,
                    INFORMATION_WITH_ERRORS, EMPTY_STRING, OK_LABEL, (AlertDialog.Listener) dialog -> {
                    }, null);
            return false;
        }
    }

    @Override
    protected boolean postSave() {
        bus.post(new BaseContainerEventNavigate(LIST_ID));
        return super.postSave();
    }

    @Override
    protected boolean postCancel() {
        bus.post(new BaseContainerEventNavigate(LIST_ID));
        return super.postCancel();
    }
}