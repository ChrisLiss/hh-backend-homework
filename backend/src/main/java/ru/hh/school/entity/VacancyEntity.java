package ru.hh.school.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacancy")
public class VacancyEntity {

    @Id
    @Column(name = "vacancy_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="date_create", nullable = false, updatable = false)
    private LocalDate dateCreate;

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    private AreaEntity area;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id")
    private SalaryEntity salary;

    @Column(name = "created_at")
    private String createdAt;

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;

    @Column(name = "views_count")
    private Integer viewsCount;
    @Column(name = "comment")
    private String comment;

    public VacancyEntity() {
    }

    public VacancyEntity(Integer id, String name, AreaEntity area, SalaryEntity salary, String created_at, EmployerEntity employer, String comment) {
        this.id = id;
        this.name = name;
        this.dateCreate = LocalDate.now();
        this.area = area;
        this.salary = salary;
        this.createdAt = created_at;
        this.employer = employer;
        this.viewsCount = 0;
        this.comment = comment;
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

    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
    }

    public SalaryEntity getSalary() {
        return salary;
    }

    public void setSalary(SalaryEntity salary) {
        this.salary = salary;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public EmployerEntity getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerEntity employer) {
        this.employer = employer;
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
}
