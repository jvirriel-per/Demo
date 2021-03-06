package com.jvirriel.demo.frontend.core.components.menu.events;

import com.pt.base.core.components.menu.BaseMenuAction;

/**
 * BaseMenuEvent:
 *
 * Creado por bpena el 21/04/2017.
 */
public class BaseMenuEvent {
    private BaseMenuAction action;

    public BaseMenuEvent(BaseMenuAction action) {
        this.action = action;
    }

    public BaseMenuAction getAction() {
        return action;
    }

    public void setAction(BaseMenuAction action) {
        this.action = action;
    }
}
