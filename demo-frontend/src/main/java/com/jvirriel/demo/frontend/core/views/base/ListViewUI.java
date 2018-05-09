package com.jvirriel.demo.frontend.core.views.base;


import com.pt.base.core.views.navigator.BaseNavigatorEvent;
import com.pt.util.search.SearchCondition;
import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.ui.Grid;
import rx.Subscription;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * ListViewUI:
 * <p>
 * Creado por bpena el 20/04/2017.
 */
public abstract class ListViewUI<T> extends ViewUI {
    protected Grid<T> grid;

    protected static Subscription conditionsSubscription;
    protected static Subscription selectedIdsSubscription;
    protected List<SearchCondition> conditions = new ArrayList<>();

    protected String code;
    protected static Subscription codeSubscription;

    protected String name;
    protected static Subscription nameSubscription;

    protected List<String> parametersList;
    protected static Subscription parametersListSubscription;

    public ListViewUI() {
        grid = new Grid<>();
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addSelectionListener(this::selectionListener);

        buildGrid();

        isResponsive();
        addComponent(grid);
    }

    protected void selectionListener(SelectionEvent<T> event) {
    }

    protected void buildGrid() {
        grid.setWidth("100%");
        fillGrid();
    }

    protected void fillGrid() {
    }

    @Override
    protected void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);

        grid.setEnabled(true);
    }

    protected void updateConditions(List<SearchCondition> conditionList) {
        List<SearchCondition> list = new ArrayList<>();
        if (conditionList != null) {
            conditionList.forEach(list::add);
            this.conditions = list;
            fillGrid();
        }
    }

    protected void receiveParametersList(List<String> parametersList) {
        List<String> list = new ArrayList<>();
        if (parametersList != null) {
            parametersList.forEach(list::add);
            this.parametersList = list;
            fillGrid();
        }
    }

    protected void updateCode(String code) {
        if (code != null)
            this.code = code;
    }

    protected void updateName(String name) {
        if (name != null)
            this.name = name;
    }

    @Override
    public void enter(BaseNavigatorEvent event) {
        super.enter(event);
        conditionsSubscription = GridService
                .getInstance()
                .getConditionsObservable()
                .subscribe(this::updateConditions);

        codeSubscription = GridService
                .getInstance()
                .getCodeObservable()
                .subscribe(this::updateCode);

        nameSubscription = GridService
                .getInstance()
                .getNameObservable()
                .subscribe(this::updateName);

        selectedIdsSubscription = GridService
                .getInstance()
                .getListObservable()
                .subscribe(this::updateSelected);

        parametersListSubscription = GridService
                .getInstance()
                .getParametersListObservable()
                .subscribe(this::receiveParametersList);
    }

    protected void updateSelected(Set<Number> ids) {
        if (ids != null) {
            Set<T> items = grid.getSelectedItems();
            items.forEach(item -> {
                try {
                    Method method = item.getClass().getMethod("getId");
                    if (!Objects.isNull(method)) {
                        Number id = (Number) method.invoke(item, (Object[]) null);
                        if (!ids.contains(id)) {
                            grid.deselect(item);
                        }
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    protected boolean postSave() {
        GridService.getInstance().removeCode();
        GridService.getInstance().removeName();
        return super.postSave();
    }

    @Override
    public void out() {
        super.out();
        if (conditionsSubscription != null)
            conditionsSubscription.unsubscribe();
        if (selectedIdsSubscription != null)
            selectedIdsSubscription.unsubscribe();
        if (codeSubscription != null)
            codeSubscription.unsubscribe();
        if (nameSubscription != null)
            nameSubscription.unsubscribe();
        if (parametersListSubscription != null)
            parametersListSubscription.unsubscribe();
    }
}