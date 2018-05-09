package com.jvirriel.demo.frontend.components.core;


import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/Label.html">Label</a>
 * <p>
 */
public final class LabelBuilder {

    private final Label label;

    /**
     * Hide constructor, use static factory methods.
     */
    private LabelBuilder(final Label label) {
        this.label = label;
    }

    /**
     * Crea un componente Vaadin del tipo Label.
     *
     * @return la instancia creada
     */
    public final Label get() {
        return label;
    }

    /**
     * Genera un componente Label vacío.
     *
     * @return el obejto actual
     */
    public static LabelBuilder label() {
        return new LabelBuilder(new Label());
    }

    /**
     * Crea un componente Label con un texto a mostrar.
     *
     * @param caption el texto a ser mostrado en el componente
     * @return el objeto actual
     */
    public static LabelBuilder label(final String caption) {
        return new LabelBuilder(new Label(caption));
    }


    /**
     * Crea un nuevo componente Label con un texto a mostrar en un modo determinado (HTML, pre formateado o texto plano).
     *
     * @param caption     el texto a mostrar
     * @param contentMode el modo en que se muestra el texto
     * @return el objeto actual
     */
    public static LabelBuilder label(final String caption, final ContentMode contentMode) {
        return new LabelBuilder(new Label(caption, contentMode));
    }

