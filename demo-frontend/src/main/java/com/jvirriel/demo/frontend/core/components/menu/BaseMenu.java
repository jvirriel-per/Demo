package com.jvirriel.demo.frontend.core.components.menu;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.pt.base.core.components.menu.events.BaseMenuEventSetMenuItems;
import com.pt.base.core.components.menu.events.BaseMenuEventShowPrincipal;
import com.pt.base.core.views.ViewActionEvent;
import com.pt.base.core.views.containers.BaseContainerEventNavigate;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import rx.Subscription;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * BaseMenu:
 *
 * Creado por bpena el 21/04/2017.
 */
public class BaseMenu extends MenuBar {
    private EventBus bus;
    private List<BaseMenuItem> itemList;
    private String newUriApp;
    protected static Subscription menuSubscription;

    public BaseMenu(String busName) {
        bus = (EventBus) UI.getCurrent().getSession().getAttribute(busName);
        bus.register(this);

        itemList = new ArrayList<>();

        addStyleName("action-menu");

        if (menuSubscription != null)
            menuSubscription.unsubscribe();
        menuSubscription = MenuService.getInstance().getMenuObservable().subscribe(this::updateUriApp);
    }

    protected void updateUriApp(String uriApp){
        this.newUriApp = uriApp;
        buildActionMenu(itemList);
    }

    protected void buildActionMenu(List<BaseMenuItem> itemList) {
        this.removeItems();


            itemList.forEach(item -> {
                if (Objects.nonNull(this.newUriApp) && !this.newUriApp.equals(item.getUriApp())){
                    this.addItem(
                            item.getCaption(),
                            item.getUriIcon(),
                            menuItem -> action(item));
                }
            });
    }

    private void action(BaseMenuItem item) {
        if (BaseMenuType.ACTION.equals(item.getBaseMenuType())) {
            bus.post(new ViewActionEvent(item.getUriApp()));
        }
        else if (BaseMenuType.NAVIGATION.equals(item.getBaseMenuType())) {
              bus.post(new BaseContainerEventNavigate(item.getUriApp()));
        }
    }

    public void setActionMenuItem(String jsonPath) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(jsonPath));
            JSONArray jsonArray = (JSONArray) obj;

            jsonArray.forEach(actionMenuObject -> {
                JSONObject actionMenuJson = (JSONObject) actionMenuObject;
                JSONArray actionMenuJsonArray = (JSONArray) actionMenuJson.get("baseMenu");

                actionMenuJsonArray.forEach(actionMenuItem -> this.itemList.add(
                    new BaseMenuItem()
                        .setCaption(String.valueOf(((JSONObject) actionMenuItem).get("caption")))
                        .setUriIcon(VaadinIcons.valueOf((String) ((JSONObject) actionMenuItem).get("uriIcon")))
                        .setUriApp((String) ((JSONObject) actionMenuItem).get("uriApp"))
                        .setTarget((String) ((JSONObject) actionMenuItem).get("targetName"))
                ));
            });

            this.buildActionMenu(this.itemList);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    private void setAlternativeItemList(BaseMenuEventSetMenuItems event) {
        this.buildActionMenu(event.getItemList());
    }

    @Subscribe
    private void setPrincipalItemList(BaseMenuEventShowPrincipal event) {
        this.buildActionMenu(this.itemList);
    }

    public void setActionMenuItem(List<BaseMenuItem> itemList) {
        this.itemList = itemList;
        this.buildActionMenu(this.itemList);
    }
}