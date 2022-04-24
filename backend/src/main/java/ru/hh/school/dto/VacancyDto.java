package ru.hh.school.dto;

import java.time.LocalDate;

public class VacancyDto {

    private Integer id;
    private String name;
    private AreaDto area;
    private SalaryDto salary;
    private String createdAt;
    private EmployerDto employer;
    private String dateCreate;
    private Popularity popularity;
    private Integer viewsCount;
    private String comment;

    public VacancyDto() {
    }

    public VacancyDto(Integer id, String name, AreaDto area, SalaryDto salary, String created_at, EmployerDto employer) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.salary = salary;
        this.createdAt = created_at;
        this.employer = employer;
    }

    public VacancyDto(Integer id, String name, AreaDto area, SalaryDto salary, String createdAt, EmployerDto employer,
                      LocalDate dateCreate, Integer viewsCount, String comment) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.salary = salary;
        this.createdAt = createdAt;
        this.employer = employer;
        this.dateCreate = dateCreate.toString();
        this.viewsCount = viewsCount;
        this.comment = comment;
        if (viewsCount > 50) {
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

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

    public SalaryDto getSalary() {
        return salary;
    }

    public void setSalary(SalaryDto salary) {
        this.salary = salary;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public EmployerDto getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerDto employer) {
        this.employer = employer;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate.toString();
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }
}
