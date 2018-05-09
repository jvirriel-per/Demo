package com.jvirriel.ui.model;

import java.util.List;

/**
 * TModel.java
 *
 * Interface que bosqueja la estructura general del Service de una Back-End para
 * una entidad persistida con JPA, exhibiendo las operaciones CRUD básicas para
 * obtener todos los registros, obtener uno en particular, insertar/actualizar,
 * eliminar y consultar existencia.
 *
 * Creado por jrojas
 * Fecha de creación: 2017-06-09
 *
 * Modificado por jrojas
 * Fecha de modificación: 2017-06-09
 *
 * @param <T> Generics correspondiente a la clase de la entidad persistida con JPA
 * @param <ID> Generics correspondiente a la clase del tipo de id de la entidad.
 *            en principio, puede ser de tipo Integer o Long.
 */
public interface TModel<T, ID> {
    /**
     * Borra una entidad dado su id.
     *
     * @param id id de la entidad a ser eliminada
     */
    void delete(ID id);

    /**
     * Obtiene todos los usuarios según uno o más criterios de búsqueda u ordenamiento (o ambos).
     *
     * @param search Expresión en RSQL para hacer consultas a través de servicios RESTful
     * @param orderBy Criterio de ordenamiento ascedente o descendente según uno o más atributos de la entidad.
     * @param page Número de página a devolver en una grid. Por defecto adquiere el valor de 1.
     * @param size Número de entidades recuperadas por cada página. Por defecto tiene el valor de 10.
     * @return Una lista de los objetos recuperados.
     */
    default List<T> findAll(String search, String orderBy, String page, String size) {
        return null;
    }

    /**
     * Obtiene un entidad específica según su id.
     *
     * @param id id de la entidad a ser recuperada, en caso de que la misma exista.
     * @return Entidad recuperada de la base de datos.
     */
    T findById(ID id);

    /**
     * Dada una entidad, inserta la misma en la base de datos.
     *
     * @param entity Entidad a ser insertada en la base de datos.
     * @return Entidad insertada.
     */
    T save(T entity);

    /**
     * Dada una entidad, actualiza la misma en la base de datos.
     *
     * @param entity Entidad a ser actualizada en la base de datos.
     * @return Entidad actualizada.
     */
    T update(T entity);
}