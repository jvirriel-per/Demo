package com.jvirriel.demo.frontend.core.views.containers;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.pt.base.core.annotations.Functionality;
import com.pt.base.core.annotations.Navigation;
import com.pt.base.core.components.breadcrumb.BreadcrumbItem;
import com.pt.base.core.components.breadcrumb.events.BreadcrumbEventAdd;
import com.pt.base.core.components.breadcrumb.events.BreadcrumbEventEntryBaseContainer;
import com.pt.base.core.components.breadcrumb.events.BreadcrumbEventRemoveLast;
import com.pt.base.core.components.menu.BaseMenu;
import com.pt.base.core.components.menu.BaseMenuItem;
import com.pt.base.core.views.base.GridService;
import com.pt.base.core.views.base.ViewUI;
import com.pt.base.core.views.main.MainUIConstants;
import com.pt.base.core.views.main.ViewEvent;
import com.pt.base.core.views.navigator.BaseNavigator;
import com.pt.components.ComponentFactory;
import com.pt.util.search.SearchCondition;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
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
import rx.Subscription;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.pt.util.constant.GeneralConstants.EMPTY_STRING;

/**
 * BaseContainerUI:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public class BaseContainerUI extends CssLayout implements View {
    protected BaseMenu baseMenu;
    protected CssLayout container;
    protected BaseNavigator baseNavigator;
    private String principalView;
    protected String uriApp;
    protected Set<Number> selectedIds;
    protected EventBus bus;
    protected static Subscription listSubscription;
    protected static Subscription codeSubscription;
    protected static Subscription nameSubscription;
    protected static Subscription conditionsSubscription;

    protected List<SearchCondition> conditions;
    protected Label title;
    protected CssLayout headerLayout;

    protected String code;
    protected String name;

    protected List<String> parametersList;
    protected static Subscription parametersListSubscription;

    public BaseContainerUI() {
        setPrimaryStyleName("base-container");

        selectedIds = new HashSet<>();

        buildHeader();
        buildContainer();
        buildNavigator();
        registerViews();

        if (listSubscription != null)
            listSubscription.unsubscribe();
        listSubscription = GridService.getInstance().getListObservable().subscribe(this::updateSelected);

        if (conditionsSubscription != null)
            conditionsSubscription.unsubscribe();
        conditionsSubscription = GridService.getInstance().getConditionsObservable().subscribe(this::updateConditions);

        if (codeSubscription != null)
            codeSubscription.unsubscribe();
        codeSubscription = GridService.getInstance().getCodeObservable().subscribe(this::updateCode);

        if (nameSubscription != null)
            nameSubscription.unsubscribe();
        nameSubscription = GridService.getInstance().getNameObservable().subscribe(this::updateName);

        if (parametersListSubscription != null)
            parametersListSubscription.unsubscribe();
        parametersListSubscription = GridService.getInstance().getParametersListObservable().subscribe(this::receiveParametersList);
    }

    private void receiveParametersList(List<String> parametersList) {
        this.parametersList = new ArrayList<>();
        if (parametersList != null)
            parametersList.forEach(parameter -> this.parametersList.add(parameter));
    }

    protected void updateSelected(Set<Number> list) {
        selectedIds = new HashSet<>();
        if (list != null)
            list.forEach(id -> selectedIds.add(id));
    }

    protected void updateConditions(List<SearchCondition> conditionList) {
        conditions = new ArrayList<>();
        if (conditionList != null)
            conditionList.forEach(condition -> this.conditions.add(condition));
    }

    protected void updateCode(String code) {
        if (code != null)
            this.code = code;
    }

    protected void updateName(String name) {
        if (name != null)
            this.name = name;
    }

    @Subscribe
    protected void selectionEventHandler(BaseContainerSelectionEvent event) {
        this.selectedIds = event.getSelectedIds();
    }

    protected void registerViews() {
        Navigation navigation = this.getClass().getAnnotation(Navigation.class);
        if (navigation != null) {
            for (com.pt.base.core.annotations.View view : navigation.views()) {
                try {
                    ViewUI viewUI = (ViewUI) view.target().newInstance();
                    viewUI.setMode(view.mode());
                    viewUI.setNavigationMode(view.navMode());
                    viewUI.setTitle(view.title());
                    registerView(view.uri(), viewUI);
                    if (view.isPrincipal())
                        this.setPrincipalView(view.uri());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void buildHeader() {
        headerLayout = ComponentFactory
                .cssLayout()
                .setStyleName("base-container-header")
                .get();
        buildTitle();
        buildActionMenu();

        super.addComponent(headerLayout);
    }

    protected void buildActionMenu() {
        baseMenu = new BaseMenu(MainUIConstants.BUS_NAME);
        headerLayout.addComponent(baseMenu);
    }

    protected void buildTitle() {
        title = new Label(EMPTY_STRING);
        title.addStyleName("title-container");
        headerLayout.addComponent(title);
    }

    @Subscribe
    public void setTitle(BaseContainerEventTitle event) {
        title.setCaption(event.getShowTitle() ? event.getTitle() : "");
    }

    protected List<BaseMenuItem> getBaseMenu() {
        List<BaseMenuItem> menuItems = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try {
            Object object;
            try {
                object = parser.parse(getJson());
                JSONArray jsonArray = (JSONArray) object;

                jsonArray.forEach(menuObject -> {
                    BaseMenuItem item = new BaseMenuItem()
                            .setCaption(String.valueOf(((JSONObject) menuObject).get("label")))
                            .setUriApp(String.valueOf(((JSONObject) menuObject).get("uriApp")))
                            .setMenuType(String.valueOf(((JSONObject) menuObject).get("menuType")))
                            .setUriIcon(new ThemeResource(String.valueOf(((JSONObject) menuObject).get("uriIcon")).toLowerCase().concat(".svg")));

                    menuItems.add(item);
                });
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return menuItems;
    }

    protected void setBaseMenu(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        uriApp = viewChangeEvent.getViewName();

        baseMenu.setActionMenuItem(getBaseMenu());
    }

    protected void buildContainer() {
        container = new CssLayout();
        container.setPrimaryStyleName("base-container-view-container");
        this.addComponent(container);
    }

    protected void buildNavigator() {
        baseNavigator = new BaseNavigator(container);
    }

    protected void registerView(String viewName, ViewUI view) {
        baseNavigator.addView(viewName, view);
    }

    protected void setPrincipalView(String viewName) {
        this.principalView = viewName;
    }

    private void goToPrincipalView() {
        if (principalView != null)
            baseNavigator.navigateTo(principalView);
    }

    @Subscribe
    protected void goToView(BaseContainerEventNavigate event) {
        UI.getCurrent().getPage().setUriFragment(uriApp + "/" + event.getUriApp(), false);
        bus.post(new BreadcrumbEventRemoveLast());

        baseNavigator.navigateTo(event.getUriApp());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);
        bus.register(this);

        Functionality functionality = this.getClass().getAnnotation(Functionality.class);
        if (functionality != null)
            bus.post(new ViewEvent(functionality.mode()));

        if (viewChangeEvent.getOldView() != null && viewChangeEvent.getOldView() instanceof BaseContainerUI) {
            ((BaseContainerUI) viewChangeEvent.getOldView()).out();
        }

        setBaseMenu(viewChangeEvent);

        addBreadcrumbToContainer();

        if (viewChangeEvent.getParameters().isEmpty()) {
            this.goToPrincipalView();
        }
    }

    public void addBreadcrumbToContainer(){
        bus.post(new BreadcrumbEventEntryBaseContainer());
        bus.post(new BreadcrumbEventAdd(new BreadcrumbItem(this.getClass().getAnnotation(Functionality.class).name()).setAction(uriApp)));
    }

    public void out() {
        baseNavigator.cleanCurrent();
        bus.unregister(baseMenu);
        bus.unregister(baseNavigator);
        bus.unregister(this);
    }

    public String getJson() throws URISyntaxException {
        ResponseEntity<String> responseEntity = null;

        try {
            HttpHeaders headersRequestForSIB = new HttpHeaders();
            headersRequestForSIB.set("userToken", UI.getCurrent().getSession().getAttribute("userToken").toString());
            headersRequestForSIB.set("level", "-1");
            headersRequestForSIB.set("appcod", UI.getCurrent().getSession().getAttribute("appCodeSecurityAction").toString());
            headersRequestForSIB.set("type", "");
            headersRequestForSIB.set("appcodOrigin", UI.getCurrent().getSession().getAttribute("appCode").toString());

            HttpEntity<?> httpEntity = new HttpEntity<>(headersRequestForSIB);

            RestTemplate restTemplate = new RestTemplate();
            responseEntity = restTemplate.exchange(
                    UI.getCurrent().getSession().getAttribute("baseUrlBackend").toString() + "/menu/toolbar", HttpMethod.GET, httpEntity, String.class);
        } catch (final HttpClientErrorException e) {
            e.getStackTrace();
        }

        return responseEntity.getBody();
    }
}