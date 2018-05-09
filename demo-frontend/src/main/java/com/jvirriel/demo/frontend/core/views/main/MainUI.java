package com.jvirriel.demo.frontend.core.views.main;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.pt.base.core.components.breadcrumb.Breadcrumb;
import com.pt.base.core.components.breadcrumb.events.BreadcrumbEventClean;
import com.pt.base.core.components.header.HeaderComponent;
import com.pt.base.core.components.menu.mainmenu.MainMenuComponent;
import com.pt.base.core.components.subheader.BackButton;
import com.pt.base.core.views.containers.VoidView;
import com.pt.base.core.views.navigator.events.NavigatorEventAdd;
import com.pt.base.core.views.navigator.events.NavigatorEventNavigate;
import com.pt.components.custom.alertdialog.AlertDialog;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static com.pt.util.constant.GeneralConstants.EMPTY_STRING;
import static com.pt.util.property.PropertyUtil.getProperty;

/**
 * MainUI:
 * De aca se extendera para generar clases de tipo ventana principal.
 * De forma predeterminada esto contendra un Header, un SubHeader, un Container,
 * un Footer y se asociara un BaseNavigator el container para que realice la carga
 * de las vistas y los cambios entre estas.
 * <p>
 * Creado por bpena el 21/04/2017.
 */
public class MainUI extends UI implements View {
    protected CssLayout mainContainer;
    protected HeaderComponent header;
    protected CssLayout subHeader;
    protected CssLayout container;
    protected CssLayout footer;
    protected Navigator navigator;
    protected EventBus bus;
    protected String appName;

    protected BackButton backButton;
    protected MainMenuComponent mainMenuComponent;
    protected com.pt.base.core.components.breadcrumb.Breadcrumb breadcrumb;

    public MainUI() {
        mainContainer = new CssLayout();
        mainContainer.setSizeFull();
        mainContainer.addStyleName("main-container");
        setContent(mainContainer);
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.appName = Page.getCurrent().getLocation().getPath().replace("/", EMPTY_STRING);
        UI.getCurrent().getSession().setAttribute("appCode", getProperty("appCode"));
        UI.getCurrent().getSession().setAttribute("baseUrlBackend", getProperty("baseUrlBackend"));
        UI.getCurrent().getSession().setAttribute("appCodeSecurityLobby", getProperty("appCodeSecurityLobby"));
        UI.getCurrent().getSession().setAttribute("appCodeSecurityHeader", getProperty("appCodeSecurityHeader"));
        UI.getCurrent().getSession().setAttribute("appCodeSecurityMain", getProperty("appCodeSecurityMain"));
        UI.getCurrent().getSession().setAttribute("appCodeSecurityAction", getProperty("appCodeSecurityAction"));

        Page.getCurrent().getJavaScript().addFunction("com.security.auth",
                (JavaScriptFunction) arguments -> {
                    try {
                        String urlBack = Page.getCurrent().getLocation().toString();
                        Page.getCurrent().getJavaScript().execute("window.sessionStorage.setItem(\"urlBack\",\"" + urlBack + "\" )");
                        UI.getCurrent().getSession().setAttribute("userToken", arguments.getString(0));

                        HttpHeaders headersRequestForSIB = new HttpHeaders();
                        headersRequestForSIB.set("userToken", UI.getCurrent().getSession().getAttribute("userToken").toString());
                        headersRequestForSIB.set("appcod", UI.getCurrent().getSession().getAttribute("appCodeSecurityHeader").toString());
                        headersRequestForSIB.set("appcodOrigin", UI.getCurrent().getSession().getAttribute("appCode").toString());

                        HttpEntity<?> httpEntity = new HttpEntity<>(headersRequestForSIB);
                        UI.getCurrent().getSession().setAttribute("userid", Long.valueOf((new RestTemplate()).exchange(
                                UI.getCurrent().getSession().getAttribute("baseUrlBackend").toString()+"user/userid",
                                HttpMethod.GET, httpEntity, String.class).getBody()));

                        registerEventBus();

                        buildHeader();
                        buildSubHeader();
                        buildContainer();
                        buildFooter();

                        setNavigator();

                        enter(null);
                    } catch (Exception e) {
                        AlertDialog.danger(UI.getCurrent(), EMPTY_STRING,
                                "Usuario no autenticado", EMPTY_STRING, "Ok", (AlertDialog.Listener) dialog -> {
                                    if (dialog.isConfirmed()) {
                                        UI.getCurrent().getPage().setLocation(getProperty("urlRedirect"));
                                    }
                                }, null);
                        e.printStackTrace();
                    }
                });

        Page.getCurrent().getJavaScript().execute("com.security.auth(window.sessionStorage.getItem('userToken'))");
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        bus.post(new BreadcrumbEventClean());
    }

