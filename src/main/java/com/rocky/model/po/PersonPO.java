package com.rocky.model.po;

/**
 * Created by rocky on 16/9/2.
 */
public class PersonPO {
    private Long id;
    private String name;

    public PersonPO() {
    }

    public PersonPO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
