package com.jvirriel.demo.frontend.core.views.navigator.events;

import com.pt.base.core.views.navigator.NavigatorAction;
import com.vaadin.navigator.View;

import static com.pt.util.constant.GeneralConstants.EMPTY_STRING;

/**
 * NavigatorEventAdd:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public class NavigatorEventAdd extends AbstractNavigatorEvent {
    private Class<? extends View> clazz;

    public NavigatorEventAdd(String target, Class<? extends View> clazz) {
        super(NavigatorAction.ADD_TARGET, target);

        if (clazz == null)
            throw new RuntimeException(EMPTY_STRING);

        this.clazz = clazz;
    }

    public Class<? extends View> getClazz() {
        return clazz;
    }

    public NavigatorEventAdd setClazz(Class<? extends View> clazz) {
        this.clazz = clazz;
        return this;
    }
}
