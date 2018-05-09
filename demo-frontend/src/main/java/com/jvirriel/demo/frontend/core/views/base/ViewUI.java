package com.jvirriel.demo.frontend.core.views.base;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.pt.base.core.annotations.Function;
import com.pt.base.core.annotations.NavigationMode;
import com.pt.base.core.components.breadcrumb.BreadcrumbItem;
import com.pt.base.core.components.breadcrumb.events.BreadcrumbEventAdd;
import com.pt.base.core.components.menu.BaseMenuItem;
import com.pt.base.core.components.menu.BaseMenuType;
import com.pt.base.core.components.menu.MenuService;
import com.pt.base.core.components.menu.events.BaseMenuEventSetMenuItems;
import com.pt.base.core.components.menu.events.BaseMenuEventShowPrincipal;
import com.pt.base.core.views.ViewActionEvent;
import com.pt.base.core.views.ViewMode;
import com.pt.base.core.views.containers.BaseContainerEventTitle;
import com.pt.base.core.views.main.MainUIConstants;
import com.pt.base.core.views.navigator.BaseNavigatorEvent;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.pt.base.core.views.navigator.NavigationType.LIST;
import static com.pt.util.constant.GeneralConstants.*;

/**
 * ViewUI:
 * <p>
 * Creado por bpena el 20/04/2017.
 */
public abstract class ViewUI extends BaseUI implements View {
    private ViewMode mode;
    private NavigationMode navMode;
    protected EventBus bus;
    protected String title;

    public ViewUI() {
        setSizeFull();
        setPrimaryStyleName("view-ui");

        mode = ViewMode.BROWSE;
        navMode = NavigationMode.DETAIL;
    }

    public ViewMode getMode() {
        return mode;
    }

    public void setMode(ViewMode mode) {
        this.mode = mode;
    }

    public NavigationMode getNavigationMode() {
        return this.navMode;
    }

    public void setNavigationMode(NavigationMode navigationMode) {
        this.navMode = navigationMode;
    }

    protected void updateActionMenu(ViewMode viewMode) {
        if (ViewMode.LIST.equals(viewMode)) {
            bus.post(new BaseMenuEventShowPrincipal());
        } else if (ViewMode.EDIT.equals(viewMode)) {
            List<BaseMenuItem> list = new ArrayList<>();
            BaseMenuItem item;

            item = new BaseMenuItem()
                    .setCaption("Guardar")
                    .setUriIcon(new ExternalResource("/assets/home/img/save.svg"))
                    .setBaseMenuType(BaseMenuType.ACTION)
                    .setUriApp(LIST)
                    .setViewMode(ViewMode.BROWSE);
            list.add(item);

            item = new BaseMenuItem()
                    .setCaption(CANCEL_LABEL)
                    .setUriIcon(new ExternalResource("/assets/home/img/cancel.svg"))
                    .setBaseMenuType(BaseMenuType.NAVIGATION)
                    .setUriApp(LIST)
                    .setViewMode(ViewMode.BROWSE);
            list.add(item);

            bus.post(new BaseMenuEventSetMenuItems(list));
        }
    }

    @Override
    protected void setReadOnly(boolean readOnly) {
        components.forEach(component -> {
            if (!(component instanceof Label))
                component.setEnabled(!readOnly);
        });
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && title.isEmpty())
            title = " ";

        this.title = title;
    }

    public void enter(BaseNavigatorEvent event) {
        bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);
        bus.register(this);

        if (event.getUriApp().equals("list")) {
            bus.post(new BreadcrumbEventAdd(new BreadcrumbItem("Listado", event.getUriApp())));
            bus.post(new BaseContainerEventTitle(this.title, false));
        } else if (event.getUriApp().equals("create")) {
            bus.post(new BreadcrumbEventAdd(new BreadcrumbItem("Nuevo", event.getUriApp())));
            bus.post(new BaseContainerEventTitle("Nuevo " + this.title));
        } else if (event.getUriApp().equals("filter")) {
            bus.post(new BreadcrumbEventAdd(new BreadcrumbItem("Buscar", event.getUriApp())));
            bus.post(new BaseContainerEventTitle("Buscar " + this.title));
        } else if (event.getUriApp().equals("detail")) {
            bus.post(new BreadcrumbEventAdd(new BreadcrumbItem("Detalle", event.getUriApp())));
            bus.post(new BaseContainerEventTitle("Detalle " + this.title));
        } else if (event.getUriApp().equals("edit")) {
            bus.post(new BreadcrumbEventAdd(new BreadcrumbItem("Editar", event.getUriApp())));
            bus.post(new BaseContainerEventTitle("Editar " + this.title));
        }

        this.setReadOnly(event.getViewMode().equals(ViewMode.BROWSE));

        if (this.getNavigationMode().equals(NavigationMode.NEW)) {
            this.onNew();
        } else if (this.getNavigationMode().equals(NavigationMode.EDIT)) {
            this.onEdit();
        } else if (this.getNavigationMode().equals(NavigationMode.DETAIL)) {
            this.onEdit();
        }

        MenuService.getInstance().setUriApp(event.getUriApp());

        updateActionMenu(event.getViewMode());
    }

    public void out() {
        try {
            bus.unregister(this);
        } catch (Exception e) {

        }
    }

    @Subscribe
    public void launchAction(ViewActionEvent event) {
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            Function function = method.getAnnotation(Function.class);
            if (function != null && function.action().equals(event.getAction())) {
                try {
                    if (Objects.isNull(event.getParams()))
                        method.invoke(this);
                    else
                        method.invoke(this, event.getParams());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}