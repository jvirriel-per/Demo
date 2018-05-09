package com.jvirriel.demo.frontend.components.custom.conditionalwizard;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import org.vaadin.teemu.wizards.WizardStep;
import org.vaadin.teemu.wizards.event.WizardProgressListener;


import java.util.List;

public class ConditionalWizardBuilder {
    private final ConditionalWizard wizard;

    private ConditionalWizardBuilder(ConditionalWizard wizard) {
        this.wizard = wizard;
    }

    public ConditionalWizard get() {
        return wizard;
    }

    public static ConditionalWizardBuilder conditionalWizard() {
        return new ConditionalWizardBuilder(new ConditionalWizard());
    }

    public ConditionalWizardBuilder addListener(ConditionalWizardProgressListener listener) {
        wizard.addListener(listener);
        return this;
    }

    public ConditionalWizardBuilder addStep(final WizardStep step, final String id) {
        wizard.addStep(step, id);
        return this;
    }

    public ConditionalWizardBuilder addStep(final WizardStep step) {
        wizard.addStep(step);
        return this;
    }

    public ConditionalWizardBuilder addSteps(final WizardStep... steps) {
        for (final WizardStep step : steps) {
            wizard.addStep(step);
        }
        return this;
    }

    public ConditionalWizardBuilder addSteps(List<WizardStep> steps) {
        for (final WizardStep step : steps) {
            wizard.addStep(step);
        }
        return this;
    }

    public ConditionalWizardBuilder addStyleName(final String... styleNames) {
        for (final String styleName : styleNames) {
            wizard.addStyleName(styleName);
        }
        return this;
    }

    public ConditionalWizardBuilder setBackButtonCaption(final String caption) {
        wizard.getBackButton().setCaption(caption);
        return this;
    }

    public ConditionalWizardBuilder setCancelButtonCaption(final String caption) {
        wizard.getCancelButton().setCaption(caption);
        return this;
    }

    public ConditionalWizardBuilder setEnabled(final boolean enabled) {
        wizard.setEnabled(enabled);
        return this;
    }

    public ConditionalWizardBuilder setFinishButtonCaption(final String caption) {
        wizard.getFinishButton().setCaption(caption);
        return this;
    }

    public ConditionalWizardBuilder setHeight(final String height) {
        wizard.setWidth(height);
        return this;
    }

    public ConditionalWizardBuilder setHeight(final Float height, final Sizeable.Unit unit) {
        wizard.setWidth(height, unit);
        return this;
    }

/*    public ConditionalWizardBuilder setImmediate(final boolean immediate) {
        wizard.setImmediate(immediate);
        return this;
    }*/

    public ConditionalWizardBuilder setNextButtonCaption(final String caption) {
        wizard.getNextButton().setCaption(caption);
        return this;
    }

    public ConditionalWizardBuilder setPrimaryStyleName(final String primaryStyleName) {
        wizard.setPrimaryStyleName(primaryStyleName);
        return this;
    }

/*    public ConditionalWizardBuilder setReadOnly(final boolean readOnly) {
        wizard.setReadOnly(readOnly);
        return this;
    }*/

    public ConditionalWizardBuilder setSizeFull() {
        wizard.setSizeFull();
        return this;
    }

    public ConditionalWizardBuilder setStyleName(final String styleName) {
        wizard.setStyleName(styleName);
        return this;
    }

    public ConditionalWizardBuilder setStyleName(final String styleName, final boolean add) {
        wizard.setStyleName(styleName, add);
        return this;
    }

    public ConditionalWizardBuilder setUriFragmentEnabled(final boolean uriFragmentedEnabled) {
        wizard.setUriFragmentEnabled(uriFragmentedEnabled);
        return this;
    }

    public ConditionalWizardBuilder setVisible(final boolean visible) {
        wizard.setVisible(visible);
        return this;
    }

    public ConditionalWizardBuilder setWidth(final String width) {
        wizard.setWidth(width);
        return this;
    }

    public ConditionalWizardBuilder setWidth(final Float width, final Sizeable.Unit unit) {
        wizard.setWidth(width, unit);
        return this;
    }

    public ConditionalWizardBuilder withoutProgressBar() {
        Component defaultHeader = wizard.getHeader();
        if (defaultHeader instanceof WizardProgressListener) {
            wizard.removeListener((WizardProgressListener) defaultHeader);
        }
        wizard.setHeader(null);
        return this;
    }
}
