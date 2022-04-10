package ru.hh.school.entity;

import javax.persistence.*;

@Entity
@Table(name = "salary")
public class SalaryEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Integer id;

    @Column(name = "salary_from")
    private Integer from;
    @Column(name = "salary_to")
    private Integer to;
    @Column(name = "currency")
    private String currency;
    @Column(name = "gross")
    private Boolean gross;

    public SalaryEntity() {
    }

    public SalaryEntity(Integer id, Integer from, Integer to, String currency, Boolean gross) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.currency = currency;
        this.gross = gross;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getGross() {
        return gross;
    }

    public void setGross(Boolean gross) {
        this.gross = gross;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
