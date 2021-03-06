package com.jvirriel.search;

import java.util.Iterator;
import java.util.List;

import static com.jvirriel.constants.SearchConstants.SEMI_COLON_SEPARATOR;
import static java.util.Objects.nonNull;

public class ConditionParser {
    public static String parseRsqlCondition(List<SearchCondition> searchConditionList) {
        String rsqlCondition = "";

        if (nonNull(searchConditionList)) {
            Iterator<SearchCondition> searchConditionIterator = searchConditionList.iterator();

            while (searchConditionIterator.hasNext()) {
                SearchCondition searchCondition = searchConditionIterator.next();
                rsqlCondition = rsqlCondition
                        .concat(searchCondition.toString())
                        .concat(searchConditionIterator.hasNext() ? SEMI_COLON_SEPARATOR : "");
            }
        }

        return rsqlCondition;
    }
}
