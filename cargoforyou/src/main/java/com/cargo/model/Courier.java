package com.cargo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Courier {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer validKgLow;
    private Integer validKgHigh;
    private Integer validDimensionsLow;
    private Integer validDimensionsHigh;






    public Courier(String name, Integer validKgLow, Integer validKgHigh, Integer validDimensionsLow, Integer validDimensionsHigh) {
        this.name = name;
        this.validKgLow = validKgLow;
        this.validKgHigh = validKgHigh;
        this.validDimensionsLow = validDimensionsLow;
        this.validDimensionsHigh = validDimensionsHigh;

    }

    public Courier() {
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

    public Integer getValidKgLow() {
        return validKgLow;
    }

    public void setValidKgLow(Integer validKgLow) {
        this.validKgLow = validKgLow;
    }

    public Integer getValidKgHigh() {
        return validKgHigh;
    }

    public void setValidKgHigh(Integer validKgHigh) {
        this.validKgHigh = validKgHigh;
    }

    public Integer getValidDimensionsLow() {
        return validDimensionsLow;
    }

    public void setValidDimensionsLow(Integer validDimensionsLow) {
        this.validDimensionsLow = validDimensionsLow;
    }

    public Integer getValidDimensionsHigh() {
        return validDimensionsHigh;
    }

    public void setValidDimensionsHigh(Integer validDimensionsHigh) {
        this.validDimensionsHigh = validDimensionsHigh;
    }
}
