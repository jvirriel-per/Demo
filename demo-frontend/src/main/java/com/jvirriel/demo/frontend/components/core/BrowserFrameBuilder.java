package com.jvirriel.demo.frontend.components.core;


import com.vaadin.event.ShortcutListener;
import com.vaadin.server.*;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;

import java.lang.reflect.Method;
import java.util.Locale;

/**
 *  Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/BrowserFrame.html">BrowserFrame</a>

 */
public final class BrowserFrameBuilder {

    private final BrowserFrame browserFrame;

    public BrowserFrameBuilder(BrowserFrame browserFrame) {
        this.browserFrame = browserFrame;
    }

    public final BrowserFrame get(){
        return browserFrame;
    }

    public static BrowserFrameBuilder browserFrame(){
        return new BrowserFrameBuilder(new BrowserFrame());
    }

    public static BrowserFrameBuilder browserFrame(String caption){
        return new BrowserFrameBuilder(new BrowserFrame(caption));
    }

    public static BrowserFrameBuilder browserFrame(String caption, Resource resource){
        return new BrowserFrameBuilder(new BrowserFrame(caption,resource));
    }



    public BrowserFrameBuilder addListener(Component.Listener listener){
        browserFrame.addListener(listener);
        return this;
    }

    public BrowserFrameBuilder addShortcutListener(ShortcutListener shortcut){
        browserFrame.addShortcutListener(shortcut);
        return this;
    }

    public BrowserFrameBuilder addStyleName(String style){
        browserFrame.addStyleName(style);
        return this;
    }

    public BrowserFrameBuilder addAttachListener(ClientConnector.AttachListener listener){
        browserFrame.addAttachListener(listener);
        return this;
    }

    public BrowserFrameBuilder addDetachListener(ClientConnector.DetachListener listener){
        browserFrame.addDetachListener(listener);
        return this;
    }

    public BrowserFrameBuilder addListener(Class<?> eventType,
                                           Object target,
                                           Method method){
        browserFrame.addListener(eventType,target,method);
        return this;
    }

    public BrowserFrameBuilder removeStyleName(String style){
        browserFrame.removeStyleName(style);
        return this;
    }

    public BrowserFrameBuilder setCaption(String caption){
        browserFrame.setCaption(caption);
        return this;
    }

    public BrowserFrameBuilder setData(Object data){
        browserFrame.setData(data);
        return this;
    }

    public BrowserFrameBuilder setComponentError(ErrorMessage componentError){
        browserFrame.setComponentError(componentError);
        return this;
    }

    public BrowserFrameBuilder setDescription(String description){
        browserFrame.setDescription(description);
        return this;
    }

    public BrowserFrameBuilder setEnabled(boolean enabled){
        browserFrame.setEnabled(enabled);
        return this;
    }

    public BrowserFrameBuilder setHeight(float height,
                                         Sizeable.Unit unit){
        browserFrame.setHeight(height,unit);
        return this;
    }

    public BrowserFrameBuilder setHeight(String height){
        browserFrame.setHeight(height);
        return this;
    }

    public BrowserFrameBuilder setHeightUndefined(){
        browserFrame.setHeightUndefined();
        return this;
    }

    public BrowserFrameBuilder setIcon(Resource icon){
        browserFrame.setIcon(icon);
        return this;
    }

    public BrowserFrameBuilder setId(String id){
        browserFrame.setId(id);
        return this;
    }

    public BrowserFrameBuilder setLocale(Locale locale){
        browserFrame.setLocale(locale);
        return this;
    }

    public BrowserFrameBuilder setParent(HasComponents parent){
        browserFrame.setParent(parent);
        return this;
    }

    public BrowserFrameBuilder setPrimaryStyleName(String style){
        browserFrame.setPrimaryStyleName(style);
        return this;
    }



    public BrowserFrameBuilder setSizeFull(){
        browserFrame.setSizeFull();
        return this;
    }

    public BrowserFrameBuilder setSizeUndefined(){
        browserFrame.setSizeUndefined();
        return this;
    }

    public BrowserFrameBuilder setStyleName(String style){
        browserFrame.setStyleName(style);
        return this;
    }

    public BrowserFrameBuilder setStyleName(String style, boolean add){
        browserFrame.setStyleName(style, add);
        return this;
    }

    public BrowserFrameBuilder setVisible(boolean visible){
        browserFrame.setVisible(visible);
        return this;
    }

    public BrowserFrameBuilder setWidth(float width,
                                        Sizeable.Unit unit){
        browserFrame.setWidth(width, unit);
        return this;
    }

    public BrowserFrameBuilder setWidth(String width){
        browserFrame.setWidth(width);
        return this;
    }

    public BrowserFrameBuilder setWidthUndefined(){
        browserFrame.setWidthUndefined();
        return this;
    }

    public BrowserFrameBuilder setErrorHandler(ErrorHandler errorHandler){
        browserFrame.setErrorHandler(errorHandler);
        return this;
    }

    public BrowserFrameBuilder setSource(Resource source){
        browserFrame.setSource(source);
        return this;
    }

    //    public BrowserFrameBuilder addContextClickListener(ContextClickEvent.ContextClickListener listener){
//        browserFrame.addContextClickListener(listener);
//        return this;
//    }
//    public BrowserFrameBuilder setResponsive(boolean responsive){
//        browserFrame.setResponsive(responsive);
//        return this;
//    }
//    public BrowserFrameBuilder removeContextClickListener(ContextClickEvent.ContextClickListener listener){
//        browserFrame.removeContextClickListener(listener);
//        return this;
//    }
//
//    public BrowserFrameBuilder removeListener(Component.Listener listener){
//        browserFrame.removeListener(listener);
//        return this;
//    }
//
//    public BrowserFrameBuilder removeShortcutListener(ShortcutListener shortcut){
//        browserFrame.removeShortcutListener(shortcut);
//        return this;
//    }
    //    public BrowserFrameBuilder removeAttachListener(ClientConnector.AttachListener listener){
//        browserFrame.removeAttachListener(listener);
//        return this;
//    }
//
//    public BrowserFrameBuilder removeListener(Class<?> eventType,
//                                              Object target){
//        browserFrame.removeListener(eventType,target);
//        return this;
//    }
//    public BrowserFrameBuilder setImmediate(boolean immediate){
//        browserFrame.setImmediate(immediate);
//        return this;
//    }
//    public BrowserFrameBuilder setReadOnly(boolean readOnly){
//        browserFrame.setReadOnly(readOnly);
//        return this;
//    }
}
