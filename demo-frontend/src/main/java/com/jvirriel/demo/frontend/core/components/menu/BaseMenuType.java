package com.jvirriel.demo.frontend.core.components.menu;

/**
 * BaseMenuType:
 * <p>
 * Creado por bpena el 26/04/2017.
 */
public enum BaseMenuType {
    ACTION,
    NAVIGATION,
    LABEL;

    public static BaseMenuType parse(String menuType) {
        for (BaseMenuType type : BaseMenuType.values()) {
            if (type.equals(menuType))
                return type;
        }
        throw new BaseMenuException("No menu type is defined");
    }

    public Boolean equals(BaseMenuType baseMenuType) {
        return this.name().equals(baseMenuType.name());
    }

    public Boolean equals(String menuType) {
        return this.name().equals(menuType.toUpperCase());
    }
}
