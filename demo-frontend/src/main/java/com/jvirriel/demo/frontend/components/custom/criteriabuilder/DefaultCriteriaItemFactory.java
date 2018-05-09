package com.jvirriel.demo.frontend.components.custom.criteriabuilder;

public class DefaultCriteriaItemFactory implements CriteriaItemFactory {
    public DefaultCriteriaItemFactory() {
    }

    public CriteriaItem makeItem(CriteriaItem parent, CriteriaField field, boolean flagNot, CriteriaCondition elementCondition, String value, boolean ignoreCase) {
        return new CriteriaItem(parent, field, flagNot, elementCondition, value, ignoreCase);
    }

    public CriteriaItem makeGroup(CriteriaItem parent, boolean flagNot, CriteriaCondition groupCondition) {
        return new CriteriaItem(parent, flagNot, groupCondition);
    }
}
