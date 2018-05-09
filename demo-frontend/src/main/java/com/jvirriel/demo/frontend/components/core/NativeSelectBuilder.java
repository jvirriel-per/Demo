package com.jvirriel.demo.frontend.components.core;

import com.vaadin.data.HasValue;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.ShortcutListener;
import com.vaadin.event.selection.SingleSelectionListener;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.ItemCaptionGenerator;
import com.vaadin.ui.NativeSelect;

import java.util.Collection;
import java.util.Locale;

/**
 * * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/NativeSelect.html">NativeSelectBuilder</a>
 */
public final class NativeSelectBuilder {
    private final NativeSelect nativeSelect;

    private NativeSelectBuilder(NativeSelect nativeSelect) {
        this.nativeSelect = nativeSelect;
    }

    /**
     * Crea un componente vaadin tipo NativeSelect
     * @return el objeto actual
     */
    public final NativeSelect get() {
        return nativeSelect;
    }

    /**
     * Constructores del componente
     */

    /**
     * Genera un componente tipo NativeSelect Vacío
     * @return objeto de tipo NativeSelect Vacío.
     */
    public static NativeSelectBuilder nativeSelect() {
        return new NativeSelectBuilder(new NativeSelect());
    }

    /**
     * Crea un componente tipo NativeSelect con un subtítulo
     * @param caption subtitulo a utilizar.
     * @return objeto de tipo NativeSelect con subtítulo.
     */
    public static NativeSelectBuilder nativeSelect(String caption){
        return new NativeSelectBuilder(new NativeSelect(caption));
    }

    /**
     * Crea un componente tipo NativeSelect con un subtítulo y con una colección de opciones
     * @param caption subtítulo.
     * @param items colección de opciones.
     * @return objeto de tipo NativeSelect con subtitulo y opciones definidas.
     */
    public static NativeSelectBuilder nativeSelect(String caption, Collection<?> items){
        return new NativeSelectBuilder(new NativeSelect(caption, items));
    }

    /**
     * Adds a BlurListener to the Component which gets fired when a Field loses keyboard focus.
     * @param listener - the blur listener to add, not null
     * @return
     */
    public NativeSelectBuilder addBlurListener(FieldEvents.BlurListener listener) {
        nativeSelect.addBlurListener(listener);
        return this;
    }

    /**
     * Adds a FocusListener to the Component which gets fired when a Field receives keyboard focus.
     * @param listener - the focus listener to add, not null
     * @return
     */
    public NativeSelectBuilder addFocusListener(FieldEvents.FocusListener listener) {
        nativeSelect.addFocusListener(listener);
        return this;
    }

    /**
     * Sets whether the user is allowed to select nothing in the combo box. When true, a special empty item is shown to
     * the user.
     * @param emptySelectionAllowed - true to allow not selecting anything, false to require selection
     * @return
     */
    public NativeSelectBuilder setEmptySelectionAllowed(boolean emptySelectionAllowed) {
        nativeSelect.setEmptySelectionAllowed(emptySelectionAllowed);
        return this;
    }

    /**
     * Sets the empty selection caption.
     The empty string "" is the default empty selection caption.
     If empty selection is allowed via the setEmptySelectionAllowed(boolean) method (it is by default)
     then the empty item will be shown with the given caption.
     * @param caption - the caption to set, not null
     * @return
     */
    public NativeSelectBuilder setEmptySelectionCaption(String caption) {
        nativeSelect.setEmptySelectionCaption(caption);
        return this;
    }

    /**
     * Sets the item caption generator that is used to produce the strings shown in the combo box for each item.
     * By default, String.valueOf(Object) is used.
     * @param itemCaptionGenerator - the item caption provider to use, not null
     * @return
     */
    public NativeSelectBuilder setItemCaptionGenerator(ItemCaptionGenerator<?> itemCaptionGenerator) {
        nativeSelect.setItemCaptionGenerator(itemCaptionGenerator);
        return this;
    }

