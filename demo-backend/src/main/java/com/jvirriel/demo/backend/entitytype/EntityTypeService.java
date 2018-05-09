package com.jvirriel.demo.backend.entitytype;

import com.jvirriel.demo.backend.configuration.BEService;
import com.jvirriel.demo.backend.configuration.CustomRsqlVisitor;
import com.jvirriel.demo.model.entitytype.EntityType;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.jvirriel.demo.backend.configuration.assessment.predicates.IntegerPredicates.isPositive;
import static com.jvirriel.demo.backend.configuration.assessment.predicates.StringPredicates.isNotEmpty;
import static com.jvirriel.demo.backend.constants.BackEndConstants.PAGE_NUMBER_POSITIVE;
import static com.pt.core.restapi.search.CriteriaOrderBy.getSortConditions;
import static java.lang.Integer.valueOf;

@Service
public class EntityTypeService implements BEService<EntityType, Integer> {

    private final EntityTypeJpaRepository repository;

    @Autowired
    public EntityTypeService(EntityTypeJpaRepository repository) {
        this.repository = repository;
    }

    /**
     * Eliminar un registro dado su id.
     *
     * @param id id de la entidad a ser eliminada
     */
    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    /**
     * Validar la existencia de un registro dado su id
     *
     * @param id id de la entidad que se va a verificar.
     * @return Boolean indicando si el registro existe o no.
     */
    @Override
    public Boolean exists(Integer id) {
        return repository.exists(id);
    }

    /**
     * Validar la existencia de un registro dada su entidad.
     *
     * @param entity, entidad a buscar
     * @return Boolean indicando si el registro existe o no.
     */
    public Boolean exists(EntityType entity) {
        Boolean result = Objects.nonNull(entity.getId());

        return !result ? result : repository.exists(entity.getId());
    }

    /**
     * @param search  Expresión en RSQL para hacer consultas a través de servicios RESTful
     * @param orderBy Criterio de ordenamiento ascedente o descendente según uno o más atributos de la entidad.
     * @param page    Número de página a devolver en una grid. Por defecto adquiere el valor de 1.
     * @param size    Número de entidades recuperadas por cada página. Por defecto tiene el valor de 10.
     * @return lista de registros del tipo de la entidad
     */
    @Override
    public List<EntityType> findAll(String search, String orderBy, String page, String size) {
        Specification<EntityType> specification = null;
        Sort sort = null;
        PageRequest pageRequest = null;

        List<EntityType> result;

        Boolean enableSearch = isNotEmpty().test(search), enableSort = isNotEmpty().test(orderBy),
                enablePaging = isNotEmpty().test(page) && isNotEmpty().test(size);

        if (enableSearch) {
            Node rootNode = new RSQLParser().parse(search);
            specification = rootNode.accept(new CustomRsqlVisitor<EntityType>());
        }

        if (enableSort) {
            sort = getSortConditions(orderBy);
        }

        if (enablePaging) {
            Integer pageValue = valueOf(page);
            Integer sizeValue = valueOf(size);

            checkArgument(isPositive().test(pageValue), PAGE_NUMBER_POSITIVE);
            checkArgument(isPositive().test(sizeValue), PAGE_NUMBER_POSITIVE);

            pageRequest = enableSort ? new PageRequest(--pageValue, sizeValue, sort)
                    : new PageRequest(--pageValue, sizeValue);
        }

        //TODO: Buscar generalizar esto para corregir la alerta de duplicado
        if (enableSearch && enableSort && enablePaging) {
            result = repository.findAll(specification, pageRequest).getContent();
        } else if (enableSearch && enableSort) {
            result = repository.findAll(specification, sort);
        } else if (enableSearch && enablePaging) {
            result = repository.findAll(specification, pageRequest).getContent();
        } else if (enableSearch) {
            result = repository.findAll(specification);
        } else if (enablePaging) {
            result = repository.findAll(pageRequest).getContent();
        } else if (enableSort) {
            result = repository.findAll(sort);
        } else {
            result = repository.findAll();
        }

        return result;
    }

    @Override
    public EntityType findById(Integer id) {
        return repository.findOne(id);
    }

    /**
     * Función para guardar (o actulizar) un EntityType.
     *
     * @param entity Entidad a ser insertada/actualizada en la base de datos.
     * @return registro guardado (o actualizado) de tipo EntityType
     */
    @Override
    public EntityType save(EntityType entity) {
        return (entity != null) ? repository.save(entity) : null;
    }

}