package com.jvirriel.demo.backend.configuration.audit;

import com.google.gson.Gson;
import com.pt.core.audit.DataIn;
import com.pt.core.audit.Document;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class RequestInfoExtractor {
    private static RequestInfoExtractor instance;
    private static final String USERNAME_HEADER = "username";
    private com.pt.core.audit.Document document;

    private RequestInfoExtractor() {
        document = new com.pt.core.audit.Document();
    }

    /**
     * Genera documento para solicitud
     * @param request solicitud recibida
     * @param appCode codigo de aplicacion
     * @return el documento con InputData: headers, params y body.
     */
    public static com.pt.core.audit.Document getDocument(HttpServletRequest request, String appCode) {
        instance = new RequestInfoExtractor();
        instance.extractDataIn(request);
        instance.setUpDocument(request, "Success", appCode);
        return instance.getDocument();
    }

    /**
     * Genera documento para respuesta
     * @param request solicitud recibida
     * @param appCode codigo de aplicacion
     * @param responseData data de respuesta a la solicitud
     * @return el documento con OutputData: responseData.toString()
     */
    public static com.pt.core.audit.Document getDocument(HttpServletRequest request, String appCode, Object responseData) {
        instance = new RequestInfoExtractor();
        instance.document.setOutputData(responseData.toString());
        instance.setUpDocument(request, "Success", appCode);
        return instance.getDocument();
    }

    /**
     * Genera documento para estatus de error
     * @param statusCode Numero de estatus http
     * @param message Mensaje de error
     * @param request solicitud recibida
     * @param appCode codigo de aplicacion
     * @return Documento con ErrorData: codigo de error y mensaje.
     */
    public static com.pt.core.audit.Document getDocument(int statusCode, String message, HttpServletRequest request, String appCode) {
        instance = new RequestInfoExtractor();
        instance.setDocumentError(statusCode, message);
        instance.setUpDocument(request, "Failed", appCode);
        return instance.getDocument();
    }

    private void setUpDocument(HttpServletRequest request, String status, String appCode) {

        List<String> group = Arrays.asList(request.getRequestURI().split("/"));
        StringBuilder subGroup = new StringBuilder();

        for (int i = 2; i < group.size(); i++) {
            subGroup.append(group.get(i));
            if (i+1 < group.size()) {
                subGroup.append(".");
            }
        }

        document.setType(request.getMethod());
        document.setStatus(status);
        document.setGroup(group.get(1));
        document.setSubGroup(subGroup.toString());
        document.setUser(request.getHeader(USERNAME_HEADER));
        document.setAppCode(appCode);
    }

    private void setDocumentError(int statusCode, String message) {
        document.setErrorData(statusCode+": "+message);
    }

    private void extractDataIn(HttpServletRequest request) {
        Gson gson = new Gson();
        Map<String, String> headers = new HashMap<>();
        Map<String, String[]> params;
        String result = "";

        Collections.list(request.getHeaderNames()).forEach(key -> headers.put(key, request.getHeader(key)));

        params = request.getParameterMap();
        try {
            com.pt.core.audit.DataIn dataIn = new DataIn(headers, params, request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
            result = gson.toJson(dataIn);
        } catch (IOException ignored) {}

        document.setInputData(result);
    }

    public Document getDocument() {
        return document;
    }
}
