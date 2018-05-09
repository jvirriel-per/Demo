package com.jvirriel.demo.frontend.core.components.lobby;

import com.pt.components.ComponentFactory;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Base LobbyButtonContainer para el panel de aplicaciones.
 * Created by fsalazar on 09/02/2017.
 */

public class LobbyButtonContainer extends CssLayout {
    private CssLayout layoutContainer;
    private CssLayout buttonContainer;
    private Label labelTitle;
    private String title;
    private List<Component> lobbyButtonList;
    private JSONObject lobbyButtonsObject;


    /**
     * Constructor del contenedor de LobbyButtons que recibe un titulo.
     *
     * @param title parámetro para el titulo del contenedor de LobbyButtons.
     */
    public LobbyButtonContainer(String title) {
        this.title = title;
    }

    /**
     * Constructor del contenedor de LobbyButtons que recibe un titulo y una lista de tipo LobbyButtons..
     *
     * @param title           parámetro para el titulo del contenedor de LobbyButtons.
     * @param lobbyButtonList parámetro que contiene la lista de componentes de tipo LobbyButtons.
     */
    public LobbyButtonContainer(String title, List<Component> lobbyButtonList) {
        this(title);
        this.lobbyButtonList = lobbyButtonList;
    }

    /**
     * Constructor del contenedor de LobbyButtons que recibe JSONObject.
     *
     * @param lobbyButtonsObject Objeto de tipo Json que contiene titulo y lista de LobbyButtons.
     */
    public LobbyButtonContainer(JSONObject lobbyButtonsObject) {
        this.lobbyButtonsObject = lobbyButtonsObject;
        this.buildLobbyButtonContainer();
    }

    /**
     * Método encargado de la construcción del contenedor de LobbyButtons.
     */
    public void buildLobbyButtonContainer() {

        super.addStyleName("lobby-button-container");
        this.title = String.valueOf(this.lobbyButtonsObject.get("label"));
        JSONArray lobbyButtonsJsonArray = (JSONArray) this.lobbyButtonsObject.get("items");

        labelTitle = ComponentFactory
                .label(title)
                .addStyleName(ValoTheme.LABEL_H4)
                .addStyleName(ValoTheme.LABEL_BOLD)
                .removeStyleName("a")
                .get();

        layoutContainer = ComponentFactory
                .cssLayout()
                .setStyleName("lobby-button-container-layout")
                .get();

        buttonContainer = ComponentFactory
                .cssLayout()
                .setStyleName("button-container")
                .get();

        lobbyButtonsJsonArray.forEach(lobbyBtn ->
                buttonContainer.addComponent(new LobbyButtonComponent((JSONObject) lobbyBtn)));

        layoutContainer.addComponent(labelTitle);
        layoutContainer.addComponent(buttonContainer);

        addComponent(layoutContainer);
    }

}