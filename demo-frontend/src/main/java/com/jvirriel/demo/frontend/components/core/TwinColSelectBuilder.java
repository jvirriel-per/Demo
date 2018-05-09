package com.jvirriel.demo.frontend.components.core;

import com.vaadin.data.HasValue;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.TwinColSelect;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 *  Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/TwinColSelect.html">TwinColSelect</a>
 */
public final class TwinColSelectBuilder {

    private final TwinColSelect twinColSelect;

    /**
     * Hide constructor, use static factory methods.
     */
    private TwinColSelectBuilder(final TwinColSelect twinColSelect) {
        this.twinColSelect = twinColSelect;
    }

    /**
     *
     * @return the created instance
     */
    public final TwinColSelect get(){
        return twinColSelect;
    }

    /**
     * Construye el twincolselect sin nada
     * @return
     */
    public static TwinColSelectBuilder twinColSelect(){
        return new TwinColSelectBuilder(new TwinColSelect());
    }

    /**
     * Construye el twinlist con una descripcion
     * @param caption
     * @return
     */
    public static TwinColSelectBuilder twinColSelect(String caption){
        return new TwinColSelectBuilder(new TwinColSelect(caption));
    }

    /**
     * Construye el twinlist como una descripci�n y coleccion de datos espec�fica
     * @param caption
     * @param options
     * @return
     */
    public static TwinColSelectBuilder twinColSelect(String caption, Collection<?> options){
        return new TwinColSelectBuilder(new TwinColSelect(caption,options));
    }


    public TwinColSelectBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            twinColSelect.addAttachListener(attachListener);
        }
        return this;
    }

    public TwinColSelectBuilder addListener(Component.Listener listener){
        twinColSelect.addListener(listener);
        return this;
    }

    public TwinColSelectBuilder addContextClickListener(ContextClickEvent.ContextClickListener contextClickListener){
        twinColSelect.addContextClickListener(contextClickListener);
        return this;
    }

    public TwinColSelectBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            twinColSelect.addStyleName(styleName);
        }
        return this;
    }


    public TwinColSelectBuilder addValueChangeListener(HasValue.ValueChangeListener listener){
        twinColSelect.addValueChangeListener(listener);
        return this;
    }

    public TwinColSelectBuilder select(Object ItemId){
        twinColSelect.select(ItemId);
        return this;
    }

    public TwinColSelectBuilder select(List<String> strings){
        for (final String string : strings){
            twinColSelect.select(string);
        }
        return this;
    }

    public TwinColSelectBuilder setWidth(final String width){
        twinColSelect.setWidth(width);
        return this;
    }

    public TwinColSelectBuilder setWidth(final float width, Sizeable.Unit unit) {
        twinColSelect.setWidth(width, unit);
        return this;
    }

    public TwinColSelectBuilder setHeight(final String height){
        twinColSelect.setHeight(height);
        return this;
    }

    public TwinColSelectBuilder setLeftColumnCaption(String leftcolumncaption){
        twinColSelect.setLeftColumnCaption(leftcolumncaption);
        return this;
    }

    public TwinColSelectBuilder setRightColumnCaption(String rightcolumncaption){
        twinColSelect.setRightColumnCaption(rightcolumncaption);
        return this;
    }

    public TwinColSelectBuilder setRows(int rows){
        twinColSelect.setRows(rows);
        return this;
    }

    public TwinColSelectBuilder setEnabled(final boolean enabled){
        twinColSelect.setEnabled(enabled);
        return this;
    }

    public TwinColSelectBuilder setVisible(final boolean visible){
        twinColSelect.setVisible(visible);
        return this;
    }

    public TwinColSelectBuilder setResponsive(final boolean responsive){
        twinColSelect.setResponsive(responsive);
        return this;
    }

    public TwinColSelectBuilder setPrimaryStyleName(final String primaryStyleName) {
        twinColSelect.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public TwinColSelectBuilder setLocale(Locale locale){
        twinColSelect.setLocale(locale);
        return this;
    }

    public TwinColSelectBuilder setReadOnly(boolean readOnly){
        twinColSelect.setReadOnly(readOnly);
        return this;
    }

    public TwinColSelectBuilder setData(Object data) {
        twinColSelect.setData(data);
        return this;
    }

    public TwinColSelectBuilder setDescription(String description){
        twinColSelect.setDescription(description);
        return this;
    }
}
