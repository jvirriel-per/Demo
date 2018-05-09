package com.jvirriel.demo.frontend.components;

import com.jvirriel.demo.frontend.components.core.*;
import com.jvirriel.demo.frontend.components.custom.conditionalwizard.ConditionalWizardBuilder;
import com.vaadin.data.HasValue;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.BorderStyle;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.UploadFinishedHandler;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.UploadStartedHandler;
import com.wcs.wcslib.vaadin.widget.multifileupload.ui.UploadStateWindow;

import java.time.LocalDate;

import java.util.Collection;

public final class ComponentFactory {

    public static AccordionBuilder accordion() {
        return AccordionBuilder.accordion();
    }

    public static AccordionBuilder accordion(Component... components) {
        return AccordionBuilder.accordion(components);
    }

    public static BrowserFrameBuilder browserFrame() {
        return BrowserFrameBuilder.browserFrame();
    }

    public static BrowserFrameBuilder browserFrame(String caption) {
        return BrowserFrameBuilder.browserFrame(caption);
    }

    public static BrowserFrameBuilder browserFrame(String caption, Resource resource) {
        return BrowserFrameBuilder.browserFrame(caption, resource);
    }

    public static ButtonBuilder button() {
        return ButtonBuilder.button();
    }

    public static ButtonBuilder button(final Resource icon) {
        return ButtonBuilder.button(icon);
    }

    public static ButtonBuilder button(final String caption) {
        return ButtonBuilder.button(caption);
    }

    public static ButtonBuilder button(final String caption, final Resource icon) {
        return ButtonBuilder.button(caption, icon);
    }

    public static ButtonBuilder button(String caption, Button.ClickListener listener) {
        return ButtonBuilder.button(caption, listener);
    }

    public static CheckBoxBuilder checkBox() {
        return CheckBoxBuilder.checkBox();
    }

    public static CheckBoxBuilder checkBox(String caption) {
        return CheckBoxBuilder.checkBox(caption);
    }

    public static CheckBoxBuilder checkBox(final String caption, final boolean initialState) {
        return CheckBoxBuilder.checkBox(caption, initialState);
    }

    public static CheckBoxGroupBuilder checkBoxGroup() {
        return CheckBoxGroupBuilder.checkBoxGroup();
    }

    public static CheckBoxGroupBuilder checkBoxGroup(String caption) {
        return CheckBoxGroupBuilder.checkBoxGroup(caption);
    }

    public static CheckBoxGroupBuilder checkBoxGroup(final String caption, final Collection<?> collection) {
        return CheckBoxGroupBuilder.checkBoxGroup(caption, collection);
    }

    public static CheckBoxGroupBuilder checkBoxGroup(final String caption, final DataProvider<?, ?> dataProvider) {
        return CheckBoxGroupBuilder.checkBoxGroup(caption, dataProvider);
    }

    public static ComboBoxBuilder comboBox() {
        return ComboBoxBuilder.comboBox();
    }

    public static ComboBoxBuilder comboBox(String caption) {
        return ComboBoxBuilder.comboBox(caption);
    }

    public static ComboBoxBuilder comboBox(final String caption, final Collection<?> options) {
        return ComboBoxBuilder.comboBox(caption, options);
    }

    public static ComboBoxMultiSelectBuilder comboBoxMultiSelect() {
        return ComboBoxMultiSelectBuilder.comboBoxMultiSelect();
    }

    public static ComboBoxMultiSelectBuilder comboBoxMultiSelect(String caption) {
        return ComboBoxMultiSelectBuilder.comboBoxMultiSelect(caption);
    }

    public static ComboBoxMultiSelectBuilder comboBoxMultiSelect(String caption, Collection<?> options) {
        return ComboBoxMultiSelectBuilder.comboBoxMultiSelect(caption, options);
    }

    public static CssLayoutBuilder cssLayout() {
        return CssLayoutBuilder.cssLayout();
    }

    public static CssLayoutBuilder cssLayout(Component... children) {
        return CssLayoutBuilder.cssLayout(children);
    }

    public static DateFieldBuilder dateField() {
        return DateFieldBuilder.dateField();
    }

    public static DateFieldBuilder dateField(final String caption) {
        return DateFieldBuilder.dateField(caption);
    }

    public static DateFieldBuilder dateField(final String caption, final LocalDate value) {
        return DateFieldBuilder.dateField(caption, value);
    }

