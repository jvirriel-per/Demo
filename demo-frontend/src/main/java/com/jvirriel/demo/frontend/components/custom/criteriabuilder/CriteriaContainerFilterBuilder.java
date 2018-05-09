package com.jvirriel.demo.frontend.components.custom.criteriabuilder;

import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.util.ContainerHierarchicalWrapper;
import com.vaadin.v7.data.util.filter.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CriteriaContainerFilterBuilder {
    public CriteriaContainerFilterBuilder() {
    }

    public static Container.Filter getFilter(CriteriaBuilder criteriaBuilder) {
        return getFilter(criteriaBuilder.getItemContainerWrapper());
    }

    public static Container.Filter getFilter(ContainerHierarchicalWrapper itemContainerWrapper) {
        return getGroupFilter(itemContainerWrapper, (CriteriaItem)itemContainerWrapper.rootItemIds().iterator().next());
    }

    public static Container.Filter getGroupFilter(ContainerHierarchicalWrapper itemContainerWrapper, CriteriaItem item) {
        Collection children = itemContainerWrapper.getChildren(item);
        if(children == null) {
            return null;
        } else {
            ArrayList filters = new ArrayList();
            Iterator groupFilter = children.iterator();

            while(groupFilter.hasNext()) {
                CriteriaItem filterArray = (CriteriaItem)groupFilter.next();
                if(filterArray.isFlagGroup()) {
                    addNotNullFilter(filters, getGroupFilter(itemContainerWrapper, filterArray));
                } else {
                    addNotNullFilter(filters, getElementFilter(itemContainerWrapper, filterArray));
                }
            }

            Container.Filter[] filterArray1 = (Container.Filter[])filters.toArray(new Container.Filter[filters.size()]);
            Object groupFilter1;
            if(item.getGroupCondition().getName().equalsIgnoreCase("and")) {
                groupFilter1 = new And(filterArray1);
            } else {
                groupFilter1 = new Or(filterArray1);
            }

            if(item.isFlagNot()) {
                return new Not((Container.Filter)groupFilter1);
            } else {
                return (Container.Filter)groupFilter1;
            }
        }
    }

    public static Container.Filter getElementFilter(ContainerHierarchicalWrapper itemContainerWrapper, CriteriaItem item){
        if (item.getField() == null || item.getElementCondition() == null)
            return null;
        Container.Filter filter = null;
        String field = item.getField().getName();
        String stringValue = item.getValue().toString();
        String oper = item.getElementCondition().getName();
        CriteriaField.ClassField fieldClass = item.getField().getClassField();
        if (oper.equals("isNull")) {
            filter = new IsNull(field);
        }
        else if (fieldClass== CriteriaField.ClassField.STRING){
            if (oper.equals("like")){
                filter = new Like(field, stringValue, !item.isIgnoreCase());
            }
            else if	(oper.equals("startingWith")) {
                filter =new SimpleStringFilter(field, stringValue, item.isIgnoreCase(), true);
            }
            else if (oper.equals("containing"))
                filter =new SimpleStringFilter(field, stringValue, item.isIgnoreCase(), false);
            else if (oper.equals("equal"))
                filter = new CompareString.Equal(field,stringValue, item.isIgnoreCase());
            else if (oper.equals("greater"))
                filter = new CompareString.Greater(field,stringValue, item.isIgnoreCase());
            else if (oper.equals("less"))
                filter = new CompareString.Less(field,stringValue, item.isIgnoreCase());
            else if (oper.equals("greaterOrEqual"))
                filter = new CompareString.GreaterOrEqual(field,stringValue, item.isIgnoreCase());
            else if (oper.equals("lessOrEqual"))
                filter = new CompareString.LessOrEqual(field,stringValue, item.isIgnoreCase());
            else if (oper.equals("notEqual"))
                filter = new CompareString.NotEqual(field,stringValue, item.isIgnoreCase());
        }
        else {
            Object value=stringValue;
            switch (fieldClass){
                case INTEGER:
                    value = new Integer(stringValue);
                    break;
                case FLOAT:
                    value = new Double(stringValue);
                    break;
                case DATE:
                    try {
                        value = SimpleDateFormat.getDateInstance().parse(stringValue);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
            }

            if (oper.equals("equal"))
                filter = new Compare.Equal(field,value);
            else if (oper.equals("greater"))
                filter = new Compare.Greater(field,value);
            else if (oper.equals("less"))
                filter = new Compare.Less(field,value);
            else if (oper.equals("greaterOrEqual"))
                filter = new Compare.GreaterOrEqual(field,value);
            else if (oper.equals("lessOrEqual"))
                filter = new Compare.LessOrEqual(field,value);
            else if (oper.equals("notEqual"))
                filter = new Not(new Compare.Equal(field,value));
        }


        if (filter!=null && item.isFlagNot())
            filter = new Not(filter);

        return filter;

    }

    private static void addNotNullFilter(Collection<Container.Filter> filters, Container.Filter filter) {
        if(filter != null) {
            filters.add(filter);
        }

    }
}
