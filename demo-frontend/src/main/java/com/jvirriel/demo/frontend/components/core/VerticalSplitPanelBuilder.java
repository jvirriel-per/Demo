package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.*;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo VerticalSplitPanel.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.6/com/vaadin/ui/VerticalSplitPanel.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public class VerticalSplitPanelBuilder {
    /**
     * delegate
     */
    private final VerticalSplitPanel verticalSplitPanel;

    /**
     * Hide constructor, use static factory methods.
     */
    private VerticalSplitPanelBuilder(final VerticalSplitPanel verticalSplitPanel) {
        this.verticalSplitPanel = verticalSplitPanel;
    }

    /**
     * @return the created instance
     */
    public final VerticalSplitPanel get() {
        return verticalSplitPanel;
    }

    /**
     * Crea un panel de división vertical vacío.
     * @return
     */
    public static VerticalSplitPanelBuilder verticalSplitPanel() {
        return new VerticalSplitPanelBuilder(new VerticalSplitPanel());
    }

    /**
     * Crea un panel de división vertical que contiene los componentes dados.
     * @param firstComponent - El componente a colocar a la izquierda del divisor.
     * @param secondComponent - El componente a colocar a la derecha del divisor.
     * @return
     */
    public static VerticalSplitPanelBuilder verticalSplitPanel(final Component firstComponent, final Component secondComponent) {
        return new VerticalSplitPanelBuilder(new VerticalSplitPanel(firstComponent, secondComponent));
    }

    /**
     * Agregue un componente en este contenedor. El componente se agrega a la derecha o debajo del componente anterior.
     * @param c - El componente a añadir.
     */
    public VerticalSplitPanelBuilder addComponent(final Component c) {
        verticalSplitPanel.addComponent(c);
        return this;
    }

    /**
     * Registrar un listener para manejar Resumen SplitPanel.Split Position Change Events.
     * @param listener - AbstractSplitPanel.SplitPositionChangeListener para ser registrado.
     * @return
     */
    public VerticalSplitPanelBuilder addSplitPositionChangeListener(final AbstractSplitPanel.SplitPositionChangeListener listener) {
        verticalSplitPanel.addSplitPositionChangeListener(listener);
        return this;
    }

    /**
     * @param listener
     * @return
     */
    public VerticalSplitPanelBuilder addSplitterClickListener(final AbstractSplitPanel.SplitterClickListener listener) {
        verticalSplitPanel.addSplitterClickListener(listener);
        return this;
    }

    /**
     * Establece el primer componente de este panel dividido. Dependiendo de la dirección, el primer componente se
     * muestra en la parte superior o izquierda.
     * @param c - El componente a utilizar como primer componente.
     * @return
     */
    public VerticalSplitPanelBuilder setFirstComponent(final Component c) {
        verticalSplitPanel.setFirstComponent(c);
        return this;
    }

    /**
     * Bloquee la posición de SplitPanels, deshabilitando al usuario de arrastrar el identificador de división.
     * @param locked - Establezca true si está bloqueado, false en caso contrario.
     * @return
     */
    public VerticalSplitPanelBuilder setLocked(final boolean locked) {
        verticalSplitPanel.setLocked(locked);
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
    public VerticalSplitPanelBuilder setMaxSplitPosition(final float pos, final Sizeable.Unit unit) {
        verticalSplitPanel.setMaxSplitPosition(pos, unit);
        return this;
    }

    /**
     * Establece la posición de división mínima en la posición y unidad dada. Si la posición dividida es invertida,
     * el máximo y el mínimo también se invierten.
     * @param pos - La posición mínima de la división.
     * @param unit - La unidad (de tamaño) en la que se da el tamaño. Las unidades permitidas son UNITS_PERCENTAGE y
     *             UNITS_PIXELS.
     * @return
     */
    public VerticalSplitPanelBuilder setMinSplitPosition(final float pos, final Sizeable.Unit unit) {
        verticalSplitPanel.setMinSplitPosition(pos, unit);
        return this;
    }

    /**
     * Establece el segundo componente de este panel dividido. Dependiendo de la dirección, el segundo componente se
     * muestra en la parte inferior o derecha.
     * @param c - El componente a utilizar como segundo componente.
     * @return
     */
    public VerticalSplitPanelBuilder setSecondComponent(final Component c) {
        verticalSplitPanel.setSecondComponent(c);
        return this;
    }

    /**
     * Mueve la posición del divisor.
     * @param pos - El nuevo tamaño de la primera región de la unidad que se utilizó por última vez (el valor
     *            predeterminado es el porcentaje). Las fracciones sólo se permiten cuando la unidad es el porcentaje.
     * @return
     */
    public VerticalSplitPanelBuilder setSplitPosition(final float pos) {
        verticalSplitPanel.setSplitPosition(pos);
        return this;
    }

    /**
     * Mueve la posición del divisor.
     * @param pos - El nuevo tamaño de la región en la unidad que se utilizó por última vez (por defecto es el
     *            porcentaje). Las fracciones sólo se permiten cuando la unidad es el porcentaje.
     * @param reverse - Si se ajusta a verdadero, la posición divisora dividida se mide por la segunda región, si no
     *                se mide por la primera región
     * @return
     */
    public VerticalSplitPanelBuilder setSplitPosition(final float pos, final boolean reverse) {
        verticalSplitPanel.setSplitPosition(pos, reverse);
        return this;
    }

    /**
     * Mueve la posición del divisor con la posición dada y la unidad.
     * @param pos - El nuevo tamaño de la primera región. Las fracciones sólo se permiten cuando la unidad es el
     *            porcentaje.
     * @param unit - La unidad (de tamaño) en la que se da el tamaño.
     * @return
     */
    public VerticalSplitPanelBuilder setSplitPosition(final float pos, final Sizeable.Unit unit) {
        verticalSplitPanel.setSplitPosition(pos, unit);
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
    public VerticalSplitPanelBuilder setSplitPosition(final float pos, final Sizeable.Unit unit, final boolean reverse) {
        verticalSplitPanel.setSplitPosition(pos, unit, reverse);
        return this;
    }

    /**
     * Escucha los eventos de adjuntar componentes.
     * @param listener - El listener para agregar, no nulo.
     * @return
     */
    public VerticalSplitPanelBuilder addComponentAttachListener(final HasComponents.ComponentAttachListener listener) {
        verticalSplitPanel.addComponentAttachListener(listener);
        return this;
    }

    /**
     * Escucha los eventos de separación de componentes.
     * @param listener
     * @return
     */
    public VerticalSplitPanelBuilder addComponentDetachListener(final HasComponents.ComponentDetachListener listener) {
        verticalSplitPanel.addComponentDetachListener(listener);
        return this;
    }

    /**
     * Agrega los componentes en el orden dado a este contenedor de componentes.
     * @param components - Los componentes a añadir.
     * @return
     */
    public VerticalSplitPanelBuilder addComponents(final Component... components) {
        verticalSplitPanel.addComponents(components);
        return this;
    }

    /**
     * Establece la altura del objeto. El número negativo implica un tamaño no especificado (el terminal es libre de
     * establecer el tamaño).
     * @param height - La altura del objeto.
     * @param unit - La unidad utilizada para el ancho.
     * @return
     */
    public VerticalSplitPanelBuilder setHeight(final float height, final Sizeable.Unit unit) {
        verticalSplitPanel.setHeight(height, unit);
        return this;
    }

    /**
     * Establece el ancho del objeto. El número negativo implica un tamaño no especificado (el terminal es libre de
     * establecer el tamaño).
     * @param width - El ancho del objeto.
     * @param unit - La unidad utilizada para el ancho.
     * @return
     */
    public VerticalSplitPanelBuilder setWidth(final float width, final Sizeable.Unit unit) {
        verticalSplitPanel.setWidth(width, unit);
        return this;
    }

    /**
     * Agrega un oyente de clicks de contexto que se notifica cuando se produce un clic de contexto.
     * @param listener - El listener de clicks de contexto para agregar, no nulo
     * @return
     */
    public VerticalSplitPanelBuilder addContextClickListener(final ContextClickEvent.ContextClickListener listener) {
        verticalSplitPanel.addContextClickListener(listener);
        return this;
    }

    /**
     * Registra un nuevo componente de componente (genérico) para el componente.
     * @param listener - El nuevo Listener que se va a registrar.
     * @return
     */
    public VerticalSplitPanelBuilder addListener(final Component.Listener listener) {
        verticalSplitPanel.addListener(listener);
        return this;
    }

    /**
     * @param shortcut
     * @return
     */
    public VerticalSplitPanelBuilder addShortcutListener(final ShortcutListener shortcut) {
        verticalSplitPanel.addShortcutListener(shortcut);
        return this;
    }

    /**
     * Agrega uno o más nombres de estilos a este componente. Se pueden especificar varios estilos como una lista de
     * nombres de estilos separados por espacios. El nombre del estilo se renderizará como un nombre de clase HTML, que
     * se puede utilizar en una definición CSS.
     * @param style - El nuevo estilo que se agregará al componente.
     * @return
     */
    public VerticalSplitPanelBuilder addStyleName(final String style) {
        verticalSplitPanel.addStyleName(style);
        return this;
    }

    /**
     * Notifica el conector que está conectado a un VaadinSession (y por lo tanto también a una interfaz de usuario).
     El llamador de este método es Connector # setParent (ClientConnector) si el padre ya está conectado a la sesión.
     De lo contrario, el padre llamará a ClientConnector.attach () para todos sus hijos cuando esté conectado a la
     sesión. Este método siempre se llama antes de que los datos del conector se envíen al cliente por primera vez.
     * @return
     */
    public VerticalSplitPanelBuilder attach() {
        verticalSplitPanel.attach();
        return this;
    }

    /**
     * Notifica al conector que está separado de su VaadinSession.
     El llamador de este método es #setParent (ClientConnector) si el padre está en la sesión. Cuando el padre se separa
     de la sesión es su responsabilidad llamar a ClientConnector.detach () para cada uno de sus hijos.
     * @return
     */
    public VerticalSplitPanelBuilder detach() {
        verticalSplitPanel.detach();
        return this;
    }

    /**
     * Establece el título del componente.
     Un subtítulo es una etiqueta textual explicativa que acompaña a un componente de interfaz de usuario, normalmente
     mostrado arriba, a la izquierda o dentro del componente. Icono (ver setIcon () está estrechamente relacionado con
     el subtítulo y normalmente se muestra horizontalmente antes o después de él, dependiendo del componente y del
     diseño que contiene.
     Normalmente, el subtítulo también se puede dar como el primer parámetro a un constructor, aunque algunos
     componentes no lo admiten.
     * @param caption - El nuevo título para el componente. Si el título es nulo, no se muestra ninguna leyenda y
     *                normalmente no ocupa ningún espacio
     * @return
     */
    public VerticalSplitPanelBuilder setCaption(final String caption) {
        verticalSplitPanel.setCaption(caption);
        return this;
    }

    /**
     * Establece si el subtítulo se representa como HTML.
     Si se establece en true, los subtítulos se representan en el navegador como HTML y el desarrollador es responsable
     de garantizar que no se utilice HTML dañino. Si se establece en false, el subtítulo se representa en el navegador
     como texto sin formato.
     El valor por defecto es falso, es decir, para que el título sea texto sin formato.
     * @param captionAsHtml - True si los subtítulos se representan como HTML, false si se representan como texto sin
     *                      formato.
     * @return
     */
    public VerticalSplitPanelBuilder setCaptionAsHtml(final boolean captionAsHtml) {
        verticalSplitPanel.setCaptionAsHtml(captionAsHtml);
        return this;
    }

    /**
     * Establece el mensaje de error del componente. El mensaje puede contener ciertas etiquetas XML, para obtener más
     * información, consulte
     * @param componentError - El nuevo ErrorMessage del componente.
     * @return
     */
    public VerticalSplitPanelBuilder setComponentError(final ErrorMessage componentError) {
        verticalSplitPanel.setComponentError(componentError);
        return this;
    }

    /**
     * Establece el objeto de datos, que se puede utilizar para cualquier aplicación de datos específicos. El componente
     * no utiliza ni modifica estos datos.
     * @param data - Los datos específicos de la aplicación.
     * @return
     */
    public VerticalSplitPanelBuilder setData(final Object data) {
        verticalSplitPanel.setData(data);
        return this;
    }

    /**
     * Establece la descripción del componente. Vea getDescription () para más información sobre cuál es la descripción.
     * @param description - La nueva cadena de descripción del componente.
     * @return
     */
    public VerticalSplitPanelBuilder setDescription(final String description) {
        verticalSplitPanel.setDescription(description);
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
    public VerticalSplitPanelBuilder setDescription(final String description, final ContentMode mode) {
        verticalSplitPanel.setDescription(description, mode);
        return this;
    }

    /**
     * Activa o desactiva el componente. El usuario no puede interactuar con componentes deshabilitados, que se muestran
     * con un estilo que indica el estado, normalmente sombreado en color gris claro. Los componentes están habilitados
     * de forma predeterminada.
     * @param enabled - Un valor booleano que especifica si el componente debe estar habilitado o no.
     * @return
     */
    public VerticalSplitPanelBuilder setEnabled(final boolean enabled) {
        verticalSplitPanel.setEnabled(enabled);
        return this;
    }

    /**
     * Establece la altura del componente utilizando la presentación String. La presentación de cadenas es similar a lo
     * que se utiliza en hojas de estilo en cascada. El tamaño puede ser la longitud o el porcentaje del tamaño
     * disponible. La cadena vacía ("") o null anulará la altura y establecerá las unidades en píxeles. Vea la
     * especificación CSS para más detalles.
     * @param height - En la representación de la cadena de estilo CSS.
     * @return
     */
    public VerticalSplitPanelBuilder setHeight(final String height) {
        verticalSplitPanel.setHeight(height);
        return this;
    }

    /**
     * Clears any defined height
     * @return
     */
    public VerticalSplitPanelBuilder setHeightUndefined() {
        verticalSplitPanel.setHeightUndefined();
        return this;
    }

    /**
     * Establece el icono del componente.
     * @param icon - El icono que se mostrará con el subtítulo del componente.
     * @return
     */
    public VerticalSplitPanelBuilder setIcon(final Resource icon) {
        verticalSplitPanel.setIcon(icon);
        return this;
    }

    /**
     * Agrega un identificador único para el componente que se utiliza en el cliente para fines de prueba. Mantener
     * identificadores únicos es responsabilidad del programador.
     * @param id - Una identificación alfanumérica.
     * @return
     */
    public VerticalSplitPanelBuilder setId(final String id) {
        verticalSplitPanel.setId(id);
        return this;
    }

    /**
     * Establece la configuración regional de este componente.
     * @param locale - La configuración regional para convertirse en la configuración regional de este componente.
     * @return
     */
    public VerticalSplitPanelBuilder setLocale(final Locale locale) {
        verticalSplitPanel.setLocale(locale);
        return this;
    }

    /**
     * Establece el conector padre del componente.
     Este método llama automáticamente Component.attach () si el componente se conecta a la sesión, independientemente
     de si se ha conectado anteriormente. Por el contrario, si el componente actualmente está conectado a la sesión,
     ClientConnector.detach () se llama para el conector antes de adjuntarlo a un nuevo padre.
     * @param parent - El conector padre.
     * @return
     */
    public VerticalSplitPanelBuilder setParent(final HasComponents parent) {
        verticalSplitPanel.setParent(parent);
        return this;
    }

    /**
     * Cambia el nombre del estilo principal del componente.
     El nombre de estilo principal identifica el componente al aplicar el tema CSS al Componente. Al cambiar el nombre
     del estilo, todas las reglas de CSS dirigidas a ese nombre de estilo ya no se aplicarán y podría resultar en que el
     componente no funcione correctamente.
     Para conservar el estilo original del componente al cambiar a un nuevo estilo principal, debe hacer que su nuevo
     estilo primario herede el estilo primario antiguo utilizando la directiva SIN @include. Vea más en los tutoriales
     de SASS.
     * @param style - El nuevo nombre de estilo principal.
     * @return
     */
    public VerticalSplitPanelBuilder setPrimaryStyleName(final String style) {
        verticalSplitPanel.setPrimaryStyleName(style);
        return this;
    }

    /**
     * Cambia la capacidad de respuesta de este componente.
     * @param responsive - Boolean permite respuesta, false inhabilita
     * @return
     */
    public VerticalSplitPanelBuilder setResponsive(final boolean responsive) {
        verticalSplitPanel.setResponsive(responsive);
        return this;
    }

    /**
     * Establece el tamaño a 100% x 100%.
     * @return
     */
    public VerticalSplitPanelBuilder setSizeFull() {
        verticalSplitPanel.setSizeFull();
        return this;
    }

    /**
     * Borra cualquier configuración de tamaño.
     * @return
     */
    public VerticalSplitPanelBuilder setSizeUndefined() {
        verticalSplitPanel.setSizeUndefined();
        return this;
    }

    /**
     * Establece uno o más nombres de estilos definidos por el usuario del componente, reemplazando cualquier estilo
     * definido por el usuario anterior. Se pueden especificar varios estilos como una lista de nombres de estilos
     * separados por espacios. Los nombres de estilo deben ser nombres de clases CSS válidos y no deben entrar en conflicto con ningún nombre de estilo incorporado en Vaadin o GWT.
     * @param style - El nuevo estilo o estilos del componente como una lista separada por espacios.
     * @return
     */
    public VerticalSplitPanelBuilder setStyleName(final String style) {
        verticalSplitPanel.setStyleName(style);
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
    public VerticalSplitPanelBuilder setStyleName(final String style, final boolean add) {
        verticalSplitPanel.setStyleName(style, add);
        return this;
    }

    /**
     * Establece la visibilidad del componente.
     Los componentes visibles se dibujan en la interfaz de usuario, mientras que los invisibles no lo son. El efecto no
     es simplemente un cambio cosmético de CSS - ninguna información sobre un componente invisible será enviada al
     cliente. El efecto es, por lo tanto, el mismo que eliminar el componente de su padre.
     * @param visible - El valor booleano que especifica si el componente debe estar visible después de la llamada o no.
     * @return
     */
    public VerticalSplitPanelBuilder setVisible(final boolean visible) {
        verticalSplitPanel.setVisible(visible);
        return this;
    }

    /**
     * Establece el ancho del componente utilizando la presentación String. La presentación de cadenas es similar a lo
     * que se utiliza en hojas de estilo en cascada. El tamaño puede ser la longitud o el porcentaje del tamaño
     * disponible. La cadena vacía ("") o null anulará el ancho y establecerá las unidades en píxeles. Vea la
     *  especificación CSS para más detalles.
     * @param width - En la representación de cadena de estilo CSS, cadena nula o vacía para restablecer.
     * @return
     */
    public VerticalSplitPanelBuilder setWidth(final String width) {
        verticalSplitPanel.setWidth(width);
        return this;
    }

    /**
     * Borra cualquier ancho definido.
     * @return
     */
    public VerticalSplitPanelBuilder setWidthUndefined() {
        verticalSplitPanel.setWidthUndefined();
        return this;
    }

    /**
     * Agregue un detector para eventos de conexión del conector.
     * @param listener - Registro para cancelar el registro del listener.
     * @return
     */
    public VerticalSplitPanelBuilder addAttachListener(final ClientConnector.AttachListener listener) {
        verticalSplitPanel.addAttachListener(listener);
        return this;
    }

    /**
     * Agregue un escucha para eventos de separación de conector.
     * @param listener - Registro para cancelar el registro del listener.
     * @return
     */
    public VerticalSplitPanelBuilder addDetachListener(final ClientConnector.DetachListener listener) {
        verticalSplitPanel.addDetachListener(listener);
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
    public VerticalSplitPanelBuilder addListener(final Class<?> eventType, final Object target, final Method method) {
        verticalSplitPanel.addListener(eventType, target, method);
        return this;
    }

    /**
     * Establece el controlador de errores para el conector. El manejador de errores se distribuye cada vez que hay un
     * error de procesamiento de los datos procedentes del cliente para este conector.
     * @param errorHandler - El controlador de errores para este conector.
     * @return
     */
    public VerticalSplitPanelBuilder setErrorHandler(final ErrorHandler errorHandler) {
        verticalSplitPanel.setErrorHandler(errorHandler);
        return this;
    }
}
