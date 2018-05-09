package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.ui.CheckBox;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/CheckBox.html">CheckBox</a>
 */
public final class CheckBoxBuilder {
    /**
     * delegate
     */
    private final CheckBox checkBox;

    /**
     * Hide constructor, use static factory methods.
     */
    private CheckBoxBuilder(final CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    /**
     * @return the created instance
     */
    public final CheckBox get() {
        return checkBox;
    }

    /**
     * Empty checkbox.
     * @return
     */
    public static CheckBoxBuilder checkBox() {
        return new CheckBoxBuilder(new CheckBox());
    }

    /**
     * Checkbox con descripci�n.
     * @param caption, checkbox descripci�n
     * @return
     */
    public static CheckBoxBuilder checkBox(final String caption) {
        return new CheckBoxBuilder(new CheckBox(caption));
    }

    /**
     * nuevo checkbox con una descripci�n y estados de conjunto inicial.
     * @param caption, checkbox descripci�n
     * @param initialState, checkbox estado inicial.
     * @return checkbox con descripci�n y estatus inicial.
     */
    public static CheckBoxBuilder checkBox(final String caption, final boolean initialState) {
        return new CheckBoxBuilder(new CheckBox(caption, initialState));
    }


    /**
     * Agrega un BlurListener al componente que se dispara cuando un campo pierde el enfoque del teclado.
     * @param blurListeners evento
     * @return checkbox con BlurListener especificado
     */
    public CheckBoxBuilder addBlurListener(final com.vaadin.event.FieldEvents.BlurListener... blurListeners) {
        for (final com.vaadin.event.FieldEvents.BlurListener blurListener : blurListeners) {
            checkBox.addBlurListener(blurListener);
        }
        return this;
    }

    /**
     * No- JavaDoc
     * @param detachListeners
     * @return
     */
    public CheckBoxBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            checkBox.addDetachListener(detachListener);
        }
        return this;
    }

    /**
     * Agrega un FocusListener al componente que se dispara cuando un campo recibe el enfoque del teclado.
     * @param focusListeners evento del focusListener
     * @return el evento del checkbox con focusListener.
     */
    public CheckBoxBuilder addFocusListener(final com.vaadin.event.FieldEvents.FocusListener... focusListeners) {
        for (final com.vaadin.event.FieldEvents.FocusListener focusListener : focusListeners) {
            checkBox.addFocusListener(focusListener);
        }
        return this;
    }

    /**
     * No-JavaDoc
     * @param shortcutListeners
     * @return
     */
    public CheckBoxBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            checkBox.addShortcutListener(shortcutListener);
        }
        return this;
    }

    /**
     * Agrega uno o m�s estilos al componente.
     * @param styleNames nombre de estilos a agregar
     * @return checkbox con uno o m�s estilos
     */
    public CheckBoxBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            checkBox.addStyleName(styleName);
        }
        return this;
    }


    /**
     *No-JavaDoc
     * @return
     */
    public CheckBoxBuilder nullSelectionAllowed() {
        return this.nullSelectionAllowed();
    }


    /**
     * Establece el subtitulo del componente.
     * @param caption descripci�n del subtitulo del componente
     * @return checkbox con subtitulo establecido
     */
    public CheckBoxBuilder setCaption(final String caption) {
        checkBox.setCaption(caption);
        return this;
    }

    /**
     * Establece el mensaje de error del componente. El mensaje puede contener ciertas etiquetas XML.
     * @param componentError mensaje de error del componente
     * @return checkbox establecido mensaje de error
     */
    public CheckBoxBuilder setComponentError(final ErrorMessage componentError) {
        checkBox.setComponentError(componentError);
        return this;
    }



    /**
     * Descripci�n del componente.
     * @param description Descripci�n del componente
     * @return checkbox con descripci�n definida
     */
    public CheckBoxBuilder setDescription(final String description) {
        checkBox.setDescription(description);
        return this;
    }

    /**
     * Establece el alto del objeto. El n�mero negativo implica un tama�o no especificado (el terminal es libre de establecer el tama�o)
     * El tama�o puede ser la longitud o el porcentaje del tama�o disponible.
     * @param enabled alto del componente.
     * @return checkbox con el alto especificado.
     */
    public CheckBoxBuilder setEnabled(final boolean enabled) {
        checkBox.setEnabled(enabled);
        return this;
    }

    /**
     * Establece el controlador de errores para el conector. El manejador de errores se env�a siempre que
     * Hay un error al procesar los datos procedentes del cliente para este conector.
     * @param errorHandler  conector
     * @return checkbox con manejador de errores.
     */
    public CheckBoxBuilder setErrorHandler(final ErrorHandler errorHandler) {
        checkBox.setErrorHandler(errorHandler);
        return this;
    }

    /**
     * Sets the height of the Product using String presentation. String presentation is similar to what is used in Cascading Style Sheets.
     * Size can be length or percentage of available size.
     * The empty string ("") or null will unset the height and set the units to pixels
     * @param height the height of the Product
     * @return the height of the Product.
     */
    public CheckBoxBuilder setHeight(final String height) {
        checkBox.setHeight(height);
        return this;
    }

    /**
     * Conjunto de componentes con iconos.
     * @param icon recurso del icono
     * @return bot�n con icono.
     */
    public CheckBoxBuilder setIcon(final Resource icon) {
        checkBox.setIcon(icon);
        return this;
    }


    /**
     * Cambios del estilo primario del componente.
     * @param primaryStyleName nombre del estilo primario del componente
     * @return checkbox con estilo primario definido
     */
    public CheckBoxBuilder setPrimaryStyleName(final String primaryStyleName) {
        checkBox.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    /**
     * Cambia el estado de s�lo lectura y ejecuta eventos de cambio de estado de s�lo lectura.
     * @param readOnly estatus de estado en solo lectura
     * @return checkbox con estatus de solo lectura.
     */
    public CheckBoxBuilder setReadOnly(final boolean readOnly) {
        checkBox.setReadOnly(readOnly);
        return this;
    }

    /**
     * Cambia la capacidad de adaptaci�n de este componente.
     * @param responsive estatus de adaptividad
     * @return checkbox con estatus de adaptabilidad definida
     */
    public CheckBoxBuilder setResponsive(final boolean responsive) {
        checkBox.setResponsive(responsive);
        return this;
    }

    /**
     * Establece uno o m�s nombres de estilos definidos por el usuario, reemplazando cualquier estilo definido por el usuario anterior
     * Multiples estilos pueden ser especificados por separado o en una lista de nombre de estilos.
     * @param styleName nombre del estilo
     * @return checkbox con los estilos especificados
     */
    public CheckBoxBuilder setStyleName(final String styleName) {
        checkBox.setStyleName(styleName);
        return this;
    }

    public CheckBoxBuilder setStyleName(String style, boolean add){
        checkBox.setStyleName(style, add);
        return this;
    }

    /**
     *No-JavaDoc
     * @param value
     * @return
     */
    public CheckBoxBuilder setValue(final boolean value) {
        checkBox.setValue(value);
        return this;
    }

    /**
     * Visibilidad del componente.
     * @param visible estatus de la visibilidad del componente
     * @return checkbox con visibilidad establecida
     */
    public CheckBoxBuilder setVisible(final boolean visible) {
        checkBox.setVisible(visible);
        return this;
    }

    /**
     * Establece el ancho del objeto. El n�mero negativo implica un tama�o no especificado (el terminal es libre de establecer el tama�o).
     * @param width ancho del objeto.
     * @return checkbox con el ancho especificado.
     */
    public CheckBoxBuilder setWidth(final String width) {
        checkBox.setWidth(width);
        return this;
    }
}