    /**
     * registerEventBus:
     * Crea y configura el bus de eventos principal y lo deja disponible para
     * utilizarlo en toda la aplicacion al compartirlo en la sesion de vaadin.
     */
    protected void registerEventBus() {
        bus = new EventBus();
        bus.register(this);
        UI.getCurrent().getSession().setAttribute(MainUIConstants.BUS_NAME, bus);
    }

    /**
     * buildHeader:
     * Construye y agrega el encabezado
     */
    protected void buildHeader() {
        header = HeaderComponent.create();
        header.useDefaultStyle();
        mainContainer.addComponent(header);
    }

    /**
     * setVisibleHeader:
     * Configura la visibilidad del encabezado.
     *
     * @param visible: valor de la visibilidad.
     */
    protected void setVisibleHeader(Boolean visible) {
        header.setVisible(visible);
    }

    protected void getMainMenu() {
        mainMenuComponent.buildMenu();
    }

    /**
     * buildSubHeader:
     * Construye y agrega el encabezado secundario
     */
    protected void buildSubHeader() {
        subHeader = new CssLayout();
        subHeader.addStyleName("sub-header");

        backButton = new BackButton();
        backButton.addStyleName("back-button");
        backButton.setVisible(false);
        subHeader.addComponent(backButton);

        mainMenuComponent = new MainMenuComponent(MainUIConstants.BUS_NAME);
        mainMenuComponent.addStyleName("main-menu-button");
        getMainMenu();
        subHeader.addComponent(mainMenuComponent);

        breadcrumb = new Breadcrumb(MainUIConstants.BUS_NAME);
        breadcrumb.addStyleName("flex");
        subHeader.addComponent(breadcrumb);
        mainContainer.addComponent(subHeader);
    }

    /**
     * Configura la visibilidad del encabezado secundario.
     *
     * @param visible: valor de la visibilidad del encabezado.
     */

    protected void setVisibleSubHeader(Boolean visible) {
        subHeader.setVisible(visible);

    }

    /**
     * @param visible
     */
    @Subscribe
    protected void setVisibleMainMenu(Boolean visible) {
        mainMenuComponent.setVisible(visible);
    }

    /**
     * buildForm
     * Construye y agrega la seccion de navegacion o contenedor principal
     */
    protected void buildContainer() {
        container = new CssLayout();
        container.addStyleName("view-main-container");
        mainContainer.addComponent(container);
    }

    /**
     * buildFooter
     * Construye y agrega el Footer
     */
    protected void buildFooter() {
        footer = new CssLayout();
        footer.addComponent(new Label("footer"));
        footer.addStyleName("footer");
        mainContainer.addComponent(footer);
    }

    /**
     * setVisibleFooter:
     * Configura la visibilidad de Footer.
     *
     * @param visible: valor de la visibilidad el footer.
     */
    protected void setVisibleFooter(Boolean visible) {
        footer.setVisible(visible);
    }

    /**
     * setNavigator
     * Se crea y se configura el BaseNavigator
     */
    protected void setNavigator() {
        navigator = new Navigator(this, container);
        setViews();
        setErrorViews();
    }

    /**
     * setViews:
     * Configura y agrega el listado de vistas o clases en el baseNavigator.
     */
    protected void setViews() {
        bus.post(new NavigatorEventAdd(EMPTY_STRING, VoidView.class));
    }

    /**
     * setErrorViews:
     * Para configurar las vistas para error.
     */
    protected void setErrorViews() {

    }

    @Subscribe
    protected void updateView(ViewEvent event) {
        switch (event.getMode()) {
            case LOGIN:
                setVisibleHeader(false);
                setVisibleSubHeader(false);
                setVisibleMainMenu(false);
                setVisibleFooter(false);
                break;
            case LOBBY:
                setVisibleHeader(true);
                setVisibleSubHeader(false);
                setVisibleMainMenu(false);
                setVisibleFooter(false);
                break;
            case FUNCTIONALLITY:
                setVisibleHeader(true);
                setVisibleSubHeader(true);
                setVisibleMainMenu(true);
                setVisibleFooter(false);
                break;
            case SUBLOBBY:
                setVisibleHeader(true);
                setVisibleSubHeader(true);
                setVisibleMainMenu(false);
                setVisibleFooter(false);
                break;

        }
    }

    @Subscribe
    protected void updateNavigator(NavigatorEventAdd event) {
        UI.getCurrent().getNavigator().addView(event.getTarget(), event.getClazz());
    }

    @Subscribe
    protected void navigateTo(NavigatorEventNavigate event) {
        UI.getCurrent().getNavigator().navigateTo(event.getTarget());
    }
}