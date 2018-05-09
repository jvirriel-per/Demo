package com.jvirriel.demo.frontend.entitytype.model;

import com.jvirriel.demo.frontend.entitytype.service.EntityTypeService;
import com.jvirriel.demo.model.entitytype.EntityType;
import com.jvirriel.ui.model.TModel;

import java.util.List;

public class EntityTypeModel implements TModel<EntityType, Integer> {
    private EntityTypeService service = new EntityTypeService();

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

    @Override
    public EntityType findById(Integer id) {
        return service.findById(id).orElse(null);
    }

    @Override
    public List<EntityType> findAll(String search, String orderBy, String page, String size) {
        return service.findAll(search, orderBy, page, size).orElse(null);
    }

    @Override
    public EntityType save(EntityType entity) {
        return service.save(entity).orElse(null);
    }

    @Override
    public EntityType update(EntityType entity) {
        return service.update(entity).orElse(null);
    }
}