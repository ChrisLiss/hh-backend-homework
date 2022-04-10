package ru.hh.school.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
public class EmployerDto {

    private Integer id;
    private String name;
    private String description;
    private String dateCreate;
    private AreaDto area;
    private String comment;
    private Popularity popularity;
    private Integer viewsCount;

    public EmployerDto() {
    }

    public EmployerDto(Integer id, String name, String description, LocalDate dateCreate, AreaDto area, String comment, Integer views_count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate.toString();
        this.area = area;
        this.comment = comment;
        this.viewsCount = views_count;
        if (views_count > 50) {
            this.popularity = Popularity.POPULAR;
        }
        else this.popularity = Popularity.REGULAR;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate.toString();
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }
}
