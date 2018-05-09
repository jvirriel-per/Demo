package com.jvirriel.demo.model.entitytype;

import com.jvirriel.model.TestableEntity;

import javax.persistence.*;

@Entity
@Table(name = "ENTITYTYPE", /*catalog = "crudtest", */schema = "dbo")
public class EntityType implements TestableEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ET_ORDER")
    private Integer entityTypeOrder;

    @Column(name = "DEFAULTVALUE")
    private String defaultValue;

    @Column(name = "ENTITYCLASS")
    private String entityClass;

    @Column(name = "ENTITYSUBCLASS")
    private String entitySubClass;

    public EntityType() {
    }

    public EntityType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public EntityType(String code, String name, Integer entityTypeOrder, String defaultValue, String entityClass, String entitySubClass) {
        this.code = code;
        this.name = name;
        this.entityTypeOrder = entityTypeOrder;
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

    public Integer getEntityTypeOrder() {
        return entityTypeOrder;
    }

    public void setEntityTypeOrder(Integer entityTypeOrder) {
        this.entityTypeOrder = entityTypeOrder;
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
        return "EntityType{" +
                "id=" + id + ", " +
                "name=\"" + name + "\"," +
                "code=\"" + code + "\"" +
                "}";
    }
}
