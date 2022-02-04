package com.tuana9a.learnannotations;

import com.tuana9a.annotations.Builder;

@Builder
public class SimpleObject {

    private String name;
    private int age;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
