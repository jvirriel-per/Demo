package com.jvirriel.ui.alertdialog;

import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Clase de implementación del AlertDialog.
 */
public class DefaultAlertDialogFactory implements AlertDialog.Factory {

    protected static final String DEFAULT_CANCEL_CAPTION = "Cancel";

    private static final double MIN_WIDTH = 20d;
    private static final double MAX_WIDTH = 40d;
    private static final double MIN_HEIGHT = 1d;
    private static final double MAX_HEIGHT = 30d;

    public AlertDialog createAlertInfo(final String caption, final String message,
                                       final String okCaption, final String cancelCaption,
                                       final String notOkCaption, final String width) {

        final AlertDialog info = new AlertDialog();
        info.setClosable(false);
        info.setId(AlertDialog.DIALOG_ID);

        String headerCaption = "Información";
        String confirmStyle = "v-confirm-color";
        Resource icon = VaadinIcons.INFO_CIRCLE;

        buildAlertContent(info, headerCaption, message, icon, cancelCaption, confirmStyle, width);

        return info;
    }

    @Override
    public AlertDialog createAlertDelete(String windowCaption, String message, String okTitle, String cancelTitle,
                                         String notOKCaption, String width) {
        AlertDialog deleteAlert = new AlertDialog();
        deleteAlert.setId(AlertDialog.DIALOG_ID);
        deleteAlert.setClosable(false);

        String deleteStyle = "v-confirm-color";
        Resource icon = VaadinIcons.FILE_REMOVE;

        buildConfirmAlert(deleteAlert, windowCaption, message, okTitle, cancelTitle, deleteStyle, icon);

        return deleteAlert;
    }


    public AlertDialog createAlertDanger(final String caption, final String message,
                                         final String okCaption, final String cancelCaption,
                                         final String notOkCaption, final String width) {

        final AlertDialog confirm = new AlertDialog();
        confirm.setClosable(false);
        confirm.setId(AlertDialog.DIALOG_ID);

        String headerCaption = "Error";
        String dangerStyle = "v-danger-color";
        Resource icon = VaadinIcons.BAN;

        buildAlertContent(confirm, headerCaption, message, icon, cancelCaption, dangerStyle, width);

        return confirm;
    }

    @Override
    public AlertDialog createAlertSuccess(String windowCaption, String message, String okTitle, String cancelTitle,
                                          String notOkCaption, String width) {

        final AlertDialog confirm = new AlertDialog();
        confirm.setClosable(false);
        confirm.setId(AlertDialog.DIALOG_ID);

        String headerCaption = "Éxito";
        String successStyle = "v-success-custom";
        Resource icon = VaadinIcons.CHECK_CIRCLE;

        buildAlertContent(confirm, headerCaption, message, icon, cancelTitle, successStyle, width);

        return confirm;
    }


    public AlertDialog createAlertWarning(final String caption, final String message,
                                          final String okCaption, final String cancelCaption,
                                          final String notOkCaption, String width) {

        final AlertDialog confirm = new AlertDialog();
        confirm.setClosable(false);
        confirm.setId(AlertDialog.DIALOG_ID);

        String headerCaption = "Advertencia";
        String warningStyle = "v-warning-color";

        Resource icon = VaadinIcons.WARNING;

        buildAlertContent(confirm, headerCaption, message, icon, cancelCaption, warningStyle, width);

        return confirm;
    }

