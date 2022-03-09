package com.tuana9a.learn.java.oop;


public class Class2 extends Class1 {

    public Class2(String name) {
        super("");
        this.name = "Class2-" + name;
    }

    @Override
    public void sing() {
        System.out.println("Class2.sing()");
    }
}
