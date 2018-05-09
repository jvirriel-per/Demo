package com.jvirriel.ui.alertdialog;

import com.vaadin.server.JsonPaintTarget;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import java.io.Serializable;

/**
 * Construye los diferentes tipos de alerta.
 */
public class AlertDialog extends Window {

    private static final long serialVersionUID = -2363125714643244070L;

    public interface Factory extends Serializable {
        AlertDialog createAlertInfo(String windowCaption, String message,
                                    String okTitle, String cancelTitle, String notOKCaption, String width);

        AlertDialog createAlertDelete(String windowCaption, String message,
                                      String okTitle, String cancelTitle, String notOKCaption, String width);

        AlertDialog createAlertDanger(String windowCaption, String message,
                                      String okTitle, String cancelTitle, String notOKCaption, String width);

        AlertDialog createAlertSuccess(String windowCaption, String message,
                                       String okTitle, String cancelTitle, String notOKCaption, String width);

        AlertDialog createAlertWarning(String windowCaption, String message,
                                       String okTitle, String cancelTitle, String notOKCaption, String width);
    }

    public static final String DIALOG_ID = "confirmdialog-window";
    public static final String MESSAGE_ID = "confirmdialog-message";
    public static final String OK_ID = "confirmdialog-ok-button";
    public static final String NOT_OK_ID = "confirmdialog-not-ok-button";
    public static final String CANCEL_ID = "confirmdialog-cancel-button";

    public enum ContentModeAux {
        TEXT_WITH_NEWLINES, TEXT, PREFORMATTED, HTML
    }

    /**
     * Listener for dialog close events. Implement and register an instance of
     * this interface to dialog to receive close events.
     *
     * @author Sami Ekblad
     *
     */
    public interface Listener extends Serializable {
        void onClose(AlertDialog dialog);
    }

    /**
     * Default dialog factory.
     *
     */
    private static Factory factoryInstance;

    /**
     * Get the ConfirmDialog.Factory used to create and configure the dialog.
     *
     *
     * @return the currently used ConfirmDialog.Factory
     */
    public static Factory getFactory() {
        if (factoryInstance == null) {
            factoryInstance =  new DefaultAlertDialogFactory();
        }
        return factoryInstance;
    }

    /**
     * Show a modal ConfirmDialog in a window.
     *
     * @param ui
     *            Main level UI.
     * @param windowCaption
     *            Caption for the confirmation dialog window.
     * @param message
     *            Message to display as window content.
     * @param okCaption
     *            Caption for the ok button.
     * @param cancelCaption
     *            Caption for cancel button.
     * @param listener
     *            Listener for dialog result.
     * @return the ConfirmDialog that was instantiated
     */
    public static AlertDialog info(final UI ui,
                                   final String windowCaption, final String message,
                                   final String okCaption, final String cancelCaption,
                                   final Listener listener, String width) {

        AlertDialog d = getFactory().createAlertInfo(windowCaption, message,
                okCaption, cancelCaption, null, width);
        d.show(ui, listener, true);
        return d;
    }

    /**
     * Construye la ventana de tipo success
     * @param ui
     * @param windowCaption
     * @param message
     * @param okCaption
     * @param cancelCaption
     * @param listener
     * @return
     */
    public static AlertDialog success(final UI ui,
                                      final String windowCaption, final String message,
                                      final String okCaption, final String cancelCaption,
                                      final Listener listener, String width) {

        AlertDialog d = getFactory().createAlertSuccess(windowCaption, message,
                okCaption, cancelCaption, null, width);
        d.show(ui, listener, true);
        return d;
    }


    /**
     * Construye la ventana de tipo danger
     * @param ui
     * @param windowCaption
     * @param message
     * @param okCaption
     * @param cancelCaption
     * @param listener
     * @return
     */
    public static AlertDialog danger(final UI ui,
                                     final String windowCaption, final String message,
                                     final String okCaption, final String cancelCaption,
                                     final Listener listener, String width) {

        AlertDialog d = getFactory().createAlertDanger(windowCaption, message,
                okCaption, cancelCaption, null, width);
        d.show(ui, listener, true);
        return d;
    }

