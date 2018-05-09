package com.jvirriel.demo.frontend.components.custom;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.vaadin.ui.*;
import com.vaadin.v7.data.util.BeanItemContainer;
import com.vaadin.v7.event.SelectionEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.v7.ui.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase base para construir componente TwinGrid (intercambio de elementos entre dos componentes Grid)
 *
 * @param <T> Recibe la entidad para armar el container de cada TwinGrid con la data proveniente del servicio.
 */
public class TwinsGrid<T> extends HorizontalLayout {

    private final Class<T> clazz;
    private Grid leftGrid;
    private Grid rightGrid;
    private String GRID_WIDTH = "390px";
    private Button delButton;
    private Button addButton;
    private VerticalLayout vlLeft;
    private VerticalLayout vlCenter;
    private VerticalLayout vlRight;
    private List<Object> leftEntityList;
    private List<Object> rightEntityList;
    private List<Object> leftItemsSelected;
    private List<Object> rightItemsSelected;
    private BeanItemContainer<T> leftBeanItemContainer;
    private BeanItemContainer<T> rightBeanItemContainer;

    /**
     * Constructor sin listas de objetos.
     * @param clazz
     */
    public TwinsGrid(Class<T> clazz) {
        this.clazz = clazz;
        TwinsInit();
        centerVerticalLayoutInit();
    }

    /**
     * Constructor con dos listas de objetos.
     * @param clazz
     * @param leftEntityList
     * @param rightEntityList
     */
    public TwinsGrid(Class<T> clazz, List<Object> leftEntityList, List<Object> rightEntityList) {
        this.clazz = clazz;
        TwinsInit();
        centerVerticalLayoutInit();
        setBothEntityList((List<T>)leftEntityList, (List<T>)rightEntityList);
    }

    /**
     * Constructor solo con la lista de objetos en la grid izquierda.
     * @param clazz
     * @param leftEntityList
     */
    public TwinsGrid(Class<T> clazz, List<Object> leftEntityList) {
        this.clazz = clazz;
        TwinsInit();
        centerVerticalLayoutInit();
        setLeftEntityList((List<T>) leftEntityList);
    }

    /**
     * Inicializa todos los componentes necesarios para el armado de las TwinsGrid en la vista.
     */
    private void TwinsInit() {
        setSpacing(true);
        TwinsGridInitObject();
    }

    /**
     * Instanciación de todos los componentes necesarios para construir las TwinGrid.
     */
    private void TwinsGridInitObject() {
        leftGrid = new Grid();
        rightGrid = new Grid();

        delButton = new Button();
        addButton = new Button();

        vlCenter = new VerticalLayout();
        vlRight = new VerticalLayout();
        vlLeft = new VerticalLayout();
    }

    /**
     * Armado del layout derecho con todas sus propiedades correspondientes para posteriormente agregarlo
     * a la vista con la botonera central.
     */
    private void centerVerticalLayoutInit() {
        addButton = new Button(FontAwesome.ANGLE_RIGHT);
        delButton = new Button(FontAwesome.ANGLE_LEFT);
        addButton.setEnabled(false);
        delButton.setEnabled(false);
        addButton.addClickListener((Button.ClickListener) event -> onAdd());
        delButton.addClickListener((Button.ClickListener) event -> onRemove());
        vlCenter.setSpacing(true);
        vlCenter.addComponents(new Label(" "), new Label(" "), addButton, delButton);
    }

    /**
     * Agrega los elementos seleccionados de la twinGrid izquierda en la TwinGrid derecha y actualiza
     * la data en las TwinsGrid.
     */
    private void onAdd() {
        if (leftGrid.getSelectedRows().size() > 0) {
            leftItemsSelected = new ArrayList<>();
            leftItemsSelected = (List<Object>) (leftGrid.getSelectedRows());
            for (Object obj : leftItemsSelected) {

                delLeftEntityByObject(obj);
                saveRightEntity(obj);
            }
            leftGridRefresh();
            rightGridRefresh();
        }
    }

    /**
     * Remueve los elementos seleccionados en la TwinsGrid derecha, los agrega de vuelta en la TwinGrid izquierda
     * y actualiza la data en las TwinsGrid.
     */
    private void onRemove() {
        if (rightGrid.getSelectedRows().size() > 0) {
            rightItemsSelected = new ArrayList<>();
            rightItemsSelected = (List<Object>) (rightGrid.getSelectedRows());

            for (Object obj : rightItemsSelected) {
                saveLeftEntity(obj);
                delRightEntityByObject(obj);
            }
            leftGridRefresh();
            rightGridRefresh();
        }
    }

    /**
     * Guarda los elementos seleccionados en la Grid izquierda.
     *
     * @param obj
     */
    public void saveLeftEntity(Object obj) {
        if (leftEntityList == null) leftEntityList = new ArrayList<Object>();
        leftEntityList.add(obj);
    }

    /**
     * Guarda los elementos seleccionados en la TwinGrid derecha.
     *
     * @param obj
     */
    public void saveRightEntity(Object obj) {
        if (rightEntityList == null) rightEntityList = new ArrayList<Object>();
        rightEntityList.add(obj);
    }

