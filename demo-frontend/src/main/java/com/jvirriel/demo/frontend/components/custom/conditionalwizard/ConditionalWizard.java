package com.jvirriel.demo.frontend.components.custom.conditionalwizard;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import java.lang.reflect.Method;
import java.util.Stack;

public class ConditionalWizard extends Wizard {
    private Stack<WizardStep> registry = new Stack<>();
    private static final Method WIZARD_NEXT_BUTTON_CLICK_METHOD;

    static {
        try {
            WIZARD_NEXT_BUTTON_CLICK_METHOD = ConditionalWizardProgressListener.class
                    .getDeclaredMethod("nextButtonClicked", WizardNextButtonClickEvent.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(
                    "Internal error finding methods in Wizard", e);
        }
    }

    public WizardStep getCurrent() {
        return super.currentStep;
    }

    @Override
    public void next() {
        if (isLastStep(currentStep)) {
            super.finish();
        } else {
            fireEvent(new WizardNextButtonClickEvent(this));
        }
    }

    @Override
    public void back() {
        if (!registry.empty()) {
            super.activateStep(registry.pop());
        }
    }

    @Override
    public void activateStep(WizardStep step) {
        registry.push(super.currentStep);
        super.activateStep(step);
    }

    @Override
    public String getId(WizardStep step) {
        return super.getId(step);
    }

    public void addListener(ConditionalWizardProgressListener listener) {
        addListener(WizardNextButtonClickEvent.class, listener,
                WIZARD_NEXT_BUTTON_CLICK_METHOD);
        super.addListener(listener);
    }
}