    public static DateFieldBuilder dateField(final HasValue.ValueChangeListener<LocalDate> valueChangeListener) {
        return DateFieldBuilder.dateField(valueChangeListener);
    }

    public static DateFieldBuilder dateField(final String caption, final HasValue.ValueChangeListener<LocalDate>
            valueChangeListener) {
        return DateFieldBuilder.dateField(caption, valueChangeListener);
    }

    public static DateFieldBuilder dateField(String caption, LocalDate value,
                                             HasValue.ValueChangeListener<LocalDate> valueChangeListener) {
        return DateFieldBuilder.dateField(caption, value, valueChangeListener);
    }

    public static FormLayoutBuilder formLayout() {
        return FormLayoutBuilder.formLayout();
    }

    public static FormLayoutBuilder formLayout(final Component... components) {
        return FormLayoutBuilder.formLayout(components);
    }

    public static GridBuilder grid() {
        return GridBuilder.grid();
    }

    public static GridBuilder grid(String caption) {
        return GridBuilder.grid(caption);
    }

    public static GridBuilder grid(final String caption, final Collection<?> items) {
        return GridBuilder.grid(caption, items);
    }


    public static GridLayoutBuilder gridLayout(final int columns, final int rows, final Component... components) {
        return GridLayoutBuilder.gridLayout().gridLayout(columns, rows, components);
    }

    public static GridLayoutBuilder gridLayout(final int columns, final int rows) {
        return GridLayoutBuilder.gridLayout(columns, rows);
    }

    public static GridLayoutBuilder gridLayout() {
        return GridLayoutBuilder.gridLayout().gridLayout();
    }

    public static HorizontalLayoutBuilder horizontalLayout() {
        return HorizontalLayoutBuilder.horizontalLayout();
    }

    public static HorizontalLayoutBuilder horizontalLayout(final Component... components) {
        return HorizontalLayoutBuilder.horizontalLayout(components);
    }

    public static HorizontalSplitPanelBuilder horizontalSplitPanel() {
        return HorizontalSplitPanelBuilder.horizontalSplitPanel();
    }

    public static HorizontalSplitPanelBuilder horizontalSplitPanel(final Component firstComponent, final Component secondComponent) {
        return HorizontalSplitPanelBuilder.horizontalSplitPanel(firstComponent, secondComponent);
    }

    public static LabelBuilder label() {
        return LabelBuilder.label();
    }

    public static LabelBuilder label(final String caption) {
        return LabelBuilder.label(caption);
    }

    public static LabelBuilder label(final String caption, final ContentMode contentMode) {
        return LabelBuilder.label(caption, contentMode);
    }

    public static LinkBuilder link() {
        return LinkBuilder.link();
    }

    public static LinkBuilder link(final String caption, final Resource resource) {
        return LinkBuilder.link(caption, resource);
    }

    public static LinkBuilder link(String caption, Resource resource, String targetName, Integer width,
                                   Integer height, BorderStyle border) {
        return LinkBuilder.link(caption, resource, targetName, width, height, border);
    }

    public static ListSelectBuilder listSelect() {
        return ListSelectBuilder.listSelect();
    }

    public static ListSelectBuilder listSelect(String caption) {
        return ListSelectBuilder.listSelect(caption);
    }

    public static ListSelectBuilder listSelect(String caption, Collection<?> options) {
        return ListSelectBuilder.listSelect(caption, options);
    }

    public static MenuBarBuilder menuBar() {
        return MenuBarBuilder.menuBar();
    }

    public static ModalWindowBuilder modalWindow() {
        return ModalWindowBuilder.modalWindow();
    }

    public static ModalWindowBuilder modalWindow(final String caption) {
        return ModalWindowBuilder.modalWindow(caption);
    }

    public static ModalWindowBuilder modalWindow(final String caption, final Component component) {
        return ModalWindowBuilder.modalWindow(caption, component);
    }

    public static MultiUploadBuilder multiUpload(UploadFinishedHandler uploadFinishedHandler,
                                                 UploadStateWindow uploadStateWindow) {
        return MultiUploadBuilder.multiUpload(uploadFinishedHandler, uploadStateWindow);
    }

