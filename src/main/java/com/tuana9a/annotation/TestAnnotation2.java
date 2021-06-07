package com.tuana9a.annotation;

@Builder
public class TestAnnotation2 {

    private String address;
    private TestAnnotation1 testAnnotation1;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTestAnnotation1(TestAnnotation1 testAnnotation1) {
        this.testAnnotation1 = testAnnotation1;
    }

    @Override
    public String toString() {
        return "TestAnnotation2{" +
                "address='" + address + '\'' +
                ", testAnnotation1=" + testAnnotation1 +
                '}';
    }
}
