package com.jvirriel.demo.frontend.components.custom.tagsfield;

import java.util.List;

import com.vaadin.ui.Component;

public interface TagsField extends Component {

    interface Tag extends Component {
        String getValue();
    }

    /**
     * Se agrega una nueva etiqueta al TagField.
     *
     * @param tag   nueva etiqueta a ser agregada
     */
    void addTag(Tag tag);

    /**
     * Se elimina una etiqueta del TagField.
     *
     * @param tag   etiqueta a ser eliminada
     */
    void removeTag(Tag tag);

    /**
     * Se asignan un nuevo conjunto de etiquetas al TagField.
     *
     * @param tags  Conjunto de etiquetas a agregar.
     */
    void setTags(List<Tag> tags);

    /**
     * Se obitnen las etiqeutas actuales del TagField.
     *
     * @return  Conjunto de etiquetas existentes en el TagField
     */
    List<Tag> getTags();
}
