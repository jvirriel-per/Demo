package com.jvirriel.model;

import java.io.Serializable;

/**
 * Interfaz que permite abstraer la manipulacion de las entidades en las pruebas abstractas.
 * Todas las entidades que quieran ser usadas en pruebas abstractas deben implementar esta interfaz.
 * El getter del ID anotado con @ID debe sobreescribir el de esta interfaz, no debe tener otro nombre.
 * @param <ID> el tipo del ID de la entidad.
 */
public interface TestableEntity<ID extends Serializable> {
    ID getId();
    void setId(ID id);
}
