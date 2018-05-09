package com.jvirriel.demo.frontend.entitystatus.views;

import com.jvirriel.demo.frontend.core.annotations.Functionality;
import com.jvirriel.demo.frontend.core.annotations.Navigation;
import com.jvirriel.demo.frontend.core.annotations.NavigationMode;
import com.jvirriel.demo.frontend.core.annotations.View;
import com.jvirriel.demo.frontend.core.views.ViewMode;
import com.jvirriel.demo.frontend.core.views.containers.BaseContainerUI;
import com.jvirriel.demo.frontend.core.views.navigator.NavigationType;
import com.vaadin.navigator.ViewChangeListener;

import static com.jvirriel.constants.GeneralConstants.*;
import static com.jvirriel.demo.frontend.entitystatus.constants.EntityStatusGeneralConstants.ENTITY_STATUS;

/**
 * Container principal definido para la funcionalidad entityStatus con todas las vistas definidas de acuerdo
 * al requerimiento.
 */
@Functionality(name = ENTITY_STATUS)
@Navigation(views = {
        @View(name = DETAIL_ID, target = EntityStatusDetailView.class, uri = NavigationType.DETAIL, mode = ViewMode.BROWSE,
                navMode = NavigationMode.DETAIL),
        @View(name = NEW_ID, target = EntityStatusDetailView.class, uri = NavigationType.CREATE, mode = ViewMode.EDIT,
                navMode = NavigationMode.NEW),
        @View(name = EDIT_ID, target = EntityStatusDetailView.class, uri = NavigationType.EDIT, mode = ViewMode.EDIT,
                navMode = NavigationMode.EDIT),
        @View(name = LIST_ID, target = EntityStatusListView.class, uri = NavigationType.LIST, mode = ViewMode.BROWSE,
                isPrincipal = true),
        @View(name = FILTER_ID, target = EntityStatusFilterView.class, uri = NavigationType.FILTER, mode = ViewMode.EDIT)
})
public class EntityStatusContainerUI extends BaseContainerUI {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        super.enter(viewChangeEvent);
    }
}