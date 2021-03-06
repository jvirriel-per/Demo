package com.jvirriel.demo.backend.entityStatus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvirriel.demo.backend.constants.BackEndConstants;
import com.jvirriel.demo.model.entitystatus.EntityStatus;
import com.pt.core.be.test.AbstractRestUnitTest;
import com.pt.demo.backend.entitystatus.EntityStatusJpaRepository;
import com.pt.demo.model.entitystatus.EntityStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.pt.demo.backend.constants.BackEndConstants.API;
import static com.pt.demo.backend.entitystatus.EntityStatusConstants.ENTITYSTATUS;
import static com.pt.util.property.PropertyUtil.getProperty;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * EntityStatusUnitTest.java
 *
 * Creado por ymontero
 * Fecha de creación: 20170607.
 *
 * Modificado por jgjimenez
 * Fecha de modificación: 20170802
 */
public class EntityStatusUnitTest extends AbstractRestUnitTest<EntityStatusJpaRepository, Integer, EntityStatus> {

    @Override
    public void initialize() {
        String base = BackEndConstants.API + ENTITYSTATUS;
        SAVE_URI = base + "/";
        FIND_URI = SAVE_URI;
        FINDALL_URI = base;
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

        notExistingId = 0;
        typeReference = new TypeReference<List<EntityStatus>>(){};
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