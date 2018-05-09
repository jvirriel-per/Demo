package com.jvirriel.demo.frontend.components.custom.security;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Responsive;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

public class    LoginComponent extends Panel {

    private Label userNameLabel;
    private TextField userName;
    private Label passwordLabel;
    private PasswordField password;
    private Button loginBtn;
    private Button backBtn;
    private Button forgotPasswordBtn;

    private VerticalLayout panelContent;
    private VerticalLayout headerLayout;
    private ExternalResource imgResource;
    private Image headerImage;

    private LoginComponent() {
        Responsive.makeResponsive(this);
        super.addStyleName(ValoTheme.PANEL_BORDERLESS);
        super.addStyleName("login-Product");

        this.panelContent = ComponentFactory
                .verticalLayout()
                .setWidth("310px")
                .setMargin(true)
                .get();

        this.headerLayout = ComponentFactory
                .verticalLayout()
                .setMargin(new MarginInfo(true, true, true, true))
                .setSpacing(true)
                .get();

        super.setContent(panelContent);
    }

    /**
     * Construye el componente con todas sus propiedades.
     *
     * @return
     */
    public static LoginComponent create() {
        return new LoginComponent();
    }

    public LoginComponent width(String width){
        super.setWidth(width);

        return this;
    }

    public LoginComponent height(String height){
        super.setHeight(height);

        return this;
    }

    /**
     * Obtiene el campo userName.
     *
     * @return
     */
    public TextField getUserName() {
        return userName;
    }

    /**
     * Obtiene el campo password.
     *
     * @return
     */
    public PasswordField getPassword() {
        return password;
    }

    /**
     * Obtiene el botón de inicio de sesión.
     *
     * @return
     */
    public Button getLoginBtn() {
        return loginBtn;
    }

    /**
     *
     * @return
     */
    public Button getForgotPasswordBtn(){
        return forgotPasswordBtn;
    }

    public Button getBackBtn(){
        return backBtn;
    }

    /**
     * Construye un header en el panel.
     *
     * @param components
     * @return
     */
    public LoginComponent insertHeader(Component... components) {
        for (final Component component : components) {
            this.headerLayout.addComponent(component);
        }
        this.headerLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        return this;
    }

    /**
     * Inserta uno a uno los componentes en el panel.
     *
     * @param components
     * @return
     */
    public LoginComponent insertContent(Component... components) {
        for (final Component component : components) {
            this.panelContent.addComponent(component);
        }
        return this;
    }

    /**
     * Inserta una lista de componentes en el panel.
     *
     * @param components
     * @return
     */
    public LoginComponent insertContent(List<Component> components) {
        for (final Component component : components) {
            this.panelContent.addComponent(component);
        }
        return this;
    }

    /**
     * Construcción de los labels con propiedades que tienen en común.
     *
     * @param caption
     * @return
     */
    private Label labelSettings(String caption) {
        Label fieldCaption = ComponentFactory
                .label(caption)
                .get();

        return fieldCaption;
    }

    /**
     * Agrega estilos al botón de olvidar contraseña.
     *
     * @param primaryStyle, estilo principal del componente.
     * @param styleNames,   estilos secundarios del componente.
     * @return
     */
    public LoginComponent setForgotPasswordButtonStyle(String primaryStyle, String... styleNames) {
        this.forgotPasswordBtn.setPrimaryStyleName(primaryStyle);
        for (final String styleName : styleNames) {
            this.forgotPasswordBtn.addStyleName(styleName);
        }
        return this;
    }

    /**
     * Agrega estilos al panel.
     *
     * @param primaryStyle, estilo principal del componente.
     * @param styleNames,   estilos secundarios del componente.
     * @return
     */
    public LoginComponent setPanelStyle(String primaryStyle, String... styleNames) {
        super.setStyleName(primaryStyle);
        for (final String styleName : styleNames) {
            super.setPrimaryStyleName(styleName);
        }
        return this;
    }

    //TODO: Cambiar las caracteristicas de este método: que se cargue la img con su tamaño desde el css.

    /**
     * Encabezado credix para el header del panel.
     *
     * @return
     */
    public LoginComponent useCredixHeader() {
//        super.setHeight("486px");
        //TODO: Cambiar por la ruta definitiva del icono
        this.imgResource = new ExternalResource("/assets/images/logo.png");

        this.headerImage = new Image(null, imgResource);
        this.headerImage.setWidth("184px");
        this.headerImage.setHeight("59px");

        this.headerLayout.addComponent(headerImage);

        this.panelContent.addComponent(headerLayout);

        this.headerLayout.setComponentAlignment(headerImage, Alignment.MIDDLE_CENTER);

        return this;
    }

    public LoginComponent useForgotPasswordHeader() {
        this.imgResource = new ExternalResource("/assets/images/logo.png");

        this.headerImage = new Image(null, imgResource);
        this.headerImage.setWidth("184px");
        this.headerImage.setHeight("59px");

        this.headerLayout.addComponent(headerImage);

        this.headerLayout.setMargin(new MarginInfo(false, true, true, true));

        this.panelContent.addComponent(headerLayout);

        this.headerLayout.setComponentAlignment(headerImage, Alignment.MIDDLE_CENTER);

        return this;
    }

    /**
     * Agrega botón de regresar en el panel de forgotPassword.
     * @return
     */
    public LoginComponent useBackBtn(){
        backBtn = ComponentFactory
                .button(VaadinIcons.ANGLE_LEFT)
                .addStyleName("btnBack")
                .addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP)
                .get();

        this.panelContent.addComponent(backBtn, 0);

        return this;
    }

    //TODO: Arreglar espacios en los labels del form
    /**
     * Agrega al cuerpo del panel un contenido pre configurado (userName, password, botón ingresar)
     *
     * @return
     */
    public LoginComponent useDefaultContent() {
        this.userNameLabel = labelSettings("Usuario");

        this.userName = ComponentFactory
                .textField()
                .get();

        this.passwordLabel = labelSettings("Contraseña");

        this.password = ComponentFactory
                .passwordField()
                .get();

        this.loginBtn = ComponentFactory.button("Ingresar")
                .get();

        this.panelContent.addComponents(userNameLabel, userName, passwordLabel, password, loginBtn);

        return this;
    }

    //TODO: Falta un contenido para el forgotPassword

    /**
     * Habilita el botón de olvidó contraseña en el panel.
     *
     * @return
     */
    public LoginComponent useForgotPasswordButton() {
        this.forgotPasswordBtn = ComponentFactory
                .button("Olvidé mi clave")
                .get();

        this.panelContent.addComponent(forgotPasswordBtn);

        return this;
    }

    /**
     * Alinea el panel a la izquierda.
     *
     * @return
     */
    public LoginComponent useAlignLeft() {
        super.addStyleName("login-panel-align-left");
        return this;
    }

    //TODO: Mejorar la alineación al centro por la clase ccs.     text-align: center; en el layout que contiene al panel
    //TODO: y en el estilo del panel colocar margin: 0 auto;

    /**
     * Alinea el panel al centro.
     *
     * @return
     */
    public LoginComponent useAlignCenter() {
        super.addStyleName("login-panel-align-center");
        return this;
    }

    /**
     * Alinea el panel a la derecha.
     *
     * @return
     */
    public LoginComponent useAlignRight() {
        super.addStyleName("login-panel-align-right");
        return this;
    }

}