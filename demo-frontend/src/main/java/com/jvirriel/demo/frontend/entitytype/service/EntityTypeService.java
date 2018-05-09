package com.jvirriel.demo.frontend.entitytype.service;

import com.jvirriel.demo.model.entitytype.EntityType;
import com.jvirriel.ui.service.AbstractService;
import com.jvirriel.ui.service.TService;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.jvirriel.demo.frontend.entitytype.constants.EntityTypeServiceConstants.BASE_PATH;
import static com.jvirriel.demo.frontend.entitytype.constants.EntityTypeServiceConstants.BY_ID;
import static com.jvirriel.demo.frontend.entitytype.constants.EntityTypeServiceConstants.SAVE;

public class EntityTypeService extends AbstractService implements TService<EntityType, Integer> {

    @Override
    public void delete(Integer id) {
        try {
            restTemplate.exchange(requestStandard.deleteRequest(BY_ID + id), EntityType.class);
        } catch (Exception ignored) {
        }
    }

    @Override
    public Optional<List<EntityType>> findAll(String search, String orderBy, String page, String size) {
        List<EntityType> result = null;

        Map<String, String> header = buildHeader(search, orderBy, page, size);

        try {
            result = restTemplate.exchange(requestStandard.getRequest(BASE_PATH, header),
                    new ParameterizedTypeReference<List<EntityType>>() {
                    })
                    .getBody();
        } catch (Exception ignored) {
        }

        return Optional.ofNullable(result);
    }

    @Override
    public Optional<EntityType> findById(Integer id) {
        EntityType entityType = null;
        try {
            entityType = restTemplate.exchange(requestStandard.getRequest(BY_ID.concat(id.toString())),
                    EntityType.class).getBody();
        } catch (Exception ignored) {
        }

        return Optional.ofNullable(entityType);
    }

    @Override
    public Optional<EntityType> save(EntityType entityType) {
        EntityType result = null;

        try {
            result = restTemplate.exchange(requestStandard.postRequest(SAVE, entityType), EntityType.class)
                    .getBody();
        } catch (Exception ignored) {
        }

        return Optional.ofNullable(result);
    }

    @Override
    public Optional<EntityType> update(EntityType entityType) {
        EntityType result = null;

        try {
            result = restTemplate.exchange(requestStandard.putRequest(BY_ID + entityType.getId(), entityType),
                    EntityType.class).getBody();
        } catch (Exception ignored) {
        }

        return Optional.ofNullable(result);
    }
}