package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.Resource;
import com.vaadin.ui.ComboBox;
import org.json.simple.ItemList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 *  Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/ComboBox.html">ComboBox</a>
 *
 *  Clase n�cleo para el ComboBox nativo y todas sus propiedades.
 */
public final class ComboBoxBuilder {

    /**
     * delegate
     */
    private final ComboBox comboBox;

    /**
     * Hide constructor, use static factory methods.
     */
    private ComboBoxBuilder(final ComboBox comboBox) {
        this.comboBox = comboBox;
    }

    /**
     * @return the created instance
     */
    public final ComboBox get() {
        return comboBox;
    }

    /**
     * Constructor de comboBox vac�o
     * @return nuevo comboBox vac�o.
     */
    public static ComboBoxBuilder comboBox() {
        return new ComboBoxBuilder(new ComboBox());
    }

    /**
     * Constructor de comboBox con subtitulo y colecci�n de opciones.
     * @param caption descripci�n del subtitulo.
     * @param options opciones.
     * @return comboBox con subtitulo y datos establecidos.
     */
    public static ComboBoxBuilder comboBox(final String caption, final Collection<?> options) {
        return new ComboBoxBuilder(new ComboBox(caption, options));
    }

    /**
     * Constructor de comboBox con subtitulo
     * @param caption descripci�n del subtitulo.
     * @return checkbox con subtitulo.
     */
    public static ComboBoxBuilder comboBox(final String caption) {

        return new ComboBoxBuilder(new ComboBox(caption));
    }

    /**
     * Agrega un BlurListener al componente que se dispara cuando un campo pierde el enfoque del teclado.
     * @param blurListeners evento
     * @return comboBox con BlurListener especificado
     */
    public ComboBoxBuilder addBlurListener(final com.vaadin.event.FieldEvents.BlurListener... blurListeners) {
        for (final com.vaadin.event.FieldEvents.BlurListener blurListener : blurListeners) {
            comboBox.addBlurListener(blurListener);
        }
        return this;
    }

    /**
     * (non-Javadoc)
     * @param shortcutListeners
     * @return
     */
    public ComboBoxBuilder addShortcutListener(final ShortcutListener... shortcutListeners) {
        for (final ShortcutListener shortcutListener : shortcutListeners) {
            comboBox.addShortcutListener(shortcutListener);
        }
        return this;
    }

    /**
     * No-Javadoc
     * @param attachListeners
     * @return
     */
    public ComboBoxBuilder addAttachListener(final com.vaadin.server.ClientConnector.AttachListener... attachListeners) {
        for (final com.vaadin.server.ClientConnector.AttachListener attachListener : attachListeners) {
            comboBox.addAttachListener(attachListener);
        }
        return this;
    }

