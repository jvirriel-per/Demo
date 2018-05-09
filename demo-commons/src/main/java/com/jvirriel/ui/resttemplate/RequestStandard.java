package com.jvirriel.ui.resttemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static com.jvirriel.property.PropertyUtil.getProperty;
import static com.jvirriel.ui.constants.RequestStandardConstants.*;
import static com.vaadin.ui.UI.getCurrent;

/**
 * Clase para construir solicitudes HTTP para ser utilizadas por RestTemplate.
 * Created by jgjimenez on 08/05/2017.
 */
public class RequestStandard {
    private HttpHeaders headers;
    private String baseUri = getProperty(BASE_URL_BACKEND);

    /**
     * Constructor, setea headers que seran utilizados siempre en todas las solicitudes
     */
    public RequestStandard() {
        headers = new HttpHeaders();
        headers.set(APPCODE_HEADER, getProperty(APPCODE));
        headers.set(CONTENT_TYPE_HEADER, CONTENT_TYPE);
    }

    /**
     * setea headers que seran utilizados en todas las solicitudes per que dependen de variables de sesion
     * y por lo tanto cambian constantemente
     */
    private void updateHeaders() {
        headers.set(TOKEN_HEADER, getCurrent().getSession().getAttribute(TOKEN_HEADER).toString());
//        headers.set(USERNAME_HEADER, getCurrent().getSession().getAttribute(SESSION_USERNAME).toString());

    }

    /**
     * Solicitud con parametros nombrados en el body
     *
     * @param uri        URI relativa al URL base seteado en properties
     * @param bodyParams Mapa con los parametros a ser enviados en el body
     * @param method     Metodo HTTP de la solicitud
     * @return RequestEntity para ser usado por RestTemplate
     */
    private RequestEntity<MultiValueMap> request(String uri, Map<String, Object> bodyParams, HttpMethod method) {
        updateHeaders();
        URI finalUri = null;
        try {
            finalUri = new URI(baseUri + uri);
        } catch (URISyntaxException e) {
        }

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();

        if (bodyParams != null) {
            for (String key : bodyParams.keySet()) {
                params.add(key, bodyParams.get(key));
            }
        }

        return new RequestEntity<>(params, headers, method, finalUri);
    }

    /**
     * Solicitud con HEADERS adicionales
     *
     * @param uri     URI relativa al URL base seteado en properties
     * @param headers Mapa con los headers adicionales
     * @param method  Metodo HTTP de la solicitud
     * @return RequestEntity para ser usado por RestTemplate
     */
    public RequestEntity requestWithHeaders(String uri, Map<String, String> headers, HttpMethod method) {
        updateHeaders();
        URI finalUri = null;
        try {
            finalUri = new URI(baseUri + uri);
        } catch (URISyntaxException e) {
        }
        HttpHeaders actualHeaders = addHeaders(headers);

        return new RequestEntity(actualHeaders, method, finalUri);
    }

    private HttpHeaders addHeaders(Map<String, String> headers) {
        HttpHeaders actualHeaders = new HttpHeaders();
        for (String key : headers.keySet()) {
            actualHeaders.set(key, headers.get(key));
        }
        for (String key : this.headers.keySet()) {
            actualHeaders.set(key, this.headers.get(key).get(0));
        }
        return actualHeaders;
    }

    /**
     * Solicitud con Body
     *
     * @param uri    URI relativa al URL base seteado en properties
     * @param body   Objeto a ser anexado al body
     * @param method Metodo HTTP de la solicitud
     * @return RequestEntity para ser usado por RestTemplate
     */
    private RequestEntity<Object> requestWithBody(String uri, Object body, HttpMethod method) {
        updateHeaders();
        URI finalUri = null;
        try {
            finalUri = new URI(baseUri + uri);
        } catch (URISyntaxException e) {
        }

        return new RequestEntity<>(body, headers, method, finalUri);
    }

    private RequestEntity<MultiValueMap> request(String uri, HttpMethod method) {
        return request(uri, null, method);
    }

