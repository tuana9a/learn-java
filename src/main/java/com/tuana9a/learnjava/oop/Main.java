package com.tuana9a.learnjava.oop;

public class Main {
    public static void main(String[] args) {
        Class1 c1 = new Class1("tuan");
        Class1 c2 = c1;
        c1 = null;
//        c2 = null;
        System.out.println(c1);
        System.out.println(c2);
    }
}
