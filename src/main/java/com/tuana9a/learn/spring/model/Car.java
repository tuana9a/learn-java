package com.tuana9a.learn.spring.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car {
    private String name;
    private Tyre tyre;

    public Car() {

    }

    public Car(String name) {
        this.name = name;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("construct " + this);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("destroy " + this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", tyre=" + tyre +
                '}';
    }
}
