package com.jvirriel.demo.frontend.entitytype.views;

import com.jvirriel.demo.frontend.core.annotations.Functionality;
import com.jvirriel.demo.frontend.core.annotations.Navigation;
import com.jvirriel.demo.frontend.core.annotations.NavigationMode;
import com.jvirriel.demo.frontend.core.annotations.View;
import com.jvirriel.demo.frontend.core.views.ViewMode;
import com.jvirriel.demo.frontend.core.views.containers.BaseContainerUI;
import com.jvirriel.demo.frontend.core.views.navigator.NavigationType;
import com.jvirriel.demo.frontend.entitytype.constants.EntityTypeGeneralConstants;
import com.vaadin.navigator.ViewChangeListener;

import static com.jvirriel.demo.frontend.constant.GeneralConstants.*;
import static com.jvirriel.demo.frontend.core.annotations.NavigationMode.DETAIL;
import static com.jvirriel.demo.frontend.core.views.navigator.NavigationType.FILTER;

@Functionality(name = EntityTypeGeneralConstants.ENTITY_TYPE)
@Navigation(views = {
        @View(name = DETAIL_ID, target = EntityTypeDetailView.class, uri = DETAIL, mode = ViewMode.BROWSE,
                navMode = NavigationMode.DETAIL),
        @View(name = NEW_ID, target = EntityTypeDetailView.class, uri = NavigationType.CREATE, mode = ViewMode.EDIT,
                navMode = NavigationMode.NEW),
        @View(name = EDIT_ID, target = EntityTypeDetailView.class, uri = NavigationType.EDIT, mode = ViewMode.EDIT,
                navMode = NavigationMode.EDIT),
        @View(name = LIST_ID, target = EntityTypeListView.class, uri = NavigationType.LIST, mode = ViewMode.BROWSE,
                isPrincipal = true),
        @View(name = FILTER, target = EntityTypeFilterView.class, uri = NavigationType.FILTER, mode = ViewMode.EDIT)
})
public class EntityTypeContainerUI extends BaseContainerUI {
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        super.enter(viewChangeEvent);
    }
}