package com.jvirriel.demo.backend.entitytype;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jvirriel.demo.backend.constants.BackEndConstants;
import com.jvirriel.demo.model.entitytype.EntityType;
import com.pt.core.be.test.AbstractRestUnitTest;
import com.pt.demo.model.entitytype.EntityType;
import org.junit.Test;

import java.util.List;

import static com.pt.demo.backend.constants.BackEndConstants.API;
import static com.pt.demo.backend.entitytype.EntityTypeConstants.ENTITYTYPE;

/**
 * Clase que aplica pruebas unitarias a EntityType en base a AbstractRestUnitTest.
 * Created by jgjimenez on 02/08/2017.
 */
public class EntityTypeUnitTest extends AbstractRestUnitTest<EntityTypeJpaRepository, Integer, EntityType> {

    @Override
    public void initialize() {
        String base = BackEndConstants.API + EntityTypeConstants.ENTITYTYPE;
        SAVE_URI = base + "/";
        FIND_URI = SAVE_URI;
        FINDALL_URI = base;
        UPDATE_URI = SAVE_URI;
        DELETE_URI = SAVE_URI;

        entityClass = EntityType.class;
        entity = new EntityType(
                "CodeTest",
                "EntityType test",
                456,
                "junitTest",
                "sample",
                "samples"
        );

        notExistingId = 0;
        typeReference = new TypeReference<List<EntityType>>(){};
    }

    @Override
    protected void changeEntity() {
        entity.setCode("newcode");
        entity.setEntityTypeOrder(123);
    }

    @Override
    protected boolean validateChange(EntityType responseEntity) {
        return entity.getCode().equals("newcode") && entity.getEntityTypeOrder().equals(123);
    }

    @Override
    @Test
    public void save() throws Exception {
        super.save();
    }

    @Override
    @Test
    public void successfulFindById() throws Exception {
        super.successfulFindById();
    }

    @Override
    @Test
    public void notSuccessfulFindById() throws Exception {
        super.notSuccessfulFindById();
    }

    @Override
    @Test
    public void findAll() throws Exception {
        super.findAll();
    }

    @Override
    @Test
    public void successfulUpdate() throws Exception {
        super.successfulUpdate();
    }

    @Override
    @Test
    public void notSuccessfulUpdate() throws Exception {
        super.notSuccessfulUpdate();
    }

    @Override
    @Test
    public void successfulDelete() throws Exception {
        super.successfulDelete();
    }

    @Override
    @Test
    public void notSuccessfulDelete() throws Exception {
        super.notSuccessfulDelete();
    }
}
