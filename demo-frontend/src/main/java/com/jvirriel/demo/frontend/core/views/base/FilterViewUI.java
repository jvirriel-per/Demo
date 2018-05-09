package com.jvirriel.demo.frontend.core.views.base;

import com.pt.base.core.annotations.Function;
import com.pt.base.core.components.menu.BaseMenuItem;
import com.pt.base.core.components.menu.BaseMenuType;
import com.pt.base.core.components.menu.events.BaseMenuEventSetMenuItems;
import com.pt.base.core.views.ViewMode;
import com.pt.base.core.views.containers.BaseContainerEventNavigate;
import com.pt.base.core.views.navigator.BaseNavigatorEvent;
import com.pt.util.search.SearchCondition;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.AbstractField;

import java.util.ArrayList;
import java.util.List;

import static com.pt.util.constant.GeneralConstants.*;

/**
 * FilterViewUI:
 *
 * Creado por bpena el 20/04/2017.
 */
public abstract class FilterViewUI<T> extends FormViewUI<T> {

    @Override
    protected void updateActionMenu(ViewMode viewMode) {
        if (ViewMode.EDIT.equals(viewMode)) {
            List<BaseMenuItem> list = new ArrayList<>();
            BaseMenuItem item;

            item = new BaseMenuItem()
                    .setCaption(SEARCH_LABEL)
                    .setUriIcon(new ExternalResource("/assets/home/img/search.svg"))
                    .setBaseMenuType(BaseMenuType.ACTION)
                    .setUriApp(ACCEPT_ID)
                    .setViewMode(ViewMode.BROWSE);
            list.add(item);

            item = new BaseMenuItem()
                    .setCaption(CLEAN_LABEL)
                    .setUriIcon(new ExternalResource("/assets/home/img/clean.svg"))
                    .setBaseMenuType(BaseMenuType.ACTION)
                    .setUriApp(CLEAN_ID)
                    .setViewMode(ViewMode.BROWSE);
            list.add(item);

            item = new BaseMenuItem()
                    .setCaption(CANCEL_LABEL)
                    .setUriIcon(new ExternalResource("/assets/home/img/cancel.svg"))
                    .setBaseMenuType(BaseMenuType.ACTION)
                    .setUriApp(CANCEL_ID)
                    .setViewMode(ViewMode.BROWSE);
            list.add(item);

            bus.post(new BaseMenuEventSetMenuItems(list));
        }
    }

    @Override
    public void enter(BaseNavigatorEvent event) {
        super.enter(event);
        updateActionMenu(event.getViewMode());
    }

    protected boolean preClean() {
        return true;
    }

    @Function(action = CLEAN_ID)
    public void onClean() {
        if (this.preClean()) {
            this.actionClean();
            this.postClean();
        }
    }

    protected boolean actionClean() {
        getAllComponent().forEach(component -> {
            if (component.isEnabled()) {
                if (component instanceof AbstractField)
                    ((AbstractField<String>)component).setValue(EMPTY_STRING);
            }
        });
        return true;
    }

    @Override
    protected boolean postCancel() {
        bus.post(new BaseContainerEventNavigate(LIST_ID));

        return super.postCancel();
    }

    protected boolean postClean() {
        return true;
    }

    protected abstract List<SearchCondition> generateFilterCondition();

}