    private void buildAlertContent(AlertDialog alertDialog, String headerCaption, String message, Resource icon,
                                   String cancelCaption, String confirmStyle, String width) {

        alertDialog.addCloseListener((Window.CloseListener) ce -> {
            if (alertDialog.isEnabled()) {
                alertDialog.setConfirmed(false);
                alertDialog.setEnabled(false);
                if (alertDialog.getListener() != null) {
                    alertDialog.getListener().onClose(alertDialog);
                }
            }
        });

        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.setMargin(false);

        alertDialog.setContent(content);

        HorizontalLayout topAlert = new HorizontalLayout();
        topAlert.setWidth("100%");
        topAlert.setHeight("45px");
        topAlert.setMargin(false);
        topAlert.addStyleName("v-align-right-custom");
        topAlert.setPrimaryStyleName("v-window-header-custom");

        Button header = new Button(headerCaption);
        header.setIcon(icon, "");
        header.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        header.addStyleName(ValoTheme.LABEL_BOLD);
        header.addStyleName(confirmStyle);

        topAlert.addComponents(header);
        topAlert.setComponentAlignment(header, Alignment.MIDDLE_LEFT);

        VerticalLayout scrollContent = new VerticalLayout();
        scrollContent.addStyleName("v-align-right-custom");
        scrollContent.setMargin(new MarginInfo(false, false, false, true));

        Label text = new Label("", ContentMode.HTML);
        text.addStyleName("v-margin-left-custom");
        text.addStyleName(ValoTheme.LABEL_TINY);
        text.setId(AlertDialog.MESSAGE_ID);

        scrollContent.addComponents(text);

        alertDialog.setMessageLabel(text);
        alertDialog.setMessage(message);

        CssLayout buttons = new CssLayout();
        buttons.setWidth("100%");
        buttons.setHeight("53px");
        buttons.addStyleName("alert-footer");
        buttons.addStyleName("v-align-right-custom");

        content.addComponents(topAlert, scrollContent, buttons);
        content.setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);

        Button cancel = new Button(cancelCaption != null ? cancelCaption : DEFAULT_CANCEL_CAPTION);
        cancel.setPrimaryStyleName("button-alert");
        cancel.setStyleName("small");
        cancel.setData(null);
        cancel.setWidth(width);
        cancel.setId(AlertDialog.CANCEL_ID);

        buttons.addComponent(cancel);
        alertDialog.setCancelButton(cancel);

        Button.ClickListener cb = (Button.ClickListener) (Button.ClickEvent event) -> {
            if (alertDialog.isEnabled()) {
                alertDialog.setEnabled(false);

                Button b;
                b = event.getButton();
                if (b != cancel)
                    alertDialog.setConfirmed(b == cancel);

                UI parent;
                parent = alertDialog.getUI();
                parent.removeWindow(alertDialog);

                if (alertDialog.getListener() != null) {
                    alertDialog.getListener().onClose(alertDialog);
                }
            }
        };

        cancel.addClickListener(cb);