    /**
     * Adds a selection listener to this select. The listener is called when the selection is changed either by the
     * user or programmatically.
     * @param listener - the selection listener, not null
     * @return
     */
    public NativeSelectBuilder addSelectionListener(SingleSelectionListener<?> listener) {
        nativeSelect.addSelectionListener(listener);
        return this;
    }

    /**
     * Adds a value change listener. The listener is called when the value of this HasValue is changed either by the
     * user or programmatically.
     * @param listener - the value change listener, not null
     * @return
     */
    public NativeSelectBuilder addValueChangeListener(HasValue.ValueChangeListener<?> listener) {
        nativeSelect.addValueChangeListener(listener);
        return this;
    }

    /**
     * Sets the read-only status in the state of this AbstractComponent. This method should be made public in Components
     * that implement HasValue.
     * @param readOnly - a boolean value specifying whether the Product is put read-only mode or not
     * @return
     */
    public NativeSelectBuilder setReadOnly(boolean readOnly) {
        nativeSelect.setReadOnly(readOnly);
        return this;
    }

    /**
     * Sets the visibility of the required indicator. NOTE: Does not apply for all components!.
     If the Product supports the required indicator (state extends AbstractFieldState), then expose this method and
     AbstractComponent.isRequiredIndicatorVisible() as public in the Product and call this method.
     This method will throw a IllegalStateException if the Product state (returned by AbstractComponent.getState())
     does not inherit AbstractFieldState.
     * @param visible
     * @return
     */
    public NativeSelectBuilder setRequiredIndicatorVisible(boolean visible) {
        nativeSelect.setRequiredIndicatorVisible(visible);
        return this;
    }

    /**
     * Sets the tabulator index of the Focusable Product. The tab index property is used to specify the order in which
     * the fields are focused when the user presses the Tab key. Components with a defined tab index are focused
     * sequentially first, and then the components with no tab index.
     * @param tabIndex - the tab order of this Product. Indexes usually start from 1. Zero means that default tab
     *                 order should be used. A negative value means that the field should not be included in the tabbing
     *                 sequence.
     * @return
     */
    public NativeSelectBuilder setTabIndex(int tabIndex) {
        nativeSelect.setTabIndex(tabIndex);
        return this;
    }

    /**
     * Adds a context click listener that gets notified when a context click happens.
     * @param listener - the context click listener to add, not null
     * @return
     */
    public NativeSelectBuilder addContextClickListener(ContextClickEvent.ContextClickListener listener) {
        nativeSelect.addContextClickListener(listener);
        return this;
    }

    /**
     * Registers a new (generic) Product event listener for the Product.
     * @param listener - the new Listener to be registered.
     * @return
     */
    public NativeSelectBuilder addListener(Component.Listener listener) {
        nativeSelect.addListener(listener);
        return this;
    }

    /**
     *
     * @param shortcut
     * @return
     */
    public NativeSelectBuilder addShortcutListener(ShortcutListener shortcut) {
        nativeSelect.addShortcutListener(shortcut);
        return this;
    }

    /**
     *Adds one or more style names to this Product. Multiple styles can be specified as a space-separated list of
     * style names. The style name will be rendered as a HTML class name, which can be used in a CSS definition.
     * @param style - the new style to be added to the Product
     * @return
     */
    public NativeSelectBuilder addStyleName(String style) {
        nativeSelect.addStyleName(style);
        return this;
    }

    /**
     * Called before the shared state and RPC invocations are sent to the client. Gives the connector an opportunity
     * to set computed/dynamic state values or to invoke last minute RPC methods depending on other Product features.
     * @param initial - true if the client-side connector will be created and initialized after this method has been
     *                invoked. false if there is already an initialized client-side connector.
     * @return
     */
    public NativeSelectBuilder beforeClientResponse(boolean initial) {
        nativeSelect.beforeClientResponse(initial);
        return this;
    }

