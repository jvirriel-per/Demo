package com.jvirriel.demo.frontend.entitytype.views;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.jvirriel.demo.frontend.core.views.base.FilterViewUI;
import com.jvirriel.demo.frontend.core.views.base.GridService;
import com.jvirriel.demo.frontend.core.views.containers.BaseContainerEventNavigate;
import com.jvirriel.search.SearchCondition;
import com.jvirriel.search.SearchOperation;
import com.jvirriel.demo.model.entitytype.EntityType;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.jvirriel.demo.frontend.constant.GeneralConstants.LIST_ID;
import static com.jvirriel.ui.constants.GeneralConstants.*;
import static com.jvirriel.ui.constants.ValidationConstants.*;

public class EntityTypeFilterView extends FilterViewUI<EntityType> {

    private TextField name;
    private TextField code;
    private TextField entityStatusOrder;

    @Override
    protected void setBinder() {
        binder = new Binder<>(EntityType.class);
    }

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
                .withValidator(name -> isGreaterThan(3).test(name.length()), GREATER_OR_EQUAL_THAN_THREE)
                .asRequired(IS_REQUIRED)
                .bind(EntityType::getName, EntityType::setName);

        binder.forField(code)
                .withValidator(code -> isAlpha().test(code), IS_ALPHA)
                .asRequired(IS_REQUIRED)
                .bind(EntityType::getCode, EntityType::setCode);

        binder.forField(entityStatusOrder)
                .withConverter(new StringToIntegerConverter(ONLY_NUMBERS))
                .bind(EntityType::getEntityTypeOrder, EntityType::setEntityTypeOrder);
    }

    @Override
    protected boolean postSave() {
        List<SearchCondition> conditionList = generateFilterCondition();
        GridService.getInstance().addConditions(conditionList);

        bus.post(new BaseContainerEventNavigate(LIST_ID));

        return super.postSave();
    }

    @Override
    protected boolean postCancel() {
        bus.post(new BaseContainerEventNavigate(LIST_ID));
        return super.postCancel();
    }

    public List<SearchCondition> generateFilterCondition() {
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
                AbstractField f = (AbstractField) c;
                if (!f.isEmpty()) {
                    String date;
                    SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
                    date = formatter.format(f.getValue());
                    conditions.add(new SearchCondition(DATE, SearchOperation.EQUALS, date));
                }
            } else if (c instanceof AbstractField) {
                AbstractField f = (AbstractField) c;
                String attribute;
                if (!f.isEmpty()) {
                    switch (f.getCaption()) {
                        case NAME_LABEL:
                            attribute = NAME;
                            break;
                        case CODE_LABEL:
                            attribute = CODE;
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