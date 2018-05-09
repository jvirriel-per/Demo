package com.jvirriel.demo.frontend.core.components.menu;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.MenuBar;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Base para el Menu de Acciones.
 * Created by fsalazar on 16/02/2017.
 */
public class ActionMenuComponent extends MenuBar {
    private String caption;
    private VaadinIcons uriIcon;

    private JSONObject actionMenuJson;

    /**
     * Constructor para el Menu de Acciones.
     */
    public ActionMenuComponent() {
        super.setStyleName("action-menu");
    }

    /**
     * Constructor para el Menu de Acciones que recibe un titulo.
     *
     * @param caption par�metro para el titulo del Menu de Acciones.
     */
    public ActionMenuComponent(String caption) {
        this.caption = caption;
    }

    /**
     * Constructor para el Menu de Acciones que recibe un titulo y la uri del icono.
     *
     * @param caption par�metro para el titulo del Menu de Acciones.
     * @param uriIcon par�metro para la uri del icono del Menu de Acciones.
     */
    public ActionMenuComponent(String caption, VaadinIcons uriIcon) {
        this.caption = caption;
        this.uriIcon = uriIcon;
    }

    /**
     * Constructor para el Menu de Acciones que recibe un titulo y la uri del icono.
     *
     * @param actionMenuJson par�metro para que contiene el Json que forma el Menu de Acciones.
     */
    public ActionMenuComponent(JSONObject actionMenuJson) {
        this.actionMenuJson = actionMenuJson;
    }


    /**
     * Metodo encargado de construir el Menu de Acciones a partir del Json que recibe.
     * <p>
     * param actionMenuJson par�metro para que contiene el Json que forma el Menu de Acciones.
     */
    public void buildActionMenu(String jsonPath) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(jsonPath));
            JSONArray jsonArray = (JSONArray) obj;

            for (Object actionMenuObject : jsonArray) {
                actionMenuJson = (JSONObject) actionMenuObject;

                JSONArray actionMenuJsonArray = (JSONArray) actionMenuJson.get("actionMenu");

                actionMenuJsonArray.forEach((Object actionMenuItem) -> {
                    super.addItem(
                            String.valueOf(((JSONObject) actionMenuItem).get("label")),
                            VaadinIcons.valueOf((String) ((JSONObject) actionMenuItem).get("uriIcon")),
                            menuItem -> action(menuItem, (String) ((JSONObject) actionMenuItem).get("uriApp")));
                });
            }


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }





    protected void action(MenuItem menuItem, String command) {

    }

}