    /**
     * Elimina los elementos de la lista correspondientes a la TwinGrid izquierda.
     *
     * @param obj, objeto con los elementos.
     */
    public void delLeftEntityByObject(Object obj) {

        for (Iterator<Object> iterator = leftEntityList.iterator(); iterator.hasNext(); ) {
            Object entity = iterator.next();
            if (entity.equals(obj)) {
                iterator.remove();
            }
        }
    }

    /**
     * Elimina los elementos de la lista correspondientes a la TwinGrid derecha.
     *
     * @param obj, objeto con los elementos.
     */
    public void delRightEntityByObject(Object obj) {

        for (Iterator<Object> iterator = rightEntityList.iterator(); iterator.hasNext(); ) {
            Object entity = iterator.next();
            if (entity == obj) {
                iterator.remove();
            }
        }
    }

    /**
     * Captura la lista de la entidad para ambas TwinsGrid.
     * @param leftEntityList
     * @param rightEntityList
     */
    public void setBothEntityList(List<T> leftEntityList, List<T> rightEntityList) {
        this.leftEntityList = (List<Object>) leftEntityList;
        this.rightEntityList = (List<Object>) rightEntityList;
        TwinsConfig();
    }

    /**
     * Captura la lista de la entidad para la Grid Izquerda.
     * @param leftEntityList
     */
    public void setLeftEntityList(List<T> leftEntityList) {
        this.leftEntityList = (List<Object>) leftEntityList;
        TwinsConfig();
    }

    /**
     * Recibe cada uno de los elementos construidos por separado para posteriormente agregarlos a la vista
     * y construir las TwinsGrid.
     */
    private void TwinsConfig() {
        leftVerticalLayoutInit();
        rightVerticalLayoutInit();
        addComponents(vlLeft, vlCenter, vlRight);
    }

    /**
     * Armado del layout izquierdo con todas sus propiedades correspondientes para posteriormente agregarlo
     * a la vista con la TwinGrid izquierda.
     */
    private void leftVerticalLayoutInit() {
        leftGrid.setWidth(GRID_WIDTH);
        leftGrid.setResponsive(true);
        leftGrid.setCaption("Left Grid");
        leftGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        leftGridRefresh();
        leftGrid.addSelectionListener(selectionEvent -> onLeftItemSelected(selectionEvent));
        vlLeft.addComponents(leftGrid);
        vlLeft.setSpacing(true);
    }

    /**
     * Actualiza la data en el container de la TwinGrid izquierda.
     */
    private void leftGridRefresh() {
        leftBeanItemContainer = new BeanItemContainer<T>(getInterfaceClass());
        if (leftBeanItemContainer == null) return;
        if (leftGrid == null) return;

        leftBeanItemContainer.removeAllItems();
        leftBeanItemContainer.addAll((List<T>) leftEntityList);//mod
        leftGrid.setContainerDataSource(leftBeanItemContainer);
        leftGrid.setResponsive(true);
//        leftGrid.setImmediate(true);
    }

    /**
     * Elementos seleccionados en la TwinGrid izquierda.
     *
     * @param selectionEvent
     */
    private void onLeftItemSelected(SelectionEvent selectionEvent) {
        if (!(delButton == null)) {
            if (selectionEvent.getSelected().size() == 0) {
                addButton.setEnabled(false);
            }
            if (selectionEvent.getSelected().size() > 0) {
                addButton.setEnabled(true);
            }
        }
    }

    /**
     * Armado del layout derecho con todas sus propiedades correspondientes para posteriormente agregarlo
     * a la vista con la Grid derecha.
     */
    private void rightVerticalLayoutInit() {
        rightGrid.setWidth(GRID_WIDTH);
        rightGrid.setResponsive(true);
        rightGrid.setCaption("Right Grid");
        rightGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        rightGridRefresh();
        rightGrid.addSelectionListener(selectionEvent -> onRightItemSelected(selectionEvent));
        vlRight.addComponents(rightGrid);
        vlRight.setSpacing(true);
    }

    /**
     * Actualiza la data en el container de la TwinGrid derecha.
     */
    private void rightGridRefresh() {
        rightBeanItemContainer = new BeanItemContainer<T>(getInterfaceClass());
        if (rightGrid == null) return;
        if (rightEntityList == null) rightEntityList = new ArrayList<>();

        rightBeanItemContainer = new BeanItemContainer<T>(getInterfaceClass());
        rightBeanItemContainer.removeAllItems();
        rightBeanItemContainer.addAll((List<T>) rightEntityList);//mod
        rightGrid.setContainerDataSource(rightBeanItemContainer);
        rightGrid.setResponsive(true);
//        rightGrid.setImmediate(true);
    }

    /**
     * Elementos seleccionados en la TwinGrid derecha.
     *
     * @param selectionEvent
     */
    private void onRightItemSelected(SelectionEvent selectionEvent) {
        if (!(delButton == null)) {
            if (selectionEvent.getSelected().size() == 0) {
                delButton.setEnabled(false);
            }
            if (selectionEvent.getSelected().size() > 0) {
                delButton.setEnabled(true);
            }
        }
    }

    /**
     * Obtiene la entidad a usar para armar el container con la data correspondiente proveniente del
     * servicio.
     *
     * @return clazz, la entidad a usar en cada Grid.
     */
    public Class<T> getInterfaceClass() {
        return clazz;
    }
}
