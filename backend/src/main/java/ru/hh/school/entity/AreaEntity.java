package ru.hh.school.entity;

import javax.persistence.*;

@Entity
@Table(name="Area")
public class AreaEntity {

    @Id
    @Column(name="area_id")
    private Integer id;

    @Column(name="name")
    private String name;

    public AreaEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public AreaEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