    /**
     * Agregar eventos a los componentes
     * @param listeners evento a ser registrado.
     * @return
     */
    public ComboBoxBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            comboBox.addListener(listener);
        }
        return this;
    }

    public ComboBoxBuilder setItems(List items) {
        comboBox.setItems(items);
        return this;
    }

    public ComboBoxBuilder setItems(ItemList... items) {
        comboBox.setItems(items);
        return this;
    }

    public ComboBoxBuilder setItems(Stream items) {
        comboBox.setItems(items);
        return this;
    }

    public ComboBoxBuilder setPlaceholder(String placeholder)
    {
        comboBox.setPlaceholder(placeholder);
        return this;
    }

    /**
     * Agrega un FocusListener al componente que se dispara cuando un campo recibe el enfoque del teclado.
     * @param focusListeners evento a enfocar.
     * @return comboBox con evento de enfoque.
     */
    public ComboBoxBuilder addFocusListener(final com.vaadin.event.FieldEvents.FocusListener... focusListeners) {
        for (final com.vaadin.event.FieldEvents.FocusListener focusListener : focusListeners) {
            comboBox.addFocusListener(focusListener);
        }
        return this;
    }

    /**
     * Agrega uno o m�s estilos al componente.
     * @param styleNames estilo a registrar
     * @return comboBox con estilos especificados.
     */
    public ComboBoxBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            comboBox.addStyleName(styleName);
        }
        return this;
    }

    /**
     *No-Javadoc
     * @param detachListeners
     * @return
     */
    public ComboBoxBuilder addDetachListener(final com.vaadin.server.ClientConnector.DetachListener... detachListeners) {
        for (final com.vaadin.server.ClientConnector.DetachListener detachListener : detachListeners) {
            comboBox.addDetachListener(detachListener);
        }
        return this;
    }

    /**
     * Establece el ancho del objeto. El n�mero negativo implica un tama�o no especificado (el terminal es libre de establecer el tama�o).
     * @param width ancho del objeto.
     * @return comboBox con el ancho especificado.
     */
    public ComboBoxBuilder setWidth(final String width) {
        comboBox.setWidth(width);
        return this;
    }

    /**
     * Habilitar o deshabilitar componentes
     * @param enabled estatus booleano que especifica si el componente esta habilitado o no
     * @return comboBox habilitado o no.
     */
    public ComboBoxBuilder setEnabled(final boolean enabled) {
        comboBox.setEnabled(enabled);
        return this;
    }

    /**
     * Sets the empty selection caption.
     The empty string "" is the default empty selection caption.

     If empty selection is allowed via the setEmptySelectionAllowed(boolean)
     method (it is by default) then the empty item will be shown with the given caption.
     * @param caption - the caption to set, not null
     * @return
     */
    public ComboBoxBuilder setEmptySelectionCaption(final String caption) {
        comboBox.setEmptySelectionCaption(caption);
        return this;
    }

    /**
     * No -Javadoc
     * @param textInputAllowed
     * @return
     */
    public ComboBoxBuilder setTextInputAllowed(final boolean textInputAllowed) {
        comboBox.setTextInputAllowed(textInputAllowed);
        return this;
    }

    /**
     * Establece la configuraci�n regional de este componente.
     * @param locale La configuraci�n regional para convertirse en la configuraci�n regional de este componente.
     * @return comboBox con la regi�n configurada.
     */
    public ComboBoxBuilder setLocale(final Locale locale) {
        comboBox.setLocale(locale);
        return this;
    }

    /**
     * Establece el �ndice tabulador del componente Focusable.
     * La propiedad �ndice de ficha se utiliza para especificar el orden en el que se enfocan los campos cuando el usuario presiona la tecla Tabulador.
     * Los componentes con un �ndice de tabulaci�n definido se enfocan primero secuencialmente y luego los componentes sin �ndice de tabulaci�n.
     * @param tabIndex el �ndice tabulador
     * @return comboBox con el �ndice del tabulador enfocables.
     */
    public ComboBoxBuilder setTabIndex(final int tabIndex) {
        comboBox.setTabIndex(tabIndex);
        return this;
    }

    /**
     * Establece el objeto de datos, que se puede utilizar para cualquier aplicaci�n de datos espec�ficos.
     * El componente no utiliza ni modifica estos datos.
     * @param data La data espec�fica de la aplicaci�n
     * @return comboBox con la data espec�fica.
     */
    public ComboBoxBuilder setData(final Object data) {
        comboBox.setData(data);
        return this;
    }

    /**
     * Sets the height of the Product using String presentation. String presentation is similar to what is used in Cascading Style Sheets.
     * Size can be length or percentage of available size.
     * The empty string ("") or null will unset the height and set the units to pixels
     * @param height the height of the Product
     * @return the height of the Product.
     */
    public ComboBoxBuilder setHeight(final String height) {
        comboBox.setHeight(height);
        return this;
    }

    /**
     * Establece si se debe desplazar el elemento seleccionado visible (abrir directamente la p�gina en la que se encuentra)
     * al abrir el men� emergente de cuadro combinado o no. S�lo se aplica al modo de selecci�n �nica.
     * Esto requiere encontrar el �ndice del art�culo, que puede ser costoso en muchos grandes contenedores de carga perezosos.
     * @param scrollToSelectedItem True para encontrar la p�gina con el elemento seleccionado al abrir la ventana emergente de selecci�n
     * @return comboBox con scrol para item seleccionado.
     */
    public ComboBoxBuilder setScrollToSelectedItem(final boolean scrollToSelectedItem) {
        comboBox.setScrollToSelectedItem(scrollToSelectedItem);
        return this;
    }

    /**
     *
     * Visibilidad del componente.
     * @param visible estatus de la visibilidad del componente
     * @return comboBox con visibilidad establecida
     */
    public ComboBoxBuilder setVisible(final boolean visible) {
        comboBox.setVisible(visible);
        return this;
    }

    /**
     * Establece la longitud de la p�gina para la ventana emergente de sugerencias.
     * Si se establece la longitud de la p�gina en 0, se inhabilitar� la funci�n de paginaci�n emergente de sugerencias (todos los elementos visibles)
     * @param pageLength La longitud de la p�gina por establecer
     * @return comboBox con la longitud de la pagina establecida.
     */
    public ComboBoxBuilder setPageLength(final int pageLength) {
        comboBox.setPageLength(pageLength);
        return this;
    }

    public ComboBoxBuilder setSizeUndefined() {
        comboBox.setSizeUndefined();
        return this;
    }

    /**
     * Establece uno o m�s nombres de estilos definidos por el usuario, reemplazando cualquier estilo definido por el usuario anterior
     * Multiples estilos pueden ser especificados por separado o en una lista de nombre de estilos.
     * @param styleName nombre del estilo
     * @return comboBox con los estilos especificados
     */
    public ComboBoxBuilder setStyleName(final String styleName) {
        comboBox.setStyleName(styleName);
        return this;
    }

    /**
     * Establece el controlador de errores para el conector. El manejador de errores se env�a siempre que
     * Hay un error al procesar los datos procedentes del cliente para este conector.
     * @param errorHandler  conector
     * @return comboBox con manejador de errores.
     */
    public ComboBoxBuilder setErrorHandler(final ErrorHandler errorHandler) {
        comboBox.setErrorHandler(errorHandler);
        return this;
    }

    /**
     * Establece el mensaje de error del componente. El mensaje puede contener ciertas etiquetas XML
     * @param componentError El nuevo mensaje de errror del componente
     * @return comboBox con mensaje de error.
     */
    public ComboBoxBuilder setComponentError(final ErrorMessage componentError) {
        comboBox.setComponentError(componentError);
        return this;
    }


    /**
     * Cambios del estilo primario del componente.
     * @param primaryStyleName nombre del estilo primario del componente
     * @return combobox con estilo primario definido
     */
    public ComboBoxBuilder setPrimaryStyleName(final String primaryStyleName) {
        comboBox.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    /**
     * Conjunto de componentes con iconos.
     * @param icon recurso del icono
     * @return comboBox con icono.
     */
    public ComboBoxBuilder setIcon(final Resource icon) {
        comboBox.setIcon(icon);
        return this;
    }

    /**
     * Descripci�n del componente.
     * @param description Descripci�n del componente
     * @return comboBox con descripci�n definida
     */
    public ComboBoxBuilder setDescription(final String description) {
        comboBox.setDescription(description);
        return this;
    }


    /**
     * Cambia el estado de s�lo lectura y ejecuta eventos de cambio de estado de s�lo lectura.
     * @param readOnly estatus de estado en solo lectura
     * @return comboBox con estatus de solo lectura.
     */
    public ComboBoxBuilder setReadOnly(final boolean readOnly) {
        comboBox.setReadOnly(readOnly);
        return this;
    }

    /**
     * El manejador de nuevos elementos que se llama cuando el usuario agrega un nuevo elemento en el modo newItemAllowed.
     * @param newItemHandler nuevo manejador a utilizar
     * @return comboBox con el nuevo manejar del item.
     */
    public ComboBoxBuilder setNewItemHandler(final ComboBox.NewItemHandler newItemHandler) {
        comboBox.setNewItemHandler(newItemHandler);
        return this;
    }

    /**
     * El valor de la selecci�n es el id de elemento seleccionado.
     * Si la selecci�n est� en modo multiselect, el valor es un conjunto de teclas de elementos seleccionados.
     * En el modo multiselect se pueden asignar todas las colecciones de id
     * @param value valor del objeto a seleccionar
     * @return comboBox con Objetos seleccionados.
     */
    public ComboBoxBuilder setValue(final Object value) {
        comboBox.setValue(value);
        return this;
    }

    /**
     * Establece los subtitulos del componente.
     * @param caption susbtitulo a utilizar.
     * @return comboBox con sustitulo definido.
     */
    public ComboBoxBuilder setCaption(final String caption) {
        comboBox.setCaption(caption);
        return this;
    }

    /**
     * Cambia la capacidad de adaptaci�n de este componente.
     * @param responsive estatus de adaptividad
     * @return comboBox con estatus de adaptabilidad definida
     */
    public ComboBoxBuilder setResponsive(final boolean responsive) {
        comboBox.setResponsive(responsive);
        return this;
    }
}
