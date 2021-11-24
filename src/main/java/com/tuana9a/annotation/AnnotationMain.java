
package com.tuana9a.annotation;

public class AnnotationMain {

    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .name("Tuan")
                .age(20)
                .address("9A")
                .build();
        System.out.println(person);
    }
}
