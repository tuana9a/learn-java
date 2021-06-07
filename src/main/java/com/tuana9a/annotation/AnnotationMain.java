
package com.tuana9a.annotation;

public class AnnotationMain {

    public static void main(String[] args) {
        TestAnnotation1 class1 = new TestAnnotation1Builder().name("Tuan").age(20).build();
        System.out.println(class1);
        TestAnnotation2 class2 = new TestAnnotation2Builder().address("Cobi").testAnnotation1(class1).build();
        System.out.println(class2);
        //        TestAnnotation1 class1 = TestAnnotation1.builder().name("Tuan").age(20).build();
        //        System.out.println(class1);
        //        TestAnnotation2 class2 = TestAnnotation2.builder().address("Cobi").testAnnotation1(class1).build();
        //        System.out.println(class2);
    }
}
