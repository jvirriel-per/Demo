package com.jvirriel.demo.backend.entitystatus;


import com.jvirriel.demo.backend.configuration.BEService;
import com.jvirriel.demo.model.entitystatus.EntityStatus;
import com.pt.core.restapi.restquery.CustomRsqlVisitor;
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
import static com.pt.core.restapi.search.CriteriaOrderBy.getSortConditions;
import static java.lang.Integer.valueOf;

@Service
public class EntityStatusService implements BEService<EntityStatus, Integer> {
    private EntityStatusJpaRepository repository;

    @Autowired
    public EntityStatusService(EntityStatusJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    public Boolean exists(EntityStatus entity) {
        Boolean result = Objects.nonNull(entity.getId());

        return !result ? result : repository.exists(entity.getId());
    }

    @Override
    public Boolean exists(Integer id) {
        return repository.exists(id);
    }

    @Override
    public List<EntityStatus> findAll(String search, String orderBy, String page, String size) {
        Specification<EntityStatus> specification = null;
        Sort sort = null;
        PageRequest pageRequest = null;

        List<EntityStatus> result;

        Boolean enableSearch = isNotEmpty().test(search),
                enableSort = isNotEmpty().test(orderBy),
                enablePaging = isNotEmpty().test(page) && isNotEmpty().test(size);

        if (enableSearch) {
            Node rootNode = new RSQLParser().parse(search);
            specification = rootNode.accept(new CustomRsqlVisitor<EntityStatus>());
        }

        if (enableSort) {
            sort = getSortConditions(orderBy);
        }

        if (enablePaging) {
            Integer pageValue = valueOf(page);
            Integer sizeValue = valueOf(size);

            checkArgument(isPositive().test(pageValue), "Número de página debe ser positivo");
            checkArgument(isPositive().test(sizeValue), "Número de página debe ser positivo");

            pageRequest = enableSort ? new PageRequest(--pageValue, sizeValue, sort) : new PageRequest(--pageValue,
                    sizeValue);
        }

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
    public EntityStatus findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public EntityStatus save(EntityStatus entity) {
        return (entity != null) ? repository.save(entity) : null;
    }
}