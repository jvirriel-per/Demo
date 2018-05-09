package com.jvirriel.demo.frontend.components.core;

import com.vaadin.ui.Upload;

/**
 * Clase <i>Builder</i> para crear un componente nativo de Vaadin del tipo Upload.
 * Para más información acerca de los métodos, ver la
 * <a href="https://vaadin.com/api/8.0.5/com/vaadin/ui/Upload.html">documentación de referencia</a> en la página
 * de Vaadin.
 */
public class SingleUploadBuilder {

    private final Upload upload;

    /**
     * Hide constructor, use static factory methods.
     */
    private SingleUploadBuilder(final Upload upload) {
        this.upload = upload;
    }

    /**
     * @return the created instance
     */
    public final Upload get() {
        return upload;
    }

    /**
     * Construye el componente.
     * @return
     */
    public static SingleUploadBuilder upload() {
        return new SingleUploadBuilder(new Upload());
    }

    /**
     * Construye el componente con una descripción y el receiver para la data a cargar.
     * @param caption
     * @param uploadReceiver
     * @return
     */
    public static SingleUploadBuilder upload(String caption, Upload.Receiver uploadReceiver) {
        return new SingleUploadBuilder(new Upload(caption, uploadReceiver));
    }

    public SingleUploadBuilder setButtonCaption(String buttonCaption) {
        upload.setButtonCaption(buttonCaption);
        return this;
    }

    public SingleUploadBuilder setCaption(final String caption) {
        upload.setCaption(caption);
        return this;
    }

    public SingleUploadBuilder setCaptionAsHtml(final Boolean captionAsHtml) {
        upload.setCaptionAsHtml(captionAsHtml);
        return this;
    }

    public SingleUploadBuilder setDescription(final String description) {
        upload.setDescription(description);
        return this;
    }

    public SingleUploadBuilder setReceiver(Upload.Receiver receiver) {
        upload.setReceiver(receiver);
        return this;
    }

    /**
     * Sets the immediate mode of the upload.
     If the upload is in immediate mode, the file upload is started immediately after the user has selected the file.
     If the upload is not in immediate mode, after selecting the file the user must click another button to start the upload.
     The default mode of an Upload Product is immediate.
     * @param immediateMode - true for immediate mode, false for not
     * @return
     */
    public SingleUploadBuilder setImmediateMode(boolean immediateMode) {
        upload.setImmediateMode(immediateMode);
        return this;
    }

    public SingleUploadBuilder styleName(final String styleName) {
        upload.setStyleName(styleName);
        return this;
    }

    public SingleUploadBuilder setVisible(final Boolean value) {
        upload.setVisible(value);
        return this;
    }

    public SingleUploadBuilder setTabIndex(final Integer tabIndex){
        upload.	setTabIndex(tabIndex);
        return this;
    }

    public SingleUploadBuilder setPrimaryStyleName(final String primaryStyleName) {
        upload.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public SingleUploadBuilder addChangeListener(final Upload.ChangeListener changeListener) {
        upload.addChangeListener(changeListener);
        return this;
    }

    public SingleUploadBuilder addFailedListener(final Upload.FailedListener failedListener) {
        upload.addFailedListener(failedListener);
        return this;
    }

    public SingleUploadBuilder addFinishedListener(final Upload.FinishedListener finishedListener) {
        upload.addFinishedListener(finishedListener);
        return this;
    }

    public SingleUploadBuilder addListener(final com.vaadin.ui.Component.Listener... listeners) {
        for (final com.vaadin.ui.Component.Listener listener : listeners) {
            upload.addListener(listener);
        }
        return this;
    }

    public SingleUploadBuilder addSucceededListener(final Upload.SucceededListener succeededListener) {
        upload.addSucceededListener(succeededListener);
        return this;
    }

    public SingleUploadBuilder addStartedListener(final Upload.StartedListener startedListener) {
        upload.addStartedListener(startedListener);
        return this;
    }

    public SingleUploadBuilder addProgressListener(Upload.ProgressListener progressListener) {
        upload.addProgressListener(progressListener);
        return this;
    }

    public SingleUploadBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            upload.addStyleName(styleName);
        }
        return this;
    }

    public SingleUploadBuilder setResponsive(final Boolean responsive) {
        upload.setResponsive(responsive);
        return this;
    }

    public SingleUploadBuilder setEnabled(final Boolean enabled) {
        upload.setEnabled(enabled);
        return this;
    }

}