        double[] dim = getDialogDimensions(message, AlertDialog.ContentModeAux.TEXT_WITH_NEWLINES);
        alertDialog.setWidth(format(dim[0]) + "em");
        alertDialog.setHeight(format(dim[1]) + "em");
        alertDialog.setResizable(false);
    }

    private void buildConfirmAlert(AlertDialog confirmDialog, String headerCaption, String message, String okCaption,
                                   String cancelCaption, String styleName, Resource icon) {

        confirmDialog.addCloseListener((Window.CloseListener) ce -> {
            if (confirmDialog.isEnabled()) {
                confirmDialog.setEnabled(false);
                confirmDialog.setConfirmed(false);
                if (confirmDialog.getListener() != null) {
                    confirmDialog.getListener().onClose(confirmDialog);
                }
            }
        });

        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.setMargin(false);

        confirmDialog.setContent(content);

        HorizontalLayout topAlert = new HorizontalLayout();
        topAlert.setWidth("100%");
        topAlert.setHeight("45px");
        topAlert.setMargin(false);
        topAlert.addStyleName("v-align-right-custom");
        topAlert.setPrimaryStyleName("v-window-header-custom");

        Button header = new Button(headerCaption);
        header.setIcon(icon, "");
        header.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        header.addStyleName(ValoTheme.LABEL_BOLD);
        header.addStyleName(styleName);
        header.setEnabled(true);

        topAlert.addComponents(header);
        topAlert.setComponentAlignment(header, Alignment.MIDDLE_LEFT);

        VerticalLayout scrollContent = new VerticalLayout();
        scrollContent.addStyleName("v-align-right-custom");
        scrollContent.setMargin(new MarginInfo(false, false, false, false));

        Label text = new Label("", ContentMode.HTML);
        text.addStyleName(ValoTheme.LABEL_TINY);
        text.addStyleName("v-margin-left-custom");
        text.setId(AlertDialog.MESSAGE_ID);

        scrollContent.addComponents(text);
        confirmDialog.setMessageLabel(text);
        confirmDialog.setMessage(message);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setWidth("100%");
        buttons.setHeight("53px");
        buttons.setMargin(false);
        buttons.setSpacing(false);
        buttons.addStyleName("alert-footer");
        buttons.addStyleName("v-align-right-custom");
        buttons.setPrimaryStyleName("v-slot-custom");

        content.addComponents(topAlert, scrollContent, buttons);
        content.setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);

        final Button ok = new Button(okCaption != null ? okCaption : "Si");
        ok.setData(true);
        ok.setPrimaryStyleName("button-alert");
        ok.setStyleName("small");
        ok.setId(AlertDialog.OK_ID);
        ok.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        buttons.addComponent(ok);

        confirmDialog.setOkButton(ok);

        final Button cancel = new Button(cancelCaption != null ? cancelCaption : DEFAULT_CANCEL_CAPTION);
        cancel.setPrimaryStyleName("button-alert");
        cancel.setStyleName("small");
        cancel.setData(null);
        cancel.setId(AlertDialog.CANCEL_ID);

        buttons.addComponent(cancel);

        confirmDialog.setCancelButton(cancel);

        Button.ClickListener cb = (Button.ClickListener) event -> {
            if (confirmDialog.isEnabled()) {
                confirmDialog.setEnabled(false);

                Button b = event.getButton();
                if (b != cancel)
                    confirmDialog.setConfirmed(b == cancel);

                UI parent;
                parent = confirmDialog.getUI();
                parent.removeWindow(confirmDialog);

                if (confirmDialog.getListener() != null) {
                    confirmDialog.getListener().onClose(confirmDialog);
                }
            }
        };

        Button.ClickListener cbOk = (Button.ClickListener) event -> {
            if (confirmDialog.isEnabled()) {
                confirmDialog.setEnabled(false);

                Button b;
                b = event.getButton();
                if (b != cancel)
                    confirmDialog.setConfirmed(b == ok);

                UI parent = confirmDialog.getUI();
                parent.removeWindow(confirmDialog);

                if (confirmDialog.getListener() != null) {
                    confirmDialog.getListener().onClose(confirmDialog);
                }
            }
        };

        ok.addClickListener(cbOk);
        cancel.addClickListener(cb);

        double[] dim = getDialogDimensions(message,
                AlertDialog.ContentModeAux.TEXT_WITH_NEWLINES);
        confirmDialog.setWidth(format(dim[0]) + "em");
        confirmDialog.setHeight(format(dim[1]) + "em");
        confirmDialog.setResizable(false);
    }

    /**
     * Approximates the dialog dimensions based on its message length.
     *
     * @param message Message string
     * @return approximate size for the dialog with given message
     */
    protected double[] getDialogDimensions(String message,
                                           AlertDialog.ContentModeAux style) {

        double chrW = 0.51d;
        double chrH = 1.5d;
        double length = message != null ? chrW * message.length() : 0;
        double rows = Math.ceil(length / MAX_WIDTH);

        if (style == AlertDialog.ContentModeAux.TEXT_WITH_NEWLINES) {
            rows += message != null ? count("\n", message) : 0;
        }

        double width = Math.min(MAX_WIDTH, length);
        double height = Math.ceil(Math.min(MAX_HEIGHT, rows * chrH));

        width = Math.max(width, MIN_WIDTH);
        height = Math.max(height, MIN_HEIGHT);

        double btnHeight = 4d;
        double vMargin = 5d;
        double hMargin = 1d;

        double[] res = new double[]{width + hMargin, height + btnHeight + vMargin};

        return res;
    }

    /**
     * Count the number of needles within a haystack.
     *
     * @param needle   The string to search for.
     * @param haystack The string to process.
     * @return count of needles within a haystack
     */
    private static int count(final String needle, final String haystack) {
        int count = 0;
        int pos = -1;
        while ((pos = haystack.indexOf(needle, pos + 1)) >= 0) {
            count++;
        }
        return count;
    }

    /**
     * Format a double single fraction digit.
     *
     * @param n
     * @return
     */
    private String format(double n) {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
        nf.setMaximumFractionDigits(1);
        nf.setGroupingUsed(false);
        return nf.format(n);
    }

}