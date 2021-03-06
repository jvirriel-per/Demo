package com.jvirriel.demo.model.demo;

public class Demo {
    private Long id;
    private String name;
    private String code;
    private String description;

    public Long getId() {
        return id;
    }

    public Demo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Demo setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Demo setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Demo setDescription(String description) {
        this.description = description;
        return this;
    }
}
