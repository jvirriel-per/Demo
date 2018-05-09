package com.jvirriel.exception;

import com.jvirriel.ui.alertdialog.AlertDialog;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.ErrorEvent;
import com.vaadin.ui.UI;
import org.springframework.dao.NonTransientDataAccessException;

import static com.jvirriel.constants.GeneralConstants.EMPTY_STRING;
import static com.jvirriel.ui.constants.GeneralConstants.OK_LABEL;

/**
 * Manejador de errores para las vistas.
 */
public class ViewErrorHandler extends DefaultErrorHandler {
    public AlertDialog alertDialog;

    @Override
    public void error(ErrorEvent event) {
//        String cause = "Error debido a: "+"\n";
//        for (Throwable t = event.getThrowable(); t != null;
//             t = t.getCause())
//            if (t.getCause() == null)
//                cause += t.getClass().getName();
//        System.out.println("Ocurrió el error "+cause);

        event.getThrowable().printStackTrace();

        if (event.getThrowable() instanceof NonTransientDataAccessException){
            System.out.println("Violación de restricción de base de datos");

        }else if (event.getThrowable() instanceof EntityVersionConflictException){
            AlertDialog.danger(UI.getCurrent(), EMPTY_STRING, "Error de version, volver a cargar", EMPTY_STRING, OK_LABEL, dialog -> {
            }, null);
        } else {

            AlertDialog.danger(UI.getCurrent(), EMPTY_STRING, "Ha ocurrido un error", EMPTY_STRING, OK_LABEL, dialog -> {
            }, null);

        }
    }


}