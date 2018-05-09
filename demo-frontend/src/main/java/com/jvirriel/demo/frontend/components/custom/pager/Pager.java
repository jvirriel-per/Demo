package com.jvirriel.demo.frontend.components.custom.pager;

import com.jvirriel.demo.frontend.components.ComponentFactory;
import com.vaadin.data.HasValue;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.List;

import static com.vaadin.icons.VaadinIcons.*;
import static com.vaadin.server.Sizeable.Unit.PIXELS;
import static com.vaadin.ui.themes.ValoTheme.BUTTON_BORDERLESS;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.String.valueOf;

public class Pager extends GridLayout {
    private static final String FIRST_PAGE = "Primera página";
    private static final String PREVIOUS_PAGE = "Página anterior";
    private static final String NEXT_PAGE = "Página siguiente";
    private static final String LAST_PAGE = "Última página";
    private static final String SEPARATOR = "/";

    private final Button firstPageButton;
    private final Button previousPageButton;
    private final TextField currentPageField;
    private final Label totalPagesLabel;
    private final Button nextPageButton;
    private final Button lastPageButton;
    private final ComboBox<Integer> pageSizeComboBox;

    private Integer currentPage;
    private Integer totalPageAmount;
    private Integer pageSize;

    private Integer recordCounter;

    public Pager(Integer recordCounter) {
        this(5, Arrays.<Integer>asList(5, 10, 15, 20), recordCounter);
    }

    public Pager(Integer pageSize, List<Integer> pageSizes, Integer recordCounter) {
        super(16, 1);

        setCurrentPage(1);
        setRecordCounter(recordCounter);
        setPageSize(pageSize);

        if (getRecordCounter() % getPageSize() == 0) {
            setTotalPageAmount(getRecordCounter() / getPageSize());
        } else {
            setTotalPageAmount(getRecordCounter() / getPageSize() + 1);
        }

        firstPageButton = ComponentFactory
                .button()
                .setStyleName(BUTTON_BORDERLESS)
                .setIcon(FAST_BACKWARD, FIRST_PAGE)
                .get();

        previousPageButton = ComponentFactory
                .button()
                .setStyleName(BUTTON_BORDERLESS)
                .setIcon(BACKWARDS, PREVIOUS_PAGE)
                .get();

        currentPageField = ComponentFactory
                .textField()
                .setWidth(50.0f, PIXELS)
                .setValue(valueOf(1))
                .get();

        totalPagesLabel = ComponentFactory
                .label()
                .setValue(SEPARATOR + valueOf(getTotalPageAmount()))
                .setEnabled(TRUE)
                .get();

        nextPageButton = ComponentFactory
                .button()
                .setStyleName(BUTTON_BORDERLESS)
                .setIcon(FORWARD, NEXT_PAGE)
                .get();

        lastPageButton = ComponentFactory
                .button()
                .setStyleName(BUTTON_BORDERLESS)
                .setIcon(FAST_FORWARD, LAST_PAGE)
                .get();

        pageSizeComboBox = new ComboBox<>();
        pageSizeComboBox.setItems(pageSizes.stream());
        pageSizeComboBox.setSelectedItem(pageSize);
        pageSizeComboBox.setEmptySelectionAllowed(FALSE);

        Label recordCounterLabel = ComponentFactory
                .label()
                .setValue(valueOf(getRecordCounter()))
                .setEnabled(TRUE)
                .get();

        super.addComponent(firstPageButton, 0, 0);
        super.addComponent(previousPageButton, 1, 0);
        super.addComponent(currentPageField, 2, 0);
        super.addComponent(totalPagesLabel, 3, 0);
        super.addComponent(nextPageButton, 4, 0);
        super.addComponent(lastPageButton, 5, 0);
        super.addComponent(pageSizeComboBox, 6, 0);
        super.addComponent(new HorizontalLayout(), 7, 0, 14, 0);
        super.addComponent(recordCounterLabel, 15, 0);
    }

    public static <T> List<T> getSubList(List<T> list, Integer start, Integer end) {
        return list.subList(start, end);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecordCounter() {
        return recordCounter;
    }

    public void setRecordCounter(Integer recordCounter) {
        this.recordCounter = recordCounter;
    }

    public Integer getTotalPageAmount() {
        return totalPageAmount;
    }

    public void setTotalPageAmount(Integer totalPageAmount) {
        this.totalPageAmount = totalPageAmount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer gerRecordCounterToCurrentPageSizeRatio() {
        return this.recordCounter / this.pageSize;
    }

    public Integer getRecordCounterToCurrentPageSizeRemainder() {
        return this.recordCounter % this.pageSize;
    }

    public void setFirstPageListener(Button.ClickListener listiner) {
        this.firstPageButton.addClickListener(listiner);
    }

    public void setPreviousPageListener(Button.ClickListener listener) {
        this.previousPageButton.addClickListener(listener);
    }

    public void setEditCurrentPageListener(HasValue.ValueChangeListener<String> listener) {
        this.currentPageField.addValueChangeListener(listener);
    }

    public void setNextPageListener(Button.ClickListener listener) {
        this.nextPageButton.addClickListener(listener);
    }

    public void setLastPageListener(Button.ClickListener listener) {
        this.lastPageButton.addClickListener(listener);
    }

    public void setSelectPageSizeListener(HasValue.ValueChangeListener<Integer> listener) {
        this.pageSizeComboBox.addValueChangeListener(listener);
    }

    public void setCurrentPageLabel(Integer currentPage) {
        this.currentPageField.setValue(currentPage.toString());
    }

    public void setTotalPagesLabel(Integer totalPages) {
        this.totalPagesLabel.setValue(SEPARATOR + totalPages.toString());
    }

    public void setEnableForEachButton(Boolean enableFirst, Boolean enablePrevious, Boolean enableNext, Boolean enableLast) {
        this.firstPageButton.setEnabled(enableFirst);
        this.previousPageButton.setEnabled(enablePrevious);
        this.nextPageButton.setEnabled(enableNext);
        this.lastPageButton.setEnabled(enableLast);
    }
}