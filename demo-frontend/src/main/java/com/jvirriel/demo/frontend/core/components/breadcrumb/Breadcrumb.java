package com.jvirriel.demo.frontend.core.components.breadcrumb;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.jvirriel.demo.frontend.core.components.breadcrumb.events.*;
import com.jvirriel.demo.frontend.core.views.ViewActionEvent;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.*;

public class Breadcrumb extends CssLayout {
    private static final String SEPARATOR = ">";
    private EventBus bus;
    private List<BreadcrumbItem> itemList;

    public Breadcrumb(String busName) {
        bus = (EventBus) UI.getCurrent().getSession().getAttribute(busName);
        bus.register(this);

        itemList = new ArrayList<>();

        addStyleName("base-breadcrumb");
    }

    @Subscribe
    private void addItem(BreadcrumbEventAdd event) {
        Boolean itemExist = itemList
                .stream()
                .map(BreadcrumbItem::getLabel)
                .anyMatch(event.getItem().getLabel()::equals);

        if (!itemExist) {
            event.getItem().setPos(itemList.size());
            itemList.add(event.getItem());
            updateView();
        }
    }

    private void removeItem(BreadcrumbItem item) {

    }

    @Subscribe
    private void removeLast(BreadcrumbEventRemoveLast event) {
        if (itemList.size() > 1) {
            itemList.remove(itemList.size() - 1);
            bus.post(new BreadcrumbEventUpdatedItemsList(itemList));
        }
    }

    @Subscribe
    private void gotoBack(BreadcrumbEventGoBack event) {
        this.onClickItem(itemList.get(itemList.size() - 2));
    }

    @Subscribe
    private void replaceLast(BreadcrumbEventReplaceLast event) {
        removeLast(new BreadcrumbEventRemoveLast());

        itemList.add(event.getItem());
        updateView();
    }

    @Subscribe
    private void clean(BreadcrumbEventClean event) {
        itemList = new ArrayList<>();
        updateView();
    }

    @Subscribe
    private void clear(BreadcrumbEventEntryBaseContainer event) {
        itemList.removeIf(breadcrumbItem -> breadcrumbItem.getPos() > 0);
    }

    private void updateView() {
        removeAllComponents();

        bus.post(new BreadcrumbEventUpdatedItemsList(itemList));

        if (itemList.size() > 1) {
            Label _separator = new Label();
            _separator.setIcon(VaadinIcons.ANGLE_RIGHT);
            _separator.addStyleName("breadcrumb-separator");
            addComponent(_separator);

            itemList.subList(1, itemList.size() - 1)
                    .forEach(item -> {
                        Button breadcrumbItem = new Button();
                        breadcrumbItem.setCaption(item.getLabel());
                        breadcrumbItem.addStyleName(ValoTheme.BUTTON_LINK);
                        breadcrumbItem.addStyleName(ValoTheme.LABEL_BOLD);
                        breadcrumbItem.addClickListener(clickEvent -> onClickItem(item));
                        addComponent(breadcrumbItem);
                        Label separator = new Label();
                        separator.setIcon(VaadinIcons.ANGLE_RIGHT);
                        separator.addStyleName("breadcrumb-separator");
                        addComponent(separator);
                    });

            Label label = new Label(itemList.get(itemList.size() - 1).getLabel());
            label.addStyleName("breadcrumb-final-item");
            addComponent(label);
        }
    }

    private void onClickItem(BreadcrumbItem item) {
        itemList.removeIf(breadcrumbItem -> breadcrumbItem.getPos() > item.getPos());
        updateView();

        if (Objects.isNull(item.getJson())) {
            UI.getCurrent().getNavigator().navigateTo(item.getAction());
        }
        else {
            Map<String, Object> map = new HashMap<>();
            map.put("items", item.getJson());
            map.put("label", item.getLabel());
            this.bus.post(new ViewActionEvent("subLobby").setParams(map));
        }
    }
}
