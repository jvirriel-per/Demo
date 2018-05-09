package com.jvirriel.demo.frontend.core.views.navigator.events;

import com.pt.base.core.views.navigator.NavigatorAction;

/**
 * NavigatorEventNavigate:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public class NavigatorEventNavigate extends AbstractNavigatorEvent {
    public NavigatorEventNavigate(String target) {
        super(NavigatorAction.NAVIGATE_TO, target);
    }
}
