package com.jvirriel.demo.frontend.core.components.menu;

import com.pt.components.ComponentFactory;
import com.pt.util.domain.user.UserData;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.Responsive;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Clase custom para armar menú de notificaciones y configuración de usuarios en el header de la app.
 * Created by ypetrilli on 07/02/2017.
 * Modified by fsalazar on 23/05/2017.
 *
 */
public class HeaderMenuComponent extends CssLayout {
    private JSONObject headerMenuObject;

    private MenuBar menuBar;

    private String uriIcon;
    private String caption;

    /**
     * Recibe el jsonObject para construir el menu.
     *
     * @param headerMenuObject, json con todos los keys necesarios para armar el menuBar
     */
    public HeaderMenuComponent(JSONObject headerMenuObject) {
        this.headerMenuObject = headerMenuObject;

        MenuBar menuBar = buildMenuBar();

        super.addComponent(menuBar);
        setStyleName("header-menu");
    }

    /**
     * Construye el menuBar para agregar los items correspondientes
     *
     * @return
     */
    private MenuBar buildMenuBar() {
        this.menuBar = ComponentFactory
                .menuBar()
                .setAutoOpen(false)
                .get();

        buildItem();

        return this.menuBar;
    }

    /**
     * Construye un nuevo menuItem con cada parametro extraido del jsonObject.
     */
    public void buildItem() {
        this.uriIcon = String.valueOf(this.headerMenuObject.get("uriIcon"));

        if ((this.headerMenuObject.get("label").equals("settings"))){
            this.caption = getFullName();
            this.caption = ""; // remove this line, if you want show fullname at userIcon
        } else {
            this.caption = "";
        }

        try {
            JSONArray headerMenuOptionsJsonArray = (JSONArray) this.headerMenuObject.get("items");

            MenuBar.MenuItem item = menuBar.addItem(this.caption, new ThemeResource(uriIcon.toLowerCase().concat(".svg")), null);
            item.setStyleName("user-name");
            headerMenuOptionsJsonArray.forEach(menu -> addMenuItem(item, (JSONObject) menu));

        } catch (Exception e) {
        }

    }

    /**
     * Agrega un nuevo item al menuBar
     *
     * @param item,       nuevo item a agregar
     * @param jsonObject, elementos provenientes del json que serán parte del item.
     */
    private void addMenuItem(MenuBar.MenuItem item, JSONObject jsonObject) {
        BaseMenuItem _item = new BaseMenuItem()
                .setCaption(String.valueOf(jsonObject.get("label")))
                .setUriIcon(VaadinIcons.valueOf(String.valueOf(jsonObject.get("uriIcon"))))
                .setUriApp(String.valueOf(jsonObject.get("uriApp")))
                .setTarget(String.valueOf(jsonObject.get("target")));

        item = item.addItemBefore(
                _item.getCaption(),
                _item.getUriIcon(),
                menuItem -> navigateTo(_item), item);
    }

    private void navigateTo(BaseMenuItem menuItem) {
        if (menuItem.getTarget().equals("_self")) {
                UI.getCurrent().getPage().open(menuItem.getUriApp(), menuItem.getTarget());
                BrowserWindowOpener opener = new BrowserWindowOpener(menuItem.getUriApp());
                opener.setWindowName(menuItem.getTarget());

        }
        else if (menuItem.getTarget().equals("_blank")) {

            UI.getCurrent().getPage().open(menuItem.getUriApp(), menuItem.getTarget());
            BrowserWindowOpener opener = new BrowserWindowOpener(menuItem.getUriApp());
            opener.setWindowName(menuItem.getTarget());

        }
        else if(menuItem.getTarget().equals("_internal")){
            UI.getCurrent().getNavigator().navigateTo(menuItem.getUriApp    ());
        }
    }

    public String getFullName (){

        ResponseEntity<UserData> responseEntity = null;
        try {
            HttpHeaders headersRequestForSIB = new HttpHeaders();
            headersRequestForSIB.set("userToken", UI.getCurrent().getSession().getAttribute("userToken").toString());
            headersRequestForSIB.set("appcod", UI.getCurrent().getSession().getAttribute("appCode").toString());
            headersRequestForSIB.set("appcodOrigin", UI.getCurrent().getSession().getAttribute("appCode").toString());

            HttpEntity<?> httpEntity = new HttpEntity<>(headersRequestForSIB);

            RestTemplate restTemplate = new RestTemplate();
             responseEntity = restTemplate.exchange(
                    UI.getCurrent().getSession().getAttribute("baseUrlBackend").toString()+"user/username",
                            HttpMethod.GET, httpEntity, UserData.class);

        } catch (final HttpClientErrorException e) {
            e.getStackTrace();
        }


        UI.getCurrent().getSession().setAttribute("userName", responseEntity.getBody().getUserName());

        return responseEntity.getBody().getFirstName()+ " " + responseEntity.getBody().getLastName();
    }

}