package com.jvirriel.demo.frontend.entitystatus.views;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.jvirriel.demo.frontend.core.views.base.FilterViewUI;
import com.jvirriel.demo.frontend.core.views.base.GridService;
import com.jvirriel.demo.frontend.core.views.containers.BaseContainerEventNavigate;
import com.jvirriel.search.SearchCondition;
import com.jvirriel.search.SearchOperation;
import com.jvirriel.demo.model.entitystatus.EntityStatus;
import com.vaadin.data.Binder;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.jvirriel.constants.GeneralConstants.LIST_ID;
import static com.jvirriel.demo.frontend.entitystatus.constants.EntityStatusGeneralConstants.ENTITY_STATUS_FILTER_VIEW_TITLE;
import static com.jvirriel.ui.constants.GeneralConstants.*;

/**
 * Implementación de la vista de buscar correspondiente a la funcionalidad EntityStatus.
 */
public class EntityStatusFilterView extends FilterViewUI<EntityStatus> {
    private TextField name;
    private TextField code;
    private TextField entityStatusOrder;

    @Override
    public void setTitle(String title) {
        super.setTitle(ENTITY_STATUS_FILTER_VIEW_TITLE);
    }

    /**
     * Se define el binder (componente nativo vaadin para enlazar valores de una entidad en un formulario) pasándole la
     * entidad principal que se manejará en el formulario.
     */
    @Override
    protected void setBinder() {
        binder = new Binder<>(EntityStatus.class);
    }

    /**
     * Se usa para agregar los campos que tendrá el formulario y enlazar dichos campos al binder.
     */
    @Override
    protected void fillForm() {
        super.fillForm();

        name = ComponentFactory
                .textField(NAME_LABEL)
                .get();

        code = ComponentFactory
                .textField(CODE_LABEL)
                .get();

        entityStatusOrder = ComponentFactory
                .textField(ORDER_LABEL)
                .get();

        addComponents(name, code, entityStatusOrder);

        binder.forField(name)
                .bind(EntityStatus::getName, EntityStatus::setName);

        binder.forField(code)
                .bind(EntityStatus::getCode, EntityStatus::setCode);
    }

    @Override
    protected boolean postSave() {
        List<SearchCondition> conditionList = generateFilterCondition();
        GridService.getInstance().addConditions(conditionList);

        bus.post(new BaseContainerEventNavigate(LIST_ID));

        return super.postSave();
    }

    /**
     * Se construye la lista de condiciones a enviar al listado.
     *
     * @return conditions, lista de condiciones a enviar a BE.
     */
    @Override
    protected List<SearchCondition> generateFilterCondition() {
        List<SearchCondition> conditions = new ArrayList<>();
        SearchCondition condition;
        List<Component> form = getAllComponent();

        for (Component c : form) {
            if (c instanceof ComboBox) {
                condition = (SearchCondition) ((ComboBox) c).getData();
                if (condition != null && !((ComboBox) c).isEmpty()) {
                    conditions.add(condition);
                }
            } else if (c instanceof CheckBox) {
                condition = (SearchCondition) ((CheckBox) c).getData();
                if (condition != null) {
                    conditions.add(condition);
                }
            } else if (c instanceof DateField) {
                AbstractField f;
                f = (AbstractField) c;
                if (!f.isEmpty()) {
                    String date;
                    SimpleDateFormat formatter;
                    formatter = new SimpleDateFormat(DATE_FORMAT);
                    date = formatter.format(f.getValue());
                    conditions.add(new SearchCondition(DATE, SearchOperation.EQUALS, date));
                }
            } else if (c instanceof AbstractField) {
                AbstractField f;
                f = (AbstractField) c;
                String attribute;
                if (!f.isEmpty()) {
                    switch (f.getCaption()) {
                        case CODE_LABEL:
                            attribute = CODE;
                            break;
                        case NAME_LABEL:
                            attribute = NAME;
                            break;
                        default:
                            attribute = NAME;
                    }
                    conditions.add(new SearchCondition(attribute, SearchOperation.EQUALS, f.getValue().toString()));
                }
            }
        }

        return conditions;
    }
}