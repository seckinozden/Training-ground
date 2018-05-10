package com.seckin.bootexercises.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exercise {

    @Id
    Long id;
    String name;
    String description;

    public Exercise() {
    }

    public Exercise(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
