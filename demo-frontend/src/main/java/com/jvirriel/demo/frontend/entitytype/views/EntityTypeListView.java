package com.jvirriel.demo.frontend.entitytype.views;

import com.jvirriel.demo.frontend.core.views.base.GridService;
import com.jvirriel.demo.frontend.core.views.base.ListViewUI;
import com.jvirriel.demo.frontend.core.views.containers.BaseContainerEventNavigate;
import com.jvirriel.demo.frontend.entitytype.model.EntityTypeModel;
import com.jvirriel.search.ConditionParser;
import com.jvirriel.demo.model.entitytype.EntityType;
import com.jvirriel.ui.alertdialog.AlertDialog;
import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.ui.UI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.jvirriel.demo.frontend.constant.GeneralConstants.DEFAULT_PAGE_NUMBER;
import static com.jvirriel.demo.frontend.constant.GeneralConstants.DEFAULT_PAGE_SIZE;
import static com.jvirriel.demo.frontend.constant.GeneralConstants.EMPTY_STRING;
import static com.jvirriel.demo.frontend.constant.GeneralConstants.LIST;
import static com.jvirriel.demo.frontend.entitystatus.constants.EntityStatusGeneralConstants.DEFAULT_VALUE;
import static com.jvirriel.demo.frontend.entitytype.constants.EntityTypeGeneralConstants.ENTITY_TYPE_LIST_VIEW_TITLE;
import static com.jvirriel.demo.frontend.entitytype.constants.EntityTypeServiceConstants.CODE;
import static com.jvirriel.demo.frontend.entitytype.constants.EntityTypeServiceConstants.NAME;
import static com.jvirriel.ui.constants.GeneralConstants.*;
import static com.jvirriel.ui.constants.ValidationConstants.*;

public class EntityTypeListView extends ListViewUI<EntityType> {

    private EntityTypeModel model;
    private Set<Number> selectedValue;
    private List<EntityType> list;

    @Override
    public void setTitle(String title) {
        super.setTitle(ENTITY_TYPE_LIST_VIEW_TITLE);
    }

    @Override
    protected void buildGrid() {
        super.buildGrid();
        grid.addColumn(EntityType::getCode).setId(CODE).setCaption(CODE_LABEL);
        grid.addColumn(EntityType::getName).setId(NAME).setCaption(NAME_LABEL);
        grid.addColumn(EntityType::getDefaultValue).setId(DEFAULT_VALUE).setCaption(DEFAULT_VALUE_LABEL);
    }

    @Override
    protected void fillGrid() {
        super.fillGrid();

        model = new EntityTypeModel();

        String search = ConditionParser.parseRsqlCondition(this.conditions);
        list = model.findAll(search, EMPTY_STRING, DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE);

        grid.setItems(list);
    }

    @Override
    protected void selectionListener(SelectionEvent<EntityType> event) {
        super.selectionListener(event);

        Set<EntityType> selectedValues = event.getAllSelectedItems();
        Set<Number> list = new HashSet<>();
        selectedValues.forEach(item -> list.add(item.getId()));
        GridService.getInstance().addSelectedIds(list);
        selectedValue = list;
    }

    @Override
    protected boolean deleteAction() {
        try {
            Integer id;
            id = (Integer) selectedValue.stream().findFirst().get();

            AlertDialog.delete(UI.getCurrent(), DELETE_RECORD, DELETE_CONFIRMATION, YES_LABEL,
                    NO_LABEL, (AlertDialog.Listener) dialog -> {
                        if (dialog.isConfirmed()) {
                            model.delete(id);
                            AlertDialog.success(UI.getCurrent(), EMPTY_STRING,
                                    RECORD_DELETED, EMPTY_STRING, GO_ON,
                                    (AlertDialog.Listener) dialog2 -> {
                                    }, "84.5px");
                            bus.post(new BaseContainerEventNavigate(LIST));

                        }
                    }, null);
        } catch (Exception e) {
            AlertDialog.danger(UI.getCurrent(), EMPTY_STRING, NO_VALUES_SELECTED, EMPTY_STRING, OK_LABEL,
                    (AlertDialog.Listener) dialog -> {
                    }, null);
        }
        return super.deleteAction();
    }
}