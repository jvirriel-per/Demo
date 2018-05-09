package com.jvirriel.demo.frontend.components.core;

import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.*;

import java.util.List;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo
 *  <a href="https://vaadin.com/directory#!addon/multifileupload">MultiUpload</a>
 */
public class MultiUploadBuilder {
    private final MultiFileUpload multiFileUpload;

    /**
     * Hide constructor, use static factory methods.
     */
    private MultiUploadBuilder(final MultiFileUpload multiFileUpload) {
        this.multiFileUpload = multiFileUpload;
    }

    /**
     * @return the created instance
     */
    public final MultiFileUpload get() {
        return multiFileUpload;
    }

    /**
     * Construye el componente.
     *
     * @return
     */
    public static MultiUploadBuilder multiUpload(UploadFinishedHandler uploadFinishedHandler,
                                                 UploadStateWindow uploadStateWindow) {
        return new MultiUploadBuilder(new MultiFileUpload(uploadFinishedHandler, uploadStateWindow));
    }

    public static MultiUploadBuilder multiUpload(UploadStartedHandler uploadStartedHandler,
                                                 UploadFinishedHandler uploadFinishedHandler,
                                                 UploadStateWindow uploadStateWindow, boolean multiple) {
        return new MultiUploadBuilder(new MultiFileUpload(uploadStartedHandler, uploadFinishedHandler, uploadStateWindow,
                multiple));
    }

    public static MultiUploadBuilder multiUpload(UploadFinishedHandler uploadFinishedHandler,
                                                 UploadStateWindow uploadStateWindow, boolean multiple) {
        return new MultiUploadBuilder(new MultiFileUpload(uploadFinishedHandler, uploadStateWindow, multiple));
    }

    public MultiUploadBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            multiFileUpload.addStyleName(styleName);
        }
        return this;
    }

    public MultiUploadBuilder setCaption(final String caption) {
        multiFileUpload.setCaption(caption);
        return this;
    }

    public MultiUploadBuilder setCaptionAsHtml(final Boolean captionAsHtml) {
        multiFileUpload.setCaptionAsHtml(captionAsHtml);
        return this;
    }

    public MultiUploadBuilder setDescription(final String description) {
        multiFileUpload.setDescription(description);
        return this;
    }

    public MultiUploadBuilder styleName(final String styleName) {
        multiFileUpload.setStyleName(styleName);
        return this;
    }

    public MultiUploadBuilder setVisible(final Boolean value) {
        multiFileUpload.setVisible(value);
        return this;
    }

    public MultiUploadBuilder setTabIndex(final Integer tabIndex){
        multiFileUpload.setTabIndex(tabIndex);
        return this;
    }

    public MultiUploadBuilder setMaxFileCount(final Integer maxFileCount){
        multiFileUpload.setMaxFileCount(maxFileCount);
        return this;
    }

    public MultiUploadBuilder setOverallProgressVisible(final Boolean overallProgressVisible){
        multiFileUpload.setOverallProgressVisible(overallProgressVisible);
        return this;
    }

    public MultiUploadBuilder setInterruptedMsg(final String interruptedMsg){
        multiFileUpload.setInterruptedMsg(interruptedMsg);
        return this;
    }

    public MultiUploadBuilder setAllUploadFinishedHandler(final AllUploadFinishedHandler uploadFinishedHandler){
        multiFileUpload.setAllUploadFinishedHandler(uploadFinishedHandler);
        return this;
    }

    public MultiUploadBuilder setAcceptedMimeTypes(final List<String> mimeTypes){
        multiFileUpload.setAcceptedMimeTypes(mimeTypes);
        return this;
    }

    public MultiUploadBuilder setResponsive(final Boolean responsive) {
        multiFileUpload.setResponsive(responsive);
        return this;
    }

    public MultiUploadBuilder setEnabled(final Boolean enabled) {
        multiFileUpload.setEnabled(enabled);
        return this;
    }

    public MultiUploadBuilder setWidth(final String width) {
        multiFileUpload.setWidth(width);
        return this;
    }

    public MultiUploadBuilder setWidth(final Float value, Sizeable.Unit unit) {
        multiFileUpload.setWidth(value, unit);
        return this;
    }

    public MultiUploadBuilder setHeight(final String height) {
        multiFileUpload.setHeight(height);
        return this;
    }

    public MultiUploadBuilder setMaxFileSize(final Integer maxFileSize) {
        multiFileUpload.setMaxFileSize(maxFileSize);
        return this;
    }

    public MultiUploadBuilder setIndeterminate(final Boolean indeterminate) {
        multiFileUpload.setIndeterminate(indeterminate);
        return this;
    }

    public MultiUploadBuilder setPrimaryStyleName(final String primaryStyleName) {
        multiFileUpload.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public MultiUploadBuilder setIcon(final Resource resource) {
        multiFileUpload.setIcon(resource);
        return this;
    }

    public MultiUploadBuilder setErrorHandler(final ErrorHandler errorHandler) {
        multiFileUpload.setErrorHandler(errorHandler);
        return this;
    }

    public MultiUploadBuilder setPanelCaption(final String panelCaption) {
        multiFileUpload.setPanelCaption(panelCaption);
        return this;
    }

    public MultiUploadBuilder setUploadButtonCaptions(final String singleUploadCaption, final String multiUploadCaption) {
        multiFileUpload.setUploadButtonCaptions(singleUploadCaption, multiUploadCaption);
        return this;
    }

    public MultiUploadBuilder setUploadButtonIcon(final Resource resource) {
        multiFileUpload.setUploadButtonIcon(resource);
        return this;
    }

}