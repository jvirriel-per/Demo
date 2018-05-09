package com.jvirriel.demo.frontend.core.views.base;

import com.pt.util.search.SearchCondition;
import rx.subjects.BehaviorSubject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GridService {
    private static GridService gridService;
    private BehaviorSubject<Set<Number>> listObservable;
    private Set<Number> selectedIds;

    private BehaviorSubject<List<SearchCondition>> conditionsObservable;
    private List<SearchCondition> conditions;

    private BehaviorSubject<String> codeObservable;
    private String code;

    private BehaviorSubject<String> nameObservable;
    private String name;

    private BehaviorSubject<List<String>> parametersListObservable;
    private List<String> parametersList;

    private GridService() {
        this.selectedIds = new HashSet<>();
        this.conditions = new ArrayList<>();

        this.parametersList = new ArrayList<>();

        this.name = "";
        this.code = "";

        this.listObservable = BehaviorSubject.create(this.selectedIds);
        this.conditionsObservable = BehaviorSubject.create(this.conditions);

        this.nameObservable = BehaviorSubject.create(this.name);
        this.codeObservable = BehaviorSubject.create(this.code);

        this.parametersListObservable = BehaviorSubject.create(this.parametersList);
    }

    public static GridService getInstance() {
        if (gridService == null)
            gridService = new GridService();

        return gridService;
    }

    public BehaviorSubject<Set<Number>> getListObservable() {
        return this.listObservable;
    }

    public BehaviorSubject<List<SearchCondition>> getConditionsObservable() {
        return this.conditionsObservable;
    }

    public BehaviorSubject<String> getCodeObservable() {
        return this.codeObservable;
    }

    public BehaviorSubject<String> getNameObservable() {
        return this.nameObservable;
    }

    public BehaviorSubject<List<String>> getParametersListObservable() {
        return this.parametersListObservable;
    }

    public void addConditions(List<SearchCondition> conditions) {
        this.conditionsObservable.onNext(conditions);
    }

    public void addParametersList(List<String> parametersList) {
        this.parametersListObservable.onNext(parametersList);
    }

    public void removeParametersList() {
        this.parametersList = new ArrayList<>();
        this.parametersListObservable.onNext(this.parametersList);
    }

    public void addCode(String code) {
        this.codeObservable.onNext(code);
    }

    public void addName(String name) {
        this.nameObservable.onNext(name);
    }

    public void addSelectedId(Number id) {
        this.selectedIds.add(id);
        this.listObservable.onNext(this.selectedIds);
    }

    public void addSelectedIds(Set<Number> ids) {
        this.selectedIds = ids;
        this.listObservable.onNext(this.selectedIds);
    }

    public void cleanSelectedIds() {
        this.selectedIds = new HashSet<>();
        this.listObservable.onNext(this.selectedIds);
    }

    public Set<Number> getSelectedIds() {
        return this.selectedIds;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public void removeSelectedId(Number id) {
        this.selectedIds.remove(id);
        this.listObservable.onNext(this.selectedIds);
    }

    public void removeSelectedIds(List<Number> ids) {
        this.selectedIds = this.selectedIds.stream().filter(id -> !ids.contains(id)).collect(Collectors.toSet());
        this.listObservable.onNext(this.selectedIds);
    }

    public void removeCode() {
        this.code = null;
        this.codeObservable.onNext(this.code);
    }

    public void removeName() {
        this.name = null;
        this.nameObservable.onNext(this.name);
    }

}