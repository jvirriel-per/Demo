package com.jvirriel.demo.frontend.core.views.navigator;

import com.pt.base.core.views.base.ViewUI;
import com.vaadin.ui.Component;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;

import java.util.HashMap;
import java.util.Map;

/**
 * BaseNavigator:
 * <p>
 * Creado por bpena el 23/04/2017.
 */
public class BaseNavigator {
    private Map<String, ? super ViewUI> views;
    private Layout componetContainer;
    private ViewUI currentView;

    public BaseNavigator(Layout componetContainer) {
        currentView = null;
        if (componetContainer == null)
            throw new RuntimeException("componentContainer is mandatory");
        this.views = new HashMap<>();
        this.componetContainer = componetContainer;
    }

    public Layout getComponetContainer() {
        return componetContainer;
    }

    public void addView(String viewName, ViewUI view) {
        if (viewName == null || viewName.isEmpty())
            throw new RuntimeException("No name is provided for baseNavigator view");

        if (view == null)
            throw new RuntimeException("No view is provided for baseNavigator");

        views.put(viewName, view);
    }

    public void navigateTo(String viewName) {
        if (viewName == null || viewName.isEmpty())
            throw new RuntimeException("No view name has been defined");

        ViewUI view = (ViewUI) views.get(viewName);
        if (view != null) {
            if (currentView != null)
                currentView.out();

            componetContainer.removeAllComponents();
            componetContainer.addComponent(view);
            currentView = view;

            BaseNavigatorEvent event = new BaseNavigatorEvent()
                    .setUriApp(viewName)
                    .setViewMode(view.getMode());

            ((ViewUI) views.get(viewName)).enter(event);
        }
    }

    public void cleanCurrent() {
        if (currentView != null)
            currentView.out();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (currentView != null)
            currentView.out();
    }
}
