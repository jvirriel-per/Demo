package com.jvirriel.demo.frontend.core.components.lobby;

/**
 *
 * Created by fsalazar on 06/06/2017.
 */
public class LobbyActionEvent {

    private String json;

    public LobbyActionEvent(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }
}
