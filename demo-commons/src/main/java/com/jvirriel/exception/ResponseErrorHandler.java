package com.jvirriel.exception;


import com.jvirriel.ui.alertdialog.AlertDialog;
import com.vaadin.ui.UI;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

import static com.jvirriel.constants.GeneralConstants.EMPTY_STRING;
import static com.jvirriel.property.PropertyUtil.getProperty;
import static com.jvirriel.ui.constants.GeneralConstants.OK_LABEL;
import static com.jvirriel.ui.constants.ValidationConstants.*;

/**
 * Manejador de errores por defecto para RestTemplate.

 */
public class ResponseErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        switch (clientHttpResponse.getStatusCode()) {
            case FORBIDDEN:
                AlertDialog.danger(UI.getCurrent(), EMPTY_STRING, UNAUTHENTICATED_USER, EMPTY_STRING, OK_LABEL,
                        this::forbiddenListenerOnClose, null);
                break;
            case NOT_FOUND:
                AlertDialog.danger(UI.getCurrent(), EMPTY_STRING, REQUESTED_INFO_NOT_FOUND, EMPTY_STRING, OK_LABEL,
                        this::notFoundListenerOnClose, null);
                break;
            case INTERNAL_SERVER_ERROR:
                AlertDialog.danger(UI.getCurrent(), EMPTY_STRING, UNEXPECTED_ERROR_NOT_FOUND, EMPTY_STRING, OK_LABEL,
                        this::internalListenerOnClose, null);
                break;
            default:
                AlertDialog.danger(UI.getCurrent(), EMPTY_STRING, UNKNOWN_ERROR, EMPTY_STRING, OK_LABEL,
                        this::defaultListenerOnClose, null);
        }
    }

    private void forbiddenListenerOnClose(AlertDialog dialog) {
        UI.getCurrent().getPage().setLocation(getProperty("urlRedirect"));

    }

    private void notFoundListenerOnClose(AlertDialog dialog) {
        if (dialog.isConfirmed()) {
        }
    }

    private void internalListenerOnClose(AlertDialog dialog) {
        UI.getCurrent().getPage().setLocation(getProperty("urlRedirect"));
    }

    private void defaultListenerOnClose(AlertDialog dialog) {
        UI.getCurrent().getPage().setLocation(getProperty("urlRedirect"));
    }
}
