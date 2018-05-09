package com.jvirriel.demo.frontend.core.components.menu.mainmenu;


import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.pt.base.core.components.breadcrumb.events.BreadcrumbEventUpdatedItemsList;
import com.pt.components.ComponentFactory;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

/**
 * Base para el Menu desplegable principal de los aplicativos.
 * Created by fsalazar on 01/03/2017.
 */
public class MainMenuComponent extends CssLayout {

    private JSONObject mainMenuJson;
    private EventBus bus;
    private String menuName;
    MenuBar menu;
    private MenuBar.MenuItem main;

    public MainMenuComponent(String busName) {
        bus = (EventBus) UI.getCurrent().getSession().getAttribute(busName);
        bus.register(this);

        this.menuName = "";

        setStyleName("main-menu");

        menu = ComponentFactory.menuBar().get();
        menu.setAutoOpen(false);
    }

    @Subscribe
    protected void updateMenuName(BreadcrumbEventUpdatedItemsList event) {
        String mName = event.getItemList().size() > 0 ? event.getItemList().get(0).getLabel() : "";
        if (mName.compareTo(this.menuName) != 0) {
            this.menuName = mName;
            this.main.setText(this.menuName);
        }
    }

    public void buildMenu(){
        super.addComponent(fillMainMenu());
    }

    protected MenuBar fillMainMenu() {
        JSONParser parser = new JSONParser();

        try {
            Object obj = null;
            try {
                obj = parser.parse(getJson());
                JSONArray jsonArray = (JSONArray) obj;

                main = menu.addItem(this.menuName, null, null);
                main.setStyleName("main-menu");

                for (Object mainMenuObject : jsonArray) {
                    mainMenuJson = (JSONObject) mainMenuObject;
                    MenuBar.MenuItem menuItem;
                    JSONArray subMenuJsonArray = (JSONArray) mainMenuJson.get("items");
                    if (subMenuJsonArray.size() > 0) {
                        menuItem = main.addItem(String.valueOf(this.mainMenuJson.get("label")), null, null);

                        subMenuJsonArray.forEach((Object subMenuArray) -> {
                            menuItem.addItem(
                                    String.valueOf(((JSONObject) subMenuArray).get("label")),
                                    null,
                                    menuItem1 -> onAction(String.valueOf(((JSONObject) subMenuArray).get("uriApp"))));
                        });
                    }
                    else {
                        menuItem = main.addItem(
                                String.valueOf(this.mainMenuJson.get("label")),
                                null,
                                menuItem1 -> onAction(String.valueOf(this.mainMenuJson.get("uriApp"))));
                    }

                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return menu;
    }

    public String getJson () throws URISyntaxException {

        ResponseEntity<String> responseEntity = null;

        try {
            HttpHeaders headersRequestForSIB = new HttpHeaders();
            headersRequestForSIB.set("userToken", UI.getCurrent().getSession().getAttribute("userToken").toString());
            headersRequestForSIB.set("level", "-1");
            headersRequestForSIB.set("appcod", UI.getCurrent().getSession().getAttribute("appCodeSecurityMain").toString());
            headersRequestForSIB.set("type", "");
            headersRequestForSIB.set("appcodOrigin",  UI.getCurrent().getSession().getAttribute("appCode").toString());

            HttpEntity<?> httpEntity = new HttpEntity<>(headersRequestForSIB);

            RestTemplate restTemplate = new RestTemplate();
            responseEntity = restTemplate.exchange(
                    UI.getCurrent().getSession().getAttribute("baseUrlBackend").toString()+"menu/main", HttpMethod.GET, httpEntity, String.class);


        }
        catch (final HttpClientErrorException e) {
            e.getStackTrace();
        }


        return responseEntity.getBody();
    }



    protected void onAction(String action) {
            UI.getCurrent().getNavigator().navigateTo(action);
//        UI.getCurrent().getPage().open(action, "_blank");
//        BrowserWindowOpener opener = new BrowserWindowOpener(action);// "http://google.com"
//        opener.setWindowName("_blank");// _new, _blank, _top, etc.
    }
}