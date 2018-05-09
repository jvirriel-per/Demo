package com.jvirriel.demo.frontend.core.components.lobby;

import com.google.common.eventbus.EventBus;
import com.pt.base.core.components.menu.BaseMenuType;
import com.pt.base.core.views.ViewActionEvent;
import com.pt.base.core.views.main.MainUIConstants;
import com.pt.components.ComponentFactory;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Base LobbyButton para el panel de aplicaciones.
 * Created by fsalazar on 06/02/2017.
 */
public class LobbyButtonComponent extends CssLayout {
    private Image imageIcon;
    private CssLayout labelContainer;
    private Label labelCaption;
    private Label labelVersion;
    private String uriIcon;
    private String label;
    private String version;
    private String uriApp;
    private String target;
    private String items;
    private BaseMenuType menuType;
    private EventBus bus;

    /**
     * Constructor del componente LobbyButton
     */
    public LobbyButtonComponent() {
        bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);
    }

    /**
     * Constructor del componente LobbyButton que recibe la uri del aplicativo.
     *
     * @param uriApp parámetro que contiene la uri del aplicativo.
     */
    public LobbyButtonComponent(String uriApp) {
        this.uriApp = uriApp;
    }

    /**
     * Constructor del componente LobbyButton que recibe la uri del aplicativo y el titulo.
     *
     * @param uriApp parámetro que contiene la uri del aplicativo.
     * @param label  parámetro que contiene el caption del aplicativo.
     */
    public LobbyButtonComponent(String uriApp, String label) {
        this(uriApp);
        this.label = label;
    }

    /**
     * Constructor del componente LobbyButton que recibe la uri del aplicativo, el titulo y la uri del icono.
     *
     * @param uriApp  parámetro que contiene la uri del aplicativo.
     * @param label   parámetro que contiene el caption del aplicativo.
     * @param uriIcon parámetro que contiene la uri del icono del aplicativo.
     */
    public LobbyButtonComponent(String uriApp, String label, String uriIcon) {
        this(uriApp, label);
        this.uriIcon = uriIcon;
    }

    /**
     * Constructor del componente LobbyButton que recibe la uri del aplicativo, el titulo, la uri del icono
     * y la version.
     *
     * @param uriApp  parámetro que contiene la uri del aplicativo.
     * @param label   parámetro que contiene el caption del aplicativo.
     * @param uriIcon parámetro que contiene la uri del icono del aplicativo.
     * @param version parámetro que contiene la version del aplicativo.
     */
    public LobbyButtonComponent(String uriApp, String label, String uriIcon, String version) {
        this(uriApp, label, uriIcon);
        this.version = version;
    }

    /**
     * Constructor del componente LobbyButton que recibe la uri del aplicativo, el titulo, la uri del icono,
     * la version y el target.
     *
     * @param uriApp     parámetro que contiene la uri del aplicativo.
     * @param label      parámetro que contiene el caption del aplicativo.
     * @param uriIcon    parámetro que contiene la uri del icono del aplicativo.
     * @param version    parámetro que contiene la version del aplicativo.
     * @param target parámetro que contiene el tipo de acción o comportamiento que tendra el LobbyButton.
     */
    public LobbyButtonComponent(String uriApp, String label, String uriIcon, String version, String target) {
        this(uriApp, label, uriIcon, version);
        this.target = target;

    }

    /**
     * Constructor del componente LobbyButton que recibe un JSONObject.
     *
     * @param lobbyBtn JSONObject que contiene la uri del aplicativo, el titulo, la uri del icono, la version
     *                 y el targetName.
     */
    public LobbyButtonComponent(JSONObject lobbyBtn) {
        this.uriApp = String.valueOf(lobbyBtn.get("uriApp"));
        this.label = String.valueOf(lobbyBtn.get("label"));
        this.uriIcon = String.valueOf(lobbyBtn.get("uriIcon"));
        this.version = String.valueOf(lobbyBtn.get("version"));
        this.target = String.valueOf(lobbyBtn.get("target"));
        this.menuType =  BaseMenuType.parse(String.valueOf(lobbyBtn.get("menuType")));
        if (this.menuType.equals(BaseMenuType.ACTION) && this.uriApp.equals("subLobby"))
            this.items = String.valueOf(lobbyBtn.get("items"));

        this.buildLobbyButton();
    }

    /**
     * @param title
     */
    public void setTittle(String title) {
        this.label = title;
    }

    /**
     * @param uriIcon
     */
    public void setUriIcon(String uriIcon) {
        this.uriIcon = uriIcon;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @param uriApp
     */
    public void setUriApp(String uriApp) {
        this.uriApp = uriApp;
    }

    /**
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Método creador del Componente LobbyButton.
     */
    public void buildLobbyButton() {

        this.addStyleName("lobby-button");

        imageIcon = new Image();
        Resource resource = new ExternalResource(uriIcon);
        imageIcon.setIcon(resource);
        imageIcon.setStyleName("lobby-button-icon");

        labelCaption = ComponentFactory
                .label()
                .setCaption(label)
                .setStyleName("label")
                .removeStyleName("a")
                .get();

        labelVersion = ComponentFactory
                .label()
                .setCaption(version)
                .setStyleName("subtitle")
                .removeStyleName("a")
                .get();

        labelContainer = ComponentFactory
                .cssLayout()
                .setStyleName("label-container")
                .addComponents(labelCaption, labelVersion)
                .get();

        this.addComponents(imageIcon, labelContainer);
        this.addLayoutClickListener(this::navigateTo);


        bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);
    }

    /**
     * Metodo encargado de la navegación que tendra cada LobbyButtonComponent en el lobby de aplicativos.
     */
    public void navigateTo (LayoutEvents.LayoutClickEvent event){

        if (!event.getButton().equals(MouseEventDetails.MouseButton.LEFT))
            return;
        if (this.menuType.equals(BaseMenuType.ACTION)) {
            Map<String, Object> map = new HashMap<>();
            map.put("items", this.items);
            map.put("label", this.label);
            this.bus.post(new ViewActionEvent(this.uriApp).setParams(map));
        }
        else if (this.target.equals("_blank")) {
            UI.getCurrent().getPage().open(this.uriApp, this.target);
            BrowserWindowOpener opener = new BrowserWindowOpener(this.uriApp);// "http://google.com"
            opener.setWindowName(this.target);// _new, _blank, _top, etc.
        }
        else if (this.target.equals("_self")) {
            UI.getCurrent().getNavigator().navigateTo(this.uriApp);
        }
    }

}