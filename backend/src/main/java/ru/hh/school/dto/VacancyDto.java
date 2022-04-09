package ru.hh.school.dto;

import java.time.LocalDate;

public class VacancyDto {

    private Integer id;
    private String name;
    private AreaDto area;
    private SalaryDto salary;
    private String created_at;
    private EmployerDto employer;

    public VacancyDto() {
    }

    public VacancyDto(Integer id, String name, AreaDto area, SalaryDto salary, String created_at, EmployerDto employer) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.salary = salary;
        this.created_at = created_at;
        this.employer = employer;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public EmployerDto getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerDto employer) {
        this.employer = employer;
    }
}
