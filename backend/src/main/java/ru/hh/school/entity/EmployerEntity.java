package ru.hh.school.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employer")
public class EmployerEntity {

    @Id
    @Column(name="employer_id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="date_create", nullable = false, updatable = false)
    private LocalDate dateCreate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id")
    private AreaEntity area;

    @Column(name="comment")
    private String comment;
    @Column(name="views_count")
    private Integer viewsCount;

    public EmployerEntity(Integer id, String name, String description, AreaEntity area, String comment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.comment = comment;
        this.dateCreate = LocalDate.now();
        this.viewsCount = 0;
        this.area = area;
    }

    public EmployerEntity() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public String getComment() {
        return comment;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
    }
}
