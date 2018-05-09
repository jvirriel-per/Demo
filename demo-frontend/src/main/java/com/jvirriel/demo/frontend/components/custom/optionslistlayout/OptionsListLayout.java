package com.jvirriel.demo.frontend.components.custom.optionslistlayout;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.jvirriel.demo.frontend.components.custom.verticaltabsheet.Option;
import com.jvirriel.demo.frontend.components.custom.verticaltabsheet.VerticalTabSheet;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OptionsListLayout extends VerticalTabSheet {

    private String title;
    private VaadinIcons icon;
    private Button iconButtonSearch, iconButtonCancel;
    private Label optionsListLayoutName;
    private Label notificationPanel;
    private Label notificationMenu;
    private List<Option> options = new ArrayList<>();
    private VerticalLayout searchMenu, panelContentNotification;
    private CssLayout group;
    private Panel panelContent;
    private TextField search;
    private List<String> listSearch = new ArrayList<>();

    public OptionsListLayout(String title, VaadinIcons icon) {
        this.title = title;
        this.icon = icon;

        buildOptionList();
    }

    private void buildOptionList(){
        this.optionsListLayoutName = ComponentFactory.label()
                .setWidth("100%")
                .setContentMode(ContentMode.HTML)
                .setValue(this.icon.getHtml() + "  " + this.title)
                .get();

        group = ComponentFactory.cssLayout()
                .setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP)
                .get();

        search = ComponentFactory
                .textField()
                .setPlaceholder("Buscar...")
                .get();

        AutocompleteExtension<String> textFieldExtension = new AutocompleteExtension<>(search);
        textFieldExtension.setSuggestionGenerator(this::suggestions);

        textFieldExtension.addSuggestionSelectListener(event -> {
            searchMenu = ComponentFactory.verticalLayout().get();
            searchMenu = super.getMenu();

            if (!search.isEmpty()) {
                search.focus();

                group.removeComponent(iconButtonSearch);
                group.addComponent(iconButtonCancel);

                boolean flag = false;
                super.removeMenu();

                for (Option option : options) {
                    if (event.getSelectedValue().equals(option.getClassName()) ||
                            option.getClassName().matches(event.getSelectedValue().substring(0, 1).toUpperCase() + event.getSelectedValue().substring(1) + ".*") ||
                            option.getClassName().matches(event.getSelectedValue() + ".*")) {
                        super.addComponent(option.getClazz(), option.getClassName(), option.getIcon());
                        flag = true;
                    }
                }

                if (!flag) {
                    searchMenu.removeAllComponents();
                    searchMenu.addComponent(notificationMenu);
                    searchMenu.setComponentAlignment(notificationMenu, Alignment.MIDDLE_CENTER);
                    panelContent.setContent(panelContentNotification);
                    super.setContentArea(panelContent);
                }
            }

            searchMenu.addComponentAsFirst(group);
            searchMenu.addComponentAsFirst(this.optionsListLayoutName);
            super.setMenu(searchMenu);
        });

        notificationPanel = ComponentFactory.label("Seleccione una opción de la lista...")
                .get();

        notificationMenu = ComponentFactory.label("No hay resultados...")
                .setStyleName(ValoTheme.LABEL_H3)
                .get();

        panelContentNotification = ComponentFactory.verticalLayout(notificationPanel)
                .setHeight("100%")
                .setComponentAlignment(notificationPanel, Alignment.MIDDLE_CENTER)
                .get();

        panelContent = ComponentFactory.panel(panelContentNotification)
                .addStyleName(ValoTheme.PANEL_BORDERLESS)
                .setWidth((float) 100, Unit.PERCENTAGE)
                .setHeight(100, Unit.PERCENTAGE)
                .get();
        super.setContentArea(panelContent);

        iconButtonSearch = ComponentFactory.button(VaadinIcons.SEARCH)
                .addClickListener(clickEvent -> search())
                .get();

        iconButtonCancel = ComponentFactory.button(VaadinIcons.CLOSE_CIRCLE)
                .addClickListener(clickEvent -> cancelSearch())
                .get();

        group.addComponents(search, iconButtonSearch);

        super.removeMenu();
        super.getMenu().addComponentAsFirst(group);
        super.getMenu().addComponentAsFirst(this.optionsListLayoutName);
    }

    private void cancelSearch() {
        group.removeComponent(iconButtonCancel);
        group.addComponent(iconButtonSearch);
        search.clear();
        search.focus();
        super.removeMenu();
        this.backupMenu();
    }

    public void search() {
        searchMenu = ComponentFactory.verticalLayout().get();
        searchMenu = super.getMenu();

        if (!search.isEmpty()) {
            search.focus();
            group.removeComponent(iconButtonSearch);
            group.addComponent(iconButtonCancel);

            boolean flag = false;

            String str = search.getValue().toLowerCase();

            super.removeMenu();
            for (Option option : options) {
                if (str.equalsIgnoreCase(option.getClassName()) ||
                        option.getClassName().matches(str.substring(0, 1).toUpperCase() + str.substring(1) + ".*") ||
                        option.getClassName().matches(str + ".*")) {
                    super.addComponent(option.getClazz(), option.getClassName(), option.getIcon());
                    flag = true;
                }
            }

            if (!flag) {
                searchMenu.removeAllComponents();
                searchMenu.addComponent(notificationMenu);
                searchMenu.setComponentAlignment(notificationMenu, Alignment.MIDDLE_CENTER);
                panelContent.setContent(panelContentNotification);
                super.setContentArea(panelContent);
            }
        }

        searchMenu.addComponentAsFirst(group);
        searchMenu.addComponentAsFirst(this.optionsListLayoutName);
        super.setMenu(searchMenu);
    }

    private List<String> suggestions(String query, int cap) {
        return listSearch.stream().filter(p -> p.contains(query))
                .limit(cap).collect(Collectors.toList());
    }

    public void addOption(Class optionClazz, String optionName, com.vaadin.server.Resource optionIcon) {
        super.addComponent(optionClazz, optionName, optionIcon);
        options.add(new Option(optionClazz, optionName, optionIcon));
        listSearch.add(optionName);
    }

    public void addOption(Option option) {
        super.addComponent(option.getClazz(), option.getClassName(), option.getIcon());
        options.add(new Option(option.getClazz(), option.getClassName(), option.getIcon()));
        listSearch.add(option.getClazz().getSimpleName());
    }

    public void addOptions(List<Option> options) {
        for (Option option : options) {
            super.addComponent(option.getClazz(), option.getClassName(), option.getIcon());
            this.options.add(new Option(option.getClazz(), option.getClassName(), option.getIcon()));
            listSearch.add(option.getClassName());
        }
    }

    public void removeAllOption() {
        super.removeMenu();
        options.clear();
    }

    public List<Option> getAllOptions() {
        return options;
    }

    private void backupMenu() {
        for (Option option : options) {
            super.addComponent(option.getClazz(), option.getClassName(), option.getIcon());
        }
        super.getMenu().addComponentAsFirst(group);
        super.getMenu().addComponentAsFirst(this.optionsListLayoutName);
    }

    public Option getActiveOption() {
        return new Option(super.getClassActive(), super.getNameActive(), super.getIconActive());
    }

    public boolean isActive(String name) {
        return super.getNameActive() == name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VaadinIcons getIcon() {
        return icon;
    }

    public void setIcon(VaadinIcons icon) {
        this.icon = icon;
    }
}