    public static MultiUploadBuilder multiUpload(UploadStartedHandler uploadStartedHandler,
                                                 UploadFinishedHandler uploadFinishedHandler,
                                                 UploadStateWindow uploadStateWindow, boolean multiple) {
        return MultiUploadBuilder.multiUpload(uploadStartedHandler, uploadFinishedHandler, uploadStateWindow, multiple);
    }

    public static MultiUploadBuilder multiUpload(UploadFinishedHandler uploadFinishedHandler,
                                                 UploadStateWindow uploadStateWindow, boolean multiple) {
        return MultiUploadBuilder.multiUpload(uploadFinishedHandler, uploadStateWindow, multiple);
    }

    public static NativeSelectBuilder nativeSelect() {
        return NativeSelectBuilder.nativeSelect();
    }

    public static NativeSelectBuilder nativeSelect(String caption) {
        return NativeSelectBuilder.nativeSelect(caption);
    }

    public static NativeSelectBuilder nativeSelect(String caption, Collection<?> items) {
        return NativeSelectBuilder.nativeSelect(caption, items);
    }

    public static PanelBuilder panel() {
        return PanelBuilder.panel();
    }

    public static PanelBuilder panel(final Component component) {
        return PanelBuilder.panel(component);
    }

    public static PanelBuilder panel(final String caption) {
        return PanelBuilder.panel(caption);
    }

    public static PanelBuilder panel(final String caption, final Component component) {
        return PanelBuilder.panel(caption, component);
    }

    public static PasswordFieldBuilder passwordField() {
        return PasswordFieldBuilder.passwordField();
    }

    public static PasswordFieldBuilder passwordField(final String caption) {
        return PasswordFieldBuilder.passwordField(caption);
    }

    public static PasswordFieldBuilder passwordField(final HasValue.ValueChangeListener<String> valueChangeListener) {
        return PasswordFieldBuilder.passwordField(valueChangeListener);
    }

    public static PasswordFieldBuilder passwordField(final String caption, final HasValue.ValueChangeListener<String>
            valueChangeListener) {
        return PasswordFieldBuilder.passwordField(caption, valueChangeListener);
    }

    public static PasswordFieldBuilder passwordField(final String caption, final String value) {
        return PasswordFieldBuilder.passwordField(caption, value);
    }

    public static PasswordFieldBuilder passwordField(final String caption, final String value,
                                                     HasValue.ValueChangeListener<String> valueChangeListener) {
        return PasswordFieldBuilder.passwordField(caption, value, valueChangeListener);
    }

    public static PopupButtonBuilder popupButton() {
        return PopupButtonBuilder.popupButton();
    }

    public static PopupButtonBuilder popupButton(final String caption) {
        return PopupButtonBuilder.popupButton(caption);
    }

    public static PopupViewBuilder popupView(PopupView.Content content) {
        return PopupViewBuilder.popupView(content);
    }

    public static PopupViewBuilder popupView(String small, Component large) {
        return PopupViewBuilder.popupView(small, large);
    }

    public static ProgressBarBuilder progressBar() {
        return ProgressBarBuilder.ProgressBar();
    }

    public static ProgressBarBuilder progressBar(float progress) {
        return ProgressBarBuilder.ProgressBar(progress);
    }

    public static RadioButtonGroupBuilder radioButtonGroup() {
        return RadioButtonGroupBuilder.radioButtonGroup();
    }

    public static RadioButtonGroupBuilder radioButtonGroup(String caption) {
        return RadioButtonGroupBuilder.radioButtonGroup(caption);
    }

    public static RadioButtonGroupBuilder radioButtonGroup(final String caption, final Collection<?> collection) {
        return RadioButtonGroupBuilder.radioButtonGroup(caption, collection);
    }

    public static RadioButtonGroupBuilder radioButtonGroup(final String caption, final DataProvider<?, ?> dataProvider) {
        return RadioButtonGroupBuilder.radioButtonGroup(caption, dataProvider);
    }

    public static SliderBuilder slider() {
        return SliderBuilder.Slider();
    }

    public static SliderBuilder slider(double min, double max, int resolution) {
        return SliderBuilder.Slider(min, max, resolution);
    }

    public static SliderBuilder slider(int min, int max) {
        return SliderBuilder.Slider(min, max);
    }

    public static SliderBuilder slider(String caption, int min, int max) {
        return SliderBuilder.Slider(caption, min, max);
    }

