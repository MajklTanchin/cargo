package com.cargo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Packages {
    @Id
    @GeneratedValue
    private Long id;

    private Integer width;
    private Integer height;
    private Integer depth;
    private Integer weight;
    @ManyToOne
    private Courier  courier;

    public Packages(Integer width, Integer height, Integer depth, Integer weight, Courier courier) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.weight = weight;
        this.courier = courier;
    }

    public Packages() {

    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
