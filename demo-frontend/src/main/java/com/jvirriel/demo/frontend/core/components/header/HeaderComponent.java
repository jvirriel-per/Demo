package com.jvirriel.demo.frontend.core.components.header;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.jvirriel.demo.frontend.core.components.menu.HeaderMenuComponent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.Responsive;
import com.vaadin.ui.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

/**
 * Clase custom que construye el header de la aplicación.
 */
public class HeaderComponent extends CssLayout {
    private CssLayout leftLayout;
    private CssLayout rightLayout;

    public String restCallResult;

    private HeaderComponent() {
        Responsive.makeResponsive(this);
        super.setWidth("100%");

        this.leftLayout = ComponentFactory.cssLayout().get();
        this.leftLayout.addStyleName("left-layout");
        this.rightLayout = ComponentFactory.cssLayout().get();
        this.rightLayout.addStyleName("right-layout");

        buildHeaderMenu();
        buildLogo();

        super.addComponents(leftLayout, rightLayout);
    }

    /**
     * Construye el headerComponent.
     *
     * @return headerComponent, header construido con todos sus elementos.
     */
    public static HeaderComponent create() {
        return new HeaderComponent();
    }

    /**
     * Construye toda la llamada REST para obtener el json de la BD.
     */
    public void buildRestCall() {
    }

    private void buildLogo() {
        Image logo = new Image();
        Resource resource = new ExternalResource("/assets/home/img/logo.svg");
        logo.setIcon(resource);
        logo.setStyleName("logo");
        this.setLeftElements(logo);
    }

    /**
     * Obtiene el jsonObject proveniente de la BD a través de una llamada REST.
     */
    private void buildHeaderMenu() {
        JSONParser parser = new JSONParser();
        try {
            this.restCallResult = getJson();
            Object object = parser.parse(this.restCallResult);
            JSONArray jsonArray = (JSONArray) object;

            for (Object menuObject : jsonArray) {
                JSONObject jsonObject = (JSONObject) menuObject;
                this.rightLayout.addComponent(new HeaderMenuComponent(jsonObject));
            }

        } catch (ParseException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getJson() throws URISyntaxException {

        ResponseEntity<String> responseEntity = null;

        try {
            HttpHeaders headersRequestForSIB = new HttpHeaders();
            headersRequestForSIB.set("userToken", UI.getCurrent().getSession().getAttribute("userToken").toString());
            headersRequestForSIB.set("level", "-1");
            headersRequestForSIB.set("appcod", UI.getCurrent().getSession().getAttribute("appCodeSecurityHeader").toString());
            headersRequestForSIB.set("type", "");
            headersRequestForSIB.set("appcodOrigin", UI.getCurrent().getSession().getAttribute("appCode").toString());

            HttpEntity<?> httpEntity = new HttpEntity<>(headersRequestForSIB);

            RestTemplate restTemplate = new RestTemplate();
            responseEntity = restTemplate.exchange(
                    UI.getCurrent().getSession().getAttribute("baseUrlBackend").toString() + "menu/header", HttpMethod.GET, httpEntity, String.class);

        } catch (final HttpClientErrorException e) {
            e.getStackTrace();
        }


        return responseEntity.getBody();
    }

    /**
     * Recibe los elementos a insertar en el lado izquierdo del header.
     *
     * @param components, componentes a agregar al lado izquierdo.
     * @return
     */
    public HeaderComponent setLeftElements(final Component... components) {
        for (final Component component : components) {
            this.leftLayout.addComponent(component);
        }

        return this;
    }

    /**
     * Insertar estilo al header.
     *
     * @param styleName, nombre de la clase css
     * @return
     */
    public HeaderComponent setHeaderStyle(String styleName) {
        super.setPrimaryStyleName(styleName);

        return this;
    }

    /**
     * Usar estilo por default en la barra.
     *
     * @return
     */
    public HeaderComponent useDefaultStyle() {
        super.setPrimaryStyleName("main-header");

        return this;
    }
}