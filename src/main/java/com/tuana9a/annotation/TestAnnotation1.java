package com.tuana9a.annotation;

@Builder
public class TestAnnotation1 {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestAnnotation1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
