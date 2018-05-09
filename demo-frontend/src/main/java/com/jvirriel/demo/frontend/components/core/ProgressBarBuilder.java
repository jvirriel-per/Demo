package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.ProgressBar;

import java.util.Locale;

/**
 *  Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/ProgressBar.html">ProgressBar</a>
 */
public final class ProgressBarBuilder {

    private final ProgressBar progressBar;

    public ProgressBarBuilder(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    /**
     * Crea un componente vaadin tipo ProgressBar
     * @return Objeto tipo ProgressBar
     */
    public final ProgressBar get(){
        return progressBar;
    }


    /**
     * Contructor vacío
     * @return Objeto tipo progressbar vacío
     */
    public static ProgressBarBuilder ProgressBar(){
        return new ProgressBarBuilder(new ProgressBar());
    }

    /**
     * Crea una nueva barra de progreso con el valor inicial dado.
     * @param progress valor inicial
     * @return Objeto con el valor especificado.
     */
    public static ProgressBarBuilder ProgressBar(float progress){
        return new ProgressBarBuilder(new ProgressBar(progress));
    }

    public ProgressBarBuilder addContextClickListener(ContextClickEvent.ContextClickListener listener){
        progressBar.addContextClickListener(listener);
        return this;
    }

    public ProgressBarBuilder addShortcutListener(ShortcutListener shortcut){
        progressBar.addShortcutListener(shortcut);
        return this;
    }

    public ProgressBarBuilder addStyleName(String style){
        progressBar.addStyleName(style);
        return this;
    }

    public ProgressBarBuilder addAttachListener(ClientConnector.AttachListener listener){
        progressBar.addAttachListener(listener);
        return this;
    }

     public ProgressBarBuilder removeShortcutListener(ShortcutListener shortcut){
         progressBar.removeShortcutListener(shortcut);
         return this;
     }

     public ProgressBarBuilder removeStyleName(String style){
         progressBar.removeStyleName(style);
         return this;
     }

     public ProgressBarBuilder setLocale(Locale locale){
         progressBar.setLocale(locale);
         return this;
     }

     public ProgressBarBuilder setCaption(String caption){
         progressBar.setCaption(caption);
         return this;
     }

     public ProgressBarBuilder setData(Object data){
         progressBar.setData(data);
         return this;
     }

     public ProgressBarBuilder setDescription(String description){
         progressBar.setDescription(description);
         return this;
     }

     public ProgressBarBuilder setEnabled(boolean enabled){
         progressBar.setEnabled(enabled);
         return this;
     }

     public ProgressBarBuilder setHeight(float height, Sizeable.Unit unit){
         progressBar.setHeight(height,unit);
         return this;
     }

    public ProgressBarBuilder setHeight(String height){
        progressBar.setHeight(height);
        return this;
    }

    public ProgressBarBuilder setHeightUndefined(){
        progressBar.setHeightUndefined();
        return this;
    }

    public ProgressBarBuilder setIcon(Resource icon){
        progressBar.setIcon(icon);
        return this;
    }

    public ProgressBarBuilder setPrimaryStyleName(String style){
        progressBar.setPrimaryStyleName(style);
        return this;
    }

    public ProgressBarBuilder setResponsive(boolean responsive){
        progressBar.setResponsive(responsive);
        return this;
    }

    public ProgressBarBuilder setSizeFull(){
        progressBar.setSizeFull();
        return this;
    }

    public ProgressBarBuilder setSizeUndefined(){
        progressBar.setSizeUndefined();
        return this;
    }

    public ProgressBarBuilder setStyleName(String style, boolean add){
        progressBar.setStyleName(style,add);
        return this;
    }

    public ProgressBarBuilder setStyleName(String style){
        progressBar.setStyleName(style);
        return this;
    }

    public ProgressBarBuilder setVisible(boolean visible){
        progressBar.setVisible(visible);
        return this;
    }

    public ProgressBarBuilder setWidth(float width, Sizeable.Unit unit){
        progressBar.setWidth(width, unit);
        return this;
    }

    public ProgressBarBuilder setWidth(String width){
        progressBar.setWidth(width);
        return this;
    }

    public ProgressBarBuilder setWidthUndefined(){
        progressBar.setWidthUndefined();
        return this;
    }

    public ProgressBarBuilder setIndeterminate(boolean indeterminate){
        progressBar.setIndeterminate(indeterminate);
        return this;
    }
}