package com.jvirriel.demo.backend.entityStatus;

import com.jvirriel.demo.backend.constants.BackEndConstants;
import com.jvirriel.demo.model.entitystatus.EntityStatus;
import com.pt.core.be.test.AbstractRestFunctionalTest;
import com.pt.demo.backend.entitystatus.EntityStatusJpaRepository;
import com.pt.demo.model.entitystatus.EntityStatus;
import org.junit.Test;

import static com.pt.demo.backend.constants.BackEndConstants.API;
import static com.pt.demo.backend.entitystatus.EntityStatusConstants.ENTITYSTATUS;

/**
 * Pruebas funcionales sobre EntityStatus basadas en AbstractRestFunctionalTest.
 * Created by jgjimenez on 02/08/2017.
 */
public class EntityStatusFunctionalTest extends AbstractRestFunctionalTest<EntityStatusJpaRepository, Integer, EntityStatus> {
    @Override
    public void initialize() {
        String base = BackEndConstants.API + ENTITYSTATUS;
        SAVE_URI = base + "/";
        FIND_URI = SAVE_URI;
        UPDATE_URI = SAVE_URI;
        DELETE_URI = SAVE_URI;

        entity = new EntityStatus();
        entity.setName("UnitTest");
        entity.setCode("123Test");
        entity.setEntityStatusOrder(2548);
        entity.setDefaultValue("test");
        entity.setEntityClass("sample");
        entity.setEntitySubClass("samples");

        entityClass = EntityStatus.class;
    }

    @Override
    protected void changeEntity() {
        entity.setCode("newcode");
        entity.setEntityStatusOrder(123);
    }

    @Override
    protected boolean validateChange(EntityStatus responseEntity) {
        return entity.getCode().equals("newcode") && entity.getEntityStatusOrder().equals(123);
    }

    @Override
    @Test
    public void crudTest() throws Exception {
        super.crudTest();
    }
}
