package com.jvirriel.demo.frontend.components.custom.conditionalwizard;

import com.vaadin.ui.Component;
import org.vaadin.teemu.wizards.WizardStep;

public class CustomWizardStep implements WizardStep {
    private String caption;
    private Component content;
    private boolean advance, back;

    public CustomWizardStep() {

    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setContent(Component content) {
        this.content = content;
    }

    public void setAdvance(boolean advance) {
        this.advance = advance;
    }

    public void setBack(boolean back) {
        this.back = back;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public Component getContent() {
        return content;
    }

    @Override
    public boolean onAdvance() {
        return advance;
    }

    @Override
    public boolean onBack() {
        return back;
    }
}
