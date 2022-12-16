package com.cargo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Price {
    @Id
    @GeneratedValue
    private Long id;

    private String basedOn;
    private Integer lowerValue;
    private Integer higherValue;
    private Float cost;
    @ManyToOne
    private Courier couriers;

    public Price() {
    }

    public Price(String basedOn,  Integer lowerValue,  Integer higherValue, float cost,Courier couriers) {
        this.basedOn = basedOn;
        this.lowerValue = lowerValue;
        this.higherValue = higherValue;
        this.cost = cost;
        this.couriers=couriers;

    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Courier getCouriers() {
        return couriers;
    }

    public void setCouriers(Courier couriers) {
        this.couriers = couriers;
    }

    public String getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(String basedOn) {
        this.basedOn = basedOn;
    }

    public  Integer getLowerValue() {
        return lowerValue;
    }

    public void setLowerValue( Integer lowerValue) {
        this.lowerValue = lowerValue;
    }

    public  Integer getHigherValue() {
        return higherValue;
    }

    public void setHigherValue( Integer higherValue) {
        this.higherValue = higherValue;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