    /**
     * Solicitud get con Headers adicionales
     *
     * @param uri     uri relativa
     * @param headers HttpHeaders
     * @return RequestEntity: Solicitud GET con URL construida a partir de la base mas la uri relativa, con los headers
     * en parametros mas los headers para security
     */
    public RequestEntity<MultiValueMap> getRequest(String uri, Map<String, String> headers) {
        return requestWithHeaders(uri, headers, HttpMethod.GET);
    }

    /**
     * Solicitud get con Parametros
     *
     * @param uri     uri relativa
     * @param params BodyParams
     * @return RequestEntity: Solicitud GET con URL construida a partir de la base mas la uri relativa, con los
     * parametros mas los headers para security
     */
    public RequestEntity<MultiValueMap> getRequestWithParams(String uri, Map<String, String> params) {
        uri = addParams(uri, params);
        return request(uri, HttpMethod.GET);
    }

    /**
     * Solicitud GET
     *
     * @param uri uri relativa
     * @return RequestEntity: Solicitud GET con URL construida a partir de la base mas la uri relativa, con los headers
     * para security
     */
    public RequestEntity<MultiValueMap> getRequest(String uri) {
        return request(uri, HttpMethod.GET);
    }

    /**
     * Solicitud POST con body
     *
     * @param uri  uri relativa
     * @param body Objeto a ser enviado en el body
     * @return RequestEntity: Solicitud POST con URL construida a partir de la base mas la uri relativa, con los headers
     * para security y el body provisto
     */
    public RequestEntity<Object> postRequest(String uri, Object body) {
        return requestWithBody(uri, body, HttpMethod.POST);
    }

    /**
     * Solicitud POST con headers adicionales
     *
     * @param uri  uri relativa
     * @param headers Headers adicionales
     * @return RequestEntity: Solicitud POST con URL construida a partir de la base mas la uri relativa, con los headers
     * para security mas los adicionales provistos
     */
    public RequestEntity<Object> postRequestWithHeaders(String uri, Map<String, String> headers) {
        return requestWithHeaders(uri, headers, HttpMethod.POST);
    }

    /**
     * Solicitud POST
     *
     * @param uri uri relativa
     * @return RequestEntity: Solicitud POST con URL construida a partir de la base mas la uri relativa, con los headers
     * para security
     */
    public RequestEntity<Object> postRequest(String uri) {
        return requestWithBody(uri, null, HttpMethod.POST);
    }

    public RequestEntity<Object> postRequest(String uri, Object body, Map<String, String> headers, Map<String, String> uriParams) {
        updateHeaders();
        URI finalUri = null;
        HttpHeaders actualHeaders = addHeaders(headers);
        uri = addParams(uri, uriParams);
        try {
            finalUri = new URI(baseUri + uri);
        } catch (URISyntaxException e) {
        }

        return new RequestEntity<>(body, actualHeaders, HttpMethod.POST, finalUri);
    }

    /**
     * Solicitud PUT con body
     *
     * @param uri  uri relativa
     * @param body Objeto a ser enviado en el body
     * @return RequestEntity: Solicitud PUT con URL construida a partir de la base mas la uri relativa, con los headers
     * para security y el body
     */
    public RequestEntity<Object> putRequest(String uri, Object body) {
        return requestWithBody(uri, body, HttpMethod.PUT);
    }

    /**
     * Solicitud PUT
     *
     * @param uri uri relativa
     * @return RequestEntity: Solicitud PUT con URL construida a partir de la base mas la uri relativa, con los headers
     * para security
     */
    public RequestEntity<Object> putRequest(String uri) {
        return requestWithBody(uri, null, HttpMethod.PUT);
    }

    /**
     * Solicitud DELETE
     *
     * @param uri uri relativa
     * @return RequestEntity: Solicitud DELETE con URL construida a partir de la base mas la uri relativa, con los
     * headers
     * para security
     */
    public RequestEntity<MultiValueMap> deleteRequest(String uri) {
        return request(uri, HttpMethod.DELETE);
    }

    public String addParams(final String uri, Map<String, String> params) {
        String result = uri;
        boolean ft = true;
        for (Map.Entry<String,String> param : params.entrySet()) {
            result += ft ? "?" : "&";
            ft = false;
            result += param.getKey()+"="+param.getValue();
        }
        return result;
    }
}
