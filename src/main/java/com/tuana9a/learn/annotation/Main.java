
package com.tuana9a.learn.annotation;

import com.tuana9a.learnannotations.SimpleObjectBuilder;

public class Main {

    public static void main(String[] args) {
        SimpleObject simpleObject = new SimpleObjectBuilder()
                .name("Tuan")
                .age(20)
                .address("9A")
                .build();
        System.out.println(simpleObject);
    }
}
