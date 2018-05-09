package com.jvirriel.demo.frontend.core.views.containers;

import rx.subjects.BehaviorSubject;

/**
 * Service to navigation.
 * Created by bpena on 24/02/17.
 */
public class BaseContainerService {
    private static BaseContainerService instance;
    private BehaviorSubject<String> targetObservable;

    private BaseContainerService() {
        this.targetObservable = BehaviorSubject.create();
    }

    public static BaseContainerService getInstance() {
        if (instance == null)
            instance = new BaseContainerService();

        return instance;
    }

    public BehaviorSubject<String> getViewTarget() {
        return this.targetObservable;
    }

    public void navigateTo(String view) {
        this.targetObservable.onNext(view);
    }

}