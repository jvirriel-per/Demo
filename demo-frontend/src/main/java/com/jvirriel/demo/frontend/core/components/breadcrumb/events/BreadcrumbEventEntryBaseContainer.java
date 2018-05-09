package com.jvirriel.demo.frontend.core.components.breadcrumb.events;

import com.jvirriel.demo.frontend.core.components.breadcrumb.BreadcrumbAction;

/**
 * BreadcrumbEventClean:
 * Evento para notificar que se eliminan todos los items del breadcrumb.
 */
public class BreadcrumbEventEntryBaseContainer extends AbstractBreadcrumbEvent {
    public BreadcrumbEventEntryBaseContainer() {
        super(BreadcrumbAction.CLEAN);
    }
}
