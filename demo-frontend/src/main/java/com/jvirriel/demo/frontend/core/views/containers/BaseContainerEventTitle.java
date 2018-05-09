package com.jvirriel.demo.frontend.core.views.containers;

import java.util.Objects;

/**
 * BaseContainerEventNavigate:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public class BaseContainerEventTitle {
    private String title;
    private Boolean showTitle;

    public BaseContainerEventTitle(String title) {
        if (Objects.isNull(title) || title.isEmpty())
            throw new BaseContainerUIException("ViewName must be defined on BaseContainerEventNavigate");
        this.showTitle = true;
        this.title = title;
    }

    public BaseContainerEventTitle(String title, Boolean showTitle) {
        this(title);
        this.showTitle = showTitle;
    }

    public String getTitle() {
        return title;
    }

    public BaseContainerEventTitle setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean getShowTitle() {
        return showTitle;
    }

    public BaseContainerEventTitle setShowTitle(Boolean showTitle) {
        this.showTitle = showTitle;
        return this;
    }
}