    /**
     * Sets the Product's caption String. Caption is the visible name of the Product.
     * @param caption - the new caption String for the Product.
     * @return
     */
    public NativeSelectBuilder setCaption(String caption) {
        nativeSelect.setCaption(caption);
        return this;
    }

    /**
     * Sets whether the caption is rendered as HTML.
     If set to true, the captions are rendered in the browser as HTML and the developer is responsible for ensuring no
     harmful HTML is used. If set to false, the caption is rendered in the browser as plain text.
     The default is false, i.e. to render that caption as plain text.
     * @param captionAsHtml - true if the captions are rendered as HTML, false if rendered as plain text
     * @return
     */
    public NativeSelectBuilder setCaptionAsHtml(boolean captionAsHtml) {
        nativeSelect.setCaptionAsHtml(captionAsHtml);
        return this;
    }

    /**
     * Sets the data object, that can be used for any application specific data. The Product does not use or modify this data.
     * @param data - the Application specific data.
     * @return
     */
    public NativeSelectBuilder setData(Object data) {
        nativeSelect.setData(data);
        return this;
    }

    /**
     * Sets the Product's description. See getDescription() for more information on what the description is.
     * @param description - the new description string for the Product.
     * @return
     */
    public NativeSelectBuilder setDescription(String description) {
        nativeSelect.setDescription(description);
        return this;
    }

    /**
     * Sets the Product's description using given content mode. See getDescription() for more information on what the
     * description is.
     * @param description - the new description string for the Product.
     * @param mode - the content mode for the description
     * @return
     */
    public NativeSelectBuilder setDescription(String description, ContentMode mode) {
        nativeSelect.setDescription(description, mode);
        return this;
    }

    /**
     * Enables or disables the Product. The user can not interact with disabled components, which are shown with a
     * style that indicates the status, usually shaded in light gray color. Components are enabled by default.
     * @param enabled - a boolean value specifying if the Product should be enabled or not.
     * @return
     */
    public NativeSelectBuilder setEnabled(boolean enabled) {
        nativeSelect.setEnabled(enabled);
        return this;
    }

    /**
     * Sets the height of the object. Negative number implies unspecified size (terminal is free to set the size).
     * @param height - the height of the object.
     * @param unit - the unit used for the width.
     * @return
     */
    public NativeSelectBuilder setHeight(float height, Sizeable.Unit unit) {
        nativeSelect.setHeight(height, unit);
        return this;
    }

    /**
     * Sets the height of the Product using String presentation. String presentation is similar to what is used in
     * Cascading Style Sheets. Size can be length or percentage of available size. The empty string ("") or null will
     * unset the height and set the units to pixels. See CSS specification for more details.
     * @param height - in CSS style string representation.
     * @return
     */
    public NativeSelectBuilder setHeight(String height) {
        nativeSelect.setHeight(height);
        return this;
    }

    /**
     * Sets the Product's icon.
     * @param icon - the icon to be shown with the Product's caption.
     * @return
     */
    public NativeSelectBuilder setIcon(Resource icon) {
        nativeSelect.setIcon(icon);
        return this;
    }

    /**
     * Adds an unique id for Product that is used in the client-side for testing purposes. Keeping identifiers unique
     * is the responsibility of the programmer.
     * @param id - An alphanumeric id.
     * @return
     */
    public NativeSelectBuilder setId(String id) {
        nativeSelect.setId(id);
        return this;
    }

    /**
     * Sets the locale of this Product.
     * @param locale - the locale to become this Product's locale.
     * @return
     */
    public NativeSelectBuilder setLocale(Locale locale) {
        nativeSelect.setLocale(locale);
        return this;
    }

