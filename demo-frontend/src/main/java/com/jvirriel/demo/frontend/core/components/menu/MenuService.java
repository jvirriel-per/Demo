package com.jvirriel.demo.frontend.core.components.menu;

import rx.subjects.BehaviorSubject;

public class MenuService {
    private static MenuService menuService;
    private BehaviorSubject<String> menuObservable;
    private String uriApp;

    private MenuService() {
        this.uriApp = null;
        this.menuObservable = BehaviorSubject.create(this.uriApp);
    }

    public static MenuService getInstance(){
        if (menuService == null)
            menuService = new MenuService();

        return menuService;
    }

    public BehaviorSubject<String> getMenuObservable(){
        return this.menuObservable;
    }

    public void setUriApp(String uriApp){
        this.uriApp = uriApp;
        this.menuObservable.onNext(this.uriApp);
    }

}