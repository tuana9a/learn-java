package com.tuana9a.spring.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Tyre {
    private String brand;

    @PostConstruct
    public void postConstruct() {
        System.out.println("construct " + this);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("destroy " + this);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
