package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.Resource;
import com.vaadin.ui.ListSelect;

import java.util.Collection;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/ListSelect.html">ListSelectBuilder</a>
 */
public final class ListSelectBuilder {

    private final ListSelect listSelect;

    private ListSelectBuilder(ListSelect listSelect) {
        this.listSelect = listSelect;
    }

    /**
     * Crea un componente vaadin tipo ListSelect
     * @return el objeto actual
     */
    public final ListSelect get() {
        return listSelect;
    }

    /**
     * Constructores del componente
     */

    /**
     * Genera un componente tipo ListSelect Vac�o
     * @return objeto de tipo ListSelect Vac�o.
     */
    public static ListSelectBuilder listSelect(){
        return new ListSelectBuilder(new ListSelect());
    }

    /**
     * Crea un componente tipo listSelect con un subt�tulo
     * @param caption subtitulo a utilizar.
     * @return objeto de tipo ListSelect con subt�tulo.
     */
    public static ListSelectBuilder listSelect(String caption){
        return new ListSelectBuilder(new ListSelect(caption));
    }

    /**
     * Crea un componente tipo listSelect con un subt�tulo y con una colecci�n de opciones
     * @param caption subt�tulo.
     * @param options colecci�n de opciones.
     * @return objeto de tipo ListSelect con subtitulo y opciones definidas.
     */
    public static ListSelectBuilder listSelect(String caption, Collection<?> options){
        return new ListSelectBuilder(new ListSelect(caption,options));
    }

     public ListSelectBuilder addAttachListener(ClientConnector.AttachListener listener){
         listSelect.addAttachListener(listener);
         return this;
     }


     public ListSelectBuilder addContextClickListener(ContextClickEvent.ContextClickListener listener){
         listSelect.addContextClickListener(listener);
         return this;
     }

     public ListSelectBuilder addDetachListener(ClientConnector.DetachListener listener){
         listSelect.addDetachListener(listener);
         return this;
     }

     public ListSelectBuilder addShortcutListener(ShortcutListener shortcut){
         listSelect.addShortcutListener(shortcut);
         return this;
     }

     public ListSelectBuilder addStyleName(String style){
         listSelect.addStyleName(style);
         return this;
     }

     public ListSelectBuilder select(Object itemId){
         listSelect.select(itemId);
         return this;
     }


     public ListSelectBuilder setRows(int rows){
         listSelect.setRows(rows);
         return this;
     }

    public ListSelectBuilder setReadOnly(boolean readOnly){
        listSelect.setReadOnly(readOnly);
        return this;
    }

    public ListSelectBuilder setCaption(String caption){
        listSelect.setCaption(caption);
        return this;
    }

    public ListSelectBuilder setWidth(String width){
        listSelect.setWidth(width);
        return this;
    }

    public ListSelectBuilder setHeight(String height){
        listSelect.setHeight(height);
        return this;
    }

    public ListSelectBuilder setData(Object data){
        listSelect.setData(data);
        return this;
    }

    public ListSelectBuilder setDescription(String description){
        listSelect.setDescription(description);
        return this;
    }

    public ListSelectBuilder setEnabled(boolean enabled){
        listSelect.setEnabled(enabled);
        return this;
    }

    public ListSelectBuilder setIcon(Resource icon){
        listSelect.setIcon(icon);
        return this;
    }

    public ListSelectBuilder setId(String id){
        listSelect.setId(id);
        return this;
    }

    public ListSelectBuilder setPrimaryStyleName(String style){
        listSelect.setPrimaryStyleName(style);
        return this;
    }

    public ListSelectBuilder setResponsive(boolean responsive){
        listSelect.setResponsive(responsive);
        return this;
    }

    public ListSelectBuilder setSizeFull(){
        listSelect.setSizeFull();
        return this;
    }

    public ListSelectBuilder setStyleName(String style){
        listSelect.setStyleName(style);
        return this;
    }

    public ListSelectBuilder setVisible(boolean visible){
        listSelect.setVisible(visible);
        return this;
    }
}
