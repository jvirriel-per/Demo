package com.jvirriel.demo.frontend.core.components.lobby;

import com.google.common.eventbus.EventBus;
import com.pt.base.core.views.main.MainUIConstants;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * Base LobbyContainer para el panel de aplicaciones.
 * Created by fsalazar on 13/02/2017.
 */
public class LobbyContainer extends CssLayout {

    protected String json = "";
    private EventBus bus;

    /**
     * Constructor del Lobby de aplicativos.
     */
    public LobbyContainer() {
        setStyles();
    }

    public void setJson(LobbyActionEvent event){

        this.json = event.getJson();
        this.buildLobbyContainer();
    }

    /**
     * Constructor del Lobby de aplicativos que recibe un Json.
     *
     * @param json Json contenedor de las listas que construyen los componentes del Lobby de aplicativos.
     */
    public LobbyContainer(String json) {
        setStyles();
        this.json = json;
    }

    protected void setStyles() {
        super.addStyleName("lobby-container");
    }

    /**
     * Metodo contructor del LobbyContainer
     */
    public void buildLobbyContainer() {
        super.removeAllComponents();
        bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(json);

            JSONArray jsonArray = (JSONArray) obj;

            for (Object lobbyButtonsObject : jsonArray) {
                JSONObject jsonObject = (JSONObject) lobbyButtonsObject;
                super.addComponent(new LobbyButtonContainer(jsonObject));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}