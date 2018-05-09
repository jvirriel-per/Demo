package com.jvirriel.demo.model.entitystatus;

import com.jvirriel.model.TestableEntity;

import javax.persistence.*;


@Entity
@Table(name = "ENTITYSTATUS", /*catalog = "crudtest", */schema = "dbo")
public class EntityStatus implements TestableEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ET_ORDER")
    private Integer entityStatusOrder;

    @Column(name = "DEFAULTVALUE")
    private String defaultValue;

    @Column(name = "ENTITYCLASS")
    private String entityClass;

    @Column(name = "ENTITYSUBCLASS")
    private String entitySubClass;

    public EntityStatus() {
    }

    public EntityStatus(String name, String code) {
        this.code = code;
        this.name = name;
    }

    public EntityStatus(
            String name,
            String code,
            Integer entityStatusOrder,
            String defaultValue,
            String entityClass,
            String entitySubClass
    ) {
        this.code = code;
        this.name = name;
        this.entityStatusOrder = entityStatusOrder;
        this.defaultValue = defaultValue;
        this.entityClass = entityClass;
        this.entitySubClass = entitySubClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEntityStatusOrder() {
        return entityStatusOrder;
    }

    public void setEntityStatusOrder(Integer entityStatusOrder) {
        this.entityStatusOrder = entityStatusOrder;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    public String getEntitySubClass() {
        return entitySubClass;
    }

    public void setEntitySubClass(String entitySubClass) {
        this.entitySubClass = entitySubClass;
    }

    @Override
    public String toString() {
        return "EntityStatus{" +
                "id=" + id + ", " +
                "name=\"" + name + "\"," +
                "code=\"" + code + "\"" +
                "}";
    }
}
