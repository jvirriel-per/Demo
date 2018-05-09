package com.jvirriel.demo.frontend.core.components.menu;

import com.pt.base.core.views.ViewMode;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;

/**
 * BaseMenuItem:
 * <p>
 * Creado por bpena el 24/04/2017.
 */
public class BaseMenuItem {
    private String caption;
    private Resource uriIcon;
    private String uriApp;
    private ViewMode viewMode;
    private BaseMenuType baseMenuType;
    private String target;

    public BaseMenuItem() {
        this.baseMenuType = BaseMenuType.NAVIGATION;
    }

    public String getCaption() {
        return caption;
    }

    public BaseMenuItem setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public Resource getUriIcon() {
        return uriIcon;
    }

    public BaseMenuItem setUriIcon(Resource uriIcon) {
        this.uriIcon = uriIcon;
        return this;
    }

    public String getUriApp() {
        return uriApp;
    }

    public BaseMenuItem setUriApp(String uriApp) {
        this.uriApp = uriApp;
        return this;
    }

    public ViewMode getViewMode() {
        return viewMode;
    }

    public BaseMenuItem setViewMode(ViewMode viewMode) {
        this.viewMode = viewMode;
        return this;
    }

    public BaseMenuItem setViewMode(String viewMode) {
        this.viewMode = ViewMode.valueOf(viewMode.toUpperCase());
        return this;
    }

    public BaseMenuType getBaseMenuType() {
        return baseMenuType;
    }

    public BaseMenuItem setBaseMenuType(BaseMenuType baseMenuType) {
        this.baseMenuType = baseMenuType;
        return this;
    }

    public BaseMenuItem setMenuType(String menuType) {
        this.baseMenuType = BaseMenuType.parse(menuType);
        return this;
    }

    public String getTarget() {
        return target;
    }

    public BaseMenuItem setTarget(String target) {
        this.target = target;
        return this;
    }
}
