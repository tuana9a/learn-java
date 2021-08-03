package com.tuana9a.oop;

//class Class1 extends Abstract1{
public class Class1{

    protected String name;

    public Class1(String name) {
        this.name = "Class1-" + name;
    }

    public void sing() {
        System.out.println("Class1.sing()");
    }

    public String getName() {
        return name;
    }
}
