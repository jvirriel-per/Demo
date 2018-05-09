package com.jvirriel.demo.frontend.core.views.containers;

import java.util.HashSet;
import java.util.Set;

/**
 * BaseContainerSelectionEvent:
 * <p>
 * Creado por bpena el 27/04/2017.
 */
public class BaseContainerSelectionEvent {
    private Set<Number> selectedIds;

    public BaseContainerSelectionEvent() {
        selectedIds = new HashSet<>();
    }

    public Set<Number> getSelectedIds() {
        return selectedIds;
    }

    public BaseContainerSelectionEvent setSelectedIds(Set<Number> selectedIds) {
        this.selectedIds = selectedIds;
        return this;
    }

    public BaseContainerSelectionEvent setSelectedId(Number selectedId) {
        this.selectedIds.add(selectedId);
        return this;
    }
}
