package com.tuana9a.learn.java.reflection;

public class ReflectionMain<T> {
    public static void main(String[] args) {
        ObjectAnalyze<Class1> m = new ObjectAnalyze<>(Class1.class);
        Class1 c = m.getObject();
        m.readObject(c);
    }
}
