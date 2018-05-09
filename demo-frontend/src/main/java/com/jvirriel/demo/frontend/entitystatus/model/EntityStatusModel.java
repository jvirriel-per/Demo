package com.jvirriel.demo.frontend.entitystatus.model;

import com.jvirriel.demo.frontend.entitystatus.service.EntityStatusService;
import com.jvirriel.demo.model.entitystatus.EntityStatus;
import com.jvirriel.ui.model.TModel;

import java.util.List;

/**
 * Clase model correspondiente a la funcionalidad EntityStatus. Debe implementar a TMoldel y asociarle la entidad
 * principal a implementar (de acuerdo al requerimiento) y el tipo de dato que tiene el Id de dicha entidad.
 */
public class EntityStatusModel implements TModel<EntityStatus, Integer> {
    private EntityStatusService service = new EntityStatusService();

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

    @Override
    public EntityStatus findById(Integer id) {
        return service.findById(id).orElse(null);
    }

    @Override
    public List<EntityStatus> findAll(String search, String orderBy, String page, String size) {
        return service.findAll(search, orderBy, page, size).orElse(null);
    }

    @Override
    public EntityStatus save(EntityStatus entity) {
        return service.save(entity).orElse(null);
    }

    @Override
    public EntityStatus update(EntityStatus entity) {
        return service.update(entity).orElse(null);
    }
}