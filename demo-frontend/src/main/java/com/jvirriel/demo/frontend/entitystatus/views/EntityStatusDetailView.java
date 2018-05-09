package com.jvirriel.demo.frontend.entitystatus.views;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.jvirriel.demo.frontend.core.views.base.FormViewUI;
import com.jvirriel.demo.frontend.core.views.containers.BaseContainerEventNavigate;
import com.jvirriel.demo.frontend.entitystatus.model.EntityStatusModel;
import com.jvirriel.demo.model.entitystatus.EntityStatus;
import com.jvirriel.ui.alertdialog.AlertDialog;
import com.vaadin.data.Binder;
import com.vaadin.data.BinderValidationStatus;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import static com.jvirriel.constants.GeneralConstants.EMPTY_STRING;
import static com.jvirriel.constants.GeneralConstants.LIST_ID;
import static com.jvirriel.demo.frontend.entitystatus.constants.EntityStatusGeneralConstants.ENTITY_CLASS_LABEL;
import static com.jvirriel.demo.frontend.entitystatus.constants.EntityStatusGeneralConstants.ENTITY_STATUS_DETAIL_VIEW_TITLE;
import static com.jvirriel.ui.constants.GeneralConstants.*;
import static com.jvirriel.ui.constants.ValidationConstants.*;

/**
 * Implementación de la vista de formulario en sus tres estados (nuevo, editar y detalle)
 * correspondiente a la funcionalidad EntityStatus.
 */
public class EntityStatusDetailView extends FormViewUI<EntityStatus> {
    private HorizontalLayout firstLayout;
    private TextField name;
    private TextField code;
    private TextField entityStatusOrder;

    private HorizontalLayout secondLayout;
    private TextField defaultValue;
    private TextField entityClass;
    private TextField entitySubClass;

    private EntityStatusModel model;
    private EntityStatus entity;

    /**
     * Recibe el título de la vista para agregarlo.
     *
     * @param title, titulo a ma
     */
    @Override
    public void setTitle(String title) {
        super.setTitle(ENTITY_STATUS_DETAIL_VIEW_TITLE);
    }

    /**
     * Se define el binder (componente nativo vaadin para enlazar valores de una entidad en un formulario) pasándole la
     * entidad principal que se manejará en el formulario.
     */
    @Override
    protected void setBinder() {
        binder = new Binder<>(EntityStatus.class);
        model = new EntityStatusModel();
    }

    /**
     * Permite cargar la ventana en modo "new"
     *
     * @return super.preNew()
     */
    @Override
    protected boolean preNew() {
        entity = new EntityStatus();
        binder.setBean(entity);

        return super.preNew();
    }

    /**
     * Permite cargar la ventana en modo "edit".
     *
     * @return super.preEdit()
     */
    @Override
    protected boolean preEdit() {
        Integer selectedId = this.selectedIds.stream().findFirst().isPresent() ? (Integer) this.selectedIds.stream()
                .findFirst().get() : 0;
        if (selectedId == 0) {
            AlertDialog.danger(UI.getCurrent(), EMPTY_STRING,
                    NO_VALUES_SELECTED, EMPTY_STRING, OK_LABEL, (AlertDialog.Listener) dialog -> {
                    }, null);
            bus.post(new BaseContainerEventNavigate(LIST_ID));
        } else {
            entity = model.findById(selectedId);
            binder.setBean(entity);
        }

        return super.preEdit();
    }

    /**
     * Se usa para agregar los campos que tendrá el formulario y enlazar dichos campos al binder.
     */
    @Override
    protected void fillForm() {
        super.fillForm();

        name = ComponentFactory.textField(NAME_LABEL).get();

        code = ComponentFactory.textField(CODE_LABEL).get();

        entityStatusOrder = ComponentFactory.textField(ORDER_LABEL)
                .get();

        binder.forField(name)
                .withNullRepresentation(EMPTY_STRING)
                .withValidator(name -> isGreaterThan(3).test(name.length()), GREATER_OR_EQUAL_THAN_THREE)
                .asRequired(IS_REQUIRED)
                .bind(EntityStatus::getName, EntityStatus::setName);

        binder.forField(code)
                .withNullRepresentation(EMPTY_STRING)
                .withValidator(code -> isAlphaNumeric().test(code), ONLY_LETTERS_AND_NUMBERS)
                .asRequired(IS_REQUIRED)
                .bind(EntityStatus::getCode, EntityStatus::setCode);

        defaultValue = ComponentFactory.textField(DEFAULT_VALUE_LABEL).get();

        entityClass = ComponentFactory.textField(ENTITY_CLASS_LABEL).get();

        entitySubClass = ComponentFactory.textField(SUBCLASS_LABEL).get();

        firstLayout = ComponentFactory.horizontalLayout()
                .setMargin(false)
                .addComponents(name, code, entityStatusOrder)
                .get();

        secondLayout = ComponentFactory.horizontalLayout()
                .setMargin(false)
                .addComponents(defaultValue, entityClass, entitySubClass)
                .get();

        addComponents(firstLayout, secondLayout);

        binder.forField(entityStatusOrder)
                .withNullRepresentation(EMPTY_STRING)
                .withConverter(new StringToIntegerConverter(ONLY_NUMBERS))
                .bind(EntityStatus::getEntityStatusOrder, EntityStatus::setEntityStatusOrder);

        binder.forField(defaultValue)
                .withNullRepresentation(EMPTY_STRING)
                .withValidator(value -> isNotEmpty().test(value), NO_EMPTY_ALLOWED)
                .bind(EntityStatus::getDefaultValue, EntityStatus::setDefaultValue);

        binder.forField(entityClass)
                .withNullRepresentation(EMPTY_STRING)
                .bind(EntityStatus::getEntityClass, EntityStatus::setEntityClass);

        binder.forField(entitySubClass)
                .withNullRepresentation(EMPTY_STRING)
                .bind(EntityStatus::getEntitySubClass, EntityStatus::setEntitySubClass);
    }

    /**
     * Permite agregarle la acción correspondiente al botón guardar.
     *
     * @return super.actionSave()
     */
    @Override
    protected boolean actionSave() {
        model.update(binder.getBean());

        AlertDialog.success(UI.getCurrent(), EMPTY_STRING,
                SAVE_SUCCESSFULLY, EMPTY_STRING, OK_LABEL, (AlertDialog.Listener) dialog -> {
                }, null);

        return super.actionSave();
    }

    /**
     * Permite evaluar las validaciones aplicadas en el formulario.
     *
     * @return boolean
     */
    @Override
    protected boolean validate() {
        BinderValidationStatus<EntityStatus> status = binder.validate();

        if (!status.hasErrors()) {
            return true;
        } else {
            AlertDialog.danger(UI.getCurrent(), EMPTY_STRING, INFORMATION_WITH_ERRORS, EMPTY_STRING, OK_LABEL,
                    (AlertDialog.Listener) dialog -> {
                    }, null);

            return false;
        }
    }

    /**
     * Permite definir que ocurrirá en la ventana luego de ejecutar la acción de guardar.
     *
     * @return super.postSave()
     */
    @Override
    protected boolean postSave() {
        bus.post(new BaseContainerEventNavigate(LIST_ID));

        return super.postSave();
    }

}