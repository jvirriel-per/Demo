package com.jvirriel.demo.frontend.core.views.navigator;

import com.pt.base.core.views.ViewMode;

/**
 * BaseNavigatorEvent:
 * <p>
 * Creado por bpena el 27/04/2017.
 */
public class BaseNavigatorEvent {
    private String uriApp;
    private ViewMode viewMode;

    public String getUriApp() {
        return uriApp;
    }

    public BaseNavigatorEvent setUriApp(String uriApp) {
        this.uriApp = uriApp;
        return this;
    }

    public ViewMode getViewMode() {
        return viewMode;
    }

    public BaseNavigatorEvent setViewMode(ViewMode viewMode) {
        this.viewMode = viewMode;
        return this;
    }
}
