package com.jvirriel.demo.frontend.core.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ViewActionEvent:
 * <p>
 * Creado por bpena el 26/04/2017.
 */
public class ViewActionEvent {
    private String action;
    private Map<String, Object> params;

    public ViewActionEvent(String action) {
        this.action = action;
    }

    public ViewActionEvent(String action, Map<String, Object> params) {
        this.action = action;
        this.params = params;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public ViewActionEvent setParams(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    public ViewActionEvent addParams(String key, Object value) {
        if (Objects.isNull(this.params))
            this.params = new HashMap<>();

        this.params.put(key, value);
        return this;
    }

    public String getAction() {
        return action;
    }
}
