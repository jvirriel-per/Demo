package com.jvirriel.ui.service;

import java.util.List;
import java.util.Optional;

/**
 * TService.java
 *
 * @param <T> Generics correspondiente a la clase de la entidad persistida con JPA
 * @param <ID> Generics correspondiente a la clase del tipo de id de la entidad.
 *            en principio, puede ser de tipo Integer o Long.
 */
public interface TService<T, ID> {
    /**
     * Borra una entidad dado su id.
     *
     * @param id Id de la entidad a ser eliminada.
     */
    void delete(ID id);

    /**
     * Obtiene todos los usuarios según uno o más criterios de búsqueda u ordenamiento (o ambos).
     *
     * @param search Expresión en RSQL para hacer consultas a través de servicios RESTful
     * @param orderBy Criterio de ordenamiento ascedente o descendente según uno o más atributos de la entidad.
     * @param page Número de página a devolver en una grid. Por defecto adquiere el valor de 1.
     * @param size Número de entidades recuperadas por cada página. Por defecto tiene el valor de 10.
     * @return Optional con una lista de los objetos recuperados.
     */
    default Optional<List<T>> findAll(String search, String orderBy, String page, String size) {
        return null;
    }

    /**
     * Obtiene un entidad específica según su id.
     *
     * @param id id de la entidad a ser recuperada, en caso de que la misma exista.
     * @return Optional con la entidad recuperada o un código de error según sea el caso.
     */
    Optional<T> findById(ID id);

    /**
     * Dada una entidad, inserta la misma en la base de datos.
     *
     * @param entity Entidad a ser insertada en la base de datos.
     * @return Optional con la entidad insertada.
     */
    Optional<T> save(T entity);

    /**
     * Dada una entidad, la actualiza en caso de ya existir en la base de datos.
     *
     * @param entity entidad a ser actualizada con los datos modificados.
     * @return Optional con la entidad actualizada
     */
    Optional<T> update(T entity);
}
