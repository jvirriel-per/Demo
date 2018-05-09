package com.jvirriel.demo.frontend.components.custom.conditionalwizard;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.event.AbstractWizardEvent;

public class WizardNextButtonClickEvent extends AbstractWizardEvent {
    protected WizardNextButtonClickEvent(Wizard source) {
        super(source);
    }
}