    /**
     * (non-Javadoc)
     *
     * @param attachListeners
     * @return el objeto actual
     */
    public LabelBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            label.addAttachListener(attachListener);
        }
        return this;
    }

    /**
     * (non-Javadoc)
     *
     * @param detachListeners
     * @return el objeto actual
     */
    public LabelBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            label.addDetachListener(detachListener);
        }
        return this;
    }

    public LabelBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            label.addListener(listener);
        }
        return this;
    }

    /**
     * (non-Javadoc)
     *
     * @param shortcutListeners
     * @return
     */
    public LabelBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            label.addShortcutListener(shortcutListener);
        }
        return this;
    }

    /**
     * Agrega una o más clases de estilos al componente.
     *
     * @param styleNames la clase o las clases de estilos a ser agregadas al componente
     * @return el objeto actual
     */
    public LabelBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            label.addStyleName(styleName);
        }
        return this;
    }

    /**
     * Especifica el ancho del componente. Un número negativo indica un tamaño indeterminado (la ventana es libre
     * de fijar el tamaño).
     *
     * @param width el ancho del componente
     * @return el objeto actual
     */
    public LabelBuilder setWidth(final String width) {
        label.setWidth(width);
        return this;
    }

    /**
     * Especifica el ancoho del componente. Un úmero negativo indica un tamaño indeterminado (la ventana es libre
     * de fijar el tamaño).
     *
     * @param width el ancho del componente
     * @param unit  la unidad de medida a usar
     * @return el objeto actual
     */
    public LabelBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        label.setWidth(width, unit);
        return this;
    }

    /**
     * Activa o desactiva el componente.
     *
     * @return el objeto actual
     */
    public LabelBuilder setEnabled(final boolean enabled) {
        label.setEnabled(enabled);
        return this;
    }

    /**
     * Asigna un Locale a un componente. Según la documentación de
     * <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Locale.html">Oracle</a>, un Locale representa
     * una región geográfica, política o cultural.
     *
     * @param locale the locale to become this Product's locale.
     * @return el objeto actual
     */
    public LabelBuilder setLocale(final Locale locale) {
        label.setLocale(locale);
        return this;
    }

    /**
     * Asigna un ErrorHandler al componente. Este error se emite cuando sea cuando se genera
     * un error al procesar los datos qe vienen desde el cliente hasta este componente.
     *
     * @param errorHandler
     * @return el objeto actual
     */
    public LabelBuilder setErrorHandler(final ErrorHandler errorHandler) {
        label.setErrorHandler(errorHandler);
        return this;
    }

    /**
     * Asigna un Data Object al Label. El componente no usa o modifica los datos.
     *
     * @param data the Application specific data
     * @return el objeto actual
     */
    public LabelBuilder setData(final Object data) {
        label.setData(data);
        return this;
    }

    /**
     * Asigna un mensaje de error al componente. El mismo pude contener etiquetas XML.
     *
     * @param componentError the new ErrorMessage of the Product.
     * @return el objeto actual
     */
    public LabelBuilder setComponentError(final ErrorMessage componentError) {
        label.setComponentError(componentError);
        return this;
    }

    /**
     * Cambia el estilo primario del componente.
     * <p>
     * <p>El estilo primario es el que viene por defecto de Vaadin y se aplica al especificar un tema. Para presever
     * el estilo original del componente al cambiar el estilo primario se debería hacer que el nuevo estilo herede
     * del estilo original usando la directiva de SASS @include.</p>
     *
     * @param primaryStyleName el nuevo estilo primario
     * @return el objeto actual
     */
    public LabelBuilder setPrimaryStyleName(final String primaryStyleName) {
        label.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public LabelBuilder setSizeUndefined() {
        label.setSizeUndefined();
        return this;
    }

    /**
     * Asigna una o más clases de estilos al componente, reemplazando estilos previos definidos por el usuario.
     * Se pueden definir múltiples estilos al separarlos con un espacio.
     *
     * @param style la clase o clases de estilos a asignar al componente
     * @return el objeto actual
     */
    public LabelBuilder setStyleName(final String style) {
        label.setStyleName(style);
        return this;
    }

    /**
     * Agrega o elimina un estilo. Se pueden definir múltiples estilos al separarlos con un espacio.
     * Si el parametro {@code add} es verdadero entonces el estilo {@code style} se agrega al componente, sino
     * se elimina del componente.
     *
     * @param style
     * @param add
     * @return
     */
    public LabelBuilder setStyleName(final String style, final boolean add) {
        label.setStyleName(style, add);
        return this;
    }

    /**
     * Asigna un ícono al componente
     *
     * @param icon el ícono a ser mostrado en el título del componente
     * @return el objeto actual
     */
    public LabelBuilder setIcon(final Resource icon) {
        label.setIcon(icon);
        return this;
    }

    /**
     * Especifica la altura del componente. Un número negativo indica un tamaño indeterminado (la ventana es libre
     * de fijar el tamaño).
     *
     * @param height la altura del componente
     * @return el objeto actual
     */
    public LabelBuilder setHeight(final String height) {
        label.setHeight(height);
        return this;
    }

    /**
     * Especifica la altura del componente. Un número negativo indica un tamaño indeterminado (la ventana es libre
     * de fijar el tamaño).
     *
     * @param height la altura del componente
     * @param unit   la unidad de medida a usar
     * @return el objeto actual
     */
    public LabelBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        label.setHeight(height, unit);
        return this;
    }

    /**
     * Asigna una descripción al componente. La misma va a ser mostrada en formato HTML en un tooltip
     * o directamente en la vista.
     *
     * @param description the new description string for the Product.
     * @return el objeto actual
     */
    public LabelBuilder setDescription(final String description) {
        label.setDescription(description);
        return this;
    }

    /**
     * Determina si un objeto es visible o no en la interfaz gráfica.
     * <p>
     * El efecto no es solamente cosmético a nivel CSS: ninguna información de un componenete invisible es enviada
     * al cliente. Es equivalente a ser removido de la interfaz.
     *
     * @param visible valor que determina si el componente es visible o no
     * @return el objeto actual
     */
    public LabelBuilder setVisible(final boolean visible) {
        label.setVisible(visible);
        return this;
    }

    /**
     * Especifica el modo (HTML, texto plano o preformateado) en que se mostrará el contenido del componente.
     *
     * @param contentMode
     * @return el objeto actual
     */
    public LabelBuilder setContentMode(final ContentMode contentMode) {
        label.setContentMode(contentMode);
        return this;
    }

    /**
     * Asigna un título visible al componente.
     *
     * @param caption el título del componente
     * @return el objeto actual
     */
    public LabelBuilder setCaption(final String caption) {
        label.setCaption(caption);
        return this;
    }

    /**
     * Define el texto a mostrarse en el Label.
     *
     * @param newValue el nuevo texto del componente Label
     * @return el objeto actual
     */
    public LabelBuilder setValue(final String newValue) {
        label.setValue(newValue);
        return this;
    }

    public LabelBuilder removeStyleName(String style) {
        label.removeStyleName(style);
        return this;
    }

}