    public static SwitchButtonBuilder switchButton() {
        return SwitchButtonBuilder.switchButton();
    }

    public static SwitchButtonBuilder switchButton(String caption) {
        return SwitchButtonBuilder.switchButton(caption);
    }

    public static SwitchButtonBuilder switchButton(String caption, Boolean initialState) {
        return SwitchButtonBuilder.switchButton(caption, initialState);
    }

    public static TableBuilder table() {
        return TableBuilder.table();
    }

    public static TableBuilder table(final String caption) {
        return TableBuilder.table(caption);
    }

    public static TabSheetBuilder tabSheet() {
        return TabSheetBuilder.tabSheet();
    }

    public static TabSheetBuilder tabSheet(Component... components) {
        return TabSheetBuilder.tabSheet(components);
    }

    public static TextFieldBuilder textField() {
        return TextFieldBuilder.textField();
    }

    public static TextFieldBuilder textField(final String caption) {
        return TextFieldBuilder.textField(caption);
    }

    public static TextFieldBuilder textField(final HasValue.ValueChangeListener<String> valueChangeListener) {
        return TextFieldBuilder.textField(valueChangeListener);
    }

    public static TextFieldBuilder textField(final String caption, HasValue.ValueChangeListener<String>
            valueChangeListener) {
        return TextFieldBuilder.textField(caption, valueChangeListener);
    }

    public static TextFieldBuilder textField(final String caption, final String value) {
        return TextFieldBuilder.textField(caption, value);
    }

    public static TextFieldBuilder textField(final String caption, final String value,
                                             HasValue.ValueChangeListener<String> valueChangeListener) {
        return TextFieldBuilder.textField(caption, value, valueChangeListener);
    }

    public static TextAreaBuilder textArea() {
        return TextAreaBuilder.textArea();
    }

    public static TextAreaBuilder textArea(final String caption) {
        return TextAreaBuilder.textArea(caption);
    }

    public static TextAreaBuilder textArea(final HasValue.ValueChangeListener<String>
                                                   valueChangeListener) {
        return TextAreaBuilder.textArea(valueChangeListener);
    }

    public static TextAreaBuilder textArea(final String caption, final HasValue.ValueChangeListener<String>
            valueChangeListener) {
        return TextAreaBuilder.textArea(caption, valueChangeListener);
    }

    public static TextAreaBuilder textArea(final String caption, final String value) {
        return TextAreaBuilder.textArea(caption, value);
    }

    public static TextAreaBuilder textArea(final String caption, final String value,
                                           HasValue.ValueChangeListener<String> valueChangeListener) {
        return TextAreaBuilder.textArea(caption, value, valueChangeListener);
    }

    public static TreeBuilder tree() {
        return TreeBuilder.tree();
    }

    public static TreeBuilder tree(final String caption) {
        return TreeBuilder.tree(caption);
    }

    public static TreeTableBuilder treeTable() {
        return TreeTableBuilder.treeTable();
    }

    public static TreeTableBuilder treeTable(final String caption) {
        return TreeTableBuilder.treeTable(caption);
    }

    public static TwinColSelectBuilder twinColSelect() {
        return TwinColSelectBuilder.twinColSelect();
    }

    public static TwinColSelectBuilder twinColSelect(final String caption) {
        return TwinColSelectBuilder.twinColSelect(caption);
    }

    public static TwinColSelectBuilder twinColSelect(String caption, Collection<?> options) {
        return TwinColSelectBuilder.twinColSelect(caption, options);
    }

    public static SingleUploadBuilder upload() {
        return SingleUploadBuilder.upload();
    }

    public static SingleUploadBuilder upload(String caption, Upload.Receiver receiver) {
        return SingleUploadBuilder.upload(caption, receiver);
    }

    public static VerticalLayoutBuilder verticalLayout() {
        return VerticalLayoutBuilder.verticalLayout();
    }

    public static VerticalLayoutBuilder verticalLayout(final Component... components) {
        return VerticalLayoutBuilder.verticalLayout(components);
    }

    public static WizardBuilder wizard() {
        return WizardBuilder.wizard();
    }

    public static ConditionalWizardBuilder conditionalWizard() {
        return ConditionalWizardBuilder.conditionalWizard();
    }

    public static WizardStepBuilder wizardStep() {
        return WizardStepBuilder.wizardStep();
    }

    private ComponentFactory() {
    }
}