
package com.tuana9a.learn.annotations;

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