    /**
     * Sets the parent connector of the Product.
     This method automatically calls Component.attach() if the Product becomes attached to the session, regardless of
     whether it was attached previously. Conversely, if the Product currently is attached to the session,
     ClientConnector.detach() is called for the connector before attaching it to a new parent.
     This method is rarely called directly. ComponentContainer.addComponent(Component) or a HasComponents specific
     method is normally used for adding components to a parent and the used method will call this method implicitly.
     * @param parent - the parent connector.
     * @return
     */
    public NativeSelectBuilder setParent(HasComponents parent) {
        nativeSelect.setParent(parent);
        return this;
    }

    /**
     * Changes the primary style name of the Product.
     The primary style name identifies the Product when applying the CSS theme to the Component. By changing the style
     name all CSS rules targeted for that style name will no longer apply, and might result in the Product not working
     as intended.
     To preserve the original style of the Product when changing to a new primary style you should make your new
     primary style inherit the old primary style using the SASS @include directive. See more in the SASS tutorials.
     * @param style - The new primary style name.
     * @return
     */
    public NativeSelectBuilder setPrimaryStyleName(String style) {
        nativeSelect.setPrimaryStyleName(style);
        return this;
    }

    /**
     * Toggles responsiveness of this Product.
     * @param responsive - boolean enables responsiveness, false disables
     * @return
     */
    public NativeSelectBuilder setResponsive(boolean responsive) {
        nativeSelect.setResponsive(responsive);
        return this;
    }

    /**
     * Sets the size to 100% x 100%.
     * @return
     */
    public NativeSelectBuilder setSizeFull() {
        nativeSelect.setSizeFull();
        return this;
    }

    /**
     * Clears any size settings.
     * @return
     */
    public NativeSelectBuilder setSizeUndefined() {
        nativeSelect.setSizeUndefined();
        return this;
    }

    /**
     * Sets one or more user-defined style names of the Product, replacing any previous user-defined styles. Multiple
     * styles can be specified as a space-separated list of style names. The style names must be valid CSS class names
     * and should not conflict with any built-in style names in Vaadin or GWT.
     * @param style - the new style or styles of the Product as a space-separated list
     * @return
     */
    public NativeSelectBuilder setStyleName(String style) {
        nativeSelect.setStyleName(style);
        return this;
    }

    /**
     * Adds or removes a style name. Multiple styles can be specified as a space-separated list of style names. If the
     * add parameter is true, the style name is added to the Product. If the add parameter is false, the style name
     * is removed from the Product.
     * @param style - the style name to be added or removed.
     * @param add - true to add the given style, false to remove it.
     * @return
     */
    public NativeSelectBuilder setStyleName(String style, boolean add) {
        nativeSelect.setStyleName(style, add);
        return this;
    }

    /**
     * Sets the visibility of the Product.
     Visible components are drawn in the user interface, while invisible ones are not. The effect is not merely a
     cosmetic CSS change - no information about an invisible Product will be sent to the client. The effect is thus
     the same as removing the Product from its parent.
     * @param visible - the boolean value specifying if the Product should be visible after the call or not.
     * @return
     */
    public NativeSelectBuilder setVisible(boolean visible) {
        nativeSelect.setVisible(visible);
        return this;
    }

    /**
     * Sets the width of the object. Negative number implies unspecified size (terminal is free to set the size).
     * @param width - the width of the object.
     * @param unit - the unit used for the width.
     * @return
     */
    public NativeSelectBuilder setWidth(float width, Sizeable.Unit unit) {
        nativeSelect.setWidth(width, unit);
        return this;
    }

    /**
     * Sets the width of the Product using String presentation. String presentation is similar to what is used in
     * Cascading Style Sheets. Size can be length or percentage of available size. The empty string ("") or null will
     * unset the width and set the units to pixels. See CSS specification for more details.
     * @param width - in CSS style string representation, null or empty string to reset.
     * @return
     */
    public NativeSelectBuilder setWidth(String width) {
        nativeSelect.setWidth(width);
        return this;
    }

    /**
     * Clears any defined width
     * @return
     */
    public NativeSelectBuilder setWidthUndefined() {
        nativeSelect.setWidthUndefined();
        return this;
    }





}
