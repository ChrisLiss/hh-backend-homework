package ru.hh.school.entity;


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

    @ManyToOne
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id")
    private AreaEntity area;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "salary_id")
    private SalaryEntity salary;

    @Column(name = "created_at")
    private String created_at;

    @ManyToOne
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;

    @Column(name = "views_count")
    private Integer viewsCount;
    @Column(name = "comment")
    private String comment;

    public VacancyEntity() {
    }

    public VacancyEntity(String name, AreaEntity area, SalaryEntity salary, String created_at, EmployerEntity employer, String comment) {
        this.name = name;
        this.dateCreate = LocalDate.now();
        this.area = area;
        this.salary = salary;
        this.created_at = created_at;
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

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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
