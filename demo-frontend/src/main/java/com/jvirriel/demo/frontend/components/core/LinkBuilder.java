package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.BorderStyle;
import com.vaadin.ui.Link;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo Link.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/Link.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public final class LinkBuilder {
    /**
     * delegate
     */
    private final Link link;

    /**
     * Hide constructor, use static factory methods.
     */
    private LinkBuilder(final Link link) {
        this.link = link;
    }

    /**
     * Crea un componente Vaadin del tipo Link
     *
     * @return la instancia creada
     */
    public final Link get() {
        return link;
    }

    /**
     * Genera un componente Link vac�o.
     *
     * @return el objeto actual
     */
    public static LinkBuilder link() {
        return new LinkBuilder(new Link());
    }

    /**
     * Crea un componente Link con un texto que apunta a un a URL.
     *
     * @param caption   el texto del enlace
     * @param resource  URI a donde apunta el enlace
     * @return          el objeto actual
     */
    public static LinkBuilder link(final String caption, final Resource resource) {
        return new LinkBuilder(new Link(caption, resource));
    }

    /**
     * Crea un componente Link con un texto que apunta a una URL determinada que abre
     * una nueva ventana.
     *
     * @param caption     el texto del enlace
     * @param resource    URI a donde apunta el enlace
     * @param targetName  el nombre de la ventana destino que abrir� el enlace. Un nombre vacio indica
     *                    que el contenido de la URI se abrir� en la ventana que contiene el enlace.
     * @param width       el ancho de la ventana destino
     * @param height      el alto de la ventana destino
     * @param border      el estilo del borde de la ventana destino
     * @return
     */
    public static LinkBuilder link(String caption, Resource resource, String targetName, Integer width,
                                   Integer height, BorderStyle border) {
        return new LinkBuilder(new Link(caption, resource, targetName, width, height, border));
    }

    /**
     * (non-Javadoc)
     *
     * @param listeners
     * @return          el objeto actual
     */
    public LinkBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            link.addListener(listener);
        }
        return this;
    }

    /**
     * (non-Javadoc)
     *
     * @param shortcutListeners
     * @return
     */
    public LinkBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            link.addShortcutListener(shortcutListener);
        }
        return this;
    }

    /**
     * (non-Javadoc)
     *
     * @param attachListeners
     * @return                  el objeto actual
     */
    public LinkBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            link.addAttachListener(attachListener);
        }
        return this;
    }

    /**
     * Asigna un t�tulo visible al componente.
     *
     * @param caption   el t�tulo del componente
     * @return          el objeto actual
     */
    public LinkBuilder setCaption(final String caption) {
        link.setCaption(caption);
        return this;
    }

    /**
     * Determina si el t�tutlo es renderizado como HTMl o no.
     *
     * <p>Si el valor es verdadero entonces el t�tulo es renderizado en el navegador como HTML
     * y es reponsabilidad del desarrollador usar c�digo HTML si efectos adeversos. Si el valor
     * es falso, entonces el contenido se muestra como texto plano.</p>
     *
     * <p>El valor por defecto es falso.</p>
     *
     * @param captionAsHtml
     * @return
     */
    public LinkBuilder setCaptionAsHtml(final boolean captionAsHtml) {
        link.setCaptionAsHtml(captionAsHtml);
        return this;
    }

    /**
     * Asigna una descripci�n al componente. La misma va a ser mostrada en formato HTML en un tooltip
     * o directamente en la vista.
     *
     * @param description   the new description string for the Product.
     * @return              el objeto actual
     */
    public LinkBuilder setDescription(final String description) {
        link.setDescription(description);
        return this;
    }

    /**
     * Especifica el ancho del componente. Un n�mero negativo indica un tama�o indeterminado (la ventana es libre
     * de fijar el tama�o).
     *
     * @param width el ancho del componente
     * @return      el objeto actual
     */
    public LinkBuilder setWidth(final String width) {
        link.setWidth(width);
        return this;
    }

    /**
     * Especifica el ancoho del componente. Un �mero negativo indica un tama�o indeterminado (la ventana es libre
     * de fijar el tama�o).
     *
     * @param width el ancho del componente
     * @param unit  la unidad de medida a usar
     * @return      el objeto actual
     */
    public LinkBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        link.setWidth(width, unit);
        return this;
    }

    /**
     * Especifica la altura del componente. Un n�mero negativo indica un tama�o indeterminado (la ventana es libre
     * de fijar el tama�o).
     *
     * @param height la altura del componente
     * @return       el objeto actual
     */
    public LinkBuilder setHeight(final String height) {
        link.setHeight(height);
        return this;
    }

    /**
     * Especifica la altura del componente. Un n�mero negativo indica un tama�o indeterminado (la ventana es libre
     * de fijar el tama�o).
     *
     * @param height    la altura del componente
     * @param unit      la unidad de medida a usar
     * @return          el objeto actual
     */
    public LinkBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        link.setHeight(height, unit);
        return this;
    }

    /**
     * Activa o desactiva el componente.
     *
     * @return el objeto actual
     */
    public LinkBuilder setEnabled(final boolean enabled) {
        link.setEnabled(enabled);
        return this;
    }

    /**
     * Asigna un �cono al componente
     *
     * @param icon  el �cono a ser mostrado en el t�tulo del componente
     * @return      el objeto actual
     */
    public LinkBuilder setIcon(final Resource icon) {
        link.setIcon(icon);
        return this;
    }

    /**
     * Cambia el estilo primario del componente.
     *
     * <p>El estilo primario es el que viene por defecto de Vaadin y se aplica al especificar un tema. Para presever
     * el estilo original del componente al cambiar el estilo primario se deber�a hacer que el nuevo estilo herede
     * del estilo original usando la directiva de SASS @include.</p>
     *
     * @param primaryStyleName  el nuevo estilo primario
     * @return                  el objeto actual
     */
    public LinkBuilder setPrimaryStyleName(final String primaryStyleName) {
        link.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    /**
     * Asigna una o m�s clases de estilos al componente, reemplazando estilos previos definidos por el usuario.
     * Se pueden definir m�ltiples estilos al separarlos con un espacio.
     *
     * @param styleName la clase o clases de estilos a asignar al componente
     * @return          el objeto actual
     */
    public LinkBuilder setStyleName(final String styleName) {
        link.setStyleName(styleName);
        return this;
    }

    /**
     * Agrega o elimina un estilo. Se pueden definir m�ltiples estilos al separarlos con un espacio.
     * Si el parametro {@code add} es verdadero entonces el estilo {@code style} se agrega al componente, sino
     * se elimina del componente.
     *
     * @param styleName
     * @param add
     * @return
     */
    public LinkBuilder setStyleName(final String styleName, final boolean add) {
        link.setStyleName(styleName, add);
        return this;
    }

    /**
     * Agrega una o m�s clases de estilos al componente.
     *
     * @param styleNames    la clase o las clases de estilos a ser agregadas al componente
     * @return              el objeto actual
     */
    public LinkBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            link.addStyleName(styleName);
        }
        return this;
    }

    /**
     * Determina si un objeto es visible o no en la interfaz gr�fica.
     *
     * El efecto no es solamente cosm�tico a nivel CSS: ninguna informaci�n de un componenete invisible es enviada
     * al cliente. Es equivalente a ser removido de la interfaz.
     *
     * @param visible   valor que determina si el componente es visible o no
     * @return          el objeto actual
     */
    public LinkBuilder setVisible(final boolean visible) {
        link.setVisible(true);
        return this;
    }

    /**
     * Asigna la ventana destino donde se abrir� la URL.
     *
     * @param targetName    nombre de la ventana destino
     * @return              el objeto actual
     */
    public LinkBuilder setTargetName(final String targetName) {
        link.setTargetName(targetName);
        return this;
    }

    /**
     * Especifica el borde de la ventana destino.
     *
     * @param borderStyle   el estilo del borde
     * @return              el objeto actual
     */
    public LinkBuilder setTargetBorder(final BorderStyle borderStyle) {
        link.setTargetBorder(borderStyle);
        return this;
    }

    /**
     * Especifica el alto de la ventana destino.
     *
     * @param height    el alto de la ventana destino
     * @return          el objeto actual
     */
    public LinkBuilder setTargetHeight(final Integer height) {
        link.setTargetHeight(height);
        return this;
    }

    /**
     * Especifica el ancho de la ventana destino.
     *
     * @param width     el ancho de la ventana destino
     * @return          el objeto actual
     */
    public LinkBuilder setTargetWidth(final Integer width) {
        link.setTargetWidth(width);
        return this;
    }

    /**
     * Asigan el recurso el cual abrir� el enlace.
     *
     * @param resource  el recurso asignado
     * @return          el objeto actual
     */
    public LinkBuilder setResource(final Resource resource) {
        link.setResource(resource);
        return this;
    }

    /**
     * Especifica si el componente es responsivo o no.
     *
     * @param responsive    verdadero activa el modo responsivo; falso lo desactiva
     * @return              el objeto actual
     */
    public LinkBuilder setResponsive(final boolean responsive) {
        link.setResponsive(responsive);
        return this;
    }

    /**
     * Asigna un menssaje de error al componente.
     *
     * @param componentError    mensaje
     * @return                  el objeto actual
     */
    public LinkBuilder setComponentError(final ErrorMessage componentError) {
        link.setComponentError(componentError);
        return this;
    }

    /**
     * Asigna un Locale a un componente. Seg�n la documentaci�n de
     * <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Locale.html">Oracle</a>, un Locale representa
     * una regi�n geogr�fica, pol�tica o cultural.
     *
     * @param locale    the locale to become this Product's locale.
     * @return          el objeto actual
     */
    public LinkBuilder setLocale(final Locale locale) {
        link.setLocale(locale);
        return this;
    }

    /**
     * Asigna un ErrorHandler al componente. Este error se emite cuando sea cuando se genera
     * un error al procesar los datos qe vienen desde el cliente hasta este componente.
     *
     * @param errorHandler
     * @return              el objeto actual
     */
    public LinkBuilder setErrorHandler(final ErrorHandler errorHandler) {
        link.setErrorHandler(errorHandler);
        return this;
    }

    /**
     * Asigna un Data Object al Label. El componente no usa o modifica los datos.
     *
     * @param data  the Application specific data
     * @return      el objeto actual
     */
    public LinkBuilder setData(final Object data) {
        link.setData(data);
        return this;
    }
}