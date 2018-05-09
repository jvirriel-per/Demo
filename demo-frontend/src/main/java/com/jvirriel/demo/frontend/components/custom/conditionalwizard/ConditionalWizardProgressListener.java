package com.jvirriel.demo.frontend.components.custom.conditionalwizard;

import org.vaadin.teemu.wizards.event.WizardProgressListener;

public interface ConditionalWizardProgressListener extends WizardProgressListener {
    void nextButtonClicked(WizardNextButtonClickEvent event);
}
