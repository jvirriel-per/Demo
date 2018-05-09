package com.jvirriel.demo.frontend.components.core;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;
import org.vaadin.teemu.wizards.event.WizardProgressListener;

import java.util.List;

/**
 * Clase <i>Builder</i> para crear un componente Add-on Vaadin del tipo Wizard.
 * Para más información acerca de los métodos, ver la
 * <a href="https://github.com/tehapo/WizardsForVaadin/blob/master/README.md">documentación de referencia</a> en la
 * página del add-on.
 */
public class WizardBuilder {

    private final Wizard wizard;

    /**
     * Hide constructor, use static factory methods.
     */
    private WizardBuilder(final Wizard wizard) {
        this.wizard = wizard;
    }

    /**
     * Crea un componente del tipo Wizard.
     *
     * @return the created instance
     */
    public final Wizard get() {
        return wizard;
    }

    /**
     * Genera un Wizard vacío.
     *
     * @return the current Builder object
     */
    public static WizardBuilder wizard() {
        return new WizardBuilder(new Wizard());
    }

    /**
     * (non-Javadoc)
     *
     * @param listener  listener para ser agregado
     * @return          el objeto actual
     */
    public WizardBuilder addListener(WizardProgressListener listener) {
        wizard.addListener(listener);
        return this;
    }

    /**
     * Agrega un paso al Wizard identificado por un fragmento que se añade a la URL.
     *
     * @param step          paso a ser agregado
     * @param uriFragment   fragmento d eLla URI que identifica al paso actual
     * @return              el objeto actual
     */
    public WizardBuilder addStep(final WizardStep step, final String uriFragment) {
        wizard.addStep(step, uriFragment);
        return this;
    }

    /**
     * Agrega uno o varios pasos al Wizard. Se mostrarán en el ordén en que fueron asignados.
     *
     * @param steps los pasos a ser agregados
     * @return      el objeto actual
     */
    public WizardBuilder addSteps(final WizardStep... steps) {
        for (final WizardStep step : steps) {
            wizard.addStep(step);
        }
        return this;
    }

    public WizardBuilder addSteps(List<WizardStep> steps) {
        for (final WizardStep step : steps) {
            wizard.addStep(step);
        }
        return this;
    }

    public WizardBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            wizard.addStyleName(styleName);
        }
        return this;
    }

    /**
     * Asigna el texto que se muestra en el botón Anterior.
     *
     * @param caption   texto del botón Anterior (Back)
     * @return          el objeto actual
     */
    public WizardBuilder setBackButtonCaption(final String caption) {
        wizard.getBackButton().setCaption(caption);
        return this;
    }

    /**
     * Asigna el texto que se muestra en el botón Cancelar.
     *
     * @param caption   texto del botón Cancelar (Cancel)
     * @return          el objeto actual
     */
    public WizardBuilder setCancelButtonCaption(final String caption) {
        wizard.getCancelButton().setCaption(caption);
        return this;
    }

    public WizardBuilder setEnabled(final boolean enabled) {
        wizard.setEnabled(enabled);
        return this;
    }

    /**
     * Asigna el texto que se muestra en el botón Finalizar.
     *
     * @param caption   texto del botón Finalizar (Finish)
     * @return          el objeto actual
     */
    public WizardBuilder setFinishButtonCaption(final String caption) {
        wizard.getFinishButton().setCaption(caption);
        return this;
    }

    public WizardBuilder setHeight(final String height) {
        wizard.setWidth(height);
        return this;
    }

    public WizardBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        wizard.setWidth(height, unit);
        return this;
    }

    /**
     * Asigna el texto que se muestra en el botón Siguiente.
     *
     * @param caption   texto del botón Siguiente (Next)
     * @return          el objeto actual
     */
    public WizardBuilder setNextButtonCaption(final String caption) {
        wizard.getNextButton().setCaption(caption);
        return this;
    }

    public WizardBuilder setPrimaryStyleName(final String primaryStyleName) {
        wizard.setPrimaryStyleName(primaryStyleName);
        return this;
    }

    public WizardBuilder setSizeFull() {
        wizard.setSizeFull();
        return this;
    }

    public WizardBuilder setStyleName(final String styleName) {
        wizard.setStyleName(styleName);
        return this;
    }

    public WizardBuilder setStyleName(final String styleName, final boolean add) {
        wizard.setStyleName(styleName, add);
        return this;
    }

    /**
     * Activa o desactiva la navegación por URL. Cada paso del Wizard puede ser identificado con una URI
     * que se añade al final de la URL de la vista, lo que permite avanzar o retroceder en el Wizard con
     * los botones Anterior/Siguiente del navegador.
     *
     * @param uriFragmentedEnabled  indica si se activa o desactiva la navegación por URL
     * @return                      el objeto actual
     */
    public WizardBuilder setUriFragmentEnabled(final boolean uriFragmentedEnabled) {
        wizard.setUriFragmentEnabled(uriFragmentedEnabled);
        return this;
    }

    public WizardBuilder setVisible(final boolean visible) {
        wizard.setVisible(visible);
        return this;
    }

    public WizardBuilder setWidth(final String width) {
        wizard.setWidth(width);
        return this;
    }

    public WizardBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        wizard.setWidth(width, unit);
        return this;
    }

    /**
     * Desactiva la barra de progreso en la cabecera del Wizard.
     *
     * @return el objeto actual
     */
    public WizardBuilder withoutProgressBar() {
        Component defaultHeader = wizard.getHeader();
        if (defaultHeader instanceof WizardProgressListener) {
            wizard.removeListener((WizardProgressListener) defaultHeader);
        }
        wizard.setHeader(null);
        return this;
    }
}
