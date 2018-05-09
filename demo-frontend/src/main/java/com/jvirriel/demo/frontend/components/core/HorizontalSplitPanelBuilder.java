package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.*;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo HorizontalSplitPanel.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.6/com/vaadin/ui/HorizontalSplitPanel.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public final class HorizontalSplitPanelBuilder {
    /**
     * delegate
     */
    private final HorizontalSplitPanel horizontalSplitPanel;

    /**
     * Hide constructor, use static factory methods.
     */
    private HorizontalSplitPanelBuilder(final HorizontalSplitPanel horizontalSplitPanel) {
        this.horizontalSplitPanel = horizontalSplitPanel;
    }

    /**
     * @return the created instance
     */
    public final HorizontalSplitPanel get() {
        return horizontalSplitPanel;
    }

    /**
     * Crea un panel de división horizontal vacío.
     * @return
     */
    public static HorizontalSplitPanelBuilder horizontalSplitPanel() {
        return new HorizontalSplitPanelBuilder(new HorizontalSplitPanel());
    }

    /**
     * Crea un panel de división horizontal que contiene los componentes dados.
     * @param firstComponent - El componente a colocar a la izquierda del divisor.
     * @param secondComponent - El componente a colocar a la derecha del divisor.
     * @return
     */
    public static HorizontalSplitPanelBuilder horizontalSplitPanel(final Component firstComponent, final Component secondComponent) {
        return new HorizontalSplitPanelBuilder(new HorizontalSplitPanel(firstComponent, secondComponent));
    }

    /**
     * Agregue un componente en este contenedor. El componente se agrega a la derecha o debajo del componente anterior.
     * @param c - El componente a añadir.
     * @return
     */
    public HorizontalSplitPanelBuilder addComponent(final Component c) {
        horizontalSplitPanel.addComponent(c);
        return this;
    }

    /**
     * Registrar un oyente para manejar AbstractSplitPanel.SplitPositionChangeEvents.
     * @param listener - Listener para ser registrado.
     * @return
     */
    public HorizontalSplitPanelBuilder addSplitPositionChangeListener(final AbstractSplitPanel.SplitPositionChangeListener listener) {
        horizontalSplitPanel.addSplitPositionChangeListener(listener);
        return this;
    }

    /**
     * @param listener
     * @return
     */
    public HorizontalSplitPanelBuilder addSplitterClickListener(final AbstractSplitPanel.SplitterClickListener listener) {
        horizontalSplitPanel.addSplitterClickListener(listener);
        return this;
    }

    /**
     * Establece el primer componente de este panel dividido. Dependiendo de la dirección, el primer componente se
     * muestra en la parte superior o izquierda.
     * @param c - El componente a utilizar como primer componente.
     * @return
     */
    public HorizontalSplitPanelBuilder setFirstComponent(final Component c) {
        horizontalSplitPanel.setFirstComponent(c);
        return this;
    }

    /**
     * Bloquee la posición de SplitPanels, deshabilitando al usuario de arrastrar el identificador de división.
     * @param locked - Establezca true si está bloqueado, false en caso contrario.
     * @return
     */
    public HorizontalSplitPanelBuilder setLocked(final boolean locked) {
        horizontalSplitPanel.setLocked(locked);
        return this;
    }

    /**
     * Establece la posición máxima dividida a la posición y unidad dada. Si la posición dividida es invertida, el
     * máximo y el mínimo también se invierten.
     * @param pos - La posición máxima de la división.
     * @param unit - La unidad (de tamaño) en la que se da el tamaño. Las unidades permitidas son UNITS_PERCENTAGE y
     *             UNITS_PIXELS.
     * @return
     */
    public HorizontalSplitPanelBuilder setMaxSplitPosition(final float pos, final Sizeable.Unit unit) {
        horizontalSplitPanel.setMaxSplitPosition(pos, unit);
        return this;
    }

    /**
     * Establece la posición de división mínima en la posición y unidad dada. Si la posición dividida es invertida, el
     * máximo y el mínimo también se invierten.
     * @param pos - La posición mínima de la división.
     * @param unit - La unidad (de tamaño) en la que se da el tamaño. Las unidades permitidas son UNITS_PERCENTAGE y
     *             UNITS_PIXELS.
     * @return
     */
    public HorizontalSplitPanelBuilder setMinSplitPosition(final float pos, final Sizeable.Unit unit) {
        horizontalSplitPanel.setMaxSplitPosition(pos, unit);
        return this;
    }

    /**
     * Establece el segundo componente de este panel dividido. Dependiendo de la dirección, el segundo componente se
     * muestra en la parte inferior o derecha.
     * @param c - El componente a utilizar como segundo componente.
     * @return
     */
    public HorizontalSplitPanelBuilder setSecondComponent(final Component c) {
        horizontalSplitPanel.setSecondComponent(c);
        return this;
    }

    /**
     * Mueve la posición del divisor.
     * @param pos - El nuevo tamaño de la primera región de la unidad que se utilizó por última vez (el valor
     *            predeterminado es el porcentaje). Las fracciones sólo se permiten cuando la unidad es el porcentaje.
     * @return
     */
    public HorizontalSplitPanelBuilder setSplitPosition(final float pos) {
        horizontalSplitPanel.setSplitPosition(pos);
        return this;
    }

    /**
     * Mueve la posición del divisor.
     * @param pos - El nuevo tamaño de la región en la unidad que se utilizó por última vez (por defecto es el
     *            porcentaje). Las fracciones sólo se permiten cuando la unidad es el porcentaje.
     * @param reverse - Si se ajusta a verdadero, la posición divisora dividida se mide por la segunda región, si no
     *                se mide por la primera región.
     * @return
     */
    public HorizontalSplitPanelBuilder setSplitPosition(final float pos, final boolean reverse) {
        horizontalSplitPanel.setSplitPosition(pos, reverse);
        return this;
    }

    /**
     * Mueve la posición del divisor con la posición dada y la unidad.
     * @param pos - El nuevo tamaño de la primera región. Las fracciones sólo se permiten cuando la unidad es el
     *            porcentaje.
     * @param unit - La unidad (de tamaño) en la que se da el tamaño.
     * @return
     */
    public HorizontalSplitPanelBuilder setSplitPosition(final float pos, final Sizeable.Unit unit) {
        horizontalSplitPanel.setSplitPosition(pos, unit);
        return this;
    }

    /**
     * Mueve la posición del divisor con la posición dada y la unidad.
     * @param pos - El nuevo tamaño de la primera región. Las fracciones sólo se permiten cuando la unidad es el
     *            porcentaje.
     * @param unit - La unidad (de tamaño) en la que se da el tamaño.
     * @param reverse - Si se ajusta a verdadero, la posición divisora dividida se mide por la segunda región, si no se
     *                mide por la primera región.
     * @return
     */
    public HorizontalSplitPanelBuilder setSplitPosition(final float pos, final Sizeable.Unit unit, final boolean reverse) {
        horizontalSplitPanel.setSplitPosition(pos, unit, reverse);
        return this;
    }

    /**
     * Escucha los eventos de adjuntar componentes.
     * @param listener - El oyente para agregar, no nulo
     * @return
     */
    public HorizontalSplitPanelBuilder addComponentAttachListener(final HasComponents.ComponentAttachListener listener) {
        horizontalSplitPanel.addComponentAttachListener(listener);
        return this;
    }

    /**
     * Escucha los eventos de separación de componentes.
     * @param listener
     * @return
     */
    public HorizontalSplitPanelBuilder addComponentDetachListener(final HasComponents.ComponentDetachListener listener) {
        horizontalSplitPanel.addComponentDetachListener(listener);
        return this;
    }

    /**
     * Agrega los componentes en el orden dado a este contenedor de componentes.
     * @param components - Los componentes a añadir.
     * @return
     */
    public HorizontalSplitPanelBuilder addComponents(final Component... components) {
        horizontalSplitPanel.addComponents(components);
        return this;
    }

    /**
     * Establece la altura del objeto. El número negativo implica un tamaño no especificado (el terminal es libre de
     * establecer el tamaño).
     * @param height - La altura del objeto.
     * @param unit - La unidad utilizada para el ancho.
     * @return
     */
    public HorizontalSplitPanelBuilder setHeight(final float height, final Sizeable.Unit unit) {
        horizontalSplitPanel.setHeight(height, unit);
        return this;
    }

    /**
     * Sets the width of the object. Negative number implies unspecified size (terminal is free to set the size).
     * @param width - El ancho del objeto.
     * @param unit - La unidad utilizada para el ancho.
     * @return
     */
    public HorizontalSplitPanelBuilder setWidth(final float width, final Sizeable.Unit unit) {
        horizontalSplitPanel.setWidth(width, unit);
        return this;
    }

    /**
     * Agrega un oyente de clics de contexto que se notifica cuando se produce un clic de contexto.
     * @param listener - Agrega un oyente de clics de contexto que se notifica cuando se produce un clic de contexto.
     * @return
     */
    public HorizontalSplitPanelBuilder addContextClickListener(final ContextClickEvent.ContextClickListener listener) {
        horizontalSplitPanel.addContextClickListener(listener);
        return this;
    }

    /**
     * Registra un nuevo componente de componente (genérico) para el componente.
     * @param listener - El nuevo Listener que se va a registrar.
     * @return
     */
    public HorizontalSplitPanelBuilder addListener(final Component.Listener listener) {
        horizontalSplitPanel.addListener(listener);
        return this;
    }

    /**
     * @param shortcut
     * @return
     */
    public HorizontalSplitPanelBuilder addShortcutListener(final ShortcutListener shortcut) {
        horizontalSplitPanel.addShortcutListener(shortcut);
        return this;
    }

    /**
     * Agrega uno o más nombres de estilos a este componente. Se pueden especificar varios estilos como una lista de
     * nombres de estilos separados por espacios. El nombre del estilo se renderizará como un nombre de clase HTML,
     * que se puede utilizar en una definición CSS.
     * @param style - El nuevo estilo que se agregará al componente.
     * @return
     */
    public HorizontalSplitPanelBuilder addStyleName(final String style) {
        horizontalSplitPanel.addStyleName(style);
        return this;
    }

    /**
     * Establece el título del componente.
     * @param caption - El nuevo título para el componente. Si el título es nulo, no se muestra ninguna leyenda y
     *                normalmente no ocupa ningún espacio.
     * @return
     */
    public HorizontalSplitPanelBuilder setCaption(final String caption) {
        horizontalSplitPanel.setCaption(caption);
        return this;
    }

    /**
     * Establece si el subtítulo se representa como HTML.
     Si se establece en true, los subtítulos se representan en el navegador como HTML y el desarrollador es responsable
     de garantizar que no se utilice HTML dañino. Si se establece en false, el subtítulo se representa en el navegador
     como texto sin formato.
     El valor por defecto es falso, es decir, para que el título sea texto sin formato.
     * @param captionAsHtml - True si los subtítulos se representan como HTML, false si se procesan como texto sin
     *                      formato.
     * @return
     */
    public HorizontalSplitPanelBuilder setCaptionAsHtml(final boolean captionAsHtml) {
        horizontalSplitPanel.setCaptionAsHtml(captionAsHtml);
        return this;
    }

    /**
     * Establece el mensaje de error del componente. El mensaje puede contener ciertas etiquetas XML, para obtener más
     * información, consulte.
     * @param componentError - El nuevo ErrorMessage del componente.
     * @return
     */
    public HorizontalSplitPanelBuilder setComponentError(final ErrorMessage componentError) {
        horizontalSplitPanel.setComponentError(componentError);
        return this;
    }

    /**
     * Establece el objeto de datos, que se puede utilizar para cualquier aplicación de datos específicos. El componente
     * no utiliza ni modifica estos datos.
     * @param data - Los datos específicos de la aplicación.
     * @return
     */
    public HorizontalSplitPanelBuilder setData(final Object data) {
        horizontalSplitPanel.setData(data);
        return this;
    }

    /**
     * Establece la descripción del componente. Vea getDescription () para más información sobre cuál es la descripción.
     * @param description - La nueva cadena de descripción del componente.
     * @return
     */
    public HorizontalSplitPanelBuilder setDescription(final String description) {
        horizontalSplitPanel.setDescription(description);
        return this;
    }

    /**
     * Establece la descripción del componente utilizando el modo de contenido determinado. Vea getDescription () para
     * más información sobre cuál es la descripción.
     Si el modo de contenido es ContentMode.HTML, la descripción se muestra como HTML en sugerencias de herramientas o
     directamente en determinados componentes, por lo que debe tenerse cuidado de no crear la posibilidad de inyección
     de HTML y, posiblemente, vulnerabilidades XSS.
     * @param description - La nueva cadena de descripción del componente.
     * @param mode - El modo de contenido para la descripción.
     * @return
     */
    public HorizontalSplitPanelBuilder setDescription(final String description, final ContentMode mode) {
        horizontalSplitPanel.setDescription(description, mode);
        return this;
    }

    /**
     * Activa o desactiva el componente. El usuario no puede interactuar con componentes deshabilitados, que se muestran
     * con un estilo que indica el estado, normalmente sombreado en color gris claro. Los componentes están habilitados
     * de forma predeterminada.
     * @param enabled - Un valor booleano que especifica si el componente debe estar habilitado o no.
     * @return
     */
    public HorizontalSplitPanelBuilder setEnabled(final boolean enabled) {
        horizontalSplitPanel.setEnabled(enabled);
        return this;
    }

    /**
     * Establece la altura del componente utilizando la presentación String. La presentación de cadenas es similar a lo
     * que se utiliza en hojas de estilo en cascada. El tamaño puede ser la longitud o el porcentaje del tamaño
     * disponible. La cadena vacía ("") o null anulará la altura y establecerá las unidades en píxeles. Vea la
     * especificación CSS para más detalles.
     * @param height - En la representación de la cadena de estilo CSS
     * @return
     */
    public HorizontalSplitPanelBuilder setHeight(final String height) {
        horizontalSplitPanel.setHeight(height);
        return this;
    }

    /**
     * Borra cualquier altura definida.
     * @return
     */
    public HorizontalSplitPanelBuilder setHeightUndefined() {
        horizontalSplitPanel.setHeightUndefined();
        return this;
    }

    /**
     * Establece el icono del componente.
     * @param icon - El icono que se mostrará con el subtítulo del componente.
     * @return
     */
    public HorizontalSplitPanelBuilder setIcon(final Resource icon) {
        horizontalSplitPanel.setIcon(icon);
        return this;
    }

    /**
     * Agrega un identificador único para el componente que se utiliza en el cliente para fines de prueba. Mantener
     * identificadores únicos es responsabilidad del programador.
     * @param id - Una identificación alfanumérica
     * @return
     */
    public HorizontalSplitPanelBuilder setId(final String id) {
        horizontalSplitPanel.setId(id);
        return this;
    }

    /**
     * Establece la configuración regional de este componente.
     * @param locale - La configuración regional para convertirse en la configuración regional de este componente.
     * @return
     */
    public HorizontalSplitPanelBuilder setLocale(final Locale locale) {
        horizontalSplitPanel.setLocale(locale);
        return this;
    }

    /**
     * Establece el conector padre del componente.
     * @param parent - El conector padre.
     * @return
     */
    public HorizontalSplitPanelBuilder setParent(final HasComponents parent) {
        horizontalSplitPanel.setParent(parent);
        return this;
    }

    /**
     * Cambia el nombre del estilo principal del componente.
     El nombre de estilo principal identifica el componente al aplicar el tema CSS al Componente. Al cambiar el nombre
     del estilo, todas las reglas de CSS dirigidas a ese nombre de estilo ya no se aplicarán y podría resultar en que
     el componente no funcione correctamente.
     Para conservar el estilo original del componente al cambiar a un nuevo estilo principal, debe hacer que su nuevo
     estilo primario herede el estilo primario antiguo utilizando la directiva SIN @include. Vea más en los tutoriales
     de SASS.
     * @param style - El nuevo nombre de estilo principal.
     * @return
     */
    public HorizontalSplitPanelBuilder setPrimaryStyleName(final String style) {
        horizontalSplitPanel.setPrimaryStyleName(style);
        return this;
    }

    /**
     * Cambia la capacidad de respuesta de este componente.
     * @param responsive - Boolean permite respuesta, false inhabilita.
     * @return
     */
    public HorizontalSplitPanelBuilder setResponsive(final boolean responsive) {
        horizontalSplitPanel.setResponsive(responsive);
        return this;
    }

    /**
     * Establece el tamaño a 100% x 100%.
     * @return
     */
    public HorizontalSplitPanelBuilder setSizeFull() {
        horizontalSplitPanel.setSizeFull();
        return this;
    }

    /**
     * Borra cualquier configuración de tamaño.
     * @return
     */
    public HorizontalSplitPanelBuilder setSizeUndefined() {
        horizontalSplitPanel.setSizeUndefined();
        return this;
    }

    /**
     * Establece uno o más nombres de estilos definidos por el usuario del componente, reemplazando cualquier estilo
     * definido por el usuario anterior. Se pueden especificar varios estilos como una lista de nombres de estilos
     * separados por espacios. Los nombres de estilo deben ser nombres de clases CSS válidos y no deben entrar en
     * conflicto con ningún nombre de estilo incorporado en Vaadin o GWT.
     * @param style - El nuevo estilo o estilos del componente como una lista separada por espacios.
     * @return
     */
    public HorizontalSplitPanelBuilder setStyleName(final String style) {
        horizontalSplitPanel.setStyleName(style);
        return this;
    }

    /**
     * Agrega o quita un nombre de estilo. Se pueden especificar varios estilos como una lista de nombres de estilos
     * separados por espacios. Si el parámetro add es verdadero, el nombre del estilo se agrega al componente. Si el
     * parámetro add es falso, el nombre de estilo se elimina del componente.
     * @param style - El nombre del estilo que se va a agregar o quitar.
     * @param add - True para agregar el estilo dado, false para eliminarlo.
     * @return
     */
    public HorizontalSplitPanelBuilder setStyleName(final String style, final boolean add) {
        horizontalSplitPanel.setStyleName(style, add);
        return this;
    }

    /**
     * Establece la visibilidad del componente.
     * @param visible - El valor booleano que especifica si el componente debe estar visible después de la llamada o no.
     * @return
     */
    public HorizontalSplitPanelBuilder setVisible(final boolean visible) {
        horizontalSplitPanel.setVisible(visible);
        return this;
    }

    /**
     * Establece el ancho del componente utilizando la presentación String. La presentación de cadenas es similar a lo
     * que se utiliza en hojas de estilo en cascada. El tamaño puede ser la longitud o el porcentaje del tamaño
     * disponible. La cadena vacía ("") o null anulará el ancho y establecerá las unidades en píxeles. Vea la
     * especificación CSS para más detalles.
     * @param width - En la representación de cadena de estilo CSS, cadena nula o vacía para restablecer
     * @return
     */
    public HorizontalSplitPanelBuilder setWidth(final String width) {
        horizontalSplitPanel.setWidth(width);
        return this;
    }

    /**
     * Borra cualquier ancho definido
     * @return
     */
    public HorizontalSplitPanelBuilder setWidthUndefined() {
        horizontalSplitPanel.setWidthUndefined();
        return this;
    }

    /**
     * Agregue un detector para eventos de conexión del conector.
     * @param listener - Registro para cancelar el registro del listener
     * @return
     */
    public HorizontalSplitPanelBuilder addAttachListener(final ClientConnector.AttachListener listener) {
        horizontalSplitPanel.addAttachListener(listener);
        return this;
    }

    /**
     * Agregue un escucha para eventos de separación de conector.
     * @param listener - Registro para cancelar el registro del listener.
     * @return
     */
    public HorizontalSplitPanelBuilder addDetachListener(final ClientConnector.DetachListener listener) {
        horizontalSplitPanel.addDetachListener(listener);
        return this;
    }

    /**
     * Registra un nuevo oyente con el método de activación especificado para escuchar los eventos generados por este
     * componente. Si el método de activación no tiene argumentos, el objeto de evento no se pasará a él cuando se llame.
     * @param eventType - El tipo de evento escuchado. Los eventos de este tipo o sus subclases activan al oyente.
     * @param target - La instancia del objeto que posee el método de activación.
     * @param method - El método de activación.
     * @return
     */
    public HorizontalSplitPanelBuilder addListener(final Class<?> eventType, final Object target, final Method method) {
        horizontalSplitPanel.addListener(eventType, target, method);
        return this;
    }

    /**
     * Establece el controlador de errores para el conector. El manejador de errores se distribuye cada vez que hay un
     * error de procesamiento de los datos procedentes del cliente para este conector.
     * @param errorHandler - El controlador de errores para este conector.
     * @return
     */
    public HorizontalSplitPanelBuilder setErrorHandler(final ErrorHandler errorHandler) {
        horizontalSplitPanel.setErrorHandler(errorHandler);
        return this;
    }
}



