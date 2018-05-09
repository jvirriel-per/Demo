package com.jvirriel.demo.frontend.components.core;

import com.pt.components.custom.conditionalwizard.CustomWizardStep;
import com.vaadin.ui.Component;
import org.vaadin.teemu.wizards.WizardStep;

public class WizardStepBuilder {
    private final CustomWizardStep instance;

    private WizardStepBuilder() {
        this.instance = new CustomWizardStep();
    }

    public static WizardStepBuilder wizardStep() {
        return new WizardStepBuilder();
    }

    public WizardStepBuilder setCaption(final String caption) {
        this.instance.setCaption(caption);
        return this;
    }

    public WizardStepBuilder setContent(final Component content) {
        this.instance.setContent(content);
        return this;
    }

    public WizardStepBuilder setOnAdvance(final boolean onAdvance) {
        this.instance.setAdvance(onAdvance);
        return this;
    }

    public WizardStepBuilder setOnReturn(final boolean onReturn) {
        this.instance.setBack(onReturn);
        return this;
    }

    public WizardStep get() {
        return instance;
    }

}
