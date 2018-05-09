package com.jvirriel.demo.backend.entitytype;

import com.jvirriel.demo.backend.constants.BackEndConstants;
import com.jvirriel.demo.model.entitytype.EntityType;
import com.pt.core.be.test.AbstractRestFunctionalTest;
import com.pt.demo.model.entitytype.EntityType;
import org.junit.Test;

import static com.pt.demo.backend.constants.BackEndConstants.API;
import static com.pt.demo.backend.entitytype.EntityTypeConstants.ENTITYTYPE;

/**
 * Prueba funcional sobre entity type basada en AbstractRestFunctionalTest
 * Created by jgjimenez on 01/08/2017.
 */
public class EntityTypeFunctionalTest extends AbstractRestFunctionalTest<EntityTypeJpaRepository, Integer, EntityType> {
    @Override
    public void initialize() {
        String base = BackEndConstants.API + EntityTypeConstants.ENTITYTYPE;
        SAVE_URI = base + "/";
        FIND_URI = SAVE_URI;
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
    public void crudTest() throws Exception {
        super.crudTest();
    }
}
