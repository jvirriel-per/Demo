package com.jvirriel.demo.frontend.core.views.navigator.events;

import com.pt.base.core.views.navigator.NavigatorAction;

import static com.pt.util.constant.GeneralConstants.EMPTY_STRING;

/**
 * AbstractNavigatorEvent:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public abstract class AbstractNavigatorEvent {
    private NavigatorAction action;
    private String target;

    public AbstractNavigatorEvent(NavigatorAction action, String target) {
        this.action = action;

        if (target == null)
            throw new RuntimeException(EMPTY_STRING);

        this.target = target;
    }

    public NavigatorAction getAction() {
        return action;
    }

    public AbstractNavigatorEvent setAction(NavigatorAction action) {
        this.action = action;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public AbstractNavigatorEvent setTarget(String target) {
        this.target = target;
        return this;
    }
}
