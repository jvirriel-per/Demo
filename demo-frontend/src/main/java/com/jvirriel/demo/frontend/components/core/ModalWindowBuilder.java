package com.jvirriel.demo.frontend.components.core;

import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo ModalWindow.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/Window.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public class ModalWindowBuilder {

    private final Window modalWindow;

    /**
     * Hide constructor, use static factory methods.
     */
    private ModalWindowBuilder(final Window window) {
        this.modalWindow = window;
    }

    /**
     * Creates a Vaadin Window object.
     *
     * @return the created instance
     */
    public final Window get() {
        return modalWindow;
    }

    /**
     * Creates a new, empty modal window.
     *
     * @return the current Builder object
     */
    public static ModalWindowBuilder modalWindow() {
        Window mw = new Window();
        mw.setModal(true);

        return new ModalWindowBuilder(mw);
    }

    /**
     * Creates a new, empty modal window with a given title.
     *
     * @param caption   the title of the modal window
     * @return the current Builder object
     */
    public static ModalWindowBuilder modalWindow(final String caption) {
        Window mw = new Window(caption);
        mw.setModal(true);

        return new ModalWindowBuilder(mw);
    }

    /**
     * Creates a new, empty window with the given content and title.
     *
     * @param caption   the title of the window
     * @param component the contents of the window
     * @return the current Builder object
     */
    public static ModalWindowBuilder modalWindow(final String caption, final Component component) {
        Window mw = new Window(caption, component);
        mw.setModal(true);

        return new ModalWindowBuilder(mw);
    }

    public ModalWindowBuilder addFocusListener(com.vaadin.event.FieldEvents.FocusListener listener) {
        modalWindow.addFocusListener(listener);
        return this;
    }

    public ModalWindowBuilder addCloseListener(Window.CloseListener listener) {
        modalWindow.addCloseListener(listener);
        return this;
    }

    public ModalWindowBuilder addResizeListener(Window.ResizeListener listener) {
        modalWindow.addResizeListener(listener);
        return this;
    }

    public ModalWindowBuilder setContent(final Component content) {
        modalWindow.setContent(content);
        return this;
    }

    public ModalWindowBuilder center() {
        modalWindow.center();
        return this;
    }

    public ModalWindowBuilder setPosition(final int x, final int y) {
        modalWindow.setPosition(x, y);
        return this;
    }

    public ModalWindowBuilder setPositionX(final int x) {
        modalWindow.setPositionX(x);
        return this;
    }

    public ModalWindowBuilder setPositionY(final int y) {
        modalWindow.setPositionX(y);
        return this;
    }

    public ModalWindowBuilder bringToFront() {
        modalWindow.bringToFront();
        return this;
    }

    public ModalWindowBuilder setWidth(final float width, final Sizeable.Unit unit) {
        modalWindow.setWidth(width, unit);
        return this;
    }

    public ModalWindowBuilder setWindowMode(final WindowMode windowMode) {
        modalWindow.setWindowMode(windowMode);
        return this;
    }

    public ModalWindowBuilder setClosable(final boolean closable) {
        modalWindow.setClosable(closable);
        return this;
    }

    public ModalWindowBuilder setDraggable(final boolean draggable) {
        modalWindow.setDraggable(draggable);
        return this;
    }

    public ModalWindowBuilder setResizable(final boolean resizable) {
        modalWindow.setResizable(resizable);
        return this;
    }

    public ModalWindowBuilder setParent(final com.vaadin.ui.HasComponents parent) {
        modalWindow.setParent(parent);
        return this;
    }

    public ModalWindowBuilder setModal(Boolean modal){
        modalWindow.setModal(modal);
        return this;
    }
}