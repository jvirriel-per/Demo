package com.jvirriel.demo.frontend.core.views.base;


import com.google.common.eventbus.Subscribe;
import com.pt.base.core.views.ViewMode;
import com.pt.base.core.views.containers.BaseContainerEventNavigate;
import com.pt.base.core.views.containers.BaseContainerSelectionEvent;
import com.pt.base.core.views.navigator.BaseNavigatorEvent;
import com.vaadin.data.Binder;
import com.vaadin.shared.Registration;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import rx.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.pt.util.constant.GeneralConstants.LIST_ID;

/**
 * FormViewUI:
 * <p>
 * Creado por bpena el 20/04/2017.
 */
public abstract class FormViewUI<T> extends ViewUI {
    protected CssLayout container;
    protected Binder<T> binder;
    protected List<Number> selectedIds;

    protected static Subscription selectedIdsSubscription;

    protected abstract void setBinder();

    public FormViewUI() {
        super.setSizeFull();

        setBinder();
        buildForm();

        selectedIdsSubscription = GridService
                .getInstance()
                .getListObservable()
                .subscribe(this::updateSelected);
    }

    protected void buildForm() {
        container = new CssLayout();
        container.addStyleName("form");

        super.addComponent(container);

        fillForm();
    }

    protected void fillForm() {

    }

    /**
     * Actualiza la lista de valores seleccionados en la grid.
     *
     * @param ids, set de ids seleccionados.
     */
    protected void updateSelected(Set<Number> ids) {
        List<Number> list = new ArrayList<>();
        if (ids != null) {
            ids.forEach(list::add);
            this.selectedIds = list;
        }
    }

    @Override
    public void addComponent(Component c) {
        container.addComponent(c);
    }

    @Override
    public void addComponent(Component c, int index) {
        container.addComponent(c, index);
    }

    @Override
    public void addComponentAsFirst(Component c) {
        container.addComponentAsFirst(c);
    }

    @Override
    public void addComponents(Component... components) {
        container.addComponents(components);
    }

    @Override
    public Registration addComponentAttachListener(ComponentAttachListener listener) {
        return container.addComponentAttachListener(listener);
    }

    @Override
    public Registration addComponentDetachListener(ComponentDetachListener listener) {
        return container.addComponentDetachListener(listener);
    }

    public List<Component> getAllComponent() {
        List<Component> list = new ArrayList<>();
        container.forEach(component -> list.add(component));
        return list;
    }

    @Subscribe
    protected void selectionEventHandler(BaseContainerSelectionEvent event) {
    }

    /**
     * Permite definir que ocurrirá en la ventana luego de ejecutar la acción de guardar.
     *
     * @return super.postSave()
     */
    @Override
    protected boolean postSave() {
        GridService.getInstance().removeSelectedIds(this.selectedIds);
        bus.post(new BaseContainerEventNavigate(LIST_ID));
        return super.postSave();
    }

    /**
     * Permite agregar acción al botón cancelar.
     *
     * @return super.actionCancel()
     */
    @Override
    protected boolean actionCancel() {
        bus.post(new BaseContainerEventNavigate(LIST_ID));
        return super.actionCancel();
    }

    @Override
    public void enter(BaseNavigatorEvent event) {
        super.enter(event);
    }

    @Override
    public void out() {
        super.out();
        if (selectedIdsSubscription != null)
            selectedIdsSubscription.unsubscribe();
    }
}