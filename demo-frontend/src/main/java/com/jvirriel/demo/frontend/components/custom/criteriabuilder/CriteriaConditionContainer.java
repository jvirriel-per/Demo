package com.jvirriel.demo.frontend.components.custom.criteriabuilder;


import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.util.IndexedContainer;

import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;


public class CriteriaConditionContainer {
    private ResourceBundle bundle = ResourceBundle.getBundle("com/pvv/criteriabuilder/criteriabuilder");
    private HashMap<String, CriteriaCondition> groupConditionMap;
    private HashMap<String, CriteriaCondition> elementConditionMap;
    private Container elementConditionContainer;
    private Container elementConditionWoStringContainer;

    public CriteriaConditionContainer() {
        this.createGroupCondition();
        this.createElementCondition();
    }

    public Collection<CriteriaCondition> getGroupConditionCollection() {
        return this.groupConditionMap.values();
    }

    public Collection<CriteriaCondition> getElementConditionCollection() {
        return this.elementConditionMap.values();
    }

    public CriteriaCondition getElementCondition(String key) {
        return (CriteriaCondition) this.elementConditionMap.get(key);
    }

    public CriteriaCondition getGroupCondition(String key) {
        return (CriteriaCondition) this.groupConditionMap.get(key);
    }

    private void createGroupCondition() {
        this.groupConditionMap = new HashMap();
        this.putGroupCondition("and");
        this.putGroupCondition("or");
    }

    private void createElementCondition() {
        this.elementConditionMap = new HashMap();
        this.putElementCondition("equal");
        this.putElementCondition("notEqual");
        this.putElementCondition("greater");
        this.putElementCondition("greaterOrEqual");
        this.putElementCondition("less");
        this.putElementCondition("lessOrEqual");
        this.putElementCondition("isNull");
        this.elementConditionWoStringContainer = new IndexedContainer(this.elementConditionMap.values());
        this.putElementCondition("startingWith");
        this.putElementCondition("containing");
        this.putElementCondition("like");
        this.elementConditionContainer = new IndexedContainer(this.elementConditionMap.values());
    }

    private void addToSet(HashMap<String, CriteriaCondition> set, String key) {
        set.put(key, new CriteriaCondition(key, this.bundle.getString(key)));
    }

    private void putGroupCondition(String key) {
        this.addToSet(this.groupConditionMap, key);
    }

    private void putElementCondition(String key) {
        this.addToSet(this.elementConditionMap, key);
    }

    public ResourceBundle getBundle() {
        return this.bundle;
    }

    public Container getElementConditionWoStringContainer() {
        return this.elementConditionWoStringContainer;
    }

    public Container getElementConditionContainer() {
        return this.elementConditionContainer;
    }
}