package ru.hh.school.dto;

public class SalaryDto {

    private Integer from;
    private Integer to;
    private String currency;
    private Boolean gross;

    public SalaryDto() {
    }

    public SalaryDto(Integer from, Integer to, String currency, Boolean gross) {
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


}
