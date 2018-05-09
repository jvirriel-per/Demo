package com.jvirriel.demo.frontend.components.core;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.ui.Slider;

import java.util.Locale;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/Slider.html">Slider</a>
 */
public final class SliderBuilder {

    private final Slider slider;

    public SliderBuilder(Slider slider) {
        this.slider = slider;
    }

    /**
     * Crea un componente vaadin tipo Slider
     *
     * @return objeto tipo slider
     */
    public final Slider get() {
        return slider;
    }

    /*
     * Constructores del componente
     */

    /**
     * Contructor vacío
     *
     * @return Objeto tipo slider vacío
     */
    public static SliderBuilder Slider() {
        return new SliderBuilder(new Slider());
    }

    /**
     * Constructor de slider con el rango y la resolución dados.
     *
     * @param min        resolución mínima
     * @param max        resolución máxima
     * @param resolution resolución
     * @return Objeto tipo slider con las caracteristicas especificadas
     */
    public static SliderBuilder Slider(double min, double max, int resolution) {
        return new SliderBuilder(new Slider(min, max, resolution));
    }

    /**
     * Cree un nuevo control deslizante con el rango dado que sólo permite valores enteros.
     *
     * @param min mínimo valor del slider
     * @param max máximo valor del slider
     * @return Objeto tipo slider con las caracteristicas especificadas
     */
    public static SliderBuilder Slider(int min, int max) {
        return new SliderBuilder(new Slider(min, max));
    }

    /**
     * Cree un nuevo control deslizante con el subtítulo y rango que sólo permite valores enteros.
     *
     * @param caption subtítulo del slider
     * @param min     mínimo valor del slider
     * @param max     máximo valor del slider
     * @return Objeto tipo slider con las caracteristicas especificadas
     */
    public static SliderBuilder Slider(String caption, int min, int max) {
        return new SliderBuilder(new Slider(caption, min, max));
    }

    /*
     * Propiedades
     */

    public SliderBuilder addAttachListener(ClientConnector.AttachListener listener) {
        slider.addAttachListener(listener);
        return this;
    }

    public SliderBuilder addContextClickListener(ContextClickEvent.ContextClickListener listener) {
        slider.addContextClickListener(listener);
        return this;
    }

    public SliderBuilder addDetachListener(ClientConnector.DetachListener listener) {
        slider.addDetachListener(listener);
        return this;
    }

    public SliderBuilder addShortcutListener(ShortcutListener shortcut) {
        slider.addShortcutListener(shortcut);
        return this;
    }

    public SliderBuilder addStyleName(String style) {
        slider.addStyleName(style);
        return this;
    }

    public SliderBuilder clear() {
        slider.clear();
        return this;
    }

    public SliderBuilder removeStyleName(String style) {
        slider.removeStyleName(style);
        return this;
    }

    public SliderBuilder setCaption(String caption) {
        slider.setCaption(caption);
        return this;
    }

    public SliderBuilder setData(Object data) {
        slider.setData(data);
        return this;
    }

    public SliderBuilder setDescription(String description) {
        slider.setDescription(description);
        return this;
    }

    public SliderBuilder setEnabled(boolean enabled) {
        slider.setEnabled(enabled);
        return this;
    }

    public SliderBuilder setHeight(float height, Sizeable.Unit unit) {
        slider.setHeight(height, unit);
        return this;
    }

    public SliderBuilder setHeight(String height) {
        slider.setHeight(height);
        return this;
    }

    public SliderBuilder setHeightUndefined() {
        slider.setHeightUndefined();
        return this;
    }

    public SliderBuilder setIcon(Resource icon) {
        slider.setIcon(icon);
        return this;
    }

    public SliderBuilder setLocale(Locale locale) {
        slider.setLocale(locale);
        return this;
    }

    public SliderBuilder setMax(double max) {
        slider.setMax(max);
        return this;
    }

    public SliderBuilder setMin(double min) {
        slider.setMin(min);
        return this;
    }

    public SliderBuilder setOrientation(SliderOrientation orientation) {
        slider.setOrientation(orientation);
        return this;
    }

    public SliderBuilder setPrimaryStyleName(String style) {
        slider.setPrimaryStyleName(style);
        return this;
    }

    public SliderBuilder setReadOnly(boolean readOnly) {
        slider.setReadOnly(readOnly);
        return this;
    }

    public SliderBuilder setResolution(int resolution) {
        slider.setResolution(resolution);
        return this;
    }

    public SliderBuilder setResponsive(boolean responsive) {
        slider.setResponsive(responsive);
        return this;
    }

    public SliderBuilder setSizeFull() {
        slider.setSizeFull();
        return this;
    }

    public SliderBuilder setStyleName(String style) {
        slider.setStyleName(style);
        return this;
    }

    public SliderBuilder setValue(Double newFieldValue) {
        slider.setValue(newFieldValue);
        return this;
    }

    public SliderBuilder setVisible(boolean visible) {
        slider.setVisible(visible);
        return this;
    }

    public SliderBuilder setWidth(float width, Sizeable.Unit unit) {
        slider.setWidth(width, unit);
        return this;
    }

    public SliderBuilder setWidth(String width) {
        slider.setWidth(width);
        return this;
    }

    public SliderBuilder setWidthUndefined() {
        slider.setWidthUndefined();
        return this;
    }
}