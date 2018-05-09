package com.jvirriel.demo.frontend.components.custom.criteriabuilder;

public interface CriteriaItemFactory {
    CriteriaItem makeItem(CriteriaItem var1, CriteriaField var2, boolean var3, CriteriaCondition var4, String var5, boolean var6);

    CriteriaItem makeGroup(CriteriaItem var1, boolean var2, CriteriaCondition var3);
}