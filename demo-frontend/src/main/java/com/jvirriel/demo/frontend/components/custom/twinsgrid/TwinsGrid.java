package com.jvirriel.demo.frontend.components.custom.twinsgrid;

import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.*;

/**
 * Clase base para construir componente TwinGrid (intercambio de elementos entre dos componentes Grid)
 *
 * @param <T> Recibe la entidad para armar el container de cada TwinGrid con la data proveniente del servicio.
 */
public class TwinsGrid<T> extends HorizontalLayout {

    private final Class<T> clazz;
    private Grid<T> leftGrid;
    private Grid<T> rightGrid;
    private String GRID_WIDTH = "50%";
    private Button delButton;
    private Button addButton;
    private VerticalLayout vlLeft;
    private VerticalLayout vlCenter;
    private VerticalLayout vlRight;
    private List<Object> leftEntityList;
    private List<Object> rightEntityList;
    private Set<Object> leftItemsSelected;
    private Set<Object> rightItemsSelected;

    /**
     * Constructor sin listas de objetos.
     *
     * @param clazz
     */
    public TwinsGrid(Class<T> clazz) {
        this.clazz = clazz;
        TwinsInit();
        centerVerticalLayoutInit();
    }

    /**
     * Constructor con dos listas de objetos.
     *
     * @param clazz
     * @param leftEntityList
     * @param rightEntityList
     */
    public TwinsGrid(Class<T> clazz, List<Object> leftEntityList, List<Object> rightEntityList) {
        this.clazz = clazz;
        TwinsInit();
        centerVerticalLayoutInit();
        setBothEntityList((List<T>) leftEntityList, (List<T>) rightEntityList);
    }

    /**
     * Constructor solo con la lista de objetos en la grid izquierda.
     *
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
        super.setSpacing(false);
        super.setMargin(false);
        TwinsGridInitObject();
    }

    /**
     * Instanciación de todos los componentes necesarios para construir las TwinGrid.
     */
    private void TwinsGridInitObject() {
        leftGrid = new Grid<>();
        rightGrid = new Grid<>();

        delButton = new Button();
        addButton = new Button();

        vlCenter = new VerticalLayout();
        vlCenter.setMargin(new MarginInfo(true, false, false, false));
        vlRight = new VerticalLayout();
        vlRight.setMargin(new MarginInfo(true, false, false, false));
        vlLeft = new VerticalLayout();
        vlLeft.setMargin(new MarginInfo(true, false, false, false));
    }

    /**
     * Armado del layout derecho con todas sus propiedades correspondientes para posteriormente agregarlo
     * a la vista con la botonera central.
     */
    private void centerVerticalLayoutInit() {
        addButton = new Button(VaadinIcons.ANGLE_RIGHT);
        delButton = new Button(VaadinIcons.ANGLE_LEFT);
        addButton.setEnabled(false);
        delButton.setEnabled(false);
        addButton.addClickListener((Button.ClickListener) event -> onAdd());
        delButton.addClickListener((Button.ClickListener) event -> onRemove());
        vlCenter.setSpacing(false);
        vlCenter.addComponents(new Label(" "), new Label(" "), addButton, delButton);
    }

    /**
     * Agrega los elementos seleccionados de la twinGrid izquierda en la TwinGrid derecha y actualiza
     * la data en las TwinsGrid.
     */
    private void onAdd() {
        if (leftGrid.getSelectedItems().size() > 0) {
            leftItemsSelected = new HashSet<>();
            leftItemsSelected = (Set<Object>) (leftGrid.getSelectedItems());
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
        if (rightGrid.getSelectedItems().size() > 0) {
            rightItemsSelected = new HashSet<>();
            rightItemsSelected = (Set<Object>) (rightGrid.getSelectedItems());

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
        if (leftEntityList == null) leftEntityList = new ArrayList<>();
        leftEntityList.add(obj);
    }

    /**
     * Guarda los elementos seleccionados en la TwinGrid derecha.
     *
     * @param obj
     */
    public void saveRightEntity(Object obj) {
        if (rightEntityList == null) rightEntityList = new ArrayList<>();
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
     *
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
     *
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
        leftGrid.setResponsive(true);
        leftGrid.setCaption("Grid del Lado Izquierdo");
        leftGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        leftGridRefresh();
        leftGrid.addSelectionListener(event -> onLeftItemSelected(event));
        vlLeft.addComponents(leftGrid);
    }

    /**
     * Actualiza la data en el container de la TwinGrid izquierda.
     */
    private void leftGridRefresh() {
        if (leftGrid == null) return;
        if (leftEntityList == null) leftEntityList = new ArrayList<>();
        leftGrid.setItems((Collection<T>) leftEntityList);
        leftGrid.setResponsive(true);
    }

    /**
     * Elementos seleccionados en la TwinGrid izquierda.
     *
     * @param selectionEvent
     */
    private void onLeftItemSelected(SelectionEvent selectionEvent) {
        if (!(delButton == null)) {
            if (selectionEvent.getAllSelectedItems().size() == 0) {
                addButton.setEnabled(false);
            }
            if (selectionEvent.getAllSelectedItems().size() > 0) {
                addButton.setEnabled(true);
            }
        }
    }

    /**
     * Armado del layout derecho con todas sus propiedades correspondientes para posteriormente agregarlo
     * a la vista con la Grid derecha.
     */
    private void rightVerticalLayoutInit() {
        rightGrid.setResponsive(true);
        rightGrid.setCaption("Grid del Lado Derecho");
        rightGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        rightGridRefresh();
        rightGrid.addSelectionListener(selectionEvent -> onRightItemSelected(selectionEvent));
        vlRight.addComponents(rightGrid);
    }

    /**
     * Actualiza la data en el container de la TwinGrid derecha.
     */
    private void rightGridRefresh() {
        if (rightGrid == null) return;
        if (rightEntityList == null) rightEntityList = new ArrayList<>();
        rightGrid.setItems((Collection<T>) rightEntityList);
        rightGrid.setResponsive(true);
    }

    /**
     * Elementos seleccionados en la TwinGrid derecha.
     *
     * @param selectionEvent
     */
    private void onRightItemSelected(SelectionEvent selectionEvent) {
        if (!(delButton == null)) {
            if (selectionEvent.getAllSelectedItems().size() == 0) {
                delButton.setEnabled(false);
            }
            if (selectionEvent.getAllSelectedItems().size() > 0) {
                delButton.setEnabled(true);
            }
        }
    }

    public Grid<T> getLeftGrid() {
        return leftGrid;
    }

    public Grid<T> getRightGrid() {
        return rightGrid;
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

    public Button getDelButton() {
        return delButton;
    }

    public Button getAddButton() {
        return addButton;
    }
}