    /**
     * Construye la ventana de tipo warning
     * @param ui
     * @param windowCaption
     * @param message
     * @param okCaption
     * @param cancelCaption
     * @param listener
     * @return
     */
    public static AlertDialog warning(final UI ui,
                                      final String windowCaption, final String message,
                                      final String okCaption, final String cancelCaption,
                                      final Listener listener, String width) {

        AlertDialog d = getFactory().createAlertWarning(windowCaption, message,
                okCaption, cancelCaption, null, width);
        d.show(ui, listener, true);
        return d;
    }

    /**
     * Show a modal ConfirmDialog in a window.
     *
     * @param ui
     *            Main level UI.
     * @param windowCaption
     *            Caption for the confirmation dialog window.
     * @param message
     *            Message to display as window content.
     * @param okCaption
     *            Caption for the ok button.
     * @param cancelCaption
     *            Caption for cancel button.
     * @param listener
     *            Listener for dialog result.
     * @return the ConfirmDialog that was instantiated
     */
    public static AlertDialog delete(final UI ui,
                                     final String windowCaption, final String message,
                                     final String okCaption, final String cancelCaption,
                                     final Listener listener, String width) {
        AlertDialog d = getFactory().createAlertDelete(windowCaption, message,
                okCaption, cancelCaption, null, width);
        d.show(ui, listener, true);

        return d;
    }

    private Listener confirmListener = null;
    private Boolean isConfirmed = null;
    private Label messageLabel = null;
    private Button okBtn = null;
    private Button cancelBtn = null;
    private String originalMessageText;
    private ContentModeAux msgContentMode = ContentModeAux.TEXT_WITH_NEWLINES;

    /**
     * Show confirm dialog.
     *
     * @param ui the UI in which the dialog should be shown
     * @param listener the listener to be notified
     * @param modal true if the dialog should be modal
     */
    public final void show(final UI ui, final Listener listener,
                           final boolean modal) {
        confirmListener = listener;
        center();
        setModal(modal);
        ui.addWindow(this);
    }

    /**
     * Did the user confirm the dialog.
     *
     * @return true if user confirmed
     */
    public final boolean isConfirmed() {
        return isConfirmed != null && isConfirmed;
    }

    /**
     * Did the user cancel the dialog.
     *
     * @return true if the dialog was canceled
     */
    public final boolean isCanceled() {
        return isConfirmed == null;
    }

    public final Listener getListener() {
        return confirmListener;
    }

    protected final void setOkButton(final Button okButton) {
        okBtn = okButton;
    }

    public final Button getOkButton() {
        return okBtn;
    }

    protected final void setCancelButton(final Button cancelButton) {
        cancelBtn = cancelButton;
    }

    public final Button getCancelButton() {
        return cancelBtn;
    }

    protected final void setMessageLabel(final Label message) {
        messageLabel = message;
    }

    public final void setMessage(final String message) {
        originalMessageText = message;
        messageLabel
                .setValue(ContentModeAux.TEXT_WITH_NEWLINES == msgContentMode ? formatDialogMessage(message)
                        : message);
    }

    public final String getMessage() {
        return originalMessageText;
    }

    public final ContentModeAux getContentMode() {
        return msgContentMode;
    }

    public final void setContentMode(final ContentModeAux contentMode) {
        msgContentMode = contentMode;
        ContentMode labelContentMode = ContentMode.TEXT;
        switch (contentMode) {
            case TEXT_WITH_NEWLINES:
            case TEXT:
                labelContentMode = ContentMode.TEXT;
                break;
            case PREFORMATTED:
                labelContentMode = ContentMode.PREFORMATTED;
                break;
            case HTML:
                labelContentMode = ContentMode.HTML;
                break;
        }
        messageLabel
                .setContentMode(labelContentMode);
        messageLabel
                .setValue(contentMode == ContentModeAux.TEXT_WITH_NEWLINES ? formatDialogMessage(originalMessageText)
                        : originalMessageText);
    }

    /**
     * Format the messageLabel by maintaining text only.
     *
     * @param text the text to be formatted
     * @return formatted text
     */
    protected final String formatDialogMessage(final String text) {
        return JsonPaintTarget.escapeXML(text).replaceAll("\n", "<br />");
    }

    /**
     * Set the isConfirmed state.
     *
     * Note: this should only be called internally by the listeners.
     *
     * @param confirmed true if dialog was confirmed
     */
    protected final void setConfirmed(final boolean confirmed) {
        isConfirmed = confirmed;
    }
}