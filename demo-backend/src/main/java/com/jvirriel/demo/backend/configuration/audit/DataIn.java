package com.jvirriel.demo.backend.configuration.audit;

import java.util.Map;

public class DataIn {
    private Map<String, String> headers;
    private Map<String, String[]> params;
    private String body;

    public DataIn() {
    }

    public DataIn(Map<String, String> headers, Map<String, String[]> params, String body) {
        this.headers = headers;
        this.params = params;
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String[]> getParams() {
        return params;
    }

    public void setParams(Map<String, String[]> params) {
        this.params = params;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
