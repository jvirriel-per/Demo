package com.jvirriel.demo.frontend.components.custom.criteriabuilder;

import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.Item;
import com.vaadin.v7.data.Property;

public abstract class CompareString implements Container.Filter {
    private final Object propertyId;
    private final Operation operation;
    private final String value;
    private final boolean ignoreCase;

    public CompareString(Object propertyId, String value, Operation operation, boolean ignoreCase) {
        this.propertyId = propertyId;
        this.operation = operation;
        this.value = value;
        this.ignoreCase = ignoreCase;
    }

    @Override
    public boolean passesFilter(Object itemId, Item item) {
        final Property<?> p = item.getItemProperty(getPropertyId());
        if (null == p) {
            return false;
        }
        Object value1 = p.getValue();
        switch (getOperation()) {
            case EQUAL:
                return compareValue(value1) == 0;
            case NOT_EQUAL:
                return compareValue(value1) != 0;
            case GREATER:
                return compareValue(value1) > 0;
            case LESS:
                return compareValue(value1) < 0;
            case GREATER_OR_EQUAL:
                return compareValue(value1) >= 0;
            case LESS_OR_EQUAL:
                return compareValue(value1) <= 0;
        }
        // all cases should have been processed above
        return false;
    }

    protected int compareValue(Object value1) {
        return this.value == null ? (value1 == null ? 0 : 1) : (value1 == null ? -1 : (this.getIgnoreCase() ? -this.value.compareToIgnoreCase(value1.toString()) : -this.value.compareTo(value1.toString())));
    }

    public boolean appliesToProperty(Object propertyId) {
        return this.getPropertyId().equals(propertyId);
    }

    public Object getPropertyId() {
        return this.propertyId;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean getIgnoreCase() {
        return this.ignoreCase;
    }

    public static final class Equal extends CompareString {
        public Equal(Object propertyId, String value, boolean ignoreCase) {
            super(propertyId, value, Operation.EQUAL, ignoreCase);
        }
    }

    public static final class Greater extends CompareString {
        public Greater(Object propertyId, String value, boolean ignoreCase) {
            super(propertyId, value, Operation.GREATER, ignoreCase);
        }
    }

    public static final class GreaterOrEqual extends CompareString {
        public GreaterOrEqual(Object propertyId, String value, boolean ignoreCase) {
            super(propertyId, value, Operation.GREATER_OR_EQUAL, ignoreCase);
        }
    }

    public static final class Less extends CompareString {
        public Less(Object propertyId, String value, boolean ignoreCase) {
            super(propertyId, value, Operation.LESS, ignoreCase);
        }
    }

    public static final class LessOrEqual extends CompareString {
        public LessOrEqual(Object propertyId, String value, boolean ignoreCase) {
            super(propertyId, value, Operation.LESS_OR_EQUAL, ignoreCase);
        }
    }

    public static final class NotEqual extends CompareString {
        public NotEqual(Object propertyId, String value, boolean ignoreCase) {
            super(propertyId, value, Operation.NOT_EQUAL, ignoreCase);
        }
    }

    public static enum Operation {
        EQUAL,
        GREATER,
        LESS,
        GREATER_OR_EQUAL,
        LESS_OR_EQUAL,
        NOT_EQUAL;

        private Operation() {
        }
    }
}